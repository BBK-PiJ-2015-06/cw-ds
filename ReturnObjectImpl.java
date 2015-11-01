public class ReturnObjectImpl implements ReturnObject {
	
	private ErrorMessage error;
	private Object object;
	
	public ReturnObjectImpl() {
		this.error = null;
		this.object = null;
	}
	
	public boolean hasError() {
		if(this.error == null) {
			return false;
		} else {
			return true;
		}
	}

	public ErrorMessage getError() {
		if(!this.hasError() == false) {
			return error.NO_ERROR;
		} else {
			return this.error;
		}
	}

	public Object getReturnValue() {
		return this.object;
	}
	
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	
	public void setReturnValue(Object object) {
		this.object = object;
	}
}