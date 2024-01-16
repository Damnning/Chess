package com.damning.chess.main;

import application.viewer.ChessViewer;
import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.chessboard.ChessBoardUtils;
import com.damning.chess.figure.Figure;

public class Main {
    public static void main(String[] args) {
        ChessViewer.main(args);
        /*ChessBoard test = ChessBoardUtils.readBoardFromFile("src/main/resources/java/com/damning/chess/chessboard/russian.txt");
        test.recalculateMoves();
        for (Figure figure : test.getFigures()) {
            System.out.println(figure);
            for (Cell cell: figure.getPossibleMoves()) {
                System.out.println(cell);
            }
        }*/
    }
}
