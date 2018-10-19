import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class model
{
	private ArrayList<vehicle> vehicles;
	private Canvas canvas;
	private static boolean show;
	private int frame;

	public model()
	{
		vehicles = new ArrayList<vehicle>();
		show = true;

		Timer timer = new Timer(50, add_frame);
		frame = 1;
		timer.start();

		for(int i = 0; i < 5; i++) {
			String name = "Boat " + i;
			boat boat1 = new boat(name, (i*100)+10, (i*100)+10, 10, 10);
			vehicles.add(boat1);
			name = "Plane " + i;
			plane plane1 = new plane(name, (i*100)+60, (i*100)+60, 10, 10, 10);
			vehicles.add(plane1);
		}

		canvas = new Canvas(timer);
		canvas.setSize(new Dimension(300, 600));
	}

	ActionListener add_frame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame++;
				canvas.repaint();
            }
        };

    public void add_plane(int speed)
    {
    	plane plane1 = new plane("Added Plane", 60, 60, speed, speed, speed);
    	vehicles.add(plane1);
    }

    public void add_boat(int speed)
    {
    	boat boat1 = new boat("Added Boat", 10, 10, speed, speed);
		vehicles.add(boat1);
    }

	public Canvas get_canvas()
	{
		return canvas;
	}

	public void toggle_view()
	{
		canvas.toggle();
	}

	public void toggle_movement()
	{
		canvas.toggle_motion();
	}

	public void set_background(Color c)
	{
		canvas.setBackground(c);
	}

	public void draw(Graphics g, boolean moving)
	{
		for(int i = 0; i < vehicles.size(); i++)
		{
			vehicles.get(i).draw(g, moving);
		}
	}

	public int get_frame()
	{
		return frame;
	}

	public class Canvas extends JPanel{

		private boolean show;
		private Color background;
		private boolean movement;

		public Canvas(Timer parent)
		{
			show = true;
			movement = false;
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if(show) {
				draw(g, movement);
			}
		}

		public void toggle()
		{
			show = !show;
			repaint();
		}

		public void toggle_motion()
		{
			movement = !movement;
			repaint();
		}

	}


}