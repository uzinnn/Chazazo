package kh.spring.chazazo.notice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



import kh.spring.chazazo.common.Pagination;
import kh.spring.chazazo.notice.model.service.NoticeService;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService nService;

	
	@GetMapping("/notice")
	public ModelAndView viewNotice(ModelAndView mv, @RequestParam(required = false, defaultValue = "1") int page) {
		int count = nService.noticeCount();
		Pagination pagination = new Pagination();
		pagination.pageInfo(10, page, count);
		
		mv.addObject("pagination", pagination);
		mv.addObject("noticeList", nService.selectNoticeList(pagination));
		mv.setViewName("member/notice");
		return mv;
	}

}
