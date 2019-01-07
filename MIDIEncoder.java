public class MIDIEncoder{
  private Tile[][] grid;
  private int length;
  private String[] Hex;
  private int currentx;
  private int currenty;
  private boolean complete;
  private String filename;

  public MIDIEncoder(String filename, int length){
    this.length = length;
    this.filename = filename;
    currentx = 0;
    currenty = 0;
    complete = false;
    //Hex codes for notes C4 to C3 in decending order
    Hex = new String[]{
    "48", "47", "46", "45", "44", "43", "42",
    "41", "40", "3F", "3E", "3D", "3C"};
    //Sets up grid
    grid = new Tile[13][length];
    for (int row = 0; row < 13; row++){
      for (int col = 0; col < length; col++){
        grid[row][col] = new Tile(row, col, Hex[col]);
      }
    }
  }

  public void main(String[][] args){}

  private boolean addNote(){
    return false;
  }

  private boolean removeNote(){
    return false;
  }

  private boolean changeCurrent(int newmode){
    return false;
  }

  public String ToString(){
    return "";
  }

  private boolean getFile(){
    return false;
  }

  private String toHex(){
    return "";
  }

}
