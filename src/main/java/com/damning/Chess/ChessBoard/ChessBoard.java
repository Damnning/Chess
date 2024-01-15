package com.damning.chess.chessboard;

import com.damning.chess.figure.Figure;
import com.damning.chess.figure.figures.King;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    Cell head;
    List<Figure> figures;

    public List<Figure> getFigures() {
        return figures;
    }

    public boolean addFigure(Figure figure) {
        if (figure.getPosition() != null) {
            figures.add(figure);
            return true;
        }
        return false;
    }

    public Cell getHead() {
        return head;
    }

    /**
     * @param head - head cell of the board
     */
    public ChessBoard(Cell head) {
        this.head = head;
        figures = new ArrayList<>();
    }
    public ChessBoard(Cell head, List<Figure> figures) {
        this.head = head;
        this.figures = figures;

    }


    public Figure getKing(byte color) {
        for (Figure figure : figures) {
            if (figure instanceof King && figure.getColor() == color) {
                return figure;
            }
        }
        return null;
    }

    public void recalculateMoves() {
        int count = 0;
        for (Figure figure : figures) {
            System.out.println(count++ + " " + figure);
            figure.calculatePossibleMoves();
        }
    }

}
