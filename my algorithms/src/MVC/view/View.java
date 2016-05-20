package MVC.view;

import java.util.HashMap;

import MVC.controller.Command;

public interface View {
	void displayMessage(String message);
	void start();
	void sendCommands(HashMap<String, Command> commands);
	
}
