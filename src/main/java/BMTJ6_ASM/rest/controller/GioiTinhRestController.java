package BMTJ6_ASM.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BMTJ6_ASM.entity.GioiTinh;
import BMTJ6_ASM.service.GioiTinhControllerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/gioitinh")
public class GioiTinhRestController {
	@Autowired
	GioiTinhControllerService GioiTinhService;

	@GetMapping()
	public List<GioiTinh> getAll() {
		return GioiTinhService.fillAll();
	}
	
}
