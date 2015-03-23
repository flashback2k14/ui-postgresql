import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;


public class Controller implements ActionListener {

	private Model model;
	private MainFrame view;
	
	public void initialise(Model model, MainFrame view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case ActionConstants.EXIT:
			System.exit(0);
			break;
			
		case ActionConstants.ENGLISH:
			model.language = model.english;
			view.repaint();
			break;
			
		case ActionConstants.GERMAN:
			model.language = model.german;
			view.repaint();
			break;
	
		case ActionConstants.ABOUT:
			new AboutDialogue();
			break;
			
		case ActionConstants.SHOW:
			
			JDialog d = new JDialog();
			JButton button = (JButton) e.getSource();
			JButton btn = new JButton(button.getIcon());
			
			d.add(btn);
			
			d.setTitle(button.getText());
			d.pack();
			d.setLocation(new Point(50, 50));
			d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			d.setVisible(true);
			break;

		default:
			break;
		}
		
	}
}