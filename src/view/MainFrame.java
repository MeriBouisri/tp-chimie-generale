/**
 * 
 */
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

/**
 * @author merie
 *
 */
public class MainFrame extends UserInput implements ActionListener, MouseListener {

	private JFrame frame;
	private JPanel elementSelectionPane;
	private JComboBox<String> elementComboBox;
	private JTextField elementField;
	private JTextField chargeField;
	private JButton addChargeButton;
	private JButton substractChargeButton;
	
	// Remove later
	public int type;
	public String element;
	public String variableConnue;
	public int entity;
	public Element x;
	public int nbElectron;
	
	private JLabel elementSelectionLabel;
	private JLabel chargeLabel;
	private JButton testButton;
	private JPanel panel;
	private JButton convertButton;
	private JTextField moleIonField;
	private JTextField nbMoleIonField;
	private JTextField moleElectronField;
	private JTextField nbMoleElectronsField;
	private JTextField unknownVariableField;
	private JLabel lblNewLabel;
	private JLabel lblMollectrons;
	private JLabel lblNewLabel_1;
	private JTextField knownVariableField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblMollectrons_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox<String> entiteBox;
	private JLabel lblNewLabel_6;
	private int clickCount = 0;
	private JButton resetButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		elementSelectionPane = new JPanel();
		elementSelectionPane.setBackground(new Color(255, 255, 255));
		elementSelectionPane.setBounds(0, 0, 522, 193);
		frame.getContentPane().add(elementSelectionPane, BorderLayout.NORTH);
		elementSelectionPane.setLayout(null);
		
		elementComboBox = new JComboBox<String>();
		elementComboBox.setOpaque(false);
		String[] searchType = getSearchType();
		elementComboBox.setModel(new DefaultComboBoxModel<String>(searchType));
		elementComboBox.setBounds(144, 33, 116, 22);
		elementComboBox.addActionListener(this);
		elementSelectionPane.add(elementComboBox);
		
		elementField = new JTextField();
		elementField.addActionListener(this);
		elementField.setBounds(144, 60, 116, 22);
		elementSelectionPane.add(elementField);
		elementField.setColumns(10);
		
		addChargeButton = new JButton("▲");
		addChargeButton.addMouseListener(this);
		addChargeButton.setMargin(new Insets(2, 2, 2, 2));
		addChargeButton.setToolTipText("Augmenter la charge");
		addChargeButton.setBorderPainted(false);
		addChargeButton.setBackground(new Color(137, 192, 237));
		addChargeButton.setBounds(318, 34, 25, 21);
		elementSelectionPane.add(addChargeButton);
		
		chargeField = new JTextField();
		chargeField.setText(String.valueOf(getInputCharge()));
		chargeField.setName("");
		chargeField.setEditable(false);
		chargeField.setBounds(353, 33, 30, 49);
		elementSelectionPane.add(chargeField);
		chargeField.setColumns(10);
		
		substractChargeButton = new JButton("▼");
		substractChargeButton.setAlignmentX(0.5f);
		substractChargeButton.setMargin(new Insets(2, 2, 2, 2));
		substractChargeButton.setToolTipText("Diminuer la charge");
		substractChargeButton.setBorderPainted(false);
		substractChargeButton.setBackground(new Color(237, 137, 157));
		substractChargeButton.setBounds(318, 61, 25, 21);
		substractChargeButton.addMouseListener(this);
		elementSelectionPane.add(substractChargeButton);
		
		elementSelectionLabel = new JLabel("Séléctionnez un élément");
		elementSelectionLabel.setBounds(144, 11, 164, 22);
		elementSelectionPane.add(elementSelectionLabel);
		
		chargeLabel = new JLabel("Charge");
		chargeLabel.setBounds(329, 15, 46, 14);
		elementSelectionPane.add(chargeLabel);
		
		knownVariableField = new JTextField();
		knownVariableField.setFont(UIManager.getFont("Button.font"));
		knownVariableField.setBounds(283, 128, 127, 20);
		elementSelectionPane.add(knownVariableField);
		knownVariableField.setColumns(10);
		
		testButton = new JButton("CALCULER");
		testButton.setBounds(222, 159, 114, 23);
		elementSelectionPane.add(testButton);
		
		lblNewLabel_2 = new JLabel("Entrez la valeur de la variable connue");
		lblNewLabel_2.setBounds(187, 103, 257, 14);
		elementSelectionPane.add(lblNewLabel_2);
		
		
		entiteBox = new JComboBox<String>();
		String[] entityType = getEntityList();
		entiteBox.setModel(new DefaultComboBoxModel<String>(entityType));
		entiteBox.setBounds(176, 127, 97, 22);
		elementSelectionPane.add(entiteBox);
		
