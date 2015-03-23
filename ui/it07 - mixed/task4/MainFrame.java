package task4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 274174717087079174L;
	
	JSlider slider;
	JSpinner spinner;
	
	public MainFrame() {
		slider = new JSlider();
		spinner = new JSpinner();
		
		slider.setValue(0);
		spinner.setValue(0);
		
		slider.setMinimum(0);
		slider.setMaximum(10);
		
		MyChangeListener changeListener = new MyChangeListener();
		slider.addChangeListener(changeListener);
		spinner.addChangeListener(changeListener);
		
		this.add(slider, BorderLayout.NORTH);
		this.add(spinner, BorderLayout.SOUTH);
	}
	
	
	class MyChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
		
			Object o = e.getSource();
			
			if (o instanceof JSlider) {
				
				spinner.setValue(((JSlider) o).getValue());
				
			} else if (o instanceof JSpinner) {
				
				int value = (int) ((JSpinner) o).getValue();
				
				if (value < 0) {
					((JSpinner) o).setValue(0);
				} else if (value > 10) {
					((JSpinner) o).setValue(10);
				} else {
					slider.setValue(value);
				}
				
			} else {
				System.out.println("unknown component");
			}
		}	
	}
}
