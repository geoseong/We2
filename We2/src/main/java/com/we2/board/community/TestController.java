package com.we2.board.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/board", method = RequestMethod.GET)  // ã�� ��ΰ� ROOT �̰� ���۹���� GET ����̸� 
	public String home(Model model) {   // ���ڷ� locale / model(view���� ����� �����͸� ��� ��ü)
		
		return "home";  // servelt-context.xml �ϴ��� view resolver �κ� ��ο� views �ؿ� home.jsp�� �ִٴ� �� 
	}
	
}
