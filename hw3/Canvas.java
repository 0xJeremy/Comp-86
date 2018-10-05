import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener{
	private boolean flag = false;

	Canvas () {
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		for(int i = 0; i < 60; i++)
		{
			if(i % 2 == 0) {
				g.setColor(Color.BLACK);
			}
			g.drawOval(40+i, 40+i, i*10, i*10);
			g.setColor(Color.GREEN);
		}
		if(flag) {
			g.fillOval(0, 0, 1000, 1000);
		}
	}

	public void fill_display() {
		flag ^= true;
		repaint();
	}


	public void mousePressed(MouseEvent event) {
			System.out.println("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
	}
	public void mouseReleased (MouseEvent event) {}
    public void mouseClicked (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
}