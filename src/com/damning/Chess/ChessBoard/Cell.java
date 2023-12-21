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

    Figure getFigure() {
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
