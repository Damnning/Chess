package com.damning.Chess.Figure;

import com.damning.Chess.ChessBoard.Cell;
import com.damning.Chess.Enums.Color;

import java.util.List;

public abstract class Figure {
    Color color;
    Cell position;
    List<Cell> possibleMoves;
    List<Cell> possibleAttacks;
    public Figure(Cell position, Color color) {
        this.position = position;
        this.color = color;
    }

    abstract public void calculatePossibleMoves();
    abstract public void calculatePossibleAttacks();
}
