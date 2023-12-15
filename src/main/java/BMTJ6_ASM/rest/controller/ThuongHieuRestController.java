package BMTJ6_ASM.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BMTJ6_ASM.entity.ThuongHieu;
import BMTJ6_ASM.service.ThuongHieuService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/thuonghieu")
public class ThuongHieuRestController {
	@Autowired
	ThuongHieuService ThuongHieuService;
	
	@GetMapping()
	public List<ThuongHieu> getAll() {
		return ThuongHieuService.findAll();
	}
	
}
