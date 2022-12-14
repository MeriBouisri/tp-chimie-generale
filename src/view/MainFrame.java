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

	public int type;
	public String element;
	public Element x;
	public int nbElectron;
	
	private JLabel elementSelectionLabel;
	private JLabel chargeLabel;
	private JButton testButton;
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
		elementSelectionPane.setBounds(0, 0, 522, 93);
		frame.getContentPane().add(elementSelectionPane, BorderLayout.NORTH);
		elementSelectionPane.setLayout(null);
		
		elementComboBox = new JComboBox<String>();
		elementComboBox.setOpaque(false);
		String[] searchType = getSearchType();
		elementComboBox.setModel(new DefaultComboBoxModel<String>(searchType));
		elementComboBox.setBounds(84, 33, 116, 22);
		elementComboBox.addActionListener(this);
		elementSelectionPane.add(elementComboBox);
		
		elementField = new JTextField();
		elementField.addActionListener(this);
		elementField.setBounds(84, 60, 116, 22);
		elementSelectionPane.add(elementField);
		elementField.setColumns(10);
		
		addChargeButton = new JButton("▲");
		addChargeButton.addMouseListener(this);
		addChargeButton.setMargin(new Insets(2, 2, 2, 2));
		addChargeButton.setToolTipText("Augmenter la charge");
		addChargeButton.setBorderPainted(false);
		addChargeButton.setBackground(new Color(137, 192, 237));
		addChargeButton.setBounds(246, 34, 25, 21);
		elementSelectionPane.add(addChargeButton);
		
		chargeField = new JTextField();
		chargeField.setText(String.valueOf(getInputCharge()));
		chargeField.setName("");
		chargeField.setEditable(false);
		chargeField.setBounds(281, 33, 30, 49);
		elementSelectionPane.add(chargeField);
		chargeField.setColumns(10);
		
		substractChargeButton = new JButton("▼");
		substractChargeButton.setAlignmentX(0.5f);
		substractChargeButton.setMargin(new Insets(2, 2, 2, 2));
		substractChargeButton.setToolTipText("Diminuer la charge");
		substractChargeButton.setBorderPainted(false);
		substractChargeButton.setBackground(new Color(237, 137, 157));
		substractChargeButton.setBounds(246, 61, 25, 21);
		substractChargeButton.addMouseListener(this);
		elementSelectionPane.add(substractChargeButton);
		
		elementSelectionLabel = new JLabel("Séléctionnez un élément");
		elementSelectionLabel.setBounds(79, 11, 127, 22);
		elementSelectionPane.add(elementSelectionLabel);
		
		chargeLabel = new JLabel("Charge");
		chargeLabel.setBounds(265, 15, 46, 14);
		elementSelectionPane.add(chargeLabel);
		
		testButton = new JButton("TEST");
		testButton.addMouseListener(this);
		testButton.setBounds(388, 34, 89, 23);
		
		elementSelectionPane.add(testButton);
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
			type = elementComboBox.getSelectedIndex();
			element = elementField.getText();
			getElement(type, element);
			System.out.println(setInputCharge());
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
