package game.ai;

public class Node {
    Node parent;
    int col;
    int row;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;
    public Node(int col, int row){
        this.col=col;
        this.row = row;
    }

    public int getCol() {return col;}
    public int getRow() {return row;}
}
