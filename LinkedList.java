/**
 * Solution to Part 3 of Assignment 2, PiJ 2015
 * An implementation of the interface List, using a dynamic data
 * structure, singly linked list as the underlying means of storing 
 * each element.
 *
 * This is a singly linked list of objects and so each object can store 
 * different types and there is no limit to the number of elements
 * in the list.
 *
 * Each element is sorted with respect to its index in the list. The
 * first element is at index 0, then index 1 and so on. The list is not
 * sorted based upon the individual elements as these can take on a variety
 * of types.
 *
 * The size of the LinkedList can be determined as well as whether it
 * is empty or not. Other operations include: retrieving elements from a
 * given index, adding elements to the LinkedList and removing elements.
 *
 * Some methods return elements of the Linkedlist in the form of a ReturnObject
 * wrapper in order to accommodate error values when they appear.
 */
 
 
public class LinkedList implements List {
	
	//Fields
	private ObjectNode listStart;
	
	//Constructor method creates a starting node and sets it to null as default
	public LinkedList() {
		this.listStart = null;
	}
	
	/**
	 * Returns true if the LinkedList is empty, false otherwise. 
	 * 
	 * @return true if the LinkedList is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		boolean output = false;
		if(this.listStart == null) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the number of elements that are currently in the LinkedList.
	 * 
	 * @return the number of elements currently in the LinkedList
	 */
	public int size() {
		int count = 0;
		ObjectNode temp = this.listStart;
		if(!this.isEmpty()) {
			count = 1;
			while(temp.getNext() != null) {
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}

	/**
	 * Returns the element at the given position provided by the index. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the LinkedList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * @param index the position in the LinkedList of the element to be retrieved
	 * @return ReturnObject with the element retrieved or the aforementioned 
	 *         error message.
	 */
	public ReturnObject get(int index) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		ObjectNode temp = this.listStart;
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			for(int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			output.setObject(temp.getObject());
		}
		return output;
	}

	/**
	 * Returns the elements at the given position provided by the index
	 * and removes it from the LinkedList. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the LinkedList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * @param index the position in the LinkedList of the element to be retrieved and
	 *        removed
	 * @return ReturnObject with the element retrieved or the aforementioned 
	 *         error message.
	 */
	public ReturnObject remove(int index) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		ObjectNode temp = this.listStart;
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index == 0) {
			output.setObject(this.listStart.getObject());
			if(this.listStart.getNext() == null) {
				this.listStart = null;
			} else {
				this.listStart = temp.getNext();
			}	
		} else {
			for(int i = 0; i < (index - 1); i++) {
				temp = temp.getNext();
			}
			output.setObject(temp.getNext().getObject());
			temp.setNext(temp.getNext().getNext());
		}
		return output;
	}

	/**
	 * Adds an element to the LinkedList, inserting it at the given
	 * position.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the LinkedList, then an INDEX_OUT_OF_BOUNDS ErrorMessage is returned.
	 * 
	 * If a null object is provided to insert in the LinkedList, the
	 * insertion is ignored and an INVALID_ARGUMENT ErrorMessage is
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the LinkedList
	 * @param item the value to insert into the LinkedList
	 * @return ReturnObject with an empty object if the operation is 
	 *         successful or containing the aforementioned error message.
	 */
	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if(item == null) {
			output.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			ObjectNode newObject = new ObjectNode(item);
			if(index == 0) {
				newObject.setNext(this.listStart);
				this.listStart = newObject;
			} else {
				ObjectNode temp = this.listStart;
				for(int i = 0; i < (index - 1); i++) {
					temp = temp.getNext();
				}
				newObject.setNext(temp.getNext());
				temp.setNext(newObject);
			}
		}
		return output;
	}

	/**
	 * Adds an element to the end of the LinkedList.
	 * 
	 * If a null object is provided to add at the end of the LinkedList, 
	 * the insertion is ignored and an INVALID_ARGUMENT ErrorMessage is
	 * returned.
	 * 
	 * @param item the value to insert at the end of the LinkedList
	 * @return ReturnObject with an empty object if the operation is
	 *         successful or containing the aforementioned error message
	 */
	public ReturnObject add(Object item) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		ObjectNode newObject = new ObjectNode(item);
		if(item == null) {
			output.setError(ErrorMessage.INVALID_ARGUMENT);
		} else if(this.isEmpty()) {
			listStart = newObject;
		} else {
			ObjectNode temp = this.listStart;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newObject);
		}
		return output;
	}
	
	/**
	 * Returns this ObjectNode.
	 * 
	 * Enables methods in extended classes to use this private field.
	 * 
	 * @return returns this ObjectNode
	 */
	public ObjectNode getList() {
		return this.listStart;
	}
	
	/**
	 * Sets the ObjectNode.
	 *
	 * Enables methods within extended classes to set their ObjectNode.
	 *
	 * @param list the ObjectNode that this ObjectNode is to be set to
	 */
	public void setList(ObjectNode listStart) {
		this.listStart = listStart;
	}
}