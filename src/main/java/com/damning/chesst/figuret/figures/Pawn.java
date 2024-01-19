package com.damning.chesst.figuret.figures;

import com.damning.chesst.chessboardt.Cell;
import com.damning.chesst.enumst.Direction;
import com.damning.chesst.figuret.Figure;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Pawn extends Figure {
    private final Direction direction;

    public Pawn(Cell position, byte color, Direction direction) {
        super(position, color);
        this.direction = direction;
    }
    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        consumer.accept(position.get(direction));
        if (movesCount == 0 && position.get(direction) != null) consumer.accept(position.get(direction).get(direction));
    }

    private void calculateAttacks() {
        calculatePotentialAttacks();
        for (Cell cell : potentialAttacks) {
            if (checkPosition(cell, board)) possibleAttacks.add(cell);
        }
    }

    @Override
    public void calculatePotentialAttacks() {
        potentialAttacks = new ArrayList<>();
        Cell cell = position.get(direction.getClockwiseHalf());
        if (cell != null && cell.getFigure() != null && cell.getFigure().getColor() != color) {
            potentialAttacks.add(cell);
        }
        cell = position.get(direction.getCounterClockwiseHalf());
        if (cell != null && cell.getFigure() != null && cell.getFigure().getColor() != color) {
            potentialAttacks.add(cell);
        }
    }

    @Override
    public void calculatePossibleMoves() {
        possibleAttacks = new ArrayList<>();
        possibleMoves = new ArrayList<>();
        calculateMoves(this::addMove);
        calculateAttacks();
    }

    @Override
    protected void addMove(Cell to) {
        if (checkPosition(to, board)) {
            if (to.getFigure() == null) possibleMoves.add(to);
        }
    }
}
