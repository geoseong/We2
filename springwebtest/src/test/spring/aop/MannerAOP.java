package test.spring.aop;

public class MannerAOP {

	public void beforeSaying(){
		System.out.println("당신의 이름을 말해 보슈");
	}
	public void afterreturnSaying(){
		System.out.println("아 정말 멋진 분이군여!!!!");
	}
	public void afterSaying(){
		System.out.println("존경 합니다!!!!");
	}
}
