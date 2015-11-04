/**
 * A sampleable list can be sampled. 
 * 
 * @author PiJ
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
	
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
			for(int i = 0; i < size; i = i + 2) {
				temp[i] = this.getList()[i];
			}
			newList.setList(temp);
		}
		return newList;
	}
}
