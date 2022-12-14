package controller;

import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import model.Element;
import model.PeriodicTable;

public class UserInput {
	
	PeriodicTable pt = new PeriodicTable();
	
	private String[] searchType = new String[] {"NOM", "SYMBOLE", "NOMBRE ATOMIQUE"};
	private Element element;
	private int charge = 0;
	private int numElectrons;
	private int molElectrons;
	private int molIon;
	private int numIon;
	
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
	
	public int getInputCharge() {
		return charge;
	}
	
	public String[] getSearchType() {
		return searchType;
	}

	public void getElement(int type, String elementString) {
		
		// Trying to use switch here, but cant figure out how to make it work with try/catch
		boolean invalidInput;

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
			
					}
				}
				
			} catch (NoSuchElementException e) {
				JOptionPane.showMessageDialog(null, "Ce " + searchType[type] + " d'élément est invalide. Réessayez.", "ERREUR", JOptionPane.ERROR_MESSAGE);
			
			}
		
	}
	
	public int setInputCharge() {
		element.setCharge(charge);
		return element.getElectrons();
	}

}
