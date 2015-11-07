/**
 * Solution to Part 2 of Assignment 2, PiJ 2015
 * An implementation of the interface List, using an array data
 * structure as the underlying means of storing each element.
 *
 * This is an array of objects and so each element can store 
 * different types and there is no limit to the number of elements
 * in the list.
 *
 * Each element is sorted with respect to its index in the list. The
 * first element is at index 0, then index 1 and so on. The list is not
 * sorted based upon the individual elements as these can take on a variety
 * of types.
 *
 * The size of the ArrayList can be determined as well as whether it
 * is empty or not. Other operations include: retrieving elements from a
 * given index, adding elements to the ArrayList and removing elements.
 *
 * Some methods return elements of the list in the form of a ReturnObject
 * wrapper in order to accommodate error values when they appear.
 */
 
 
public class ArrayList implements List {
	
	//Fields
	private Object[] list;
	
	//Constructor method creates new empty array (length 0)
	public ArrayList() {
		this.list = new Object[0];
	}

	/**
	 * Returns true if the Arraylist is empty, false otherwise. 
	 * 
	 * @return true if the Arraylist is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		boolean output = false;
		if(this.list.length == 0) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the number of elements that are currently in the ArrayList.
	 * 
	 * @return the number of elements currently in the ArrayList
	 */
	public int size() {
		int output = this.list.length;
		return output;
	}

	/**
	 * Returns the element at the given position provided by the index. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the ArrayList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * @param index the position in the ArrayList of the element to be retrieved
	 * @return ReturnObject with the element retrieved or the aforementioned 
	 *         error message.
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
	 * Returns the elements at the given position provided by the index
	 * and removes it from the ArrayList. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the ArrayList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * @param index the position in the ArrayList of the element to be retrieved and
	 *        removed
	 * @return ReturnObject with the element retrieved or the aforementioned 
	 *         error message.
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
			for(int i = (index + 1); i < this.list.length; i++) {
				temp[i - 1] = this.list[i];
			}
			this.list = temp;
		}   
		return output;
	}

	/**
	 * Adds an element to the ArrayList, inserting it at the given
	 * position.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the ArrayList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * If a null object is provided to insert in the ArrayList, the
	 * insertion is ignored and an INVALID_ARGUMENT ErrorMessage is
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the ArrayList
	 * @param item the value to insert into the ArrayList
	 * @return ReturnObject with an empty object if the operation is 
	 *         successful or containing the aforementioned error message.
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
	 * Adds an element to the end of the ArrayList.
	 * 
	 * If a null object is provided to add at the end of the ArrayList, 
	 * the insertion is ignored and an INVALID_ARGUMENT ErrorMessage is
	 * returned.
	 * 
	 * @param item the value to insert at the end of the ArrayList
	 * @return ReturnObject with an empty object if the operation is
	 *         successful or containing the aforementioned error message
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

	/**
	 * Returns this Object[]
	 * 
	 * Enables methods in extended classes to use this private field.
	 * 
	 * @return returns this Object[]
	 */
	public Object[] getList() {
		return this.list;
	}
	
	/**
	 * Sets the Object[].
	 *
	 * Enables methods within extended classes to set their Object[].
	 *
	 * @param list the Object[] that this Object[] is to be set to
	 */
	public void setList(Object[] list) {
		this.list = list;
	}
	
}
