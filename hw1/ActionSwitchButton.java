/******************************
* Jeremy Kanovsky
* jeremy.kanovsky@tufts.edu
* This class allows the user to make a button that switches its text when pressed.
******************************/

import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ActionSwitchButton extends JButton
{
	private int switch_name;

	public ActionSwitchButton(String[] button_text, int initial)
	{
		this.setText(button_text[initial]);
		switch_name = initial;
	}

	public void add_single_print(String print)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(print);
			}
		});
	}

	public void add_switch_name(String[] button_text)
	{
		int l = button_text.length;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				switch_name++;
				change_button_text(button_text[switch_name % l]);
				System.out.println(button_text[switch_name % l]);
			}
		});
	}

	private void change_button_text(String text)
	{
		this.setText(text);
	}

}