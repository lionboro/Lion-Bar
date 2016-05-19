package controller;

import model.Model;

public class C_Maze3dgenerator implements Command {

	private Model model;

	public C_Maze3dgenerator(Model model) {
		this.model = model;
	}

	public void doCommand(String arg) {
		String[] s = new String[4];
		if (arg == null) {
			model.Error_massage("NULL");
		}

		else {
			s = arg.split(",");
			if (s[0] == null)
				model.Error_massage("noName");
			String s1 = new String();
			s1 += s[1];
			s1 += s[2];
			s1 += s[3];

			if (!s1.matches("[0-9]+") || s[1] == null || s[2] == null || s[3] == null)
				model.Error_massage("noArg");
			else {

				int row = Integer.parseInt(s[1]);
				int col = Integer.parseInt(s[2]);
				int floor = Integer.parseInt(s[3]);
				model.Generate_3d_maze(s[0], row, col, floor);
			}
		}
	}

}
