package fr.armida.cogal;

public class LevelOneMacroCell implements MacroCell {
	private static final int LEVEL = 1;
	
	private final boolean nw;
	private final boolean ne;
	private final boolean se;
	private final boolean sw;
	
	// this is immutable so we can cache the hash
	private Integer hash;
	// same for string representation
	private String stringRep;

	public LevelOneMacroCell(boolean nw, boolean ne, boolean se, boolean sw) {
		super();
		this.nw = nw;
		this.ne = ne;
		this.se = se;
		this.sw = sw;
	}

	@Override
	public int hashCode() {
		if (hash == null) {
			final int prime = 31;
			int result = 1;
			result = prime * result + (getNe() ? 1231 : 1237);
			result = prime * result + (getNw() ? 1231 : 1237);
			result = prime * result + (getSe() ? 1231 : 1237);
			result = prime * result + (getSw() ? 1231 : 1237);

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
		if (getLevel() != other.getLevel())
			return false;
		if (getNe() != other.getNe())
			return false;
		if (getNw() != other.getNw())
			return false;
		if (getSe() != other.getSe())
			return false;
		if (getSw() != other.getSw())
			return false;
		return true;
	}

	public int getLevel() {
		return LEVEL;
	}

	public String toString() {
		if (stringRep == null) {
			stringRep = "|" + columnRep(getNw(), getSw()) + columnRep(getNe(), getSe()) + "|";
		}
		
		return stringRep;
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

	public boolean getNw() {
		return nw;
	}

	public boolean getNe() {
		return ne;
	}

	public boolean getSe() {
		return se;
	}

	public boolean getSw() {
		return sw;
	}
}
