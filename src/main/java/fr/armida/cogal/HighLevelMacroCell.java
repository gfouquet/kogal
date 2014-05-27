package fr.armida.cogal;

public class HighLevelMacroCell implements MacroCell {
	private final int level;
	private final MacroCell nw;
	private final MacroCell ne;
	private final MacroCell se;
	private final MacroCell sw;
	
	private MacroCell result;

	public HighLevelMacroCell(int level, MacroCell nw, MacroCell ne, MacroCell se, MacroCell sw) {
		super();
		this.level = level;
		this.nw = nw;
		this.ne = ne;
		this.se = se;
		this.sw = sw;

		assert ne.getLevel() == level - 1;
		assert nw.getLevel() == level - 1;
		assert sw.getLevel() == level - 1;
		assert se.getLevel() == level - 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getLevel();
		result = prime * result + ((ne == null) ? 0 : ne.hashCode());
		result = prime * result + ((nw == null) ? 0 : nw.hashCode());
		result = prime * result + ((se == null) ? 0 : se.hashCode());
		result = prime * result + ((sw == null) ? 0 : sw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighLevelMacroCell other = (HighLevelMacroCell) obj;
		if (level != other.level)
			return false;
		if (ne == null) {
			if (other.ne != null)
				return false;
		} else if (!ne.equals(other.ne))
			return false;
		if (nw == null) {
			if (other.nw != null)
				return false;
		} else if (!nw.equals(other.nw))
			return false;
		if (se == null) {
			if (other.se != null)
				return false;
		} else if (!se.equals(other.se))
			return false;
		if (sw == null) {
			if (other.sw != null)
				return false;
		} else if (!sw.equals(other.sw))
			return false;
		return true;
	}

	public int getLevel() {
		return level;
	}

}
