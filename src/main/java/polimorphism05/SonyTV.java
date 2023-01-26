package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component// 객체명 지정 안하면 클래스 이름 의 소문자로 생성됨~~
public class SonyTV implements TV {

	
	@Autowired	//Speaker 타입의 객체를 Spring Framework에서 검색해서 자동 주입(DI)
				//BossSpeaker(speaker), SonySpeake(speaker2) < == 두개의 객체 모두 speaker 타입 객체 내포 .
	@Qualifier("speaker2")
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("SonyTV - 전원을 켭니다");

	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV - 전원을 끕니다");

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
