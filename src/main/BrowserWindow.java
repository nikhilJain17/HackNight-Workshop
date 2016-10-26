package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BrowserWindow {
	
	// 5 GUI components we need to build the browser
	JFrame frame;				// master container
	JButton goButton;			// button to visit URL
	JTextField searchBar;	 	// text field to enter URL's
	JEditorPane displayPane; 	// display website's content
	JScrollPane scrollPane; 	// scrollable container to hold displaypane
								// allows you to scroll through webpages
	
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
		displayPane.setPreferredSize(new Dimension(666, 666));
		displayPane.setEditable(false); // no editing senor
		
		// build scrollpane and add displayPane to it
		scrollPane = new JScrollPane(displayPane);
		scrollPane.setPreferredSize(new Dimension(666, 666));
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	    
		// what to do when user clicks a hyperlink
		displayPane.addHyperlinkListener(new HyperlinkListener() {

			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				
				// only go to hyperlink when control key is down (lol)
				if (e.getInputEvent().isControlDown()) {
					try {
						System.out.println("hyperlinked!");
						displayPane.setPage(e.getURL());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		// use SpringLayout to position the GUI components
		// create rules for adding stuff to the frame
		
		// put 5 px of room from left edge of search bar to left edge of frame
		layoutManager.putConstraint(SpringLayout.WEST, searchBar, 5, SpringLayout.WEST, frame);
		
		// put 5 px of room from right of button to right of frame
		layoutManager.putConstraint(SpringLayout.EAST, goButton, 5, SpringLayout.EAST, frame);
		
		// put 5 px of room from top of scrollPane and  bottom of search bar
		layoutManager.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.SOUTH, searchBar);
		
		// put 5 px of room from left of scrollPane and left of frame
		layoutManager.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, frame);

		
		// set on click listener for button
		// if you click the button, it goes to the URL typed in the search bar
		// sends a GET request to the server
		// gets the output content
		// displays it in the displayPane
		goButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button clicked");
				// TODO Auto-generated method stub
				try {
					System.out.println("fetching html");
//					String html = getHTML(searchBar.getText());
//					displayPane.setText(html);
//					System.out.println(html);
					displayPane.setPage(searchBar.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		// add the components to the frame
		frame.add(goButton);
		frame.add(searchBar);
//		frame.add(displayPane);
		frame.add(scrollPane);
		
		// display the GUI
		goButton.setVisible(true);
		searchBar.setVisible(true);
		displayPane.setVisible(true);
		
		frame.pack();
		frame.setVisible(true);
		
		
	} // end of constructor
	
	// The hard way: send a get request manually 
	
	
	private static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }
	
	public static void main(String[] args) {
		
		System.out.println("Hello world!");
		BrowserWindow window = new BrowserWindow();
		
	}
	
}
