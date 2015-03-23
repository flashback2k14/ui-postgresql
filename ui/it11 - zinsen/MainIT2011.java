
public class MainIT2011 {

	public static void main(String[] args) {
	
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller();
		
		model.initialise(0, 0, 0);
		controller.initialise(model, view);
		view.initialise(model, controller);	
	}
}