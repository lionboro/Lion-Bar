package algorithms.search;

import java.util.PriorityQueue;



public abstract class CommonSearcherWithPQueue extends CommonSearcher {
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closedList;
	
	public CommonSearcherWithPQueue() {
		openList = new PriorityQueue<State>();
		closedList = new PriorityQueue<State>();
	}
}
