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
}