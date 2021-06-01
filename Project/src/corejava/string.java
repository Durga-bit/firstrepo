package corejava;

import java.util.Scanner;

public class string {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		String[] b=a.split(" ");
		System.out.println("Words in the string->"+b.length);
		System.out.println("Characters in the string->"+a.toCharArray().length);
	}

}
