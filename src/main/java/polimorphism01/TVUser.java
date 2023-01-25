package polimorphism01;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 유지보수가 어려운 코드 = 결합도가 높다(강결합)
			//1. 코드의 결합도를 느슨하게 해서 유지 보수를 쉽게 하는 코드
				// a. 인터페이스를 사용해서 구현한 객체에서 동일한 메소드 이름을 사용
				// b. 객체 생성을 개발자가 코드내부에서 생성하는 것이 아니라 spring framework에 위임(IOC)
					// 객체(Bean)를 필요한 곳에 주입 (DI)
					// 객체(Bean) : 프레임 워크에서 생성해서 주입.
		
		
		// 객체 생성
		SamsungTV tv = new SamsungTV();
		//메소드 호출		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		System.out.println("=============================");
		//TV 사용자가 SamsungTV에서 LgTV로 바꾸었다.
		
		LgTV tv2 = new LgTV();
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
		
		
	}

}


