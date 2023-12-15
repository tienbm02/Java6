package BMTJ6_ASM.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BMTJ6_ASM.entity.DSSP;
import BMTJ6_ASM.service.DSSPService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class productRestController {
	@Autowired
	DSSPService dsspservice;
	
	@GetMapping()
	public List<DSSP> getAll() {
		return dsspservice.findAll();
	}
	
	@GetMapping("{id}")
	public DSSP getOne(@PathVariable("id") Integer id) {
		return dsspservice.findById(id);
	}
	
	@PostMapping()
	public DSSP create(@RequestBody DSSP sanpham) {
		return dsspservice.create(sanpham);
	}
	
	@PutMapping("{id}")
	public DSSP update(@PathVariable("id") Integer id, @RequestBody DSSP sanpham) {
		return dsspservice.update(sanpham);
	} 
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 dsspservice.delete(id);
	} 
	
}
