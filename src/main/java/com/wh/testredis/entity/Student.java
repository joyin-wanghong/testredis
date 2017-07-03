package com.wh.testredis.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	public int age;
	public String addr;
	public BigDecimal ll;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public BigDecimal getLl() {
		return ll;
	}

	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}

}
