public class TestScript {
	public static void main(String[] args) {
		TestScript launcher = new TestScript();
		launcher.launch();
	}
	public void launch() {
		ArrayList array1 = new ArrayList();
		ReturnObjectImpl a = array1.add("Hello");
		a.printReturnObject();
		if(array1.isEmpty()) {
			System.out.println("This structure is empty.");
		} else {
			System.out.println("This structure is not empty.");
		}
		int size = array1.size();
		System.out.println("Size: " + size);
		a = array1.get(0);
		a.printReturnObject();
		a = array1.remove(0);
		a.printReturnObject();
		
		size = array1.size();
		System.out.println("New size: " + size);
	}
}