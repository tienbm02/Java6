package BMTJ6_ASM.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DonHang")
public class DonHang  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer IDDonHang;
	//String Username;
	String SDT;
	String DiaChi;
	Date Ngay;
	Double Gia;
	Double PhiVanChuyen;
	Double TongTien;
	@JsonIgnore
	@OneToMany(mappedBy = "DONHANG")
	List<ChiTietDonHang> chitietdonhang;
	@ManyToOne
	@JoinColumn(name="Username")
	TaiKhoan Username;
	
	public Integer getIDDonHang() {
		return IDDonHang;
	}
	
	public void setIDDonHang(Integer iDDonHang) {
		IDDonHang = iDDonHang;
	}
	
	public String getSDT() {
		return SDT;
	}
	
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	public String getDiaChi() {
		return DiaChi;
	}
	
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public Date getNgay() {
		return Ngay;
	}
	
	public void setNgay(Date ngay) {
		Ngay = ngay;
	}
	
	public Double getGia() {
		return Gia;
	}
	
	public void setGia(Double gia) {
		Gia = gia;
	}
	
	public Double getPhiVanChuyen() {
		return PhiVanChuyen;
	}
	
	public void setPhiVanChuyen(Double phiVanChuyen) {
		PhiVanChuyen = phiVanChuyen;
	}
	
	public Double getTongTien() {
		return TongTien;
	}
	
	public void setTongTien(Double tongTien) {
		TongTien = tongTien;
	}
	
	public List<ChiTietDonHang> getChitietdonhang() {
		return chitietdonhang;
	}
	
	public void setChitietdonhang(List<ChiTietDonHang> chitietdonhang) {
		this.chitietdonhang = chitietdonhang;
	}
	
	public TaiKhoan getUsername() {
		return Username;
	}
	
	public void setUsername(TaiKhoan username) {
		Username = username;
	}

	public DonHang(Integer iDDonHang, String sDT, String diaChi, Date ngay, Double gia, Double phiVanChuyen,
			Double tongTien, List<ChiTietDonHang> chitietdonhang, TaiKhoan username) {
		IDDonHang = iDDonHang;
		SDT = sDT;
		DiaChi = diaChi;
		Ngay = ngay;
		Gia = gia;
		PhiVanChuyen = phiVanChuyen;
		TongTien = tongTien;
		this.chitietdonhang = chitietdonhang;
		Username = username;
	}

	public DonHang() {
		
	}
	
}