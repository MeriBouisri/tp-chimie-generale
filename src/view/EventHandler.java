package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.UserInput;

public class EventHandler implements MouseListener {
	
	MainFrame window;
	UserInput ui = new UserInput();
	
	private int charge;
	private int convertAvogadro = 1;
	
	public void listenTo(MainFrame window) {
		this.window = window;
	}
	
	private void onAddCharge() {
		this.charge = charge + 1;
		window.setChargeFieldText(charge);
	}
	
	private void onSubtractCharge() {
		this.charge = charge - 1;
		window.setChargeFieldText(charge);
	}
	
	/**
	 * Envoyer toutes les variables connues à {@code UserInput}
	 * pour effectuer le calcul de moles.
	 */
	private void onConfirm() {
		ui.setElementSearchType(window.getSearchTypeOptionIndex());
		ui.setElement(window.getElementText());
		ui.setInputCharge(charge);
		ui.setKnownVariable(window.getKnownVariableValue());
		ui.setKnownEntity(window.getEntityTypeOptionIndex());
		
		setDisplayText();
	}
	
	private void setDisplayText() {
		window.setUpperRightVariableField(ui.getNumElectrons());
		window.setUpperLeftVariableField();
		window.setKnownValueDisplayField(ui.getMoleOfKnownVariable(), window.getEntityTypeOptionIndex());
		
		// Afficher la valeur de la variable inconnue
		window.setUnknownValue(ui.findUnknown());
	}
	
	private void onConvert() {
		convertAvogadro++;
		boolean convert = convertAvogadro % 2 != 0;
		window.setConvertText(convert);
		window.setUnknownValue(ui.convertValue(convert));
	}
	
	private void onReset() {
		ui.resetValues();
		window.resetTextFields();
		convertAvogadro = 1;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (window.isAddChargeButton(e)) {
			onAddCharge();
		}
		
		else if (window.isSubtractChargeButton(e)) {
			onSubtractCharge();
		}
		
		else if (window.isConfirmButton(e)) {
			onConfirm();
		}
		
		else if (window.isConvertButton(e)) {
			onConvert();
		}
		
		else if (window.isResetButton(e)) {
			onReset();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
