import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.*;

import javax.swing.*;

public class frame extends JFrame
{

	public frame(String window_name, int height, int width)
	{
		setTitle(window_name);
		setSize(height, width);
		setLayout(new GridLayout(3, 1));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ActionButton add_print_button(String button_text, String print_out)
	{
		ActionButton button = new ActionButton(button_text);
		button.add_single_print(print_out);
		return button;
	}

	public void add_canvas()
	{
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(300, 300));
		add(canvas);
	}

	public ActionCheckBox add_checkbox(String button_text, String print_out, int x, int y)
	{
		ActionCheckBox box = new ActionCheckBox(button_text);
		box.add_single_print(print_out);
		box.setBounds(x, y, 150, 30);
		return box;
	}

	public void add_JPanel(JPanel panel)
	{
		add(panel);
	}

}