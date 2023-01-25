package polimorphism03;

public interface TV {

	// 메소드를 선언만한다. 모든 메소드는 public abstract (추상적 메소드)가 생략되어 있다.
		//public abstract = 선언부만 있고 구현부는 없는 메소드.
		//자식 클래스에서 메소드 오버라이딩을 사용해서 구현한 메소드를 정의해서 사용.
	
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();

	
}
