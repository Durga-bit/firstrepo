package corejava;

import java.util.*;
import java.util.stream.Collectors;

class WWE
{
	private String firstName;
	private String lastName;
	private int weight;
	public WWE(String firstName, String lastName, int weight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String toString()
	{
		return 
				"lastName "+lastName+" ";
	}
}
public class WWEWrestlerImplementation {
	public static void main(String[] args)
	{
		ArrayList<WWE> wwe=new ArrayList<WWE>();
		wwe.add(new WWE("rey","mysterio",110));
		wwe.add(new WWE("Roman","Reigns",200));
		wwe.add(new WWE("Dolph","Ziggler",220));
		wwe.add(new WWE("Drew","Gulak",190));
		WWEWrestlerImplementation.sortFirstName(wwe);
		WWEWrestlerImplementation.printFirstName(wwe);
		System.out.println("count of wrestlers "+wwe.stream().count());
		//System.out.println(wwe.stream().filter(weight->(weight>200).collect(Collectors.summingInt(WWE::getWeight));
	}
	static List<String> printFirstName(ArrayList<WWE> wwe)
	{
		List<String> a=wwe.stream().collect(Collectors.toList());
	}
       static List<WWE> sortFirstName(ArrayList<WWE> wwe)
       {List<WWE> a=wwe.stream().sorted(Comparator.comparing(WWE::getFirstName)).collect(Collectors.toList());
       a.stream().forEach(System.out::print);
       return a;
}
}
