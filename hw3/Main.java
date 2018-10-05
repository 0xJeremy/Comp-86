import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main
{
	public static void main(String args[])
	{
		frame window = new frame("Comp 86 – Homework 3", 650, 400);

		window.add_canvas();

		JPanel options = new JPanel();
		options.add(window.add_checkbox("Toggle Infared View", "Toggled Infared View"));
		options.add(window.add_checkbox("Toggle Night View", "Toggled Night View"));
		options.add(window.add_checkbox("Toggle All Sensors", "Toggled All Sensors"));
		window.add(options, BorderLayout.PAGE_START);

		JPanel extras = new JPanel();
		extras.add(window.add_print_button("Add Enemy", "Added Enemy"));
		extras.add(window.add_print_button("Remove Enemy", "Removed Enemy"));

		JSlider view_distance = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
		extras.add(view_distance);

		JButton toggle_display = new JButton("Toggle Display");
		toggle_display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.fill_canvas();
			}
		});
		extras.add(toggle_display);

		window.add(extras, BorderLayout.PAGE_END);

		window.setVisible(true);
	}

}