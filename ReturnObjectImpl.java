/**
 * Solution to Part 1 of Assignment 2, PiJ 2015
 * An implementation of the interface ReturnObject,
 * containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 */

public class ReturnObjectImpl implements ReturnObject {
	
	//Fields
	private Object object;
	private ErrorMessage error;
	
	//Constructor method instantiates fields to null as default value.
	public ReturnObjectImpl() {
		this.object = null;
		this.error = null;
	}
	
	/**
	 * Returns whether there has been an error
	 * @return true if there has been an error otherwise returns false
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
	 * Return NO_ERROR if {@hasError} returns false.
	 * otherwise returns the current error message of the object
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
	 * Returns the object.
	 * 
	 * Returns null if there has been an error or
	 * if there is no object to return from the method
	 * 
	 * @return the return value from the method
	 */
	public Object getReturnValue() {
		return this.object;
	}
	
	/**
	 * Sets the value of object.
	 *
	 * Enables methods within other classes to set the value of their
	 * ReturnObject objects.
	 *
	 * @param object the object that this object is to be set to
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
	/**
	 * Sets the value of this error. 
	 *
	 * Enables methods within other classes to set the value of their
	 * ReturnObject errors. The set of values used can only be those
	 * found in the ErrorMessage enum class.
	 *
	 * @param error the ErrorMessage that this error is to be set to
	 */
	public void setError(ErrorMessage error) {
		this.error = error;
	}

}
