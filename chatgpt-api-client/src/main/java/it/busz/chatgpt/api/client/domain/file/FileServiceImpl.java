package it.busz.chatgpt.api.client.domain.file;

import it.busz.chatgpt.api.client.domain.file.api.GptFile;
import it.busz.chatgpt.api.client.domain.file.api.GptFileUploadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class FileServiceImpl implements FileService{
    private final FileClient fileClient;

    FileServiceImpl(FileClient fileClient) {
        this.fileClient = fileClient;
    }

    @Override
    public List<GptFile> listFiles(){
        return fileClient.listFiles();
    }

    @Override
    public  GptFile upload(final GptFileUploadRequest request){
        return fileClient.upload(request);
    }

    @Override
    public void delete(final String fileId){
        fileClient.delete(fileId);
        log.info("Successfully deleted file {}", fileId);
    }

    @Override
    public GptFile retrieve(final String fileId){
        return fileClient.retrieve(fileId);
    }

    @Override
    public String getJsonContent(final String fileId){
        return fileClient.getJsonContent(fileId);
    }
}
