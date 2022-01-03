package com.test.app.common;

class A{
	void func() {
		System.out.println("A���� ���");
	}
}

class B extends A{
	void func() {
		System.out.println("B���� ���");
	}
}

class C extends A{
	void func() {
		System.out.println("C���� ���");
	}
}

public class BindTest {
	
	public static void main(String[] args) {
		
		//�߻�ȭ ��� ������ ĸ��ȭ 
		//�������̵� -> �������ε��� ���� "������" ����	
		A[] data = new A[2];
		data[0] = new B(); //��ĳ����
		data[1] = new C();
		for (int i = 0; i < data.length; i++) {
			data[i].func();
			// ���� �ֱٿ� ������(���� ����Ŭ������) �޼��带 �ڵ�ȣ���ϴ� ����
			// == �������ε� -> �������� �����ߴ�.
		}
	}
	
}
