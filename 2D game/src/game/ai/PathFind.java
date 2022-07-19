package game.ai;

import game.data.GameControl;
import game.tile.TileMapObj;
import game.tile.blocks.HoleBlock;
import game.tile.blocks.ObjBlock;


import java.util.ArrayList;

public class PathFind {
    public static Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    private ArrayList<Node> pathList = new ArrayList<>();
    private Node startNode, goalNode, currentNode;
    boolean goalReached= false;
    int step =0;
    private int maxCol;
    private int maxRow;
    public PathFind(){
        maxCol = 50;
        maxRow = 50;
        instantiateNodes();
    }
    public void instantiateNodes(){
        node = new Node[maxCol][maxRow];
        int col=0;
        int row=0;
        while (col<maxCol && row < maxRow){
            node[col][row] = new Node(col,row);
            col++;
            if(col == maxCol){
                col=0;
                row ++;
            }
        }
    }

    public void resetNodes() {
        int col = 0;
        int row = 0;
        while (col < maxCol && row < maxRow) {
            node[col][row].open = false;
            node[col][row].checked = false;

            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }
        // Reset other settings
        openList.clear();
        pathList.clear();
        goalReached= false;
        step=0;
    }
    public void setNodes(int startCol, int startRow, int goalCol, int goalRow){
        resetNodes();
        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);
        //SET SOLID NODE

        int col=0;
        int row=0;
        while (col < maxCol && row < maxRow) {
            getCost(node[col][row]);
            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }

        
    }
    private void getCost(Node node){
        //GET G COST(the distance from the start node)
        int xDistance= Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance +yDistance;

        //GET H COST(the distance from the goal node)

        xDistance= Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance +yDistance;

        //GET F COST(The total cost)
        node.fCost = node.gCost+ node.hCost;

    }
    public boolean search(){
        while (goalReached == false && step <500){
            int col = currentNode.col;
            int row= currentNode.row;

            currentNode.checked = true;
            openList.remove(currentNode);

            //OPEN THE NODE NEAR CURRENT NODE
            if(row -1 >=0){
                openNode(node[col][row-1]);
            }
            if(col -1 >=0){
                openNode(node[col-1][row]);
            }
            if(row +1 < maxRow){
                openNode(node[col][row+1]);
            }
            if(col +1 < maxCol){
                openNode(node[col+1][row]);
            }
            //FIND THE BEST NODE
            int bestNodeIndex =0;
            int bestNodefCost = 999;

            for(int i=0; i<openList.size(); i++){
                //Check if this node's cost is better
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex=i;
                    bestNodefCost = openList.get(i).fCost;
                }
                //If F cost is equal, check the G cost
                else if(openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex=i;
                    }
                }
            }
            //If there is no node in the openList, end the loop
            if(openList.size() ==0) break;
            //After the loop, we get the best node which is our next step
            currentNode = openList.get(bestNodeIndex);
            if(currentNode == goalNode){
                goalReached = true;
                trackThePath();
            }
            step++;
        }
       return goalReached;
    }

    private void openNode(Node node){
        if(node.open == false && node.checked == false && node.solid == false){
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }
    private void trackThePath(){
        Node current = goalNode;
        while(current != startNode){
            pathList.add(0,current);
            current = current.parent;
        }
    }

    public int getMaxCol() {return maxCol;}
    public int getMaxRow() {return maxRow;}
    public ArrayList<Node> getPathList() {return pathList;}
    public Node getStartNode() {return startNode;}
    public Node getGoalNode() {return goalNode;}
    public Node getCurrentNode() {return currentNode;}

}
