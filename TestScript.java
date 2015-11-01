public class TestScript {
	public static void main(String[] args) {
		TestScript launcher = new TestScript();
		launcher.launch();
	}
	public void launch() {
		ArrayList array1 = new ArrayList();
		if(array1.isEmpty()) {
			System.out.println("This structure is empty.");
		} else {
			System.out.println("This structure is not empty.");
		}
	}
}