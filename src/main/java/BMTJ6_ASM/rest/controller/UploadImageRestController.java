package BMTJ6_ASM.rest.controller;

import java.io.File;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import BMTJ6_ASM.service.UploadImageService;

@CrossOrigin("*")
@RestController
public class UploadImageRestController {
	@Autowired
	UploadImageService uploadSercice;
	
	@PostMapping("/rest/upload/{folder}")
	public JsonNode Upload(@PathParam("file") MultipartFile file, @PathVariable("folder") String folder) {
		File sevedFile = uploadSercice.save(file, folder);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", sevedFile.getName());
		node.put("size", sevedFile.length());
		return node;
	}
}
