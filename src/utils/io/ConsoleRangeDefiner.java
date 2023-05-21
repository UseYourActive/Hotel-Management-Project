package utils.io;

public class ConsoleRangeDefiner {
    private static final String INVALID_RAGE_MESSAGE = "Min value cannot exceed max value!";
    private static final String NOT_IN_RANGE_MESSAGE = "Input must be between %d and %d!";

    private ConsoleRangeDefiner() {
        throw new UnsupportedOperationException();
    }

    public static int readInt(int minValue, int maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException(INVALID_RAGE_MESSAGE);
        }

        int input;
        boolean isWithinRange;

        do {
            input = ConsoleReader.readInt();
            isWithinRange = input >= minValue && input <= maxValue;
            if (!isWithinRange) {
                System.out.printf(NOT_IN_RANGE_MESSAGE, minValue, maxValue);
            }
        } while (!isWithinRange);

        return input;
    }
}
