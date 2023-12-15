package BMTJ6_ASM.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities")
public class Authority implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	@ManyToOne 
	@JoinColumn(name = "Username")
	TaiKhoan account;
	@ManyToOne  
	@JoinColumn(name = "Roleid")
	Role role;
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public TaiKhoan getAccount() {
		return account;
	}
	
	public void setAccount(TaiKhoan account) {
		this.account = account;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public Authority(Integer id, TaiKhoan account, Role role) {
		Id = id;
		this.account = account;
		this.role = role;
	}

	public Authority() {
		
	}
	
}
