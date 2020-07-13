package com.Javabean;

import java.io.Serializable;



public class Pet_Info implements Serializable{
	private static final long serialVersionUID = 1L;
	private int p_id;
	private String p_user;
	private String p_tel;
    private String p_type;
    private String p_pet;
    private String p_combo;
    private Double p_price1;
    private String p_other;
    private Double p_price2;
	private String p_notes;
	private String p_time;
    private String p_leavetime;
    private int p_day;
    private int p_hours;
    private Double p_spend;
    private int p_sign;
    private String p_filename;
    private String p_operator;
    private int p_userid;
    
    
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_user() {
		return p_user;
	}
	public void setP_user(String p_user) {
		this.p_user = p_user;
	}
	public String getP_tel() {
		return p_tel;
	}
	public void setP_tel(String p_tel) {
		this.p_tel = p_tel;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_pet() {
		return p_pet;
	}
	public void setP_pet(String p_pet) {
		this.p_pet = p_pet;
	}
	public String getP_combo() {
		return p_combo;
	}
	public void setP_combo(String p_combo) {
		this.p_combo = p_combo;
	}
	public Double getP_price1() {
		return p_price1;
	}
	public void setP_price1(Double p_price1) {
		this.p_price1 = p_price1;
	}
	public String getP_other() {
		return p_other;
	}
	public void setP_other(String p_other) {
		this.p_other = p_other;
	}
	public Double getP_price2() {
		return p_price2;
	}
	public void setP_price2(Double p_price2) {
		this.p_price2 = p_price2;
	}
	public String getP_notes() {
		return p_notes;
	}
	public void setP_notes(String p_notes) {
		this.p_notes = p_notes;
	}
	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	public String getP_leavetime() {
		return p_leavetime;
	}
	public void setP_leavetime(String p_leavetime) {
		this.p_leavetime = p_leavetime;
	}
	public int getP_day() {
		return p_day;
	}
	public void setP_day(int p_day) {
		this.p_day = p_day;
	}
	public int getP_hours() {
		return p_hours;
	}
	public void setP_hours(int p_hours) {
		this.p_hours = p_hours;
	}
	public Double getP_spend() {
		return p_spend;
	}
	public void setP_spend(Double p_spend) {
		this.p_spend = p_spend;
	}
	public int getP_sign() {
		return p_sign;
	}
	public void setP_sign(int p_sign) {
		this.p_sign = p_sign;
	}
	public String getP_filename() {
		return p_filename;
	}
	public void setP_filename(String p_filename) {
		this.p_filename = p_filename;
	}
	public String getP_operator() {
		return p_operator;
	}
	public void setP_operator(String p_operator) {
		this.p_operator = p_operator;
	}
	public int getP_userid() {
		return p_userid;
	}
	public void setP_userid(int p_userid) {
		this.p_userid = p_userid;
	}
	@Override
	public String toString() {
		return "Pet_Info [p_id=" + p_id + ", p_user=" + p_user + ", p_tel="
				+ p_tel + ", p_type=" + p_type + ", p_pet=" + p_pet
				+ ", p_combo=" + p_combo + ", p_price1=" + p_price1
				+ ", p_other=" + p_other + ", p_price2=" + p_price2
				+ ", p_notes=" + p_notes + ", p_time=" + p_time
				+ ", p_leavetime=" + p_leavetime + ", p_day=" + p_day
				+ ", p_hours=" + p_hours + ", p_spend=" + p_spend + ", p_sign="
				+ p_sign + ", p_filename=" + p_filename + ", p_operator="
				+ p_operator + ", p_userid=" + p_userid + "]";
	}
	
	
    
	
	
	
	}
