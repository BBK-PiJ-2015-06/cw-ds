import org.junit.*;
import static org.junit.Assert.*;

public class TestSampleableListImpl {
	
	private SampleableListImpl list;
	
	@Before
	public void initialise() {
		list = new SampleableListImpl();
	}
	
	@Test
	public void testsSampleOnEmptyList() {
		SampleableList newList = list.sample();
		assertEquals(0, newList.size());
		assertEquals(null, newList.get(0).getReturnValue());
		newList.add(5);
		assertEquals(0, list.size());
		assertEquals(1, newList.size());
	}
	
	@Test 
	public void testsSampleOnList() {
		list.add(1);
		list.add(98);
		list.add(22);
		list.add(40);
		list.add(2, 55);
		SampleableList newList = list.sample();
		assertEquals(3, newList.size());
		assertEquals(1, newList.get(0).getReturnValue());
		assertEquals(55, newList.get(1).getReturnValue());
		assertEquals(40, newList.get(2).getReturnValue());
		newList.add("Test");
		assertEquals(5, list.size()); //Tests that original list is not changed.
		assertEquals(4, newList.size());
	}
	
	@Test
	public void testsSampleIndependance() {
		list.add(1);
		list.add(2);
		SampleableList newList = list.sample();
		newList.add(2);
		assertEquals(2, list.size());
		assertEquals(2, newList.size());
		newList.remove(0);
		list.remove(0);
		list.remove(0);
		assertEquals(0, list.size());
		assertEquals(1, newList.size());
		assertEquals(2, newList.get(0).getReturnValue());
	}
}