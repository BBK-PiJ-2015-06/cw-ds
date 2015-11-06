import org.junit.*;
import static org.junit.Assert.*;

public class TestImprovedStackImpl {
	
	private ArrayList alist;
	private LinkedList llist;
	private ImprovedStackImpl stack1;
	private ImprovedStackImpl stack2;
	
	@Before
	public void initialise() {
			alist = new ArrayList();
			llist = new LinkedList();
			
			alist.add(5);
			alist.add("String");
			alist.add(null);
			alist.add(3.1);
			alist.add(100);
			alist.add("George");
			
			llist.add(20);
			llist.add(50.55);
			llist.add("Object");
			
			stack1 = new ImprovedStackImpl(alist);
			stack2 = new ImprovedStackImpl(llist);
	}
	
	
	
	//Tests isEmpty() method.
	
	@Test
	public void testsIsEmpty() {
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
	}
	
	@Test
	public void testsIsEmptyWithNullList() {
		ImprovedStackImpl stack3 = new ImprovedStackImpl(null);
		assertTrue(stack3.isEmpty());
	}
	
	@Test
	public void testsIsEmptyWithEmptyListLinked() {
		LinkedList emptyList = new LinkedList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertTrue(stack3.isEmpty());
	}
	
	@Test
	public void testsIsEmptyWithEmptyListArray() {
		ArrayList emptyList = new ArrayList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertTrue(stack3.isEmpty());
	}
	
	
	
	//Tests size() method.
	
	@Test
	public void testsSize() {
		assertEquals(5, stack1.size());
		assertEquals(3, stack2.size());
	}
	
	@Test
	public void testsSizeWithNullList() {
		ImprovedStackImpl stack3 = new ImprovedStackImpl(null);
		assertEquals(0, stack3.size());
	}
	
	@Test
	public void testsSizeOnEmptyListLinked() {
		LinkedList emptyList = new LinkedList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertEquals(0, stack3.size());
	}
	
	@Test
	public void testsSizeOnEmptyListArray() {
		ArrayList emptyList = new ArrayList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertEquals(0, stack3.size());
	}
	
	
	
	//Tests push(Object) and top() methods.
	
	@Test
	public void testsPushAndTop() {
		assertEquals("George", stack1.top().getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, stack1.top().getError());
		
		stack1.push("pushed Object");
		assertEquals(6, stack1.size());
		assertEquals("pushed Object", stack1.top().getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, stack1.top().getError());
		
		stack2.push("Hello");
		assertEquals(4, stack2.size());
		assertEquals("Hello", stack2.top().getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, stack2.top().getError());
		
		stack1.top();
		stack2.top();
		stack2.top();
		assertEquals(6, stack1.size());
		assertEquals(4, stack2.size());
	}
	
	@Test
	public void testsPushAndTopWithNullList() {
		ImprovedStackImpl stack3 = new ImprovedStackImpl(null);
		assertEquals(null, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack3.top().getError());
		
		stack3.push(10);
		assertEquals(0, stack3.size());
		assertEquals(null, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack3.top().getError());
	}
	
	@Test
	public void testsPushAndTopWithEmptyListLinked() {
		LinkedList emptyList = new LinkedList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertEquals(null, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack3.top().getError());
		
		stack3.push(0);
		assertFalse(stack3.isEmpty());
		assertEquals(1, stack3.size());
		assertEquals(0, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, stack3.top().getError());
	    
		stack3.top();
		assertFalse(stack3.isEmpty());
		assertEquals(1, stack3.size());
	}
	
	@Test
	public void testsPushAndTopWithEmptyListArray() {
		ArrayList emptyList = new ArrayList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		assertEquals(null, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack3.top().getError());
		
		stack3.push(0);
		assertFalse(stack3.isEmpty());
		assertEquals(1, stack3.size());
		assertEquals(0, stack3.top().getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, stack3.top().getError());
	    
		stack3.top();
		assertFalse(stack3.isEmpty());
		assertEquals(1, stack3.size());
	}
	
	@Test
	public void testsPushingNullValue() {
		stack1.push(null);
		assertEquals("George", stack1.top().getReturnValue());
		assertEquals(5, stack1.size());
	}
	
	//Tests pop() method.
	
