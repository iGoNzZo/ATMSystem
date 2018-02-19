/**
 * - main for the ATMSystem
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATMSystem {
	
	/**
	 * main for ATMSystem 
	 */
	public static void main(String[] args){
		setterUpper();
		ATM.sessionStart();
	}
	
	/**
	 * sets up the bank accounts and adds customers to the bank
	 */
	public static void setterUpper()
	{
		Bank bankOfA = new Bank("BankofA ", "A");
		Bank bankOfB = new Bank("BankofB ", "B");
		
		Bank.add(bankOfA);
		Bank.add(bankOfB);
		
		Customer c1 = new Customer("Kloe", "Harrell", "A");
		bankOfA.customerList.add(c1);
		
		Customer c2 = new Customer("Hueman", "Gonzalez", "A");
		bankOfA.customerList.add(c2);
		
		Customer c3 = new Customer("Orelia", "Barrientos", "A");
		bankOfA.customerList.add(c3);
		
		Customer c4 = new Customer("Amanda", "Scares", "A");
		bankOfA.customerList.add(c4);
		
		Customer c5 = new Customer("Eddie", "Orozco", "A");
		bankOfA.customerList.add(c5);
		
		Customer c6 = new Customer("Jesse", "Guiterez", "A");
		bankOfA.customerList.add(c6);
		
		Customer c7 = new Customer("Stephanie", "Hawkez", "A");
		bankOfA.customerList.add(c7);
		
		Customer c8 = new Customer("Ramiro", "Chapa", "A");
		bankOfA.customerList.add(c8);
		
		Customer c9 = new Customer("Rob", "Bailey", "A");
		bankOfA.customerList.add(c9);
		
		
		Customer z1 = new Customer("Carly", "Harrell", "B");
		bankOfB.customerList.add(z1);
		
		Customer z2 = new Customer("Adrian", "Barrientos", "B");
		bankOfB.customerList.add(z2);
		
		Customer z3 = new Customer("Steven", "Gonzalez", "B");
		bankOfB.customerList.add(z3);
		
		Customer z4 = new Customer("Aiden", "Hawkez", "B");
		bankOfB.customerList.add(z4);

		Customer z5 = new Customer("Frankie", "Orozco", "B");
		bankOfB.customerList.add(z5);
		
		Customer z6 = new Customer("Eric", "Chapa", "B");
		bankOfB.customerList.add(z6);
		
		Customer z7 = new Customer("Edicus", "Guiterez", "B");
		bankOfB.customerList.add(z7);
		
		Customer z8 = new Customer("Bill", "Bailey", "B");
		bankOfB.customerList.add(z8);
		
		Customer z9 = new Customer("Tony", "Ramon", "B");
		bankOfB.customerList.add(z9);

		System.out.println(bankOfA.getBankName());
		for(int j = 0; j < bankOfA.customerList.size(); j++)
		{
			SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			String custName = bankOfA.customerList.get(j).getName();
			String accNum = bankOfA.accountList.get(j).getAccountNumber();
			String psCode = bankOfA.cashCardList.get(j).getPasscode();
			Date expDate = bankOfA.cashCardList.get(j).getExpiration();
			df.format(expDate);
			System.out.println("Customer:  " + custName  + ", Account Number: " + accNum + ", Passcode: " + psCode + ", expires on: " +  expDate);
		}
			
		System.out.println();
		
		System.out.println(bankOfB.getBankName());
		for(int i = 0; i < bankOfB.customerList.size(); i++)
		{
			SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			String custName = bankOfB.customerList.get(i).getName();
			String accNum = bankOfB.accountList.get(i).getAccountNumber();
			String psCode = bankOfB.cashCardList.get(i).getPasscode();
			Date expDate = bankOfB.cashCardList.get(i).getExpiration();
			df.format(expDate);
			System.out.println("Customer:  " + custName  + ", Account Number: " + accNum + ", Passcode: " + psCode + ", expires on: " +  expDate);
		}
		System.out.println();
	}
}
