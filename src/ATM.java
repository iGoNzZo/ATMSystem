/**
 * - ATMSystem user interface
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class ATM {
	public static double maxWithdrawLimit = 50;
	public int enterdPswd;
	public static String ans;
	public static Bank bankInSession;
	public static cashCard currentCardInSession;
	public static double accountBalance;
	public static BankAccount accountToGet;
	public static boolean isPasscodeVarified = false;
	public static boolean isAccountVarified = false;
	public String name;
	
	/**
	 * creates an ATM object and tells the ATM to start the session 
	 * 
	 * @param ATMname
	 */
	public void ATM(String atmName)
	{
		name = atmName;
		sessionStart();
	}
	
	/**
	 * gets the current ATM name from the atm
	 * 
	 * @return name the atms name 
	 */
	public String getATMname()
	{
		return name;
	}
	
	/**
	 * starts the ATM session 
	 */
	public void startTheSession()
	{
		ATM.sessionStart();
	}
	
	/**
	 * starts the ATMSystem user interface 
	 */
 	public static void sessionStart()
	{
		Scanner in = new Scanner(System.in);
		String toGet = "";
		Bank current;
		System.out.println("Choose ATM type. OPTIONS: ATM_A1, ATM_A2, ATM_B1, ATM_B2.");
		ans = in.nextLine();
			if(ans.equals("ATM_A1") | ans.equals("ATM_A2") | ans.equals("atm_a1") | ans.equals("atm_a2"))
			{
				toGet = "A";
				current = Bank.bankToGet(toGet);
				bankInSession = current;
				System.out.println("You choose ATM type for: " + current.getBankName());
			}
			else if(ans.equals("ATM_B1") | ans.equals("ATM_B2") | ans.equals("atm_b1") | ans.equals("atm_b2"))
			{
				toGet = "B";
				current = Bank.bankToGet(toGet);
				bankInSession = current;
				System.out.println("You choose ATM type for: " + current.getBankName());
			}
			else
			{
				System.out.println("You entered an invalid ATM type, Please try again.");
				sessionStart();
			}
		getCashCardNum();
	}
	
 	/**
 	 * gets the cashCard number from the customer 
 	 */
	public static void getCashCardNum(){
		boolean valid = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your cachCard number, or type quit to end the session");
		ans = in.nextLine();
		int j = 0;
		
		if(ans.equals("quit") | ans.equals("QUIT"))
		{
			quitTheDamnThing();
		}
		
		for(int i = 0; i < bankInSession.cashCardList.size(); i++)
		{
				currentCardInSession = bankInSession.cashCardList.get(i);
				String currentCardNum = currentCardInSession.getCardNum();
				if(ans.equals(currentCardNum))
				{
					valid = true;
					j = i;
					break;
				}
		}
		
		if(valid == false)
		{
			System.out.println("Invalid card number, please try again");
			getCashCardNum();
		}
		else if(valid == true)
		{
			Date today = new Date();
			Date cardsDate = currentCardInSession.getExpiration();
			if(cardsDate.compareTo(today) < 0)
			{
				System.out.println("Expired Card");
				getCashCardNum();
			}
			else
			{
				System.out.print("cahCard Accepted");
				getPasscode(currentCardInSession);	//
			}
		}	
	}
	
	/**
	 * asks for a cashCards corresponding passcode
	 * 
	 * @param c the cashCard entered by the customer 
	 */
	private static void getPasscode(cashCard c) {
		Scanner in = new Scanner(System.in);
		cashCard c2 = c;
		System.out.println("Please enter your personal passcode for this CashCard, or type quit to end the session");
		ans = in.nextLine();
		String cardCode = c2.getPasscode();
		
		if(ans.equals(cardCode))
		{
			System.out.println("Passcode Accepted, Access granted..");
			isPasscodeVarified = true;
			displayOptions(c2);
			
		}
		else if(ans.equals("quit") | ans.equals("QUIT"))
		{
			quitTheDamnThing();
		}
		else
		{
			System.out.println("Passcode not accepted, Access denied!");
			getPasscode(c2);
		}
	}
	
	/**
	 * gets an accounts balance and displays it
	 */
	public static void displayBalance()
	{     	
		String get = currentCardInSession.getCardsAccount();
		accountBalance = bankInSession.getAccount(get).getBalance();
	}

	/**
	 * options for the user to chose from 
	 * 
	 * @param c the cashCard to act on
	 */
	public static void displayOptions(cashCard c)
	{
		cashCard c2 = c;
		String get = currentCardInSession.getCardsAccount();
		Scanner in = new Scanner(System.in);
		String action = null;
		String amount = null;
		System.out.println("To withdraw cash from your account, press w, or type quit to end the session");
		action = in.nextLine();
		
		if(action.equals("quit") | action.equals("QUIT"))
		{
			quitTheDamnThing();
		}
		else if(action.equals("w") | action.equals("W"))
		{
			System.out.println("Enter how much money you would like to withdraw from your account...");
			String withdrawAmount = in.nextLine();
			amount = withdrawAmount;
			if(Double.parseDouble(amount) > maxWithdrawLimit)
			{
				System.out.println("Invalid, withdraw amount exceeds max limit, please start transaction over");
				displayOptions(c2);
			}
			else if(Double.parseDouble(amount) > bankInSession.getAccount(get).getBalance())
			{
				System.out.println("entered amoumt exceeds the current accounts balance");
				displayOptions(c2);
			}
			else
			{
				sendRequest(action, amount, c2);
			}
		}
		else if(!action.equals("w") | !action.equals("W"))
		{
			System.out.println("you entered an invalid action");
			displayOptions(c2);
		}
	}
	
	/**
	 * quits the current ATM session 
	 */
	private static void quitTheDamnThing() {
		System.out.println("You ended the session...");
		
	}

	/**
	 * send a request to the bank for action 
	 */
	public static void sendRequest(String action, String amount, cashCard c)
	{
		String toGet = c.getCardsAccount();
		BankAccount cNUm = bankInSession.getAccount(toGet);
		bankInSession.requestForTransaction(action, amount, cNUm);
	}
	/**
	 * 
	 * @return true if passcode and cashCard number have been verified
	 */
	public static boolean isItAllVarified()
	{
		boolean allVarified = false;
		if(isPasscodeVarified == true & isAccountVarified == true)
		{
			allVarified = true;
		}
		return allVarified;
	}
	
	/**
	 * returns the customers balance after competing a successful transaction 
	 * 
	 * @param newAmount the customers new bank account balance 
	 */
	public static void permissionToDispense(double newAmount)
	{
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Your new Account Balance: $ " + df.format(bankInSession.getAccountBalance(currentCardInSession.getCardsAccount())));
		System.out.println("You withdrew: $ " +  df.format(newAmount));
		nextStep();
	}
	
	/**
	 * user decides what to do after completing a successful transaction 
	 */
	public static void nextStep()
	{
		String action = null;
		Scanner in = new Scanner(System.in);
		System.out.println("for another transaction type: another, or  type quit to end session");
		action = in.nextLine();
		if(action.equals("another") | action.equals("ANOTHER"))
		{
			getCashCardNum();
		}
		else if(action.equals("quit") | action.equals("QUIT"))
		{
			quitTheDamnThing();
		}
		else if(!action.equals("quit") | !action.equals("QUIT") | !action.equals("another") | !action.equals("ANOTHER"))
		{
			System.out.println("You entered an invalid action, try again");
			nextStep();
		}
	}
}
