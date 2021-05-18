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
@Table(name = "phieuxuatkho")
public class PhieuXuatKho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuDatHangID",nullable = false)
	private PhieuDatHang phieuDatHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KhoID",nullable = false)
	private Kho kho;
	
	@Column(name = "NgayXuat",nullable = false)
	private String ngayXuat;
	
	@Column(name = "SoLuong",nullable = false)
	private int soLuong;
	
	@Column(name = "TrangThai",nullable = false)
	private String trangThai;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}

	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
	}

	public Kho getKho() {
		return kho;
	}

	public void setKho(Kho kho) {
		this.kho = kho;
	}

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
