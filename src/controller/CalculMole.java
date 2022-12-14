package projetChimie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022E23;
	
	// Constantes qui decrivent les 4 variables possibles
	public final int ELECTRON = 0;
	public final int ION = 1;
	public final int MOL = 0;
	public final int NUM = 1;
	
	private double unknown;
	
	private double[][] var;
	
	public CalculMole() {
		var = new double[2][2];
	}
	
	public void setVariable(int specie, int unit, double value) {
		var[specie][unit] = value;
	}
	
	public void setUnknown(int specie, int unit) {
		this.unknown = var[specie][unit];
	}
	
	public double getValueOf(int specie, int unit) {
		return var[specie][unit];
	}
	
	// Produits croisés
	//TODO: optimiser cette methode
	public double findUnknown() {
		double result = 0;
		if (unknown == var[ELECTRON][MOL]) {
			result = (var[ELECTRON][NUM] * var[ION][MOL]) / var[ION][NUM];
		}
		
		if (unknown == var[ELECTRON][NUM]) {
			result = (var[ELECTRON][MOL] * var[ION][NUM]) / var[ION][MOL];
		}
		if (unknown == var[ION][MOL]) {
			result = (var[ELECTRON][MOL] * var[ION][NUM]) / var[ELECTRON][NUM];
		}
		
		if (unknown == var[ION][NUM]) {
			result = (var[ELECTRON][NUM] * var[ION][MOL]) / var[ELECTRON][MOL];
		}
		
		return setSigFig(result, 2);
	}
	
	public double getNumberOf(double baseUnit) {
		return baseUnit * CONST_AVOGADRO;
	}
	
	public double getMoleOf(double numberUnit) {
		return numberUnit / CONST_AVOGADRO;
	}
	
	public double calculMole(double numberUnit, int molElectron) {
		return numberUnit * molElectron;
	}
	
	/**
	 * @return resultat arrondi au nombre de chiffres significatifs donne
	 */
	public double setSigFig(double resultat, int sigFig) {
		double precision = Math.pow(10, sigFig);
		return Math.round(resultat * precision) / precision;
	}

	
}
