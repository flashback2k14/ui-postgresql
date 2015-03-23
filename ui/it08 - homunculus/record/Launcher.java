package record;

import javax.swing.JFrame;

public class Launcher {

	public static void main(String[] args) {

		Controller controller = new Controller();
		JFrame f = new JFrame();
		MainPanel mainPanel = new MainPanel(controller);
		
		f.add(mainPanel);
		
		f.setTitle("Homunculus");
		f.setLocation(50,50);
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
