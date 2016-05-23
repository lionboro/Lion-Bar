package controller;

import java.io.IOException;
import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {
	private Model model;
	private View view;
	private HashMap<String, Command> commands_map;

	public void setModel(Model model) {
		this.model = model;

	}

	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}
	@Override
	public void modelSolution(String[] solution) {
		view.sendDisplySolution(solution);

	}
	@Override
	public void generateCommands() {
		HashMap<String, Command> commands = new HashMap<String, Command>();
		commands.put("Generate_3d_maze", new Generate_Maze_Command(model));
		commands.put("Save_maze", new Save_Maze_Command(model));
		commands.put("Load_maze",new Load_Maze_Command(model));
		view.sendCommands(commands);
	}

	@Override
	public HashMap<String, Command> getMap() {
		
			return commands_map;
	}

}
