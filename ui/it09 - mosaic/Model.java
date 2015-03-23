import java.awt.Color;
import java.util.Random;


public class Model {

	private Color[] colours = null;
	public Color storedColour = null;
	
	public void initialise() {
		colours = new Color[49];
		mixAllColours();
	}
	
	public Color[] getColours() {
		return colours;
	}
	
	public Color getRandomColour() {
		int r = new Random().nextInt(255);
		int g = new Random().nextInt(255);
		int b = new Random().nextInt(255);
		return new Color(r,g,b);
	}
	
	public void mixOneColour(int index) {
		colours[index] = getRandomColour();
	}
	
	public void mixAllColours() {
		for (int i = 0; i < colours.length; i++) {
			mixOneColour(i);
		}
	}
	
	public void resetAllColours() {
		for (int i = 0; i < colours.length; i++) {
			colours[i] = Color.WHITE;
		}
	}
	
	public void copyColour(int index, Color copiedColour) {
		colours[index] = copiedColour;
	}
}
