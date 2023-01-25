package polimorphism03;

public class BeanFactory {

	// Spring Framework이 나오기 이전 디자인 패턴(Factory 패턴)
	// 디자인 패턴 : 유지보수를 쉽게 할 수 잇는 코드를 작성할 수 있는 방법을 정의.
		//Spring Framework 에 디자인 패턴이 녹아있다.
	// Bean : 객체
	// BeanFactory : 객체를 외부에서 생성해서 만들어진 객체를 주입 : 
	
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		}else if (beanName.equals("lg")){
			return new LgTV();
		}
		return null;
	}
	
	
}
