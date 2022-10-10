package tictactoe.bll;

public class Tile {
    private boolean isUsed = false;
    private boolean hasX = false;

    public boolean getIsUsed(){return isUsed;}
    public void setUsed(boolean isUsed){this.isUsed = isUsed;}

    public boolean getHasX(){return hasX;}
    public void setHasX(boolean hasX){this.hasX = hasX;}


}
