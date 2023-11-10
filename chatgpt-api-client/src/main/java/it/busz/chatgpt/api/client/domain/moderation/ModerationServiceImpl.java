package it.busz.chatgpt.api.client.domain.moderation;

import it.busz.chatgpt.api.client.domain.moderation.api.Moderation;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class ModerationServiceImpl implements ModerationService {
    private final ModerationClient moderationClient;

    ModerationServiceImpl(ModerationClient moderationClient) {
        this.moderationClient = moderationClient;
    }

    @Override
    public Moderation createModeration(ModerationRequest request) {
        final var moderation = moderationClient.createModeration(request);
        return ModerationMapper.mapToDto(moderation);
    }
}
