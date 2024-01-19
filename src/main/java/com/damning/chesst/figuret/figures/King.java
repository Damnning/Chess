package com.damning.chesst.figuret.figures;

import com.damning.chesst.chessboardt.Cell;
import com.damning.chesst.enumst.Direction;
import com.damning.chesst.figuret.Figure;

import java.util.function.Consumer;

public class King extends Figure {
    public King(Cell position, byte color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        for (Direction direction : Direction.values()) {
            Cell cell = position.get(direction);
            if (cell != null)
                consumer.accept(cell);
        }
    }
}
