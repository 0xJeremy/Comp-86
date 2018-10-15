import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class plane extends vehicle
{
	private int altitude;
	private boolean flag;
	// private boolean moving;

	public plane(String uname, int pos_x, int pos_y, int v_x, int v_y, int height)
	{
		super(uname, pos_x, pos_y, v_x, v_y);
		flag = true;
		altitude = height;
		// moving = true;
	}

	public void draw(Graphics g, boolean moving)
	{
		g.setColor(Color.WHITE);
		if(moving)
		{
			if(position_x > 400 && position_y > 400)
			{
				flag = false;
			}
			else if(position_x < 0 && position_y < 0)
			{
				flag = true;
			}
			if(flag)
			{
				position_x = position_x + speed_x;
				position_y = position_y + speed_y;
			}
			else if(!flag)
			{
				position_x = position_x - speed_x;
				position_y = position_y - speed_y;
			}
		}
		
		g.drawOval(position_x, position_y, 40, 40);
	}
}