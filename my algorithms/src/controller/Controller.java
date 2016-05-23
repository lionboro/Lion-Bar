package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public interface Controller {
	public HashMap<String, Command> getMap();
	void setModel(Model model);
	void setView(View view);
	void displayMessage(String message);	
	void generateCommands();
	void modelSolution(String[] solution);

	
}
