package task2;

import java.awt.Button;
import java.awt.Frame;

public class MainTask2 {

	public static void main(String[] args) {

		Frame frame = new Frame();
		Button button = new Button();
		
		WindowController windowController = new WindowController();
		MouseController mouseController = new MouseController();
		
		button.addMouseMotionListener(mouseController);
		frame.addWindowListener(windowController);
		
		frame.add(button);
		frame.setLocation(100,100);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}