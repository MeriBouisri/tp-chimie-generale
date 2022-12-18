package model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Cette classe contient toutes les formules nécessaires à la résolution d'un problème de calcul de mole.
 * @author Merieme Bouisri
 */
public class CalculMole {
	
	/**
	 * Nombre d'entités élémentaires qui se trouvent dans une mole de matière.
	 */
	private final double CONST_AVOGADRO = 6.022E23;
	
	/**
	 * Chiffres significatifs
	 */
	private int sigFig;
	
	/**
	 * Cette méthode permet d'obtenir la réciproque d'une valeur donnée.
	 * Cela permet de calculer des produits croisés ou d'isoler une inconnue.
	 * @param value Valeur à inverser
	 * @param inverse Si, oui ou non, la valeur doit être inversée
	 * @return (1 / value) si {@code inverse == true}
	 */
	public double reciprocalValueOf(double value, boolean inverse) {
		return inverse
				? 1 / value // true : Réciproque de la valeur
				: value;    // false : Valeur elle-même
	}
	
	/**
	 * Cette méthode permet d'obtenir le nombre d'entités selon son nombre de moles, et vice versa. La direction
	 * de la conversion avec le nombre d'Avogadro est déterminée par {@code convert}.
	 * @param valueToConvert Valeur à convertir
	 * @param convert Condition pour déterminer si la valeur doit être divisée ou multipliée par le nombre d'Avogadro
	 * @return Valeur divisée par la constante d'Avogadro si {@code convert == true}, multipliée si {@code convert == false}
	 */
	public double convertAvogadro(double valueToConvert, boolean convert) {
		return valueToConvert * reciprocalValueOf(CONST_AVOGADRO, convert);
	}
	
	/**
	 * Cette méthode permet de trouver une valeur inconnue en effectuant un produit croisé. 
	 * Si l'entité recherchée est le nombre de moles d'ions (entityIndex == 0), {@code knownValue} sera divisée par {@code molElectron}.
	 * Si l'entité recherchée est le nombre de moles d'électrons (entityIndex == 1), {@code knownValue} sera multipliée par {@code molElectron}.
	 * @param knownValue Valeur connue
	 * @param molElectron Moles d'électrons dans 1 mole de l'ion
	 * @param entityIndex Entité recherchée (0 = nombre de moles d'électrons, 1 = nombre de moles d'ions)
	 * @return Valeur inconnue
	 */
	public double calculateUnknown(double knownValue, double molElectron, int entityIndex) { 
	 return knownValue * reciprocalValueOf(molElectron, entityIndex == 0);
	}
	
	/**
	 * Cette méthode permet d'enregistrer le nombre de chiffres significatifs à conserver
	 * au cours de tous les calculs. Souvent basée sur la valeur entrée par l'utilisateur.
	 * @param value Valeur qui détermine les c.s. 
	 */
	public void getSigFig(double value) {
		this.sigFig = BigDecimal.valueOf(value).precision();
	}
	
	/**
	 * Cette méthode permet de formater une valeur donnée de manière à conserver 
	 * seulement le nombre de chiffres significatifs déterminés avec la méthode getSigFig
	 * @param value Valeur à formater
	 * @return Valeur avec les bons chiffres significatifs
	 */
	public double setSigFig(double value) {
		MathContext significantFigures = new MathContext(sigFig, RoundingMode.UP);
		return BigDecimal.valueOf(value)
				.round(significantFigures)
				.doubleValue();
	}
}