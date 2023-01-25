package polimorphism03;

public class BeanFactory {

	// Spring Framework�� ������ ���� ������ ����(Factory ����)
	// ������ ���� : ���������� ���� �� �� �մ� �ڵ带 �ۼ��� �� �ִ� ����� ����.
		//Spring Framework �� ������ ������ ����ִ�.
	// Bean : ��ü
	// BeanFactory : ��ü�� �ܺο��� �����ؼ� ������� ��ü�� ���� : 
	
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		}else if (beanName.equals("lg")){
			return new LgTV();
		}
		return null;
	}
	
	
}