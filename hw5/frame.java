import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class frame extends JFrame
{
	boolean fire_button_flag;

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

		JButton fire_button = new JButton("Fire On Enemies");
		this.fire_button_flag = false;
		fire_button.setEnabled(fire_button_flag);
		fire_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Now firing on enemies!");
			}
		});
		extras.add(fire_button);

		String[] add_values = new String[] {"Add Plane (Speed 5)", 
					"Add Plane (Speed 10)", "Add Boat (Speed 5)", 
					"Add Boat (Speed 10)"};
		JComboBox<String> add_values_box = new JComboBox<String>(add_values);
		add_values_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String selected_object = (String)add_values_box.getSelectedItem();
				if(selected_object.equals("Add Plane (Speed 5)")) {
					canvas.add_plane(5);
					System.out.println("New Plane with Speed 5 Added!");
				}
				else if(selected_object.equals("Add Plane (Speed 10)")) {
					canvas.add_plane(10);
					System.out.println("New Plane with Speed 10 Added!");
				}
				else if(selected_object.equals("Add Boat (Speed 5)")) {
					canvas.add_boat(5);
					System.out.println("New Boat with Speed 5 Added!");
				}
				else if(selected_object.equals("Add Boat (Speed 10)")) {
					canvas.add_plane(10);
					System.out.println("New Boat with Speed 10 Added!");
				}
			}
		});
		extras.add(add_values_box);

		// JButton add_plane = new JButton("Add Plane");
		// add_plane.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		canvas.add_plane();
		// 	}
		// });
		// extras.add(add_plane);

		// JButton add_boat = new JButton("Add Boat");
		// add_boat.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent event) {
		// 		canvas.add_boat();
		// 	}
		// });
		// extras.add(add_boat);

		JButton toggle_movement = new JButton("Toggle Movement");
		toggle_movement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.toggle_movement();
				fire_button_flag = !fire_button_flag;
				fire_button.setEnabled(fire_button_flag);
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