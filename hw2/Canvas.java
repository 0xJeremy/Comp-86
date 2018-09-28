import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
		for(int i = 0; i < 60; i++)
		{
			g.drawOval(40+i, 40+i, i*10, i*10);
		}
	}
}