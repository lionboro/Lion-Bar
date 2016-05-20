package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Controller;import io.MyCompressorOutputStream;

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
		MyMaze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d maze = mg.generate(row, column, floor);
		mazes.put(name, maze);
		controller.displayMessage("maze " + name + " is ready");
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
	public void Save_maze(String name, String filename) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void Load_maze(String filename, String name) {
		// TODO Auto-generated method stub

	}

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

}
