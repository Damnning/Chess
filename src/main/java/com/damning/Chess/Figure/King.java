package com.damning.chess.figure;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Color;
import java.util.function.Consumer;

public class King extends Figure {
    public King(Cell position, Color color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        consumer.accept(position.getUp());
        consumer.accept(position.getUpRight());
        consumer.accept(position.getRight());
        consumer.accept(position.getDownRight());
        consumer.accept(position.getDown());
        consumer.accept(position.getDownLeft());
        consumer.accept(position.getLeft());
        consumer.accept(position.getUpLeft());
    }
}
