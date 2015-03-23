import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;


public class Dialogue extends JDialog {

	private static final long serialVersionUID = -8869615538472342750L;
   
    public void initialise() {
    
        JTabbedPane t = new JTabbedPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        initialisePanel(p1, "src/resource/dollar.png", "src/resource/dollar.txt");
        initialisePanel(p2, "src/resource/woergl.png", "src/resource/woergl.txt");
        initialisePanel(p3, "src/resource/brakteaten.png", "src/resource/brakteaten.txt");

        t.addTab("Dollar", p1);
        t.addTab("Wörgl", p2);
        t.addTab("Brakteaten", p3);

        add(t);

        setTitle("Information");
        setLocation(200, 200);
        setSize(800, 600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        setVisible(true);
    }
       
    protected void initialisePanel(JPanel panel, String image, String text) {

        LayoutManager m = new BorderLayout();

        panel.setLayout(m);
        initialiseImage(panel, image);
        initialiseText(panel, text);
    }
    
    protected void initialiseImage(JPanel panel, String image) {

        Icon i = new ImageIcon(image);
        JLabel l = new JLabel(i);

        panel.add(l, BorderLayout.NORTH);
    }
    
    protected void initialiseText(JPanel panel, String text) {

        try {
            JTextPane t = new JTextPane();
            FileReader r = new FileReader(text);
            @SuppressWarnings("resource")
			BufferedReader b = new BufferedReader(r);
            String s = "";
            String line = b.readLine();
            
            while (true) {
            
                if (line == null) {
                    break;
                }
            
                s = s + line + "\n";
                line = b.readLine();
            }

            t.setText(s);
            JScrollPane sp = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            panel.add(sp, BorderLayout.CENTER);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Problem beim Einlesen der Textdatei!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
}
