package controller;

import model.Model;

public class Generate_Maze_Command implements Command {
	Model model;
	
	public Generate_Maze_Command(Model model) {
		this.model=model;
		}

	@Override
	public void doCommand(String[] args) {
		if (args.length < 4)
			throw new IllegalArgumentException("Incorrect number of args");
		
		String name = args[0];
		int rows = Integer.parseInt(args[1]);
		int columns = Integer.parseInt(args[2]);
		int levels = Integer.parseInt(args[3]);
		
		
		model.Generate_3d_maze(name, rows, columns, levels);	

	}

}


