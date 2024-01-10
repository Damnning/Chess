package com.damning.chess.figure;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Color;
import com.damning.chess.enums.Direction;

import java.util.function.Consumer;

public class Pawn extends Figure {
    private final Direction direction;
    public Pawn(Cell position, Color color, Direction direction) {
        super(position, color);
        this.direction = direction;
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        switch (direction) {
            case UP:
                consumer.accept(position.getUp());
                if (movesCount == 0 && position.getUp() != null) consumer.accept(position.getUp().getUp());
                break;
            case DOWN:
                consumer.accept(position.getDown());
                if (movesCount == 0 && position.getDown() != null) consumer.accept(position.getDown().getDown());
                break;
            case LEFT:
                consumer.accept(position.getLeft());
                if(movesCount == 0 && position.getLeft() != null) consumer.accept(position.getLeft().getLeft());
                break;
            case RIGHT:
                consumer.accept(position.getRight());
                if(movesCount == 0 && position.getRight() != null) consumer.accept(position.getRight().getRight());
                break;
        }
    }
}
