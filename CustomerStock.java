//This class contains the constructors/methods for Stock. 

public class CustomerStock extends Stock {
	private double bookValue;
	private double marketValue;
	private double averageCostPerShare;
	
/*Constructor Stock
 *Used to create an instance of the CustomerStock Class, calls on super constructor
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public CustomerStock() {
		super();
		
	}//end constructor CustomerStock
	
/*Constructor Stock
 *Used to create an instance of the CustomerStock Class, calls on super constructor
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public CustomerStock(String stockName, String ticker, double marketCostPerShare, int quantity ) {
		super(stockName,ticker,marketCostPerShare,quantity);
		purchasingUpdatesBookValue(quantity);
		updateMarketValue();
		updateAverageCostPerShare();
		
	}//end constructor CustomerStock
	
/*Method getAverageCostPerShare
 *Used to access object field averageCostPerShare
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public double getAverageCostPerShare() {
		return averageCostPerShare;
		
	}//end method getAverageCostPerShare
	
/*Method getMarketValue
 *Used to access object field MarketValue
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public double getMarketValue() {
		return marketValue;
		
	}//end method getMarketValue
	
/*Method getBookValue
 *Used to access object field bookValue
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public double getBookValue() {
		return bookValue;
		
	}//end method getBookValue
	
/*Method updateAverageCostPerShare
 *Used to update object field averageCostPerShare with respect to current bookValue and quantity
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public void updateAverageCostPerShare() {
		if (quantity>0)
			averageCostPerShare=Util.roundOff(bookValue/quantity, 2);
		
	}//end method updateAverageCostPerShare
	
/*Method updateMarketValue
 *Used to update object field marketValue with respect to current marketCostPerShare
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */
	public void updateMarketValue() {
		marketValue=Util.roundOff(marketCostPerShare*quantity, 2);
		
	}//end method updateMarketValue
	
/*Method purchasingUpdatesBookValue
 *Used to update object field BookValue with respect to quantityToPurchase and marketCostPerShare.
 *This method is called within the purchaseQuantity method
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	quantityToPurchase: integer variable by which object field quantity is being increased
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	private void purchasingUpdatesBookValue(int quantityToPurchase ) {
		if (quantityToPurchase<0)
			throw new IllegalArgumentException("cannot purchase a negative amt");
		bookValue+=marketCostPerShare*quantityToPurchase;
		bookValue=Util.roundOff(bookValue, 2);
		
	}//end method purchasingUpdatesBookValue
	
/*Method sellingUpdatesBookValue
 *Used to update object field BookValue with respect to quantityToPurchase and marketCostPerShare.
 *This method is called within the sellQuantity method
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	quantityToPurchase: integer variable by which object field quantity is being decreased
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	private void sellingUpdatesBookValue(int quantityToSell) {
		if (quantityToSell<0)
			throw new IllegalArgumentException("cannot sell a negative amt");
		bookValue-=averageCostPerShare*quantityToSell;
		bookValue=Util.roundOff(bookValue, 2);
		
	}//end method sellingUpdatesBookValue
	
/*Method purchaseQuantity
 *Ensure that the marketCostPerShare is updated before using this method!
 *Used "purchase" a stock. 
 *fields bookValue, marketValue, averageCostPerShare, and quantity are updated.
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	quantityToPurchase: integer variable by which object field quantity is being increased
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void purchaseQuantity(int quantityToPurchase) {
		purchasingUpdatesBookValue(quantityToPurchase);
		super.increaseQuantity(quantityToPurchase);
		updateAverageCostPerShare();
		updateMarketValue();
		
	}//end method purchaseQuantity
	
/*Method sellQuantity
 *Ensure that the marketCostPerShare is updated before using this method!
 *Used "sell" a stock. 
 *fields bookValue, marketValue, averageCostPerShare, and quantity are updated.
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	quantityToSell: integer variable by which object field quantity is being decreased
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void sellQuantity(int quantityToSell) {
		sellingUpdatesBookValue(quantityToSell);
		super.decreaseQuantity(quantityToSell);
		updateAverageCostPerShare();
		updateMarketValue();
		
	}//end method sellQuantity
	
/*Method stockSplit
 *Ensure that the marketCostPerShare is updated (divided by two) before using this method! 
 *Used to "split" a stock, quantity is doubled.
 *fields marketValue and averageCostPerShare are also updated.
 *Parameters:
 *none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void stockSplit() {
		quantity=quantity*2;
		updateAverageCostPerShare();
		updateMarketValue();
		
	}//end method stockSplit
	
/*Method reverseStockSplit
 *Ensure that the marketCostPerShare is updated (doubled) before using this method!
 *Used to "reverse split" a stock, quantity is divided by two (integer division).
 *Sell any remainders in the main method.
 *fields marketValue and averageCostPerShare are also updated.
 *Parameters:
 *none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void reverseStockSplit() {
		quantity=quantity/2;
		updateAverageCostPerShare();
		updateMarketValue();
		
	}//end method reverseStockSplit
	
	
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
		return ("\nStock Name: "+stockName
				+"\nTicker: "+ticker
				+"\nBook Value: "+bookValue
				+"\nMarket Value: "+marketValue
				+"\nAverage Cost/Share: "+averageCostPerShare
				+"\nMarket Cost/Share: "+marketCostPerShare
				+"\nQuantity: "+quantity);
		
	}//end method toString
	
	
	
}