package polimorphism01;
//결합도를 낮추기 위해서 어떻게 해야하는ㄱ ㅏ?
public class SamsungTV {

	// 클래스 블락에 올 수 있는 것 : 1. 생성자, 2. 필드 3. 메소드 4. 내부 클래스
	// 클래스는 객체화 해서 사용가능하다.
	
	//powerOn() 메소드
	public void powerOn() {
		System.out.println("SamsungTV -- 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV -- 전원을 끕니다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV -- 볼륨을 높입니다.");
	}
	public void	volumeDown() {
		System.out.println("SamsungTV -- 볼륨을 줄입니다.");
	}
	
	
	
}
