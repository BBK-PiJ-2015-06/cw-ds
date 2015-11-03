public class TestScript {
	public static void main(String[] args) {
		TestScript launcher = new TestScript();
		launcher.launch();
	}
	public void launch() {
		LinkedList link = new LinkedList();
		ReturnObject a = link.add("Hello");
		System.out.println(a.getReturnValue());
		System.out.println(a.getError());
		link.add("World");
		link.add(1, 23);
		a = link.get(0);
		System.out.println(a.getReturnValue());
		System.out.println(a.getError());
		a = link.remove(2);
		System.out.println(a.getReturnValue());
		System.out.println(a.getError());
		int i = link.size();
		System.out.println(i);
	}
}