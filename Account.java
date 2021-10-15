import java.util.Scanner;

public class Account {
	//Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//Class constructor
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	
	//Deposit money
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Withdraw money
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//Showing previous transaction
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occurred");
		}
	}
	
	//interest of current funds after a number of years
	void calculateInterest(int years) {
		double interestRate = 0.185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate));
		System.out.println("After " + years + " years, your balance will be " + newBalance);
	}
	
	//Main menu function
	void showMenu() {
		char option = '\0';
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your Id is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A-Check your balance");
		System.out.println("B-Make a deposit");
		System.out.println("C-Make a withdrawal");
		System.out.println("D-View previous transaction");
		System.out.println("E-Calculate interest");
		System.out.println("F-Exit");
		
		
		do {
			System.out.println();
			System.out.println("Enter an option");
			char option1 = reader.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//Account balance
			case 'A':
				System.out.println("=============================");
				System.out.println("Balance = $" + balance);
				System.out.println("=============================");
				System.out.println();
				break;
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = reader.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = reader.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("=============================");
				getPreviousTransaction();
				System.out.println("=============================");
				break;
			case 'E':
				System.out.println("Enter how many years of interest: ");
				int years = reader.nextInt();
				calculateInterest(years);
			case 'F':
				System.out.println("==============================");
				break;
			//if they entered invalid char
			default: 
				System.out.println("Invalid input. Please enter A, B, C, D, E, or F.");
				break;
				
			}
			
		} while(option !='F');
		System.out.println("Thank you for banking with us!");
	}
	
	
}
