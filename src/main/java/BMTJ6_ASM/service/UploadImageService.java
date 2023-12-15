package BMTJ6_ASM.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
	File save(MultipartFile file, String folder);
}
