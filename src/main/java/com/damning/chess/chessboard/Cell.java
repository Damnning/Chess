package com.damning.chess.chessboard;


import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

/**
 * Cell of the board
 */
public class Cell {
    int x;
    int y;
    private Figure figure;
    private Cell up;
    private Cell down;
    private Cell left;
    private Cell right;

    public Cell get(Direction direction) {
        return switch (direction) {
            case UP -> up;
            case DOWN -> down;
            case LEFT -> left;
            case RIGHT -> right;
            case UP_RIGHT -> getUpRight();
            case UP_LEFT -> getUpLeft();
            case DOWN_RIGHT -> getDownRight();
            case DOWN_LEFT -> getDownLeft();
        };
    }

    public Cell(int x, int y) {
        this(x, y, null);

    }

    public Cell getUpLeft() {
        if (up != null && up.left != null) return up.left;
        if (left != null) return left.up;
        return null;
    }

    public Cell getUpRight() {
        if (up != null && up.right != null) return up.right;
        if (right != null) return right.up;
        return null;
    }

    public Cell getDownLeft() {
        if (down != null && down.left != null) return down.left;
        if (left != null) return left.down;
        return null;
    }

    public Cell getDownRight() {
        if (down != null && down.right != null) return down.right;
        if (right != null) return right.down;
        return null;
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

    public int getX() {
        return x;
    }

    public int getY() {
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

    @Override
    public String toString() {
        return x + " " + y + "; ";
    }

}
