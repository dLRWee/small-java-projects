import java.math.BigDecimal;
import util.Fibonacci;

public final class Main {

	private static final String USAGE = "usage: <bound>";

	public static void main(String[] args) {
		int bound = validateInput(args);

		for (int i = 0; i < bound; i++) {
			BigDecimal fibonacci = Fibonacci.compute(i);
			System.out.println(i + ":\t" + fibonacci.toString());
		}
	}

	private static int validateInput(String[] args) {
		if (args.length != 1) {
			errorExit(USAGE);
		}

		int bound = tryParseInt(args[0]);

		if (bound < 0) {
			errorExit("Bound should not be negative");
		}

		return bound;
	}

	private static int tryParseInt(String string) {
		int result = -1;

		try {
			result = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			String message = String.format("Could not parse string '%s' to an integer", string);
			errorExit(message);
		}

		return result;
	}

	private static void errorExit(String message) {
		System.out.println(message);
		System.exit(1);
	}
}
