//This class contains the constructor/methods for DynamicAccountArray

public class DynamicAccountArray {
	private Account [] myClients;
	private int arraySize;
	private int currentLastSpot;
	
/*Constructor DynamicAccountArray
 *Used to create an instance of the DynamicAccountArray Class
 *Parameters:
 *none
 *Return Values:
 *n/a
 *Local Variables:
 *none
 */
	public DynamicAccountArray() {
		arraySize=1;
		currentLastSpot=0;
		myClients= new Account[arraySize];
		
	}//end constructor DynamicAccountArray
	
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
		
	}//end method getArraySize
	
/*Method getArray
 *Used to access object field array
 *Parameters:
 *none
 *Return Values:
 *Account []
 *Local Variables:
 *none
 */
	public Account[] getArray() {
		return myClients;
		
	}//end method getArray
	
/*Method addEntry
 *Used to add an element to the object field array. 
 *Calls on the growArray method to increase the array length as needed
 *Parameters:
 *	accountToAdd: Account variable which will be added to the array
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void addEntry(Account accountToAdd) {
		if (isFull())
			growArray();
		
		myClients[currentLastSpot]=accountToAdd;
		currentLastSpot+=1;
		
	}//end method addEntry
	
/*Method removeEntry
 *Used to remove the first instance of an element from the object field array. 
 *Calls on the shrinkArray method to decrease the array length as needed
 *Parameters:
 *	accountToRemove: Account variable which will be removed from the array
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	public void removeEntry(Account accountToRemove) {
		if (!isEmpty()) {
			for (int i=0;i<arraySize;i++) {
				if (myClients[i].equals(accountToRemove)) {
					myClients[i]=myClients[currentLastSpot-1];
					currentLastSpot-=1;
					shrinkArray();
					break;
				}
			}
		}
		
	}//end method removeEntry
	
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
		
	}//end method isFull
	
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
		
	}//end method isEmpty
	
/*Method growArray
 *Increases object field array length by 1.
 *Parameters:
 *none
 *Return Values:
 *void 
 *Local Variables:
 *none
 */
	private void growArray() {
		//Creates a new Account[] longer than the current array by 1.
		Account [] temp= new Account[arraySize+1];
		
		//Method copies all of the entries of the current array onto it.
		for (int i=0;i<arraySize;i++)
			temp[i]=myClients[i];
		
		//The temp array is assigned to the object field array 
		//The temp array is then made null.
		myClients=temp;
		temp=null;
		arraySize+=1;
		
	}//end method growArray
	
/*Method shrinkArray
 *decreases object field array length by 1.
 *Parameters:
 *none
 *Return Values:
 *void
 *Local Variables:
 *none
 */
	private void shrinkArray() {
		//Creates a new Account[] shorter than the current array by 1..
		arraySize-=1;
		
		//Method copies all of the entries of the current array onto it except the last.
		Account [] temp = new Account [arraySize];
		for (int i=0;i<arraySize;i++)
			temp[i]=myClients[i];
		
		//The temp array is assigned to the object field array 
		//The temp array is then made null.
		myClients=temp;
		temp=null;
		
	}//end method shrinkArray
	
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
				temp+=myClients[i].toString();
			}
		}
		return temp;
		
	}//end method toString

}
