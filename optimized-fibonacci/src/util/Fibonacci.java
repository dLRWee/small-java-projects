package util;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public final class Fibonacci {

	private static final Map<Integer, BigDecimal> computed;

	static {
		computed = new HashMap<>();
		computed.put(0, BigDecimal.ONE);
		computed.put(1, BigDecimal.ONE);
	}

	private Fibonacci() {
		throw new AssertionError("Fibonacci is a util class and cannot be instantiated");
	}

	public static BigDecimal compute(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Index should not be negative");
		}

		if (computed.containsKey(index)) {
			return computed.get(index);
		}

		computed.put(index - 2, compute(index - 2));
		computed.put(index - 1, compute(index - 1));

		BigDecimal result = computed.get(index - 2).add(computed.get(index - 1));
		computed.put(index, result);
		return result;
	}
}
