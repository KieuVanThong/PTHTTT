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
@Table(name = "congdoansx")
public class CongDoanSX implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SanPhamID",nullable = false)
	private SanPham sanPham;
	
	@Column(name = "TenCongDoan",nullable = false)
	private String tenCongDoan;
	
	@Column(name = "MoTa",nullable = false)
	private String moTa;
	
	@Column(name = "ThoiGianHoanThien",nullable = false)
	private String thoiGianHoanThien;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public String getTenCongDoan() {
		return tenCongDoan;
	}

	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getThoiGianHoanThien() {
		return thoiGianHoanThien;
	}

	public void setThoiGianHoanThien(String thoiGianHoanThien) {
		this.thoiGianHoanThien = thoiGianHoanThien;
	}
	
	
}
