package com.damning.chess.chessboard;

public interface BoardTokens {
    final String SEPARATOR = "---";
    // Cell tokens
    final String SPACE = "_";
    final String EMPTY = "*";
    final String BLOCKED = "x";
    final String UP = "u";
    final String DOWN = "d";
    final String LEFT = "l";
    final String RIGHT = "r";

    // Figure tokens
    final String KING = "k";
    final String QUEEN = "q";
    final String BISHOP = "b";
    final String HORSE = "h";
    final String TOWER = "t";
    final String PAWN = "p";
}
