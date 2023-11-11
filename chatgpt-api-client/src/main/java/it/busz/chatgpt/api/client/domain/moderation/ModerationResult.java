package it.busz.chatgpt.api.client.domain.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

record ModerationResult(
        Boolean flagged,
        ModerationCategories categories,
        @JsonProperty("category_scores")
        ModerationCategoryScores categoryScores
) {
}