		lblNewLabel_6 = new JLabel("Nombre de");
		lblNewLabel_6.setBounds(103, 131, 79, 14);
		elementSelectionPane.add(lblNewLabel_6);
		testButton.addMouseListener(this);
		
		panel = new JPanel();
		panel.setBounds(0, 195, 522, 118);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		convertButton = new JButton("Convertir en nombre");
		convertButton.addMouseListener(this);
		convertButton.setBounds(318, 90, 173, 23);
		panel.add(convertButton);
		
		moleIonField = new JTextField();
		moleIonField.setText("1");
		moleIonField.setBounds(110, 11, 23, 20);
		panel.add(moleIonField);
		moleIonField.setColumns(10);
		
		nbMoleIonField = new JTextField();
		nbMoleIonField.setColumns(10);
		nbMoleIonField.setBounds(93, 42, 63, 20);
		panel.add(nbMoleIonField);
		
		moleElectronField = new JTextField();
		moleElectronField.setColumns(10);
		moleElectronField.setBounds(341, 11, 23, 20);
		panel.add(moleElectronField);
		
		nbMoleElectronsField = new JTextField();
		nbMoleElectronsField.setColumns(10);
		nbMoleElectronsField.setBounds(324, 42, 63, 20);
		panel.add(nbMoleElectronsField);
		
		unknownVariableField = new JTextField();
		unknownVariableField.setBounds(203, 91, 86, 20);
		panel.add(unknownVariableField);
		unknownVariableField.setColumns(10);
		
		lblNewLabel = new JLabel("mol ion");
		lblNewLabel.setBounds(143, 14, 46, 14);
		panel.add(lblNewLabel);
		
		lblMollectrons = new JLabel("mol électrons");
		lblMollectrons.setBounds(372, 14, 94, 14);
		panel.add(lblMollectrons);
		
		lblNewLabel_1 = new JLabel(".................................................");
		lblNewLabel_1.setBounds(180, 14, 148, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("mol ion");
		lblNewLabel_3.setBounds(166, 45, 46, 14);
		panel.add(lblNewLabel_3);
		
		lblMollectrons_1 = new JLabel("mol électrons");
		lblMollectrons_1.setBounds(397, 45, 94, 14);
		panel.add(lblMollectrons_1);
		
		lblNewLabel_4 = new JLabel("Nombre de moles d'inconnue :");
		lblNewLabel_4.setBounds(29, 94, 183, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel(".................................................");
		lblNewLabel_5.setBounds(203, 45, 111, 14);
		panel.add(lblNewLabel_5);
		
		resetButton = new JButton("RESET");
		resetButton.addMouseListener(this);
		resetButton.setBounds(226, 324, 89, 23);
		frame.getContentPane().add(resetButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

 		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == addChargeButton) {
			onAddCharge();
			chargeField.setText(String.valueOf(getInputCharge()));
			
		}
		
		if (e.getSource() == substractChargeButton) {
			onSubstractCharge();
			chargeField.setText(String.valueOf(getInputCharge()));
			
		}
		
		if (e.getSource() == testButton) {
			JTextField[] fieldList = { nbMoleElectronsField, nbMoleIonField};
			type = elementComboBox.getSelectedIndex();
			element = elementField.getText();
			entity = entiteBox.getSelectedIndex();
			variableConnue = knownVariableField.getText();
			getElement(type, element);
			
			fieldList[entity].setText(String.valueOf(getVariable(entity, variableConnue)));
			moleElectronField.setText(String.valueOf(setInputCharge()));
			unknownVariableField.setText(String.valueOf(findUnknown()));
			
			//nbMoleElectronsField.setText();
		}
		
		
		if (e.getSource() == convertButton) {
			clickCount += 1;
			System.out.println(clickCount);
			if (clickCount % 2 != 0) {
				convertButton.setText("Convertir en nombre");
				unknownVariableField.setText(String.valueOf(onConvert(clickCount)));
			}
			else {
				convertButton.setText("Convertir en moles");
				unknownVariableField.setText(String.valueOf(onConvert(clickCount)));
			}
		}
		
		if (e.getSource() == resetButton) {
			onReset();
			chargeField.setText("0");
			elementField.setText("");
			knownVariableField.setText("");
			unknownVariableField.setText("");
			nbMoleElectronsField.setText("");
			nbMoleIonField.setText("");
			clickCount = 0;
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
