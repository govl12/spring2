package polimorphism01;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���������� ����� �ڵ� = ���յ��� ����(������)
			//1. �ڵ��� ���յ��� �����ϰ� �ؼ� ���� ������ ���� �ϴ� �ڵ�
				// a. �������̽��� ����ؼ� ������ ��ü���� ������ �޼ҵ� �̸��� ���
				// b. ��ü ������ �����ڰ� �ڵ峻�ο��� �����ϴ� ���� �ƴ϶� spring framework�� ����(IOC)
					// ��ü(Bean)�� �ʿ��� ���� ���� (DI)
					// ��ü(Bean) : ������ ��ũ���� �����ؼ� ����.
		
		
		// ��ü ����
		SamsungTV tv = new SamsungTV();
		//�޼ҵ� ȣ��		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		System.out.println("=============================");
		//TV ����ڰ� SamsungTV���� LgTV�� �ٲپ���.
		
		LgTV tv2 = new LgTV();
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
		
		
	}

}


