package com.damning.chess.figure.figures;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Color;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

import java.util.function.Consumer;

public class King extends Figure {
    public King(Cell position, Color color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        for (Direction direction : Direction.values()) {
            consumer.accept(position.get(direction));
        }
    }
}
