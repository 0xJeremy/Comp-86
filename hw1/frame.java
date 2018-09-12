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

	public frame(String window_name, int height, int width)
	{
		window_height = height;
		window_width = width;
		setTitle(window_name);
		setSize(height, width);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(panel);
		panel.setLayout(null);
	}

	public void add_quit_button()
	{
		JButton quitButton = new JButton("Quit");
		int button_x = window_width-80;
		int button_y = window_height-10;
		quitButton.setBounds(button_x, button_y, 80, 30);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		panel.add(quitButton);
	}

	public void add_print_button(String button_text, String print_out, int x, int y)
	{
		JButton button = new JButton(button_text);
		button.setBounds(x, y, 150, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print_out);
			}
		});
		panel.add(button);
	}

	public void add_switchable_button(String button_text, String print_out, int x, int y)
	{
		JButton button = new JButton(button_text);
		button.setBounds(x, y, 150, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println();
			}
		});
		panel.add(button);
	}

	public void add_checkbox(String button_text, int x, int y)
	{
		JCheckBox box = new JCheckBox(button_text);
		box.setBounds(x, y, 150, 30);
		panel.add(box);
	}

	public void add_combobox(String[] button_text, int x, int y)
	{
		JComboBox<String> box = new JComboBox<String>(button_text);
		box.setBounds(x, y, 150, 30);
		panel.add(box);
	}
}