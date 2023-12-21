package com.damning.Chess.ChessBoard;

import com.damning.Chess.Figure.Figure;

public class Cell {
    int x;
    int y;
    private Figure figure;
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
