package com.damning.chess.main;

import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.chessboard.ChessBoardUtils;
import com.damning.chess.figure.Figure;

public class Main {
    public static void main(String[] args) {
        ChessBoard test = ChessBoardUtils.readBoardFromFile("src/main/resources/java/com/damning/chess/chessboard/classic.txt");
        test.recalculateMoves();
        for (Figure figure : test.getFigures()) {
            System.out.println(figure);
        }
    }
}
