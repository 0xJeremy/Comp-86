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
	private bool show_planes = false;
	private bool show_boats = false;

	public model()
	{
		vehicles = new ArrayList<vehicle>();

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

	public class Canvas extends JPanel{

		public void paintComponent(Graphics g)
		{
			// for(int i = 0; i < 60; i++)
			// {
			// 	if(i % 2 == 0) {
			// 		g.setColor(Color.BLACK);
			// 	}
			// 	g.drawOval(40+i, 40+i, i*10, i*10);
			// 	g.setColor(Color.GREEN);
			// }
			draw(g);
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