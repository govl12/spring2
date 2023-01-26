package polimorphism05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component// ��ü�� ���� ���ϸ� Ŭ���� �̸� �� �ҹ��ڷ� ������~~
public class SonyTV implements TV {

	
	@Autowired	//Speaker Ÿ���� ��ü�� Spring Framework���� �˻��ؼ� �ڵ� ����(DI)
				//BossSpeaker(speaker), SonySpeake(speaker2) < == �ΰ��� ��ü ��� speaker Ÿ�� ��ü ���� .
	@Qualifier("speaker2")
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("SonyTV - ������ �մϴ�");

	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV - ������ ���ϴ�");

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
