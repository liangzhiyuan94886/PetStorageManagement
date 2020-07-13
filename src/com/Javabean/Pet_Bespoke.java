package com.Javabean;

import java.io.Serializable;

public class Pet_Bespoke implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int b_id;
	private int b_userid;
	private String b_username;
	private String b_type;
	private String b_pet;
	private String b_tel;
	private String b_date;
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getB_userid() {
		return b_userid;
	}
	public void setB_userid(int b_userid) {
		this.b_userid = b_userid;
	}
	public String getB_username() {
		return b_username;
	}
	public void setB_username(String b_username) {
		this.b_username = b_username;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public String getB_pet() {
		return b_pet;
	}
	public void setB_pet(String b_pet) {
		this.b_pet = b_pet;
	}
	public String getB_tel() {
		return b_tel;
	}
	public void setB_tel(String b_tel) {
		this.b_tel = b_tel;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	@Override
	public String toString() {
		return "Pet_Bespoke [b_id=" + b_id + ", b_userid=" + b_userid
				+ ", b_username=" + b_username + ", b_type=" + b_type
				+ ", b_pet=" + b_pet + ", b_tel=" + b_tel + ", b_date="
				+ b_date + "]";
	}
	
	
}
