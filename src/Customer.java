/**
 * - sets up a customer and retrieves customer information.
 * - creates bank account using customer information 
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
public class Customer {
	
	public String fName;
	public String lName;
	public String bankName;
	public double balance;
	
	/**
	 * constructs a customer object 
	 * 
	 * @param f customers first name 
	 * @param l customers last name
	 * @param a the customers account numer 
	 * @param ca the customers cashCard number 
	 * @param p the customers passcode to their cashCard
	 * @param b the customers chosen bank 
	 * @param m the customers bank account balance 
	 */
	public Customer(String f, String ln, String b) 
	{
		fName = f;
		lName = ln;
		bankName = b;
		setupAccount(Bank.bankToGet(bankName));
		
	}
	
	/**
	 * adds a bank account to the chosen bank
	 * 
	 * @param b the bank to add the account too
	 */
	public void setupAccount(Bank b)
	{
		BankAccount newAccount = new BankAccount(getName(), getChosenBank(), 40.00);
		String name = bankName;
		b.accountList.add(newAccount);
	}
	
	/**
	 * gets the customers chosen bank
	 * @return returns the bank the customer chose to open account with 
	 */
	public String getChosenBank()
	{
		return bankName;
	}
	
	/**
	 * gets the customers chosen bank
	 * 
	 * @return bankName the name of the customers chosen bank 
	 */
	public String getCustBank()
	{
		return bankName;
	}
	
	/**
	 * get the customers name 
	 * 
	 * @return the customer name 
	 */
	public String getName()
	{
		return (fName + " " + lName);
	}
	
	/**
	 * customer object represented as a screen
	 * 
	 * @return a string identifying the customers information 
	 */
	public String toString()
	{
		return fName + " " + lName + " " + bankName + " " + balance ;
	}
}
