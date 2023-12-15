package BMTJ6_ASM.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	@Id
	@NotEmpty(message = "Không được để trống")
	String Username;
	@NotEmpty(message = "Không được để trống")
	String Password;
	Boolean Admin = false;
	String Hovaten = null;
	String SDT = null;
	@NotEmpty(message = "Không được để trống")
	@Email(message = "Không đúng định dạng")
	String gmail;
	String Diachi = null;
	String hinh = null;
	@JsonIgnore
	@OneToMany(mappedBy = "Username")
	List<DonHang> dsDH;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
	List<Authority> authorities;
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public Boolean getAdmin() {
		return Admin;
	}
	
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	
	public String getHovaten() {
		return Hovaten;
	}
	
	public void setHovaten(String hovaten) {
		Hovaten = hovaten;
	}
	
	public String getSDT() {
		return SDT;
	}
	
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	public String getGmail() {
		return gmail;
	}
	
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	public String getDiachi() {
		return Diachi;
	}
	
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	
	public String getHinh() {
		return hinh;
	}
	
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	
	public List<DonHang> getDsDH() {
		return dsDH;
	}
	
	public void setDsDH(List<DonHang> dsDH) {
		this.dsDH = dsDH;
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public TaiKhoan(@NotEmpty(message = "Không được để trống") String username,
			@NotEmpty(message = "Không được để trống") String password, Boolean admin, String hovaten, String sDT,
			@NotEmpty(message = "Không được để trống") @Email(message = "Không đúng định dạng") String gmail,
			String diachi, String hinh, List<DonHang> dsDH, List<Authority> authorities) {
		Username = username;
		Password = password;
		Admin = admin;
		Hovaten = hovaten;
		SDT = sDT;
		this.gmail = gmail;
		Diachi = diachi;
		this.hinh = hinh;
		this.dsDH = dsDH;
		this.authorities = authorities;
	}

	public TaiKhoan() {
		
	}
	
}
