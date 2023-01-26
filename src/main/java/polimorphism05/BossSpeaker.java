package polimorphism05;

import org.springframework.stereotype.Component;

//@Component("speaker")	//BossSpeaker(타입) speaker = new BossSpeaker();
public class BossSpeaker implements Speaker { //BosSpeaker > Speaker 내포 

	@Override
	public void volumeup() {
		System.out.println("BossSpeaker - 볼륨업");
	}

	@Override
	public void volumeDown() {
		System.out.println("BossSpeaker - 볼륨다운");
	}

}
