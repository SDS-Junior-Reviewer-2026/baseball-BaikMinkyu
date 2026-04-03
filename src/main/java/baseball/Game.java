package baseball;

public class Game {
    public void guess(String guessNumber) {
        checkIllegalArgument(guessNumber);
    }

    private static void checkIllegalArgument(String guessNumber) {
        if (guessNumber == null || guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char digit : guessNumber.toCharArray()) {
            if (digit < '0' || digit > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (hasDuplicateDigits(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateDigits(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
