package com.damning.chess.chessboard;

import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;
import com.damning.chess.figure.figures.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ChessBoardUtils implements BoardTokens {
    private static String[][] readBoardArrayFromFile(String path, List<Direction> pawnDirections) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(path)))) {
            int x = 0;
            int y = 0;
            StringBuilder sb = new StringBuilder();
            String p = scanner.nextLine();
            while (!p.equals(SEPARATOR)) {
                switch (p.split(SPACE)[1]) {
                    case UP -> pawnDirections.add(Direction.UP);
                    case DOWN -> pawnDirections.add(Direction.DOWN);
                    case LEFT -> pawnDirections.add(Direction.LEFT);
                    case RIGHT -> pawnDirections.add(Direction.RIGHT);
                }
                p = scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                x = Math.max(x, line.split(SPACE).length);
                y++;
                sb.append(line);
                sb.append("\n");
            }
            scanner.close();
            String[][] board = new String[y][x];
            String[] lines = sb.toString().split("\n");
            for (int i = 0; i < y; i++) {
                String[] line = lines[i].split(SPACE);
                System.arraycopy(line, 0, board[i], 0, x);
            }
            return board;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ChessBoard readBoardFromFile(String path) {
        List<Direction> pawnDirections = new ArrayList<>();
        List<Figure> figures = new ArrayList<>();
        String[][] board = readBoardArrayFromFile(path, pawnDirections);
        Cell[][] cells = new Cell[board.length][board[0].length];
        Cell head = null;
        ChessBoard chessBoard = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cells[i][j] = parseToken(board[i][j], i, j, pawnDirections);
                if(head == null) {
                    head = cells[i][j];
                    chessBoard = new ChessBoard(cells[i][j]);
                }

            }
        }
        assert chessBoard != null;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                addNeighbors(cells, i, j, board);
                if (cells[i][j] != null && cells[i][j].getFigure() != null) {
                    chessBoard.addFigure(cells[i][j].getFigure());
                    cells[i][j].getFigure().setBoard(chessBoard);
                }
            }
        }
        chessBoard.setSizeX(cells[0].length);
        chessBoard.setSizeY(cells.length);
        chessBoard.setPlayersCount((byte) pawnDirections.size());
        return chessBoard;
    }

    private static Cell parseToken(String token, int y, int x, List<Direction> pawnDirections) {
        Cell cell = null;
        String[] tokens = token.split("");
        if (tokens.length == 1) {
            if (tokens[0].equals(BLOCKED)) {
                return null;
            } else {
                return new Cell(x, y);
            }
        } else if (tokens.length > 1) {
            cell = new Cell(x, y);
            parseFigure(Byte.parseByte(tokens[0]), tokens[1], cell, pawnDirections.get(Byte.parseByte(tokens[0])));
        }
        return cell;
    }

    private static void addNeighbors(Cell[][] cells, int y, int x, String[][] tokens) {
        if(cells[y][x] == null) return;
        if (x > 0) {
            if (!tokens[y][x].endsWith(LEFT) && !tokens[y][x - 1].endsWith(RIGHT))
                cells[y][x].setLeft(cells[y][x - 1]);
        }
        if (x < cells[0].length - 1) {
            if (!tokens[y][x].endsWith(RIGHT) && !tokens[y][x + 1].endsWith(LEFT))
                cells[y][x].setRight(cells[y][x + 1]);
        }
        if (y > 0) {
            if (!tokens[y][x].endsWith(UP) && !tokens[y - 1][x].endsWith(DOWN))
                cells[y][x].setUp(cells[y - 1][x]);
        }
        if (y < cells.length - 1) {
            if (!tokens[y][x].endsWith(DOWN) && !tokens[y + 1][x].endsWith(UP))
                cells[y][x].setDown(cells[y + 1][x]);
        }
    }

    private static void parseFigure(byte player, String token, Cell cell, Direction pawnDirection) {
        switch (token) {
            case KING:
                cell.setFigure(new King(cell, player));
                break;
            case QUEEN:
                cell.setFigure(new Queen(cell, player));
                break;
            case BISHOP:
                cell.setFigure(new Bishop(cell, player));
                break;
            case HORSE:
                cell.setFigure(new Horse(cell, player));
                break;
            case TOWER:
                cell.setFigure(new Tower(cell, player));
                break;
            case PAWN:
                cell.setFigure(new Pawn(cell, player, pawnDirection));
                break;
        }
    }


    public static List<Cell> getLine(Cell from, Direction direction) {
        List<Cell> cells = new ArrayList<>();
        Cell current = from.get(direction);
        while (current != null) {
            if (current.getFigure() != null) {
                cells.add(current);
                break;
            }
            cells.add(current);
            current = current.get(direction);
        }
        return cells;
    }

    public static List<Cell> getKnightCells(Cell from, Direction direction) {
        List<Cell> cells = new ArrayList<>();
        Cell current = from.get(direction);
        if (current != null) {
            current = current.get(direction);
            if (current != null) {
                assert direction.getHalf() != null;
                Cell aux = current.get(direction.getHalf());
                if (aux != null) {
                    cells.add(aux);
                }
                assert direction.getCounterClockwise() != null;
                aux = current.get(direction.getCounterClockwise());
                if (aux != null) {
                    cells.add(aux);
                }
            }
        }
        return cells;

    }
}
