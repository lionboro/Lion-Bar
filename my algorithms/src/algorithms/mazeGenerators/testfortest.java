package algorithms.mazeGenerators;

public class testfortest {
public static void main(String[] args) {
	
	MyMaze3dGenerator md=new MyMaze3dGenerator();
	Maze3d m3=new Maze3d(9,9,3);
	m3=md.generate(9, 9,3);

	Position Spos=m3.getStartPosition();
	Position Gpos=m3.getGoalPosition();
	System.out.println("Start:" + Spos.x + "," + Spos.y + "," + Spos.z);
	System.out.println("goal:" + Gpos.x + "," + Gpos.y + "," + Gpos.z);
	
	m3.print();
	
}
}
