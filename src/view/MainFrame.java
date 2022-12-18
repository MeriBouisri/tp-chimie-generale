package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Point;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import controller.UserInput;
import model.Element;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.UIManager;

public class MainFrame extends EventHandler {
	
	private JFrame frame;
	private JPanel inputPane;
	private JPanel calculationPanel;
	
	// Combo boxes
	private JComboBox<String> searchTypeBox;
	private JComboBox<String> entityTypeBox;
	
	// Textfields for input
	private JTextField elementField;
	private JTextField knownVariableField;
	
	// TextFields for display
	private JTextField chargeField;
	private JTextField moleIonField;
	private JTextField nbMoleIonField;
	private JTextField moleElectronField;
	private JTextField nbMoleElectronField;
	private JTextField unknownVariableField;
	
	// Buttons
	private JButton addChargeButton;
	private JButton subtractChargeButton;
	private JButton confirmButton;
	private JButton convertButton;
	private JButton resetButton;
	
	private JLabel elementSelectionLabel;
	private JLabel chargeLabel;
	private JLabel molIonLabel;
	private JLabel molElectronLabel;
	private JLabel separatorLabel;
	private JLabel knownVariableInputLabel;
	private JLabel nbMolIonLabel;
	private JLabel nbMolElectronLabel;
	private JLabel convertLabel;
	private JLabel separatorLabel2;
	private JLabel numberOfKnownLabel;
	
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		//------------------------------------------------------
		//              CREATING MAINFRAME
		//------------------------------------------------------
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//------------------------------------------------------
		//              CREATING PANELS
		//------------------------------------------------------
		inputPane = new JPanel();
		inputPane.setBackground(new Color(255, 255, 255));
		inputPane.setBounds(0, 0, 522, 198);
		frame.getContentPane().add(inputPane, BorderLayout.NORTH);
		inputPane.setLayout(null);
		
		calculationPanel = new JPanel();
		calculationPanel.setBounds(0, 195, 522, 118);
		frame.getContentPane().add(calculationPanel);
		calculationPanel.setLayout(null);
		
		//------------------------------------------------------
		//                 CREATING COMBO BOX
		//------------------------------------------------------
		String[] searchType = getSearchType();
		String[] entityType = getEntityList();
		
		searchTypeBox = new JComboBox<String>();
		searchTypeBox.setOpaque(false);
		searchTypeBox.setModel(new DefaultComboBoxModel<String>(searchType));
		searchTypeBox.setBounds(144, 33, 116, 22);
		inputPane.add(searchTypeBox);
		
		entityTypeBox = new JComboBox<String>();
		entityTypeBox.setModel(new DefaultComboBoxModel<String>(entityType));
		entityTypeBox.setBounds(176, 127, 97, 22);
		inputPane.add(entityTypeBox);
		
		//--------------------------------------------------------
		//                 CREATING INPUT TEXT FIELDS
		//--------------------------------------------------------
		elementField = new JTextField();
		elementField.setBounds(144, 60, 116, 22);
		inputPane.add(elementField);
		elementField.setColumns(10);
		
		knownVariableField = new JTextField();
		knownVariableField.setFont(UIManager.getFont("Button.font"));
		knownVariableField.setBounds(283, 128, 127, 20);
		inputPane.add(knownVariableField);
		knownVariableField.setColumns(10);
		
		//--------------------------------------------------------------
		//                    CREATING BUTTONS
		//--------------------------------------------------------------
		addChargeButton = new JButton("▲");
		addChargeButton.setMargin(new Insets(2, 2, 2, 2));
		addChargeButton.setToolTipText("Augmenter la charge");
		addChargeButton.setBorderPainted(false);
		addChargeButton.setBackground(new Color(137, 192, 237));
		addChargeButton.setBounds(318, 34, 25, 21);
		inputPane.add(addChargeButton);
		
		subtractChargeButton = new JButton("▼");
		subtractChargeButton.setAlignmentX(0.5f);
		subtractChargeButton.setMargin(new Insets(2, 2, 2, 2));
		subtractChargeButton.setToolTipText("Diminuer la charge");
		subtractChargeButton.setBorderPainted(false);
		subtractChargeButton.setBackground(new Color(237, 137, 157));
		subtractChargeButton.setBounds(318, 61, 25, 21);
		inputPane.add(subtractChargeButton);
		
		confirmButton = new JButton("CALCULER");
		confirmButton.setBounds(222, 159, 114, 23);
		inputPane.add(confirmButton);
		
		convertButton = new JButton("Convertir en nombre");
		convertButton.setBounds(318, 90, 173, 23);
		calculationPanel.add(convertButton);
	
		resetButton = new JButton("RESET");
		resetButton.setBounds(226, 324, 89, 23);
		frame.getContentPane().add(resetButton);
		
		//-----------------------------------------------------------
		//               CREATING DISPLAY TEXT FIELDS
		//-----------------------------------------------------------
		chargeField = new JTextField();
		chargeField.setText("0");
		chargeField.setName("");
		chargeField.setEditable(false);
		chargeField.setBounds(353, 33, 30, 49);
		inputPane.add(chargeField);
		chargeField.setColumns(10);
		
		unknownVariableField = new JTextField();
		unknownVariableField.setEditable(false);
		unknownVariableField.setBounds(222, 91, 86, 20);
		calculationPanel.add(unknownVariableField);
		unknownVariableField.setColumns(10);
		
		moleIonField = new JTextField();
		moleIonField.setEditable(false);
		moleIonField.setBounds(110, 11, 23, 20);
		calculationPanel.add(moleIonField);
		moleIonField.setColumns(10);
		
