import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class QuitButton extends JButton
{
	private int button_x_loc;
	private int button_y_loc;
	private int button_x_size;
	private int button_y_size;

	public QuitButton()
	{
		this.setText("Quit");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
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

}