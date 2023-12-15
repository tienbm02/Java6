package BMTJ6_ASM.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.TaiKhoan;
import BMTJ6_ASM.dao.TaiKhoanDAO;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	BCryptPasswordEncoder pe;
	@Autowired
	TaiKhoanDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			TaiKhoan account = dao.findById(username).get();
			String password = account.getPassword();
			String[] roles = account.getAuthorities().stream().map(au -> au.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
//			System.err.println(account.getUsername());
//			System.err.println(account.getPassword());
//			System.err.println(roles.toString());
			return User.withUsername(username).password(pe.encode(password)).roles(roles).build();
		} catch (Exception e) {
			System.err.println(e);
			throw new UsernameNotFoundException(username + "loi");
		}
	}

	// Đăng nhập từ mạng xã hội
	public void loginFromOAuth2(OAuth2AuthenticationToken oAuth2) {
		String name = oAuth2.getPrincipal().getAttribute("name");
		String id = oAuth2.getPrincipal().getAttribute("id");
		System.out.print("ID:" + id);
		String password = Long.toHexString(System.currentTimeMillis());
		UserDetails user = User.withUsername(name).password(pe.encode(password)).roles("USER").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		try {
			TaiKhoan account = dao.findById(id).get();
		} 
		catch (Exception e) {
			
		}
	}

}
