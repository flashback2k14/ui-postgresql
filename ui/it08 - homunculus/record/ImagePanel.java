package record;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = -1209925582246091837L;
	private static final int[] X = {224, 236, 240, 240, 240, 252, 252, 260, 268, 280, 268, 268, 250, 244, 230, 220};
	private static final int[] Y = {90, 100, 124, 140, 156, 174, 190, 210, 212, 224, 222, 248, 244, 214, 178, 126};
	public static final Polygon POLYGON = new Polygon(X, Y, X.length);
	public static final Color COLOR = new Color(1f, 0f, 0f, 0.3f);
	public static boolean PAINTED = false;
	
	public ImagePanel(Controller controller) {			
		
		JLabel label = new JLabel(determineIcon("skeleton_ventral.jpeg"));
		label.addMouseMotionListener(controller);
		
		add(label);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	public Icon determineIcon(String file) {		
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(file));
	}
}
