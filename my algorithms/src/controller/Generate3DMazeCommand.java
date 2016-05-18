package controller;

import model.Model;

public class Generate3DMazeCommand implements Command {
	Model model;

	public Generate3DMazeCommand(Model model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] args) {
		String name = args[0];
		int rows =  Integer.parseInt(args[1]);
		int cols =	Integer.parseInt(args[2]);
		int floor=	Integer.parseInt(args[3]);
		model.generateMaze(name, rows, cols,floor);
	}
}
