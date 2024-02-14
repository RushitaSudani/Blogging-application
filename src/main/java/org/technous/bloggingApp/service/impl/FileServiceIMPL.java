package org.technous.bloggingApp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.technous.bloggingApp.service.FileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceIMPL implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
    String name = file.getOriginalFilename();
    String randomId = UUID.randomUUID().toString();

    String filename1=randomId.concat(name.substring(name.lastIndexOf(".")));
    //full path
    String filepath=path+File.separator+filename1;

    File f= new File(path);
    if(!f.exists()){
        f.mkdir();
    }
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return name;
    }

    @Override
    public InputStream getResourse(String path, String filename) throws IOException {

        String fullpath=path+File.separator+filename;
        InputStream is=new FileInputStream(fullpath);
        return is;
    }
}
