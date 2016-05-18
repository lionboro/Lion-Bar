package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller{
	private Model model;
	private View view;
	private HashMap<String, Command> commands;
	@Override
	public void update(Command command) {
		command.doCommand(args);
		
	}
	
}
