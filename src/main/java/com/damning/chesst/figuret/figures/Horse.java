package com.damning.chesst.figuret.figures;

import com.damning.chesst.chessboardt.Cell;
import com.damning.chesst.enumst.Direction;
import com.damning.chesst.figuret.Figure;

import java.util.function.Consumer;

import static com.damning.chesst.chessboardt.ChessBoardUtils.getKnightCells;

public class Horse extends Figure {
    public Horse(Cell position, byte color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        for (Direction direction : Direction.getVerticals()) {
            for (Cell cell : getKnightCells(position, direction)) {
                consumer.accept(cell);
            }
        }
    }
}
