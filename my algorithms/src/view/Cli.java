package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class Cli {
	private BufferedReader In;
	private PrintWriter Out;
	private HashMap<String, Command> Commands;

	public Cli(BufferedReader In, PrintWriter Out, HashMap<String, Command> Commands) {
		this.In = In;
		this.Out = Out;
		this.Commands = Commands;
	}

public void start(){
	
	Thread thread=new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
		
	});
	
	
}

}
