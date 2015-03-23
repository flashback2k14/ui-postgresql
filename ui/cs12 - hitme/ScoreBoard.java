package hitme;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel implements Observer {

	private static final long serialVersionUID = -8280983828845741973L;
	private JLabel lblScore;
	private Model model;
	
	public ScoreBoard(Model m) {
		JLabel lbl = new JLabel("Score");
		lblScore = new JLabel("0");
		
		this.model = m;
		
		add(lbl, BorderLayout.NORTH);
		add(lblScore, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable ob, Object o) {
		
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		lblScore.setText(String.valueOf(this.model.score));
	}
}
