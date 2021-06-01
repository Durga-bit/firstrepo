package corejava;

public class SavingsAccount {
int balance;
double interest;
public SavingsAccount(int balance, double interest) {
	super();
	this.balance = balance;
	this.interest = interest;
}
void withdraw(int a)
{
	if(balance<a)
	{
		System.out.println("cannot withdraw");
	}
	else {
		balance=balance-a;
		System.out.println("after withdraw "+balance);
	}
}
void deposit(int a)
{
	balance=balance+a;
	System.out.println("after deposit "+balance);
}
void interest()
{
	System.out.println("interest rate is "+interest+"%");
}
public static void main(String[] args)
{
	SavingsAccount savings=new SavingsAccount(5000,3.2);
	savings.withdraw(200);
	savings.deposit(1000);
	savings.interest();
}
}

