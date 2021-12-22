package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("phone") //������ȭ�� ���� ��� @�� ���� -> �ڹ��ڵ��� ������ �پ��� ������
public class Galaxy implements Phone{
	@Autowired
	private Watch watch; //������ ��ȭ�� ���� �߻��� ���� ->.xml
	public Galaxy() {
		System.out.println("������ ������");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();		
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();		
	}
	@Override
	public void msg() {
		System.out.println("������ ���ں�����");
		
	}
}
