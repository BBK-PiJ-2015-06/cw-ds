/**
 * Solution to Part 5 of Assignment 2, PiJ 2015
 * A FunctionalLinkedList implements FunctionalList and extends
 * LinkedList with the addition of methods that enable the 
 * LinkedList to be utilised in a recursive manner. 
 *
 * These additional methods enable the first element (index 0) 
 * and / or the body (index 1, index 2...index(size - 1)) to be 
 * retrieved with no change being inflicted upon the original structure.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	//Constructor method calls constructor from parent class LinkedList
	public FunctionalLinkedList() {
		super();
	}
	
    /**
     * Returns the element at the beginning of the FunctionalLinkedList. 
     * 
     * If the structure is empty, an EMPTY_STRUCTURE ErrorMessage is returned. 
     *
     * @return ReturnObject which holds a copy of the element at the beginning 
	 *         of the FunctionalLinkedList or an error if the list is empty.
     */
    public ReturnObject head() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.getList().getObject());
		}
		return output;
	}

    /**
     * Returns a FunctionalList with the elements in this list except the
     * head. The elements remain in the same order. The original structure
	 * and elements are not changed or affected by changes in the new list. 
     * 
     * If the FunctionalLinkedList is empty, another empty list is returned. 
     */
    public FunctionalList rest() {
		FunctionalLinkedList output = new FunctionalLinkedList(); //New list created in order to preserve original 
		if(this.size() > 1) {
			/* 
			 * iteratively re-adding elements to new list. 
			 * Cannot simply repoint new list starter node to next object as 
			 * this won't preserve original if changes are made in the new list.
			 */
			for(int index = 1; index < this.size(); index++) {
				output.add(this.get(index).getReturnValue());
			} 										
		}
		return output;
	}
													
}
