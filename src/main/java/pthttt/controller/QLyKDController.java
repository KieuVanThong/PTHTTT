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
import pthttt.entity.NhanVien;
import pthttt.entity.PhieuDatHang;
import pthttt.entity.PhieuThu;
import pthttt.entity.SanPham;
import pthttt.entity.ThanhPham;
import pthttt.entity.Xuong;
import pthttt.service.LenhSanXuatService;
import pthttt.service.NhanVienService;
import pthttt.service.PhieuDatHangService;
import pthttt.service.PhieuThuService;
import pthttt.service.SanPhamService;
import pthttt.service.ThanhPhamService;
import pthttt.service.XuongService;

@Controller
public class QLyKDController {

	@Autowired
	private PhieuDatHangService pdhService;

	@Autowired
	private NhanVienService nhanVienService;

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private XuongService xuongService;

	@Autowired
	private ThanhPhamService thanhPhamService;

	@Autowired
	private PhieuThuService phieuThuService;
	
	@Autowired
	private LenhSanXuatService lenhSanXuatService;
	
	@GetMapping("/PhieuDatHang")
	public String listPhieuDatHang(Model model) {
		List<PhieuDatHang> listpdh = new ArrayList<PhieuDatHang>();
		List<ThanhPham> listTP = new ArrayList<ThanhPham>();
		listpdh = pdhService.findAllPhieuDatHang();
		listTP = thanhPhamService.findAllThanhPhams();
		model.addAttribute("pdhs", listpdh);
		model.addAttribute("tps", listTP);
		return "quanLyKD_ListPDH";
	}

	@GetMapping("/AddPhieuDatHang")
	public String AddPhieuDatHang(HttpSession session,Model model) {
		String hoTenKinhDoanh =(String) session.getAttribute("hoTenKinhDoanh");
		model.addAttribute("hoTenKinhDoanh", hoTenKinhDoanh);
		return "quanLyKD_AddPDH";
	}

	@GetMapping("/Active_AddPhieuDatHang")
	public String active_AddPhieuDatHang(@ModelAttribute NhanVien nhanVien, @ModelAttribute PhieuDatHang phieuDatHang, //
			@RequestParam("maPhieu") String maPhieu, @RequestParam("tenKH") String tenKH,
			@RequestParam("sdtKH") String sdtKH, //
			@RequestParam("diaChiKH") String diaChiKH, @RequestParam("ngayLap") String ngayLap, //
			@RequestParam("ngayGiaoHang") String ngayGiaoHang, @RequestParam("trangThai") String trangThai,
			@RequestParam("ghiChu") String ghiChu, //
			@RequestParam("tenNguoiLap") String tenNguoiLap, HttpSession session) {

		if (nhanVienService.checkNhanVienByHoTen(tenNguoiLap)) {
			nhanVien = nhanVienService.findNhanVien(tenNguoiLap);
			phieuDatHang.setMaPhieu(maPhieu);
			phieuDatHang.setTenKH(tenKH);
			phieuDatHang.setSdtKH(sdtKH);
			phieuDatHang.setDiaChiKH(diaChiKH);
			phieuDatHang.setNgayLap(ngayLap);
			phieuDatHang.setNgayGiaoHang(ngayGiaoHang);
			phieuDatHang.setTrangThai(trangThai);
			phieuDatHang.setChuThich(ghiChu);
			phieuDatHang.setNhanVien(nhanVien);

			pdhService.savePhieuDatHang(phieuDatHang);
			return "redirect:/PhieuDatHang";
		} else {
			session.setAttribute("error", "Tên không hợp lệ!");
			return "redirect:/AddPhieuDatHang";
		}
	}

