package com.damning.chesst.chessboardt;

/**
 * Token constants for board parsing
 */
public interface BoardTokens {
    String SEPARATOR = "---";
    // Cell tokens
    String SPACE = "_";
    String EMPTY = "*";
    String BLOCKED = "x";
    String UP = "u";
    String DOWN = "d";
    String LEFT = "l";
    String RIGHT = "r";

    // Figure tokens
    String KING = "k";
    String QUEEN = "q";
    String BISHOP = "b";
    String HORSE = "h";
    String TOWER = "t";
    String PAWN = "p";
}
