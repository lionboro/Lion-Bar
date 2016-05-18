package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class MyMaze3dGenerator extends Common3dMazeGenerator {
	//Variables
	private Maze3d maze3d;
	private Random rand=new Random();
	
	private Position chooseRandomPosition(){
		
		int x = rand.nextInt(maze3d.getColumn());
		int y = rand.nextInt(maze3d.getRow());
		int z = rand.nextInt(maze3d.getFloor());
		while (x%2 ==1)
			x = rand.nextInt(maze3d.getColumn());
		while (y%2 == 1)
			y =rand.nextInt(maze3d.getRow());
		z=0;
		
		return new Position(x, y, z);
	}
	@Override
	public Maze3d generate(int row, int column, int floor)
	{
		maze3d=new Maze3d(row, column,floor );
		PutWallIn3dMaze();
		// Choose random start position	
		Position startPosition =chooseRandomPosition();
		maze3d.setStartPosition(startPosition);
		maze3d.setFree(startPosition.x,startPosition.y,startPosition.z);
		DFS(startPosition);
		Position endposition = chooseRandomPosition();
		int Temp = maze3d.getValue(endposition.x, endposition.y, endposition.z);
		while (Temp != maze3d.Free || endposition.equals(startPosition)){
			 endposition = chooseRandomPosition();
			 Temp = maze3d.getValue(endposition.x, endposition.y, endposition.z);
		}
	
		return maze3d;
	}
	
	public void PutWallIn3dMaze()
	{
		int [][][] m=maze3d.getMaze();
		for (int i = 0; i < maze3d.getRow(); i++) {
			for (int j = 0; j < maze3d.getColumn(); j++) {
				for (int k = 0; k < maze3d.getFloor(); k++) {
					m[i][j][k]=maze3d.Wall;
				}
			}
		}
			
	}

	private void DFS(Position pos) {
		ArrayList<Direction> Direct = getPossibleMoves(pos);
		Position newpos;
		if (Direct.size() == 0)
			return;
		
		for (int i = 0; i < Direct.size(); i++) {
		
			// Choose random direction
			int idx = rand.nextInt(Direct.size());
			Direction dir = Direct.get(idx);
			Direct.remove(idx);
			int[][][] m = maze3d.getMaze();
			
			switch (dir) {
			case BACKWARD:
				
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x-1][pos.y][pos.z] = Maze3d.Free;
				m[pos.x-2][pos.y][pos.z] = Maze3d.Free;	
				ChooseGoalPos(new Position(pos.x-2, pos.y, pos.z));
				DFS(new Position(pos.x-2, pos.y,pos.z));
				break;
			case FORWARD:
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x+1][pos.y][pos.z] = Maze3d.Free;
				m[pos.x+2][pos.y][pos.z] = Maze3d.Free;	
				ChooseGoalPos(new Position(pos.x+2, pos.y, pos.z));
				DFS(new Position(pos.x+2, pos.y,pos.z));
				break;
			case LEFT:
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x][pos.y-1][pos.z] = Maze3d.Free;
				m[pos.x][pos.y-2][pos.z] = Maze3d.Free;	
		
				ChooseGoalPos(new Position(pos.x, pos.y-2, pos.z));
				DFS(new Position(pos.x, pos.y-2,pos.z));
				break;
			case RIGHT:
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x][pos.y+1][pos.z] = Maze3d.Free;
				m[pos.x][pos.y+2][pos.z] = Maze3d.Free;	
				ChooseGoalPos(new Position(pos.x, pos.y+2, pos.z));
				DFS(new Position(pos.x, pos.y+2,pos.z));
				break;
			case DOWN:
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x][pos.y][pos.z-1] = Maze3d.Free;
				m[pos.x][pos.y][pos.z-2] = Maze3d.Free;	
				ChooseGoalPos(new Position(pos.x, pos.y, pos.z-2));
				DFS(new Position(pos.x, pos.y,pos.z-2));
				break;
			case UP:
				m[pos.x][pos.y][pos.z] = Maze3d.Free;
				m[pos.x][pos.y][pos.z+1] = Maze3d.Free;
				m[pos.x][pos.y][pos.z+2] = Maze3d.Free;	
				ChooseGoalPos(new Position(pos.x, pos.y, pos.z+2));
				DFS(new Position(pos.x, pos.y,pos.z+2));
				break;
			}
		}
	}
	
	private ArrayList<Direction> getPossibleMoves(Position pos) {
		ArrayList<Direction> Direct = new ArrayList<Direction>();
		int[][][] m = maze3d.getMaze();
		
		// Check backward neighbor
		if (pos.x-2 >= 0 && m[pos.x-2][pos.y][pos.z] == Maze3d.Wall) {
			Direct.add(Direction.BACKWARD);
		}
		
		// Check forward neighbor
		if (pos.x + 2 < maze3d.getRow() && m[pos.x+2][pos.y][pos.z] == Maze3d.Wall) {
			Direct.add(Direction.FORWARD);
		}
		// Check left neighbor
		if (pos.y - 2 >= 0 && m[pos.x][pos.y-2][pos.z] == Maze3d.Wall) {
			Direct.add(Direction.LEFT);
		}
		// Check right neighbor
		if (pos.y + 2 <maze3d.getColumn() && m[pos.x][pos.y+2][pos.z] == Maze3d.Wall) {
			Direct.add(Direction.RIGHT);
		}
		// Check down neighbor
		if (pos.z-2 >=0 && m[pos.x][pos.y][pos.z-2] == Maze3d.Wall) {
			Direct.add(Direction.DOWN);
		}
				
		// Check up neighbor
		if (pos.z + 2 < maze3d.getFloor() && m[pos.x][pos.y][pos.z+2] == Maze3d.Wall) {
			Direct.add(Direction.UP);
		}
		
		return Direct;
	}
	
	void ChooseGoalPos(Position pos)
	{

		
		if((pos.getX()>maze3d.getStartPosition().getX()+1)||(pos.getX()>maze3d.getStartPosition().getX()-2)){
			if((pos.getZ()>(maze3d.getStartPosition().getZ())+1)||(pos.getZ()<(maze3d.getStartPosition().getZ())-1)){
				if((pos.getY()>(maze3d.getStartPosition().getY())+1)||(pos.getY()<(maze3d.getStartPosition().getY())-1)){
					maze3d.setGoalPosition(pos);
				}
			}
		}


		
			
}
	

}