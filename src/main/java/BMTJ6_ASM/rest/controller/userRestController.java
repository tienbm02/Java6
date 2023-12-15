package BMTJ6_ASM.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/user")
public class userRestController {
	@RequestMapping("/user/tt")
	public String tt() {
		return "redirect:/assets/user/index.html";
	}
}
