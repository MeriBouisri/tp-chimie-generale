package controller;

import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import model.*;

/**
 * Cette classe représente le pont entre le view et le model.
 * Les données entrées par l'utilisateur sont envoyées par {@code EventHandler}.
 * Cette classe fait ensuite le traitement de ces données grâce aux infos
 * et methodes contenues dans {@code model.PeriodicTable} et {@code model.CalculMole}.
 * Une fois les calculs effectués, les valeurs sont renvoyées à {@code view.EventHandler}
 * 
 * @author Merieme Bouisri
 */
public class UserInput {
	
	PeriodicTable periodicTable;
	CalculMole calculMole;
	
	// Variables permettant de définir l'élément impliqué dans le calcul
	private int elementSearchType;
	private Element element;
	
	/**
	 * Nombre d'électrons dans 1 entité élémentaire
	 */
	private int numElectrons;
	
	// Variables permettant de définir la valeur connue
	private double knownValue;
	/**
	 * Entité élémentaire dont le nombre est connu.
	 */
	private int knownEntity;
	
	/**
	 * Valeur recherchée.
	 */
	private double unknownValue;
	
	public UserInput() {
		periodicTable = new PeriodicTable();
		calculMole = new CalculMole();
	}
	
	/**
	 * @return Nombre de moles d'éléctrons dans 1 mole d'entité élémentaire.
	 */
	public int getNumElectrons() {
		this.numElectrons = element.getElectrons();
		return numElectrons;
	}
	
	/**
	 * Cette méthode permet de convertir la valeur connue (Nombre d'entités) 
	 * en nombre de moles.
	 * @return Nombre de moles de l'entité connue (avec C.S. conformes).
	 */
	public double getMoleOfKnownVariable() {
		this.knownValue = calculMole.convertAvogadro(knownValue, true);
		return calculMole.setSigFig(knownValue);
	}
	
	/**
	 * @return Nombre de moles de l'entité inconnue (avec C.S. conformes)
	 */
	public double findUnknown() {
		this.unknownValue = calculMole.calculateUnknown(knownValue, numElectrons, knownEntity);
		return calculMole.setSigFig(unknownValue);
	}
	
	/**
	 * Cette méthode permet de convertir {@code unknownValue} en nombre d'entités, puis reconvertir en nombre de moles
	 * au besoin.
	 * @param convert {@code true} pour convertir en nombre de moles, {@code false} pour convertir en nombre d'entités
	 * @return Valeur convertie de {@code unknownValue}.
	 */
	public double convertValue(boolean convert) {
		
		this.unknownValue = calculMole.convertAvogadro(unknownValue, convert);
		return calculMole.setSigFig(unknownValue);
	}
	
	// Méthodes de définitions des variables
	
	/**
	 * Définir la charge de l'élément sélectionné.
	 * @param charge Charge de l'élément.
	 */
	public void setInputCharge(int charge) {
		element.setCharge(charge);
	}
	
	/**
	 * Définir la variable connue (nombre de l'entité sélectionnée).
	 * Cette variable définit le nombre de chiffres significatifs pour le reste des calculs.
	 * @param knownValue Variable connue
	 */
	public void setKnownVariable(double knownValue) {
		this.knownValue = knownValue;
		calculMole.getSigFig(knownValue);
	}
	
	/**
	 * Définir le type d'entité connue.
	 * @param entityIndex : 0 -> Electrons, 1 -> Ions
	 */
	public void setKnownEntity(int entityIndex) {
		this.knownEntity = entityIndex;
	}
	
	/**
	 * Définir l'attribut par lequel l'élément est recherché
	 * @param elementSearchTypeIndex : 0 -> Nom, 1 -> Symbole, 2 -> Numero atomique
	 */
	public void setElementSearchType(int elementSearchTypeIndex) {
		this.elementSearchType = elementSearchTypeIndex;
	}
	
	/**
	 * Définir l'élément impliqué dans le calcul de moles.
	 * @param elementString Élément recherché par l'utilisateur.
	 */
	public void setElement(String elementString) {
		// Liste des attributs possibles
		String[] searchType = new String[] {"NOM", "SYMBOLE", "NOMBRE ATOMIQUE"};
		
		try {
			if (elementSearchType == 0) { // Chercher l'élément par son nom
				this.element = periodicTable.forName(elementString);
			}
			else if (elementSearchType == 1) { // Chercher l'élément par son symbole
				this.element = periodicTable.forSymbol(elementString);
			}
			else if (elementSearchType == 2) { // Chercher l'élément par son numéro atomique
				try {
					// S'assurer que la valeur entrée est bien une valeur entière
					this.element = periodicTable.forNumber(Integer.parseInt(elementString));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Nombre atomique invalide.", "ERREUR", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(null, "Ce " + searchType[elementSearchType] 
					+ " d'élément est invalide. Réessayez.", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Réinitialiser les valeurs des variables pour effectuer un nouveau calcul.
	 */
	public void resetValues() {
		this.unknownValue = 0;
		this.knownValue = 0;
		this.element = null;
	}
}