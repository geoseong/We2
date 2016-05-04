package test.spring.aop;

public class YuGaunSun implements Human {

	@Override
	public String sayName(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" 이라고 합니다. ");
		return "난 ~~~ 민족의 횃불 " + name+" 이다.";
	}

}
