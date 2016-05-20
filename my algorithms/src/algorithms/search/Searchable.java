package algorithms.search;

import java.util.HashMap;
/**
* we use this interface due to the reason we are able to switch 
* searchable domains independently from the searching algorithm
* @author Bar
*/
public interface Searchable {
	State getStartState();
	State getGoalState();
	HashMap<Action, State> getAllPossibleActions(State state);
}
