/**
 * Solution to Part 4 of Assignment 2, PiJ 2015
 * A FunctionalArrayList implements FunctionalList and extends
 * ArrayList with the addition of methods that enable the 
 * ArrayList to be utilised in a recursive manner. 
 *
 * These additional methods enable the first element (index 0) 
 * and / or the body (index 1, index 2...index(size - 1)) to be 
 * retrieved with no change being inflicted upon the original structure.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	//Constructor method calls constructor from parent class ArrayList
	public FunctionalArrayList() {
		super();
	}
	
    /**
     * Returns the element at the beginning of the FunctionalArrayList. 
     * 
     * If the structure is empty, an EMPTY_STRUCTURE ErrorMessage is returned. 
     *
     * @return ReturnObject which holds a copy of the element at the beginning 
	 *         of the FunctionalArrayList or an error if the list is empty.
     */
    public ReturnObject head() {
		ReturnObjectImpl output = new ReturnObjectImpl();
		if(this.isEmpty()) {
			output.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			output.setObject(this.getList()[0]);
		}
		return output;
	}

    /**
     * Returns a FunctionalList with the elements in this list except the
     * head. The elements remain in the same order. The original list
     * is not changed or affected by changes in the new list. 
     * 
     * If the FunctionalArrayList is empty, another empty list is returned. 
     */
    public FunctionalList rest() {
		FunctionalArrayList output = new FunctionalArrayList(); //New list created in order to preserve original
		if(this.isEmpty()) {
			output.setList(this.getList());
		} else {
			Object[] temp = new Object[this.size() - 1];
			for(int i = 0; i < this.size() - 1; i++) {
				temp[i] = this.getList()[i + 1];
			}
			output.setList(temp);
		}
		return output;
	}
	
}