		nbMoleIonField = new JTextField();
		nbMoleIonField.setEditable(false);
		nbMoleIonField.setColumns(10);
		nbMoleIonField.setBounds(93, 42, 63, 20);
		calculationPanel.add(nbMoleIonField);
		
		moleElectronField = new JTextField();
		moleElectronField.setEditable(false);
		moleElectronField.setColumns(10);
		moleElectronField.setBounds(341, 11, 23, 20);
		calculationPanel.add(moleElectronField);
		
		nbMoleElectronField = new JTextField();
		nbMoleElectronField.setEditable(false);
		nbMoleElectronField.setColumns(10);
		nbMoleElectronField.setBounds(324, 42, 63, 20);
		calculationPanel.add(nbMoleElectronField);
		
		//-----------------------------------------------------------
		//                   CREATING LABELS
		//-----------------------------------------------------------
		elementSelectionLabel = new JLabel("Séléctionnez un élément");
		elementSelectionLabel.setBounds(144, 11, 164, 22);
		inputPane.add(elementSelectionLabel);
		
		chargeLabel = new JLabel("Charge");
		chargeLabel.setBounds(329, 15, 46, 14);
		inputPane.add(chargeLabel);
		
		knownVariableInputLabel = new JLabel("Entrez la valeur de la variable connue");
		knownVariableInputLabel.setBounds(187, 103, 257, 14);
		inputPane.add(knownVariableInputLabel);
		
		numberOfKnownLabel = new JLabel("Nombre de");
		numberOfKnownLabel.setBounds(103, 131, 79, 14);
		inputPane.add(numberOfKnownLabel);
		
		molIonLabel = new JLabel("mol ion");
		molIonLabel.setBounds(143, 14, 46, 14);
		calculationPanel.add(molIonLabel);
		
		molElectronLabel = new JLabel("mol électrons");
		molElectronLabel.setBounds(372, 14, 94, 14);
		calculationPanel.add(molElectronLabel);
		
		separatorLabel = new JLabel(".................................................");
		separatorLabel.setBounds(180, 14, 148, 14);
		calculationPanel.add(separatorLabel);
		
		nbMolIonLabel = new JLabel("mol ion");
		nbMolIonLabel.setBounds(166, 45, 46, 14);
		calculationPanel.add(nbMolIonLabel);
		
		nbMolElectronLabel = new JLabel("mol électrons");
		nbMolElectronLabel.setBounds(397, 45, 94, 14);
		calculationPanel.add(nbMolElectronLabel);
		
		convertLabel = new JLabel("Nombre de moles d'inconnue :");
		convertLabel.setBounds(48, 94, 183, 14);
		calculationPanel.add(convertLabel);
		
		separatorLabel2 = new JLabel(".................................................");
		separatorLabel2.setBounds(203, 45, 111, 14);
		calculationPanel.add(separatorLabel2);
		
		frame.setVisible(true);
	}
	
	public void setMouseListener(MouseListener l) {
		addChargeButton.addMouseListener(l);
		subtractChargeButton.addMouseListener(l);
		confirmButton.addMouseListener(l);
		convertButton.addMouseListener(l);
		resetButton.addMouseListener(l);
	}
	
	public String getElementText() {
		return elementField.getText();
	}
	
	public double getKnownVariableValue() {
		BigDecimal knownVariable = new BigDecimal(knownVariableField.getText());
		return knownVariable.doubleValue();
	}
	
	public int getSearchTypeOptionIndex() {
		return searchTypeBox.getSelectedIndex();
	}
	
	public int getEntityTypeOptionIndex() {
		return entityTypeBox.getSelectedIndex();
	}
	
	public void setChargeFieldText(int inputCharge) {
		chargeField.setText(String.valueOf(inputCharge));
	}
	
	public void setUnknownValue(double unknownValue) {
		unknownVariableField.setText(String.valueOf(unknownValue));
	}
	
	public void setUnknownFields(double value, int index) {
		JTextField[] displayFields = { nbMoleElectronField, nbMoleIonField };
		displayFields[index].setText(String.valueOf(value));
	}
	
	public void setConvertText(boolean convert) {
		convertButton.setText(convert ? "Convertir en moles" : "Convertir en nombre");
		convertLabel.setText(convert ? "Nombre d'entités d'inconnue" : "Nombre de moles d'inconnue");
	}
	
	public void setMoleElectronField(int moleElectron) {
		moleElectronField.setText(String.valueOf(moleElectron));
	}
	
	public void setMoleIonField() {
		moleIonField.setText("1");
	}
	
	public void resetTextFields() {
		chargeField.setText("0");
		setConvertText(false);
		
		JTextField[] textFieldList = 
			{elementField, knownVariableField, moleIonField, nbMoleIonField, moleElectronField, nbMoleElectronField, unknownVariableField};
		
		Arrays.asList(textFieldList).stream().forEach(textField -> textField.setText(""));
	}
	
	public boolean isAddChargeButton(MouseEvent e) {
		return e.getSource() == addChargeButton;
	}
	
	public boolean isSubtractChargeButton(MouseEvent e) {
		return e.getSource() == subtractChargeButton;
	}
	
	public boolean isConfirmButton(MouseEvent e) {
		return e.getSource() == confirmButton;
	}
	
	public boolean isConvertButton(MouseEvent e) {
		return e.getSource() == convertButton;
	}
	
	public boolean isResetButton(MouseEvent e) {
		return e.getSource() == resetButton; 
	}

}
