package test.aspectj.aop;

public aspect Advice {
	pointcut callsay(): call (* GilDong.say(..));
	
	before(): callsay() {
		System.out.println("[before Advice] Welcome");
	}
	
	after(): callsay() {
		System.out.println("[after Advice] Good bye");
	}
}
