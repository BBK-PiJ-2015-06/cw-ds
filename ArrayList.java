/**
 * An ArrayList is an implementation of the class List. It holds a 
 * collection of objects within an array which expands and decreases
 * in size when object are added or removed from the list. The 
 * ArrayList cannot hold null objects but can contain a mixture of 
 * other types of objects.
 * 
 * This class also makes use of the ReturnObject complex type to 
 * return the objects and / or any appropriate error messages.
 */
public class ArrayList implements List {
	
	private Object[] list;
	private ReturnObjectImpl returnObject;
	
	public ArrayList() {
		this.list = new Object[0];
		this.returnObject = new ReturnObjectImpl();
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */	
	public boolean isEmpty() {
		boolean output = false;
		if(this.list.length == 0) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		int output = this.list.length;
		return output;
	}

	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObjectImpl get(int index) {
		this.returnObject = new ReturnObjectImpl();
		if(isIndexValid(index)) {
			this.returnObject.setObject(this.list[index]);
		}
		return returnObject;
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObjectImpl remove(int index) {
		this.returnObject = new ReturnObjectImpl();
		if(isIndexValid(index)) {
			this.returnObject.setObject(this.list[index]);
			Object[] temp = new Object[this.list.length - 1];
			for(int i = 0; i < index; i++) {
				temp[i] = this.list[i];
			}
			for(int i = (index + 1); i < temp.length; i++) {
				temp[i - 1] = this.list[i];
			}
			this.list = temp;
		}
		return returnObject;
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObjectImpl add(int index, Object item) {
		this.returnObject = new ReturnObjectImpl();
		if(item == null) {
			this.returnObject.setError(ErrorMessage.INVALID_ARGUMENT);
		} else if(isIndexValid(index)) {
			Object[] temp = new Object[this.list.length + 1];
			for(int i = 0; i < index; i++) {
				temp[i] = this.list[i];
			}
			temp[index] = item;
			for(int i = index + 1; i < temp.length; i++) {
				temp[i] = this.list[i-1];
			}
			this.list = temp;
		}
		return returnObject;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObjectImpl add(Object item) {
		this.returnObject = new ReturnObjectImpl();
		if(item == null) {
			this.returnObject.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			Object[] temp = new Object[this.list.length + 1];
			for(int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}
			temp[temp.length - 1] = item;
			this.list = temp;
		}
		return returnObject;
	}	
	
	/**
	* Checks whether the index value provided by the user is correct.
	*
	* Also checks whether an index is apropriate in a given situation
	* by testing whether the current ArrayList is empty.
	*
	* An appropriate error is given to returnObject in each case. Also 
	* returns true if the index is valid, or false if the index is invalid, 
	* out of bounds or the list is empty.
	*
	* @param index the position within the list that is to be tested
	*        for validity.
	* @return returns true if the index is valid or returns false if the 
	*         index is invalid, out of bounds or the list is empty.
	*/
	private boolean isIndexValid(int index) {
		boolean output = true;
		if(this.isEmpty()) {
			this.returnObject.setError(ErrorMessage.EMPTY_STRUCTURE);
			output = false;
		} else if(index >= this.list.length || index < 0) {
			this.returnObject.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			output = false;
		}
		return output;
	}
	
	/**
	* Prints on screen the objects contained within the list, each on a 
	* separate line, in ascending order with respect to index.
	*
	* No objects or values are returned.
	*/
	public void printList() {
		if(this.isEmpty()) {
			this.returnObject.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			for(int i = 0; i < this.list.length; i++) {
				System.out.println(this.list[i]);
			}
		}
	}
}
