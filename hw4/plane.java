import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class plane extends vehicle
{
	private int altitude;

	public plane(String uname, int pos_x, int pos_y, int v_x, int v_y, int height)
	{
		super(uname, pos_x, pos_y, v_x, v_y);
		altitude = height;
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawOval(position_x, position_y, 40, 40);
	}
}