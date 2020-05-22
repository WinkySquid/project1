package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.List;

public class JOPListener2 implements ActionListener {
	
	//INSTANCE VARIABLES
	private int _i;
	private Window _w;
	private Frame2 _f;
	private Timer t;
	private String _s;
	private String _s2;
	private int _j;
	private int _k;
	private int _points;
	private int _points2;
	private List _l;
	private List _l2;
	private boolean _b;
	private ImageIcon _a;
	
	//FINAL VARIABLES
	public final ImageIcon ROCK = new ImageIcon(getClass().getResource("rock.png"));
	public final ImageIcon SCISSORS = new ImageIcon(getClass().getResource("scissors.png"));
	public final ImageIcon PAPER = new ImageIcon(getClass().getResource("paper.png"));
	public final ImageIcon BLACK = new ImageIcon(getClass().getResource("black.png"));
	
	//CONSTRUCTOR (also creates a timer)
	public JOPListener2(int i ,Frame2 f, int j, int k, int p, int q, List l, List l2, boolean b, String s, ImageIcon d) {
		_i = i;
		_f = f;
		_l = l;
		_j = j;
		_k = k;
		_a = d;
		_l2 = l2;
		_points = p;
		_points2 = q;
		_b = b;
		_s = s;
		
		_w = new Window();
		t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
        		check();
            }
        });
		//false represents p1 had its turn, true represents p2 had its turn
	}
	
	/*
	 * This method checks if _j or _k has the value of 3. If _j is 3, then the method
	 * increments _points by 1, adds _points2 to _l (the ArrayList), sets _points2 to 0,
	 * displays the victory message for Player 1, and creates a new Frame2. If _k is 3, 
	 * then the method increments _points2 by 1, adds _points to _l (the ArrayList), sets 
	 * _points to 0, displays the victory message for Player 2, and creates a new Frame2.
	 */
	private void checkPoints() {
			if(_j == 3) {
				_points++;
				_f.getFrame().setVisible(false);
				_w.msg4("Player 1 Wins the Round!\n"
						+"Score (Player 1): " + _points + "\n"
						+ "Score (Player 2): " + _points2, "#1 WINNER", new ImageIcon(getClass().getResource("veemo.png")));
				_l.add(_points2);
				
				_points2 = 0;
				_f = new Frame2(0, 0, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
			}
			else if (_k == 3) {
				_points2++;
				_f.getFrame().setVisible(false);
				_w.msg4("Player 2 Wins the Round!\n"
						+"Score (Player 1): " + _points
						+ "\nScore (Player 2): " + _points2, "#2 WINNER", new ImageIcon(getClass().getResource("ngyes.png")));
				
				_l.add(_points);
				
				_points = 0;
				_f = new Frame2(0, 0, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
			}
	}
	
	/*
	 * This method checks if Player 1 wins, Player 2 wins, or the result is a tie depending on
	 * what each player's card is and displays the result accordingly. It also calls the 
	 * checkPoints method and stops the timer.
	 */
	public void check() {
			if(_s.equals(_s2)) {
				_f.getFrame().setVisible(false);
				_w.msg3("It's a tie!", "TIE!");
				_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
			}
			else if(_s.equals("Rock")) {
				if(_s2.equals("Paper")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 2 Wins!", "");
					_k++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
				else if(_s2.equals("Scissors")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 1 Wins!", "");
					_j++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
			}
			else if(_s.equals("Paper")) {
				if(_s2.equals("Scissors")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 2 Wins!", "");
					_k++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
				else if(_s2.equals("Rock")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 1 Wins!", "");
					_j++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
			}
			else if(_s.equals("Scissors")) {
				if(_s2.equals("Rock")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 2 Wins!", "");
					_k++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
				else if(_s2.equals("Paper")) {
					_f.getFrame().setVisible(false);
					_w.msg3("Player 1 Wins!!", "");
					_j++;
					_f = new Frame2(_j, _k, BLACK, BLACK, false, _points, _points2, _l, _l2, "");
				}
			
		
		}
			checkPoints();
			t.stop();
	}
	
	/*
	 * This method overrides the original actionPerformed method and displays a new frame representing
	 * the moves of Player 1 and Player 2 and the status of the game or
	 * message dialog displaying the high scores of Player 1 or Player 2
	 * depending on the values of _b and _i.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		UIManager.put("OptionPane.background",new ColorUIResource(0,150,0));
		UIManager.put("Panel.background",new ColorUIResource(0,150,150));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Calibri", Font.CENTER_BASELINE, 18)));
		if(_b == false) {
			;
			if(_i == 0) {
				_s = "Rock";
				
				_f.getFrame().setVisible(false);
				_f = new Frame2(_j,_k, BLACK, BLACK, true, _points, _points2, _l, _l2, _s);
			}
			else if(_i == 1) {
				_s = "Paper";
				
				_f.getFrame().setVisible(false);
				_f = new Frame2(_j,_k, BLACK, BLACK, true, _points, _points2, _l, _l2, _s);
				
			}
			else if(_i == 2) {
				_s = "Scissors";
				
				_f.getFrame().setVisible(false);
				_f = new Frame2(_j,_k, BLACK, BLACK, true, _points, _points2, _l, _l2, _s);
			}
			else if(_i == 3) {
				_w.msg2("List of high scores for Player 1: \n"
						+ _l.toString() + "\n"
						+"List of high scores for Player 2: \n"
						+ _l2.toString() + "\n", "HIGH SCORES");
			}
		}
		else if(_b == true) {
			if(_i == 0) {
				_s2 = "Rock";
				_f.getFrame().setVisible(false);
				_f = new Frame2(0,0, _a, ROCK, false, _points, _points2, _l, _l2, _s);
				
				t.start();
			}
			else if(_i == 1) {
				_s2 = "Paper";
				_f.getFrame().setVisible(false);
				_f = new Frame2(0,0, _a, PAPER, false, _points, _points2, _l, _l2, _s);
				
				t.start();
			}
			else if(_i == 2) {
				_s2 = "Scissors";
				_f.getFrame().setVisible(false);
				
				_f = new Frame2(0,0, _a, SCISSORS, false, _points, _points2, _l, _l2, _s);
				
				t.start();
			}
			else if(_i == 3) {
				_w.msg2("List of high scores for Player 1: \n"
						+ _l.toString() + "\n"
						+"List of high scores for Player 2: \n"
						+ _l2.toString() + "\n", "HIGH SCORES");
			}
		}
	}
	
	//GETTERS (depending on the value of i)
	public ImageIcon getCPUIcon(int i) {
		if(i == 0) {
			return ROCK;
		}
		else if(i == 1) {
			return PAPER;
		}
		else if(i == 2) {
			return SCISSORS;
		}
		return BLACK;
	}
	public String getMove(int i) {
		if(i == 0) {
			return "Rock";
		}
		else if(i == 1) {
			return "Paper";
		}
		else if(i == 2) {
			return "Scissors";
		}
		return "(has not made a move)";
	}
}
