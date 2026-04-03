package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
	private Game game;

	@BeforeEach
	public void setUp() {
		game = new Game();
	}

	@Test
	public void newGame() {
		assertNotNull(game);
	}

	@Test
	public void guessInvalidInput() {
		assertThrowsIllegalArgument(null);
		assertThrowsIllegalArgument("12");
		assertThrowsIllegalArgument("1234");
		assertThrowsIllegalArgument("12s");
		assertThrowsIllegalArgument("121");
	}

	@Test
	public void 숫자_세개가_전부_일치_할_경우_3_strike() {
		generateQuestion("123");

		assertThatGuessResultIsEqual(game.guess("123"), true, 3, 0);
	}

	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {
		generateQuestion("123");

		assertThatGuessResultIsEqual(game.guess("456"), false, 0, 0);
	}

	@Test
	public void 스트라이크만_있을_경우_2_strike_0_ball() {
		generateQuestion("123");

		assertThatGuessResultIsEqual(game.guess("120"), false, 2, 0);
	}

	@Test
	public void 볼만_있을_경우_0_strike_1_ball() {

	}

	@Test
	public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

	}

	private void generateQuestion(String question) {
		game.question = question;
	}

	private void assertThrowsIllegalArgument(String guessNumber) {
		assertThrows(IllegalArgumentException.class, () -> {
			game.guess(guessNumber);
		});
	}

	private void assertThatGuessResultIsEqual(GuessResult result, boolean isSolved, int strikes, int balls) {
		Assertions.assertThat(result)
				.isNotNull();
		Assertions.assertThat(result.getIsSolved())
				.isEqualTo(isSolved);
		Assertions.assertThat(result.getStrikes())
				.isEqualTo(strikes);
		Assertions.assertThat(result.getBalls())
				.isEqualTo(balls);
	}
}
