package com.we2.board.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/board", method = RequestMethod.GET)  // 찾는 경로가 ROOT 이고 전송방식이 GET 방식이면 
	public String home(Model model) {   // 인자로 locale / model(view에서 사용할 데이터를 담는 객체)
		
		return "home";  // servelt-context.xml 하단의 view resolver 부분 경로에 views 밑에 home.jsp가 있다는 뜻 
	}
	
}
