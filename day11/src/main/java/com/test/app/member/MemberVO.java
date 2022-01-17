package com.test.app.member;

public class MemberVO {
	 private String mid;
	   private String password;
	   private String mname;
	   private String role;
	   public String getMid() {
	      return mid;
	   }
	   public void setMid(String mid) {
	      this.mid = mid;
	   }
	   public String getPassword() {
	      return password;
	   }
	   public void setPassword(String password) {
	      this.password = password;
	   }
	   public String getMname() {
	      return mname;
	   }
	   public void setMname(String mname) {
	      this.mname = mname;
	   }
	   public String getRole() {
	      return role;
	   }
	   public void setRole(String role) {
	      this.role = role;
	   }
	   @Override
	   public String toString() {
	      return "MemberVO [mid=" + mid + ", password=" + password + ", mname=" + mname + ", role=" + role + "]";
	   }

}
