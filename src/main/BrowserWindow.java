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
		searchBar.setPreferredSize(new Dimension(frame.getWidth() - 100, 60)); // dynamically resize textfield relative to frame's size
		
		// build button
		goButton = new JButton("GO"); // create new button with some default text
		goButton.setPreferredSize(new Dimension(80, 60));
		
		// build displayPane
		displayPane = new JEditorPane(); // dynamically set width and height
		displayPane.setContentType("text/html");
		displayPane.setPreferredSize(new Dimension(frame.getWidth() - 20, frame.getHeight() - 150));
		
		// use SpringLayout to position the GUI components
		// create rules for adding stuff to the frame
		
		// put the go button next to the search bar in a cheeky manner
		layoutManager.putConstraint(SpringLayout.WEST, goButton, 5, SpringLayout.EAST, searchBar);

		// the searchbar will always be 5 px away from the edge of the window
		layoutManager.putConstraint(SpringLayout.WEST, searchBar, 5, SpringLayout.WEST, frame);

		layoutManager.putConstraint(SpringLayout.NORTH, displayPane, 5, SpringLayout.SOUTH, searchBar);

		
		
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