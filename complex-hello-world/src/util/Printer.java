package util;

public final class Printer {

	private Printer() {
		throw new AssertionError("Printer is a util class and cannot be instantiated");
	}

	public static void print(Object object) {
		System.out.println(object);
	}
}
