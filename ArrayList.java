public class ArrayList implements List {
	
	private Object[] list;
	
	public ArrayList() {
		this.list = new Object[0];
	}

	public boolean isEmpty() {
		boolean output = false;
		if(this.list.length == 0) {
			output = true;
		}
		return output;
	}

	public int size() {
		int output = this.list.length;
		return output;
	}

	public ReturnObject get(int index) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			output.setObject(this.list[index]);
		}
		return output;
	}

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

	public Object[] getList() {
		return this.list;
	}
	
}
