package com.shop.bookstore.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {


    public static Path save(MultipartFile file, String uploadDir) throws IOException {
        Path path = Paths.get(uploadDir);


        String fileExtention = FilenameUtils.getExtension(file.getOriginalFilename());
        String nameGenerated = UUID.randomUUID().toString().replace("-", "");


        nameGenerated += "." + fileExtention;

        try {
            InputStream inputStream = file.getInputStream();

            Path pathFile = path.resolve(nameGenerated.toLowerCase());


            Files.copy(inputStream, pathFile, StandardCopyOption.REPLACE_EXISTING);

            return pathFile;
        }
        catch (IOException e) {
            throw new IOException("can not save file: " + file.getOriginalFilename(), e);
        }
    }
}