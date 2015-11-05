public class ImprovedStackImpl implements ImprovedStack {
	
	private List stackList;
	
	public ImprovedStackImpl(List list) {
		this.stackList = list;
	}
	
	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
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
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.stackList.get(this.size() - 1));
		}
		return output;
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.stackList.get(this.size() - 1));
			this.stackList.remove(this.size() - 1);
		}
		return output;
	}
		/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStack reverse() {
		if(this.isEmpty()) {
			return this;
		} else {
			ArrayList reverseList = new ArrayList();
			for(int index = (this.size() - 1); index >= 0; index--) {
				reverseList.add(index);
			}
			ImprovedStackImpl newStack = new ImprovedStackImpl(reverseList);
			return newStack;
		}
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
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