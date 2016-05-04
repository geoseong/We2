package test.mysite.spring.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//컨트롤러 클래스임.
public class Hello extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("hello");	//뷰 이름
		
		// 여기에 비즈니스 로직을 실행하고 결과를 받아서 mav에 저장
		
		mav.addObject("myhello", "안녕하세요");		// 뷰에서 사용할 데이터 저장
		return mav;
	}
	
}
