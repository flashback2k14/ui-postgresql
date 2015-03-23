import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame {
	/**
	 * Attribute
	 */
	private static final long serialVersionUID = -8215973777232473220L;

	public static final String CALCULATE_ZINS_TEXT = "Berechne Zins";
	public static final String CALCULATE_ZINSESZINS_TEXT = "Berechne Zinseszins";
	public static final String SHOW_INFORMATION_TEXT = "Zeige Information";
	
	public DiagramPanel diagramPanel;
	public JTextField txtLaufzeit, txtStartkapital, txtZinsfusz;
	public Model model;
	/**
	 * init
	 */
	public void initialise(Model model, Controller controller) {
		this.model = model;
		
		JPanel pEdit = new JPanel();
		JPanel pButton = new JPanel();
		this.diagramPanel = new DiagramPanel();
		
		initialiseEditPanel(pEdit);
		initialiseButtonPanel(pButton, controller);
		initialiseDiagramPanel(diagramPanel, model);
		
		this.add(pEdit, BorderLayout.NORTH);
		this.add(pButton, BorderLayout.SOUTH);
		this.add(diagramPanel, BorderLayout.CENTER);
		
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * Methoden
	 */
	private void initialiseEditPanel(JPanel pEdit) {
		GridLayout gridLayout = new GridLayout(3, 2, 5, 5);
		pEdit.setLayout(gridLayout);
		
		JLabel lblLaufzeit = new JLabel("Laufzeit");
		JLabel lblStartkapital = new JLabel("Startkapital");
		JLabel lblZinsfusz = new JLabel("Zinsfuﬂ");
		
		this.txtLaufzeit = new JTextField(10);
		this.txtStartkapital = new JTextField(10);
		this.txtZinsfusz = new JTextField(10);
		
		pEdit.add(lblLaufzeit);
		pEdit.add(txtLaufzeit);
		pEdit.add(lblStartkapital);
		pEdit.add(txtStartkapital);
		pEdit.add(lblZinsfusz);
		pEdit.add(txtZinsfusz);
	}
	
	private void initialiseButtonPanel(JPanel pButton, Controller c) {
		
		JButton btnBerechneZins = new JButton(CALCULATE_ZINS_TEXT);
		JButton btnBerechneZZins = new JButton(CALCULATE_ZINSESZINS_TEXT);
		JButton btnZeigeInfos = new JButton(SHOW_INFORMATION_TEXT);
		
		btnBerechneZins.setMnemonic('B');
		btnBerechneZZins.setMnemonic('Z');
		btnZeigeInfos.setMnemonic('I');
		
		btnBerechneZins.setActionCommand(CALCULATE_ZINS_TEXT);
		btnBerechneZZins.setActionCommand(CALCULATE_ZINSESZINS_TEXT);
		btnZeigeInfos.setActionCommand(SHOW_INFORMATION_TEXT);
		
		btnBerechneZins.addActionListener(c);
		btnBerechneZZins.addActionListener(c);
		btnZeigeInfos.addActionListener(c);
		
		pButton.add(btnBerechneZins);
		pButton.add(btnBerechneZZins);
		pButton.add(btnZeigeInfos);
	}
	
	private void initialiseDiagramPanel(DiagramPanel pDiagram, Model m) {
		
		pDiagram.setModel(m);
		pDiagram.setActiveDiagram(CALCULATE_ZINS_TEXT);
		pDiagram.setBackground(Color.YELLOW);
	}
}
