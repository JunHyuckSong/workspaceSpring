package test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("iPhone") // == <bean class="",id="">��ϰ� ���� ���� : IPhone iPhone = new IPhone();
			 // => �⺻�����ڰ� �����ؾ���!!.
			 //"iPhone"�� �߰������ id�� ��밡��
public class IPhone implements Phone{
	@Autowired //"�� �ܺο��� watch�� �ް� �;�"
	//@Resource(name="appleWatch") //name�Ӽ� ��밡��, Ÿ���� �ߺ��� ��� ���
	private Watch watch; //->IoC�� ������ �ڵ�!
	//private String uname;
	public IPhone() {
		System.out.println("������ ������1");
	}
	
	/*public IPhone(Watch watch,String uname) {
		System.out.println("������ ������2");
		this.watch = watch;
		this.uname = uname;
		System.out.println(this.uname);
	}*/
	
	
	public void volumeUp() {
		watch.volumeUp();
	}
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	/*public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}*/

	public void volumeDown() {
		watch.volumeDown();
	}
	public void msg() {
		System.out.println("������ ���ں�����");
	}
	public void initMethod() {
		//�������� �ʱ�ȭ�� �� ó���� �۾��� ���� �޼���
		System.out.println("�������� �ʱ�ȭ�� �� ó���� �۾��� ���� �޼���");
	}
	public void destroyMethod() {
		//�������� ������ �� ó���� �۾��� ���� �޼���
		System.out.println("��������ü ������ �� ó���� �۾��� ���� �޼���");
	}
}