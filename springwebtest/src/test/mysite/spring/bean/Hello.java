package test.mysite.spring.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//��Ʈ�ѷ� Ŭ������.
public class Hello extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("hello");	//�� �̸�
		
		// ���⿡ ����Ͻ� ������ �����ϰ� ����� �޾Ƽ� mav�� ����
		
		mav.addObject("myhello", "�ȳ��ϼ���");		// �信�� ����� ������ ����
		return mav;
	}
	
}
