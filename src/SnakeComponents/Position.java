package SnakeComponents;

public class Position implements Comparable<Position> {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Position pos) {
        int rtn = 0;
        if (x == pos.getX() && y == pos.getY()){
            return 0;
        }
        if (x < pos.getX()) rtn = -1;
        if (x > pos.getX()) rtn = +1;

        if(rtn == 0) {
            if (y < pos.getY()) rtn = -1;
            if (y > pos.getY()) rtn = +1;
        }

        return rtn;
    }
}
