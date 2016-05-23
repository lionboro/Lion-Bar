package controller;

import model.Model;

public class Save_Maze_Command implements Command {
	private Model model;

	public Save_Maze_Command(Model model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] arg) throws Exception {
		String mazename = arg[0];
		String fileName = arg[1];
		
		model.Save_maze(mazename, fileName);

	}

}
