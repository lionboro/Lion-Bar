package model;

public interface Model {
	void generateMaze(String[] args);
	void saveMaze(String name, String fileName);
	void loadMaze(String fileName, String name);
}
