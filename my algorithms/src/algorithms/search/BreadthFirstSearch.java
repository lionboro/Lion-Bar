package algorithms.search;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
/**
 * Breadth First Search class extends from Best First Search
 *  but all the cost=0
 * 
 * @author Bar
 * 
 */


public class BreadthFirstSearch extends BestFirstSearch {
	
	public BreadthFirstSearch() {
		Comparator<State> newCmp;
		newCmp= new Comparator<State>() {
			
			@Override
			public int compare(State o1, State o2) {

				return 0;
			}
		};
		
		PriorityQueue<State> newOpenList = new PriorityQueue<>(newCmp);

		openList=newOpenList;
		
		
			
	}



}
