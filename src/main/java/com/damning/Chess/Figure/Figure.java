package com.damning.chess.figure;

import main.java.com.damning.Chess.ChessBoard.Cell;
import main.java.com.damning.Chess.Enums.Color;
import main.java.com.damning.Chess.Enums.MoveStatus;

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
    abstract public MoveStatus move(Cell to, List<Figure> figures, Figure king);
    protected void switchCell(Cell to) {
        to.setFigure(position.getFigure());
        position.setFigure(null);
        position = to;
    }
    protected void addMove(Cell to) {
        if(to != null){
            if(to.getFigure() == null) possibleMoves.add(to);
            else if(to.getFigure().getColor() != color) possibleAttacks.add(to);
        }
    }


    private Color getColor() {
        return color;
    }
}
