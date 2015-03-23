
public class LaunchIT2009 {

	public static void main(String[] args) {

		Model model = new Model();
		MainFrame view = new MainFrame();
		Controller controller = new Controller();
		
		controller.view = view;
		
		model.initialise();
		
		controller.model = model;
		view.model = model;
		
		view.controller = controller;
		
		view.initialise();
	}
}