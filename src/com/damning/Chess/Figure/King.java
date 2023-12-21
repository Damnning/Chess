package com.damning.Chess.Figure;

import com.damning.Chess.ChessBoard.Cell;
import com.damning.Chess.Enums.Color;

public class King extends Figure {
    public King(Cell position, Color color) {
        super(position, color);
    }

    @Override
    public void calculatePossibleMoves() {
        if(position.getUp() != null && position.getUp().getFigure() == null) possibleMoves.add(position.getUp());
        if(position.getDown() != null && position.getDown().getFigure() == null) possibleMoves.add(position.getDown());
        if(position.getLeft() != null && position.getLeft().getFigure() == null) possibleMoves.add(position.getLeft());
        if(position.getRight() != null && position.getRight().getFigure() == null) possibleMoves.add(position.getRight());
    }

    @Override
    public void calculatePossibleAttacks() {
        if(position.getUp() != null && position.getUp().getFigure() != null) possibleAttacks.add(position.getUp());
        if(position.getDown() != null && position.getDown().getFigure() != null) possibleAttacks.add(position.getDown());
        if(position.getLeft() != null && position.getLeft().getFigure() != null) possibleAttacks.add(position.getLeft());
        if(position.getRight() != null && position.getRight().getFigure() != null) possibleAttacks.add(position.getRight());
    }

}
