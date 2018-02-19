/**
 * - creates a bank object and retrieves bank information
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
import java.util.ArrayList;
import java.util.List;

public class Bank{
	public String bName;
	
	public static List<Bank> bankList = new ArrayList<>();
	public static List<BankAccount> accountList;
	public List<cashCard> cashCardList;
	public List<Customer> customerList;
	public String bankId;
	public static BankAccount accountInSession;
	public static int numberOfAccounts;
	
	/**
	 * creates a bank object
	 * 
	 * @param s the string containing the bank name 
	 * @param iD the id that identified the bank 
	 */
	public Bank(String s, String iD)
	{
		bName = s;
		bankId = iD;
		customerList = new ArrayList<>();
		cashCardList= new ArrayList<>();
		accountList = new ArrayList<>();
		//makeATMs(iD);
	}
	
	/**
	 * makes ATM objects once the bank has been set up
	 * 
	 * @param iD corresponds to the bank who is making the ATMs
	 */
	public void makeATMs(String iD)
	{
		String toCall = "ATM_" + iD;
		ATM atm1= new ATM();
		ATM atm2 = new ATM();
	}
	
	/**
	 * add bank to a bank of lists
	 *
	 * @param b
	 */
	public static void add(Bank b)
	{
		bankList.add(b);
	}
	
	/**
	 * adds a bank account to a banks list of accounts
	 * 
	 * @param chosenb bank chosen by customer
	 * @param newAccount new Account to add
	 */
	public void addBankAccount(String chosenb, BankAccount newAccount)
	{
		for(int i = 0; i < bankList.size(); i++)
		{
			String currentBank = bankList.get(i).getBankName();
			if(chosenb.equals(currentBank))
			{
				accountList.add(newAccount);	
				numberOfAccounts++;
			}
		}
	}
	
	/**
	 * gets the bank with the corresponding iD
	 * 
	 * @param iD the bank id to get
	 * @return bank with the corresponding iD
	 */
	public static Bank bankToGet(String iD)
	{
		boolean got = false;
		String idCheck = iD;
		Bank current; 
		int j = 0;
		
		for(int i = 0; i < bankList.size(); i++)
		{
			current = bankList.get(i);
			if(current.getId().equals(idCheck))
			{
				got = true;
				j=i;
			}
		}
		
		if(got == true)
		{
			return bankList.get(j);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * return the banks Id code 
	 * 
	 * @return bankId
	 */
	public String getId()
	{
		return  bankId;
	}
	
	/**
	 * gets the name of the bank 
	 *
	 *@return bName the name of the bank
	 */
	public String getBankName()
	{
		return bName;
	}

	/**
	 * sends a request to the bank for transaction 
	 * 
	 * @param action the action to perform on the bankAccount
	 * @param amount the amount to be acted on the bankAccount
	 * @param b the bankAccount to carry out the action on
	 */
	public void requestForTransaction(String action, String amount, BankAccount b)
	{
		String act = action;
		double amt = Double.parseDouble(amount);
		if(act.equals("w") | act.equals("W"))
		{
			if(isEverythingVarified() == true)
			{
				b.withdrawCash(amt);
				ATM.permissionToDispense(amt);
			}
		}
	}
	
	/**
	 * checks to see if passcode has been verified by the ATM
	 * 
	 * @return true if all account info has been verified by ATM, returns false if the information has not been verified
	 */
	public static boolean isEverythingVarified()
	{
		boolean check = ATM.isItAllVarified();
		if(check = true)
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * gets an accounts balance
	 * 
	 * @param g //// ?
	 * @return the account in sessions balance 
	 */
	public double getAccountBalance(String g)
	{ 
		return accountInSession.getBalance();
	}
	
	/**
	 * looks for bank account within a bank
	 * 
	 * @param id string iD of the account to look for 
	 * @return accountInSession the bank account to return
	 */
	public BankAccount getAccount(String id)
	{
		for(int i = 0; i < accountList.size()-1; i++)
		{
			BankAccount current = accountList.get(i);
			if(current.getAccountNumber().equals(id))
			{
				accountInSession = current;
			}
		}
		return accountInSession;
	}
	
	/**
	 * returns bankName and Bank id
	 * 
	 * @return bank Namw + bank iD
	 */
	public String toString()
	{
		return bName + bankId;
	}
}