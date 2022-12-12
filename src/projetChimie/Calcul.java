package projetChimie;

public class Calcul {

	private final double CONST_AVOGADRO = 6.022 * (Math.pow(10, 23));
	
	public double conversion(int uniteBase) {
		return uniteBase * CONST_AVOGADRO;
	}
	
}
