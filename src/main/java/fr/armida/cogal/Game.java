package fr.armida.cogal;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Game {
	private static final int MAX_LEVEL = 3;
	private static final int BOARD_WIDTH = BigInteger.valueOf(2).pow(MAX_LEVEL).intValue();
	private final Map<Integer, MacroCell> macroCellsByHash = new HashMap<>();

	public Game() {
		super();
		boolean[][] board = randomBoard();
		printBoard(board);
		buildMacroCells(board);
	}

	public boolean[][] randomBoard() {
		System.out.println("creating random board");

		boolean[][] board = new boolean[BOARD_WIDTH][BOARD_WIDTH];

		for (int row = 0; row < BOARD_WIDTH; row++) {
			board[row] = new boolean[BOARD_WIDTH];

			for (int col = 0; col < BOARD_WIDTH; col++) {
				boolean alive = Math.round(Math.floor(Math.random() * (3 - 0 + 1) + 0)) == 0 ? true : false;
				board[row][col] = alive;
			}

		}

		return board;
	}

	public MacroCell buildMacroCells(boolean[][] board) {
		createLevelOneQuadrants(board);

		return null;

	}

	private void createLevelOneQuadrants(boolean[][] board) {
		for (int row = 0; row < BOARD_WIDTH; row = row + 2) {
			createLevelOneRow(board, row);
		}
	}

	private void createLevelOneRow(boolean[][] board, int row) {
		for (int col = 0; col < BOARD_WIDTH; col = col + 2) {
			System.out.println("Reading (" + row + ',' + col + ')');
			MacroCell mc = createLevelOneCell(board, row, col);
			mc = cached(mc);

			System.out.println("Generated L1 macrocell " + mc.toString());

		}
	}

	protected MacroCell createLevelOneCell(boolean[][] board, int row, int col) {
		MacroCell mc = new LevelOneMacroCell(
				board[row][col],
				board[row][col + 1],
				board[row + 1][col + 1],
				board[row + 1][col]);
		return mc;
	}

	private MacroCell cached(MacroCell mc) {
		MacroCell cached = macroCellsByHash.get(mc.hashCode());

		if (cached == null) {
			System.out.println("Cache miss for : " + mc.toString());
			macroCellsByHash.put(mc.hashCode(), mc);
			cached = mc;
		}

		assert cached.getLevel() == mc.getLevel();

		return cached;
	}

	protected static void printBoard(boolean[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3 / 2 * board.length + 1; i++) {
			sb.append("-");
		}
		
		String sep = sb.toString();

		for (int r = 0; r < board.length; r++) {
			StringBuilder rb = new StringBuilder("|");

			for (int c = 0; c < board[r].length; c++) {
				rb.append(board[r][c] ? "*" : " ");

				if ((c + 1) % 2 == 0) {
					rb.append('|');
				}
			}

			System.out.println(rb.append(r).toString());

			if ((r + 1) % 2 == 0) {
				System.out.println(sep);
			}

		}
	}
}
