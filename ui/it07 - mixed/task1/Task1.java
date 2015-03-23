package task1;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Task1 extends Frame {
	
	private static final long serialVersionUID = -6039306067571116257L;

	public Task1(String titel) {
		super(titel);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	
		int[] arr1 = {224, 236, 240, 240, 240, 252, 252, 260, 268, 280, 268, 268, 250, 244, 230, 220};
		int[] arr2 = {90, 100, 124, 140, 156, 174, 190, 210, 212, 224, 222, 248, 244, 214, 178, 126};
	
		Image image = Toolkit.getDefaultToolkit().getImage("src/task1/skeleton_ventral.jpeg");
		
		g.drawImage(image, 0, 0, getParent());
				
		g.setColor(new Color(1f, 0f, 0f, 0.3f));
		
		g.fillPolygon(arr1, arr2, arr1.length);
		
		setSize(image.getWidth(this), image.getHeight(this));
	}
}
