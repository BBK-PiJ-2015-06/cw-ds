public class ReturnObjectImpl implements ReturnObject {
	
	private Object object;
	private ErrorMessage error;
	
	public ReturnObjectImpl() {
		this.object = null;
		this.error = null;
	}
	
	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError() {
		boolean output = false;
		if(this.error != null) {
			output = true;
		}
		return output;
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError() {
		if(!this.hasError()) {
			error = ErrorMessage.NO_ERROR;
		}
		return this.error;
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue() {
		return this.object;
	}
}
