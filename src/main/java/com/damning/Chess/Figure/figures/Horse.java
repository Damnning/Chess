package com.damning.chess.figure.figures;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

import java.util.function.Consumer;
import static com.damning.chess.chessboard.ChessBoardUtils.getKnightCells;

public class Horse extends Figure {
    public Horse(Cell position, byte color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {
        for(Direction direction: Direction.getVerticals()){
            for (Cell cell: getKnightCells(position, direction)) {
                consumer.accept(cell);
            }
        }
    }
}
