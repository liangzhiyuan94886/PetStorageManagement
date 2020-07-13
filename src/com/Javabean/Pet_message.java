package com.Javabean;

import java.io.Serializable;

public class Pet_message implements Serializable{
	private static final long serialVersionUID = 1L;
	private int m_id;
	private String m_username;
	private String m_content;
	private String m_date;
	private int m_sign;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public int getM_sign() {
		return m_sign;
	}
	public void setM_sign(int m_sign) {
		this.m_sign = m_sign;
	}
	@Override
	public String toString() {
		return "Pet_message [m_id=" + m_id + ", m_username=" + m_username
				+ ", m_content=" + m_content + ", m_date=" + m_date
				+ ", m_sign=" + m_sign + "]";
	}
	
	
	

}
