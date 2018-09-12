import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[])
	{
		String hello = "Hello World!";
		System.out.println(hello);
		frame window = new frame("Comp 86 – Homework 1", 600, 400);
		window.add_quit_button();
		window.add_print_button(hello, hello);
		window.setVisible(true);
	}

}