	@Test
	public void testsPop() {
		ReturnObject a = stack1.pop();
		assertEquals("George", a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		assertEquals(4, stack1.size());
		
		a = stack2.pop();
		assertEquals("Object", a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		assertEquals(2, stack2.size());
	}
	
	@Test
	public void testsPopOnNullList() {
		ImprovedStackImpl stack3 = new ImprovedStackImpl(null);
		ReturnObject a = stack3.pop();
		assertEquals(null, a.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, a.getError());
	}
	
	@Test
	public void testsPopOnEmptyListLinked() {
		LinkedList emptyList = new LinkedList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		ReturnObject a = stack3.pop();
		assertEquals(null, a.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, a.getError());
	}
	
	@Test
	public void testsPopOnEmptyListArray() {
		ArrayList emptyList = new ArrayList();
		ImprovedStackImpl stack3 = new ImprovedStackImpl(emptyList);
		ReturnObject a = stack3.pop();
		assertEquals(null, a.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, a.getError());
	}
	
	@Test
	public void testsPopOnOneElementList() {
		ReturnObject a = stack2.pop();
		assertEquals("Object", a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		
		a = stack2.pop();
		assertEquals(50.55, a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		
		a = stack2.pop();
		assertEquals(20, a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		
		a = stack2.pop();
		assertEquals(null, a.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, a.getError());
	}
	
	
	
	//Tests reverse() method.
	
	@Test
	public void testsReverse() {
		ImprovedStack reversed = stack1.reverse();
		assertEquals(5, reversed.size());
		assertEquals("George", stack1.top().getReturnValue());
		assertEquals(5, reversed.top().getReturnValue());
		reversed.pop();
		assertEquals("String", reversed.top().getReturnValue());
		reversed.pop();
		assertEquals(3.1, reversed.top().getReturnValue());
		reversed.pop();
		assertEquals(100, reversed.top().getReturnValue());
		reversed.pop();
		assertEquals("George", reversed.top().getReturnValue());
		
		ReturnObject a = reversed.pop();
		assertEquals("George", a.getReturnValue());
		assertEquals(ErrorMessage.NO_ERROR, a.getError());
		assertTrue(reversed.isEmpty());
		
		a = reversed.pop();
		assertEquals(null, a.getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, a.getError());
	}
	
	@Test
	public void testsReverseOnNullList() {
		ImprovedStack stack3 = new ImprovedStackImpl(null);
		ImprovedStack reversed = stack3.reverse();
		assertEquals(0, reversed.size());
		assertTrue(reversed.isEmpty());
		assertEquals(null, reversed.top().getReturnValue());
	}
	
	@Test
	public void testsReverseOnEmptyList() {
		ArrayList emptyList = new ArrayList();
		ImprovedStack stack3 = new ImprovedStackImpl(emptyList);
		ImprovedStack reversed = stack3.reverse();
		assertEquals(0, reversed.size());
		assertTrue(reversed.isEmpty());
		assertEquals(null, reversed.top().getReturnValue());
	}
	
	@Test
	public void testsReverseOnSingleList() {
		ArrayList single = new ArrayList();
		single.add("Hello");
		ImprovedStack singleStack = new ImprovedStackImpl(single);
		ImprovedStack reversed = singleStack.reverse();
		assertEquals(1, reversed.size());
		assertFalse(reversed.isEmpty());
		assertEquals("Hello", reversed.top().getReturnValue());
	}
	
	@Test
	public void testsReverseOnDoubleList() {
		ArrayList doubleList = new ArrayList();
		doubleList.add("Hello");
		ImprovedStack doubleStack = new ImprovedStackImpl(doubleList);
		doubleStack.push("Bye!");
		ImprovedStack reversed = doubleStack.reverse();
		assertEquals(2, reversed.size());
		assertEquals(2, doubleStack.size());
		assertFalse(reversed.isEmpty());
		assertEquals("Hello", reversed.top().getReturnValue());
		assertEquals("Bye!", doubleStack.top().getReturnValue());
	}
	
	
	
	//Tests remove() method.
	
	@Test
	public void testsRemove() {
		stack1.remove(5);
		assertEquals(4, stack1.size());
		stack2.remove("Object");
		assertEquals(2, stack2.size());
		assertEquals(50.55, stack2.top().getReturnValue());
	}
	
	@Test
	public void testsRemoveOnNullList() {
		ImprovedStack nullStack = new ImprovedStackImpl(null);
		nullStack.remove("Object");
		assertEquals(0, nullStack.size());
	}
	
	@Test
	public void testsRemoveOnEmptyList() {
		ArrayList emptyList = new ArrayList();
		ImprovedStack stack3 = new ImprovedStackImpl(emptyList);
		stack3.remove(24);
		assertEquals(0, stack3.size());
		assertTrue(stack3.isEmpty());
	}
	
	@Test
	public void testsRemovingMultipleElements() {
		stack1.push("String");
		stack1.push(3.1);
		assertEquals(7, stack1.size());
		stack1.remove("String");
		assertEquals(5, stack1.size());
		stack1.remove(3.1);
		assertEquals(3, stack1.size());
		assertEquals("George", stack1.pop().getReturnValue());
		assertEquals(100, stack1.pop().getReturnValue());
		assertEquals(5, stack1.pop().getReturnValue());
		assertEquals(null, stack1.pop().getReturnValue());
	}
	
	@Test
	public void testsRemovingMultipleConsecutiveElements() {
		stack2.push("Object");
		assertEquals(4, stack2.size());
		stack2.remove("Object");
		assertEquals(2, stack2.size());
		assertEquals(50.55, stack2.top().getReturnValue());
	}
	
	@Test
	public void testsRemovingRemainingObjectsInStack() {
		LinkedList duplicates = new LinkedList();
		duplicates.add("Me");
		duplicates.add("Me");
		duplicates.add("Me");
		duplicates.add("Me");
		duplicates.add("Me");
		ImprovedStack stack3 = new ImprovedStackImpl(duplicates);
		assertEquals(5, stack3.size());
		stack3.remove("Me");
		assertTrue(stack3.isEmpty());
		assertEquals(0, stack3.size());
	}	
}