	@GetMapping("/EditPhieuDatHang/{ID}")
	public String editPhieuDatHang(Model model, @PathVariable int ID, @ModelAttribute PhieuDatHang phieuDatHang) {
		phieuDatHang = pdhService.findOnePhieuDatHangByID(ID);
		model.addAttribute("ID", phieuDatHang.getID());
		model.addAttribute("maPhieu", phieuDatHang.getMaPhieu());
		model.addAttribute("tenKH", phieuDatHang.getTenKH());
		model.addAttribute("sdtKH", phieuDatHang.getSdtKH());
		model.addAttribute("diaChiKH", phieuDatHang.getDiaChiKH());
		model.addAttribute("ngayLap", phieuDatHang.getNgayLap());
		model.addAttribute("ngayGiaoHang", phieuDatHang.getNgayGiaoHang());
		model.addAttribute("trangThai", phieuDatHang.getTrangThai());
		model.addAttribute("chuThich", phieuDatHang.getChuThich());
		model.addAttribute("tenNguoiLap", phieuDatHang.getNhanVien().getHoTen());
		return "quanLyKD_EditPDH";
	}

	@GetMapping("/Active_EditPhieuDatHang")
	public String active_EditPhieuDatHang(@ModelAttribute NhanVien nhanVien, @ModelAttribute PhieuDatHang phieuDatHang, //
			@RequestParam("ID") int ID, @RequestParam("maPhieu") String maPhieu, @RequestParam("tenKH") String tenKH,
			@RequestParam("sdtKH") String sdtKH, //
			@RequestParam("diaChiKH") String diaChiKH,
			@RequestParam("ngayLap") String ngayLap, //
			@RequestParam("ngayGiaoHang") String ngayGiaoHang, @RequestParam("trangThai") String trangThai,
			@RequestParam("ghiChu") String ghiChu,HttpSession session) {

		String tenNguoiLap =(String) session.getAttribute("hoTenKinhDoanh");
		nhanVien = nhanVienService.findNhanVien(tenNguoiLap);
		phieuDatHang.setMaPhieu(maPhieu);
		phieuDatHang.setTenKH(tenKH);
		phieuDatHang.setSdtKH(sdtKH);
		phieuDatHang.setDiaChiKH(diaChiKH);
		phieuDatHang.setNgayLap(ngayLap);
		phieuDatHang.setNgayGiaoHang(ngayGiaoHang);
		phieuDatHang.setTrangThai(trangThai);
		phieuDatHang.setChuThich(ghiChu);
		phieuDatHang.setNhanVien(nhanVien);

		pdhService.savePhieuDatHang(phieuDatHang);
		return "redirect:/PhieuDatHang";
	}

	@GetMapping("/RemovePhieuDatHang/{ID}")
	public String removePhieuDatHang(@PathVariable int ID, @ModelAttribute ThanhPham thanhPham,
			@ModelAttribute PhieuDatHang phieuDatHang) {

		phieuDatHang = pdhService.findOnePhieuDatHangByID(ID);
		if (thanhPhamService.checkThanhPhamByPhieuDatHang(phieuDatHang) ||phieuThuService.checkPhieuThuByPhieuDatHang(phieuDatHang)||
				lenhSanXuatService.check(phieuDatHang)) {
			return "redirect:/Phieudathang";
		} else {
			pdhService.delete(ID);
			return "redirect:/PhieuDatHang";
		}
	}

	@GetMapping("/AddThanhPham")
	public String AddThanhPham(Model model) {
		model.addAttribute("xuongID", 1);
		return "quanLyKD_AddThanhPham";
	}

	@GetMapping("/Active_AddThanhPham")
	public String active_AddThanhPham(@RequestParam("maPhieu") String maPhieu, @RequestParam("tenSanPham") String tenSanPham,
			@RequestParam("soLuong") int soLuong,@RequestParam("loaiGia") float loaiGia, @RequestParam("trangThai") String trangThai,
			@ModelAttribute SanPham sanPham,@ModelAttribute ThanhPham thanhPham, @ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute Xuong xuong) {

		sanPham = sanPhamService.findSanPham(tenSanPham);
		phieuDatHang = pdhService.findOnePhieuDatHangByMa(maPhieu);
		xuong = xuongService.findXuong(1);
		thanhPham.setSanPham(sanPham);
		thanhPham.setSoLuong(soLuong);
		thanhPham.setLoaiGia(loaiGia);
		thanhPham.setPhieuDatHang(phieuDatHang);
		thanhPham.setXuong(xuong);
		thanhPham.setSoLuongTonKho(0);
		thanhPham.setSoLuongTrongXuong(0);
		thanhPham.setTinhTrang("chưa giao");

		thanhPhamService.saveThanhPham(thanhPham);
		return "redirect:/PhieuDatHang";
	}
	
