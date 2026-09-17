public final class Main {

	public static void main(String[] args) {
		int index = Integer.parseInt(args[0]);
		long fibo = fibonacci(index);
		System.out.println(fibo);
	}

	private static long fibonacci(int index) {
		if (index == 0 || index == 1) {
			return 1L;
		}

		return fibonacci(index - 2) + fibonacci(index - 1);
	}
}
