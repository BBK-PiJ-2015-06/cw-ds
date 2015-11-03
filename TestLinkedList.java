import org.junit.*;
import static org.junit.Assert.*;

public class TestLinkedList {
	
	@Test
	public void testsIsEmptyMethodWithEmptyStructure() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
	}
}