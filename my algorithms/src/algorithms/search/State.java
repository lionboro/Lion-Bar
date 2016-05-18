package algorithms.search;
/**
 * the State Class
 *@author Bar 
 *@param cost is the weight of the path - the calculate cost from
 * the start position to this state
 *@param cameFrom indicate from which state we arrive to this current state
 */
public class State implements Comparable<State>{
	private String description ;
	private double cost;
	private State cameFrom;
	
	//Getters& Setters
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public State getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
	//compare between to states
	public int compareTo(State s) {
		return (int)(this.cost - s.cost);
	}
	//  override Object's equals method
	@Override
	public boolean equals(Object arg0) {
		State state = (State)arg0;
		return description.equals(state.description);
	}
	@Override
	public int hashCode() {
		return description.hashCode();
	}
	@Override
	public String toString() {
		return description;
		
	}
}
