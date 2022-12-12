package projetChimie;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022 * (Math.pow(10, 23));
	
	public double getNumberOf(double baseUnit) {
		return baseUnit * CONST_AVOGADRO;
	}
	
	public double getMoleOf(double numberUnit) {
		return numberUnit / CONST_AVOGADRO;
	}
	
	public double calculMole(double numberUnit, int molElectron) {
		return numberUnit * molElectron;
	}
}
