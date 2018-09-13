/******************************
* Jeremy Kanovsky
* jeremy.kanovsky@tufts.edu
* This class creates a basic combobox by extending ComboBox and lets the user add a print function.
******************************/

import java.util.*;
import java.io.*;
import java.lang.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ActionComboBox extends JComboBox<String>
{

	public ActionComboBox(String[] text)
	{
		super(text);
	}

	public void add_single_print()
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("New Selection Made!");
			}
		});
	}
}