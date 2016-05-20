package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public interface Controller {
	void setModel(Model model);

	void setView(View view);

	void displayMessage(String message);

	void generateCommands();

	//public HashMap<String, Command> getMap();
}
