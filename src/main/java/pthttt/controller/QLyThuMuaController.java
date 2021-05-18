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

import pthttt.entity.BangDinhMuc;
import pthttt.entity.LenhSanXuat;
import pthttt.entity.NVLCanDung;
import pthttt.entity.NguyenVatLieu;
import pthttt.entity.NhanVien;
import pthttt.entity.PhieuChi;
import pthttt.entity.PhieuDatHang;
import pthttt.entity.PhieuMuaNVL;
import pthttt.entity.SanPham;
import pthttt.entity.ThanhPham;
import pthttt.entity.Xuong;
import pthttt.service.BangDinhMucService;
import pthttt.service.LenhSanXuatService;
import pthttt.service.NVLCanDungService;
import pthttt.service.NguyenVatLieuService;
import pthttt.service.NhanVienService;
import pthttt.service.PhieuChiService;
import pthttt.service.PhieuDatHangService;
import pthttt.service.PhieuMuaNVLService;
import pthttt.service.SanPhamService;
import pthttt.service.ThanhPhamService;
import pthttt.service.XuongService;

@Controller
public class QLyThuMuaController {

	@Autowired
	private LenhSanXuatService lenhSanXuatService;

	@Autowired
	private PhieuMuaNVLService phieuMuaNVLService;

	@Autowired
	private NVLCanDungService nvlCanDungService;

	@Autowired
	private NhanVienService nhanVienService;

	@Autowired
	private BangDinhMucService bangDinhMucService;

	@Autowired
	private ThanhPhamService thanhPhamService;

	@Autowired
	private PhieuDatHangService phieuDatHangService;

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private XuongService xuongService;

	@Autowired
	private NguyenVatLieuService nguyenVatLieuService;

	@Autowired
	private PhieuChiService phieuChiService;

	@GetMapping("/ListLenhSanXuat_TM")
	public String listLenhSanXuat_TM(Model model) {
		List<LenhSanXuat> listlsx = new ArrayList<LenhSanXuat>();
		listlsx = lenhSanXuatService.findAllLenhSanXuat();
		model.addAttribute("lsxs", listlsx);
		return "quanLyThuMua_ListLenhSanXuat";
	}

	@GetMapping("/ListPhieuMuaNVL/{ID}")
	public String listPhieuMuaNVL(@PathVariable int ID, @ModelAttribute LenhSanXuat lenhSanXuat, Model model,
			HttpSession session, //
			@ModelAttribute PhieuDatHang phieuDatHang, @ModelAttribute SanPham sanPham) {
		lenhSanXuat = lenhSanXuatService.findOneByID(ID);
		List<PhieuMuaNVL> listpmnvl = new ArrayList<PhieuMuaNVL>();
		listpmnvl = phieuMuaNVLService.findAllByLenhSanXuat(lenhSanXuat);
		model.addAttribute("pmnvls", listpmnvl);

		phieuDatHang = phieuDatHangService.findOnePhieuDatHangByID(lenhSanXuat.getPhieuDatHang().getID());
		List<ThanhPham> listtp = new ArrayList<ThanhPham>();
		listtp = thanhPhamService.findThanhPhamByPhieuDatHang(phieuDatHang);
		model.addAttribute("tps", listtp);

		List<BangDinhMuc> listbdm = new ArrayList<BangDinhMuc>();

		for (int i = 0; i < listtp.size(); i++) {
			sanPham = sanPhamService.findSanPham(listtp.get(i).getSanPham().getTenSP());
			listbdm = bangDinhMucService.findAllBySanPham(sanPham);
		}
		model.addAttribute("bdms", listbdm);
		session.setAttribute("IDLenhSanXuat", ID);
		return "quanLyThuMua_ListPhieuMuaNVL";
	}

	@GetMapping("/ListNVLCanDung/{ID}")
	public String listNVLCanDung(@PathVariable int ID, @ModelAttribute PhieuMuaNVL phieuMuaNVL, Model model,
			HttpSession session) {
		phieuMuaNVL = phieuMuaNVLService.findOneByID(ID);
		List<NVLCanDung> listnvlcd = new ArrayList<NVLCanDung>();
		listnvlcd = nvlCanDungService.findAll(phieuMuaNVL);
		model.addAttribute("nvlcds", listnvlcd);

		session.setAttribute("IDPhieuMuaNVL", ID);
		return "quanLyThuMua_ListNVLCanDung";
	}

	@GetMapping("/EditPhieuMuaNVL/{ID}")
	public String editPhieuMuaNVL(@PathVariable int ID, @ModelAttribute PhieuMuaNVL phieuMuaNVL, Model model) {
		phieuMuaNVL = phieuMuaNVLService.findOneByID(ID);
		model.addAttribute("chuThich", phieuMuaNVL.getChuThich());
		model.addAttribute("ID", phieuMuaNVL.getID());
		model.addAttribute("IDLenhSanXuat", phieuMuaNVL.getLenhSanXuat().getID());
		model.addAttribute("maPhieu", phieuMuaNVL.getMaPhieu());
		model.addAttribute("ngayLap", phieuMuaNVL.getNgayLap());
		model.addAttribute("tenNhanVien", phieuMuaNVL.getNhanVien().getHoTen());
		return "quanLyThuMua_EditPhieuMuaNVL";
	}

