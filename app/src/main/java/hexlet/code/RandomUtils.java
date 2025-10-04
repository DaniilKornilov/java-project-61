package hexlet.code;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    private static final int NUMBER_OF_OPERATIONS = 3;

    private RandomUtils() {
    }

    public static int generateNumber(int boundExclusive) {
        return random.nextInt(boundExclusive);
    }

    public static String generateRandomOperation() {
        int operationNumber = RandomUtils.generateNumber(NUMBER_OF_OPERATIONS);
        return switch (operationNumber) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected value: " + operationNumber);
        };
    }
}
