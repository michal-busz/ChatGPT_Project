package it.busz.chatgpt.api.client.domain.moderation;

import it.busz.chatgpt.api.client.domain.moderation.api.ModerationCategories;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationCategory;
import it.busz.chatgpt.api.client.domain.moderation.api.Moderation;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ModerationMapper {
    static Moderation mapToDto(it.busz.chatgpt.api.client.domain.moderation.Moderation moderation) {
        final var results = resultToDto(moderation.results());
        return new Moderation(
                moderation.id(),
                moderation.model(),
                results);

    }

    private static List<ModerationResult> resultToDto(List<it.busz.chatgpt.api.client.domain.moderation.ModerationResult> results) {
        return results.stream()
                .map(ModerationMapper::resultToDto)
                .toList();
    }

    private static ModerationResult resultToDto(it.busz.chatgpt.api.client.domain.moderation.ModerationResult result) {
        final var categories = categoriesToDto(result.categories(), result.categoryScores());
        return new ModerationResult(
                result.flagged(),
                categories
        );
    }

    private static ModerationCategories categoriesToDto(it.busz.chatgpt.api.client.domain.moderation.ModerationCategories categories,
                                                        ModerationCategoryScores scores) {
        return new ModerationCategories(
                categoryToDto(categories.sexual(), scores.sexual()),
                categoryToDto(categories.hate(), scores.hate()),
                categoryToDto(categories.harassment(), scores.harassment()),
                categoryToDto(categories.selfHarm(), scores.selfHarm()),
                categoryToDto(categories.sexualMinors(), scores.sexualMinors()),
                categoryToDto(categories.harassmentThreatening(), scores.hateThreatening()),
                categoryToDto(categories.violenceGraphic(), scores.violenceGraphic()),
                categoryToDto(categories.selfHarmIntent(), scores.selfHarmIntent()),
                categoryToDto(categories.selfHarmInstructions(), scores.selfHarmInstructions()),
                categoryToDto(categories.harassmentThreatening(), scores.harassmentThreatening()),
                categoryToDto(categories.violence(), scores.violence())
        );
    }

    private static ModerationCategory categoryToDto(Boolean flagged, Double score) {
        return new ModerationCategory(
                flagged,
                score
        );
    }
}
