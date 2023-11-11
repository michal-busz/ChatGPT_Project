package it.busz.chatgpt.api.client.domain.image;

import it.busz.chatgpt.api.client.domain.image.api.Image;

import java.time.Instant;
import java.util.List;

record ImageResponse(
        Instant created,
        List<Image> data
) {
}
