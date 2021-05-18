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
@Table(name = "kho")
public class Kho implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID",nullable = false)
	private NhanVien nhanVien;
	
	@Column(name = "TenKho",nullable = false)
	private String tenKho;
	
	@Column(name = "DiaChi",nullable = false)
	private String diaChi;
	
	@Column(name = "DienTich",nullable = false)
	private float dienTich;
	
	@Column(name = "LuongNhanCong",nullable = false)
	private int luongNhanCong;

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

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	public int getLuongNhanCong() {
		return luongNhanCong;
	}

	public void setLuongNhanCong(int luongNhanCong) {
		this.luongNhanCong = luongNhanCong;
	}
	
	
}
