/******************************
* Jeremy Kanovsky
* jeremy.kanovsky@tufts.edu
* This class is a basic action button that extends JButton and allows the user to add a print function.
******************************/

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

	public ActionButton(String text)
	{
		this.setText(text);
	}

	public void add_single_print(String print)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print);
			}
		});
	}

}