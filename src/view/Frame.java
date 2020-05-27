package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.*;

public class Frame {
	
	//INSTANCE VARIABLES
	private JFrame _frame;
	private JPanel _pan;
	private JButton[][] _labMaze;
	private JLabel _lab;
	private JLabel _lab2,_lab3;
	private int _i;
	private int _j;
	private ImageIcon _h1;
	private ImageIcon _h2;
	private String _str;
	private int _points;
	private List _l;
	private Window _w;
	
	//CONSTRUCTOR
	public Frame(  int i, int j, ImageIcon i2, ImageIcon i3, String str, int p, List l) {
		
		UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		UIManager.put("Panel.background",new ColorUIResource(0,200,150));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Arial", Font.BOLD, 32)));
		_i = i;
		_l = l;
		_j = j;
		_h1 = i2;
		_h2 = i3;
		_points = p;
		_w = new Window();
		_str = str;
		
		setupButtons();
		setupPanel();
		setupFrame();
		
	}
	
	//GETTERS
	public JFrame getFrame() {
		return _frame;
	}
	public int getCount() {
		return _i;
	}
	/*
	 * This method is a getter method that returns _lab, _lab2, or _lab3 depending on the value of i.
	 */
	public JLabel getLabel(int i) {
		if(i == 0 || i == 1) {
			return _lab;
		}
		else if(i == 2) {
			return _lab2;
		}
		else if(i == 2) {
			return _lab3;
		}
		return null;
	}
	
	/*
	 * This method sets up the frame for the board. It does not allow for resizing, lets you exit the program
	 * upon closing, sets the background of the frame, sets the bounds for the frame, sets the icon for the frame,
	 * and sets the decoration of the frame. 
	 */
	private void setupFrame() {
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.green));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.black));
		JFrame.setDefaultLookAndFeelDecorated(true);
		_frame = new JFrame("RPS");
		_frame.setVisible(true);
		
		_frame.setBackground(new Color(0, 150, 0));
		_frame.add(_pan);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("dice block.png")));
		_frame.pack();
		_frame.setResizable(false);
		_frame.setBounds(300, 300, 1100, 400);
		_frame.repaint();
	}
	
	/*
	 * This method sets up all the JButtons that represent that the options the player has while playing
	 * the round. It also sets up the margin of the buttons, sets up the background for each
	 * button, adds the text representing each option the player has to each button,
	 * and adds an ActionListener to each button.
	 */
	private void setupButtons() {
		
			String s = "This round: " +_i + " - " + _j;
		
		_lab = new JLabel(s);
		_lab2 = new JLabel(_h1);
		_lab3 = new JLabel(_h2);
		_labMaze = new JButton[1][4];
		_labMaze[0][0] = new JButton("Rock");
		_labMaze[0][1] = new JButton("Paper");
		_labMaze[0][2] = new JButton("Scissors");
		_labMaze[0][3] = new JButton("See High Scores");
		
			for(int d = 0; d < _labMaze[0].length; d++) {
				_labMaze[0][d].setBackground(new Color(255, 180, 180));
				_labMaze[0][d].setFocusPainted(false);
				_labMaze[0][d].setContentAreaFilled(true);
				_labMaze[0][d].setMargin(new Insets(0,0,0,0));
				_labMaze[0][d].setOpaque(true);
				_labMaze[0][d].addActionListener(new JOPListener(d, this, _i, _j, _points, _l));
			}
			
	}
	
	/*
	 * This method sets up the panel that is required to draw a round of Rock, Paper, Scissors.
	 * It adds the labels for the cards, the score of the round, and the status of the round. It also
	 * adds the JButtons from _labMaze that represent the options that the player has.
	 */
	private void setupPanel() {
		
		_pan = new JPanel(new GridLayout(2, 4));
		_pan.add(_lab, 0);
		_pan.add(_lab2);
		_pan.add(_lab3);
		_pan.add(new JLabel("CPU's move: " +  _str));
		
		for(JButton[] l: _labMaze) {
			for(JButton b : l) {
				_pan.add(b);
			}
		}
		
		_pan.repaint();
	}
	
}
