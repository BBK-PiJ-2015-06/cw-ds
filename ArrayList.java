/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author PiJ
 */
public class ArrayList implements List {
	
	private Object[] list;
	private int length;
	private ReturnObjectImpl ob;
	
	public ArrayList() {
		this.length = 0;
		this.list = new Object[length];
	}
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		if(this.length == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return this.length;
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
	public ReturnObject get(int index) {
		if(!this.hasIndexError(index)) {
			ob.setReturnValue(this.list[index]);
		}
		return ob;
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
	public ReturnObject remove(int index) {
		if(!this.hasIndexError(index)) {
			ob.setReturnValue(this.list[index]);
			Object[] temp = new Object[length - 1];
			if(index == length - 1) {
				for(int i = 0; i < temp.length; i++) {
					temp[i] = this.list[i];
				}
			} else {
				for(int i = 0; i < index; i++) {
					temp[i] = this.list[i];
				}
				for(int i = index + 1; i < temp.length; i ++) {
					temp[i - 1] = this.list[i];
				}
			}
			this.list = temp;
			this.length = this.length - 1;
		}
		return ob;
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
	public ReturnObject add(int index, Object item) {
		if(item == null){
			ob.setError(ErrorMessage.INVALID_ARGUMENT);
		} else if(!this.hasIndexError(index)) {
			Object[] temp = new Object[length + 1];
			for(int i = 0; i < index; i++) {
				temp[i] = this.list[i];
			}
			temp[index] = item;
			for(int i = index + 1; i < temp.length; i++) {
				temp[i] = this.list[i - 1];
			}
			this.list = temp;
			this.length++;
		}
		return ob;
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
	public ReturnObject add(Object item) {
		if(item == null){
			ob.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			Object[] temp = new Object[length + 1];
			for(int i = 0; i < list.length; i++) {
				temp[i] = this.list[i];
			}
			temp[temp.length - 1] = item;
			this.list = temp;
			this.length++;
		}
		return ob;
	}
	
	/**
	* Checks those methods where an index is provided that the index is valid.
	*
	* Changes the error message only if the index is invalid.
    *	
	* @param index the position at which the item should be inserted in
	*        the list
	* @return returns true if the index is invalid
	*         returns false if the index is valid
	*/
	private boolean hasIndexError(int index) {
		if(this.isEmpty()) {
			ob.setError(ErrorMessage.EMPTY_STRUCTURE);
			return true;
		} else if(index < 0 || index >= this.length) {
			ob.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return true;
		} else {
			return false;
		}
	}
}
