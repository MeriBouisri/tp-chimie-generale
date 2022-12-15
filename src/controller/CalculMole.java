package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022E23;
	
	public CalculMole() {
		
	}

	public double getNumberOf(double baseUnit) {
		return baseUnit * CONST_AVOGADRO;
	}
	
	public double getMoleOf(double numberUnit) {
		return numberUnit / CONST_AVOGADRO;
	}
	
	public double calculNombreIon(double nbMolIon, int molElectron) {
		return nbMolIon * molElectron;
	}
	
	public double calculNombreElectron(double nbMolElectron, int molElectron) {
		return nbMolElectron / molElectron;
	}
	
	/**
	 * @return resultat arrondi au nombre de chiffres significatifs donne
	 */
	public double setSigFig(double resultat, boolean notationScientifique, int sigFig) {
		double formattedDouble;
		double precision = Math.pow(10, sigFig);
		try {
			if (notationScientifique) {
				String[] separateDouble = String.valueOf(resultat).split("E");
				double valueRound = Double.parseDouble(separateDouble[0]);
				separateDouble[0] = String.valueOf(Math.round(valueRound * precision) / precision);
				formattedDouble = Double.parseDouble(separateDouble[0] + "E" + separateDouble[1]);
			} else {
			formattedDouble = Math.round(resultat * precision) / precision;
			}}
		catch (IndexOutOfBoundsException e) {
			formattedDouble = Math.round(resultat * precision) / precision;
		}
		
		// Reconstruire le double
		
		return formattedDouble;
	}

	
}
