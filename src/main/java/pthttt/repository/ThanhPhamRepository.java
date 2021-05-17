package pthttt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.PhieuDatHang;
import pthttt.entity.ThanhPham;

@Repository
public interface ThanhPhamRepository extends JpaRepository<ThanhPham, Integer>{
	
	public List<ThanhPham> findAll() ;
	
	public List<ThanhPham> findByPhieuDatHang(int ID);
	
	public boolean existsByPhieuDatHang(PhieuDatHang phieuDatHang); 
	
	public ThanhPham findByID(int ID);
	
	public List<ThanhPham> findAllByPhieuDatHang(PhieuDatHang phieuDatHang) ;
	
}
