package pthttt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

	public NhanVien findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
	
	public NhanVien findByHoTen(String hoTen);

	public NhanVien getByTenDangNhap(String tenDangNhap);

	public boolean existsByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau) ;

	public boolean existsByHoTen(String hoTen);
	
	public NhanVien findByID(int ID);
}
