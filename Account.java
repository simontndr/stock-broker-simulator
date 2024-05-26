//This class contains the constructors/methods for Account. 

public class Account {
	private String firstName;
	private String lastName;
	private double balance;
	private int identificationNumber;
	private DynamicCustomerStockArray accountStocks;
	
/*Constructor Account
 *Used to create an instance of the Account Class, calls on another constructor
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Account() {
		this("none","none",0,0);
		
	}//end constructor Account

/*Constructor Account
 *Used to create an instance of the Account Class, calls on another constructor
 *Parameters:
 *	identificationNumber: integer variable assigned to object field identificationNumber
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Account(int identificationNumber) {
		this("none","none",identificationNumber,0);
		
	}//end constructor Account
	
/*Constructor Account
 *Used to create an instance of the Account Class
 *Parameters:
 *	firstName: String variable assigned to object field firstName
 *	lastName: String variable assigned to object field lastName
 *	identificationNumber: integer variable assigned to object field identification Number
 *	balance: double variable assigned to object field balance
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Account(String firstName, String lastName, int identificationNumber, double balance) {
		this.firstName=firstName;
		this.lastName=lastName;
		setIdentificationNumber(identificationNumber);
		setBalance(balance);
		accountStocks= new DynamicCustomerStockArray();
		
	}//end constructor Account

/*Method setBalance
 *Used to mutate object field balance.
 *Throws IllegalArgumentException for negative parameters.
 *Parameters:
 *	balance: double variable assigned to object field balance
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void setBalance(double balance) {
		if (balance<0)
			throw new IllegalArgumentException("cannot have a negative balance!");
		this.balance=balance;
		
	}//end method setBalance
	
/*Method setIdentificationNumber
 *Used to mutate object field identificationNumber
 **Throws IllegalArgumentException for negative parameters.
 *Parameters:
 *	identificationNumber: integer variable assigned to object field identification Number
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void setIdentificationNumber(int identificationNumber) {
		if (identificationNumber<0)
			throw new IllegalArgumentException("invalid ID number!");
		this.identificationNumber=identificationNumber;
		
	}//end method setIdentificationNumber
	
/*Method getFirstName
 *Used to access object field firstName
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */	
	public String getFirstName() {
		return firstName;
		
	}//end method getFirstName
	
/*Method getLastName
 *Used to access object field lastName
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */	
	public String getLastName() {
		return lastName;
		
	}//end method getLastName

/*Method getBalance
 *Used to access object field balance
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */	
	public double getBalance() {
		return balance;
		
	}//end method getBalance
	
/*Method getIdentificationNumber
 *Used to access object field identificationNumber
 *Parameters:
 *none
 *Return Values:
 *integer
 *Local Variables:
 *n/a
 */		
	public int getIdentificationNumber() {
		return identificationNumber;
		
	}//end method getIdentificationNumber

/*Method getAccountStocks
 *Used to access object field accountStocks
 *Parameters:
 *none
 *Return Values:
 *DynamicCustomerStockArray
 *Local Variables:
 *n/a
 */		
	public DynamicCustomerStockArray getAccountStocks() {
		return accountStocks;
		
	}//end method getAccountStocks
	
/*Method fundAccount
 *Used to increase value of object field balance. 
 *Throws IllegalArgumentException for negative parameters.
 *Parameters:
 *	moneyToAdd: double used to hold quantity with which to increase balance
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void fundAccount(double moneyToAdd) {
		if (moneyToAdd<0)
			throw new IllegalArgumentException("cannot increase balance cannot by negative value...");
		balance+=moneyToAdd;
		
	}//end method fundAccount
	
/*Method withdrawFunds
 *Used to decrease value of object field balance
 *Throws IllegalArgumentException for negative parameters.
 *Throws IllegalArgumentException for parameters greater than object balance.
 *Parameters:
 *	moneyToRemove: double used to hold quantity with which to decrease balance
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void withdrawFunds(double moneyToRemove) {
		if (moneyToRemove<0)
			throw new IllegalArgumentException("cannot decrease balance cannot by negative value...");
		if (moneyToRemove>balance)
			throw new IllegalArgumentException("cannot withdraw money greater than total balance");
		balance-=moneyToRemove;
		
	}//end method withdrawFunds
	
/*Method equals
 *Used to determine whether argument is equal to object (identificationNumbers are same)
 *Parameters:
 *	otherAccount: Account object to which current object will be compared
 *Return Values:
 *boolean
 *Local Variables:
 *none
 */	
	public boolean equals(Account otherAccount) {
		return identificationNumber==otherAccount.identificationNumber;
		
	}//end method equals

/*Method toString
 *Used to convert object's fields to String
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */	
	public String toString() {
		return  "\nfirst name: "+firstName
				+"\nlast name: "+lastName
				+"\nID number: "+identificationNumber
				+"\nbalance: "+balance;
		
	}//end method toString
	
}
