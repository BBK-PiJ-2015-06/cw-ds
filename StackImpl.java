/**
 * Solution to Part 7 of Assignment 2, PiJ 2015
 * A StackImpl is an implementation of a stack that extends 
 * AbstractStack and uses a {@List} as the underlying data 
 * structure (ArrayList or LinkedList).
 *
 * A stack using a null list as its data structure behaves the
 * same way as a stack using an empty list except that elements 
 * cannot be pushed to a null list. A stack with a null list will
 * always therefore be regarded as empty and having a size 0.
 */

public class StackImpl extends AbstractStack {
	
	//Constructor method calls constructor of parent class AbstractStack
	public StackImpl(List list) {
		super(list);
	}
	
	/**
	 * Returns true if the stack is empty or if the stack is using
	 * an underlying data structure that is null, false otherwise. 
	 * 
	 * @return true if the stack is empty or list is null, 
	 *         false otherwise. 
	 */
	public boolean isEmpty() {
		if(this.isListNull()) {
			return true;              //tests for null list first, otherwise NullPointerException is thrown
		}
		boolean output = false;
		if(this.internalList.isEmpty()) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the number of items currently in the stack.
	 * A null list returns a size 0.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		if(!this.isListNull()) {
			return this.internalList.size();
		} else {
			return 0;
		}
	}

	/**
	 * Adds an element at the top of the stack. 
	 *
	 * This method will do nothing if stack contains a null list,
	 * but will add an element to index 0 if stack contains an 
	 * empty list.
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		if(!this.isListNull()) {
			this.internalList.add(item);
		}
	}

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty or if the list used within the stack is null an 
	 *         EMPTY_STRUCTURE ErrorMessage is returned.
	 */
	public ReturnObject top() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty() || this.isListNull()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.internalList.get(this.size() - 1).getReturnValue());
		}
		return output;
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed from the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty or if the list used within the stack is null an 
	 *         EMPTY_STRUCTURE ErrorMessage is returned.
	 */
	public ReturnObject pop() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty() || this.isListNull()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.internalList.get(this.size() - 1).getReturnValue());
			this.internalList.remove(this.size() - 1);
		}
		return output;
	}
	
	/**
	 * Returns true if the underlying data structure of the stack is
	 * null (not the same as empty!!!), false otherwise.
	 *
	 * @return true if this list is null, false otherwise.
	 */
	private boolean isListNull() {
		boolean output = false;
		if(this.internalList == null) {
			output = true;
		}
		return output;
	}
}