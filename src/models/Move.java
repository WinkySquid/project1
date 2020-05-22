package models;

import javax.swing.ImageIcon;

public class Move {
	
	//INSTANCE VARIABLES
	private int _move;
	private int _points;
	private boolean _b;

	//CONSTRUCTOR
	public Move() {
		_move = 0;
		_points = 0;
		_b = false;
	}
	
	
	
	//GETTERS
	public int getPoints() {
		return _points;
	}
	public boolean hasPlayed() {
		return _b;
	}
	
	//SETTERS
	public void setMove(int i) {
		_move = i;
	}
	public void changePlay(boolean b) {
		_b = b;
	}
	
	/*
	 * This method increments the _points variable by 1.
	 */
	public void addPoints() {
		_points++;
	}
	
	/*
	 * This method returns the icon representing the player's move depending on what he or she
	 * chooses as 
	 */
	public ImageIcon getIcon() {
		if(_move == 0 && _b == true) {
			return new ImageIcon(getClass().getResource("rock.png"));
		}
		else if (_move == 1 && _b == true) {
			return new ImageIcon(getClass().getResource("paper.png"));
		}
		else if (_move == 2 && _b == true) {
			return new ImageIcon(getClass().getResource("scissors.png"));
		}
		else if (_b == false) {
			return new ImageIcon(getClass().getResource("black.png"));
		}
		return null;
	}
}
