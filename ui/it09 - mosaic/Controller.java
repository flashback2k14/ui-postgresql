import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;


public class Controller extends MouseAdapter implements ActionListener {

	public static final String MIX = "Mix";
	public static final String RESET = "Reset";
	public static final String COPY = "Copy";
	public static final String PASTE = "Paste";
	
	public Model model;
	public MainFrame view;
	
	private int index;
	private Color colour;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case MIX:	
			model.mixAllColours();
			view.repaint();
			break;

		case RESET:
			model.resetAllColours();
			view.repaint();
			break;
			
		case COPY:
			model.storedColour = colour;			
			break;
			
		case PASTE:
			model.copyColour(this.index, model.storedColour);
			view.repaint();
			break;
			
		default:
			break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);

		if (e.getSource() instanceof JLabel) {

			JLabel lbl = (JLabel) e.getSource();
			
			int i = Integer.parseInt(lbl.getText());
			Color c = lbl.getBackground();
			
			if (e.getButton() == MouseEvent.BUTTON1) {
			
				model.mixOneColour(i);
				view.repaint();
				
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				
				view.popupMenu.show(e.getComponent(), e.getX(), e.getY());
				this.index = i;
				this.colour = c;
				
			} else {
				System.out.println("mittlerer Mouse Button clicked!");
			}
		}
	}
}
