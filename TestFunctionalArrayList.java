import org.junit.*;
import static org.junit.Assert.*;

public class TestFunctionalArrayList {
	
	private FunctionalArrayList list;
	
	@Before
	public void initialise() {
		list = new FunctionalArrayList();
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
}