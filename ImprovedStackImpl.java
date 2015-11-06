/**
 * Solution to Part 8 of Assignment 2, PiJ 2015
 * An ImprovedStackImpl is an implementation of ImprovedStackstack 
 * which in turn extends Stack with additional methods reverse and
 * remove. 
 * 
 * The class uses a {@see List} as the underlying data structure to 
 * store the elements on the stack. 
 * 
 * Just as in StackImpl, an ImprovedStackImpl using a null list as 
 * its data structure behaves the same way as a stack using an empty 
 * list except that elements cannot be pushed to a null list. 
 * A stack with a null list will always therefore be regarded as 
 * empty and having a size 0.
 */

public class ImprovedStackImpl implements ImprovedStack {
	
	//Field
	private List stackList;
	
	//Constructor method initiates the field stackList with provided list
	public ImprovedStackImpl(List list) {
		this.stackList = list;
	}
	
	/**
	 * Returns true if the stack is empty or if the stack is using
	 * an underlying data structure that is null, false otherwise. 
	 * 
	 * @return true if the stack is empty or list is null, 
	 *         false otherwise. 
	 */
	public boolean isEmpty() {
		if(this.stackList == null) {
			return true;
		} else if(this.stackList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number of items currently in the stack.
	 * A null list returns a size 0.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		if(this.isEmpty()) {
			return 0;
		} else {
			return this.stackList.size();
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
		if(this.stackList != null) {
			this.stackList.add(item);
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
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.stackList.get(this.size() - 1).getReturnValue());
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
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.stackList.get(this.size() - 1).getReturnValue());
			this.stackList.remove(this.size() - 1);
		}
		return output;
	}
	
	/**
	 * Returns a copy of this stack but with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa. 
	 * 
	 * If the stack contains a null list, the method simply returns another null
     * list. If the stack is empty, the method returns an empty stack.	 
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStack reverse() {
		if(this.stackList == null) {
			return this;
		} else if(this.isEmpty()) {
			ArrayList emptyList = new ArrayList(); //Creates true copy so changes made to reverse list do not affect original and visa versa.
			ImprovedStackImpl newStack = new ImprovedStackImpl(emptyList);
			return newStack;
		} else {
			ArrayList reverseList = new ArrayList(); //Creates an array list as the data structure to hold the reversed elements.
			for(int index = (this.size() - 1); index >= 0; index--) {
				reverseList.add(this.stackList.get(index).getReturnValue());
			}
			ImprovedStackImpl newStack = new ImprovedStackImpl(reverseList);
			return newStack;
		}
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * This method performs no action if the stack is empty or 
	 * contains a null list.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object) {
		if(!this.isEmpty()) {
			int size = this.size();
			int index = 0;
			while(index < size) {
				if(this.stackList.get(index).getReturnValue().equals(object)) {
					this.stackList.remove(index);
					size = size - 1;
				} else {
					index++;
				}
			}
		}
	}
	
}