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
  private static Tile[][] grid;
  //length of the file (how many beats)
  private int length;
  //x value of cursor
  private int currentx;
  //y value of cursor
  private int currenty;
  //whether the program is complete
  private boolean complete;
  //filename to write to
  private String filename;

  private static boolean note;

  public MIDIEncoder(String filename, int length){
    this.length = length;
    this.filename = filename;
    currentx = 5;
    currenty = 5;
    complete = false;
    //Hex codes for notes C4 to C3 in decending order
    String[] Hex = new String[]{
    "48", "47", "46", "45", "44", "43", "42",
    "41", "40", "3F", "3E", "3D", "3C"};
    //Sets up grid
    grid = new Tile[13][length];
    for (int row = 0; row < 13; row++){
      for (int col = 0; col < length; col++){
        grid[row][col] = new Tile(row, col, Hex[row]);
      }
    }
    //will run lanterna functions to get user input and modify the grid
    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();
    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);
    boolean hasLoaded = false;
    int mode = 0;
    while(!(complete)){
      Key key = terminal.readInput();
      if (key != null)
      {

              if (key.getKind() == Key.Kind.Escape) {
                      //terminal.setCursorVisible(false);

                      terminal.exitPrivateMode();
                      System.out.println(toHex());
                      complete = true;
              }
              if (key.getKind() == Key.Kind.ArrowUp){
                      if (currenty > 5)  currenty--;
                      terminal.clearScreen();
                      hasLoaded = false;
              }
              if (key.getKind() == Key.Kind.ArrowDown){
                      if (currenty < 17) currenty++;
                      terminal.clearScreen();
                      hasLoaded = false;
              }
              if (key.getKind() == Key.Kind.ArrowRight){
                      if (currentx < (length +4)) currentx++;
                      terminal.clearScreen();
                      hasLoaded = false;
              }
              if (key.getKind() == Key.Kind.ArrowLeft){
                      if (currentx > 5)currentx--;
                      terminal.clearScreen();
                      hasLoaded = false;
              }

              if (key.getCharacter() == 'a'){
			          addNote(1);
                int a = currentx;
                int b = currenty;
                //putString(a,b,terminal, "  ",Terminal.Color.GREEN,Terminal.Color.GREEN,Terminal.Color.RED);
			        }

              if (key.getCharacter() == 'e'){
                removeNote();
                int a = currentx;
                int b = currenty;
                //putString(a,b,terminal, "  ",Terminal.Color.GREEN,Terminal.Color.GREEN,Terminal.Color.RED);
              }

              if(mode == 0 && hasLoaded){
                      if(key.getKind() == Key.Kind.Backspace) {
                              mode = 1;
                              hasLoaded = false;
                                terminal.clearScreen();
                      }
              }
              if(mode == 1 && hasLoaded) {
                      if(key.getKind() == Key.Kind.Backspace) {
                              mode = 0;
                              hasLoaded = false;
                                terminal.clearScreen();
                      }

              }
      }



      if(mode==0){
              if(!hasLoaded) {
				putString(0,0,terminal, "AAAAAAAAAAAAAAAAAAAAAAAAAAWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW",Terminal.Color.RED,Terminal.Color.RED,Terminal.Color.RED);

				putString(0,5,terminal, "C   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,6,terminal, "B   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,7,terminal, "A#",Terminal.Color.WHITE,Terminal.Color.BLACK,Terminal.Color.RED);
        putString(2,7,terminal, "  ",Terminal.Color.WHITE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,8,terminal, "A   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,9,terminal, "G#",Terminal.Color.WHITE,Terminal.Color.BLACK,Terminal.Color.RED);
        putString(2,9,terminal, "  ",Terminal.Color.WHITE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,10,terminal, "G   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,11,terminal, "F#",Terminal.Color.WHITE,Terminal.Color.BLACK,Terminal.Color.RED);
        putString(2,11,terminal, "  ",Terminal.Color.WHITE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,12,terminal, "F   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,13,terminal, "E   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,14,terminal, "D#",Terminal.Color.WHITE,Terminal.Color.BLACK,Terminal.Color.RED);
        putString(2,14,terminal, "  ",Terminal.Color.WHITE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,15,terminal, "D   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,16,terminal, "C#",Terminal.Color.WHITE,Terminal.Color.BLACK,Terminal.Color.RED);
        putString(2,16,terminal, "  ",Terminal.Color.WHITE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(0,17,terminal, "C   ",Terminal.Color.BLACK,Terminal.Color.WHITE,Terminal.Color.RED);
        putString(1,3,terminal, "currentx: "+ currentx,Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);
        putString(15,3,terminal, "currenty: "+ currenty,Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);
				putString(30,3,terminal, "note: "+ note,Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);
        putString(45,3,terminal, "mode: "+ currentTile().getMode(),Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);
        putString(currentx,currenty,terminal,"^",Terminal.Color.DEFAULT, Terminal.Color.DEFAULT, Terminal.Color.GREEN);
              for (int row = 0; row < 13; row++){
                for (int col = 0; col < (length); col++){
                  if (grid[row][col].getMode() == 1) putString(col + 5, row + 5,terminal, " ",Terminal.Color.GREEN,Terminal.Color.GREEN,Terminal.Color.RED);
                }
              }
            }




				hasLoaded = true;
              }

      }

  }

  public static void main(String[] args){

    MIDIEncoder M = new MIDIEncoder(args[0], Integer.parseInt(args[1]));





  }

  public void putString(int r, int c,Terminal t,
        String s, Terminal.Color text, Terminal.Color forg, Terminal.Color back ){
    t.moveCursor(r,c);
    t.applyBackgroundColor(forg);
    t.applyForegroundColor(text);

    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
    t.applyBackgroundColor(Terminal.Color.DEFAULT);
    t.applyForegroundColor(Terminal.Color.DEFAULT);
  }

  private boolean addNote(int mode){
    if ((mode < 2) && (mode >= 0)){
      currentTile().setMode(mode);
      return true;
    }else{
      return false;
    }

  }

  private Tile currentTile(){
    return grid[currenty-5][currentx-5];
  }

  private boolean removeNote(){
    if(currentTile().getMode() != 0){
      currentTile().setMode(0);
      return true;
    }else{
      return false;
    }
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
      String output = "4D 54 68 64 00 00 00 06 00 01 00 01 00 E0 4D 54 72 6B ";
      //length of the MIDI track
      int trackLen = 0;
      //Track information
      String output2 = "";
      for (int col = 0; col < length; col++){
        if (col > 0) {
          output2 += "80 48 ";
          trackLen += 2;
        }
        else {
          output2 += "80 00 ";
          trackLen += 2;
        }
        for (int row = 0; row < 13; row++){
          if (row > 0) {
            output2 += "80 00 ";
            trackLen += 2;
          }
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
      trackLenHex = "00000000".substring(0, 8 - trackLenHex.length()) + trackLenHex + " ";
      String temp3 = "";
      //TrackLenHex is formatted to be consistent
      for (int i = 0; i < trackLenHex.length() - 2; i += 2){
        temp3 += trackLenHex.substring(i, i + 2).toUpperCase() + " ";
      }
      return output += temp3 + output2;
    }


}
