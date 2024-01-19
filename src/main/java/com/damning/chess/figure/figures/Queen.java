package com.damning.chess.figure.figures;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

import java.util.List;
import java.util.function.Consumer;

import static com.damning.chess.chessboard.ChessBoardUtils.getLine;

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
