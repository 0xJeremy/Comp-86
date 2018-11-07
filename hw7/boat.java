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
	private boolean zoom;

	public boat(String uname, int pos_x, int pos_y, int v_x, int v_y)
	{
		super(uname, pos_x, pos_y, v_x, v_y);
		flag = true;
		selected = false;
		zoom = false;
	}

	public void draw(Graphics g, boolean moving)
	{
		g.setColor(Color.BLUE);
		int modifier = 40;
		int edge_pos = 400;
		if(zoom) {
			edge_pos = 800;
		}
		if(moving)
		{
			if(position_x > edge_pos || position_y > edge_pos)
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
			g.fillRect(position_x, position_y, modifier, modifier);
		}
		else {
			g.drawRect(position_x, position_y, modifier, modifier);
		}
	}

	public void clicked(int x, int y)
	{
		if(x > position_x && x < (position_x + 40)
			&& y > position_y && y < (position_y + 40))
		{
			selected = true;
			System.out.println("Vehicle Selected at " + x + ", " + y);
			speed_x = 0;
			speed_y = 0;
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

	public void toggle_zoom()
	{
		zoom = !zoom;
		if(zoom) {
			position_x *= 2;
			position_y *= 2;
			speed_x *= 2;
			speed_y *= 2;
		}
		else {
			position_x /= 2;
			position_y /= 2;
			speed_x /= 2;
			speed_y /= 2;
		}
	}
}