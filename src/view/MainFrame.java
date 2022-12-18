package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.swing.JLabel;

/**
 * Cette classe contient le design de l'interface graphique créé avec WindowBuilder.
 * Les méthodes de cette classe permettent de communiquer avec la classe {@code EventHandler}
 * afin de traiter les données entrées par l'utilisateur.
 * @author Merieme Bouisri
 */
public class MainFrame {
	
	private JFrame frame;
	private JPanel inputPane;
	private JPanel calculationPanel;
	
	// Combo boxes
	private JComboBox<String> searchTypeBox;
	private JComboBox<String> entityTypeBox;
	private String[] searchType = new String[] {"NOM", "SYMBOLE", "NOMBRE ATOMIQUE"};
	private String[] entityType = new String[] {"D'ELECTRONS", "D'IONS"};
	
	// Textfields for input
	private JTextField elementField;
	private JTextField knownVariableField;
	
	// TextFields for display
	private JTextField chargeField;
	private JTextField unknownVariableField;
	/** Textfield pour 1 mol d'ion (0, 0) */
	private JTextField upperLeftVariableField;
	/** Textfield pour nombre de moles d'ion (1, 0)*/
	private JTextField lowerLeftVariableField;
	/** Textfield pour mol d'électrons dans 1 mol d'ion (0, 1) */
	private JTextField upperRightVariableField;
	/** Textfield pour nombre de moles d'électrons (1, 1)*/
	private JTextField lowerRightVariableField;
	
	// Buttons
	private JButton addChargeButton;
	private JButton subtractChargeButton;
	private JButton confirmButton;
	private JButton convertButton;
	private JButton resetButton;
	
	// Labels
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
		
		
		// Text fields that display variables according to their
		// placement in the cross product
		
		upperLeftVariableField = new JTextField();
		upperLeftVariableField.setEditable(false);
		upperLeftVariableField.setBounds(110, 11, 23, 20);
		calculationPanel.add(upperLeftVariableField);
		upperLeftVariableField.setColumns(10);
		
		lowerLeftVariableField = new JTextField();
		lowerLeftVariableField.setEditable(false);
		lowerLeftVariableField.setColumns(10);
		lowerLeftVariableField.setBounds(93, 42, 63, 20);
		calculationPanel.add(lowerLeftVariableField);
		
		upperRightVariableField = new JTextField();
		upperRightVariableField.setEditable(false);
		upperRightVariableField.setColumns(10);
		upperRightVariableField.setBounds(341, 11, 23, 20);
		calculationPanel.add(upperRightVariableField);
		
		lowerRightVariableField = new JTextField();
		lowerRightVariableField.setEditable(false);
		lowerRightVariableField.setColumns(10);
		lowerRightVariableField.setBounds(324, 42, 63, 20);
		calculationPanel.add(lowerRightVariableField);
		
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
	
	/**
	 * Méthode pour attribuer un mouseListener à chaque boutton.
	 * Cela permet de gérer les actions à partir d'une classe différente.
	 * @param l Classe qui contient les actions associées au MouseListener
	 */
	public void setMouseListener(MouseListener l) {
		addChargeButton.addMouseListener(l);
		subtractChargeButton.addMouseListener(l);
		confirmButton.addMouseListener(l);
		convertButton.addMouseListener(l);
		resetButton.addMouseListener(l);
	}
	
	/**
	 * @return L'élément que l'utilisateur recherche
	 */
	public String getElementText() {
		return elementField.getText();
	}
	
	/**
	 * Cette méthode permet de récupérer la valeur entrée dans le knownVariableField.
	 * @return Valeur connue dans son format original
	 */
	public double getKnownVariableValue() {
		// Convertir en Big Decimal afin de conserver le format dans lequel 
		// le double a été entré. Permet de déterminer chiffres significatifs après.
		BigDecimal knownVariable = new BigDecimal(knownVariableField.getText());
		return knownVariable.doubleValue();
	}
	
	/**
	 * Cette methode permet de recuperer l'indice de selection dans searchTypeBox.
	 * @return 0 -> Name, 1 -> Symbol, 2 -> Atomic Number
	 */
	public int getSearchTypeOptionIndex() {
		return searchTypeBox.getSelectedIndex();
	}
	
