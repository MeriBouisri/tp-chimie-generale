package controller;

public class CalculMole {

	private final double CONST_AVOGADRO = 6.022E23;
	
	public double crossProduct(boolean condition, double value) {
		return condition ? 1 / value : value;
	}
	public double convertAvogadro(double valueToConvert, boolean convert) {
		return valueToConvert * crossProduct(convert, CONST_AVOGADRO);
	}
	
	public double calculateUnknown(double knownValue, double molElectron, int entityIndex) { 
	 return knownValue * crossProduct(entityIndex == 0, molElectron);
	}

	public double setSigFig(double resultat, int sigFig) {
		double formattedDouble;
		double precision = Math.pow(10, sigFig);
		
		if (String.valueOf(resultat).contains("E")) {
			String[] separateDouble = String.valueOf(resultat).split("E");
			double valueRound = Double.parseDouble(separateDouble[0]);
			separateDouble[0] = String.valueOf(Math.round(valueRound * precision) / precision);
			formattedDouble = Double.parseDouble(separateDouble[0] + "E" + separateDouble[1]);
		} else {
			formattedDouble = Math.round(resultat * precision) / precision;
		}
		
		return formattedDouble;
	}
	
}