	@GetMapping("/Active_EditPhieuMuaNVL")
	public String active_EditPhieuMuaNVL(@RequestParam("chuThich") String chuThich, @RequestParam("ID") int ID,
			@RequestParam("IDLenhSanXuat") int IDLenhSanXuat, //
			@RequestParam("maPhieu") String maPhieu, @RequestParam("ngayLap") String ngayLap,
			@RequestParam("tenNhanVien") String tenNhanVien, //
			@ModelAttribute LenhSanXuat lenhSanXuat, @ModelAttribute NhanVien nhanVien,
			@ModelAttribute PhieuMuaNVL phieuMuaNVL) {
		lenhSanXuat = lenhSanXuatService.findOneByID(IDLenhSanXuat);
		nhanVien = nhanVienService.findNhanVien(tenNhanVien);

		phieuMuaNVL.setID(ID);
		phieuMuaNVL.setChuThich(chuThich);
		phieuMuaNVL.setLenhSanXuat(lenhSanXuat);
		phieuMuaNVL.setMaPhieu(maPhieu);
		phieuMuaNVL.setNgayLap(ngayLap);
		phieuMuaNVL.setNhanVien(nhanVien);

		phieuMuaNVLService.save(phieuMuaNVL);
		return "redirect:/ListLenhSanXuat_TM";
	}

	@GetMapping("/RemovePhieuMuaNVL/{ID}")
	public String removePhieuMuaNVL(@PathVariable int ID, @ModelAttribute PhieuMuaNVL phieuMuaNVL) {
		phieuMuaNVL = phieuMuaNVLService.findOneByID(ID);
		if (nvlCanDungService.check(phieuMuaNVL) || phieuChiService.check(phieuMuaNVL)) {
			return "redirect:/ListLenhSanXuat_TM";
		} else {
			phieuMuaNVLService.delete(ID);
		}
		return "redirect:/ListLenhSanXuat_TM";
	}

	@GetMapping("/AddPhieuMuaNVL")
	public String AddPhieuMuaNVL(Model model, HttpSession session) {
		String hoTenThuMua = (String) session.getAttribute("hoTenThuMua");
		model.addAttribute("hoTenThuMua", hoTenThuMua);
		return "quanLyThuMua_AddPhieuMuaNVL";
	}

	@GetMapping("/Active_AddPhieuMuaNVL")
	public String active_AddPhieuMuaNVL(@RequestParam("maPhieu") String maPhieu,
			@RequestParam("ngayLap") String ngayLap, @RequestParam("chuThich") String chuThich, //
			@RequestParam("hoTenThuMua") String hoTenThuMua, @ModelAttribute PhieuMuaNVL phieuMuaNVL,
			@ModelAttribute LenhSanXuat lenhSanXuat, //
			HttpSession session, @ModelAttribute NhanVien nhanVien) {
		int IDLenhSanXuat = (int) session.getAttribute("IDLenhSanXuat");
		lenhSanXuat = lenhSanXuatService.findOneByID(IDLenhSanXuat);
		nhanVien = nhanVienService.findNhanVien(hoTenThuMua);
		phieuMuaNVL.setChuThich(chuThich);
		phieuMuaNVL.setLenhSanXuat(lenhSanXuat);
		phieuMuaNVL.setMaPhieu(maPhieu);
		phieuMuaNVL.setNgayLap(ngayLap);
		phieuMuaNVL.setNhanVien(nhanVien);

		phieuMuaNVLService.save(phieuMuaNVL);
		return "redirect:/ListLenhSanXuat_TM";
	}

	@GetMapping("/AddNVLCanDung")
	public String AddNVLCanDung() {
		return "quanLyThuMua_AddNVLCanDung";
	}

	@GetMapping("/Active_AddNVLCanDung")
	public String active_AddNVLCanDung(@RequestParam("soLuong") int soLuong, @RequestParam("tenNVL") String tenNVL,
			HttpSession session, @ModelAttribute Xuong xuong, //
			@ModelAttribute NguyenVatLieu nguyenVatLieu, @ModelAttribute NVLCanDung nvlCanDung,
			@ModelAttribute PhieuMuaNVL phieuMuaNVL) {
		xuong = xuongService.findXuong(1);
		nguyenVatLieu = nguyenVatLieuService.findOneNVLByTenNVL(tenNVL);
		int IDPhieuMuaNVL = (int) session.getAttribute("IDPhieuMuaNVL");
		phieuMuaNVL = phieuMuaNVLService.findOneByID(IDPhieuMuaNVL);

		nvlCanDung.setNguyenVatLieu(nguyenVatLieu);
		nvlCanDung.setPhieuMuaNVL(phieuMuaNVL);
		nvlCanDung.setSoLuong(soLuong);
		nvlCanDung.setXuong(xuong);

		nvlCanDungService.save(nvlCanDung);
		return "redirect:/ListLenhSanXuat_TM";
	}

