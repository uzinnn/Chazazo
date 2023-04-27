package kh.spring.chazazo.review.controller;




import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.chazazo.member.model.service.MemberService;
import kh.spring.chazazo.review.model.dto.ReviewDto;
import kh.spring.chazazo.review.model.service.ReviewService;



@RestController
@RequestMapping
public class ReviewController {
	@Autowired
	private MemberService mService;
	
	@Autowired
	private ReviewService rService;
	

	
	@PostMapping("/postReview")
	public int insertReview(@RequestBody ReviewDto data) {
	
		int result = rService.insertReview(data);
		return result;
	}
	
	@PostMapping("/insertLike") 
	public int insertLike(ReviewDto data) {
		int result = rService.insertLike(data);
		return result;
	}
	@PostMapping("/updateReview") 
	public int updateReview(ReviewDto data) {
		int result = rService.updateReview(data);
		return result;
	}
	
	
	@DeleteMapping("/deleteReview")
	public int deleteReview(ReviewDto data) {
		int result = rService.deleteReview(data);
		return result;
	}
	
	@GetMapping ("/reportReview/{idx}")
	public ModelAndView reportReview(ModelAndView mv, @PathVariable String idx) {

		mv.setViewName("review/reportReview");
		
		return mv;
	}
	
	
	
}
