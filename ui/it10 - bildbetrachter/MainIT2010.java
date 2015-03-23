
public class MainIT2010 {

	public static void main(String[] args) {
	
		Model model = new Model();
		MainFrame view = new MainFrame();
		Controller controller = new Controller();

		model.initialise();
		view.initialise(controller, model);
		controller.initialise(model, view);
		
	}
}