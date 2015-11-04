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
	
	@Test
	public void testsGetMethodWithOutOfBoundsIndex() {
		list.add("Object1");
		list.add("Object2");
		ReturnObject a = list.get(2);
		Object expected = null;
		ErrorMessage errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);	
	}
	
	@Test
	public void testsRemovingElementFromStartOfList() {
		list.add("Object1");
		list.add("Object2");
		list.add("Object3");
		list.add("Object4");
		list.add("Object5");
		ReturnObject a = list.remove(0);
		Object expected = "Object1";
		ErrorMessage errorExpected = ErrorMessage.NO_ERROR;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		int expectedSize = 4;
		int outputSize = list.size();
		assertEquals(expectedSize, outputSize);
		
		a = list.get(0);
		expected = "Object2";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(3);
		expected = "Object5";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(4);
		expected = null;
		errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
	}
	
	@Test
	public void testsRemovingElementFromMiddleOfList() {
		list.add("Object1");
		list.add("Object2");
		list.add("Object3");
		list.add("Object4");
		list.add("Object5");
		ReturnObject a = list.remove(2);
		Object expected = "Object3";
		ErrorMessage errorExpected = ErrorMessage.NO_ERROR;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		int expectedSize = 4;
		int outputSize = list.size();
		assertEquals(expectedSize, outputSize);
		
		a = list.get(0);
		expected = "Object1";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(3);
		expected = "Object5";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(4);
		expected = null;
		errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
	}
	
	@Test
	public void testsRemovingElementFromEndOfList() {
		list.add("Object1");
		list.add("Object2");
		list.add("Object3");
		list.add("Object4");
		list.add("Object5");
		ReturnObject a = list.remove(list.size() - 1);
		Object expected = "Object5";
		ErrorMessage errorExpected = ErrorMessage.NO_ERROR;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		int expectedSize = 4;
		int outputSize = list.size();
		assertEquals(expectedSize, outputSize);
		
		a = list.get(0);
		expected = "Object1";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(3);
		expected = "Object4";
		errorExpected = ErrorMessage.NO_ERROR;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		a = list.get(4);
		expected = null;
		errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
	}
	
	@Test
	public void testsRemovingElementWhereOnlyOneElementRemains() {
		list.add("Object1");
		ReturnObject a = list.remove(0);
		Object expected = "Object1";
		ErrorMessage errorExpected = ErrorMessage.NO_ERROR;
		Object output = a.getReturnValue();
		ErrorMessage errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		int expectedSize = 0;
		int outputSize = list.size();
		assertEquals(expectedSize, outputSize);
		
		a = list.get(0);
		expected = null;
		errorExpected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		output = a.getReturnValue();
		errorOutput = a.getError();
		assertEquals(expected, output);
		assertEquals(errorExpected, errorOutput);
		
		assertTrue(list.isEmpty());
		
	}
	
	@Test
	public void testsAddingAnElementToEmptyList() {
		ReturnObject a = list.add("Object1");
		Object expected = null;
		Object output = a.getReturnValue();
		ErrorMessage expectedError = ErrorMessage.NO_ERROR;
		ErrorMessage outputError = a.getError();
		assertEquals(expected, output);
		assertEquals(expectedError, outputError);
		assertEquals(1, list.size());
		assertEquals("Object1", list.get(0).getReturnValue());
	}
	
	@Test
	public void testsAddingAnElementToTheEndOfExistingList() {
		list.add("Object1");
		ReturnObject a = list.add("Object2");
		Object expected = null;
		Object output = a.getReturnValue();
		ErrorMessage expectedError = ErrorMessage.NO_ERROR;
		ErrorMessage outputError = a.getError();
		assertEquals(expected, output);
		assertEquals(expectedError, outputError);
		assertEquals(2, list.size());
		assertEquals("Object1", list.get(0).getReturnValue());
		assertEquals("Object2", list.get(1).getReturnValue());
	}

}