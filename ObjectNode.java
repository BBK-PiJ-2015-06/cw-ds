/**
 * An ObjectNode is a complex type that contains an object and a 
 * pointer which points to another ObjectNode in the heap.
 *
 * In sequence, ObjectNodes form the underlying dynamic data
 * structure utilised in class LinkedList and it's subsequent
 * subclasses.
 *
 * Operations performed upon ObjectNodes are simply methods of
 * setting and getting the respective object and pointer.
 */

public class ObjectNode {
	
	//Fields
	private Object object;
	private ObjectNode next;
	
	/*Constructor method initialises the object with a given object
	 * and makes the pointer point to null as a default.
	 */
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
	
	public void setNext(ObjectNode nextObjectNode) {
		this.next = nextObjectNode;
	}
	
}