	/**
	 * Cette methode permet de recuperer l'indice de selection dans entityTypeBox.
	 * @return 0 -> Electrons, 1 -> Ions
	 */
	public int getEntityTypeOptionIndex() {
		return entityTypeBox.getSelectedIndex();
	}
	
	/**
	 * Cette méthode permet d'afficher la valeur de la charge de l'ion en même temps que
	 * l'utilisateur la modifie.
	 * @param inputCharge Charge entrée
	 */
	public void setChargeFieldText(int inputCharge) {
		chargeField.setText(String.valueOf(inputCharge));
	}
	
	/**
	 * Cette méthode permet d'inscrire la valeur de l'inconnue dans le textField approprié
	 * @param unknownValue Valeur inconnue
	 */
	public void setUnknownValue(double unknownValue) {
		unknownVariableField.setText(String.valueOf(unknownValue));
	}
	
	/**
	 * Cette méthode permet d'insérer la valeur connue dans le textField approprié.
	 * Si l'entité connue sont les électrons, index = 0. Si ce sont les ions, index = 1.
	 * @param value Valeur à montrer
	 * @param entityIndex Indice du textField ou insérer la valeur
	 */
	public void setKnownValueDisplayField(double value, int entityIndex) {
		JTextField[] displayFields = { lowerRightVariableField, lowerLeftVariableField };
		displayFields[entityIndex].setText(String.valueOf(value));
	}
	
	/**
	 * Cette méthode contient les chaînes de charactère attribuées à {@code convertButton} et {@code convertLabel}
	 * pour indiquer la direction des conversions avec le nombre d'Avogadro.
	 * @param convert {@code true} si la valeur de l'inconnue doit etre en nombre, {@code false} si la valeur de 
	 * l'inconnue doit etre en nombre de moles.
	 */
	public void setConvertText(boolean convert) {
		convertButton.setText(convert ? "Convertir en moles" : "Convertir en nombre");
		convertLabel.setText(convert ? "Nombre d'entités d'inconnue" : "Nombre de moles d'inconnue");
	}
	
	/**
	 * Cette méthode permet d'afficher le nombre d'électrons dans 1 ion dans le textField (0, 1).
	 * @param molElectron Nombre d'électrons dans 1 mol d'ion.
	 */
	public void setUpperRightVariableField(int molElectron) {
		upperRightVariableField.setText(String.valueOf(molElectron));
	}
	
	/**
	 * Cette méthode permet d'afficher la valeur "1" dans le textField (0,0).
	 * Ce textField représente 1 mol d'ion.
	 */
	public void setUpperLeftVariableField() {
		upperLeftVariableField.setText("1");
	}
	
	/**
	 * Méthode pour réinitialisé le text dans les display textFields.
	 */
	public void resetTextFields() {
		chargeField.setText("0");
		setConvertText(false);
		
		JTextField[] textFieldList = 
			{elementField, knownVariableField, upperLeftVariableField, lowerLeftVariableField, upperRightVariableField, lowerRightVariableField, unknownVariableField};
		
		Arrays.asList(textFieldList).stream().forEach(textField -> textField.setText(""));
	}
	
	// Méthodes récupérer informer d'autres classes qu'un certain boutton a été cliqué
	
	/**
	 * (@code addChargeButton) a été cliqué.
	 */
	public boolean isAddChargeButton(MouseEvent e) {
		return e.getSource() == addChargeButton;
	}
	
	/**
	 * (@code subtractChargeButton) a été cliqué.
	 */
	public boolean isSubtractChargeButton(MouseEvent e) {
		return e.getSource() == subtractChargeButton;
	}
	
	/**
	 * (@code confirmButton) a été cliqué.
	 */
	public boolean isConfirmButton(MouseEvent e) {
		return e.getSource() == confirmButton;
	}
	
	/**
	 * {@code convertButton} a été cliqué.
	 */
	public boolean isConvertButton(MouseEvent e) {
		return e.getSource() == convertButton;
	}
	
	/**
	 * {@code resetButton} a été cliqué.
	 */
	public boolean isResetButton(MouseEvent e) {
		return e.getSource() == resetButton; 
	}
}
