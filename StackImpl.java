public class StackImpl extends AbstractStack {
	
	public StackImpl(List list) {
		super(list);
	}
	
		/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		boolean output = false;
		if(this.internalList.isEmpty()) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return this.internalList.size();
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		this.internalList.add(item);
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
			output.setObject(this.internalList.get(this.size() - 1).getReturnValue());
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
			output.setObject(this.internalList.get(this.size() - 1).getReturnValue());
			this.internalList.remove(this.size() - 1);
		}
		return output;
	}
	
}