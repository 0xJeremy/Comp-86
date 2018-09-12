import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[])
	{
		String hello = "Hello World!";
		String[] hello_array = {"Hello 1", "Hello 2", "Hello 3", "Hello 4"};
		System.out.println(hello);
		frame window = new frame("Comp 86 – Homework 1", 650, 200);
		// window.add_quit_button();
		for(int i = 0; i < 4; i++)
		{
			window.add_print_button(hello_array[i], hello_array[i], 10, (i*40)+10);
			window.add_checkbox(hello_array[i], hello_array[i], 170, (i*40)+10);
			window.add_combobox(hello_array, 330, (i*40)+10);
			window.add_switchable_button(hello_array, hello_array[i], 490, (i*40)+10);
		}
		// window.add_quit_button();
		window.setVisible(true);
	}

}