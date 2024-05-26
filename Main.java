/* public class Main
 * Developer: Simon Tenedero
 * Project Start Date: May 1st 2022`
 * Project End Date: May 12th 2022
 *
 *This class contains the main method where program execution begins. The purpose of this 
 *project is to simulate a stock brokerage. Students are prompted with a main menu containing
 *multiple options. Options 1-3 correspond to respective submenus. 
 *
 */

public class Main {
	
/*Method displayMainMenu
 *Used to output the main menu text
 *Parameters:
 *	none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void displayMainMenu() {
		System.out.println("Program Execution Main Menu "
				+ "\n1. Customer Account Management "
				+ "\n2. Stock Management &  Transactions "
				+ "\n3. Generate Reports "
				+ "\n4. Random Market Movement "
				+ "\n5. Cookie Random Catastrophe "
				+ "\n6. Quit");
		
	}//end method displayMainMenu
	
	
/*Method displayMainMenu
 *Used to output the account management sub menu text
 *Parameters:
 *	none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void displayAccountManagementSubMenu() {
		System.out.println("Customer Account Management Submenu"
				+ "\n1. Add Account Holder "
				+ "\n2. Remove Account Holder "
				+ "\n3. Fund Account "
				+ "\n4. Withdraw Funds "
				+ "\n5. Display Account Current Stock Positions"
				+ "\n6. Return to Main Menu");
		
	}//end method displayAccountManagementSubMenu
	
/*Method displayStockManagementAndTransactionsSubMenu
 *Used to output the Stock Management And Transactions sub menu text
 *Parameters:
 *	none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void displayStockManagementAndTransactionsSubMenu() {
		System.out.println("Stock Management & Transactions Submenu"
				+ "\n1. Add new stock to available stocks"
				+ "\n2. Customer purchase of stock "
				+ "\n3. Customer sale of stock "
				+ "\n4. Stock split "
				+ "\n5. Reverse Stock split 1 for 2"
				+ "\n6. Return to Main Menu");
		
	}//end method displayStockManagementAndTransactionsSubMenu
	
/*Method displayGenerateReportsSubMenu
 *Used to output the Generate Reports sub menu text
 *Parameters:
 *	none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void displayGenerateReportsSubMenu() {
		System.out.println("Generate Reports Submenu"
				+ "\n1. View all current holders for a particular stock"
				+ "\n2. Generate all positions for all accounts "
				+ "\n3. Return to Main Menu");
		
	}//end method displayGenerateReportsSubMenu
	
/*Method isAccount
 *Used to determine whether Account argument is an element of the DynamicAccountArray argument
 *Parameters:
 *	myClients: DynamicAccountArray object which will be checked
 *	possibleAccount: Account object with which all elements of 
 *						myClients will be compared to for a match
 *Return Values:
 *boolean
 *Local Variables:
 *	result: boolean variable which holds the method result
 */
	public static boolean isAccount(DynamicAccountArray myClients, Account possibleAccount) {
		boolean result=false;
		if(!myClients.isEmpty()) {
			for (int i=0;i<myClients.getArraySize();i++) {
				if (myClients.getArray()[i].equals(possibleAccount)) {
					result=true;
					break;
					}
			}
		}
		
		return result;
		
	}//end method isAccount
	
/*Method isMarketStock
 *Used to determine whether Stock argument is an element of the DynamicStockArray argument
 *Parameters:
 *	myMarketStocks: DynamicStockArray object which will be checked
 *	possibleStock: Account object with which all elements of 
 *						myMarketStocks will be compared to for a match
 *Return Values:
 *boolean
 *Local Variables:
 *	result: boolean variable which holds the method result
 */
	public static boolean isMarketStock(DynamicStockArray myMarketStocks, Stock possibleStock) {
		boolean result=false;
		if(!myMarketStocks.isEmpty()) {
			for(int i=0;i<myMarketStocks.getArraySize();i++) {
				if (myMarketStocks.getArray()[i].equals(possibleStock)) {
					result=true;
					break;
				}
			}
		}
		return result;
		
	}//end method isMarketStock
	
/*Method isAccountStock
 *Used to determine whether Stock argument is an element of the DynamicCustomerStockArray argument
 *Parameters:
 *	myAccountStocks: DynamicCustomerStockArray object which will be checked
 *	possibleStock: Account object with which all elements of 
 *						myAccountStocks will be compared to for a match
 *Return Values:
 *boolean
 *Local Variables:
 *	result: boolean variable which holds the method result
 */
	public static boolean isAccountStock(DynamicCustomerStockArray myAccountStocks, Stock possibleStock) {
		boolean result=false;
		if(!myAccountStocks.isEmpty()) {
			for(int i=0;i<myAccountStocks.getArraySize();i++) {
				if (myAccountStocks.getArray()[i].equals(possibleStock)) {
					result=true;
					break;
				}
			}
		}
		return result;
		
	}//end method isAccountStock
	
/*Method retrieveAccount
 *Used to retrieve an element of the DynamicAccountArray argument which matches the Account argument
 *Throws an IllegalArgumentException if the Account argument is not within the array
 *Parameters:
 *	myClients: DynamicAccountArray object which will be checked
 *	accountID: Account object with which all elements of 
 *						myClients will be compared to for a match
 *Return Values:
 *Account 
 *Local Variables:
 *	result: Account variable which holds the method result
 */
	public static Account retrieveAccount(DynamicAccountArray myClients, Account accountID) {
		Account result= new Account();
		if (!isAccount(myClients,accountID))
			throw new IllegalArgumentException("not an account!");
		for (int i=0;i<myClients.getArraySize();i++) {
			if (myClients.getArray()[i].equals(accountID))
				result=myClients.getArray()[i];
		}
		return result;
		
	}//end method retrieveAccount
	
/*Method retrieveMarketStock
 *Used to retrieve an element of the DynamicStockArray argument which matches the Stock argument
 *Throws an IllegalArgumentException if the Stock argument is not within the array
 *Parameters:
 *	myMarketStocks: DynamicStockArray object which will be checked
 *	stockTicker: Stock object with which all elements of 
 *						myMarketStocks will be compared to for a match
 *Return Values:
 *Stock
 *Local Variables:
 *	result: Stock variable which holds the method result
 */
	public static Stock retrieveMarketStock(DynamicStockArray myMarketStocks, Stock stockTicker) {
		Stock result=new Stock();
		if(!isMarketStock(myMarketStocks,stockTicker))
			throw new IllegalArgumentException("not a stock!");
		for(int i=0;i<myMarketStocks.getArraySize();i++) {
			if(myMarketStocks.getArray()[i].equals(stockTicker))
				result=myMarketStocks.getArray()[i];
		}
		return result;
		
	}//end method retrieveMarketStock
	
/*Method retrieveMarketStock
 *Used to retrieve an element of the DynamicCustomerStockArray argument which matches the Stock argument
 *Throws an IllegalArgumentException if the Stock argument is not within the array
 *Parameters:
 *	myAccountStocks: DynamicCustomerStockArray object which will be checked
 *	stockTicker: Stock object with which all elements of 
 *						myAccountStocks will be compared to for a match
 *Return Values:
 *CustomerStock
 *Local Variables:
 *	result: CustomerStock variable which holds the method result
 */
	public static CustomerStock retrieveCustomerStock(DynamicCustomerStockArray myAccountStocks, 
														Stock stockTicker) {
		CustomerStock result=new CustomerStock();
		if(!isAccountStock(myAccountStocks,stockTicker))
			throw new IllegalArgumentException("not within the account stock!");
		for(int i=0;i<myAccountStocks.getArraySize();i++) {
			if(myAccountStocks.getArray()[i].equals(stockTicker))
				result=myAccountStocks.getArray()[i];
		}
		return result;
		
	}//end method retrieveCustomerStock
	
/*Method generatePositiveOrNegative
 *Used to randomly return +/- 1
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public static double generatePositiveOrNegative() {
		return Math.pow(-1,Util.randomIntBetween(0,1));
		
	}//end method generatePositivevOrNegative
	
/*Method generateRandomStockChange
 *Used to randomly generate a random double between -10 to 10 (inclusive)
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *	result: double variable used to hold result
 */
	public static double generateRandomStockChange() {
		double result= generatePositiveOrNegative()*Util.randomIntBetween(200, 1000)*Math.pow(10, -2);
		return Util.roundOff(result,2);
		
	}//end method generateRandomStockChange
	
/*Method fillDoubleArray
 *Used to initialize the double[] argument with method generateRandomStockChange
 *Parameters:
 *	myPercentsOfChange: double [] which will be initialized by the method
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void fillDoubleArray(double[] myPercentsOfChange) {
		for (int i=0;i<myPercentsOfChange.length;i++) {
			myPercentsOfChange[i]=generateRandomStockChange();
		}
		
	}//end method fillDoubleArray
	
/*Method fillDoubleArrayCatastrophe
 *Used to initialize the double[] argument with -50
 *Parameters:
 *	arrayOfFiftyPercents: double [] which will be initialized by the method
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void fillDoubleArrayCatastrophe(double [] arrayOfFiftyPercents) {
		for(int i=0;i<arrayOfFiftyPercents.length;i++) {
			arrayOfFiftyPercents[i]=-50;
		}
		
	}//end method fillDoubleArrayCatastrophe
	
/*Method updateMarketStocksValue
 *Used to change the MarketCostPerShare fields of elements in the DynamicStockArray argument 
 *Parameters:
 *	availableStocks: DynamicStockArray in which it's elements' fields 
 *						MarketCostPerShare will be mutated
 *	myPercentsOfChange: double [] which will be used to create factorOfChange variable
 *Return Values:
 *void
 *Local Variables:
 * 	factorOfChange: double variable used to change an element's MarketCostPerShare 
 * 					field with the .simulateMarketMovement method of the Stock class.
 */
	public static void updateMarketStocksValue(DynamicStockArray availableStocks, double[] myPercentsOfChange) {
		if (!availableStocks.isEmpty()) {
			for (int i=0;i<availableStocks.getArraySize();i++) {
			double factorOfChange=1+myPercentsOfChange[i]*Math.pow(10, -2);
			factorOfChange=Util.roundOff(factorOfChange,4);
			availableStocks.getArray()[i].simulateMarketMovement(factorOfChange);
			}
		}
		
	}//end method updateMarketStocksValue
	
/*Method updateAccountStocksValue
 *Used to check the DynamicCustomerStockArray of each element in the DynamicAccountArray argument.
 *If an element in the DynamicCustomerStockArray matches an element in the DynamicStockArray argument, 
 *the marketCostPerShare will be updated to match the latter.
 *Parameters:
 *	availableStocks: DynamicStockArray which will serve as a reference point when updating MarketCostPerShare
 *	myClients: DynamicAccountArray which will be updated. 
 *Return Values:
 *void
 *Local Variables:
 * 	stockToSearchFor: Stock variable which is being searched for within the DynamicAccountArray
 */
	public static void updateAccountStocksValue(DynamicStockArray availableStocks, DynamicAccountArray myClients) {
		if(!(availableStocks.isEmpty() || myClients.isEmpty())) {
			for (int i=0;i<availableStocks.getArraySize();i++) {
				Stock stockToSearchFor=availableStocks.getArray()[i];
				for (int j=0;j<myClients.getArraySize();j++) {
					DynamicCustomerStockArray currentCustomerStocksToCheck = myClients.getArray()[j].getAccountStocks();
					if (isAccountStock(currentCustomerStocksToCheck,stockToSearchFor)) {
						retrieveCustomerStock(currentCustomerStocksToCheck,stockToSearchFor).setMarketCostPerShare(stockToSearchFor.getMarketCostPerShare());
						retrieveCustomerStock(currentCustomerStocksToCheck,stockToSearchFor).updateMarketValue();
					}
				}
			}
		}
		
		
	}//end method updateAccountStocksValue
	
/*Method simulateMarketMovement
 *Calls on the methods updateMarketStocksValue and updateAccountStocksValue 
 *to change the marketCostPerShare of the available stocks, and the respective instances of those stocks within the client array
 *Parameters:
 *	myPercentsOfChange: double [] which will serve as a reference point when update availableStocks
 *	availableStocks: DynamicStockArray which will serve as a reference point when updating myClients
 *	myClients: DynamicAccountArray which will be updated. 
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public static void simulateMarketMovement(DynamicStockArray availableStocks, DynamicAccountArray myClients, double [] myPercentsOfChange) {
		updateMarketStocksValue(availableStocks,myPercentsOfChange);
		updateAccountStocksValue(availableStocks,myClients);
		
	}//end method simulateMarketMovement
	
/*Method sellAllAccountStocks
 *Used to obtain the CustomerStocks within the Account argument, 
 *then output messages selling the shares at market value. 
 *The elements within the DynamicStockArray argument are decreased in terms of quantity to reflect this.
 *Parameters:
 *	availableStocks: DynamicStockArray which will be updated
 *	accountToRemove: Account object from which the "selling" messages will derive. 
 *Return Values:
 *void
 *Local Variables:
 *	stockToSearchFor: CustomerStock variable which is being searched for within the availableStocks
 */
	public static void sellAllAccountStocks(DynamicStockArray availableStocks, Account accountToRemove) {
		if (!accountToRemove.getAccountStocks().isEmpty()){
			for (int i=0;i<accountToRemove.getAccountStocks().getArraySize();i++) {
					CustomerStock stockToSearchFor=accountToRemove.getAccountStocks().getArray()[i];
					for (int j=0;j<availableStocks.getArraySize();j++) {
						if(availableStocks.getArray()[j].equals(stockToSearchFor)) {
							availableStocks.getArray()[j].decreaseQuantity(stockToSearchFor.getQuantity());
							System.out.println(stockToSearchFor.getQuantity()+" share(s) of "+stockToSearchFor.getStockName()+" sold for "+stockToSearchFor.getMarketValue());
						}
					}
				}
		}
		
	}//end method sellAllAccountStocks
	
	
/*Method obtainAllAccountNameAndID
 *Used to obtain the name and identificationNumber of the elements within the DynamicAccountArray Argument
 *as a table 
 *Parameters:
 *	myClients: DynamicAccountArray from which the elements will be searched.
 *Return Values:
 *void
 *Local Variables:
 *	currentAccount: Account variable from which the name and identificationNumber will be output.
 */
	public static String obtainAllAccountNameAndID(DynamicAccountArray myClients) {
		String temp="";
		if(!myClients.isEmpty()) {
			temp+=String.format("%s %10s %n", "Account Number","Full Name");
			for (int i=0;i<myClients.getArraySize();i++) {
				Account currentAccount=myClients.getArray()[i];
				temp+=String.format("%d %25s %n", 
								currentAccount.getIdentificationNumber(),
								currentAccount.getFirstName()+" "+currentAccount.getLastName());
			}	
		}
		return temp;
	}//end method obtainAllAccountNameAndID
	
/*Method copyStockContents
 *Used to create a new instance of DynamicStockArray 
 *composed of new instances of Stock matching the elements within DynamicStockArray argument
 *Parameters:
 *	availableStocks: DynamicStockArray which will be copied
 *Return Values:
 *DynamicStockArray
 *Local Variables:
 *	temp: DynamicStockArray object which will be filled.
 *	originalStock: Stock object which will be copied
 *	copyOfStock: Stock object which contains copies of the fields within originalStock.
 */
	public static DynamicStockArray copyStockContents(DynamicStockArray availableStocks) {
		 DynamicStockArray temp = new DynamicStockArray();
		 for (int i=0;i<availableStocks.getArraySize();i++) {
			 Stock originalStock=availableStocks.getArray()[i];
			 Stock copyOfStock = new Stock(originalStock.getStockName(),originalStock.getTicker(),originalStock.getMarketCostPerShare(),originalStock.getQuantity());
			 temp.addEntry(copyOfStock);
		 }
		 
		 return temp;
		
	}//end method copyStockContents
	
/*Method obtainMarketMovementTable
 *Used to create a table of the stock values prior to and after market movement, alongside the percent of increase/decrease
 *Parameters:
 *	availableStocksPriorToMovement: DynamicStockArray used to create the column of market values prior to movement
 *	availableStocks: DynamicStockArray used to create the column of market values post movement
 *	myPercentsOfChange: double[] used to create column of percent changes
 *Return Values:
 *String
 *Local Variables:
 *	temp: String variaible used to hold the result
 *	stockPriorToMovement: derived from availableStocksPriorToMovement. Object Market Value is formatted within the temp.
 *	stockPostMovement: derived from availableStocks. Object Market Value is formatted within the temp.
 */
	public static String obtainMarketMovementTable(DynamicStockArray availableStocksPriorToMovement, 
													DynamicStockArray availableStocks, 
													double[] myPercentsOfChange) {
		String temp=String.format("%s %s %20s %22s %19s %n", 
									"Ticker: ",
									"Stock Name", 
									"Percent Change", 
									"Original Market Value",
									" New Market Price");
		
		for (int i=0;i<availableStocks.getArraySize();i++) {
			Stock stockPriorToMovement = availableStocksPriorToMovement.getArray()[i];
			Stock stockPostMovement = availableStocks.getArray()[i];
			temp+=String.format("%s %20s %13.2f %18.2f %18.2f %n", stockPriorToMovement.getTicker(),
												stockPriorToMovement.getStockName(),
												myPercentsOfChange[i],
												stockPriorToMovement.getMarketCostPerShare(),
												stockPostMovement.getMarketCostPerShare());
		}
		
		return temp;
		
	}//end method obtainMarketMovementTable
	
/*Method obtainMarketStocksTable
 *Used to output the fields of the elements within the DynamicStockArray argument as a table
 *Parameters:
 *	availableStocks: DynamicStockArray from which the table will derive
 *Return Values:
 *String
 *Local Variables:
 *	temp: String variable which holds the result (given availableStocks is not empty)
 *	currentStock: Stock variable from which fields will be formatted to table
 */
	public static String obtainMarketStocksTable(DynamicStockArray availableStocks) {
		//fix formatting
		if(availableStocks.isEmpty())
			return "No stocks under brockerage";
		
		String temp=String.format("%s %15s %15s %20s %n", 
				"Ticker: ",
				"Stock Name", 
				"Market Price", 
				"Outstanding Shares");
		
		for (int i=0;i<availableStocks.getArraySize();i++) {
			Stock currentStock= availableStocks.getArray()[i];
			temp+=String.format("%s %20s %13.2f %10d %n", currentStock.getTicker(),
														currentStock.getStockName(),
														currentStock.getMarketCostPerShare(),
														currentStock.getQuantity());
		}
		
		return temp;
		
	}//end method obtainMarketStocksTable
	
/*Method obtainAccountStocksTable
 *Used to output the fields of the customerStock within the Account argument as a table
 *Parameters:
 *	accountToSeekInfo: Account object from which the table will derive
 *Return Values:
 *String
 *Local Variables:
 *	temp: String variable which holds the result (given accountStocks is not empty)
 *	clientStocks: DynamicCustomerStockArray object in which it's elements' fields will be searched
 *	currentStock: Stock object from which fields will be formatted to table
 */
	public static String obtainAccountStocksTable(Account accountToSeekInfo) {
		//fix formatting
		if(accountToSeekInfo.getAccountStocks().isEmpty())
			return "Client does not own any stock";
		
		String temp=String.format("%s %15s %20s %20s %15s %15s %15s %n", 
				"Ticker: ",
				"Stock Name", 
				"Market Cost/Share", 
				"Average Cost/Share",
				"Market Value",
				"Book Value",
				"Owned Shares");
		
		DynamicCustomerStockArray clientStocks=accountToSeekInfo.getAccountStocks();
		
		for (int i=0;i<clientStocks.getArraySize();i++) {
			CustomerStock currentStock= clientStocks.getArray()[i];
			temp+=String.format("%s %22s %8.2f %20.2f %20.2f %16.2f %10d %n", 
											currentStock.getTicker(),
											currentStock.getStockName(),
											currentStock.getMarketCostPerShare(),
											currentStock.getAverageCostPerShare(),
											currentStock.getMarketValue(),
											currentStock.getBookValue(),
											currentStock.getQuantity());
		}
		
		return temp;
		
	}//end method obtainAccountStocksTable
	
/*Method obtainAccountStocksTable
 *Used to output the "all holders" table. CustomerStock from the DynamicAccountArray argument 
 *matching the Stock argument will be included within the table, alongside the corresponding fields.
 *Parameters:
 *	myClients: DynamicAccountArray object from which the table will derive
 *	stockToSearchFor: Stock object which is searched for within myClients
 *Return Values:
 *String
 *Local Variables:
 *	ownedByAnyAccount: boolean variable used to check whether stockToSearchFor 
 *						is found within myClients at least once
 *	result: String variable which holds the result (given ownedByAnyAccount is false)
 *	currentAccount: Account variable which is being search currently
 *	currentAccountStocks: DynamicCustomerStockArray created from currentAccount object
 */
	public static String obtainAllHoldersTable(DynamicAccountArray myClients, Stock stockToSearchFor) {
		boolean ownedByAnyAccount=false;
		
		String result=String.format("%s %15s %20s %25s %n","Client ID","Client Name","Number of Shares","Client's Average Cost");
		
		for(int i=0;i<myClients.getArraySize();i++) {
			Account currentAccount=myClients.getArray()[i];
			DynamicCustomerStockArray currentAccountStocks=currentAccount.getAccountStocks();
			
			if (isAccountStock(currentAccountStocks,stockToSearchFor)) {
				ownedByAnyAccount=true;
				CustomerStock ownedStock = retrieveCustomerStock(currentAccountStocks,stockToSearchFor);
				result+=String.format("%d %20s %8d %22.2f %n" ,
													currentAccount.getIdentificationNumber(),
													currentAccount.getFirstName()+" "+currentAccount.getLastName(),
													ownedStock.getQuantity(),
													ownedStock.getAverageCostPerShare());
				}	
		
		}
		
		if(!ownedByAnyAccount)
			return "stock is not owned by any clients";
		
		return result;
		
				
	}//end method obtainAllHoldersTable
	
/*Method isAlreadyTicker
 *Used to determine weather String argument matches any tickers within DynamicStockArray argument
 *Parameters:
 *	myStocks: DynamicStockArray object which is being searched
 *	input: String variable which is compared to tickers of elements in myStocks
 *Return Values:
 *boolean
 *Local Variables:
 *	currentStock: Stock variable which is being checked for matching String argument
 */
	public static boolean isAlreadyTicker(DynamicStockArray myStocks, String input) {
		boolean result=false;
		
		for(int i=0;i<myStocks.getArraySize();i++) {
			Stock currentStock=myStocks.getArray()[i];
			if (currentStock.getTicker().equalsIgnoreCase(input)) {
				result=true;
				break;
			}
		}
		
		return result;
		
	}//end method isAlreadyTicker
	
/*Method inputNewTicker
 *Used to ensure user does not enter an already existing ticker. 
 *Also checks that user enters a ticker matching proper conventions (ie. only letters, length of 3)
 *Parameters:
 *	myStocks: DynamicStockArray object which is being checked by method isAlreadyTicker
 *	prompt: String variable which will be output to screen prior to requesting user input
 *Return Values:
 *String
 *Local Variables:
 *	valid: boolean variable which controls loop.
 *	result: String variable which holds result
 */
	public static String inputNewTicker(DynamicStockArray myStocks, String prompt) {
		boolean valid=false;
		String result="";
		
		while(!valid) {
			result=Util.inputLine(prompt);
			result=result.toUpperCase();
			if(Util.isAlphabetic(result) && result.length()==3) {
				if(!isAlreadyTicker(myStocks,result))
					valid=true;
				else
					System.out.println("Ticker already exists! please try again...");
			}
			else
				System.out.println("Tickers are made of 3 letters...");
		}
		
		return result;
		
	}//end method inputNewTicker
	
