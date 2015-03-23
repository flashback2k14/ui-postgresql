package hitme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class View extends JPanel implements Observer {

	private static final long serialVersionUID = -4920394707448061997L;

	public Model model;
	
	public void initialise(Model model, Controller controller) {
		this.model = model;
		this.addMouseListener(controller);
	}

	@Override
	public void update(Observable ob, Object o) {

		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Target t : model.targets) {
			
			Graphics2D g2 = (Graphics2D) g.create();
			Color color = t.fadeColour(20);
			
			g2.setColor(color);
			
			Ellipse2D.Double elDo = new Ellipse2D.Double(t.position.x - (t.size / 2), t.position.y - (t.size / 2), t.size, t.size);
	 		Shape shape = elDo;
	 		
	 		g2.fill(shape);
		}
		
		g.dispose();
	}
}
