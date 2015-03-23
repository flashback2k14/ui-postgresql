package record;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailPanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 2736263065492935938L;
	private JLabel label;

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public Icon getIcon() {
		return label.getIcon();
	}

	public void setIcon(Icon icon) {
		label.setIcon(icon);
	}

	public DetailPanel() {
		label = new JLabel();
		add(label);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
}
