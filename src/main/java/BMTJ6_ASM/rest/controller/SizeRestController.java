package BMTJ6_ASM.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BMTJ6_ASM.entity.Size;
import BMTJ6_ASM.service.SizeControllerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/size")
public class SizeRestController {
	@Autowired
	SizeControllerService sizeService;
	
	@GetMapping()
	public List<Size> getAll(){
		return sizeService.fillAll();
	}
}
