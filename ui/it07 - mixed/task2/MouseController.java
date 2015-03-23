package task2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseController extends MouseAdapter {

	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);

		Object o = e.getSource();

		Component component = (Component)o;
			
		float r = new Random().nextFloat();
		
		Color color = new Color(r, r, 1f);
		
		component.setBackground(color);
	}
}
