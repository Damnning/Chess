package com.damning.chesst.figuret.figures;

import com.damning.chesst.chessboardt.Cell;
import com.damning.chesst.enumst.Direction;
import com.damning.chesst.figuret.Figure;

import java.util.List;
import java.util.function.Consumer;

import static com.damning.chesst.chessboardt.ChessBoardUtils.getLine;

public class Queen extends Figure {
    public Queen(Cell position, byte color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        for (Direction direction : Direction.values()) {
            List<Cell> line = getLine(position, direction);
            for (Cell cell : line) {
                consumer.accept(cell);
            }
        }
    }
}
