package task5;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class MainTask5 {

	
	private static void sayHello(Locale local) {
		
		try {
			ResourceBundle bundle = PropertyResourceBundle.getBundle("task5/resource", local);
			System.out.println(bundle.getString("Hi") + ", " + bundle.getString("To"));
		} catch(MissingResourceException mre) {
			JOptionPane.showMessageDialog(null, mre.getMessage(), "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	
	public static void main(String[] args) {

		sayHello(Locale.getDefault());
		sayHello(Locale.FRANCE);
		sayHello(new Locale("de", "CH"));
		sayHello(Locale.US);
	}
}