package org.app.fitness_app.Helper;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.net.URI;

public class FileHelper {
    public static String getAbsolutePathImage(String fileName){
        String webappRoot = new FileSystemResource("").getFile().getAbsolutePath();

        return webappRoot + FileHelper.getRelativePathImage(fileName);
    }
    public static String getRelativePathImage(String fileName){
        String relativeFolder = File.separator + "resources" + File.separator + "images" + File.separator;
        return  relativeFolder + fileName;
    }
    public static String getImageUrl(String imageName) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resources/images/")
                .path(imageName)
                .build()
                .toUri();
        return uri.toString();
    }
}
