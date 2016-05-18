package algorithms.mazeGenerators;

public abstract class Common3dMazeGenerator implements Maze3dGenerator {

abstract public Maze3d generate(int row, int column, int floor);
@Override
	public String measureAlgorithmTime(int row,int column,int floor) {
	long startTime = System.currentTimeMillis();
	generate(row, column,floor);
	long endTime = System.currentTimeMillis();
	long duration = endTime - startTime;
	return String.valueOf(duration);
	}
}
