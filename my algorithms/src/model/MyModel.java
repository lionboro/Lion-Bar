package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel implements Model {
	private Controller controller;
	private ArrayList<Thread> threads = new ArrayList<Thread>();
	private HashMap<String, Maze3d> mazes = new HashMap<String, Maze3d>();

	public MyModel(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void Dir(String path) {

	}

	
	@Override
	public void Generate_3d_maze(String name, int row, int column, int floor) {
		Thread thread=new Thread(new  Runnable() {
			@Override
			public void run() {
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(row, column, floor);
				mazes.put(name, maze);
				controller.displayMessage("maze " + name + " is ready");
			}
		});
		thread.start();
		threads.add(thread);
	}

	
	@Override
	public void Display(String name) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void Display_cross_section_by_x(int index_x, String name) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void Display_cross_section_by_y(int index_x, String name) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void Display_cross_section_by_z(int index_x, String name) {
		// TODO Auto-generated method stub

	}
@Override
	public void Save_maze(String name, String fileName) 
	{
		if (!mazes.containsKey(name)) 
		{
			controller.displayMessage("Maze " + name + " does not exist\n");
			return;
		}
		Maze3d maze = mazes.get(name);
		try {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
			int size = maze.toByteArray().length;
			int count = 0;
			while(size>255)
			{
				size = size-255;
				count++;
			}	
			out.write(size);
			out.write(count);
			out.write(maze.toByteArray());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			controller.displayMessage("File Not Found");
			return;
		} catch (IOException e) {
			controller.displayMessage("IOEXception");
			return;
		}
	}
	@Override
	
	public void Load_maze(String filename,String name)  
	{
		if (mazes.containsKey(name))
		{
			controller.displayMessage("Maze " + name + " Already exist");
			return;
		}
		byte[] myarry = null;
		try{

			InputStream in = new MyDecompressorInputStream(new FileInputStream(filename));
			int size = in.read();
			int count =in.read();
			if(count >0)
			{
				count = count*255;
				size = size+count;
			}
			myarry = new byte[size];
			in.read(myarry);
			in.close();
		}catch(FileNotFoundException e){
			controller.displayMessage("File Not Found");
			return;
		} catch (IOException e) {
			controller.displayMessage("IOEXception");
			return;
		}
		mazes.put(name, new Maze3d(myarry));
	}
/*	@Override
	public void Save_maze(String mazeName, String fileName) throws Exception {
		if (!mazes.containsKey(mazeName)) {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName + ".maze"));
			out.write(mazes.get(mazeName).toByteArray());
			out.flush();
			out.close();
			controller.modelSolution(
					("the maze: " + mazeName + " " + "is saved successfully in file: " + fileName).split("\b"));
		}
		else {
			throw new RuntimeException("The maze is not exist in dataBase");
		}
	}

	
	@Override
	public void Load_maze(String fileName, String mazeName) throws Exception {
		MyDecompressorInputStream in = new MyDecompressorInputStream(new FileInputStream(new File(fileName + ".maze")));
		byte b[] = new byte[(int)Files.size(new File(fileName + ".maze").toPath()) + 34];
		in.read(b);
		in.close();
		mazes.put(mazeName, new Maze3d(b));
		if (mazes.containsKey(mazeName)) {
			controller.modelSolution(("The maze: " + mazeName + " " + "loaded successfully").split("\b"));
		}
		else {
			throw new RuntimeException(
					"The maze: " + mazeName + " " + "is not exist in database please check the file name");
		}

	}*/

	@Override
	public void Maze_size(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void File_size(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Slove(String name, String Algo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Display_solution(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Error_massage(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Maze3d getMaze(String name) {
		
		return mazes.get(name);	
	}
	
}
