package BMTJ6_ASM.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import BMTJ6_ASM.service.UploadImageService;

@Service
public class UploadImageServiceImpl implements UploadImageService {
	@Autowired
	ServletContext app;

	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/image/" + folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
			System.err.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
