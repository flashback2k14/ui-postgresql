import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2269971701250845501L;
	private JMenu menuFile, menuSettings, menuHelp;
	private JMenuItem itemExit, itemAbout;
	private JRadioButtonMenuItem itemEnglish, itemGerman;
	private JMenuBar menuBar;
	
	public Model model;

	public void initialise(Controller controller, Model model) {
		
		this.model = model;
		
		buildMenu(controller);
		buildPanel(controller);
		
		this.setTitle("Gallery");
		this.setLocation(new Point(100, 100));
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void buildMenu(Controller controller) {
		menuBar = new JMenuBar();
		menuFile = new JMenu();
		menuSettings = new JMenu();
		menuHelp = new JMenu();
		
		itemExit = new JMenuItem();
		itemEnglish = new JRadioButtonMenuItem();
		itemGerman = new JRadioButtonMenuItem();
		itemAbout = new JMenuItem();
					
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(itemEnglish);
		buttonGroup.add(itemGerman);
		itemEnglish.setSelected(true);
			
		itemExit.setActionCommand(ActionConstants.EXIT);
		itemEnglish.setActionCommand(ActionConstants.ENGLISH);
		itemGerman.setActionCommand(ActionConstants.GERMAN);
		itemAbout.setActionCommand(ActionConstants.ABOUT);
		
		itemExit.addActionListener(controller);
		itemEnglish.addActionListener(controller);
		itemGerman.addActionListener(controller);
		itemAbout.addActionListener(controller);
		
		menuFile.add(itemExit);
		menuSettings.add(itemEnglish);
		menuSettings.add(itemGerman);
		menuHelp.add(itemAbout);
		
		menuBar.add(menuFile);
		menuBar.add(menuSettings);
		menuBar.add(menuHelp);
		
		this.setJMenuBar(menuBar);
	}
	
	private void buildPanel(Controller controller) {

		GridLayout gridLayout = new GridLayout(3, 3, 5, 5);
		this.setLayout(gridLayout);
		
		String imgDir = "src/image";
		File dir = new File(imgDir);
		
		File[] files = dir.listFiles();
		
		for(File f : files) {
			ImageIcon imageIcon = new ImageIcon(f.getAbsolutePath());
			JButton button = new JButton(imageIcon);
			button.setText(f.getAbsolutePath());
			button.setActionCommand(ActionConstants.SHOW);
			button.addActionListener(controller);
			this.getContentPane().add(button);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		menuFile.setText(model.language.getString("File"));
		menuSettings.setText(model.language.getString("Settings"));
		menuHelp.setText(model.language.getString("Help"));
		
		itemExit.setText(model.language.getString("Exit"));
		itemEnglish.setText(model.language.getString("English"));
		itemGerman.setText(model.language.getString("German"));
		itemAbout.setText(model.language.getString("About"));
		
		menuFile.setMnemonic(menuFile.getText().charAt(0));
		menuSettings.setMnemonic(menuSettings.getText().charAt(0));
		menuHelp.setMnemonic(menuHelp.getText().charAt(0));
		
		itemExit.setMnemonic(itemExit.getText().charAt(0));
		itemEnglish.setMnemonic(itemEnglish.getText().charAt(0));
		itemGerman.setMnemonic(itemGerman.getText().charAt(0));
		itemAbout.setMnemonic(itemAbout.getText().charAt(0));	
		
		itemExit.setAccelerator(KeyStroke.getKeyStroke(itemExit.getText().charAt(0), KeyEvent.CTRL_DOWN_MASK));
		itemEnglish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		itemGerman.setAccelerator(KeyStroke.getKeyStroke(itemGerman.getText().charAt(0), KeyEvent.CTRL_DOWN_MASK));
		itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
	}
}
