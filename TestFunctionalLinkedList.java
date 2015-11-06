import org.junit.*;
import static org.junit.Assert.*;

public class TestFunctionalLinkedList {
	
	private FunctionalLinkedList list;
	
	@Before
	public void initialise() {
		list = new FunctionalLinkedList();
	}

	@Test 
	public void testsHeadMethodOnEmptyList() {
		ReturnObject a = list.head();
		Object expected = null;
		ErrorMessage expectedError = ErrorMessage.EMPTY_STRUCTURE;
		Object output = a.getReturnValue();
		ErrorMessage outputError = a.getError();
		assertEquals(expected, output);
		assertEquals(expectedError, outputError);
	}
	
	@Test 
	public void testsHeadMethodOnNonEmptyList() {
		list.add("Object1");
		list.add("Object2");
		ReturnObject a = list.head();
		Object expected = "Object1";
		ErrorMessage expectedError = ErrorMessage.NO_ERROR;
		Object output = a.getReturnValue();
		ErrorMessage outputError = a.getError();
		assertEquals(expected, output);
		assertEquals(expectedError, outputError);
	}
	
	@Test 
	public void testsRestMethodOnEmptyList() {
		FunctionalList newList = list.rest();
		assertEquals(0, newList.size());
	}
	
	@Test
	public void testsRestMethodOnListWithOneElement() {
		list.add("Object1");
		FunctionalList newList = list.rest();
		assertEquals(0, newList.size());
	}
	
	@Test 
	public void testsRestMethodOnListWithMultipleElements() {
		list.add("Object1");
		list.add("Object2");
		FunctionalList newList = list.rest();
		assertEquals(1, newList.size());
		assertEquals("Object2", newList.get(0).getReturnValue());
	}
	
	@Test 
	public void testsWhetherRestMethodAvoidsChangingOriginalList() {
		list.add("Object1");
		list.add("Object2");
		list.add("Object3");
		FunctionalList newList = list.rest();
		assertEquals(2, newList.size());
		assertEquals(3, list.size());
		
		assertEquals("Object2", newList.get(0).getReturnValue());
		assertEquals("Object3", newList.get(1).getReturnValue());
		assertEquals(null, newList.get(2).getReturnValue());
		
		assertEquals("Object1", list.get(0).getReturnValue());
		assertEquals("Object2", list.get(1).getReturnValue());
		assertEquals("Object3", list.get(2).getReturnValue());
		assertEquals(null, list.get(3).getReturnValue());
		
		newList.add("Test");
		assertEquals(3, newList.size());
		assertEquals(3, list.size());
		
	}
	
	@Test
	public void testsEmptyListIndependance() {
		FunctionalList newList = list.rest();
		newList.add("test");
		assertEquals(1, newList.size());
		assertEquals(0, list.size());
		
	}
	
	@Test
	public void testsOriginalListIndependance() {
		list.add(1);
		list.add(2);
		FunctionalList newList = list.rest();
		assertEquals(2, list.size());
		assertEquals(1, newList.size());
		newList.add(2);
		newList.add(3);
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals(3, newList.size());
	}
}