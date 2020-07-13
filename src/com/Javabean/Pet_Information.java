package com.Javabean;

import java.io.Serializable;

public class Pet_Information implements Serializable{
	private static final long serialVersionUID = 1L;
	private int m_id;
	private String m_name;
	private String m_type;
	private String m_pets;
	private String m_color;
	private Double m_weight;
	private Double m_age;
	private String m_owner;
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_type() {
		return m_type;
	}
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	public String getM_pets() {
		return m_pets;
	}
	public void setM_pets(String m_pets) {
		this.m_pets = m_pets;
	}
	public String getM_color() {
		return m_color;
	}
	public void setM_color(String m_color) {
		this.m_color = m_color;
	}
	public Double getM_weight() {
		return m_weight;
	}
	public void setM_weight(Double m_weight) {
		this.m_weight = m_weight;
	}
	public Double getM_age() {
		return m_age;
	}
	public void setM_age(Double m_age) {
		this.m_age = m_age;
	}
	public String getM_owner() {
		return m_owner;
	}
	public void setM_owner(String m_owner) {
		this.m_owner = m_owner;
	}
	
	
	@Override
	public String toString() {
		return "Pet_Information [m_id=" + m_id + ", m_name=" + m_name
				+ ", m_type=" + m_type + ", m_pets=" + m_pets + ", m_color="
				+ m_color + ", m_weight=" + m_weight + ", m_age=" + m_age
				+ ", m_owner=" + m_owner + "]";
	}
}
