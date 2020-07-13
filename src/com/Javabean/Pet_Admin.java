package com.Javabean;

import java.io.Serializable;

public class Pet_Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int a_id;
	private String a_admin;
	private String a_password;
	private String a_number;
	private String a_name;
	private String a_sex;
	private String a_idcard;
	private String a_tel;
	private String a_address;
	private String a_notes;
	private String a_filename;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_admin() {
		return a_admin;
	}
	public void setA_admin(String a_admin) {
		this.a_admin = a_admin;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_number() {
		return a_number;
	}
	public void setA_number(String a_number) {
		this.a_number = a_number;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_sex() {
		return a_sex;
	}
	public void setA_sex(String a_sex) {
		this.a_sex = a_sex;
	}
	public String getA_idcard() {
		return a_idcard;
	}
	public void setA_idcard(String a_idcard) {
		this.a_idcard = a_idcard;
	}
	public String getA_tel() {
		return a_tel;
	}
	public void setA_tel(String a_tel) {
		this.a_tel = a_tel;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public String getA_notes() {
		return a_notes;
	}
	public void setA_notes(String a_notes) {
		this.a_notes = a_notes;
	}
	public String getA_filename() {
		return a_filename;
	}
	public void setA_filename(String a_filename) {
		this.a_filename = a_filename;
	}
	@Override
	public String toString() {
		return "Pet_Admin [a_id=" + a_id + ", a_admin=" + a_admin
				+ ", a_password=" + a_password + ", a_number=" + a_number
				+ ", a_name=" + a_name + ", a_sex=" + a_sex + ", a_idcard="
				+ a_idcard + ", a_tel=" + a_tel + ", a_address=" + a_address
				+ ", a_notes=" + a_notes + ", a_filename=" + a_filename + "]";
	}
	
	

}
