package baseball;

public class Game {
    public void guess(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }
        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char digit : guessNumber.toCharArray()) {
            if (digit < '0' || digit > '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}
