package com.itYan.POJO;

public class Account {
	private Integer id;
	private String name;
	private Integer money;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Account{" +
				"id=" + id + 
				", name='" + name + '\'' + 
				", money" + money + 
				'}';
	}
}
