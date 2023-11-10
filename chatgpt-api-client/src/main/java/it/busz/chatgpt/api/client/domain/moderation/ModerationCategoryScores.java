package it.busz.chatgpt.api.client.domain.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

record ModerationCategoryScores(
        Double sexual,
        Double hate,
        Double harassment,
        @JsonProperty("self-harm")
        Double selfHarm,
        @JsonProperty("sexual/minors")
        Double sexualMinors,
        @JsonProperty("hate/threatening")
        Double hateThreatening,
        @JsonProperty("violence/graphic")
        Double violenceGraphic,
        @JsonProperty("self-harm/intent")
        Double selfHarmIntent,
        @JsonProperty("self-harm/instructions")
        Double selfHarmInstructions,
        @JsonProperty("harassment/threatening")
        Double harassmentThreatening,
        Double violence
) {
}
