package view;
import javax.swing.*;

public class Window {
	
	//CONSTRUCTOR
	public Window() {}
	
	/*
	 * This method displays a default message dialog box with msg as the message inside the box and title as the dialog box title.
	 */
	public void msg2(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);
	}
	
	/*
	 * This method displays a warning message dialog box with msg as the message inside the box and title as the dialog box title.
	 */
	public void msg3(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/*
	 * This method displays a default message dialog box with msg as the message inside the box, title as the dialog box title,
	 * and i as the icon displayed inside the box.
	 */
	public void msg4(String msg, String title, ImageIcon i) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.DEFAULT_OPTION,
				i);
	}
	
	/*
	 * This method displays an dialog box prompting the user for an input with msg as the message inside the box.
	 */
	public String in(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	/*
	 * This method displays an option dialog box with the buttons inside the dialog box
	 * being labeled as the String objects in options and msg as the message inside the box.
	 */
	public int option(String[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	
	/*
	 * This method displays an option dialog box with the buttons inside the dialog box
	 * being labeled as the String objects in options, msg as the text inside the box,
	 * i as the icon displayed in the dialog box, and s as the dialog box title.
	 */
	public int option2(String[] options, String msg, String s, ImageIcon i) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                s, // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                i, 
                options, // possible options
                options[0]); // default option
	}
	
	/*
	 * This method displays a message with msg as the object displayed inside the box.
	 */
	public void msg(Object msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/*
	 * This method displays an input dialog box with msg as the object message inside the box.
	 */
	public String in(Object msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	/*
	 * This method displays an option dialog box with the buttons inside the dialog box
	 * being labeled as the Objects in options and msg as the message inside the box.
	 */
	public int option(Object[] options, Object msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	
}
