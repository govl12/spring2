package polimorphism05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 클라이언트 코드 블락 : 외부에서 객체를 생성해서 주입받을 때 수정하지 않아도 됨.
		
		// 객체 생성을 Spring Framework에서 생성 후 DI를 통해서 객체를 주입
			// 1. XML 파일에서 객체를 생성해서 주입.
				// src/main/resources : 주로 설정에 관련된 내용을 저장하는 경로 (mybatis 매퍼설정, bean의 xml, db connection)
					// applicationContext.xml 	: bean을 셋팅하는 파일 , spring framework에서 생성
			// 2. @(어노테이션)을 사용해서 객체를 생성 후 DI를 통해서 객체를 주입. <=== Spring Boot 를 사용하는 방식
				
				// 프레임워크에..객체화.. 
				//a. @ (어노테이션)을 사용할 수 있도록 설정이 필요함.
					//applicationContext.xml : Bean 구성 파일, 어노테이션을 사용할 수 있도록 설정 필요.(context 등록)
						//<context:component-scan base-package="polimorphism05"></context:component-scan>
				//b. 클래스 위에 @Component(어노테이션) 붙여서 객체를 생성
						//다양한 종류의 클래스가 존재하기 떄문의 클래스의 종류에 따라서 여러 이름의 어노테이션(@)을 붙임.
					//@Component : 일반적인 클래스를 Bean(객체화) 생성
					//@Service : 비즈니스 로직을 처리하는 클래스에 Bean 생성
					//@Repository : 데이터 베이스 연동을 처리하는 DAO 클래스에 생성
					//@Controller : 사용자 요청을 Controller 클래스에 붙여주는 
					//(클래스를 객체로 만들어주는..)
					
				//c. Spring Framework 에서 생성된 객체를 의존성 주입(DI)하는 어노테이션 
					//@Autowired : 해당 타입의 객체를 찾아서 자동으로 할당하는 어노테이션(클래스 변수 위에 할당)
							// 해당타입의 객체가 여러개 존재할 경우 오류가 발생
					//@Qualifier : 특정 객체 이름을 사용해서 불러오는 것, @Autowired와 같이 사용함.
		
					//@inject : 자바에서 제공되는 어노테이션, @Autowired와 동일한 어노테이션(타입으로 객체 적용)
					//@Resource : 자바에서 제공되는 어노테이션. @Autowired + Qualifier 를 하나로 사용함.
		
		
		
		
		//1. Spring Container 구동 
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		//2. Spring 컨테이너로부터 필요한 객체를 LookUp 한다. : DI(객체를 주입)
		TV tv = (TV) factory.getBean("tv3");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
	}

}
