package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMaze3dGenerator extends Common3dMazeGenerator {

	private Maze3d simpleMaze;
	private Random rand = new Random();
	private Position chooseRandomPosition() {
		// Choose an even row
		int x = rand.nextInt(simpleMaze.getRow());
		while (x % 2 == 1)
			x = rand.nextInt(simpleMaze.getRow());
		
		// Choose an even column
		int y = rand.nextInt(simpleMaze.getColumn());
		while (y % 2 == 1)
			y = rand.nextInt(simpleMaze.getColumn());	
				
		// Choose an even floor
		int z = rand.nextInt(simpleMaze.getFloor());
		while (z % 2 == 1)
			z = rand.nextInt(simpleMaze.getFloor());	
		
		return new Position(x, y, z);
	}
	
	@Override
	public Maze3d generate(int rows, int column, int floor) {
		simpleMaze=new Maze3d(rows, column, floor);
		// Initialization maze randomly
		for (int i = 0; i <floor; i++) {
			for (int j = 0; j < rows; j++) {
				for (int k= 0; k< column; k++) {
					int  n = rand.nextInt(2) + 1;
					if (n==1){
						simpleMaze.setWall(j, k, i);
					}		
				}
			}
		}
		
		simpleMaze.setStartPosition(chooseRandomPosition());
		simpleMaze.setFree(simpleMaze.getStartPosition().getX(),simpleMaze.getStartPosition().getY(), simpleMaze.getStartPosition().getZ());
		simpleMaze.setGoalPosition(chooseRandomPosition());
		simpleMaze.setFree(simpleMaze.getGoalPosition().getX(),simpleMaze.getGoalPosition().getY(), simpleMaze.getGoalPosition().getZ());
		
		Position go=simpleMaze.getGoalPosition();
		Position Start= new Position(simpleMaze.getStartPosition().getX(),simpleMaze.getStartPosition().getY(),simpleMaze.getStartPosition().getZ());
		

		while (!(simpleMaze.getGoalPosition().equals(Start))) 
		{
		// run on floor
			while (Start.getZ()<go.getZ()) {
				Start.setZ(Start.getZ()+1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
			while (Start.getZ()>go.getZ()) {
				Start.setZ(Start.getZ()-1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
		// run on colums
			while (Start.getY()<go.getY()) {
				Start.setY(Start.getY()+1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
			while (Start.getY()>go.getY()) {
				Start.setY(Start.getY()-1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
		// run on rows
			while (Start.getX()<go.getX()) {
				Start.setX(Start.getX()+1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
			while (Start.getX()>go.getX()) {
				Start.setX(Start.getX()-1);
				simpleMaze.setFree(Start.getX(), Start.getY(), Start.getZ());
			}
			
		}
		return simpleMaze;
	}

	}
	


