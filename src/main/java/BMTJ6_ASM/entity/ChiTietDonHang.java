package BMTJ6_ASM.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietDonHang")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChiTietDonHang  implements Serializable{
	
	private static final long serialVersionUID = 5222891851676895634L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ID;
	//Integer IDDonHang;
	

	String TenSP;
	Double Gia;
	int SL;
	Double ThanhTien;
	String Hinh;
	
	@ManyToOne
	@JoinColumn(name = "IDSP", referencedColumnName = "IDSP")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JsonProperty("dssp")
	DSSP DSSP;

	//Integer IDSP; 
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IDDONHANG")
	DonHang DONHANG;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public Double getGia() {
		return Gia;
	}

	public void setGia(Double gia) {
		Gia = gia;
	}

	public int getSL() {
		return SL;
	}

	public void setSL(int sL) {
		SL = sL;
	}

	public Double getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		ThanhTien = thanhTien;
	}

	public String getHinh() {
		return Hinh;
	}

	public void setHinh(String hinh) {
		Hinh = hinh;
	}

	public DSSP getDSSP() {
		return DSSP;
	}

	public void setDSSP(DSSP dSSP) {
		DSSP = dSSP;
	}

	public DonHang getDONHANG() {
		return DONHANG;
	}

	public void setDONHANG(DonHang dONHANG) {
		DONHANG = dONHANG;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ChiTietDonHang(Integer iD, String tenSP, Double gia, int sL, Double thanhTien, String hinh,
			BMTJ6_ASM.entity.DSSP dSSP, DonHang dONHANG) {
		ID = iD;
		TenSP = tenSP;
		Gia = gia;
		SL = sL;
		ThanhTien = thanhTien;
		Hinh = hinh;
		DSSP = dSSP;
		DONHANG = dONHANG;
	}

	public ChiTietDonHang() {
		
	}
	
}
