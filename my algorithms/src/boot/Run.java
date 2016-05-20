package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import MVC.controller.Controller;
import MVC.controller.MyController;
import MVC.model.Model;
import MVC.model.MyModel;
import MVC.view.MyView;
import MVC.view.View;

public class Run {

	public static void main(String[] args) {
		Controller controller = new MyController();
		Model model = new MyModel(controller);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		View view = new MyView(controller, in, out);

		controller.setModel(model);
		controller.setView(view);

		controller.generateCommands();
		view.start();
	}

}