	@GetMapping("/RemoveNVLCanDung/{ID}")
	public String removeNVLCanDung(@PathVariable int ID, @ModelAttribute NVLCanDung nvlCanDung) {
		nvlCanDung = nvlCanDungService.findOne(ID);

		nvlCanDungService.delete(nvlCanDung);
		return "redirect:/ListLenhSanXuat_TM";
	}

	@GetMapping("/ListPhieuChi/{ID}")
	public String listPhieuChi(@PathVariable int ID, @ModelAttribute PhieuMuaNVL phieuMuaNVL, Model model,
			HttpSession sesion) {
		phieuMuaNVL = phieuMuaNVLService.findOneByID(ID);
		List<PhieuChi> listpc = new ArrayList<PhieuChi>();
		listpc = phieuChiService.findAll(phieuMuaNVL);
		model.addAttribute("pcs", listpc);

		sesion.setAttribute("IDPhieuMuaNVL", ID);
		return "quanLyThuMua_ListPhieuChi";
	}

	@GetMapping("/AddPhieuChi")
	public String AddPhieuChi() {
		return "quanLyThuMua_AddPhieuChi";
	}

	@GetMapping("/Active_AddPhieuChi")
	public String active_AddPhieuMuaNVL(@RequestParam("soPhieu")String soPhieu,@RequestParam("loaiPhieu")String loaiPhieu,//
			@RequestParam("ngay")String ngay,@RequestParam("noiDung")String noiDung,@RequestParam("giaThanh")float giaThanh,//
			@ModelAttribute PhieuChi phieuChi,@ModelAttribute PhieuMuaNVL phieuMuaNVL,HttpSession session ) {
		int IDPhieuMuaNVL=(int) session.getAttribute("IDPhieuMuaNVL");
		phieuMuaNVL=phieuMuaNVLService.findOneByID(IDPhieuMuaNVL);
		
		phieuChi.setGiaThanh(giaThanh);
		phieuChi.setLoaiPhieu(loaiPhieu);
		phieuChi.setNgay(ngay);
		phieuChi.setNoiDung(noiDung);
		phieuChi.setPhieuMuaNVl(phieuMuaNVL);
		phieuChi.setSoPhieu(soPhieu);
		
		phieuChiService.save(phieuChi);
		return "redirect:/ListLenhSanXuat_TM";
	}
	
	@GetMapping("/AditPhieuChi/{ID}")
	public String editPhieuMuaNVL(@PathVariable int ID,@ModelAttribute PhieuChi phieuChi,Model model) {
		phieuChi =phieuChiService.findOne(ID);
		
		model.addAttribute("giaThanh", phieuChi.getGiaThanh());
		model.addAttribute("ID", phieuChi.getID());
		model.addAttribute("loaiPhieu", phieuChi.getLoaiPhieu());
		model.addAttribute("ngay", phieuChi.getNoiDung());
		model.addAttribute("noiDung", phieuChi.getNoiDung());
		model.addAttribute("maPhieuNVL",phieuChi.getPhieuMuaNVL().getMaPhieu());
		model.addAttribute("soPhieu",phieuChi.getSoPhieu());
		return "quanLyThuMua_EditPhieuChi";
	}
	
	@GetMapping("/Active_EditPhieuChi")
	public String active_EditPhieuChi(@RequestParam("giaThanh")float giaThanh,@RequestParam("ID")int ID,@RequestParam("loaiPhieu")String loaiPhieu,//
			@RequestParam("ngay")String ngay,@RequestParam("noiDung")String noiDung,@RequestParam("maPhieuNVL")String maPhieuNVL,//
			@RequestParam("soPhieu")String soPhieu,@ModelAttribute PhieuChi phieuChi,@ModelAttribute PhieuMuaNVL phieuMuaNVL) {
		phieuMuaNVL=phieuMuaNVLService.findOneByMaPhieu(maPhieuNVL);
		phieuChi.setGiaThanh(giaThanh);
		phieuChi.setID(ID);
		phieuChi.setLoaiPhieu(loaiPhieu);
		phieuChi.setNgay(ngay);
		phieuChi.setNoiDung(noiDung);
		phieuChi.setPhieuMuaNVl(phieuMuaNVL);
		phieuChi.setSoPhieu(soPhieu);
		
		phieuChiService.save(phieuChi);
		return "redirect:/ListLenhSanXuat_TM";
	}
	
	@GetMapping("/RemovePhieuChi/{ID}")
	public String removePhieuChi(@PathVariable int ID,@ModelAttribute PhieuChi phieuChi) {
		phieuChiService.delete(ID);
		return "redirect:/ListLenhSanXuat_TM";
	}
}