	@GetMapping("/EditThanhPham/{ID}")
	public String editThanhPham(Model model, @PathVariable int ID, @ModelAttribute ThanhPham thanhPham) {
		thanhPham = thanhPhamService.findOneThanhPhamByID(ID);
		model.addAttribute("ID", ID);
		model.addAttribute("tenSanPham",thanhPham.getSanPham().getTenSP());
		model.addAttribute("maPhieu", thanhPham.getPhieuDatHang().getMaPhieu());
		model.addAttribute("tenKH", thanhPham.getPhieuDatHang().getMaPhieu());
		model.addAttribute("tenXuong", thanhPham.getXuong().getTenXuong());
		model.addAttribute("soLuong", thanhPham.getSoLuong());
		model.addAttribute("loaiGia", thanhPham.getLoaiGia());
		return "quanLyKD_EditThanhPham";
	}
	
	@GetMapping("/Active_EditThanhPham")
	public String active_EditThanhPham(@RequestParam("ID")int ID,@RequestParam("tenSanPham")String tenSanPham,//
			@RequestParam("maPhieu")String maPhieu,//
			@RequestParam("tenKH")String tenKH,@RequestParam("soLuong")int soLuong,//
			@RequestParam("loaiGia")float loaiGia,@ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute Xuong xuong,//
			@ModelAttribute ThanhPham thanhPham,@ModelAttribute SanPham sanPham) {
		
		sanPham=sanPhamService.findSanPham(tenSanPham);
		phieuDatHang=pdhService.findOnePhieuDatHangByMa(maPhieu);
		xuong =xuongService.findXuong(1);
		thanhPham.setID(ID);
		thanhPham.setPhieuDatHang(phieuDatHang);
		thanhPham.setXuong(xuong);
		thanhPham.setLoaiGia(loaiGia);
		thanhPham.setSanPham(sanPham);
		thanhPham.setSoLuong(soLuong);
		thanhPham.setSoLuongTonKho(0);
		thanhPham.setSoLuongTrongXuong(0);
		thanhPham.setTinhTrang("chưa giao");
		
		thanhPhamService.saveThanhPham(thanhPham);;
		return "redirect:/PhieuDatHang";
	}
	@GetMapping("/RemoveThanhPham/{ID}")
	public String removeThanhPham(@PathVariable int ID) {
		thanhPhamService.delete(ID);
		return "redirect:/Phieudathang";
	}

	@GetMapping("/ListPhieuThu/{ID}")
	public String listPhieuThu(Model model,@ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute ThanhPham thanhPham,@PathVariable int ID) {
		List<PhieuThu> listpt=new ArrayList<PhieuThu>();
		List<ThanhPham> listtp =new ArrayList<ThanhPham>();
		phieuDatHang=pdhService.findOnePhieuDatHangByID(ID);
		listpt=phieuThuService.findAllByPhieuDatHang(phieuDatHang);
		model.addAttribute("pts", listpt);
		
		listtp=thanhPhamService.findThanhPhamByPhieuDatHang(phieuDatHang);
		float tongTien=0;
		float sum=0;
		for(int i=0;i<listtp.size();i++) {
			tongTien=listtp.get(i).getSoLuong()*listtp.get(i).getLoaiGia();
			sum+=tongTien;
		}
		float tongCoc=0;
		for(int i=0;i<listpt.size();i++) {
			tongCoc+=listpt.get(i).getTienDatCoc();
		}
		model.addAttribute("sum",sum);
		model.addAttribute("conNo",sum-tongCoc);
		return "quanLyKD_ListPhieuThu";
	}

