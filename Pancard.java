package com.ty_one_to_one_uni1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pancard {
	@Id
	private int pid;
	private String name;
	private String address;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PanCard [pid=" + pid + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
