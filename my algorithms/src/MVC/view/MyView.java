package MVC.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;

import MVC.controller.Command;
import MVC.controller.Controller;

public class MyView implements View {

	private BufferedReader in;
	private PrintWriter out;
	private Cli cli;
	private HashMap<String, Command> commands;
	private Controller controller;

	public MyView(Controller controller, BufferedReader in, PrintWriter out) {

		this.in = in;
		this.out = out;
		this.controller = controller;
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				cli.start();
			}
		});
		thread.start();

	}

	@Override
	public void sendCommands(HashMap<String, Command> commands) {

	}

}
