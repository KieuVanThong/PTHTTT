package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bangdinhmuc")
public class BangDinhMuc implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID",nullable = false)
	private NhanVien nhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NguyenVatLieuID",nullable = false)
	private NguyenVatLieu nguyenVatLieu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SanPhamID",nullable = false)
	private SanPham sanPham;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public NguyenVatLieu getNguyenVatLieu() {
		return nguyenVatLieu;
	}

	public void setNguyenVatLieu(NguyenVatLieu nguyenVatLieu) {
		this.nguyenVatLieu = nguyenVatLieu;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	
}
