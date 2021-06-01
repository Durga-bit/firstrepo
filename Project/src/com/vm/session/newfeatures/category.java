package com.vm.session.newfeatures;

import java.util.ArrayList;
public class category {
	public static void main(String[] args)
	{
ArrayList<Integer> nums=new ArrayList<Integer>();
nums.add(8);
nums.add(9);
nums.add(3);
nums.add(0);
nums.add(6);
nums.add(2);

nums.stream().sorted().forEach(System.out::println);

	
}
}
