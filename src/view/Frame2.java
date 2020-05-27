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

public class Frame2 {
	
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
	private int _points;
	private int _points2;
	private List _l;
	private List _l2;
	private boolean _b;
	private String _str;
	
	//FINAL VARIABLES
	public final ImageIcon ROCK = new ImageIcon(getClass().getResource("rock.png"));
	public final ImageIcon SCISSORS = new ImageIcon(getClass().getResource("scissors.png"));
	public final ImageIcon PAPER = new ImageIcon(getClass().getResource("paper.png"));
	public final ImageIcon BLACK = new ImageIcon(getClass().getResource("black.png"));
	
	//CONSTRUCTOR
	public Frame2(  int i, int j, ImageIcon i2, ImageIcon i3, boolean b, int p, int q,List l, List l2, String s) {
		UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		UIManager.put("Panel.background",new ColorUIResource(0,200,150));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Arial", Font.BOLD, 32)));
		_i = i;
		_l = l;
		_j = j;
		_b = b;
		_h1 = i2;
		_h2 = i3;
		_points = p;
		_points2 = q;
		_l2 = l2;
		_str = s;
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
	
	//SETTER
	public void setPlay(boolean b) {
		_b = b;
	}
	
	/*
	 * This method sets up the frame. It does not allow for resizing, lets you exit the program
	 * upon closing, sets the background, sets the bounds for the frame, sets the icon for the frame,
	 * and sets the decoration of the frame. 
	 */
	private void setupFrame() {
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.green));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.black));
		JFrame.setDefaultLookAndFeelDecorated(true);
		_frame = new JFrame("RPS");
		_frame.setVisible(true);
		if(_b == false)
		_frame.setBackground(new Color(0, 150, 0));
		else if (_b == true)
			_frame.setBackground(new Color(210, 100, 0));
		_frame.add(_pan);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("dice block.png")));
		_frame.pack();
		_frame.setResizable(false);
		_frame.setBounds(300, 300, 1100, 400);
		//_frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING));
		_frame.repaint();
		
	}
	
	/*
	 * This method sets up all the JButtons that represent that the player has while playing
	 * the round. It also sets up the margin of the buttons, sets up the background for each
	 * button, adds the text representing the options each player has to each button,
	 * and adds an ActionListener to each button. The method also sets up the JLabels that
	 * represent who has the current turn and the moves that the players have (whether
	 * they be blank, rock, paper, or scissors).
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
				
			}
			_labMaze[0][0].addActionListener(new JOPListener2(0, this, _i, _j, _points, _points2, _l, _l2, _b, _str, _h1));
			_labMaze[0][1].addActionListener(new JOPListener2(1, this, _i, _j, _points, _points2, _l, _l2, _b, _str, _h1));
			_labMaze[0][2].addActionListener(new JOPListener2(2, this, _i, _j, _points, _points2, _l, _l2, _b, _str, _h1));
			_labMaze[0][3].addActionListener(new JOPListener2(3, this, _i, _j, _points, _points2, _l, _l2, _b, _str, _h1));
	}
	
	/*
	 * This method sets up the panel required to draw a round of Rock, Paper, Scissors.
	 * It adds the labels for the cards, the score of the round, and the status of the round. It also
	 * adds the JButtons from _labMaze that represent the options that each player has. It also
	 * adds the JLabels to the panel
	 */
	private void setupPanel() {
		
		_pan = new JPanel(new GridLayout(2, 4));
		_pan.add(_lab, 0);
		_pan.add(_lab2);
		_pan.add(_lab3);
		if(!_b) {
			_pan.add(new JLabel("Player 1's Move."));
		}
		else {
			_pan.add(new JLabel("Player 2's Move."));
		}
		for(JButton[] l: _labMaze) {
			for(JButton b : l) {
				_pan.add(b);
			}
		}
		
		_pan.repaint();
	}
	
}
