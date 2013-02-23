import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

//Naomi Plasterer and Brandon Bosso

public class IntBoard {
	private HashSet<Integer> targets;
	private Map<Integer, LinkedList<Integer>> adjMtx;
	private boolean[] visited;
	
	public IntBoard() {
		targets = new HashSet<Integer>();
		adjMtx = new HashMap<Integer, LinkedList<Integer>>();
		visited = new boolean[16];
		Arrays.fill(visited, false);
	}
	
	public void calcAdjacencies(){
		LinkedList<Integer> adjs;
		for(int row = 0; row <= 3; row++) {
			for(int column = 0; column <= 3; column++) {
				adjs = new LinkedList<Integer>();
				if(row == 3) 
					adjs.add(calcIndex(row-1,column));
				else if(row == 0)
					adjs.add(calcIndex(row+1,column));
				else {
					adjs.add(calcIndex(row+1,column));
					adjs.add(calcIndex(row-1,column));
				}

				if(column == 3)
					adjs.add(calcIndex(row,column-1));
				else if(column == 0)
					adjs.add(calcIndex(row,column+1));
				else {
					adjs.add(calcIndex(row,column+1));
					adjs.add(calcIndex(row,column-1));
				}
				adjMtx.put(calcIndex(row,column),adjs);
			}
		}
	}
	
	public void startTargets(int location, int steps){
		//empty targets and set visited to false just in case
		targets = new HashSet<Integer>();
		Arrays.fill(visited, false);
		//set start location to true
		visited[location] = true;
		calcTargets(location,steps);
	}
	
	public void calcTargets(int location, int steps) {
		LinkedList<Integer> adjs = new LinkedList<Integer>();
		for(Integer i : adjMtx.get(location)) {
			if(!visited[i])
				adjs.add(i);
		}
		for(Integer adjCell : adjs) {
			visited[adjCell] = true;
			if(steps == 1) 
				targets.add(adjCell);
			else
				calcTargets(adjCell, steps - 1);
			visited[adjCell] = false;
		}
	}
	
	public HashSet getTargets(){
		return targets;	
	}
	
	public LinkedList<Integer> getAdjList(int location){
		return adjMtx.get(location);
	}
	
	public int calcIndex(int row, int column){
		return (4*row) + column;
	}
}
