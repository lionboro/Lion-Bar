package Demo;


import java.util.HashMap;

import Demo.MazeState;
import algorithms.search.Action;
import algorithms.search.Searchable;
import algorithms.search.State;
import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.Maze3d;
/**
 * This class doing an Adaptation to each sherchable problem in the maze. 
 * @author BAR
 *
 */

public class MazeAdpter implements Searchable{

	private Maze3d maze;
	private static final int MOVEMENT_COST = 1;
	
	public MazeAdpter(Maze3d maze) {
		this.maze=maze;
	}
	
	@Override
	public State getStartState() {
		MazeState startState=new MazeState(maze.getStartPosition());
		//MazeState startState = new MazeState(maze.getStartPosition());
		return startState;
	}

	@Override
	public State getGoalState() {
		MazeState goalState = new MazeState(maze.getGoalPosition());
		return goalState;
	}

	private Position getNextPosition(Position currPos, Direction dir) {
		
		switch (dir) {
		case FORWARD:
			return new Position(currPos.x+1, currPos.y, currPos.z);
		case BACKWARD:
			return new Position(currPos.x-1, currPos.y, currPos.z);
		case RIGHT:
			return new Position(currPos.x, currPos.y+1,currPos.z);			
		case LEFT:
			return new Position(currPos.x, currPos.y-1,currPos.z);	
		case DOWN:
			return new Position(currPos.x, currPos.y,currPos.z-1);	
		case UP:
			return new Position(currPos.x, currPos.y,currPos.z+1);	
		}
		return null;
	}
	@Override
	public HashMap<Action, State> getAllPossibleActions(State state) {
		MazeState mazeState = (MazeState)state;
		Position pos = mazeState.getCurrPlayerPosition();
		Direction[] directions = maze.getPossibleDirections(pos);
		
		HashMap<Action, State> actions = new HashMap<Action, State>();
		for (Direction d: directions) {
			Action action = new Action(d.toString(), MOVEMENT_COST);
			MazeState newState = new MazeState(getNextPosition(pos, d));
			
			actions.put(action, newState);
		}
		
		return actions;
	}

}
