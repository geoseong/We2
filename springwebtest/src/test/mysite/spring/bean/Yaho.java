package test.mysite.spring.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ��Ʈ�ѷ� Ŭ������.
public class Yaho implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("yaho");	// �� �̸�
		
		// ���⿡ ����Ͻ� ������ �����ϰ� ����� �޾Ƽ� mav�� �����մϴ�.
		
		mav.addObject("myyaho", "�ȳ��ϼ���ȣ");	// �信�� ����� ������ ����
		return mav;
	}

}
