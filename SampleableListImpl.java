/**
 * Solution to Part 6 of Assignment 2, PiJ 2015
 * A sampleable list can be sampled. 
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
	
	//Constructor method calls constructor from parent class ArrayList
	public SampleableListImpl() {
		super();
	}
	
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample() {
		SampleableListImpl newList = new SampleableListImpl();
		int size = this.size();
		if(size == 0) {
			newList.setList(this.getList());
		} else {
			Object[] temp = new Object[(size / 2) + (size % 2)];
			int j = 0; // uses j as an additional counter to count through indicies of original list.
			
			// j initialised to 0.
			// Assumes first, third, fifth items (as mentioned above) takes the literal
			// first, third and fifth elements, NOT index 1, index 3, index 5...etc.
			for(int i = 0; i < temp.length; i++) { 
				temp[i] = this.getList()[j];
				j = j + 2;
			}
			newList.setList(temp);
		}
		return newList;
	}
	
}
