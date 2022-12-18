package controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022E23;
	
	private int sigFig;
	
	public double crossProduct(boolean condition, double value) {
		return condition ? 1 / value : value;
	}
	public double convertAvogadro(double valueToConvert, boolean convert) {
		return valueToConvert * crossProduct(convert, CONST_AVOGADRO);
	}
	
	public double calculateUnknown(double knownValue, double molElectron, int entityIndex) { 
	 return knownValue * crossProduct(entityIndex == 0, molElectron);
	}

	public double setSigFig(double result) {
		MathContext significantFigures = new MathContext(sigFig, RoundingMode.UP);
		return BigDecimal.valueOf(result)
				.round(significantFigures)
				.doubleValue();
	}
	
	public void getSigFig(double value) {
		this.sigFig = BigDecimal.valueOf(value).precision();
	}
}
