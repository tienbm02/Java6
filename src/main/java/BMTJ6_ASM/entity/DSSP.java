package BMTJ6_ASM.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DSSP")
public class DSSP {
	@Id
	Integer IDSP;
	String TenSP;
//	Integer IDthuongHieu;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IDthuongHieu")
	ThuongHieu thuonghieu;

//	Integer IDgioiTinh;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IDgioiTinh")
	GioiTinh gioitinh;

//	Integer IDSize;
	@ManyToOne
	@JoinColumn(name = "IDSize")
	Size size;

	Double Gia;
	String ChatLieu;
	String Mau;
	String MoTa;
	String Hinh1;
	String Hinh2;
	String Hinh3;
	String Hinh4;
	
	public Integer getIDSP() {
		return IDSP;
	}
	
	public void setIDSP(Integer iDSP) {
		IDSP = iDSP;
	}
	
	public String getTenSP() {
		return TenSP;
	}
	
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	
	public ThuongHieu getThuonghieu() {
		return thuonghieu;
	}
	
	public void setThuonghieu(ThuongHieu thuonghieu) {
		this.thuonghieu = thuonghieu;
	}
	
	public GioiTinh getGioitinh() {
		return gioitinh;
	}
	
	public void setGioitinh(GioiTinh gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Double getGia() {
		return Gia;
	}
	
	public void setGia(Double gia) {
		Gia = gia;
	}
	
	public String getChatLieu() {
		return ChatLieu;
	}
	
	public void setChatLieu(String chatLieu) {
		ChatLieu = chatLieu;
	}
	
	public String getMau() {
		return Mau;
	}
	
	public void setMau(String mau) {
		Mau = mau;
	}
	
	public String getMoTa() {
		return MoTa;
	}
	
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	
	public String getHinh1() {
		return Hinh1;
	}
	
	public void setHinh1(String hinh1) {
		Hinh1 = hinh1;
	}
	
	public String getHinh2() {
		return Hinh2;
	}
	
	public void setHinh2(String hinh2) {
		Hinh2 = hinh2;
	}
	
	public String getHinh3() {
		return Hinh3;
	}
	
	public void setHinh3(String hinh3) {
		Hinh3 = hinh3;
	}
	
	public String getHinh4() {
		return Hinh4;
	}
	
	public void setHinh4(String hinh4) {
		Hinh4 = hinh4;
	}

	public DSSP(Integer iDSP, String tenSP, ThuongHieu thuonghieu, GioiTinh gioitinh, Size size, Double gia,
			String chatLieu, String mau, String moTa, String hinh1, String hinh2, String hinh3, String hinh4) {
		IDSP = iDSP;
		TenSP = tenSP;
		this.thuonghieu = thuonghieu;
		this.gioitinh = gioitinh;
		this.size = size;
		Gia = gia;
		ChatLieu = chatLieu;
		Mau = mau;
		MoTa = moTa;
		Hinh1 = hinh1;
		Hinh2 = hinh2;
		Hinh3 = hinh3;
		Hinh4 = hinh4;
	}

	public DSSP() {
		
	}

//	@JsonIgnore
//	@OneToMany(mappedBy = "DSSP")
//	List<ChiTietDonHang> chitietdonhang;
	
	

}
