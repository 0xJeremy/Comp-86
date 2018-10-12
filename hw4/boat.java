import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class boat extends vehicle
{

	public boat(String uname, int pos_x, int pos_y, int v_x, int v_y)
	{
		super(uname, pos_x, pos_y, v_x, v_y);
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(position_x, position_y, 40, 40);
	}
}