	public static void main(String[] args) {
		DynamicAccountArray myClients = new DynamicAccountArray();
		DynamicStockArray availableStocks = new DynamicStockArray();
		
		int latestAccountID=1000;
		int mainMenuChoice=0;
		int subMenuChoice=0;
		
		//2 accounts are automatically added to myClients
		Account firstAccount = new Account("Simon","Tenedero",latestAccountID,15750);
		latestAccountID+=1;
		Account secondAccount = new Account("Cookie","Monster",latestAccountID,18910);
		latestAccountID+=1;
		
		myClients.addEntry(firstAccount);
		myClients.addEntry(secondAccount);
		
		//2 stocks are automatically added to availableStocks
		Stock firstStock = new Stock("Slay Corp.","SLY",15.75);
		Stock secondStock = new Stock("Duck Holdings inc.","DHI",45.60);
		
		availableStocks.addEntry(firstStock);
		availableStocks.addEntry(secondStock);
		
		//MAIN MENU
		//encompasses all other sub menus
		while(true) {
			displayMainMenu();
			
			mainMenuChoice=Util.inputIntegerBetween("Select an option ",1,6);
			
			//ACCOUNT MANAGEMENT
			while(mainMenuChoice==1) {
				displayAccountManagementSubMenu();
				
				subMenuChoice=Util.inputIntegerBetween("Submenu selection: ",1,6);
				
				//add an account
				if (subMenuChoice==1) {
					//account IDs are automatically assigned
					Account addAccount= new Account(
							Util.inputLine("\nfirst name: "),
							Util.inputLine("\nlast name: "),
							latestAccountID,
							Util.inputDoubleLow("\nEnter Account Balance: ",0));
					
					if(Util.obtainYesNo("Do you wish to confirm these changes? (y/n) ")=='y') {
						myClients.addEntry(addAccount);
						latestAccountID+=1;
						//increased to ensure no duplicated IDs
					}
					else
						System.out.println("no new account created...");
						
					
				}
				
				//remove an account
				else if (subMenuChoice==2) {
					System.out.println(obtainAllAccountNameAndID(myClients));
					
					//temporary account object is created, with the user input ID
					Account accountIDToRemove= new Account(Util.inputInteger("Enter an account ID to remove: "));
					
					//check if an account within myClients
					if (isAccount(myClients,accountIDToRemove)) {
						
						if(Util.obtainYesNo("Do you wish to confirm these changes? (y/n)")=='y') {
						Account accountToRemove = retrieveAccount(myClients,accountIDToRemove);
						
						//updates availableStocks before removing the account from myClients
						sellAllAccountStocks(availableStocks,accountToRemove);
						myClients.removeEntry(accountToRemove);
						}
						else
							System.out.println("no account removed...");
				
					}
					else
						System.out.println("not an account ID");
				}
				
				//fund an account
				else if (subMenuChoice==3) {
					
					//temp. account object
					Account accountToFund= new Account(Util.inputInteger("Enter an account ID: "));
					
					//check if real account
					if (isAccount(myClients,accountToFund)) {
						double moneyToAdd = Util.inputDoubleLow("Enter how much money to add: ", 0);
						
						if(Util.obtainYesNo("Do you wish to confirm these changes? (y/n)")=='y') {
						retrieveAccount(myClients,accountToFund).fundAccount(moneyToAdd);
						}
						else
							System.out.println("no money added to account...");
					}
					else
						System.out.println("not an account ID");
				}
				
				//withdraw funds from an account
				else if (subMenuChoice==4) {
					
					//temp. account object
					Account accountToWithdrawFunds= new Account(Util.inputInteger("Enter an account ID: "));
					
					//check if real account
					if (isAccount(myClients,accountToWithdrawFunds)) {
						
						//ensure that user cannot withdraw more than what is actually stored in the account
						double moneyToAdd = Util.inputDoubleBetween("Enter how much money to withdraw: ",
																	0,retrieveAccount(myClients,accountToWithdrawFunds).getBalance());
						
						if(Util.obtainYesNo("Do you wish to confirm these changes? (y/n)")=='y') {
						retrieveAccount(myClients,accountToWithdrawFunds).withdrawFunds(moneyToAdd);
						}
						else
							System.out.println("no money withdrawn from account...");
					}
					else
						System.out.println("not an account ID");
				}
				
				//display all stock positions
				else if (subMenuChoice==5) {
					System.out.println(obtainAllAccountNameAndID(myClients));
					
					Account accountIDToSeekInfo= new Account(Util.inputInteger("Enter an account ID: "));
					
					if (isAccount(myClients,accountIDToSeekInfo)) {
						
						Account accountToSeekInfo = retrieveAccount(myClients,accountIDToSeekInfo);
						
						System.out.println(obtainAccountStocksTable(accountToSeekInfo));
						
						}
					
					else
						System.out.println("not an account ID");
				}
				
				//quit account management sub menu
				else
					break;
			}
			
			
			//STOCK MANAGEMENT 
			while(mainMenuChoice==2) {
				displayStockManagementAndTransactionsSubMenu();
				
				subMenuChoice=Util.inputIntegerBetween("Submenu selection: ",1,6);
				
				//add a stock to list
				if (subMenuChoice==1) {
					Stock tempStock = new Stock(Util.inputLine("Stock Name: "),
														inputNewTicker(availableStocks,"Ticker: "),
														Util.inputDoubleLow("Cost/Share?", 0));
					
					if(Util.obtainYesNo("Do you wish to confirm these changes (y/n)")=='y')
						availableStocks.addEntry(tempStock);
					else
						System.out.println("no stock was added...");
					
				}
				
				//purchase a stock, show all account ID
				else if (subMenuChoice==2) {
					
					System.out.println(obtainAllAccountNameAndID(myClients));
					Account idToBuyStock = new Account(Util.inputInteger("Enter an account ID: "));
					
					if (isAccount(myClients,idToBuyStock)) {
						
						Account accountToBuyStock = retrieveAccount(myClients,idToBuyStock);
						
						//display account's balance, and market stocks
						System.out.println("Client's Current Balance: "+accountToBuyStock.getBalance());
						System.out.println("\nMarket Stocks:\n"+obtainMarketStocksTable(availableStocks));
						
						//create a temporary Stock object with user input ticker
						Stock stockToPurchaseTicker= new Stock(Util.inputLine("Enter Stock Ticker To Purchase: ").toUpperCase());
						
						//check if any element in marketStock match temp.
						if (isMarketStock(availableStocks,stockToPurchaseTicker)) {
							Stock originalStock= retrieveMarketStock(availableStocks,stockToPurchaseTicker);
							
							//calculate the high bound by down casting; partial stocks are not allowed
							int maxQuantityCanPurchase=(int)(accountToBuyStock.getBalance()/originalStock.getMarketCostPerShare());
							
							int quantityOfStocksToPurchase = Util.inputIntegerBetween("How many to purchase? (1-"+maxQuantityCanPurchase+")", 1 , maxQuantityCanPurchase );
							
							System.out.println("\nStock Order: "+originalStock.getStockName()
												+" Number of Shares: "+quantityOfStocksToPurchase
												+" Price per share: "+originalStock.getMarketCostPerShare()
												+" Total Cost: "+originalStock.getMarketCostPerShare()*quantityOfStocksToPurchase);
							
							if(Util.obtainYesNo("Do you wish to confim these changes? (y/n)")=='y') {
								
								//withdraw money from account according to price
								accountToBuyStock.withdrawFunds(originalStock.getMarketCostPerShare()*quantityOfStocksToPurchase);
								
								//if the stock does not already exist within account, create a new instance
								if (!isAccountStock(accountToBuyStock.getAccountStocks(),originalStock)) {
									accountToBuyStock.getAccountStocks().addEntry(
									new CustomerStock(originalStock.getStockName(),
											originalStock.getTicker(),
											originalStock.getMarketCostPerShare(),
											quantityOfStocksToPurchase));
								}
								
								//if the stock already exists within account, update it using .purchaseQuantity method
								else {
									retrieveCustomerStock(accountToBuyStock.
											getAccountStocks(),originalStock).
												purchaseQuantity(quantityOfStocksToPurchase);							
								}
								
								//update the market stock quantity as well to reflect cumulative amount in brokerage
								System.out.println("purchase successful!");
								originalStock.increaseQuantity(quantityOfStocksToPurchase);
							
							}
							else
								System.out.println("no purchase made.");
						}
						else
							System.out.println("invalid entry. Ticker does not exist.");
						}
						
					else
						System.out.println("not an account ID");
				}
				
				//sell a stock
				else if (subMenuChoice==3) {
					
					System.out.println(obtainAllAccountNameAndID(myClients));
					Account accountToTradeStockID = new Account(Util.inputInteger("\nEnter an account ID: "));
					
					if (isAccount(myClients,accountToTradeStockID)) {
						
						//display all stocks owned by account, prompt input
						Account accountToTradeStock =retrieveAccount(myClients,accountToTradeStockID);
						System.out.println("\nAccount Stocks:\n"+obtainAccountStocksTable(accountToTradeStock));
						Stock stockToTradeTicker = new Stock(Util.inputLine("Enter Ticker of Stock to Sell: ").toUpperCase());
							
						if(isAccountStock(accountToTradeStock.getAccountStocks(),stockToTradeTicker)) {							
							System.out.println("stock owned by account!");
							CustomerStock stockToTrade = retrieveCustomerStock(accountToTradeStock.getAccountStocks(),stockToTradeTicker);
							
							//determine high bound such that user cannot sell more than quantity owned
							int maxQuantityCanSell = stockToTrade.getQuantity();
							
							int quantityOfStocksToSell=Util.inputIntegerBetween("How many to sell? (0-"+maxQuantityCanSell+")",0,maxQuantityCanSell);
							
							System.out.println("\nStock Order: "+stockToTrade.getStockName()
							+" Number of Shares: "+quantityOfStocksToSell
							+" Price per share: "+stockToTrade.getMarketCostPerShare()
							+" Total Proceeds: "+stockToTrade.getMarketCostPerShare()*quantityOfStocksToSell);
							
							if(Util.obtainYesNo("Do you wish to confirm these changes?")=='y') {
								
								//update customerStock via .sellQuantity method, market stock is decreased as well 
								stockToTrade.sellQuantity(quantityOfStocksToSell);
								accountToTradeStock.fundAccount(quantityOfStocksToSell*stockToTrade.getMarketCostPerShare());
								retrieveMarketStock(availableStocks,stockToTradeTicker).decreaseQuantity(quantityOfStocksToSell);
								
								//if the customerStock quantity reaches 0, remove it from the account
								if(stockToTrade.getQuantity()==0)
										accountToTradeStock.getAccountStocks().removeEntry(stockToTrade);
								
								System.out.println("stock successfully traded!");
							}
							
						}
						else
							System.out.println("Stock either invalid or not owned by account!");
					}
					else
						System.out.println("not an account ID");
				}
				
				//split stock 
				else if (subMenuChoice==4) {
			
					System.out.println("available stocks to SPLIT");
					System.out.println(obtainMarketStocksTable(availableStocks));
					
					Stock stockTickerToSplit = new Stock(Util.inputLine("enter a stock Ticker to split: ").toUpperCase());
					
					if (isMarketStock(availableStocks,stockTickerToSplit)) {
						Stock stockToSplit = retrieveMarketStock(availableStocks,stockTickerToSplit);
						Stock stockPriorToSplit = new Stock(stockToSplit.getStockName(),stockToSplit.getTicker(),stockToSplit.getMarketCostPerShare(),stockToSplit.getQuantity());
						
						System.out.println("Old market price: "+stockPriorToSplit.getMarketCostPerShare());
						System.out.println("New market price: "+Util.roundOff(stockPriorToSplit.getMarketCostPerShare()/2,2));
						
						if(Util.obtainYesNo("Confirm these changes? (y/n)")=='y') {
							
							//first update the market stock costPerShare to reflect the split, divided by two
							stockToSplit.setMarketCostPerShare(Util.roundOff(stockPriorToSplit.getMarketCostPerShare()/2,2));
							
							//check if myClients is empty, prevent null pointer exception
							if(!myClients.isEmpty()) {
								
								for(int i=0;i<myClients.getArraySize();i++) {
								Account currentAccount=myClients.getArray()[i];
									
									//check if current account owns any stocks
									if(!currentAccount.getAccountStocks().isEmpty()) {
										for (int j=0;j<currentAccount.getAccountStocks().getArraySize();j++) {
										CustomerStock currentStock=currentAccount.getAccountStocks().getArray()[j];
										
										//currentStock matches stockToSplit
										if(currentStock.equals(stockToSplit)) {
											
											//set marketCostPerShare to match the market stock
											currentStock.setMarketCostPerShare(stockToSplit.getMarketCostPerShare());
											//increase market Stock quantity as well
											stockToSplit.increaseQuantity(currentStock.getQuantity());
											currentStock.stockSplit();
											}
											
										}
									}
								}
							}
						
						System.out.println("available stocks AFTER split");
						System.out.println(obtainMarketStocksTable(availableStocks));
						
						}
						else
							System.out.println("no changes made...");
						
						
					}
					else
						System.out.println("not a valid stock...");
				}
				
				//reverse split stock
				else if (subMenuChoice==5) {
					System.out.println("available stocks to REVERSE split ");
					System.out.println(obtainMarketStocksTable(availableStocks));
					Stock stockTickerToReverseSplit = new Stock(Util.inputLine("enter a stock Ticker to reverse split: "));
					
					if (isMarketStock(availableStocks,stockTickerToReverseSplit)) {
						
						Stock stockToReverseSplit = retrieveMarketStock(availableStocks,stockTickerToReverseSplit);
						Stock stockPriorToReverseSplit = new Stock(stockToReverseSplit.getStockName(),stockToReverseSplit.getTicker(),stockToReverseSplit.getMarketCostPerShare(),stockToReverseSplit.getQuantity());
						
						System.out.println("Old market price: "+stockPriorToReverseSplit.getMarketCostPerShare());
						System.out.println("New market price: "+stockPriorToReverseSplit.getMarketCostPerShare()*2);
						
						if(Util.obtainYesNo("Confirm these changes? (y/n)")=='y') {
							
							stockToReverseSplit.setMarketCostPerShare(stockPriorToReverseSplit.getMarketCostPerShare()*2);
						
							if(!myClients.isEmpty()) {
								
								for(int i=0;i<myClients.getArraySize();i++) {
									
								Account currentAccount = myClients.getArray()[i];
						
									if(!currentAccount.getAccountStocks().isEmpty()) {
										
										for (int j=0;j<currentAccount.getAccountStocks().getArraySize();j++) {
										CustomerStock currentStock=currentAccount.getAccountStocks().getArray()[j];
										
										//currentStock matches stockToReverseSplit
										if(currentStock.equals(stockToReverseSplit)) {
											
											//check for any remainders when dividing by two
											if (currentStock.getQuantity()%2==1) {
												
												//sell quantity, update market Stock
												currentStock.sellQuantity(1);
												stockToReverseSplit.decreaseQuantity(1);
												//account is funded
												currentAccount.fundAccount(stockPriorToReverseSplit.getMarketCostPerShare());
												//output message confirming the trade
												System.out.println("Account ID: "+currentAccount.getIdentificationNumber()
																	+" Client "+currentAccount.getFirstName()+" "+currentAccount.getLastName()
																	+" sells 1 share at "+stockPriorToReverseSplit.getMarketCostPerShare()+" per share. New client Balance: "+currentAccount.getBalance());
												}
											
											//update marketCostPerShare to match market Stock 
											currentStock.setMarketCostPerShare(stockToReverseSplit.getMarketCostPerShare());
											currentStock.reverseStockSplit();
											
											//decrease market Stock as well
											stockToReverseSplit.decreaseQuantity(currentStock.getQuantity()); 
											
											}
											
										}
									}
								}
							}
							
							System.out.println("stocks AFTER reverse split: ");
							System.out.println(obtainMarketStocksTable(availableStocks));
						}
						else
							System.out.println("no changes made.");
						}
					else
						System.out.println("not a valid stock...");
					
				}
				
				//quit stock management sub menu
				else
					break;
			}
			
			//GENERATE REPORTS 
			while (mainMenuChoice==3) {
				displayGenerateReportsSubMenu();
				subMenuChoice=Util.inputIntegerBetween("Submenu selection: ",1,3);
				
				//view all holders of a particular stock
				if(subMenuChoice==1) {
					Stock stockTickerToViewAllHolders = new Stock(Util.inputLine("enter a stock Ticker to check all Holders: ").toUpperCase());
					if(isMarketStock(availableStocks,stockTickerToViewAllHolders)) {
						
						//print table
						System.out.println(obtainAllHoldersTable(myClients,stockTickerToViewAllHolders));
					}
					else
						System.out.println("invalid ticker...");
				}
				
				//generate all positions for all accounts
				else if (subMenuChoice==2) {
					if(!myClients.isEmpty()) {
						for(int i=0;i<myClients.getArraySize();i++) {
							Account accountAtMoment = myClients.getArray()[i];
							System.out.println("Name: "+accountAtMoment.getFirstName()+" "+accountAtMoment.getLastName()
												+" Account Number: "+accountAtMoment.getIdentificationNumber());
							//print table
							System.out.println(obtainAccountStocksTable(accountAtMoment));
							}
					}
					else 
						System.out.println("no clients within the system.");
				}
				
				//quit generate reports sub menu
				else
					break;
			}
			
			//SIMULATE MARKET MOVEMENT
			if (mainMenuChoice==4) {
				
				if (!availableStocks.isEmpty()) {
					//copy stocks, used for table
					DynamicStockArray availableStocksPriorToMovement=copyStockContents(availableStocks);
					double[] myPercentsOfChange = new double[availableStocks.getArraySize()];
					fillDoubleArray(myPercentsOfChange);
					simulateMarketMovement(availableStocks,myClients,myPercentsOfChange);
					
					//print table
					System.out.println(obtainMarketMovementTable(
										availableStocksPriorToMovement,
										availableStocks,
										myPercentsOfChange));
				}
				else
					System.out.println("There are no stocks within the brokerage...");
				}
			
			//COOKIE CATASTROPHE
			else if (mainMenuChoice==5) {
				if(!availableStocks.isEmpty()) {
					
					//5% chance of catastrophe happening
					if(Util.randomIntBetween(1,100)<=5) {
						System.out.println("OMG. COOKIE CATASTROPHE!!!");
						DynamicStockArray availableStocksPriorToCatastrophe=copyStockContents(availableStocks);
						double [] arrayOfFiftyPercents = new double[availableStocks.getArraySize()];
						fillDoubleArrayCatastrophe(arrayOfFiftyPercents);
						
						//reused method, except arrayOfPercents is -50. 
						simulateMarketMovement(availableStocks,myClients,arrayOfFiftyPercents);
						
						//print table
						System.out.println(obtainMarketMovementTable(
											availableStocksPriorToCatastrophe,
											availableStocks,
											arrayOfFiftyPercents));
					}
					System.out.println("nothing happened... crisis averted!");
				}
				else
					System.out.println("There are no stocks within the brokerage...");
			}
			
			//QUIT MAIN MENU
			else if(mainMenuChoice==6)
				break;
			
			}
		
	}
	}

		


	


