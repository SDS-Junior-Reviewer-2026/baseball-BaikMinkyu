package baseball;

public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        checkIllegalArgument(guessNumber);

        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        }

        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < question.length(); ++i) {
            if (question.indexOf(guessNumber.charAt(i)) == i) {
                ++strikes;
            } else if (question.indexOf(guessNumber.charAt(i)) > -1) {
                ++balls;
            }
        }

        return new GuessResult(false, strikes, balls);
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
