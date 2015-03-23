package hitme;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class HitMe {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JDialog dialog = new JDialog();
		
		Model model = new Model();
		model.initialise();
		
		View view = new View();
		Controller controller = new Controller();
		
		ScoreBoard scoreBoard = new ScoreBoard(model);
		
		view.initialise(model, controller);
		model.addObserver(view);
		model.addObserver(scoreBoard);
		
		frame.add(view);
		frame.setTitle("HitMe");
		frame.setLocation(new Point(100, 100));
		frame.setSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		dialog.add(scoreBoard);
		dialog.setTitle("Scoreboard");
		dialog.setSize(new Dimension(100, 100));
		dialog.setLocation(new Point(frame.getWidth() + 100, 100));
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
		
		controller.initialise(model, view, frame.getBounds());
	}
	
	/**
	 * 
	 * Observable Beispiel
	 * 
	 
	public class ObserverClass { 
	    public static void main(String[] args) { 
	        new Erzaehler(); 
	    } 
	} 

	class Erzaehler extends Observable { 
	     
	    public Erzaehler(){ 
	        this.addObserver(new Zuhoerer_1()); 
	        this.addObserver(new Zuhoerer_2()); 
	        tell("hoihoi!"); 
	    } 

	     
	    public void tell(String info){ 
	        if(countObservers() > 0){ 
	            setChanged(); 
	            notifyObservers(info); 
	        } 
	    } 
	} 

	class Zuhoerer_1 extends JFrame implements Observer { 
	     
	    private JTextField field1; 
	     
	    public Zuhoerer_1(){ 
	        field1 = new JTextField("a"); 
	        add(field1); 
	         
	        setTitle("Zuhoerer 1"); 
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        setSize(300, 50); 
	        setVisible(true); 
	    } 
	     
	    public void update(Observable o, Object arg) { 
	        field1.setText((String) arg); 
	    } 
	} 

	class Zuhoerer_2 extends JFrame implements Observer { 
	     
	    private JTextField field2; 
	     
	    public Zuhoerer_2(){ 
	        field2 = new JTextField("b"); 
	        add(field2); 
	         
	        setTitle("Zuhoerer 2"); 
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        setSize(300, 50); 
	        setVisible(true); 
	    } 
	     
	    public void update(Observable o, Object arg) { 
	        field2.setText((String) arg); 
	    } 
	} 
	
	*/
}
