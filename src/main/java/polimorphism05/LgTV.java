package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv2")	//tv2 클래스생성. spring framework 위치.
public class LgTV implements TV {

	@Autowired	//Speaker 타입의 객체를 찾아서 Speaker 변수에 주입. 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원을 켭니다.");

	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원을 끕니다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeup();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
