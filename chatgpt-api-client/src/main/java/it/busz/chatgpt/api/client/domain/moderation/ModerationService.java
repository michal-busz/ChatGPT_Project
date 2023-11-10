package it.busz.chatgpt.api.client.domain.moderation;

import it.busz.chatgpt.api.client.domain.moderation.api.Moderation;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationRequest;

public interface ModerationService {
    Moderation createModeration(ModerationRequest moderationRequest);
}
