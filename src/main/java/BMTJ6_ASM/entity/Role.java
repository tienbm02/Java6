package BMTJ6_ASM.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Roles")
public class Role implements Serializable{
	@Id
	String Id;
	String name;
 	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
 	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Role(String id, String name, List<Authority> authorities) {
		Id = id;
		this.name = name;
		this.authorities = authorities;
	}

	public Role() {
		
	}
 	
}
