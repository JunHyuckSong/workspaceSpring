package test;

import org.springframework.stereotype.Component;

@Component//("smartWatch")
public class SmartWatch implements Watch{
	public SmartWatch() {
		System.out.println("����Ʈ��ġ ��ü����");
	}
	public void volumeUp() {
		System.out.println("����Ʈ��ġ�� ���ؼ� �Ҹ�++");
	}
	public void volumeDown() {
		System.out.println("����Ʈ��ġ�� ���ؼ� �Ҹ�--");
	}


}