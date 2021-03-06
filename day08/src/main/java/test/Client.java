package test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		/*BeanFactory factory = new BeanFactory();
		Phone phone = (Phone)factory.getBean(args[0]);
		phone.volumeUp();
		phone.msg();
		 */
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Phone phone = (Phone)factory.getBean("iPhone");
		phone.volumeUp();
		phone.volumeDown();
		phone.msg();
								  // getBean() 메서드는 AbstractApplicationContext에 구현되어 있음
		/*Phone p1 = (Phone)factory.getBean("galaxyPhone"); //갤럭시 생성자
		Phone p2 = (Phone)factory.getBean("galaxyPhone"); //갤럭시 생성자
		Phone p3 = (Phone)factory.getBean("galaxyPhone"); //갤럭시 생성자   하나가 아닌 3개의 생성자가 실행됨.
		 */		
		
		
		// IPhone 객체 만들어서 한 번 테스트 해보기
		/*IPhone p4 = (IPhone)factory.getBean("iPhone");
		System.out.println(p4.getUname()); //티모
		p4.volumeUp();//애플워치를 통해서 소리++ --> iPhone객체를 생성했으므로
		 */
		
		
		CollectionTest ct = (CollectionTest)factory.getBean("ct");
		//Map<String,String> datas = ct.getMembers();
		//List<String> datas = ct.getMemo();
		Set<String> datas = ct.getNameSet();
		/*for (String key : datas.keySet()) {
			System.out.println(key);
			System.out.println(datas.get(key));
		}*/
		for (String data : datas) {
			System.out.println(data); // "바이"가 중복되므로 하나밖에 출력되지 않음
		}
		
		
		factory.close();
	}
}
//코드의 핵심!!
//결합도 낮추기.