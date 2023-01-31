package polimorphism05;

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
				
				// �����ӿ�ũ��..��üȭ.. 
				//a. @ (������̼�)�� ����� �� �ֵ��� ������ �ʿ���.
					//applicationContext.xml : Bean ���� ����, ������̼��� ����� �� �ֵ��� ���� �ʿ�.(context ���)
						//<context:component-scan base-package="polimorphism05"></context:component-scan>
				//b. Ŭ���� ���� @Component(������̼�) �ٿ��� ��ü�� ����
						//�پ��� ������ Ŭ������ �����ϱ� ������ Ŭ������ ������ ���� ���� �̸��� ������̼�(@)�� ����.
					//@Component : �Ϲ����� Ŭ������ Bean(��üȭ) ����
					//@Service : ����Ͻ� ������ ó���ϴ� Ŭ������ Bean ����
					//@Repository : ������ ���̽� ������ ó���ϴ� DAO Ŭ������ ����
					//@Controller : ����� ��û�� Controller Ŭ������ �ٿ��ִ� 
					//(Ŭ������ ��ü�� ������ִ�..)
					
				//c. Spring Framework ���� ������ ��ü�� ������ ����(DI)�ϴ� ������̼� 
					//@Autowired : �ش� Ÿ���� ��ü�� ã�Ƽ� �ڵ����� �Ҵ��ϴ� ������̼�(Ŭ���� ���� ���� �Ҵ�)
							// �ش�Ÿ���� ��ü�� ������ ������ ��� ������ �߻�
					//@Qualifier : Ư�� ��ü �̸��� ����ؼ� �ҷ����� ��, @Autowired�� ���� �����.
		
					//@inject : �ڹٿ��� �����Ǵ� ������̼�, @Autowired�� ������ ������̼�(Ÿ������ ��ü ����)
					//@Resource : �ڹٿ��� �����Ǵ� ������̼�. @Autowired + Qualifier �� �ϳ��� �����.
		
		
		
		
		//1. Spring Container ���� 
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� LookUp �Ѵ�. : DI(��ü�� ����)
		TV tv = (TV) factory.getBean("tv3");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
	}

}
