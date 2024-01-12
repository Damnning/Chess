package com.damning.chess.figure.figures;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Color;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

import java.util.function.Consumer;

public class Pawn extends Figure {
    private final Direction direction;
    public Pawn(Cell position, Color color, Direction direction) {
        super(position, color);
        this.direction = direction;
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        consumer.accept(position.get(direction));
        if(movesCount == 0 && position.get(direction) != null) consumer.accept(position.get(direction).get(direction));
    }
}
