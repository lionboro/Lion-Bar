package algorithms.search;

import java.util.ArrayList;
/**
 *this class show us the solution from the start state to the goal state.
 *@author Bar
 *@param ArrayList<State>
 */


public class Solution {
	private ArrayList<State> states;

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State s: states) {
			sb.append(s).append("\n");
		}
		return sb.toString();
	}
}
