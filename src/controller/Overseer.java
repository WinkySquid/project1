package controller;

import models.*;
import view.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Overseer {
	
	//INSTANCE VARIABLES
	private Window _w;
	private Frame _f;
	private static final String[] A = new String[] {"Player vs. CPU", "Player vs. Player", "Exit"};
	private List _l;
	private List _l2;
	private Frame2 _f2;
	
	//CONSTRUCTOR
	public Overseer() {
		_w = new Window();
		_l = new List();
		_l2 = new List();
		start();
	}
	
	/*
	 * This method displays the starting option dialog. It sets the font and decoration of the dialog box,
	 * and creates a new Frame (Player vs. CPU), creates a new Frame2 (Player vs. Player), or exits the 
	 * program depending on what option the user chooses.
	 */
	private void start() {
		UIManager.put("OptionPane.background",new ColorUIResource(0,225,0));
		UIManager.put("Panel.background",new ColorUIResource(215,215,215));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Arial", Font.BOLD, 32)));
		
		boolean b = false;
		
		while(!b) {
			int x = _w.option2(A, "", "Rock, Paper, Scissors!",
					new ImageIcon(getClass().getResource("table.png")));
			if(x == 0) {
				UIManager.put("OptionPane.background",new ColorUIResource(0,150,0));
				UIManager.put("Panel.background",new ColorUIResource(150,78,0));
				b = true;
				
				_f = new Frame(0,0,new ImageIcon(getClass().getResource("black.png")),new ImageIcon(getClass().getResource("black.png")), "",0, _l);
			}
			if(x == 1) {
				UIManager.put("OptionPane.background",new ColorUIResource(0,150,0));
				UIManager.put("Panel.background",new ColorUIResource(150,78,0));
				b = true;
				_f2 = new Frame2(0,0,new ImageIcon(getClass().getResource("black.png")),new ImageIcon(getClass().getResource("black.png")), false,0,0, _l, _l2,"");
			}
			if(x == 2) {
				System.exit(0);
			}
		}
		
	}
}