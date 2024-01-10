package com.damning.chess.chessboard;

import com.damning.chess.enums.Color;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;
import com.damning.chess.figure.King;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * @param path - path to .txt file with board description
     */
    public ChessBoard(String path) {

    }

    private void readBoardFromFile(String path) throws FileNotFoundException, IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {

        }
    }
    public Figure getKing(Color color) {
        for (Figure figure : figures) {
            if (figure instanceof King && figure.getColor() == color) {
                return figure;
            }
        }
        return null;
    }

    public void recalculateMoves() {
        for (Figure figure : figures) {
            figure.calculatePossibleMoves();
        }
    }
    //todo: continue
    public List<Cell> getLine(Cell from, Direction direction) {
        List<Cell> cells = new ArrayList<>();
        Cell current = from;
        while (current != null) {
            cells.add(current);
            //current = current.get(direction);
        }
        return cells;
    }
}
