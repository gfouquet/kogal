package fr.armida.cogal;

import java.util.stream.Stream;

public class LevelTwoMacroCell {
	LevelOneMacroCell[] quad = new LevelOneMacroCell[4];
	
	public LevelTwoMacroCell(LevelOneMacroCell nw, LevelOneMacroCell ne,
			LevelOneMacroCell se, LevelOneMacroCell sw) {
		quad[0] = nw;
		quad[1] = ne;
		quad[2] = se;
		quad[3] = sw;
	}

	public void computeResult() {
		// mapper les quad dans une matrice
		// calculer les coordonnées du voisinage - on peut meme les mettre dans une hashmap
		// mapper les coordonnées et compter
		
		int rq = 0;
		int rqq = 2;
		
		int alive = Stream.of(0,1,2,3).filter((i) -> (i != rqq)).map((i) -> quad[rq].quad[i] ? 1 : 0).reduce(0, (it, memo) -> it + memo);
		alive += Stream.of(0,1,2,3).filter((i) -> (i != rqq)).map((i) -> quad[rq].quad[i] ? 1 : 0).reduce(0, (it, memo) -> it + memo);
	}
}
