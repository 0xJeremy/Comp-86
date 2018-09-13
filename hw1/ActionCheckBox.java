import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ActionCheckBox extends JCheckBox
{
	private int x_loc;
	private int y_loc;
	private int x_size;
	private int y_size;

	public ActionCheckBox()
	{

	}

	public void set_dimensions(int x, int y, int sx, int sy)
	{
		x_loc = x;
		y_loc = y;
		x_size = sx;
		y_size = sy;
		this.setBounds(x_loc, y_loc, x_size, y_size);
	}

	public void add_single_print(String print)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print);
			}
		});
	}


}