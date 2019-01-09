//API : http://mabe02.github.io/lanterna/apidocs/2.1/
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


public class TerminalDemo {

	private static int currentx;
	//y value of cursor
	private static int currenty;

  public static void putString(int r, int c,Terminal t, String s){
    t.moveCursor(r,c);
    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
  }

  public static void putString(int r, int c,Terminal t,
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
  public static void main(String[] args) {

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);

    boolean running = true;
    int mode = 0;
    long lastTime =  System.currentTimeMillis();
    long currentTime = lastTime;
    long timer = 0;


    while(running){
      Key key = terminal.readInput();
      if (key != null)
      {

        //YOU CAN PUT DIFFERENT SETS OF BUTTONS FOR DIFFERENT MODES!!!

        //only for the game mode.
        if(mode == 0){
          if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running = false;
          }
					if (key.getKind() == Key.Kind.ArrowUp){
		        currenty++;
		      }
		      if (key.getKind() == Key.Kind.ArrowDown){
		        currenty--;
		      }
		      if (key.getKind() == Key.Kind.ArrowRight){
		        currentx++;
		      }
		      if (key.getKind() == Key.Kind.ArrowLeft){
		        currentx--;
		      }
        }

        //for all modes
        if (key.getCharacter() == ' ') {
          mode++;
          mode%=2;//2 modes
          terminal.clearScreen();
          lastTime = System.currentTimeMillis();
          currentTime = System.currentTimeMillis();
        }
      }

      terminal.applySGR(Terminal.SGR.ENTER_BOLD);
      putString(1,1,terminal, "This is mode "+mode,Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
      terminal.applySGR(Terminal.SGR.RESET_ALL);


      if(mode==0){
				putString(0,0,terminal, "AAAAAAAAAAAAAAAAAAAAAAAAAAWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW",Terminal.Color.RED,Terminal.Color.RED,Terminal.Color.RED);

				putString(1,5,terminal, "C",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,6,terminal, "B",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,7,terminal, "A#",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,8,terminal, "A",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,9,terminal, "G#",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,10,terminal, "G",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,11,terminal, "F#",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,12,terminal, "F",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,13,terminal, "E",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,14,terminal, "D#",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,15,terminal, "D",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,16,terminal, "C#",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);
				putString(1,17,terminal, "C",Terminal.Color.BLUE,Terminal.Color.WHITE,Terminal.Color.RED);

        putString(1,3,terminal, "currentx: "+currentx,Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);
        putString(15,3,terminal, "currenty: "+currenty,Terminal.Color.BLUE, Terminal.Color.WHITE,Terminal.Color.RED);

      }else{

        terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
        putString(1,3,terminal, "Not game, just a pause!",Terminal.Color.BLUE,Terminal.Color.RED,Terminal.Color.WHITE);
        terminal.applySGR(Terminal.SGR.RESET_ALL);

      }

    }


  }
}
