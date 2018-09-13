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
		quitButton.set_dimensions(x, y, sx, sy);
		panel.add(quitButton);
	}

	public void add_print_button(String button_text, String print_out, int x, int y)
	{
		ActionButton button = new ActionButton(button_text);
		button.set_dimensions(x, y, 150, 30);
		button.add_single_print(print_out);
		panel.add(button);
		// JButton button = new JButton(button_text);
		// button.setBounds(x, y, 150, 30);
		// button.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		System.out.println(print_out);
		// 	}
		// });
		// panel.add(button);
	}

	public void add_switchable_button(String[] button_text, String initial_text, int x, int y)
	{
		ActionButton button = new ActionButton(initial_text);
		button.set_dimensions(x, y, 150, 30);
		button.add_switch_name(button_text);
		panel.add(button);
		// JButton button = new JButton(initial_text);
		// button.setBounds(x, y, 150, 30);
		// int l = button_text.length;
		// button.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		click_counter++;
		// 		button.setText(button_text[click_counter % l]);
		// 		System.out.println(button_text[click_counter % l]);
		// 	}
		// });
		// panel.add(button);
	}

	public void add_checkbox(String button_text, String print_out, int x, int y)
	{
		ActionCheckBox box = new ActionCheckBox();
		box.add_single_print(print_out);
		box.setBounds(x, y, 150, 30);
		panel.add(box);
		// JCheckBox box = new JCheckBox(button_text);
		// box.setBounds(x, y, 150, 30);
		// box.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		System.out.println(print_out);
		// 	}
		// });
		// panel.add(box);
	}

	public void add_combobox(String[] button_text, int x, int y)
	{
		JComboBox<String> box = new JComboBox<String>(button_text);
		box.setBounds(x, y, 150, 30);
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(box.getSelectedItem().toString());
			}
		});
		panel.add(box);
	}
}