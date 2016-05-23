package controller;

import model.Model;

public class Load_Maze_Command implements Command {
	private Model model;

	public Load_Maze_Command(Model model) {
		this.model=model;
	}

	@Override
	public void doCommand(String[] arg) throws Exception {
		String mazeName = arg[0];
		String fileName = arg[1];
		model.Load_maze(fileName, mazeName);

	}

}
