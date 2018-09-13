import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class frame extends JFrame
{
	private JPanel panel = new JPanel();
	private int window_height;
	private int window_width;
	private int click_counter;

	public frame(String window_name, int height, int width)
	{
		window_height = height;
		window_width = width;
		click_counter = 0;
		setTitle(window_name);
		setSize(height, width);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void add_quit_button(int x, int y, int sx, int sy)
	{
		QuitButton quitButton = new QuitButton();
		quitButton.setBounds(x, y, sx, sy);
		panel.add(quitButton);
	}

	public void add_print_button(String button_text, String print_out, int x, int y)
	{
		ActionButton button = new ActionButton(button_text);
		button.setBounds(x, y, 150, 30);
		button.add_single_print(print_out);
		panel.add(button);
	}

	public void add_switchable_button(String[] button_text, int initial_text, int x, int y)
	{
		ActionSwitchButton button = new ActionSwitchButton(button_text, initial_text);
		button.setBounds(x, y, 150, 30);
		button.add_switch_name(button_text);
		panel.add(button);
	}

	public void add_checkbox(String button_text, String print_out, int x, int y)
	{
		ActionCheckBox box = new ActionCheckBox(button_text);
		box.add_single_print(print_out);
		box.setBounds(x, y, 150, 30);
		panel.add(box);
	}

	public void add_combobox(String[] button_text, int x, int y)
	{
		ActionComboBox box = new ActionComboBox(button_text);
		box.add_single_print();
		box.setBounds(x, y, 150, 30);
		panel.add(box);
	}
}