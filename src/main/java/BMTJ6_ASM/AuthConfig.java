package BMTJ6_ASM;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import BMTJ6_ASM.service.UserService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;

    /* Mã hóa mật khẩu */ 
    @Bean
     BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	/*--QUẢN LÝ NGƯỜI DỮ LIỆU NGƯỜI SỬ DỤNG--*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	/*--PHÂN QUYỀN SỬ DỤNGVÀ HÌNH THỨC ĐĂNG NHẬP--*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF, CORS chia sẻ tài nguyên và truy cập từ bên ngoài bị vô hiệu hóa
		http.csrf().disable().cors().disable();
		// Phân quyền sử dụng
		http.authorizeRequests()
		.antMatchers("/","/trangchu","/auth/login/**","/user/forgot/**","/product/chitiet/{IDSP}").permitAll()/* cho phép */
		
		.antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
		.antMatchers("/order/checkout").authenticated()
		.anyRequest().authenticated();
//		
//		//điều khiển lỗi truy cập không đúng vai trò
		http.exceptionHandling().accessDeniedPage("/auth/access/denied");
		
		
//		// Giao diện đăng nhập
//		http.httpBasic(); (form mặt định)
		
		http.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginPage("/auth/login/form")
		.loginProcessingUrl("/auth/login")
		.defaultSuccessUrl("/trangchu",false)
		.failureUrl("/auth/login/error");
		
		
		http.rememberMe()
		.rememberMeParameter("remember");
		
		http.logout()
		.logoutUrl("/auth/logoff")
		.logoutSuccessUrl("/auth/logoff/success");
		
		
		// Đăng nhập từ mạng xã hội
		http.oauth2Login()
		.loginPage("/auth/login/form")
		.defaultSuccessUrl("/security2/login/sucess", true)
		.failureUrl("/auth/login/error")
		.authorizationEndpoint().baseUri("/oauth2/authorization");
	}
	
}
