package algorithms.mazeGenerators;



public class Position {
	
	public int x; 
	public int y;
	public int z;
	

	public Position(Position P) {
		// TODO Auto-generated constructor stub
	}
	public Position(int x, int y,int z) {		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "{" + x + "," + y + ","  + z +"}";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Position p =(Position)obj;
		return x==p.x&& y==p.y&&z==p.z;
	}
}