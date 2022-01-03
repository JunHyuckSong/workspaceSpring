package com.test.app.common;

class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	void move() {
		this.x++;
		this.y++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) {
			System.out.println("캐스팅안됨!");
			return false;
		}
		Point p = (Point) obj; // 다운 캐스팅
		if(this.x == p.x && this.y == p.y) {
			return true;
		}
		return false;
	}
	
}

public class BindTest2 {
	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(9, 19);
		p2.move();
		
		if(p1.equals(p2)) {
			
		}else {
			
		}
		
	}
}
