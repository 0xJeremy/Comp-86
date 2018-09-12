import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class frame extends JFrame
{
	private JPanel panel = new JPanel();

	public frame(String window_name, int height, int width)
	{
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
		quitButton.setBounds(10, 10, 80, 30);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		panel.add(quitButton);
	}

	public void add_print_button(String button_text, String print_out)
	{
		JButton button = new JButton(button_text);
		button.setBounds(100, 100, 200, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print_out);
			}
		});
		panel.add(button);
	}
}