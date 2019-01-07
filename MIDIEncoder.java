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
    grid = new Tile[12][length];
    currentx = 0;
    currenty = 0;
    complete = false;
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
