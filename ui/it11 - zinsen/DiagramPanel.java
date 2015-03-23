

import java.awt.Graphics;

import javax.swing.JPanel;

public class DiagramPanel extends JPanel {

	private static final long serialVersionUID = 4521850601888287089L;
	
	public static final int ORIGOX = 50;
    public static final int ORIGOY = 450;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    // Der Goldpreis fuer 1 kg (Barren).
    public static final double KILOGRAMME = 42361.13;
    public static final double TON = DiagramPanel.KILOGRAMME * 1000;
    // Der Erdpreis fuer 1 Erdkugel aus Gold.
    // Verhaeltnisgleichung:
    // x / 42361.13 EUR == 5.974e24 kg / 1 kg
    // x = 5.974e24 kg * 42361.13 EUR / 1 kg
    // x = 5.974e24 * 42361.13 EUR
    public static final double EARTH = 5.974e24 * DiagramPanel.KILOGRAMME;

    private Model model;
    private String activeDiagram;

    public Model getModel() {

        return this.model;
    }

    public void setModel(Model m) {
    
        this.model = m;
    }

    public String getActiveDiagram() {

        return this.activeDiagram;
    }

    public void setActiveDiagram(String d) {
    
        this.activeDiagram = d;
    }

    /*
     * Spiegele Koordinaten für Bildschirm.
     */
    protected void draw(Graphics g, int px1, int py1, int px2, int py2) {
    
        int x1 = DiagramPanel.ORIGOX + px1;
        int y1 = DiagramPanel.ORIGOY - py1;
        int x2 = DiagramPanel.ORIGOX + px2;
        int y2 = DiagramPanel.ORIGOY - py2;

        // Zeichne Linie.
        g.drawLine(x1, y1, x2, y2);
    }

    /*
     * Übersetze in Punkte des Koordinatensystems.
     * 
     * Nutze Verhältnisgleichung:
     * gesuchter Wert / aktueller Wert = maximum x / maximum Koordinatenachse
     */
    protected void translate(Graphics g, double[] guthaben, int index, int maxx, double maxy) {

        double x1 = index - 1;
        double y1 = guthaben[index - 1];
        double x2 = index;
        double y2 = guthaben[index];

        x1 = x1 / maxx;
        y1 = y1 / maxy;
        x2 = x2 / maxx;
        y2 = y2 / maxy;

        x1 = x1 * DiagramPanel.WIDTH;
        y1 = y1 * DiagramPanel.HEIGHT;
        x2 = x2 * DiagramPanel.WIDTH;
        y2 = y2 * DiagramPanel.HEIGHT;

        draw(g, (int) x1, (int) y1, (int) x2, (int) y2);
    }
    
    protected void paintEndGuthaben(Graphics g, double e) {

        double kg = e / DiagramPanel.KILOGRAMME;
        double t = e / DiagramPanel.TON;
        double earth = e / DiagramPanel.EARTH;

        g.drawString("Endguthaben [EUR]: " + e, DiagramPanel.ORIGOX + 300, DiagramPanel.ORIGOY - 430);
        g.drawString("Endguthaben [kg Gold]: " + kg, DiagramPanel.ORIGOX + 300, DiagramPanel.ORIGOY - 410);
        g.drawString("Endguthaben [t Gold]: " + t, DiagramPanel.ORIGOX + 300, DiagramPanel.ORIGOY - 390);
        g.drawString("Endguthaben [Erdkugel Gold]: " + earth, DiagramPanel.ORIGOX + 300, DiagramPanel.ORIGOY - 370);
    }

    protected void paintZins(Graphics g) {

        // Bestimme Feldlänge.
        int l = this.model.getGuthabenZins().length;
        // Bestimme größten x-Wert und y-Wert.
        int maxx = l;
        double maxyzins = this.model.getGuthabenZins()[l - 1];
        // Zeichne Kurve.
        int j = 1;

        while (true) {

            if (j > (l - 1)) {
            
                break;
            }

            translate(g, this.model.getGuthabenZins(), j, maxx, maxyzins);

            j++;
        }

        // Zeichne Endguthaben.
        double e = this.model.getGuthabenZins()[l - 1];
        paintEndGuthaben(g, e);
    }

    protected void paintZinsesZins(Graphics g) {

        // Bestimme Feldlänge.
        int l = this.model.getGuthabenZinsesZins().length;
        // Bestimme größten x-Wert und y-Wert.
        int maxx = l;
        double maxyzinseszins = this.model.getGuthabenZinsesZins()[l - 1];
        // Zeichne Kurve.
        int j = 1;

        while (true) {

            if (j > (l - 1)) {
            
                break;
            }

            translate(g, this.model.getGuthabenZinsesZins(), j, maxx, maxyzinseszins);

            j++;
        }

        // Zeichne Endguthaben.
        double e = this.model.getGuthabenZinsesZins()[l - 1];
        paintEndGuthaben(g, e);
    }

    @Override
    protected void paintComponent(Graphics g) {

        // Clear background.
        super.paintComponent(g);

        // Zeichne Achsen.
        draw(g, 0, 0, DiagramPanel.WIDTH, 0);
        draw(g, 0, 0, 0, DiagramPanel.HEIGHT);
        
        // Zeichne Beschriftung.
        g.drawString("Guthaben [EUR]", DiagramPanel.ORIGOX - 30, DiagramPanel.ORIGOY - 430);
        g.drawString("Zeit [Jahr]", DiagramPanel.ORIGOX + 650, DiagramPanel.ORIGOY - 0);
        
        
        if (getActiveDiagram().equals(View.CALCULATE_ZINS_TEXT)) {

            paintZins(g);

        } else if (getActiveDiagram().equals(View.CALCULATE_ZINSESZINS_TEXT)) {

            paintZinsesZins(g);
        }
    }
}
