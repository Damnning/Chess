package com.damning.chess.figure;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.enums.Color;
import com.damning.chess.enums.MoveStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class Figure {
    protected ChessBoard board;
    protected final Color color;
    protected Cell position;
    protected List<Cell> possibleMoves;

    protected List<Cell> possibleAttacks;
    protected List<Cell> potentialAttacks;
    protected int movesCount;


    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Figure(Cell position, Color color) {
        movesCount = 0;
        this.position = position;
        this.color = color;
    }

    public void calculatePotentialAttacks() {
        potentialAttacks = new ArrayList<>();
        calculateMoves(cell -> {
            if(cell.getFigure() != null && cell.getFigure().getColor() != color) {
                potentialAttacks.add(cell);
            }
        });
    }

    public void calculatePossibleMoves() {
        possibleMoves = new ArrayList<>();
        calculateMoves(this::addMove);
    }

    abstract public void calculateMoves(Consumer<Cell> consumer); // todo: think about transmitting board

    public MoveStatus move(Cell to) {
        if(possibleMoves.contains(to)) {
            switchCell(to);
            movesCount++;
            return MoveStatus.SUCCESS;
        }
        return MoveStatus.ILLEGAL;
    }

    protected void switchCell(Cell to) {
        to.setFigure(position.getFigure());
        position.setFigure(null);
        position = to;
    }

    protected void addMove(Cell to) {
        if (checkPosition(to, board)) {
            if (to.getFigure() == null) possibleMoves.add(to);
            else if (to.getFigure().getColor() != color) possibleAttacks.add(to);
        }
    }

    private boolean checkPosition(Cell to, ChessBoard board) {
        if (to != null) {
            Cell previousPosition = position;
            Figure toFigure = to.getFigure();
            Cell kingPosition = board.getKing(color).getPosition();
            switchCell(to);
            for (Figure figure : board.getFigures()) {
                figure.calculatePotentialAttacks();
                if (figure.potentialAttacks.contains(kingPosition)) {
                    switchCell(previousPosition);
                    to.setFigure(toFigure);
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public Color getColor() {
        return color;
    }
}