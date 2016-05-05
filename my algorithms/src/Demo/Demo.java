package Demo;


import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BestFirstSearch;

import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Solution;
/**
 *  this class creates an object adapter, solving the maze by Bfs,Dfs,BreadthFirstSearch
 * @author Bar 
 *
 */
public class Demo {

	 public void run(){
		 //Creating a maze3d by MyMaze3dGenerator 
		MyMaze3dGenerator myMaze = new MyMaze3dGenerator();
		Maze3d maze3d = myMaze.generate(7,7,3);
		//Print the maze
		maze3d.print();
		//StartPosition and GoalPosition of maze3d
		Position pos = maze3d.getStartPosition();
		Position po = maze3d.getGoalPosition();
		//print the start and the goal position
		System.out.println("Start:" + pos.x + "," + pos.y + "," + pos.z);
		System.out.println("goal:" + po.x + "," + po.y + "," + po.z);
		//create mazeadpter and solving the maze with bestfirstsearch,breadthfirstsearch
		//and depthfirstsearch and print the solutions
		MazeAdpter adpter = new MazeAdpter(maze3d);
		BestFirstSearch bfs=new BestFirstSearch();
		DepthFirstSearch dfs=new DepthFirstSearch();
		BreadthFirstSearch breadFs=new BreadthFirstSearch();
		Solution solution1=bfs.search(adpter);
		Solution solution2=breadFs.search(adpter);
		Solution solution3=dfs.search(adpter);
		System.out.println("Best first search:" + " " + solution1);
		System.out.println(" ");
		System.out.println("Bredthfirstsearch:" + " " + solution2);
		System.out.println(" ");
		System.out.println("Depthfirstsearch:" + " " + solution3);

	}
}


