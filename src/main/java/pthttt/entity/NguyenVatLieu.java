package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "nguyenvatlieu")
public class NguyenVatLieu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name = "MaNVL",nullable = false)
	private String maNVL;
	
	@Column(name = "TenNVL",nullable = false)
	private String tenNVL;
	
	@Column(name = "KhoiLuong",nullable = false)
	private float khoiLuong;
	
	@Column(name = "DoDai",nullable = false)
	private float doDai;
	
	@Column(name = "DoRong",nullable = false)
	private float doRong;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaNVL() {
		return maNVL;
	}

	public void setMaNVL(String maNVL) {
		this.maNVL = maNVL;
	}

	public String getTenNVL() {
		return tenNVL;
	}

	public void setTenNVL(String tenNVL) {
		this.tenNVL = tenNVL;
	}

	public float getKhoiLuong() {
		return khoiLuong;
	}

	public void setKhoiLuong(float khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	public float getDoDai() {
		return doDai;
	}

	public void setDoDai(float doDai) {
		this.doDai = doDai;
	}

	public float getDoRong() {
		return doRong;
	}

	public void setDoRong(float doRong) {
		this.doRong = doRong;
	}
	
	
}
