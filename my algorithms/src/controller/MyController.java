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

	public void setCommands(HashMap<String, Command> commands) {
		this.commands_map = new HashMap<String, Command>();

		commands_map.put("Dir", new Command() {

			@Override
			public void doCommand(String[] arg) {
				// TODO Auto-generated method stub

			}
		});
		commands_map.put("Generate_3d_maze", new Command() {

			@Override
			public void doCommand(String[] arg) {
				String name_of_maze = arg[0];
				int row = Integer.parseInt(arg[1]);
				int column = Integer.parseInt(arg[2]);
				int floor = Integer.parseInt(arg[3]);
				model.Generate_3d_maze(name_of_maze, row, column, floor);
			}
		});

	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateCommands() {
		// TODO Auto-generated method stub
		
	}





}
