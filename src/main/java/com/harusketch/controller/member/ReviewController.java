package com.harusketch.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.harusketch.entity.Review;
import com.harusketch.service.member.ReviewService;



@Controller("memberReviewController")
@RequestMapping("/member/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	
	@RequestMapping("list")
	public String list(Integer page, Model model) {
		
		/*List<Review> list = service.getReviewList(page);
		
		model.addAttribute("reviews", list);
		*/
		return "member.review.list";
	}
	
	
	@RequestMapping("{id}") //여기 원래 detail
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		/*Review review = service.getReview(id);
		
		model.addAttribute("review", review);*/
		
		return "member.review.detail";
	}
	
	
	@RequestMapping("edit")
	public String edit() {
		
		return "member.review.edit";
	}
	
	
	@RequestMapping(value="reg" , method=RequestMethod.GET)
	public String reg() {
		
		return "member.review.reg";
	}
	
	@RequestMapping(value="reg" , method=RequestMethod.POST)
	//public String reg(String title, String content) {
		public String reg(Review review, MultipartFile file, HttpServletRequest request) { //여기에 Note note 넣어두면 자동으로 setter를 확인해서 담아줌?
		
		String memberId = "newlec";
		ServletContext ctx = request.getServletContext();
	      String path = ctx.getRealPath("/resources/review/"+memberId); //나중에 newlec 대신 회원 아이디를 넣어야함
		File f = new File(path);
		if(!f.exists())
			f.mkdirs();
		
		if(!file.isEmpty())
		try {
			String fname = file.getOriginalFilename();
			InputStream fis = file.getInputStream();
			
			FileOutputStream fos = new FileOutputStream(path+File.separator+fname);
						//path는 물리경로인데 운영체제마다 물리경로를 나타내는기호가 다르다 윈도우는 역슬래쉬 리눅스는 슬래쉬
						//그러므로 file.separator를 써줘서 구분자를 넣어준다.
			
			byte[] buf = new byte[1024];
			
			int size = 0;
			
			while((size = fis.read(buf, 0, 1024)) != -1)
				fos.write(buf, 0, size);
			
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 프로젝트에서는 에러페이지 만들어서 return "redirect:error" 써줘야함
		}
		//file.getSize(); //파일사이즈 가 0kb면 에러처리
		//file.isEmpty(); //파일 첨부안했을 경우도 있으므로 이 조건검사안하면 오류남.
		
		int result = service.insertReview(review);
		
		return "redirect:list"; //list로 가고싶다 하지만 이것은 view가 아니다.
	}
	
	@RequestMapping("data")
	@ResponseBody
	public String data() {
		
		return "안녕하세요"; //이거 view아니야 @ResponseBody붙일테니까 그냥 얘 출력해줘
	}
	
	


}