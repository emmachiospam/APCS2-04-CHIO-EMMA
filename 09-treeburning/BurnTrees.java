import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;


  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();//set the left column on fire.
  }

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[0].length; j++) {
        if (map[i][j] == FIRE) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean inRange(int r, int c) {
    if(r >= map.length || r < 0) {
      return false;
    }
    if(c >= map[0].length || c < 0) {
      return false;
    }
    return true;
  }
  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    int[][] temp = new int[map.length][map[0].length];
    for(int k = 0; k < map.length; k++) {
      temp[k] = map[k].clone();
    }
    for(int i = 0; i < temp.length; i++) {
      for(int j = 0; j < temp[0].length; j++) {
        if(map[i][j] == FIRE) {
          if(inRange(i + 1, j) && map[i + 1][j] == TREE) {
            temp[i + 1][j] = FIRE;
          }
          if(inRange(i - 1, j) && map[i - 1][j] == TREE) {
            temp[i - 1][j] = FIRE;
          }
          if(inRange(i , j + 1) && map[i][j + 1] == TREE) {
            temp[i][j + 1] = FIRE;
          }
          temp[i][j] = ASH;
        }
      }
    }
    map = temp;
    ticks++;
    //YOU MUST IMPLEMENT THIS
  }

  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
      }
    }
  }





  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .7;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


    System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
