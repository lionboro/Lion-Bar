package controller;

import model.Model;

public class Generate3DMazeCommand implements Command {
	Model model;
	String[] args;
	public Generate3DMazeCommand(Model model) {
		this.model = model;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	@Override
	public void doCommand() {
//		String name = args[0];
//		int rows =  Integer.parseInt(args[1]);
//		int column =	Integer.parseInt(args[2]);
//		int floor=	Integer.parseInt(args[3]);
//		model.generateMaze(name, rows, column,floor);
		model.generateMaze(args);
	}
}
