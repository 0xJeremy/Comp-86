/***********************************************
Jeremy Kanovsky
Class: boat
Does: Extends the vehicle class and creates a
boat object. This object is capable of maintaining
its own location and drawing itself on the canvas.
***********************************************/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class boat extends vehicle
{
	private boolean flag;
	private boolean selected;

	public boat(String uname, int pos_x, int pos_y, int v_x, int v_y)
	{
		super(uname, pos_x, pos_y, v_x, v_y);
		flag = true;
		selected = false;
	}

	public void draw(Graphics g, boolean moving)
	{
		g.setColor(Color.BLUE);
		if(moving)
		{
			if(position_x > 400 || position_y > 400)
			{
				flag = false;
			}
			else if(position_x < 0 || position_y < 0)
			{
				flag = true;
			}
			if(flag)
			{
				position_x = position_x + speed_x;
				// position_y = position_y + speed_y;
			}
			else if(!flag)
			{
				position_x = position_x - speed_x;
				// position_y = position_y - speed_y;
			}
		}
		if(selected) {
			g.fillRect(position_x, position_y, 40, 40);
		}
		else {
			g.drawRect(position_x, position_y, 40, 40);
		}
	}

	public void clicked(int x, int y)
	{
		if(x > position_x && x < (position_x + 40)
			&& y > position_y && y < (position_y + 40))
		{
			selected = true;
		}
		else {
			selected = false;
		}
	}

	public int posx()
	{
		return position_x;
	}

	public int posy()
	{
		return position_y;
	}
}