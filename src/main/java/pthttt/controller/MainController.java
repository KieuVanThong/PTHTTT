package pthttt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pthttt.entity.NhanVien;
import pthttt.service.NhanVienService;

@Controller
public class MainController {

	@Autowired
	private NhanVienService nhanVienService;

	@RequestMapping(value = { "/", "/LoginPage" }, method = RequestMethod.GET)
	public String showLogin() {
		return "loginPage";
	}

	@PostMapping("/CheckLogin")
	public String processLogin(@RequestParam("tenDangNhap") String tenDangNhap, 
			@RequestParam("matKhau") String matKhau, @ModelAttribute NhanVien nhanVien, HttpSession session) {

		if (nhanVienService.checkNhanVien(tenDangNhap, matKhau)==true) {
			nhanVien = nhanVienService.findNhanVien(tenDangNhap, matKhau);
			if (nhanVien.getBoPhan().equalsIgnoreCase("QLyKinhDoanh")) {
				session.setAttribute("hoTenKinhDoanh", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/PhieuDatHang";
			} else if (nhanVien.getBoPhan().equalsIgnoreCase("QLyKyThuat")) {
				session.setAttribute("hoTenKyThuat", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/PhieuDatHang_KT";
			} else if (nhanVien.getBoPhan().equalsIgnoreCase("QLySanXuat")) {
				session.setAttribute("hoTenSanXuat", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/ListSanPham_SX";
			} else if (nhanVien.getBoPhan().equalsIgnoreCase("QLyThuMua")) {
				session.setAttribute("hoTenThuMua", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/ListLenhSanXuat_TM";
			} else if (nhanVien.getBoPhan().equalsIgnoreCase("QLyKho")) {
				session.setAttribute("hoTenKho", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/ListThanhPham_Kho";
			} else if (nhanVien.getBoPhan().equalsIgnoreCase("QLy")) {
				session.setAttribute("hoTenQLy", nhanVienService.findNhanVien(tenDangNhap, matKhau).getHoTen());
				return "redirect:/ListNhanVien_QLy";
			}
		}
	
		return "redirect:/LoginPage";
	}

	@GetMapping("/LogOut")
	public String LogOut() {
		return "redirect:/";
	}
}