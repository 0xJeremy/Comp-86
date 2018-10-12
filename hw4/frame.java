import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class frame extends JFrame
{

	public frame(String window_name, int height, int width)
	{
		setTitle(window_name);
		setSize(height, width);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		model canvas = new model();
		add(canvas.get_canvas(), BorderLayout.CENTER);

		JPanel options = new JPanel();
		options.add(add_checkbox("Toggle Infared View", "Toggled Infared View"));
		options.add(add_checkbox("Toggle Night View", "Toggled Night View"));
		options.add(add_checkbox("Toggle All Sensors", "Toggled All Sensors"));
		add(options, BorderLayout.PAGE_START);

		JPanel extras = new JPanel();
		extras.add(add_print_button("Show Boats", "Now showing boats"));
		extras.add(add_print_button("Show Planes", "Now showing planes"));

		JSlider view_distance = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
		extras.add(view_distance);

		JButton toggle_display = new JButton("Toggle Display");
		extras.add(toggle_display);

		add(extras, BorderLayout.PAGE_END);

		setVisible(true);
	}

	public ActionButton add_print_button(String button_text, String print_out)
	{
		ActionButton button = new ActionButton(button_text);
		button.add_single_print(print_out);
		return button;
	}

	public ActionCheckBox add_checkbox(String button_text, String print_out)
	{
		ActionCheckBox box = new ActionCheckBox(button_text);
		box.add_single_print(print_out);
		box.setBounds(1, 1, 150, 30);
		return box;
	}

}