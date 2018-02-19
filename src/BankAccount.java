/**
 * - creates a BankAccount object with the information passed from the customer object
 * - adds the BankAccount to a list belonging to its created bank
 * - Retrieves BankAccount information rfom account
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class BankAccount {
	public String accountNum;
	public String cust;
	public String bankId;
	public double balance;
	public static int numberOfAccounts = 11;
	public int yearMod = 0;
	
	/**
	 * sets up a bankAccount object 
	 * 
	 * @param actNum the acount number for the bankAccount
	 * @param cId the card Id for the corresponding bankAccounts cashCard
	 * @param custName the customer whome the bankAccount belongs to 
	 * @param bal the balance of the corresponding bankAccount 
	 */
	public BankAccount(String custName,String iD,  double bal)
	{
		cust = custName;
		balance = bal;
		bankId = iD;
		accountNum = String.valueOf(numberOfAccounts);
		Bank dealingBank = Bank.bankToGet(iD);
		setupCard(dealingBank);
	}

	/**
	 * sets up a bank accounts cashCard
	 * 
	 * @param b the bank that is issuing the cashCard
	 */
	public void setupCard(Bank b)
	{
		Calendar cal = Calendar.getInstance();
		Random r1 = new Random();
		int day = r1.nextInt(30- 1 + 1)+ 1;
		int month = r1.nextInt(12-8 + 1) + 8;
		int yearToAdd = 2015;
	
		if(yearMod % 3 == 0)
		{
			yearToAdd = yearToAdd + 0;
			yearMod++;
		}
		else if(yearMod % 3 == 1)
		{
			yearToAdd = yearToAdd + 1;
			yearMod++;
		}
		else if(yearMod % 2 == 2)
		{
			yearToAdd = yearToAdd + 2;
			yearMod++;
		}
		cal.set(yearToAdd, month, day);
		
		Date exDate = cal.getTime();
		
		cashCard newCard = new cashCard(b.getId() + " " + numberOfAccounts , accountNum, "111",  exDate, b.getId());
		b.cashCardList.add(newCard);
		numberOfAccounts = numberOfAccounts + 10;
		yearMod++;
		
		
	}
	
	/**
	 * gets an accounts bankId
	 * 
	 * @return bankId the accounts bank id
	 */
	public String getAccountsBankId()
	{
		return bankId;
	}
	
	/**
	 * get the account number for the bankAccount 
	 * 
	 * @return accountNum the id for the bankAccount 
	 */
	public String getAccountNumber()
	{
		return accountNum;
	}
	
	/**
	 * gets the customer that the bank account belongs to 
	 * 
	 * @return cust the bankAccounts accountHolder 
	 */
	public String getAccountHolder()
	{
		return cust;
	}
	
	/**
	 * gets the accounts balance 
	 * 
	 * @return balance the accounts current balance 
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * withdraw cash from the bank account 
	 * 
	 * @param d the amount to deduct from the bank account 
	 * @return balance after deducting the amount specified 
	 */
	public double withdrawCash(double d)
	{
		balance = getBalance() - d;
		return balance;
	}
	
	/**
	 * create a string identifier for the bankAccount object 
	 * 
	 * @return a string representing the bankAccount object 
	 */
	public String toString()
	{
		return cust + " " + accountNum + " " + balance;
	}
}
