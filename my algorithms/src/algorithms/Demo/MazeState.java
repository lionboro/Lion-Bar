package algorithms.Demo;

import algorithms.mazeGenerators.Position;
import algorithms.search.State;

public class MazeState extends State {
	private Position currPlayerPosition;

	public Position getCurrPlayerPosition() {
		return currPlayerPosition;
	}

	public void setCurrPlayerPosition(Position currPlayerPosition) {
		this.currPlayerPosition = currPlayerPosition;
	}
	
	public MazeState(Position pos) {
		this.currPlayerPosition = pos;
		this.setDescription(pos.toString());
	}
	
}
