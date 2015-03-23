package record;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 7380740875463717953L;

	public MainPanel(Controller controller) {
		
		setLayout(new BorderLayout());
		
		JPanel panelLeft = new JPanel();
		JPanel panelRight = new JPanel();
		
		ImagePanel imagePanel = new ImagePanel(controller);
		DetailPanel detailPanel = new DetailPanel();
		ButtonPanel buttonPanel = new ButtonPanel(controller);
		
		controller.setImagePanel(imagePanel);
		controller.setDetailPanel(detailPanel);
		
		panelLeft.setLayout(new BorderLayout());
		panelLeft.add(imagePanel, BorderLayout.CENTER);
		
		panelRight.setLayout(new BorderLayout());
		panelRight.add(detailPanel, BorderLayout.CENTER);
		panelRight.add(buttonPanel, BorderLayout.SOUTH);
		
		add(panelLeft, BorderLayout.WEST);
		add(panelRight, BorderLayout.CENTER);
	}	
}
