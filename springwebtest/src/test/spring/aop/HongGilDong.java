package test.spring.aop;

public class HongGilDong implements Human {

	@Override
	public String sayName(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" 이라고 합니다. ");
		return "난 ~~~ 동해번쩍 서해번쩍 " + name+" 이다.";
	}

}
