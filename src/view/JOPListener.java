package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.List;
import models.Move;

public class JOPListener implements ActionListener {
	
	//INSTANCE VARIABLES
	private int _i;
	private Window _w;
	private Frame _f;
	private Timer t;
	private String _s;
	private String _s2;
	private int _j;
	private int _k;
	private int _points;
	private List _l;
	
	//FINAL VARIABLES
	public final ImageIcon ROCK = new ImageIcon(getClass().getResource("rock.png"));
	public final ImageIcon SCISSORS = new ImageIcon(getClass().getResource("scissors.png"));
	public final ImageIcon PAPER = new ImageIcon(getClass().getResource("paper.png"));
	public final ImageIcon BLACK = new ImageIcon(getClass().getResource("black.png"));
	
	//CONSTRUCTOR (also creates a timer)
	public JOPListener(int i ,Frame f, int j, int k, int p, List l) {
		_i = i;
		_f = f;
		_l = l;
		_j = j;
		_k = k;
		_points = p;
		_w = new Window();
		t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
        		action();
            }
        });
		
	}
	
	/*
	 * This method checks if _j or _k has the value of 3. If _j is 3, then the method
	 * increments _points by 1, displays the victory message for the player, and creates a new Frame. 
	 * If _k is 3, then the method adds _points to _l (the ArrayList), sets 
	 * _points to 0, displays the defeat message for the player, and creates a new Frame.
	 */
	private void checkPoints() {
		if(_j == 3) {
			_f.getFrame().setVisible(false);
			_w.msg4("Yay! You win!\n"+"Score: " + _points, "WINNER", new ImageIcon(getClass().getResource("veemo.png")));
			_points++;
			_f = new Frame(0, 0, BLACK, BLACK, "(has not made a move)", _points, _l);
		}
		else if (_k == 3) {
			_f.getFrame().setVisible(false);
			_w.msg4("Aw, man! You lost!\n"+"Score: " + _points, "LOSER", new ImageIcon(getClass().getResource("octo.png")));
			
			_l.add(_points);
			_points = 0;
			_f = new Frame(0, 0, BLACK, BLACK, "(has not made a move)", _points, _l);
		}
	}
	
	/*
	 * This method checks if the player wins, the computer wins, or the result is a tie depending on
	 * what the computer's card is and what the player's card is and displays the result accordingly. 
	 * It also calls the checkPoints method and stops the timer.
	 */
	public void action() {
		if(_s.equals(_s2)) {
			_f.getFrame().setVisible(false);
			_w.msg3("It's a tie!", "TIE!");
			_f = new Frame(_j, _k, BLACK, BLACK, "(has not made a move)", _points, _l);
		}
		else if(_s.equals("Rock")) {
			if(_s2.equals("Paper")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You lose!", "YOU LOSE!");
				_f = new Frame(_j, ++_k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
			else if(_s2.equals("Scissors")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You win!", "YOU WIN!");
				_f = new Frame(++_j, _k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
		}
		else if(_s.equals("Paper")) {
			if(_s2.equals("Scissors")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You lose!", "YOU LOSE!");
				_f = new Frame(_j, ++_k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
			else if(_s2.equals("Rock")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You win!", "YOU WIN!");
				_f = new Frame(++_j, _k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
		}
		else if(_s.equals("Scissors")) {
			if(_s2.equals("Rock")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You lose!", "YOU LOSE!");
				_f = new Frame(_j, ++_k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
			else if(_s2.equals("Paper")) {
				_f.getFrame().setVisible(false);
				_w.msg3("You win!", "YOU WIN!");
				
				_f = new Frame(++_j, _k, BLACK, BLACK, "(has not made a move)", _points, _l);
			}
		}
		checkPoints();
		t.stop();
	}
	
	/*
	 * This method overrides the original actionPerformed method and displays a new frame representing
	 * the moves of Player 1 and the CPU and the status of the game or
	 * message dialog displaying the high scores of Player 1 or Player 2
	 * depending on the value of _i.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		UIManager.put("OptionPane.background",new ColorUIResource(0,150,0));
		UIManager.put("Panel.background",new ColorUIResource(0,150,150));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Calibri", Font.CENTER_BASELINE, 18)));
		if(_i == 0) {
			_s = "Rock";
			int id = (int)(Math.random()*3);
			_s2 = getMove(id);
			_f.getFrame().setVisible(false);
			_f = new Frame(0,0, ROCK, getCPUIcon(id), _s2, _points, _l);
			t.start();
		}
		else if(_i == 1) {
			_s = "Paper";
			int id = (int)(Math.random()*3);
			_s2 = getMove(id);
			_f.getFrame().setVisible(false);
			_f = new Frame(0,0, PAPER, getCPUIcon(id), _s2, _points, _l);
			t.start();
		}
		else if(_i == 2) {
			_s = "Scissors";
			int id = (int)(Math.random()*3);
			_s2 = getMove(id);
			_f.getFrame().setVisible(false);
			_f = new Frame(0,0, SCISSORS, getCPUIcon(id), _s2, _points, _l);
			t.start();
		}
		else if(_i == 3) {
			_w.msg2("List of high scores: \n"
					+ _l.toString(), "HIGH SCORES");
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
