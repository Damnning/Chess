package com.damning.chess.chessboard;

import com.damning.chess.enums.Direction;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessBoardUtils {
    private void readBoardFromFile(String path) throws FileNotFoundException, IOException{

        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(path)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        }
    }
    public static List<Cell> getLine(Cell from, Direction direction) {
        List<Cell> cells = new ArrayList<>();
        Cell current = from.get(direction);
        while(current != null) {
            if(current.getFigure() != null) {
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
        if(current != null) {
            current = current.get(direction);
            if(current != null) {
                assert direction.getClockwise() != null;
                Cell aux = current.get(direction.getClockwise());
                if(aux != null) {
                    cells.add(aux);
                }
                assert direction.getCounterClockwise() != null;
                aux = current.get(direction.getCounterClockwise());
                if(aux != null) {
                    cells.add(aux);
                }
            }
        }
        return cells;

    }
}
