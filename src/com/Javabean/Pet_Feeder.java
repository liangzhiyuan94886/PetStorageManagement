package com.Javabean;

import java.io.Serializable;

public class Pet_Feeder implements Serializable{
	private static final long serialVersionUID = 1L;
	private int f_id;
	private String f_number;
	private String f_name;
	private String f_sex;
	private String f_idcard;
	private String f_tel;
	private String f_address;
	private String f_notes;
	private String f_filename;
	
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_number() {
		return f_number;
	}
	public void setF_number(String f_number) {
		this.f_number = f_number;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_sex() {
		return f_sex;
	}
	public void setF_sex(String f_sex) {
		this.f_sex = f_sex;
	}
	public String getF_idcard() {
		return f_idcard;
	}
	public void setF_idcard(String f_idcard) {
		this.f_idcard = f_idcard;
	}
	public String getF_tel() {
		return f_tel;
	}
	public void setF_tel(String f_tel) {
		this.f_tel = f_tel;
	}
	public String getF_address() {
		return f_address;
	}
	public void setF_address(String f_address) {
		this.f_address = f_address;
	}
	public String getF_notes() {
		return f_notes;
	}
	public void setF_notes(String f_notes) {
		this.f_notes = f_notes;
	}
	public String getF_filename() {
		return f_filename;
	}
	public void setF_filename(String f_filename) {
		this.f_filename = f_filename;
	}
	
	
	@Override
	public String toString() {
		return "Pet_Feeder [f_id=" + f_id + ", f_number=" + f_number
				+ ", f_name=" + f_name + ", f_sex=" + f_sex + ", f_idcard="
				+ f_idcard + ", f_tel=" + f_tel + ", f_address=" + f_address
				+ ", f_notes=" + f_notes + ", f_filename=" + f_filename + "]";
	}
	

}
