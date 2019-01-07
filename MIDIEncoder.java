public class MIDIEncoder{
  //grid of each beat
  private Tile[][] grid;
  //length of the file (how many beats)
  private int length;
  //reference string
  private String[] Hex;
  //x value of cursor
  private int currentx;
  //y value of cursor
  private int currenty;
  //whether the program is complete
  private boolean complete;
  //filename to write to
  private String filename;
  //which notes are on or off on a given beat
  private boolean[] NotesOn;

  public MIDIEncoder(String filename, int length){
    this.length = length;
    this.filename = filename;
    currentx = 0;
    currenty = 0;
    complete = false;
    NotesOn = new boolean[]{
    false, false, false, false, false, false,
    false, false, false, false, false, false, false};
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
    //Header chunk of the MIDI file
    String output = "4D 54 68 64 00 00 00 06 00 01 00 01 00 80 4D 54 72 6B 00 00 00";
    //length of the MIDI track
    String trackLength = "00";
    return output;
  }

}
