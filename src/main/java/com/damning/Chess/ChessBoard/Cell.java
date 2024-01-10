package com.damning.chess.chessboard;


import com.damning.chess.figure.Figure;

public class Cell {
    int x;
    int y;
    private Figure figure;
    //todo: write method for getting neighbour cell with Direction enum
    private Cell up;
    private Cell down;
    private Cell left;
    private Cell right;

    public Cell(int x, int y) {
        this(x, y, null);

    }
    public Cell getUp() {
        return up;
    }
    public Cell getDown() {
        return down;
    }
    public Cell getLeft() {
        return left;
    }
    public Cell getRight() {
        return right;
    }
    public Cell getUpLeft() {
        if(up != null && up.left != null) return up.left;
        if(left != null) return left.up;
        return null;
    }
    public Cell getUpRight() {
        if(up != null && up.right != null) return up.right;
        if(right != null) return right.up;
        return null;
    }
    public Cell getDownLeft() {
        if(down != null && down.left != null) return down.left;
        if(left != null) return left.down;
        return null;
    }
    public Cell getDownRight() {
        if(down != null && down.right != null) return down.right;
        if(right != null) return right.down;
        return null;
    }


    public void setUp(Cell up) {
        this.up = up;
    }
    public void setDown(Cell down) {
        this.down = down;
    }
    public void setLeft(Cell left) {
        this.left = left;
    }
    public void setRight(Cell right) {
        this.right = right;
    }

    public Cell(int x, int y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cell other)) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }

}