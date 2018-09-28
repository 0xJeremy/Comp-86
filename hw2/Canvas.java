import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
		g.drawLine(50, 50, 100, 50);
		g.drawString("I wish I went to Brown", 40, 70);
		g.drawRect(35, 45, 25, 35);
	}
}