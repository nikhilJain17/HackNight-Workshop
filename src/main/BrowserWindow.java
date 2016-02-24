package main;

import java.awt.*;
import javax.swing.*;

public class BrowserWindow {
	
	JFrame frame;				// master container
	JButton goButton;			// button to visit URL
	JTextField searchBar;	 	// text field to enter URL's
	JEditorPane displayPane; 	// display HTML output
	
	// Constructor - function that is called when class is instantiated
	public BrowserWindow() {
		
		frame = new JFrame(); 
		frame.setPreferredSize(new Dimension(700, 700));	// set frame to be 700x700 px
		
		SpringLayout layout = new SpringLayout(); 			// what we use to place things specifically where we want them on the frame
		
		// display the frame
		frame.pack();
		frame.setVisible(true);
		
	} // end of constructor
	
	public static void main(String[] args) {
		
		BrowserWindow window = new BrowserWindow();
		
	}
	
}