package MVC.model;

/**
 * 
 * @author בר
 *
 */
public interface Model {
	/**
	 * 
	 * @param path
	 */
	void Dir(String path);

	/**
	 * 
	 * @param name
	 * @param row
	 * @param column
	 * @param floor
	 */
	void Generate_3d_maze(String name, int row, int column, int floor);

	/**
	 * 
	 * @param name
	 */
	void Display(String name);

	/**
	 * 
	 * @param index_x
	 * @param name
	 */
	void Display_cross_section_by_x(int index_x, String name);

	/**
	 * 
	 * @param index_y
	 * @param name
	 */
	void Display_cross_section_by_y(int index_x, String name);

	/**
	 * 
	 * @param index_z
	 * @param name
	 */
	void Display_cross_section_by_z(int index_x, String name);

	/**
	 * 
	 * @param name
	 * @param filename
	 */
	void Save_maze(String name, String filename);

	/**
	 * 
	 * @param filename
	 * @param name
	 */
	void Load_maze(String filename, String name);

	/**
	 * 
	 * @param name
	 */
	void Maze_size(String name);

	/**
	 * 
	 * @param name
	 */
	void File_size(String name);

	/**
	 * 
	 * @param name
	 * @param Algo
	 */
	void Slove(String name, String Algo);

	/**
	 * 
	 * @param name
	 */
	void Display_solution(String name);

	void Error_massage(String name);

}
