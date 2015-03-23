package record;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Controller implements ActionListener, MouseMotionListener {

	private ImagePanel imagePanel;
	private DetailPanel detailPanel;
	
	public ImagePanel getImagePanel() {
		return imagePanel;
	}
	
	public void setImagePanel(ImagePanel imagePanel) {
		this.imagePanel = imagePanel;
	}
	
	public DetailPanel getDetailPanel() {
		return detailPanel;
	}
	
	public void setDetailPanel(DetailPanel detailPanel) {
		this.detailPanel = detailPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch (e.getActionCommand()) {
		case ActionConstants.YELLOW:
			if (getDetailPanel().getBackground() != Color.YELLOW) {
				getDetailPanel().setBackground(Color.YELLOW);
				System.out.println("Set Yellow BG in DP");
			}
			break;
			
		case ActionConstants.RED:
			if (getDetailPanel().getBackground() != Color.RED) {
				getDetailPanel().setBackground(Color.RED);
				System.out.println("Set Red BG in DP");
			}
			break;

		default:
			System.out.println("Action command ist unbekannt.");
			break;
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {		
		
		Point p = e.getPoint();
		Graphics g = getImagePanel().getGraphics();
		
		if ((ImagePanel.PAINTED == false) && (ImagePanel.POLYGON.contains(p))) {
			
			g.setColor(ImagePanel.COLOR);
			g.fillPolygon(ImagePanel.POLYGON);
			
			getDetailPanel().setIcon(getImagePanel().determineIcon("arm_ventral.jpeg"));
			ImagePanel.PAINTED = true;
			
		} else if ((ImagePanel.PAINTED) && (ImagePanel.POLYGON.contains(p) == false)) {
			
			getImagePanel().update(g);
			getDetailPanel().setIcon(null);
			ImagePanel.PAINTED = false;			
		}
	}	
}
