package test.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFirstSpringBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] {"test/spring/bean/applicationContext.xml"}
				);
		
		Greeting greeting=(Greeting) ac.getBean("korean");
		greeting.sayHi();
		
		greeting=(Greeting) ac.getBean("japan");
		greeting.sayHi();
		
		greeting=(Greeting) ac.getBean("american");
		greeting.sayHi();
	}

}
