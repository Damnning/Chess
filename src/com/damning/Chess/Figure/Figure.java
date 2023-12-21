package com.damning.Chess.Figure;

import com.damning.Chess.ChessBoard.Cell;

import java.util.List;

public abstract class Figure {
    Cell position;
    List<Cell> possibleMoves;
    List<Cell> possibleAttacks;

}
