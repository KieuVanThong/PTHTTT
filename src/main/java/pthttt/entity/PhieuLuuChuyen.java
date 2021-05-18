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
@Table(name = "phieuluuchuyen")
public class PhieuLuuChuyen implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XuongID",nullable = false)
	private Xuong xuong;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KhoID",nullable = false)
	private Kho kho;
	
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

	public Xuong getXuong() {
		return xuong;
	}

	public void setXuong(Xuong xuong) {
		this.xuong = xuong;
	}

	public Kho getKho() {
		return kho;
	}

	public void setKho(Kho kho) {
		this.kho = kho;
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
