package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View {
	private BufferedReader in;
	private Writer out;
	private Cli cli;
	private Controller controller;
	private HashMap<String, Command> commands;

	public MyView(Controller controller2, BufferedReader in2, PrintWriter out2) {
		// TODO Auto-generated constructor stub
		cli.setV(this);
	}

	@Override
	public void start() throws Exception {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				cli.start();
			}
			
		});	
		thread.start();
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Command command) {
		command.doCommand();
		
	}

}
