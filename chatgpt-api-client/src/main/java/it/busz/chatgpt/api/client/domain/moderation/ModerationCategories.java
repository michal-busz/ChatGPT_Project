package it.busz.chatgpt.api.client.domain.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

record ModerationCategories(
        Boolean sexual,
        Boolean hate,
        Boolean harassment,
        @JsonProperty("self-harm")
        Boolean selfHarm,
        @JsonProperty("sexual/minors")
        Boolean sexualMinors,
        @JsonProperty("hate/threatening")
        Boolean hateThreatening,
        @JsonProperty("violence/graphic")
        Boolean violenceGraphic,
        @JsonProperty("self-harm/intent")
        Boolean selfHarmIntent,
        @JsonProperty("self-harm/instructions")
        Boolean selfHarmInstructions,
        @JsonProperty("harassment/threatening")
        Boolean harassmentThreatening,
        Boolean violence
) {
}
