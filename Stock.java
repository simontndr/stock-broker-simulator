//This class contains the constructors/methods for Stock. 
 
public class Stock {
	protected String stockName;
	protected String ticker;
	protected double marketCostPerShare;
	protected int quantity;
	
/*Constructor Stock
 *Used to create an instance of the Stock Class, calls on another constructor
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Stock() {
		this("none","none",0,0);
		
	}//end constructor Stock

/*Constructor Stock
 *Used to create an instance of the Stock Class, calls on another constructor
 *Parameters:
 *	ticker: String variable assigned to object field ticker
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Stock(String ticker) {
		this("none",ticker,0,0);
		
	}//end constructor Stock
	
/*Constructor Stock
 *Used to create an instance of the Stock Class, calls on another constructor
 *Parameters:
 *	stockName: String variable assigned to object field stockName
 *	ticker: String variable assigned to object field ticker
 *	marketCostPerShare: double variable assigned to object field marketCostPerShare
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public Stock(String stockName, String ticker, double marketCostPerShare) {
		this(stockName,ticker,marketCostPerShare,0);
		
	}//end constructor Stock
	
/*Constructor Stock
 *Used to create an instance of the Stock Class
 *Parameters:
 *	stockName: String variable assigned to object field stockName
 *	ticker: String variable assigned to object field ticker
 *	marketCostPerShare: double variable assigned to object field marketCostPerShare
 *	quantity: integer variable assigned to object field quantity
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	
	public Stock(String stockName, String ticker, double marketCostPerShare, int quantity) {
		this.stockName=stockName;
		this.ticker=ticker;
		setMarketCostPerShare(marketCostPerShare);
		setQuantity(quantity);
		
	}//end constructor Stock
	
/*Method setMarketCostPerShare
 *Used to mutate object field marketCostPerShare
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	marketCostPerShare: double variable assigned to object field marketCostPerShare
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void setMarketCostPerShare(double marketCostPerShare) {
		if (marketCostPerShare<0)
			throw new IllegalArgumentException("cannot have a negative cost per share!");
		
		this.marketCostPerShare=marketCostPerShare;
		
	}//end method setMarketCostPerShare
	
/*Method setQuantity
 *Used to mutate object field quantity
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
*	quantity: integer variable assigned to object field quantity
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void setQuantity(int quantity) {
		if (quantity<0)
			throw new IllegalArgumentException("cannot have a negative stock qty");
		this.quantity=quantity;
		
	}//end method setQuantity
	
/*Method getStockName
 *Used to access object field stockName
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */	
	public String getStockName() {
		return stockName;
		
	}//end method getStockName

/*Method getTicker
 *Used to access object field ticker
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */	
	public String getTicker() {
		return ticker;
		
	}//end method getTicker
	
/*Method getMarketCostPerShare
 *Used to access object field marketCostPerShare
 *Parameters:
 *none
 *Return Values:
 *double
 *Local Variables:
 *none
 */	
	public double getMarketCostPerShare() {
		return marketCostPerShare;
		
	}//end method getMarketCostPerShare
	
/*Method getQuantity
 *Used to access object field quantity
 *Parameters:
 *none
 *Return Values:
 *integer
 *Local Variables:
 *none
 */	
	public int getQuantity() {
		return quantity;
		
	}//end method getQuantity
	
/*Method increaseQuantity
 *Used to increase value of object field quantity
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	quantityToIncreaseBy: integer variable by which to increase quantity
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void increaseQuantity(int quantityToIncreaseBy) {
		if (quantityToIncreaseBy<0)
			throw new IllegalArgumentException("cannot increase stock qty. by negative");
		quantity+=quantityToIncreaseBy;
		
	}//end method increaseQuantity
	
/*Method decreaseQuantity
 *Used to decrease value of object field quantity
 *Throws IllegalArgumentException for negative parameters
 *Throws IllegalArgumentException for parameters greater than object field quantity
 *Parameters:
 *	quantityToDecreaseBy: integer variable by which to decrease quantity
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void decreaseQuantity(int quantityToDecreaseBy) {
		if (quantityToDecreaseBy<0)
			throw new IllegalArgumentException("cannot decrease stock qty. by negative");
		if (quantityToDecreaseBy>quantity)
			throw new IllegalArgumentException("cannot decrease stock qty. by value greater than total qty.");
		quantity-=quantityToDecreaseBy;
		
	}//end method decreaseQuantity
	
/*Method simulateMarketMovement
 *Used to multiply object field marketCostPerShare by a given parameter
 *Throws IllegalArgumentException for negative parameters
 *Parameters:
 *	factorOfChange: double integer by which marketCostPerShare will be multiplied
 *					ex. if increasing stock by 5%, factor of change would be 1.05
 *Return Values:
 *void
 *Local Variables:
 *none
 */	
	public void simulateMarketMovement(double factorOfChange) {
		if (factorOfChange<0)
			throw new IllegalArgumentException("cannot multiply stock by a negative factor!");
	marketCostPerShare=Util.roundOff(marketCostPerShare*factorOfChange, 2);
	
	}//end method simulateMarketMovement
	
	
/*Method equals
 *Used to determine whether argument is equal to object (tickers are same)
 *Parameters:
 *	otherStock: Stock object to which current object will be compared
 *Return Values:
 *boolean
 *Local Variables:
 *none
 */	
	public boolean equals(Stock otherStock) {
		return ticker.equals(otherStock.ticker);
		
	}//end method equals 
	
/*Method equals
 *Used to determine whether argument is equal to object (tickers are same)
 *Parameters:
 *	otherStock: CustomerStock object to which current object will be compared
 *Return Values:
 *boolean
 *Local Variables:
 *none
 */	
	public boolean equals(CustomerStock otherStock) {
		return ticker.equals(otherStock.ticker);
		
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
		return ("\nStock Name: "+stockName
				+"\nTicker: "+ticker
				+"\n Market Cost/Share: "+marketCostPerShare
				+"\nQuantity: "+quantity);
		
	}//end method toString

}
