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
								  // getBean() �޼���� AbstractApplicationContext�� �����Ǿ� ����
		/*Phone p1 = (Phone)factory.getBean("galaxyPhone"); //������ ������
		Phone p2 = (Phone)factory.getBean("galaxyPhone"); //������ ������
		Phone p3 = (Phone)factory.getBean("galaxyPhone"); //������ ������   �ϳ��� �ƴ� 3���� �����ڰ� �����.
		 */		
		
		
		// IPhone ��ü ���� �� �� �׽�Ʈ �غ���
		/*IPhone p4 = (IPhone)factory.getBean("iPhone");
		System.out.println(p4.getUname()); //Ƽ��
		p4.volumeUp();//���ÿ�ġ�� ���ؼ� �Ҹ�++ --> iPhone��ü�� ���������Ƿ�
		 */
		
		
		/*CollectionTest ct = (CollectionTest)factory.getBean("ct");
		Map<String,String> datas = ct.getMembers();
		for (String key : datas.keySet()) {
			System.out.println(key);
			System.out.println(datas.get(key));
		}*/
		
		
		
		factory.close();
	}
}
//�ڵ��� �ٽ�!!
//���յ� ���߱�.