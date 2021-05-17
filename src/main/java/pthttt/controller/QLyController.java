package pthttt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import pthttt.entity.Kho;
import pthttt.entity.NguyenVatLieu;
import pthttt.entity.NhanVien;
import pthttt.entity.SanPham;
import pthttt.entity.Xuong;
import pthttt.service.KhoService;
import pthttt.service.NguyenVatLieuService;
import pthttt.service.NhanVienService;
import pthttt.service.SanPhamService;
import pthttt.service.XuongService;

@Controller
public class QLyController {

	@Autowired
	private NhanVienService nhanVienService;

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private NguyenVatLieuService nguyenVatLieuService;
	
	@Autowired
	private XuongService xuongService;
	
	@Autowired
	private KhoService khoService;
	
	@GetMapping("/ListNhanVien_QLy")
	public String listNhanVien(Model model) {
		List<NhanVien> listnv = new ArrayList<NhanVien>();
		listnv = nhanVienService.findAll();
		model.addAttribute("nvs", listnv);
		return "quanLy_ListNhanVien";
	}

	@GetMapping("/AddNhanVien")
	public String AddNhanVien() {
		return "quanLy_AddNhanVien";
	}

	@GetMapping("/Active_AddNhanVien")
	public String active_AddNhanVien(@RequestParam("hoTen") String hoTen,
			@RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String //
			matKhau, @RequestParam("diaChi") String diaChi, @RequestParam("viTri") String viTri,
			@RequestParam("boPhan") String boPhan, @ModelAttribute //
			NhanVien nhanVien) {
		nhanVien.setBoPhan(boPhan);
		nhanVien.setDiaChi(diaChi);
		nhanVien.setHoTen(hoTen);
		nhanVien.setMatKhau(matKhau);
		nhanVien.setTenDangNhap(tenDangNhap);
		nhanVien.setViTri(viTri);

		nhanVienService.save(nhanVien);
		return "redirect:/ListNhanVien_QLy";
	}

	@GetMapping("/EditNhanVien/{ID}")
	public String editNhanVien(@PathVariable int ID, @ModelAttribute NhanVien nhanVien, Model model,
			HttpSession sesion) {
		nhanVien = nhanVienService.findByID(ID);
		model.addAttribute("ID", nhanVien.getID());
		model.addAttribute("boPhan", nhanVien.getBoPhan());
		model.addAttribute("viTri", nhanVien.getViTri());
		model.addAttribute("hoTen", nhanVien.getHoTen());
		model.addAttribute("diaChi", nhanVien.getDiaChi());
		model.addAttribute("tenDangNhap", nhanVien.getTenDangNhap());
		model.addAttribute("matKhau", nhanVien.getMatKhau());
		return "quanLy_EditNhanVien";
	}

	@GetMapping("/Active_EditNhanVien")
	public String active_EditNhanVien(HttpSession session,@ModelAttribute NhanVien nhanVien,@RequestParam("boPhan")String boPhan,@RequestParam("viTri")//
	String viTri,@RequestParam("hoTen")String hoTen,@RequestParam("diaChi")String diaChi,@RequestParam("tenDangNhap")String tenDangNhap,//
	@RequestParam("matKhau")String matKhau,@RequestParam("ID")int ID) {
		nhanVien.setBoPhan(boPhan);
		nhanVien.setDiaChi(diaChi);
		nhanVien.setHoTen(hoTen);
		nhanVien.setID(ID);
		nhanVien.setMatKhau(matKhau);
		nhanVien.setTenDangNhap(tenDangNhap);
		nhanVien.setViTri(viTri);
		
		nhanVienService.save(nhanVien);
		return "redirect:/ListNhanVien_QLy";
	}

	@GetMapping("/ListSanPham_QLy")
	public String listSanPham_QLy(Model model) {
		List<SanPham> listsp = new ArrayList<SanPham>();
		listsp = sanPhamService.findAllSanPham();
		model.addAttribute("sps", listsp);
		return "quanLy_ListSanPham";
	}
	
	@GetMapping("/AddSanPham")
	public String AddSanPham() {
		return "quanLy_AddSanPham";
	}
	
	@GetMapping("/Active_AddSanPham")
	public String active_AddSanPham(@RequestParam("tenSP")String tenSP,@RequestParam("maSP")String maSP,@RequestParam("khoiLuong")float khoiLuong,
			@RequestParam("doDai")float doDai,@RequestParam("doRong")float doRong,@ModelAttribute SanPham sanPham) {
		sanPham.setDoDai(doDai);
		sanPham.setDoRong(doRong);
		sanPham.setKhoiLuong(khoiLuong);
		sanPham.setMaSP(maSP);
		sanPham.setTenSP(tenSP);
		
		sanPhamService.save(sanPham);
		return "redirect:/ListSanPham_QLy";
	}
	
	@GetMapping("/EditSanPham/{ID}")
	public String editSanPham(@PathVariable int ID,@ModelAttribute SanPham sanPham,Model model) {
		sanPham =sanPhamService.findSanPhamByID(ID);
		model.addAttribute("ID", ID);
		model.addAttribute("tenSP", sanPham.getTenSP());
		model.addAttribute("maSP", sanPham.getMaSP());
		model.addAttribute("khoiLuong", sanPham.getKhoiLuong());
		model.addAttribute("doDai", sanPham.getDoDai());
		model.addAttribute("doRong", sanPham.getDoRong());
		return "quanLy_EditSanPham";
	}
	
