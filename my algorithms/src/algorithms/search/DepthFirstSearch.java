package algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
/**
 * this is the depth first search algorithm and he extends from commonsearcher 
 * using with HashSet<State>
 * @author BAR
 *
 */
public class DepthFirstSearch extends CommonSearcher {
	private HashSet<State> visitedStates = new HashSet<State>();
	private Solution solution;
	
	private void dfs(Searchable s, State state) {
		if (state.equals(s.getGoalState())) {
			solution = backtrace(state);
			return;
		}
		
		visitedStates.add(state);
		
		HashMap<Action,State> actions = s.getAllPossibleActions(state);
		for(State neighbor: actions.values())
		{
			if (!visitedStates.contains(neighbor)) {
				neighbor.setCameFrom(state);
				dfs(s, neighbor);					
			} 			
		}
		return;
	}


	@Override	
	public Solution search(Searchable s) {
		
		dfs(s, s.getStartState());		
		return solution;
	}


}
