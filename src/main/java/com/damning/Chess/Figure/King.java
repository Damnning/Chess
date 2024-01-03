package com.damning.chess.figure;

import main.java.com.damning.Chess.ChessBoard.Cell;
import main.java.com.damning.Chess.Enums.Color;
import main.java.com.damning.Chess.Enums.MoveStatus;

import java.util.List;

public class King extends Figure {
    public King(Cell position, Color color) {
        super(position, color);
    }

    @Override
    public void calculatePossibleMoves() {
        addMove(position.getUp());
        addMove(position.getUpRight());
        addMove(position.getRight());
        addMove(position.getDownRight());
        addMove(position.getDown());
        addMove(position.getDownLeft());
        addMove(position.getLeft());
        addMove(position.getUpLeft());
    }

    @Override
    public MoveStatus move(Cell to, List<Figure> figures, Figure king) {
        Cell previousPosition = position;
        List<Figure> figuresCopy = List.copyOf(figures);
        if (possibleMoves.contains(to)) {
            switchCell(to);
            for (Figure figure : figuresCopy) {
                figure.calculatePossibleMoves();
                if (figure.possibleAttacks.contains(king.position)) {
                    switchCell(previousPosition);
                    return MoveStatus.ENDANGERED_KING;
                }
            }
            figures = figuresCopy;
            return MoveStatus.SUCCESS;
        }
        return MoveStatus.ILLEGAL;
    }

}
