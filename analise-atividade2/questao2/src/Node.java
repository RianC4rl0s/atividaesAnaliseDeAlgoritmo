public class Node {
    private int x, y;
    private boolean hasPair;
    public Node(){
        x = 0; y =0;
        hasPair = false;
    }
    public Node(int x, int y){
        this.x = x; this.y =y;
        hasPair = false;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }  
    public void hasPair(){
        hasPair = !hasPair;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean getHaspait(){
        return hasPair;
    }

}
