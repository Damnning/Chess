package com.damning.chess.figure;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.player.Player;


import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;

public abstract class Figure {
    Player player;
    protected ChessBoard board;
    protected final byte color;
    protected Cell position;
    protected List<Cell> possibleMoves;
    protected List<Cell> possibleAttacks;
    protected List<Cell> potentialAttacks;
    protected int movesCount;

    public Figure(Cell position, byte color) {
        movesCount = 0;
        this.position = position;
        this.color = color;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public byte getColor() {
        return color;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public List<Cell> getPossibleMoves() {
        return possibleMoves;
    }

    public void calculatePossibleMoves() {
        possibleAttacks = new ArrayList<>();
        possibleMoves = new ArrayList<>();
        calculateMoves(this::addMove);
    }

    public String getName() {
        return this.getClass().getSimpleName().toLowerCase();
    }


    public void calculatePotentialAttacks() {
        potentialAttacks = new ArrayList<>();
        calculateMoves(cell -> {
            if (cell != null && cell.getFigure() != null && cell.getFigure().getColor() != color) {
                potentialAttacks.add(cell);
            }
        });
    }


    abstract public void calculateMoves(Consumer<Cell> consumer);

    public void move(Cell to) {
        if (possibleMoves.contains(to)) {
            switchCell(to);
            movesCount++;
        } else if (possibleAttacks.contains(to)) {
            board.getFigures().remove(to.getFigure());
            to.getFigure().getPlayer().getFigures().remove(to.getFigure());
            switchCell(to);
            movesCount++;
        }
    }

    protected void switchCell(Cell to) {
        to.setFigure(position.getFigure());
        position.setFigure(null);
        position = to;
    }

    protected void addMove(Cell to) {
        if (checkPosition(to, board)) {
            if (to.getFigure() == null) possibleMoves.add(to);
            else if (to.getFigure().getColor() != color) possibleAttacks.add(to);
        }
    }

    protected boolean checkPosition(Cell to, ChessBoard board) {
        if (to != null) {
            Cell previousPosition = position;
            Figure toFigure = to.getFigure();
            switchCell(to);
            Cell kingPosition = board.getKing(color).getPosition();
            for (Figure figure : board.getFigures()) {
                if (figure.getPosition() != null) {
                    figure.calculatePotentialAttacks();
                    //System.out.println(figure);
                    if (figure.potentialAttacks.contains(kingPosition)) {
                        switchCell(previousPosition);
                        to.setFigure(toFigure);
                        return false;
                    }
                }
            }
            switchCell(previousPosition);
            to.setFigure(toFigure);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + color;
    }


    public boolean canMoveTo(Cell selectedCell) {
        return possibleMoves.contains(selectedCell) || possibleAttacks.contains(selectedCell);
    }

    public List<Cell> getPossibleAttacks() {
        return possibleAttacks;
    }
}
