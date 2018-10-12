import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class model
{
	private ArrayList<vehicle> vehicles;
	private Canvas canvas;
	private static boolean show;

	public model()
	{
		vehicles = new ArrayList<vehicle>();
		show = true;

		for(int i = 0; i < 5; i++) {
			String name = "Boat " + i;
			boat boat1 = new boat(name, (i*100)+10, (i*100)+10, 10, 10);
			vehicles.add(boat1);
			name = "Plane " + i;
			plane plane1 = new plane(name, (i*100)+60, (i*100)+60, 10, 10, 10);
			vehicles.add(plane1);
		}

		canvas = new Canvas();
		canvas.setSize(new Dimension(300, 600));
	}

	public Canvas get_canvas()
	{
		return canvas;
	}

	public void toggle_view()
	{
		canvas.toggle();
	}

	public void set_background(Color c)
	{
		canvas.setBackground(c);
	}

	public class Canvas extends JPanel{

		private boolean show;
		private Color background;

		public Canvas()
		{
			show = true;
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if(show) {
				draw(g);
			}
		}

		public void toggle()
		{
			show = !show;
			repaint();
		}

	}

		public void draw(Graphics g)
		{
			for(int i = 0; i < vehicles.size(); i++)
			{
				vehicles.get(i).draw(g);
			}
		}

}