package BMTJ6_ASM.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import BMTJ6_ASM.entity.TaiKhoan;
import BMTJ6_ASM.dao.TaiKhoanDAO;
import BMTJ6_ASM.service.MailerService;
import BMTJ6_ASM.service.TaiKhoanService;

@Controller
public class AccountController {

	@Autowired
	TaiKhoanService TkhoanService;
	@Autowired
	TaiKhoanDAO dao;
	@Autowired
	MailerService mailer;
	String maXN;

	@RequestMapping("/user/forgot/form")
	public String quen(Model model) {
		model.addAttribute("checkTK", new TaiKhoan());
		return "quenmk";
	}

	@RequestMapping("/user/forgot/confirm")
	public String xacnhan() {
		return "maxacnhan";
	}

	@RequestMapping("/user/forgot/check")
	public String check(Model model,
			@Validated @ModelAttribute("checkTK") TaiKhoan tk, BindingResult result, Errors errors) {
		if (!errors.hasErrors()) {
			model.addAttribute("message", "Lỗi thông tin");
			//System.out.println(tk.getGmail());
			return "quenmk";
		}
		else {
			//System.out.println(username);	
			try {
				TaiKhoan account = dao.findById(tk.getUsername().trim()).get();
				//System.out.println(account.getGmail());
				if (account.getGmail().equals(tk.getGmail().trim())) {
					String code = RandomStringUtils.randomAlphabetic(6);
					maXN = code;
					mailer.sendEmail(account.getGmail(), "Ma xac nhan:", code);
				}
				else {
					model.addAttribute("messageE", "Email không chính xác");
					return "quenmk";
				}
			}
			catch (Exception e) {
				model.addAttribute("messageU", "Tên đăng nhập không tồn tại");
				return "quenmk";
			}
			return "redirect:/user/forgot/confirm";
		}
	}
	
	@RequestMapping("/user/forgot/code")
	public String code(Model model,@Param("codecfm") String codecfm) {
		if (codecfm.equals("")) {
			model.addAttribute("message", "Mã xác nhận đang trống");
			System.out.println(codecfm);
			return "maxacnhan";
		} else {
			System.out.println(codecfm);
			 	maXN = codecfm;
			return "redirect:/auth/login/form";
		}
	}

}
