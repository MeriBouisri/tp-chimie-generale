package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.UserInput;

public class EventHandler extends UserInput implements MouseListener {
	
	MainFrame window;
	UserInput input;
	
	private int charge;
	private int clickCount = 1;

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
	
	private void onConfirm() {
		setElementSearchType(window.getSearchTypeOptionIndex());
		setElement(window.getElementText());
		setInputCharge(charge);
		setKnownVariable(window.getKnownVariableValue());
		setKnownEntity(window.getEntityTypeOptionIndex());
		setDisplayText();
	}
	
	private void setDisplayText() {
		window.setMoleElectronField(getNumElectrons());
		window.setMoleIonField();
		window.setUnknownFields(getMoleOfKnownVariable(), window.getEntityTypeOptionIndex());
		window.setUnknownValue(findUnknown());
	}
	
	private void onConvert() {
		clickCount++;
		boolean convert = clickCount % 2 == 0;
		window.setConvertText(convert);
		window.setUnknownValue(convertValue(convert));
	}
	
	private void onReset() {
		resetValues();
		clickCount = 1;
		window.resetTextFields();
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
