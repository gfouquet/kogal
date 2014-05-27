package fr.armida.cogal;

import java.util.Arrays;

public class LevelOneMacroCell implements MacroCell {
	private static final int LEVEL = 1;

	public final boolean[] quad = new boolean[4];

	// this is immutable so we can cache the hash
	private int hash = Integer.MIN_VALUE;
	// same for string representation
	private String stringRep;

	public LevelOneMacroCell(boolean nw, boolean ne, boolean se, boolean sw) {
		super();
		quad[0] = nw;
		quad[1] = ne;
		quad[2] = se;
		quad[3] = sw;
	}

	public int getLevel() {
		return LEVEL;
	}

	public String toString() {
		if (stringRep == null) {
			stringRep = "|" + columnRep(quad[0], quad[3]) + columnRep(quad[1], quad[2])
					+ "|";
		}

		return stringRep;
	}

	@Override
	public int hashCode() {
		if (hash == Integer.MAX_VALUE) {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(quad);
			hash = result;
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LevelOneMacroCell other = (LevelOneMacroCell) obj;
		if (!Arrays.equals(quad, other.quad))
			return false;
		return true;
	}

	private char columnRep(boolean top, boolean bottom) {
		if (top && bottom) {
			return '8';
		}
		if (top && !bottom) {
			return '°';
		}
		if (top && !bottom) {
			return 'o';
		}
		return ' ';
	}

	public boolean getNW() {
		return quad[0];
	}

	public boolean getNE() {
		return quad[1];
	}

	public boolean getSE() {
		return quad[2];
	}

	public boolean getSW() {
		return quad[3];
	}
}
