package kh.spring.chazazo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.chazazo.admin.model.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	@GetMapping("/main")
	public ModelAndView viewMain(ModelAndView mv) {
		mv.setViewName("admin/main");
		return mv;
	}
	
	@GetMapping("/member")
	public ModelAndView viewMember(ModelAndView mv) {
		mv.addObject("memberList", aService.selectMemberList());
		mv.setViewName("admin/member");
		return mv;
	}
	
	@GetMapping("/member/{username}")
	public ModelAndView viewMemberOne(ModelAndView mv, @PathVariable String username) {
		mv.addObject("member", aService.selectMemberOne(username));
		mv.setViewName("admin/memberdetails");
		return mv;
	}
	
	@DeleteMapping("/member/{username}")
	public int deleteMember(@PathVariable String username) {
		System.out.println(username);
		int result = aService.deleteMember(username);
		System.out.println(result);
		return result;
	}
	
	
	@GetMapping("/report")
	public ModelAndView viewReport(ModelAndView mv) {
		mv.addObject("reportList", aService.selectReportList());
		mv.setViewName("admin/report");
		return mv;
	}
	
	@GetMapping("/report/{idx}")
	public ModelAndView viewReportOne(ModelAndView mv, @PathVariable String idx) {
		mv.addObject("report", aService.selectReportOne(idx));
		mv.addObject("review", aService.selectReviewContent(idx));
		mv.setViewName("admin/reportdetails");
		return mv;
	}
	
	@GetMapping("/reservation")
	public ModelAndView viewReservation(ModelAndView mv) {
		mv.setViewName("admin/reservation");
		return mv;
	}
	
	@GetMapping("/location")
	public ModelAndView viewLocation(ModelAndView mv) {
		mv.setViewName("admin/location");
		return mv;
	}
	
	@GetMapping("/vehicle")
	public ModelAndView viewVehicle(ModelAndView mv) {
		mv.addObject("vehicleList", aService.selectVehicleList());
		mv.setViewName("admin/vehicle");
		return mv;
	}
	
	@GetMapping("/coupon")
	public ModelAndView viewCoupon(ModelAndView mv) {
		mv.addObject("couponList", aService.selectCouponList());
		mv.setViewName("admin/coupon");
		return mv;
	}
	
	@GetMapping("/coupon/{idx}")
	public ModelAndView viewCoupon(ModelAndView mv, @PathVariable String idx) {
		mv.addObject("coupon", aService.selectCouponOne(idx));
		mv.setViewName("admin/coupondetails");
		return mv;
	}
	
	@GetMapping("/notice")
	public ModelAndView viewNotice(ModelAndView mv) {
		mv.setViewName("admin/member");
		return mv;
	}
	
	@GetMapping("/inquiry")
	public ModelAndView viewInquiry(ModelAndView mv) {
		mv.setViewName("admin/member");
		return mv;
	}
	
	@GetMapping("/statistics")
	public ModelAndView viewStatistics(ModelAndView mv) {
		mv.setViewName("admin/statistics");
		return mv;
	}

}
