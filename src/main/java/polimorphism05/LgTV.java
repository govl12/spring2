package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv2")	//tv2 Ŭ��������. spring framework ��ġ.
public class LgTV implements TV {

	@Autowired	//Speaker Ÿ���� ��ü�� ã�Ƽ� Speaker ������ ����. 
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - ������ �մϴ�.");

	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - ������ ���ϴ�.");
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
