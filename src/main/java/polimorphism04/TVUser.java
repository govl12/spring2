package polimorphism04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ŭ���̾�Ʈ �ڵ� ��� : �ܺο��� ��ü�� �����ؼ� ���Թ��� �� �������� �ʾƵ� ��.
		
		// ��ü ������ Spring Framework���� ���� �� DI�� ���ؼ� ��ü�� ����
			// 1. XML ���Ͽ��� ��ü�� �����ؼ� ����.
				// src/main/resources : �ַ� ������ ���õ� ������ �����ϴ� ��� (mybatis ���ۼ���, bean�� xml, db connection)
					// applicationContext.xml 	: bean�� �����ϴ� ���� , spring framework���� ����
			// 2. @(������̼�)�� ����ؼ� ��ü�� ���� �� DI�� ���ؼ� ��ü�� ����. <=== Spring Boot �� ����ϴ� ���
			
		//1. Spring Container ���� 
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� LookUp �Ѵ�. : DI(��ü�� ����)
		TV tv = (TV) factory.getBean("tv");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
	}

}
