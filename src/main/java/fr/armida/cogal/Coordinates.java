package fr.armida.cogal;

public enum Coordinates {
	NW(0), NE(1), SE(2), SW(3);

	public final int index;

	private Coordinates(int i) {
		index = i;
	}
}