	@GetMapping("/AddPhieuThu/{ID}")
	public String addPhieuThu(Model model,@PathVariable int ID,@ModelAttribute PhieuDatHang phieuDatHang) {
		phieuDatHang=pdhService.findOnePhieuDatHangByID(ID);
		model.addAttribute("phieudathangID", phieuDatHang.getMaPhieu());
		return "quanLyKD_AddPhieuThu";
	}

	@GetMapping("/Active_AddPhieuThu")
	public String active_AddPhieuThu(@ModelAttribute PhieuThu phieuthu,@ModelAttribute PhieuDatHang phieuDatHang,//
			@RequestParam("soPhieu") String soPhieu,//
			@RequestParam("loaiPhieu")String loaiPhieu,@RequestParam("ngay")String ngay,@RequestParam("noiDung")String noiDung,//
			@RequestParam("chuThich")String chuThich,@RequestParam("tienDatCoc")float tienDatCoc,//
			@RequestParam("phieuDatHangID") String phieuDatHangID) {
		phieuDatHang =pdhService.findOnePhieuDatHangByMa(phieuDatHangID);
		phieuthu.setPhieudathang(phieuDatHang);
		phieuthu.setLoaiPhieu(loaiPhieu);
		phieuthu.setSoPhieu(soPhieu);
		phieuthu.setNgay(ngay);
		phieuthu.setNoiDung(noiDung);
		phieuthu.setChuThich(chuThich);
		phieuthu.setTienDatCoc(tienDatCoc);
		
		phieuThuService.savePhieuThu(phieuthu);
		return "redirect:/PhieuDatHang";
	}
	
	@GetMapping("/RemovePhieuThu/{ID}")
	public String removePhieuThu(@PathVariable int ID) {
		phieuThuService.removePhieuThu(ID);
		return  "quanLyKD_ListPhieuThu";
	}
	
	@GetMapping("/EditPhieuThu/{ID}")
	public String editPhieuThu(@PathVariable int ID,@ModelAttribute PhieuThu phieuThu,Model model) {
		phieuThu=phieuThuService.findOnePhieuTHuByID(ID);
		model.addAttribute("ID", ID);
		model.addAttribute("loaiPhieu", phieuThu.getLoaiPhieu());
		model.addAttribute("soPhieu", phieuThu.getSoPhieu());
		model.addAttribute("ngay", phieuThu.getNgay());
		model.addAttribute("noiDung", phieuThu.getNoiDung());
		model.addAttribute("chuThich", phieuThu.getChuThich());
		model.addAttribute("tienDatCoc", phieuThu.getTienDatCoc());
		model.addAttribute("maPhieuDatHang",phieuThu.getPhieudathang().getMaPhieu());
		return "quanLyKD_EditPhieuThu" ;
	}
	
	@GetMapping("/Active_EditPhieuThu")
	public String active_EditPhieuThu(@ModelAttribute PhieuThu phieuthu,@ModelAttribute PhieuDatHang phieuDatHang,//
			@RequestParam("ID")int ID,@RequestParam("soPhieu") String soPhieu,@RequestParam("maPhieuDatHang")String maPhieuDatHang,//
			@RequestParam("loaiPhieu")String loaiPhieu,@RequestParam("ngay")String ngay,@RequestParam("noiDung")String noiDung,//
			@RequestParam("chuThich")String chuThich,@RequestParam("tienDatCoc")float tienDatCoc) {
				
		phieuDatHang=pdhService.findOnePhieuDatHangByMa(maPhieuDatHang);
		phieuthu.setPhieudathang(phieuDatHang);
		phieuthu.setID(ID);
		phieuthu.setLoaiPhieu(loaiPhieu);
		phieuthu.setSoPhieu(soPhieu);
		phieuthu.setNgay(ngay);
		phieuthu.setNoiDung(noiDung);
		phieuthu.setChuThich(chuThich);
		phieuthu.setTienDatCoc(tienDatCoc);
		
		phieuThuService.savePhieuThu(phieuthu);
		return "redirect:/PhieuDatHang";
		
	}
}
