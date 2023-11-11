package it.busz.chatgpt.api.client.domain.image;

import it.busz.chatgpt.api.client.domain.image.api.Image;
import it.busz.chatgpt.api.client.domain.image.api.ImageCreateRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageEditRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageVariationRequest;

import java.util.List;

public interface ImageService {
    List<Image> create(ImageCreateRequest request);
    List<Image> edit(ImageEditRequest request);
    List<Image> variation(ImageVariationRequest request);
}
