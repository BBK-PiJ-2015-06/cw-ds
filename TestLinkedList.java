import org.junit.*;
import static org.junit.Assert.*;

public class TestLinkedList {
	
	private LinkedList list;
	
	@Before
	public void initialise() {
		list = new LinkedList();
	}
	
	@Test
	public void testsIsEmptyMethodWithEmptyList() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testsIsEmptyMethodWithNonEmptyList() {
		list.add("Hello");
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testsSizeWithEmptyList() {
		assertEquals(0, list.size());
	}
	
	@Test
	public void testsSizeWithNonEmptyList() {
		for(int i = 1; i < 10; i++) {
			list.add("Object");
			assertEquals(i, list.size());
		}
	}
	
	@Test
	public void testsSizeAfterAddingElementAndRemovingElement() {
		list.add("Object");
		assertEquals(1, list.size());
		list.add("Object");
		assertEquals(2, list.size());
		list.remove(1);
		assertEquals(1, list.size());
		list.remove(0);
		assertEquals(0, list.size());
	}
	
	
	
}