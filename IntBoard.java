import java.util.Arrays;
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
		visited = new boolean[15];
		Arrays.fill(visited, false);
	}
	
	public void calcAdjacencies(){
		for(int row = 0; row <= 3; row++) {
			for(int column = 0; column <= 3; column++) {
				LinkedList<Integer> adjs = new LinkedList<Integer>();
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
				else if(column-1 == 0)
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
		LinkedList<Integer> adjs = adjMtx.get(location);
		for(Integer i : adjs) {
			visited[i] = true;
			if(steps == 1) 
				targets.add(i);
			else
				startTargets(i, steps - 1);
			visited[i] = false;
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
