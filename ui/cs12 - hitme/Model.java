package hitme;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

	public ArrayList<Target> targets;
	public int score;
	public int frequency;
	public long time;
	
	public void initialise() {
		
		targets = new ArrayList<Target>();
		score = 0;
		frequency = 100;
		time = System.currentTimeMillis();
	}
	
	public void markChanged() {
		
		setChanged();
	}
}
