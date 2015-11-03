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
	
	public ArrayList() {
		this.list = new Object[0];
	}
	
	public ArrayList(int size) {
		this.list = new Object[size];
		for(int i = 0; i < size; i++) {
			System.out.println("Please provide object for index " + i + ": " );
			Object ob = System.console().readLine();
			this.list[i] = ob;
		}
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
	public ReturnObject get(int index) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			output.setObject(this.list[index]);
		}
		return output;
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
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			output.setObject(this.list[index]);
			Object[] temp = new Object[this.list.length - 1];
			for(int i = 0; i < index; i++) {
				temp[i] = this.list[i];
			}
			for(int i = (index + 1); i < temp.length; i++) {
				temp[i - 1] = this.list[i];
			}
			this.list = temp;
		}
		return output;
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
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		else if(item == null) {
			output.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
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
		return output;
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
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(item == null) {
			output.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			Object[] temp = new Object[this.list.length + 1];
			for(int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}
			temp[temp.length - 1] = item;
			this.list = temp;
		}
		return output;
	}	
	
}
