package test.spring.aop;

public class HongGilDong implements Human {

	@Override
	public String sayName(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" �̶�� �մϴ�. ");
		return "�� ~~~ ���ع�½ ���ع�½ " + name+" �̴�.";
	}

}
