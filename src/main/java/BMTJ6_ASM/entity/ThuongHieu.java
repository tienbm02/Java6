package BMTJ6_ASM.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ThuongHieu")
public class ThuongHieu {
	@Id
	Integer IDTH;
	String ThuongHieu;
	
	@JsonIgnore
	@OneToMany(mappedBy = "thuonghieu", fetch = FetchType.LAZY)
	List<DSSP> DSSP;

	public Integer getIDTH() {
		return IDTH;
	}

	public void setIDTH(Integer iDTH) {
		IDTH = iDTH;
	}

	public String getThuongHieu() {
		return ThuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		ThuongHieu = thuongHieu;
	}

	public List<DSSP> getDSSP() {
		return DSSP;
	}

	public void setDSSP(List<DSSP> dSSP) {
		DSSP = dSSP;
	}

	public ThuongHieu(Integer iDTH, String thuongHieu, List<BMTJ6_ASM.entity.DSSP> dSSP) {
		IDTH = iDTH;
		ThuongHieu = thuongHieu;
		DSSP = dSSP;
	}

	public ThuongHieu() {
		
	}
	
}