package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "xuong")
public class Xuong implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@Column(name = "TenXuong",nullable = false)
	private String tenXuong;
	
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

	public String getTenXuong() {
		return tenXuong;
	}

	public void setTenXuong(String tenXuong) {
		this.tenXuong = tenXuong;
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
