package com.Tuc.Jdbc;

import java.util.Comparator;

public class Passenger implements Comparator{
	int age;
	String name;
	String Gender;
	int fare;
	public Passenger(int age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		Gender = gender;
	}
	@Override
	public String toString() {
		return "Passenger [age=" + age + ", name=" + name + ", Gender=" + Gender + "]";
	}
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
