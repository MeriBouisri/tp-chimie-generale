package controller;

import java.util.NoSuchElementException;
import java.util.function.Function;

import javax.swing.JOptionPane;

import model.Element;
import model.PeriodicTable;

public class UserInput {
	
	PeriodicTable periodicTable;
	CalculMole calculMole;
	
	private String[] searchType = new String[] {"NOM", "SYMBOLE", "NOMBRE ATOMIQUE"};
	private String[] variableType = new String[] {"D'ELECTRONS", "D'IONS"};
	
	private Element element;
	private int elementSearchType;
	private int charge;
	private double knownValue;
	private int knownEntity;
	private int numElectrons;
	private double unknownValue;
	
	public UserInput() {
		periodicTable = new PeriodicTable();
		calculMole = new CalculMole();
	}
	
	public String[] getSearchType() {
		return searchType;
	}

	public String[] getEntityList() {
		return variableType;
	}
	
	public void setInputCharge(int charge) {
		this.charge = charge;
	}
	
	public void setKnownVariable(double knownValue) {
		this.knownValue = knownValue;
	}
	
	public void setKnownEntity(int entityIndex) {
		this.knownEntity = entityIndex;
	}
	
	public void setElementSearchType(int elementSearchTypeIndex) {
		this.elementSearchType = elementSearchTypeIndex;
	}
	
	public void setElement(String elementString) {
		try {
			if (elementSearchType == 0) {
				this.element = periodicTable.forName(elementString);
			}
			
			else if (elementSearchType == 1) {
				this.element = periodicTable.forSymbol(elementString);
			}
			
			else if (elementSearchType == 2) {
				try {

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
	
	public int getNumElectrons() {
		element.setCharge(charge);
		this.numElectrons = element.getElectrons();
		return numElectrons;
	}
	
	public double getMoleOfKnownVariable() {
		this.knownValue = calculMole.convertAvogadro(knownValue, true);
		return calculMole.setSigFig(knownValue, 2);
	}
	
	public double findUnknown() {
		this.unknownValue = calculMole.calculateUnknown(knownValue, numElectrons, knownEntity);
		return calculMole.setSigFig(unknownValue, 2);
	}
	
	public double convertValue(boolean convert) {
		this.unknownValue = calculMole.convertAvogadro(unknownValue, !convert);
		return calculMole.setSigFig(unknownValue, 2);
	}
	
	public void resetValues() {
		this.unknownValue = 0;
		this.knownValue = 0;
		this.charge = 0;
		this.element = null;
	}
}
