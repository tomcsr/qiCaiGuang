package com.txz.Bean;

public class cityBean {

	private int id;
	private int pid;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "cityBean [id=" + id + ", pid=" + pid + ", city=" + city + "]";
	}
}
