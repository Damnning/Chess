package com.damning.chess.chessboard;

import com.damning.chess.figure.Figure;
import com.damning.chess.figure.figures.King;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ChessBoard {
    int sizeX;
    int sizeY;
    Cell head;
    List<Figure> figures;
    byte playersCount;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }


    public List<Figure> getFigures() {
        return figures;
    }

    public byte getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(byte playersCount) {
        this.playersCount = playersCount;
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public Cell getHead() {
        return head;
    }

    public ChessBoard(Cell head) {
        this.head = head;
        figures = new ArrayList<>();
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
        for (Figure figure : figures) {
            figure.calculatePossibleMoves();
        }
    }

    public Cell getCell(int x, int y) {
        Queue<Cell> queue = new ArrayDeque<>();
        List<Cell> visited = new ArrayList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            visited.add(cell);
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
            if (cell.getLeft() != null && !visited.contains(cell.getLeft()) && !queue.contains(cell.getLeft())) {
                queue.add(cell.getLeft());
            }
            if (cell.getRight() != null && !visited.contains(cell.getRight()) && !queue.contains(cell.getRight())) {
                queue.add(cell.getRight());
            }
            if (cell.getUp() != null && !visited.contains(cell.getUp()) && !queue.contains(cell.getUp())) {
                queue.add(cell.getUp());
            }
            if (cell.getDown() != null && !visited.contains(cell.getDown()) && !queue.contains(cell.getDown())) {
                queue.add(cell.getDown());
            }
        }
        return null;

    }

}
