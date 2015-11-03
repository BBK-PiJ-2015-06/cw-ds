public class LinkedList implements List {
	
	private ObjectNode listStart;
	
	public LinkedList() {
		this.listStart = null;
	}
	
	public boolean isEmpty() {
		boolean output = false;
		if(this.listStart == null) {
			output = true;
		}
		return output;
	}

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

	public ReturnObject remove(int index) {
		ReturnObjectImpl output = new ReturnObjectImpl();
		ObjectNode temp = this.listStart;
		if(index < 0 || index >= this.size()) {
			output.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			for(int i = 0; i < (index - 1); i++) {
				temp = temp.getNext();
			}
			output.setObject(temp.getNext().getObject());
			temp.setNext(temp.getNext().getNext());
		}
		return output;
	}

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
	
}