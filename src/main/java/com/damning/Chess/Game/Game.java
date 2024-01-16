package com.damning.chess.game;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.figure.Figure;
import com.damning.chess.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Figure selectedFigure;
    ChessBoard board;
    byte turn;
    List<Player> players;
    Player currentPlayer;

    public Game(ChessBoard board) {
        this.board = board;
        players = new ArrayList<>();
        addPlayers(board.getPlayersCount());
        turn = 0;
        addPlayersFigures();
    }

    public void start() {
        currentPlayer = players.get(turn);
        board.recalculateMoves();
    }

    public Figure getSelectedFigure() {
        return selectedFigure;
    }

    public void selectFigure(Figure selectedFigure) {
        if (selectedFigure != null) {
            if (selectedFigure.getColor() == turn) {
                this.selectedFigure = selectedFigure;
            }
        }
    }

    public void deselectFigure() {
        selectedFigure = null;
    }

    public ChessBoard getBoard() {
        return board;
    }

    private void nextTurn() {
        if (turn == players.size() - 1)
            turn = 0;
        else
            turn++;
        currentPlayer = players.get(turn);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Cell getCell(int x, int y) {
        return board.getCell(x, y);
    }

    public boolean checkWin() {
        for (int i = 0; i < players.size(); i++) {
            int movesCount = 0;
            for (Figure figure : players.get(i).getFigures()) {
                movesCount += figure.getPossibleMoves().size();
            }
            if (movesCount == 0) {
                for (Figure figure : players.get(i).getFigures()) {
                    figure.getPosition().setFigure(null);
                    figure.setPosition(null);
                }
                players.remove(players.get(i));
                i--;
                removeEmptyFigures();
                board.recalculateMoves();
            }
        }
        return players.size() == 1;
    }

    private void removeEmptyFigures() {
        for (int i = 0; i < board.getFigures().size(); i++) {
            if (board.getFigures().get(i).getPosition() == null) {
                board.getFigures().remove(i);
                i--;
            }
        }
    }

    private void addPlayers(int playersCount) {
        for (byte i = 0; i < playersCount; i++)
            players.add(new Player(i));
    }

    private void addPlayersFigures() {
        for (Figure figure : board.getFigures()) {
            players.get(figure.getColor()).addFigure(figure);
            figure.setPlayer(players.get(figure.getColor()));
        }
    }

    public void move(Figure selectedFigure, Cell selectedCell) {
        selectedFigure.move(selectedCell);
        board.recalculateMoves();
        nextTurn();
    }

}
