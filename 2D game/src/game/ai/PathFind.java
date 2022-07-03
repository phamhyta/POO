package game.ai;

import game.GamePanel;
import game.data.GameControl;

import java.util.ArrayList;

public class PathFind {
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();
    Node startNode, goalNode, currentNode;
    boolean goalReached= false;
    int step =0;
    int maxCol = GameControl.tm.getWidth();
    int maxRow = GameControl.tm.getHeight();
    public PathFind(){

    }
    public void instantiateNodes(){
        node = new Node[maxCol][maxRow];
        int col=0;
        int row=0;
        while (col<maxCol && row < maxRow){
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;

            col++;
            if(col == maxCol){
                col=0;
                row ++;
            }
        }
    }
    public void resetNodes(){

    }
}
