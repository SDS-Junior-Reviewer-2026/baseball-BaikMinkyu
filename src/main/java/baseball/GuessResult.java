package baseball;

public class GuessResult {
    private boolean isSolved;
    private int strikes;
    private int balls;

    public GuessResult(boolean isSolved, int strikes, int balls) {
        this.isSolved = isSolved;
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean getIsSolved() {
        return isSolved;
    }
    public int getStrikes() {
        return strikes;
    }
    public int getBalls() {
        return balls;
    }
}
