package com.lespierresfolles.api.services.images;

import com.lespierresfolles.api.models.Megalith;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.text.Normalizer;

@Component
public class ImageManager {

    private final Path rootDir = Paths.get("uploads");

    public String storeImage(Megalith megalith, MultipartFile file, int index) throws IOException {
        if (index < 1 || index > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5.");
        }

        String departmentSlug = slugify(String.valueOf(megalith.getDepartment()));
        String nameSlug = slugify(megalith.getName());

        Path targetDir = rootDir.resolve(departmentSlug).resolve(nameSlug);
        Files.createDirectories(targetDir);

        String ext = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String filename = "image" + index + "." + ext;

        Path targetPath = targetDir.resolve(filename);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + departmentSlug + "/" + nameSlug + "/" + filename;
    }

    public String slugify(String input) {
        if (input == null) return "";
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");
    }

    public String deslugify(String slug) {
        if (slug == null) return "";
        return slug.replace("-", " ");
    }
}
