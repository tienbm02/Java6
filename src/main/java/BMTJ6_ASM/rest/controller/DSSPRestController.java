package BMTJ6_ASM.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BMTJ6_ASM.entity.DSSP;
import BMTJ6_ASM.service.DSSPService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/DSSP")
public class DSSPRestController {
	@Autowired
	DSSPService dsspControllerService;

	@GetMapping("{IDSP}")
	public DSSP getOne(@PathVariable("IDSP") Integer IDSP) {
		return dsspControllerService.findById(IDSP);
	}
	
}
