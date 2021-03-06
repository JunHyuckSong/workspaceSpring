package test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("iPhone") // == <bean class="",id="">등록과 같은 설정 : IPhone iPhone = new IPhone();
			 // => 기본생성자가 존재해야함!!.
			 //"iPhone"을 추가해줘야 id로 사용가능
public class IPhone implements Phone{
	@Autowired //"나 외부에서 watch값 받고 싶어"
	//@Resource(name="appleWatch") //name속성 사용가능, 타입이 중복될 경우 사용
	private Watch watch; //->IoC가 구현된 코드!
	//private String uname;
	public IPhone() {
		System.out.println("아이폰 생성자1");
	}
	
	/*public IPhone(Watch watch,String uname) {
		System.out.println("아이폰 생성자2");
		this.watch = watch;
		this.uname = uname;
		System.out.println(this.uname);
	}*/
	
	
	public void volumeUp() {
		watch.volumeUp();
	}
	
	// 어노테이션을 사용하는경우 getter, setter을 굳이 만들어주지 않아도 됨.
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
		System.out.println("아이폰 문자보내기");
	}
	public void initMethod() {
		//아이폰을 초기화할 떄 처리할 작업이 들어가는 메서드
		System.out.println("아이폰을 초기화할 떄 처리할 작업이 들어가는 메서드");
	}
	public void destroyMethod() {
		//아이폰을 삭제할 떄 처리할 작업이 들어가는 메서드
		System.out.println("아이폰객체 삭제될 떄 처리할 작업이 들어가는 메서드");
	}
}
