package com.damning.chess.figure;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.enums.Color;

import java.util.function.Consumer;

public class Queen extends Figure {
    public Queen(Cell position, Color color) {
        super(position, color);
    }

    @Override
    public void calculateMoves(Consumer<Cell> consumer) {

    }
}
