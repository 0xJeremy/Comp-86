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
		ActionButton button1 = new ActionButton("Set Background Black");
		button1.add_single_print("Background Set");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.set_background(Color.BLACK);
			}
		});
		ActionButton button2 = new ActionButton("Set Background Orange");
		button2.add_single_print("Background Set");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.set_background(Color.ORANGE);
			}
		});
		options.add(button1);
		options.add(button2);
		options.add(add_checkbox("Toggle All Sensors", "Toggled All Sensors"));
		add(options, BorderLayout.PAGE_START);

		JPanel extras = new JPanel();

		ActionButton button = new ActionButton("Toggle Objects");
		button.add_single_print("Objects Toggled");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.toggle_view();
			}
		});

		extras.add(button);
		extras.add(add_print_button("Fire On Enemies", "Now Firing!"));

		JSlider view_distance = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
		extras.add(view_distance);

		JButton toggle_movement = new JButton("Toggle Movement");
		toggle_movement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.toggle_movement();
			}
		});
		extras.add(toggle_movement);

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