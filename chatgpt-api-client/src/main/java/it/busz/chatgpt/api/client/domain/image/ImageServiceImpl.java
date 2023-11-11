package it.busz.chatgpt.api.client.domain.image;

import it.busz.chatgpt.api.client.domain.image.api.Image;
import it.busz.chatgpt.api.client.domain.image.api.ImageCreateRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageEditRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageVariationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class ImageServiceImpl implements ImageService {
    private final ImageClient imageClient;

    ImageServiceImpl(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    @Override
    public List<Image> create(ImageCreateRequest request) {
        return imageClient.create(request);
    }

    @Override
    public List<Image> edit(ImageEditRequest request) {
        return imageClient.edit(request);
    }

    @Override
    public List<Image> variation(ImageVariationRequest request) {
        return imageClient.variation(request);
    }
}
