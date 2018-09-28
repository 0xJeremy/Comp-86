import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;

public class Main
{
	public static void main(String args[])
	{
		frame window = new frame("Comp 86 – Homework 2", 650, 400);
		window.add_canvas();

		JPanel options = new JPanel();
		String seeIR = "Toggle Infared View";
		String seeIR2 = "Toggled Infared View";
		options.add(window.add_checkbox(seeIR, seeIR2, 1, 1));

		String seenight = "Toggle Night View";
		String seenight2 = "Toggled Night View";
		options.add(window.add_checkbox(seenight, seenight2, 1, 1));
		window.add_JPanel(options);

		JPanel buttons = new JPanel();
		String button = "Add Enemy";
		String button2 = "Added Enemy";
		buttons.add(window.add_print_button(button, button2));

		button = "Remove Enemy";
		button2 = "Removed Enemy";
		buttons.add(window.add_print_button(button, button2));
		window.add_JPanel(buttons);

		window.setVisible(true);
	}

}