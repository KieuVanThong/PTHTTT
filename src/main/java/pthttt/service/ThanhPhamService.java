package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuDatHang;
import pthttt.entity.ThanhPham;
import pthttt.repository.ThanhPhamRepository;

@Service
public class ThanhPhamService {

	@Autowired
	private ThanhPhamRepository thanhPhamRepository;
	
	public ThanhPham saveThanhPham(ThanhPham thanhPham) {
		 return thanhPhamRepository.save(thanhPham);
	}

	public List<ThanhPham> findAllThanhPhams() {
		return  thanhPhamRepository.findAll();
	}
	public ThanhPham findOneThanhPhamByID(int ID) {
		return thanhPhamRepository.findByID(ID);
	}
	public boolean checkThanhPhamByPhieuDatHang(PhieuDatHang phieuDatHang) {
		return thanhPhamRepository.existsByPhieuDatHang(phieuDatHang);
	}
	public void delete(List<ThanhPham> thanhPham) {
        thanhPhamRepository.delete((ThanhPham) thanhPham);
    }
	public void delete(int id) {
        thanhPhamRepository.deleteById(id);
    }
	public List<ThanhPham> findThanhPhamByPhieuDatHang(PhieuDatHang phieuDatHang){
		return thanhPhamRepository.findAllByPhieuDatHang(phieuDatHang);
	}
}
