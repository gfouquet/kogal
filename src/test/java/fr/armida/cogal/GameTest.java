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
		assertThat(cell.getNW(), Is.is(true));
		assertThat(cell.getNE(), Is.is(false));
		assertThat(cell.getSE(), Is.is(true));
		assertThat(cell.getSW(), Is.is(false));
		
	}
}
