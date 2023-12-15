package BMTJ6_ASM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping({"/admin", "/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
	
	@RequestMapping("/user/tt")
	public String tt() {
		return "redirect:/assets/user/index.html";
	}
	
}
