import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


public class Model {

	public ResourceBundle language;
	public ResourceBundle english;
	public ResourceBundle german;
	
	private Locale de;
	private Locale eng;
	
	public void initialise() {
		
		de = new Locale("de", "DE");
		eng = new Locale("en", "GB");
		
		try {
			english = PropertyResourceBundle.getBundle("resource/menu", eng);
			german = PropertyResourceBundle.getBundle("resource/menu", de);
		} catch (MissingResourceException mre) {
			JOptionPane.showMessageDialog(null, mre.getMessage(), "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
		}		
		
		language = english;
	}
}
