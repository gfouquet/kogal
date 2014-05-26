package fr.armida.cogal;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

public class GameTest {
	public Game game;
	
	@Before
	public void initFixture() {
		game = new Game();
	}

	@Test
	public void should_create_level_one_cell() {
		// given
		boolean[][] board = new boolean[][] {{true, false},{false, true}};
		
		//when
		LevelOneMacroCell cell = (LevelOneMacroCell) game.createLevelOneCell(board, 0, 0);
		
		//then 
		assertThat(cell.getNw(), Is.is(true));
		assertThat(cell.getNe(), Is.is(false));
		assertThat(cell.getSe(), Is.is(true));
		assertThat(cell.getSw(), Is.is(false));
		
	}
}
