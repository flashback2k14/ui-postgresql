import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JLabel;


public class AboutDialogue extends JDialog {

	private static final long serialVersionUID = 5122240127548119438L;

	public AboutDialogue() {
		
		JLabel lblTitel = new JLabel("Klausur IT 2010");
		JLabel lblAuthor = new JLabel("Sebastian Kloppe");
		
		this.add(lblTitel, BorderLayout.NORTH);
		this.add(lblAuthor, BorderLayout.SOUTH);
	
		this.setModal(true);
		this.setTitle("AboutDialog");
		this.setLocation(new Point(150, 150));
		this.setSize(new Dimension(150, 150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
