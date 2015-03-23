package task2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowController extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
	
		System.exit(0);
	
	}
}
