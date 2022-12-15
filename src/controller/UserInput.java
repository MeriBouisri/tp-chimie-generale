package controller;

import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import model.Element;
import model.PeriodicTable;

public class UserInput {
	
	PeriodicTable pt = new PeriodicTable();
	CalculMole cm = new CalculMole();
	
	private String[] searchType = new String[] {"NOM", "SYMBOLE", "NOMBRE ATOMIQUE"};
	private String[] variableType = new String[] {"D'ELECTRONS", "D'IONS"};
	private Element element;
	private boolean validInput;
	private int charge = 0;
	
	private double numElectrons;
	private double molElectrons;
	private double molIons;
	private double numIons;
	private double knownValue;
	private double unknown;
	private int specie;
	
	public UserInput() {

	}
	
	public void onAddCharge() {
		this.charge = charge + 1;
	}
	
	public void onSubstractCharge() {
		this.charge = charge - 1;
	}
	
	public void onConfirm() {
	
	}
	
	public void onConvertValue() {
		
	}
	
	public int getInputCharge() {
		return charge;
	}
	
	public String[] getSearchType() {
		return searchType;
	}

	
	public String[] getEntityList() {
		return variableType;
	}

	public void getElement(int type, String elementString) {
		
		// Trying to use switch here, but cant figure out how to make it work with try/catch
		this.validInput = true;

			try {
				
				if (searchType[type].equals(searchType[0])) {
					this.element = pt.forName(elementString);
				}
				
				if (searchType[type].equals(searchType[1])) {
					this.element = pt.forSymbol(elementString);
				}
				
				if (searchType[type].equals(searchType[2])) {
				
					try {
						
						int numAtomique = Integer.parseInt(elementString);
						this.element = pt.forNumber(numAtomique);
						
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Nombre atomique invalide.", "ERREUR", JOptionPane.ERROR_MESSAGE);
						this.validInput = false;
			
					}
				}
				
			} catch (NoSuchElementException e) {
				JOptionPane.showMessageDialog(null, "Ce " + searchType[type] + " d'élément est invalide. Réessayez.", "ERREUR", JOptionPane.ERROR_MESSAGE);
				this.validInput = false;
			}
	}
	
	public double getVariable(int specie, String valueString) {
		
		double value = Double.parseDouble(valueString);
		this.specie = specie;
		this.knownValue = cm.setSigFig(cm.getMoleOf(value), false, 2);
		
		
		System.out.println(knownValue);
		return knownValue;
		
	}
	
	public double findUnknown() {
		
		if (specie == 0) {
			this.unknown = cm.calculNombreElectron(knownValue, element.getElectrons());
		}
		if (specie == 1) {
			this.unknown = cm.calculNombreIon(knownValue, element.getElectrons());
		}
		System.out.println(unknown);
		return cm.setSigFig(unknown, false, 2);
		
	}
	
	public double onConvert(int clickCount) {
		boolean notationScientifique;
		if (clickCount % 2 != 0) {
			this.unknown = cm.getNumberOf(unknown);
			
			notationScientifique = true;
			System.out.println(unknown);
		}
		
		else {
			notationScientifique = false;
			this.unknown = cm.getMoleOf(unknown);
		}
	
		return cm.setSigFig(unknown, notationScientifique, 2);
		
	}
	
	public void onReset() {
		this.unknown = 0;
		this.knownValue = 0;
		this.charge = 0;
		this.specie = -1;
		this.element = null;
	}
	
	public int setInputCharge() {

		element.setCharge(charge);
		return element.getElectrons();
		
	}

}