	@GetMapping("/Active_EditSanPham")
	public String active_EditSanPham(@RequestParam("tenSP")String tenSP,@RequestParam("maSP")String maSP,@RequestParam("khoiLuong")float khoiLuong,
			@RequestParam("doDai")float doDai,@RequestParam("doRong")float doRong,@RequestParam("ID")int ID,@ModelAttribute SanPham sanPham) {
		sanPham.setID(ID);
		sanPham.setDoDai(doDai);
		sanPham.setDoRong(doRong);
		sanPham.setKhoiLuong(khoiLuong);
		sanPham.setMaSP(maSP);
		sanPham.setTenSP(tenSP);
		
		sanPhamService.save(sanPham);
		return "redirect:/ListSanPham_QLy";
	}
	
	@GetMapping("/ListNVL_QLy")
	public String listNVL_QLy(Model model) {
		List<NguyenVatLieu> listnvl=new ArrayList<NguyenVatLieu>();
		listnvl=nguyenVatLieuService.findAll();
		model.addAttribute("nvls", listnvl);
		return "quanLy_ListNVL";
	}
	
	@GetMapping("/AddNVL")
	public String AddNVL() {
		return "quanLy_AddNVL";
	}
	
	@GetMapping("/Active_AddNVL")
	public String active_AddNVL(@RequestParam("tenNVL")String tenNVL,@RequestParam("maNVL")String maNVL,@RequestParam("khoiLuong")float khoiLuong,
			@RequestParam("doDai")float doDai,@RequestParam("doRong")float doRong,@ModelAttribute NguyenVatLieu nguyenVatLieu) {
		
		nguyenVatLieu.setDoDai(doDai);
		nguyenVatLieu.setDoRong(doRong);
		nguyenVatLieu.setKhoiLuong(khoiLuong);
		nguyenVatLieu.setMaNVL(maNVL);
		nguyenVatLieu.setTenNVL(tenNVL);
		
		nguyenVatLieuService.save(nguyenVatLieu);
		return "redirect:/ListNVL_QLy";
	}
	
	@GetMapping("/EditNVL/{ID}")
	public String editNVL(@PathVariable int ID,@ModelAttribute NguyenVatLieu nguyenVatLieu,Model model) {
		nguyenVatLieu =nguyenVatLieuService.findByID(ID);
		model.addAttribute("ID", ID);
		model.addAttribute("tenNVL",nguyenVatLieu.getTenNVL());
		model.addAttribute("maNVL", nguyenVatLieu.getMaNVL());
		model.addAttribute("khoiLuong", nguyenVatLieu.getKhoiLuong());
		model.addAttribute("doDai", nguyenVatLieu.getDoDai());
		model.addAttribute("doRong", nguyenVatLieu.getDoRong());
		return "quanLy_EditNVL";
	}
	
	@GetMapping("/Active_EditNVL")
	public String active_EditNVL(@RequestParam("tenNVL")String tenNVL,@RequestParam("maNVL")String maNVl,@RequestParam("khoiLuong")float khoiLuong,
			@RequestParam("doDai")float doDai,@RequestParam("doRong")float doRong,@RequestParam("ID")int ID,@ModelAttribute NguyenVatLieu nguyenVatLieu) {
		nguyenVatLieu.setDoDai(doDai);
		nguyenVatLieu.setDoRong(doRong);
		nguyenVatLieu.setID(ID);
		nguyenVatLieu.setKhoiLuong(khoiLuong);
		nguyenVatLieu.setMaNVL(maNVl);
		nguyenVatLieu.setTenNVL(tenNVL);
		
		nguyenVatLieuService.save(nguyenVatLieu);
		return "redirect:/ListNVL_QLy";
	}
	
	@GetMapping("/AddXuong")
	public String AddXuong(@ModelAttribute Xuong xuong,Model model) {
		model.addAttribute("tenXuong", "Xưởng Gia Công");
		model.addAttribute("diaChi", "Hà Nội");
		model.addAttribute("dienTich",50);
		model.addAttribute("luongNhanCong", 20);
		
		return "quanLy_AddXuong";
	}
	@GetMapping("/Active_AddXuong")
	public String Active_AddXuong(@RequestParam("tenXuong")String tenXuong,@RequestParam("diaChi")String diaChi,@RequestParam("dienTich")float dienTich,
			@RequestParam("luongNhanCong")int luongNhanCong,@ModelAttribute Xuong xuong) {
		xuong.setID(1);
		xuong.setDiaChi(diaChi);
		xuong.setDienTich(dienTich);
		xuong.setLuongNhanCong(luongNhanCong);
		xuong.setTenXuong(tenXuong);
		
		xuongService.save(xuong);
		return "redirect:/ListNVL_QLy";
	}

	@GetMapping("/AddKho")
	public String AddKho(Model model) {
		model.addAttribute("tenKho", "Kho Thành Phẩm");
		model.addAttribute("diaChi", "Hà Nội");
		model.addAttribute("dienTich",50);
		model.addAttribute("luongNhanCong", 10);
		model.addAttribute("IDnhanVien", 1);
		return "quanLy_AddKho";
	}
	
	@GetMapping("/Active_AddKho")
	public String Active_AddKho(@RequestParam("tenKho")String tenKho,@RequestParam("diaChi")String diaChi,@RequestParam("dienTich")float dienTich,
			@RequestParam("luongNhanCong")int luongNhanCong,@RequestParam("IDnhanVien")int IDnhanVien,@ModelAttribute Kho kho,@ModelAttribute NhanVien nhanVien){
		kho.setID(1);
		kho.setDiaChi(diaChi);
		kho.setDienTich(dienTich);
		kho.setLuongNhanCong(luongNhanCong);
		kho.setTenKho(tenKho);
		nhanVien=nhanVienService.findByID(IDnhanVien);
		
		kho.setNhanVien(nhanVien);
		khoService.save(kho);
		return "redirect:/ListNVL_QLy";
	}
}
