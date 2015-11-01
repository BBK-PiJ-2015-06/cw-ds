public class ArrayList implements List {
	
	private Object[] list;
	private ReturnObjectImpl returnObject;
	
	
	public ArrayList() {
		this.list = new Object[0];
		this.returnObject = new ReturnObjectImpl();
	}
	
	public boolean isEmpty() {
		boolean output = false;
		if(this.list.length == 0) {
			output = true;
		}
		return output;
	}

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
	
	private boolean isIndexValid(int index) {
		boolean output = true;
		if(this.list.length == 0) {
			this.returnObject.setError(ErrorMessage.EMPTY_STRUCTURE);
			output = false;
		} else if(index >= this.list.length || index < 0) {
			this.returnObject.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			output = false;
		}
		return output;
	}
	
}
