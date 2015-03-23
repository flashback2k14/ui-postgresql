package record;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 5644558068458256344L;

	public ButtonPanel(Controller controller) {
		
		JButton btnYellow = new JButton(ActionConstants.YELLOW);
		JButton btnRed = new JButton(ActionConstants.RED);
		
		btnYellow.setActionCommand(ActionConstants.YELLOW);
		btnRed.setActionCommand(ActionConstants.RED);
		
		btnYellow.addActionListener(controller);
		btnRed.addActionListener(controller);
		
		add(btnYellow);
		add(btnRed);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
}
