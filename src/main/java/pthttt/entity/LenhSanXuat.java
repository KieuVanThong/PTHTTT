package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lenhsanxuat")
public class LenhSanXuat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID",nullable = false)
	private NhanVien nhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuDatHangID",nullable = false)
	private PhieuDatHang phieuDatHang;
	
	@Column(name = "NgayBatDauSP",nullable = false)
	private String ngayBatDauSP;
	
	@Column(name = "NgayXuatSP",nullable = false)
	private String ngayXuatSP;
	
	@Column(name = "TrangThai",nullable = false)
	private String trangThai;
	
	@Column(name = "ChuThich",nullable = false)
	private String chuThich;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}

	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
	}

	public String getNgayBatDauSP() {
		return ngayBatDauSP;
	}

	public void setNgayBatDauSP(String ngayBatDauSP) {
		this.ngayBatDauSP = ngayBatDauSP;
	}

	public String getNgayXuatSP() {
		return ngayXuatSP;
	}

	public void setNgayXuatSP(String ngayXuatSP) {
		this.ngayXuatSP = ngayXuatSP;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	
	
}
