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
@Table(name = "phieumuanvl")
public class PhieuMuaNVL implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID",nullable = false)
	private NhanVien nhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LenhSanXuatID",nullable = false)
	private LenhSanXuat lenhSanXuat;
	
	@Column(name = "MaPhieu",nullable = false)
	private String maPhieu;
	
	@Column(name = "NgayLap",nullable = false)
	private String ngayLap;
	
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

	public LenhSanXuat getLenhSanXuat() {
		return lenhSanXuat;
	}

	public void setLenhSanXuat(LenhSanXuat lenhSanXuat) {
		this.lenhSanXuat = lenhSanXuat;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	
	
}
