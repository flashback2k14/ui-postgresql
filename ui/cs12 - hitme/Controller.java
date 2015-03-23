package hitme;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.Timer;

public class Controller extends MouseAdapter implements ActionListener {

	public Model model;
	public View view;
	public Timer timer;
	public Rectangle box;
	
	public void initialise(Model model, View view, Rectangle rect) {
		this.model = model;
		this.view = view;
		this.timer = new Timer(1000, this);
		this.box = new Rectangle(rect);
		
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Target t = null;
			
		// The old time.
		long o = this.model.time;
		this.model.time = System.currentTimeMillis() / this.model.frequency;
		
		if (this.model.time != o) {

			for (Iterator<Target> iterator = this.model.targets.iterator(); iterator.hasNext();) {
				t = iterator.next();
				
				t.ageTarget((this.model.time * this.model.frequency));
				
				if (t.age > t.lifespan) {
					iterator.remove();
				}
			}
		}
				
		t = new Target();
		t.initialise(this.box);
		
		this.model.targets.add(t);
		this.model.markChanged();
		this.model.notifyObservers();		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			Point p = e.getPoint();
			
			for(Target t : this.model.targets) {
			 	if (t.containsPoint(p)) {
			 		this.model.score += t.score;
			 		this.model.targets.remove(t);
			 		this.model.markChanged();
			 		this.model.notifyObservers();
			 	}
			}
		}
	}
}
