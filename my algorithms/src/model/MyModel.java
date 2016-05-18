package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;
import io.MyCompressorOutputStream;



public class MyModel implements Model {
	private Controller controller;
	private ArrayList<Thread> threads = new ArrayList<Thread>();
	private HashMap<String, Maze3d> mazes = new HashMap<String, Maze3d>();
	
	
	public MyModel(Controller controller)
	{
		this.controller = controller;
	}
	
	@Override
	public void generateMaze(String[] args){
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {				
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(Integer.valueOf(args[1]), Integer.valueOf(args[2]),Integer.valueOf(args[3]));
				mazes.put(args[0], maze);
				//controller.displayMessage("Maze " + name + " is ready\n");				
			}				
		});
		thread.start();	
		threads.add(thread);
	}

	@Override
	public void saveMaze(String name, String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadMaze(String fileName, String name) {
		// TODO Auto-generated method stub
		
	}
	




}
