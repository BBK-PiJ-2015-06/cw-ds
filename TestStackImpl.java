import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {
	
	private ArrayList alist;
	private LinkedList llist;
	
	@Before
	public void initialise() {
			alist = new ArrayList();
			llist = new LinkedList();
	}
	
	@Test
	public void testsIsEmpty() {
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertTrue(stack1.isEmpty());
		assertTrue(stack2.isEmpty());
	}
	
	@Test 
	public void testsIsNotEmpty() {
		alist.add("Object1");
		llist.add("Object2");
		llist.add("Object3");
		ArrayList temp = alist;
		StackImpl stack1 = new StackImpl(temp);
		StackImpl stack2 = new StackImpl(llist);
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
	}
	
	@Test
	public void testsSize() {
		alist.add(1);
		alist.add(2);
		llist.add(3);
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertEquals(2, stack1.size());
		assertEquals(1, stack2.size());
	}
	
	@Test 
	public void testsPushOnEmptyList() {
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		stack1.push(0);
		stack1.push(1);
		stack2.push("Object");
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
		assertEquals(2, stack1.size());
		assertEquals(1, stack2.size());
	}
	
	@Test 
	public void testsPush() {
		alist.add("Hello");
		alist.add("World");
		llist.add("Test");
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		stack1.push(0);
		stack1.push(1);
		stack2.push("Object");
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
		assertEquals(4, stack1.size());
		assertEquals(2, stack2.size());
	}
	
	@Test
	public void testsTopOnEmptyList() {
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertEquals(null, stack1.top().getReturnValue());
		assertEquals(null, stack2.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack1.top().getError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack1.top().getError());
	}
	
	@Test
	public void testsTop() {
		alist.add("Hello");
		alist.add("World");
		llist.add("Test");
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertEquals("World", stack1.top().getReturnValue());
		assertEquals("Test", stack2.top().getReturnValue());
		
		stack1.push(0);
		stack1.push(1);
		stack2.push("Object");
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
		assertEquals(4, stack1.size());
		assertEquals(2, stack2.size());
		assertEquals(1, stack1.top().getReturnValue());
		assertEquals("Object", stack2.top().getReturnValue());
		assertEquals(4, stack1.size());
		assertEquals(2, stack2.size());
	}
	
	@Test 
	public void testsPopOnEmptyList() {
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertEquals(null, stack1.pop().getReturnValue());
		assertEquals(null, stack2.pop().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack1.pop().getError());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack1.pop().getError());
	}
	
	@Test
	public void testsPop() {
		alist.add("Hello");
		alist.add("World");
		llist.add("Test");
		StackImpl stack1 = new StackImpl(alist);
		StackImpl stack2 = new StackImpl(llist);
		assertEquals("World", stack1.pop().getReturnValue());
		assertEquals("Test", stack2.pop().getReturnValue());
		
		stack1.push(null);
		stack1.push(1);
		stack2.push("Object");
		assertFalse(stack1.isEmpty());
		assertFalse(stack2.isEmpty());
		assertEquals(2, stack1.size());
		assertEquals(1, stack2.size());
		assertEquals(1, stack1.pop().getReturnValue());
		assertEquals("Object", stack2.pop().getReturnValue());
		assertEquals(1, stack1.size());
		assertEquals(0, stack2.size());
	}
	
	@Test
	public void testsEffectOfChangesToOriginalListOrInternalList() {
		ArrayList original = new ArrayList();
		StackImpl stack = new StackImpl(original);
		assertEquals(0, original.size());
		assertEquals(0, stack.size());
		
		stack.push("Object");
		assertEquals(1, original.size());
		assertEquals(1, stack.size());
	}
	
	@Test 
	public void testNullLists() {
		StackImpl stack = new StackImpl(null);
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
		stack.push("Object");
		assertEquals(0, stack.size());
		assertEquals(null, stack.top().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack.top().getError());
		assertEquals(null, stack.pop().getReturnValue());
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack.pop().getError());
		assertEquals(0, stack.size());
	}
		
}