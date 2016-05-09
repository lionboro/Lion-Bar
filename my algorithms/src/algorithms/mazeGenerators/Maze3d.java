package algorithms.mazeGenerators;

import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Position;

public class Maze3d {

	// data member

	int row;// x
	int column;// y
	int floor;// z
	public int[][][] maze;
	private Position startPosition;
	private Position goalPosition;
	private int[][][] maze3d;

	// WALL OR FREE
	public static final int Free = 0;
	public static final int Wall = 1;

	// Getters

	// get a 3d Maze
	public int[][][] getMaze() {
		return maze;
	}

	// get row:x
	public int getRow() {
		return row;
	}

	// get column:y
	public int getColumn() {
		return column;
	}

	// get floor:z
	public int getFloor() {
		return floor;
	}

	// get wall
	public static int getWall() {
		return Wall;
	}

	// get free
	public static int getFree() {
		return Free;
	}

	// get value of maze cell
	public int getValue(int x, int y, int z) {
		return maze[x][y][z];
	}

	// get start maze cell
	public Position getStartPosition() {
		return startPosition;
	}

	// get goal maze cell
	public Position getGoalPosition() {
		return goalPosition;
	}

	// Setters

	// set a wall
	public void setWall(int x, int y, int z) {
		maze[x][y][z] = Wall;
	}

	// set free
	public void setFree(int x, int y, int z) {
		maze[x][y][z] = Free;
	}

	// set start maze cell
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	// set goal maze cell
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}

	public Maze3d(byte[] B) {
		// size of the maze
		this.row = B[0];
		this.column = B[1];
		this.floor = B[2];
		// start position [x][y][z]
	/*	this.getStartPosition().setX(B[3]);
		this.getStartPosition().setY(B[4]);
		this.getStartPosition().setZ(B[5]);
		// goal position [x][y][z]
		this.getGoalPosition().setX(B[6]);
		this.getGoalPosition().setY(B[7]);
		this.getGoalPosition().setZ(B[8]);*/
		this.startPosition = new Position(B[5],B[4],B[3]);
		this.goalPosition = new Position(B[8],B[6],B[7]);
		//all maze cells
		int c=8;
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				for (int k = 0; k < this.floor; k++) {
					this.maze[i][j][k]=B[c+1];
				}

			}
		}
	}

	// cTOR of the maze
	public Maze3d(int row, int column, int floor) {
		this.floor = floor;
		this.row = row;
		this.column = column;
		this.maze = new int[row][column][floor];// [x][y][z]
	}

	// copy cTOR
	public Maze3d(Maze3d myMaze3d) {
		this.row = myMaze3d.row;
		this.column = myMaze3d.column;
		this.floor = myMaze3d.floor;
		this.startPosition = myMaze3d.startPosition;
		this.goalPosition = myMaze3d.goalPosition;
		this.maze = new int[myMaze3d.row][myMaze3d.column][myMaze3d.floor];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Start: " + startPosition + "\n");
		sb.append("Goal: " + goalPosition + "\n");
		for (int i = 1; i < floor; i++) {
			for (int j = 1; j < row; j++) {
				for (int k = 1; k < column; k++) {
					sb.append(maze[j][k][i] + " ");
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Direction[] getPossibleDirections(Position pos) {
		ArrayList<Direction> directions = new ArrayList<Direction>();
		if (pos.y + 1 < column && maze[pos.x][pos.y + 1][pos.z] == Free)
			directions.add(Direction.RIGHT);
		if (pos.y - 1 >= 0 && maze[pos.x][pos.y - 1][pos.z] == Free)
			directions.add(Direction.LEFT);
		if (pos.z - 1 >= 0 && maze[pos.x][pos.y][pos.z - 1] == Free)
			directions.add(Direction.DOWN);
		if (pos.z + 1 < floor && maze[pos.x][pos.y][pos.z + 1] == Free)
			directions.add(Direction.UP);
		if (pos.x + 1 < row && maze[pos.x + 1][pos.y][pos.z] == Free)
			directions.add(Direction.FORWARD);
		if (pos.x - 1 >= 0 && maze[pos.x - 1][pos.y][pos.z] == Free)
			directions.add(Direction.BACKWARD);
		Direction[] arr = new Direction[directions.size()];
		directions.toArray(arr);
		return arr;
	}

	public int[][] getCrossSectionByX(int num) throws IndexOutOfBoundsException {
		if (num < 0 || num >= maze.length)
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
		else {
			int[][] x = new int[this.maze[0].length][this.maze[0][0].length];
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < x[0].length; j++) {
					x[i][j] = maze[num][i][j];
				}
			}
			return x;
		}
	}

	public int[][] getCrossSectionByY(int num) throws IndexOutOfBoundsException {
		if (num < 0 || num >= maze[0].length)
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
		else {
			int[][] y = new int[this.maze.length][this.maze[0][0].length];
			for (int i = 0; i < y.length; i++) {
				for (int j = 0; j < y[0].length; j++) {
					y[i][j] = maze[i][num][j];
				}
			}
			return y;

		}

	}

	public int[][] getCrossSectionByZ(int num) throws IndexOutOfBoundsException {
		if (num < 0 || num >= maze[0].length)
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");
		else {
			int[][] z = new int[this.maze.length][this.maze[0].length];
			for (int i = 0; i < z.length; i++) {
				for (int j = 0; j < z[0].length; j++) {
					z[i][j] = maze[i][j][num];
				}
			}
			return z;

		}

	}

	public void PrintMazeCross(int arr[][])

	{
		String s = new String();
		for (int j = 0; j < arr.length; j++) {
			for (int j2 = 0; j2 < arr[0].length; j2++) {
				s += " " + arr[j][j2];
			}
			s += "\n";
		}

		System.out.println(s);
	}

	public byte[] toByteArray() {

		// put in arraylist (row,column,floor,start(x,y,z),goal(x,y,z))
		ArrayList<Byte> Array = new ArrayList<Byte>();
		Array.add((byte) getRow());
		Array.add((byte) getColumn());
		Array.add((byte) getFloor());
		Array.add((byte) startPosition.getX());
		Array.add((byte) startPosition.getY());
		Array.add((byte) startPosition.getZ());
		Array.add((byte) goalPosition.getX());
		Array.add((byte) goalPosition.getY());
		Array.add((byte) goalPosition.getZ());
		// put in array ,all the maze cells 0 or 1;
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				for (int z = 0; z < floor; z++) {

					Array.add((byte) maze[x][y][z]);

				}
				
			}
		}
		// copy the array and convert to bytes array;
		byte[] bytes = new byte[Array.size()];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = Array.get(i);
		}
		System.out.println(Array);
		return bytes;
	}

	// print the maze3d
	public void print() {
		for (int k = 0; k < floor; k++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					System.out.print(maze[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
