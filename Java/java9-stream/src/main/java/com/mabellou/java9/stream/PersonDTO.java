package com.mabellou.java9.stream;

import java.util.List;
import java.util.Optional;

public class PersonDTO {
	private String name;
	private int age;
	private List<String> orders;
	private Optional<String> carName;

	public PersonDTO(String name, int age, List<String> orders, Optional<String> carName) {
		super();
		this.name = name;
		this.age = age;
		this.orders = orders;
		this.carName = carName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public Optional<String> getCarName() {
		return carName;
	}

	public void setCarName(Optional<String> carName) {
		this.carName = carName;
	}

	public String toString() {
		return "I'm " + name + " (" + age + " years)";
	}
	
}
