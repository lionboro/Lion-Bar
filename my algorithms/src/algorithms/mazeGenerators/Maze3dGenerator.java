package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	Maze3d generate(int Floor, int row, int column);
	String measureAlgorithmTime(int row, int column, int floor);
}
