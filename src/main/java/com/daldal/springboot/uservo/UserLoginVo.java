package com.daldal.springboot.uservo;

public class UserLoginVo {
	private String nickname;
	private int age;
	public UserLoginVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLoginVo(String nickname, int age) {
		super();
		this.nickname = nickname;
		this.age = age;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserLoginVo [nickname=" + nickname + ", age=" + age + "]";
	}
	
}
