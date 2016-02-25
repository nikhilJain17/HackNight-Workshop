package main;

import java.awt.*;
import javax.swing.*;

public class BrowserWindow {
	
	// 4 GUI components we need to build the browser
	JFrame frame;				// master container
	JButton goButton;			// button to visit URL
	JTextField searchBar;	 	// text field to enter URL's
	JEditorPane displayPane; 	// display website's content
	
	// Constructor - function that is called when class is instantiated
	public BrowserWindow() {
		
		// build frame
		frame = new JFrame(); 
		frame.setPreferredSize(new Dimension(700, 700));	// set frame to be 700x700 px
		
		// initialize layout, but dont do anything with it yet
		SpringLayout layoutManager = new SpringLayout(); 			// what we use to place things specifically where we want them on the frame
		frame.setLayout(layoutManager); 							// will come back to later
		
		// build search bar
		searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(500, 60)); 
		
		// build button
		goButton = new JButton("GO"); // create new button with some default text
		goButton.setPreferredSize(new Dimension(80, 60));
		
		// build displayPane
		displayPane = new JEditorPane(); 
		displayPane.setContentType("text/html");
		displayPane.setPreferredSize(new Dimension(500, 500));
		
		// use SpringLayout to position the GUI components
		// create rules for adding stuff to the frame
		
		// put 5 px of room from left edge of search bar to left edge of frame
		layoutManager.putConstraint(SpringLayout.WEST, searchBar, 5, SpringLayout.WEST, frame);
		
		
		// add the components to the frame
		frame.add(goButton);
		frame.add(searchBar);
		frame.add(displayPane);
		
		// display the frame
		goButton.setVisible(true);
		searchBar.setVisible(true);
		displayPane.setVisible(true);
		
		frame.pack();
		frame.setVisible(true);
		
	} // end of constructor
	
	public static void main(String[] args) {
		
		System.out.println("Hello world!");
		BrowserWindow window = new BrowserWindow();
		
	}
	
}