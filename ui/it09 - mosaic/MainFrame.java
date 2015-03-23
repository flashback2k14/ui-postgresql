import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 681568717064275555L;
	private JLabel[] labels;
	
	public Model model;
	public Controller controller;
	public JPopupMenu popupMenu;
	
	
	public MainFrame() {
		labels = new JLabel[49];
		popupMenu = new JPopupMenu("Menu");
	}
	
	public void initialise() {
			
		buildMenu();
		
		JPanel colourPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		colourPanel.setSize(new Dimension(400, 400));
		colourPanel.setBackground(Color.LIGHT_GRAY);
		
		GridLayout gridLayout = new GridLayout(7, 7, 5, 5);
		colourPanel.setLayout(gridLayout);
		
		for(int i = 0; i < labels.length; i++) {
			JLabel lbl = new JLabel();
			lbl.setText(String.valueOf(i));
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setOpaque(true);
			lbl.addMouseListener(controller);
			labels[i] = lbl;
			colourPanel.add(lbl);
		}
		
		JButton btnMix = new JButton(Controller.MIX);
		JButton btnReset = new JButton(Controller.RESET);
		
		btnMix.setActionCommand(Controller.MIX);
		btnReset.setActionCommand(Controller.RESET);
		
		btnMix.addActionListener(controller);
		btnReset.addActionListener(controller);
		
		buttonPanel.add(btnMix);
		buttonPanel.add(btnReset);
		
		this.getContentPane().add(colourPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationByPlatform(true);
		this.setTitle("Mosaic");
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void buildMenu() {
				
		JMenuItem itemMix = new JMenuItem(Controller.MIX);
		JMenuItem itemReset = new JMenuItem(Controller.RESET);
		JMenuItem itemCopy = new JMenuItem(Controller.COPY);
		JMenuItem itemPaste = new JMenuItem(Controller.PASTE);
		
		itemMix.setActionCommand(Controller.MIX);
		itemReset.setActionCommand(Controller.RESET);
		itemCopy.setActionCommand(Controller.COPY);
		itemPaste.setActionCommand(Controller.PASTE);
		
		itemMix.addActionListener(controller);
		itemReset.addActionListener(controller);
		itemCopy.addActionListener(controller);
		itemPaste.addActionListener(controller);
		
		this.popupMenu.add(itemMix);
		this.popupMenu.add(itemReset);
		this.popupMenu.addSeparator();
		this.popupMenu.add(itemCopy);
		this.popupMenu.add(itemPaste);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Color[] color = new Color[labels.length]; 
		color = model.getColours();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i].setBackground(color[i]);
		}
	}
}
