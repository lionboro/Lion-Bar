package view;

import java.io.BufferedReader;
import java.io.IOException;
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
	//thread
	Thread thread=new Thread(new Runnable() {

		@Override
		public void run() {
			 
			try {
				Out.write("Enter command: ");
				Out.flush();
				String line = In.readLine();
				while (!(line.equals("exit"))) {
					
										
					String[] arr = line.split(" ");
					String str = "";
					int i = 0;					
					
					Command command = null;
					while (command == null && i < arr.length) {
						str += arr[i];
						command = Commands.get(str);
						str += " ";
						i++;
					}
					
					if (command == null) {
						Out.write("Command not found\n");
						Out.flush();							
					} else {
						
						String[] args = null;
						if (i < arr.length) {
							args = new String[arr.length - i];
							System.arraycopy(arr, i, args, 0, arr.length - i);
						}						
						
						command.doCommand(args);						
					}						
					
					Out.write("Enter command: ");
					Out.flush();
					line = In.readLine();
				}	
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}						
		}
		
	});
	thread.start();
}
}