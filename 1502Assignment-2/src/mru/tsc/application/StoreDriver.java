package mru.tsc.application;
import mru.tsc.view.StoreMenu;

public class StoreDriver {
	public final static String FILE_PATH="res/toys.txt";

	public static void main(String[] args) 
	{
		//Calls the instance of StoreMenu to run the whole program
		StoreMenu toyStore = new StoreMenu(FILE_PATH);
		toyStore.run();
	}
}