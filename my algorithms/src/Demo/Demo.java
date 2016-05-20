package Demo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BestFirstSearch;

import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Solution;
import controller.Command;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import view.Cli;
/**
 *  this class creates an object adapter, solving the maze by Bfs,Dfs,BreadthFirstSearch
 * @author Bar 
 *
 */
public class Demo {

	 public void run() throws IOException {
/*		 //Creating a maze3d by MyMaze3dGenerator 
			MyMaze3dGenerator myMaze = new MyMaze3dGenerator();
			Maze3d maze3d = myMaze.generate(7,7,3);*/
		//Print the maze
		/*maze3d.print();
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
		System.out.println("Depthfirstsearch:" + " " + solution3);*/
		/*byte[] Btest=maze3d.toByteArray();
		Maze3d m3=new Maze3d(Btest);
		m3.print();*/
		 MyMaze3dGenerator myMazeGenerator = new MyMaze3dGenerator();
		 Maze3d maze = myMazeGenerator.generate(5, 5, 5);
		
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		
		System.out.println(loaded.equals(maze));
	 }
}