package com.Javabean;

import java.io.Serializable;

public class Pet_User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int u_id;
	private String userName;
	private String Mail;
    private String Tel;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	@Override
	public String toString() {
		return "Pet_User [u_id=" + u_id + ", userName=" + userName + ", Mail="
				+ Mail + ", Tel=" + Tel + "]";
	}
    

}
