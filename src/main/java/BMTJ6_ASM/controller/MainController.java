package BMTJ6_ASM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/trangchu")
	public String cuuhang() {
		return "index";
	}
	
}
