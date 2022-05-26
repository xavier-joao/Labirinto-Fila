package br.pucpr;

public class Coord {
    private int x, y;

    private final static int UP = 0;
    private final static int RIGHT = 1;
    private final static int DOWN = 2;
    private final static int LEFT = 3;
    private final static int INVALID = -1;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord(Coord coord) {
        this.x = coord.x;
        this.y = coord.y;
    }

    public void move(int direction) {
        switch (direction) {
            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
        }
    }

    public void moveUp(){
        y--;
    }

    public void moveRight(){
        x++;
    }

    public void moveDown(){
        y++;
    }

    public void moveLeft(){
        x--;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public Coord copy() {
        return new Coord(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (x != coord.x) return false;
        return y == coord.y;
    }
}
