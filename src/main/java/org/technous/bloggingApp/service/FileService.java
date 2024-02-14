package org.technous.bloggingApp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    String uploadImage(String path, MultipartFile file)throws IOException;
    InputStream getResourse(String path,String filename)throws IOException;
}
