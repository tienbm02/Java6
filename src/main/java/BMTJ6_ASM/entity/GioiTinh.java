package BMTJ6_ASM.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="GioiTinh")
public class GioiTinh {
	@Id
	Integer IDGT;
	String GioiTinh;
	@JsonIgnore
	@OneToMany(mappedBy = "gioitinh")
	List<DSSP> dsSP_theoGT;
	
	public Integer getIDGT() {
		return IDGT;
	}
	
	public void setIDGT(Integer iDGT) {
		IDGT = iDGT;
	}
	
	public String getGioiTinh() {
		return GioiTinh;
	}
	
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	public List<DSSP> getDsSP_theoGT() {
		return dsSP_theoGT;
	}
	
	public void setDsSP_theoGT(List<DSSP> dsSP_theoGT) {
		this.dsSP_theoGT = dsSP_theoGT;
	}

	public GioiTinh(Integer iDGT, String gioiTinh, List<DSSP> dsSP_theoGT) {
		IDGT = iDGT;
		GioiTinh = gioiTinh;
		this.dsSP_theoGT = dsSP_theoGT;
	}

	public GioiTinh() {
		
	}
	
}
