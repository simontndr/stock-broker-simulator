//This class contains the constructor/methods for DynamicStockArray

public class DynamicStockArray {
	Stock [] marketStocks;
	int arraySize;
	int currentLastSpot;
	
/*Constructor DynamicStockArray
 *Used to create an instance of the DynamicStockArray Class
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public DynamicStockArray() {
		arraySize=1;
		currentLastSpot=0;
		marketStocks=new Stock[arraySize];
		
	}//end DynamicStockArray
	
/*Method getArraySize
 *Used to access object field arraySize
 *Parameters:
 *none
 *Return Values:
 *integer
 *Local Variables:
 *none
 */
	public int getArraySize() {
		return arraySize;
		
	}//end getArraySize
	
/*Method getArray
 *Used to access object field array
 *Parameters:
 *none
 *Return Values:
 *Stock []
 *Local Variables:
 *none
 */
	public Stock[] getArray() {
		return marketStocks;
		
	}//end getArray
	
/*Method addEntry
 *Used to add an element to the object field array. 
 *Calls on the growArray method to increase the array length as needed
 *Parameters:
 *	stockToAdd: Stock variable which will be added to the array
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void addEntry(Stock stockToAdd) {
		if (isFull())
			growArray();
		marketStocks[currentLastSpot]=stockToAdd;
		currentLastSpot+=1;
		
	}//end addEntry
	
/*Method removeEntry
 *Used to remove the first instance of an element from the object field array. 
 *Calls on the shrinkArray method to decrease the array length as needed
 *Parameters:
 *	stockToRemove: Stock variable which will be removed from the array
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void removeEntry(Stock stockToRemove) {
		if (!isEmpty()) {
			for (int i=0;i<arraySize;i++) {
			if (marketStocks[i].equals(stockToRemove)) {
				marketStocks[i]=marketStocks[currentLastSpot-1];
				currentLastSpot-=1;
				shrinkArray();
				break;
				}
			}
		}
		
	}//end removeEntry
	
/*Method isFull
 *Used to determine whether the array is full. Checks if currentLastSpot equals arraySize
 *Parameters:
 *none
 *Return Values:
 *boolean
 *Local Variables:
 *none
 */
	public boolean isFull() {
		return currentLastSpot==arraySize;
		
	}//end isFull
	
/*Method isEmpty
 *Used to determine whether the array is empty. Checks if currentLastSpot equals 0
 *Parameters:
 *none
 *Return Values:
 *boolean
 *Local Variables:
 *none
 */
	public boolean isEmpty() {
		return currentLastSpot==0;
		
	}//end isEmpty
	
/*Method growArray
 *Increases object field array length by 1.
 *Parameters:
 *none
 *Return Values:
 *void 
 *Local Variables:
 *none
 */
	public void growArray() {
		Stock [] temp = new Stock [arraySize+1];
		for (int i=0;i<arraySize;i++) {
			temp[i]=marketStocks[i];
		}
		marketStocks=temp;
		temp=null;
		arraySize+=1;
		
	}//end growArray
	
/*Method shrinkArray
 *decreases object field array length by 1.
 *Parameters:
 *none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void shrinkArray() {
		arraySize-=1;
		Stock [] temp = new Stock[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			temp[i]=marketStocks[i];
		}
		
		marketStocks=temp;
		temp=null;
		
	}//end shrinkArray
	
/*Method toString
 *converts object field array elements to String
 *Parameters:
 *none
 *Return Values:
 *String
 *Local Variables:
 *none
 */
	public String toString() {
		String temp="";
		
		if(!isEmpty()) {
			for (int i=0;i<arraySize;i++) {
				temp+="\n"+marketStocks[i].toString();
			}
		}
		return temp;
		
	}//end toString
	
	
	
}
