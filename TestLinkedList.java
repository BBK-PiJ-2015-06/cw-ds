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
	
	@Test
	public void testsGetElementFromCorrectStartMiddleEndIndex() {
		list.add("Object1");
		list.add("Object2");
		list.add("Object3");
		list.add("Object4");
		list.add("Object5");
		ReturnObject a = list.get(0);
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		Object expected = "Object1";
		ErrorMessage errorExpected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		a = list.get(2);
		output = a.getReturnValue();
		errorOutput = a.getError();
		expected = "Object3";
		errorExpected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		a = list.get(list.size() - 1);
		output = a.getReturnValue();
		errorOutput = a.getError();
		expected = "Object5";
		errorExpected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
	}
	
	@Test
	public void testsGetMethodWithInvalidIndex() {
		ReturnObject a = list.get(-1);
		Object expected = null;
		ErrorMessage errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);	
	}
	
}