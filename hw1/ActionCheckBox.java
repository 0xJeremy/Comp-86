/******************************
* Jeremy Kanovsky
* jeremy.kanovsky@tufts.edu
* This class makes a simple checkbox by extending JCheckBox and lets the user add a print function when pressed.
******************************/

import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ActionCheckBox extends JCheckBox
{

	public ActionCheckBox(String text)
	{
		super(text);
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