public class ObjectNode {
	
	private Object object;
	private ObjectNode next;
	
	public ObjectNode(Object object) {
		this.object = object;
		this.next = null;
	}
	
	public Object getObject() {
		return this.object;
	}
	
	public ObjectNode getNext() {
		return this.next;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public void setNext(ObjectNode nextObjectNode) {
		this.next = nextObjectNode;
	}
	
}