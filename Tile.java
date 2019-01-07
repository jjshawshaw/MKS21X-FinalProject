public class Tile{

	int x, y;
	String val;
	int mode;

public Tile(int x, int y, String value){
		this.x = x;
		this.y = y;
		val = value;
		mode = 0;
	}

	public int getMode(){
		return mode;
	}

	public String getVal(){
		return val;
	}

	public void setMode(int newmode){
		mode = newmode;
	}





}
