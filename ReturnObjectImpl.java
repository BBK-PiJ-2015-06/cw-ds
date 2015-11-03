public class ReturnObjectImpl implements ReturnObject {
	
	private Object object;
	private ErrorMessage error;
	
	public ReturnObjectImpl() {
		this.object = null;
		this.error = null;
	}
	
	public boolean hasError() {
		boolean output = false;
		if(this.error != null) {
			output = true;
		}
		return output;
	}

	public ErrorMessage getError() {
		if(!this.hasError()) {
			error = ErrorMessage.NO_ERROR;
		}
		return this.error;
	}

	public Object getReturnValue() {
		return this.object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public void setError(ErrorMessage error) {
		this.error = error;
	}

}
