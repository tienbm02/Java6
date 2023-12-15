package BMTJ6_ASM.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import BMTJ6_ASM.entity.DSSP;
import BMTJ6_ASM.service.DSSPService;
import BMTJ6_ASM.service.OrderService;


@Controller
public class ProductController {

	@Autowired
	DSSPService dsspControllerService;
	
	@Autowired
	OrderService orderService;

	@RequestMapping("/product/cuahang")//sửa đường truyền
	public String cuuhang(Model model) {
		List<DSSP>list = dsspControllerService.findAll();
		model.addAttribute("items",list);
		return "/product/cuahang";
	}

	@RequestMapping("/product/chitiet/{IDSP}")
	public String detail(Model model, @PathVariable("IDSP") Integer IDSP) {
		DSSP item  = dsspControllerService.findById(IDSP);
		model.addAttribute("item",item);
		
		return "/product/chitiet";
	}
	
	@RequestMapping("/cart/Giohang")
	public String giohang(Model model) {
		return "/cart/Giohang";
	}
	
	
	@RequestMapping("/order/checkout")//đặt hàng
	public String checkout() {
		return "/order/checkout";
	}
	
	@RequestMapping("/order/list")//đặt hàng
	public String list() {
		return "/order/list";
	}
	
//	@RequestMapping("/order/views")
//	public String list(Model model, HttpServletRequest request) {
//		String username = request.getRemoteUser();
//		model.addAttribute("orders",orderService.findByUsername(username));
//		return "order/list";
//	}
	
	@RequestMapping("/order/detail/{IDDonHang}")//đặt hàng
	public String detail(@PathVariable("IDDonHang") Integer IDDonHang, Model model) {
		model.addAttribute("donHang", orderService.findById(IDDonHang));
		return "order/detail";
	}
	
}
