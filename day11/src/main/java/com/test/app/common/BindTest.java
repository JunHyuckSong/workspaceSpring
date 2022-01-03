package com.test.app.common;

class A{
	void func() {
		System.out.println("A에서 출력");
	}
}

class B extends A{
	void func() {
		System.out.println("B에서 출력");
	}
}

class C extends A{
	void func() {
		System.out.println("C에서 출력");
	}
}

public class BindTest {
	
	public static void main(String[] args) {
		
		//추상화 상속 다형성 캡슐화 
		//오버라이딩 -> 동적바인딩을 통해 "다형성" 실현	
		A[] data = new A[2];
		data[0] = new B(); //업캐스팅
		data[1] = new C();
		for (int i = 0; i < data.length; i++) {
			data[i].func();
			// 가장 최근에 구현된(가장 하위클래스의) 메서드를 자동호출하는 현상
			// == 동적바인딩 -> 다형성를 실현했다.
		}
	}
	
}
