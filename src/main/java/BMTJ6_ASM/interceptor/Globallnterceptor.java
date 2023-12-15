package BMTJ6_ASM.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import BMTJ6_ASM.service.ThuongHieuService;

public class Globallnterceptor implements HandlerInterceptor {
	@Autowired
	ThuongHieuService thuongHieuService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", thuongHieuService.findAll()); //chuyển trang trong đây
	}
	
}
