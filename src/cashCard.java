/**
 * - sets up a cashCard using the information passed to it from the BankAccount object
 * - retrieves information stored on the cashCard at setup
 * 
 * @author Steven Gonzalez SSID: 009387092
 * @copyRight ? Hasn't been published
 * version 1
 * September 19, 2015
 */
import java.util.Date;

public class cashCard 
{
	public String cardNum;
	public String passcode;
	public String linkedAccount;
	public String issuedBank;
	public Date exDate;
	
	/**
	 * sets up a cashCard object 
	 * 
	 * @param cNum the number that identifies the cashCard
	 * @param cName the name of the customer whome the cashCard belongs to 
	 * @param lAccount the bankAccount in which the cashCard belongs to 
	 * @param pCode the passcode that allows access to the features of the cashCard.
	 * @param ex the date in which the cashCard will expire on 
	 * @param k the bank who issued the cashCard to the customer 
	 */
	public cashCard(String cNum, String lAccount, String pCode, Date ex, String iD)
	{
		cardNum = cNum;
		linkedAccount = lAccount;
		passcode = pCode;
		exDate = ex;
		issuedBank = iD;
	}
	
	/**
	 * gets the card Number for the cashCard
	 * 
	 * @return cardNum
	 */
	public String getCardNum()
	{
		return cardNum;
	}
	
	/**
	 * gets the cards experation date 
	 * 
	 * @return exDate the date in which the cashCard will expire 
	 */
	public Date getExpiration()
	{
		return exDate;
	}
	
	/**
	 * gets the passcode for for the cashCard
	 * 
	 * @return passcode the pin belonging to the cashcard 
	 */
	public String getPasscode()
	{
		return passcode;
	}
	
	/**
	 * gets the bank id of the bank who issued the cashCard
	 * 
	 * @return issuedBank the bank name who issued the cashCard to the customer 
	 */
	public String issuedBank()
	{
		return issuedBank;
	}
	
	/**
	 * get the account in which the cashCard belongs to 
	 * 
	 * @return linkedAccount the account in which the cashCard is associated with 
	 */
	public String getCardsAccount()
	{
		return linkedAccount;
	}
	
	/**
	 * cashCard objects representation of a string
	 * 
	 * @return the objects representation of a string 
	 */
	public String toString()
	{
		return cardNum + " " + " " + linkedAccount + " " + passcode + " " + exDate + " " + issuedBank; 
	}
}
