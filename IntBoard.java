import java.util.HashSet;
import java.util.LinkedList;

//Naomi Plasterer and Brandon Bosso

public class IntBoard {
	private HashSet<Integer> targets;
	private Map<Integer, LinkedList<Integer>> adjMtx;
	private boolean[] visited;
	
	public IntBoard() {
		targets = new HashSet<Integer>();
		Arrays.fill(visited, 0, 14 false);
	}
	
	public void calcAdjacencies(){
		
	}
	
	public void startTargets(int location, int steps){
		
	}
	
	public HashSet getTargets(){
		
		//return a HashSet with no items
		return targets;	
	}
	
	public LinkedList<Integer> getAdjList(int location){
		return adjMtx.get(location);
	}
	
	public int calcIndex(int row, int column){
		return (2*row) + column;
	}
}
