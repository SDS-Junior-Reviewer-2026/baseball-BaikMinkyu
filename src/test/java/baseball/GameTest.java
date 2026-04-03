package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game;

	@BeforeEach
	public void setUp() {
		game = new Game();
	}

	@Test
	public void newGame() {
		Assertions.assertNotNull(game);
	}

	@Test
	public void 입력값이_없을_경우() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			game.guess(null);
		});
	}

	@Test
	public void 입력값_자리수가_세자리가_아닐_경우() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			game.guess("12");
		});
	}

	@Test
	public void 입력값에_숫자_외의_뮸자가_입력될_경우() {

	}

	@Test
	public void 입력값에_중복된_숫자가_입력될_경우() {

	}

	@Test
	public void 숫자_세개가_전부_일치_할_경우_3_strike() {

	}

	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {

	}

	@Test
	public void 스트라이크만_있을_경우_1_strike_0_ball() {

	}

	@Test
	public void 볼만_있을_경우_0_strike_1_ball() {

	}

	@Test
	public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

	}
}
