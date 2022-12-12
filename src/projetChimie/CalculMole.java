package projetChimie;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022 * (Math.pow(10, 23));
	
	public double getNumberOf(int baseUnit) {
		return baseUnit * CONST_AVOGADRO;
	}
	
	public double getMoleOf(int numberUnit) {
		return numberUnit / CONST_AVOGADRO;
	}
	
}
