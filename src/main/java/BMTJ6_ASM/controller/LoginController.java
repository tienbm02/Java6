package BMTJ6_ASM.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import BMTJ6_ASM.entity.TaiKhoan;
import BMTJ6_ASM.service.TaiKhoanService;
import BMTJ6_ASM.service.UserService;

@Controller
public class LoginController {

	@Autowired
	TaiKhoanService TkhoanService;

	@RequestMapping("/auth/login/form")
	public String formLogin() {
		return "dangnhap";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model m) {
		m.addAttribute("message", "Đăng nhập thành công");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/login/error")
	public String error(Model m) {
		m.addAttribute("message", "Sai thông tin đăng nhập");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/logoff/success")
	public String logoff(Model m) {
		System.err.println();
		m.addAttribute("message", "Đăng xuât thành công");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model m) {
		m.addAttribute("message", "bạn không có quyền truy cập");
		return "dangnhap";
	}

	// Đăng nhập từ mạng xã hội
	@Autowired
	UserService userService;

	@RequestMapping("/security2/login/sucess")
	public String sucess(OAuth2AuthenticationToken oAuth2) {
		userService.loginFromOAuth2(oAuth2);
		return "redirect:/trangchu";
	}

	@RequestMapping("/auth/SinUp/form")
	public String create(Model model) {
		model.addAttribute("createSinUp", new TaiKhoan());
		return "dangky";
	}

	@GetMapping("/auth/SinUp/errors")
	public String errors(Model model) {
		model.addAttribute("createSinUp", new TaiKhoan());
		return "dangky";
	}

	@RequestMapping("/auth/SinUp/saveORudate")
	public String saveORudate(Model model, @Param("pw2") String pw2,
			@Validated @ModelAttribute("createSinUp") TaiKhoan tk, BindingResult result, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Lỗi thông tin");
			return "dangky";
		}
		else {
			if (!tk.getPassword().equals(pw2)) {
				model.addAttribute("messagePW", "Mật khẩu không trùng khớp");
				System.out.print(pw2);
				return "dangky";
			}
			else {
				TaiKhoan entity = new TaiKhoan();
				BeanUtils.copyProperties(tk, entity);
				TkhoanService.save(entity);
				model.addAttribute("message", "Thêm thành công");
				// System.out.println(""+entity.getUsername());
				// System.out.println(""+entity.getPassword());
				return "redirect:/auth/login/form";
			}
		}
	}
	
}
