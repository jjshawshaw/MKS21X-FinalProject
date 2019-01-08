import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;

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
    System.out.println(toHex());
  }

  public static void main(String[] args){
    new MIDIEncoder(args[0], Integer.parseInt(args[1]));
  }

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

  private int[] getNotes(int col){
    int[] Notes = new int[13];
    for (int row = 0; row < 13; row++){
      Notes[row] = grid[row][col].getMode();
    }
    return Notes;
  }

  private String toHex(){
    //Header chunk of the MIDI file
    String output = "4D 54 68 64 00 00 00 06 00 01 00 01 00 80 4D 54 72 6B ";
    //length of the MIDI track
    int trackLen = 0;
    //Track information
    String output2 = "";
    for (int col = 0; col < length; col++){
      output2 += "80 18 ";
      trackLen += 4;
      for (int row = 0; row < 13; row++){
        if (grid[row][col].getMode() != 2){
          output2 += "91 " + grid[row][col].getVal() + " ";
          if (grid[row][col].getMode() == 0) output2 += "00 ";
          else output2 += "64 ";
          trackLen += 3;
        }
      }
    }
    //Track end chunk
    output2 += "00 FF 2F 00";
    trackLen += 4;
    //TrackLen is calculated and turned to hex
    String trackLenHex = Integer.toHexString(trackLen);
    int temp = trackLen;
    trackLen += trackLenHex.length();
    trackLenHex = Integer.toHexString(trackLen);
    while (temp + trackLenHex.length() != trackLen){
      int temp2 = trackLenHex.length();
      trackLenHex = Integer.toHexString(trackLen);
      trackLen += temp2 - trackLenHex.length();
    }
    trackLenHex = "00000000".substring(0, 8 - trackLenHex.length()) + trackLenHex + " ";
    String temp3 = "";
    //TrackLenHex is formatted to be consistent
    for (int i = 0; i < trackLenHex.length() - 2; i += 2){
      temp3 += trackLenHex.substring(i, i + 2).toUpperCase() + " ";
    }
    return output += temp3 + output2;
  }

}
