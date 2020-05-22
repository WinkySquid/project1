package models;

import java.util.ArrayList;
import java.util.Collections;

public class List {
	
	//INSTANCE VARIABLE (ArrayList of Integer objects)
	private ArrayList<Integer> _list;
	
	//CONSTRUCTOR
	public List() {
		_list = new ArrayList<Integer>();
	}
	
	/*
	 * This method adds an int variable i to the end of _list and increments the size of _list by 1.
	 */
	public void add(int i) {
		_list.add(i);
	}
	
	/*
	 * This method removes the Integer object at index i in _list and decrements the size of _list by 1.
	 */
	public void remove(int i) {
		_list.remove(i);
	}
	
	/*
	 * This creates the toString method that overrides the toString method of the Object class and returns 
	 * a String that represents the list of high scores that a player has. 
	 * If a player does not have any high scores, it returns "NO HIGH SCORES".
	 */
	@Override
	public String toString() {
		
		String s = "";
		if(_list.size() == 0) {
			return "NO HIGH SCORES";
		}
		for(int i = _list.size()-1; i >=0; i--) {
			Collections.sort(_list);
			if(i > 0) {
				s += _list.get(i) + ", ";
			}
			else {
				s += _list.get(i);
			}
		}
		return s;
	}
}
