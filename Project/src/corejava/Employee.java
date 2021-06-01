package corejava;

import java.util.Scanner;

//import com.sun.java_cup.internal.runtime.Scanner;


public class Employee{
	private String firstName;
	 private String lastName;
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void validation()
	{
		try {
			if(firstName==null&&lastName==null)
			{
				throw new NullPointerException("Entry Missing");
				
		}
			else
			{
				if(firstName.length()<3&&lastName.length()<3)
				{
					throw new Exception("name should be minimum 3 character");
				}
			}
	}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Enter employee name");
		Scanner sc=new Scanner(System.in);
		String firstName=sc.nextLine();
		String lastName=sc.nextLine();
		Employee a=new Employee(firstName,lastName);
		a.validation();
		
	}
}

 

