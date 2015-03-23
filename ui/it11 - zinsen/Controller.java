import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Controller implements ActionListener {
	/**
	 * Attribute
	 */
	public Model model;
	public View view;
	/**
	 * init
	 */
	public void initialise(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	/**
	 * Methode
	 */
	public void update() {
		int laufzeit = 0;
		double startkapital = 0;
		int zinsfusz = 0;
		
		try {
			laufzeit = Integer.valueOf(view.txtLaufzeit.getText());
			startkapital = Double.valueOf(view.txtStartkapital.getText());
			zinsfusz = Integer.valueOf(view.txtZinsfusz.getText());
			
			view.txtLaufzeit.setForeground(Color.WHITE);
			view.txtStartkapital.setForeground(Color.WHITE);
			view.txtZinsfusz.setForeground(Color.WHITE);
			
		} catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(view, e.getMessage(), "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
			
			view.txtLaufzeit.setForeground(Color.RED);
			view.txtStartkapital.setForeground(Color.RED);
			view.txtZinsfusz.setForeground(Color.RED);
		}
		
		model.initialise(zinsfusz, laufzeit, startkapital);
		view.repaint();
	}
	/**
	 * Ereignisverarbeitung
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch (e.getActionCommand()) {
		case View.CALCULATE_ZINS_TEXT:
			
			view.diagramPanel.setActiveDiagram(View.CALCULATE_ZINS_TEXT);
			update();
			
			break;
			
		case View.CALCULATE_ZINSESZINS_TEXT:
			
			view.diagramPanel.setActiveDiagram(View.CALCULATE_ZINSESZINS_TEXT);
			update();
			
			break;
			
		case View.SHOW_INFORMATION_TEXT:
			
			Dialogue dialogue = new Dialogue();
			dialogue.initialise();
			
			break;

		default:
			break;
		}
	}
}
