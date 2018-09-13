import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ActionButton extends JButton
{
	private int button_x_loc;
	private int button_y_loc;
	private int button_x_size;
	private int button_y_size;
	private int switch_name;

	public ActionButton(String text)
	{
		this.setText(text);
		switch_name = 0;
	}

	public void set_dimensions(int x_loc, int y_loc, int x_size, int y_size)
	{
		button_x_loc = x_loc;
		button_y_loc = y_loc;
		button_x_size = x_size;
		button_y_size = y_size;
		this.setBounds(button_x_loc, button_y_loc,
						button_x_size, button_y_size);
	}

	public void add_single_print(String print)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print);
			}
		});
	}

	public void add_switch_name(String[] button_text)
	{
		int l = button_text.length;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				switch_name++;
				change_button_text(button_text[switch_name % l]);
				System.out.println(button_text[switch_name % l]);
			}
		});
	}

	private void change_button_text(String text)
	{
		this.setText(text);
	}

}