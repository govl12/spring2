package polimorphism05;

import org.springframework.stereotype.Component;

//@Component("speaker")	//BossSpeaker(Ÿ��) speaker = new BossSpeaker();
public class BossSpeaker implements Speaker { //BosSpeaker > Speaker ���� 

	@Override
	public void volumeup() {
		System.out.println("BossSpeaker - ������");
	}

	@Override
	public void volumeDown() {
		System.out.println("BossSpeaker - �����ٿ�");
	}

}
