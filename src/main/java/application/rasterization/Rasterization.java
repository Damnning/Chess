package application.rasterization;

import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoard;
import com.damning.chess.enums.Direction;
import com.damning.chess.figure.Figure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.*;

/**
 * Rasterization of a chess board
 */
public class Rasterization {
    final static int WIDTH = 2;
    final static Color BLACK = Color.TAN;
    final static Color WHITE = Color.WHEAT;

    public static void drawBoard(GraphicsContext graphicsContext, ChessBoard chessBoard) {
        graphicsContext.clearRect(0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().getHeight());
        double canvasWidth = graphicsContext.getCanvas().getWidth();
        double canvasHeight = graphicsContext.getCanvas().getHeight();
        double cellWidth = canvasWidth / chessBoard.getSizeX();
        double cellHeight = canvasHeight / chessBoard.getSizeY();
        Queue<Cell> queue = new ArrayDeque<>();
        List<Cell> visited = new ArrayList<>();
        queue.add(chessBoard.getHead());
        Cell current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (Direction direction : Direction.getVerticals()) {
                Cell aux = current.get(direction);
                if (aux != null && !visited.contains(aux) && !queue.contains(aux)) {
                    queue.add(aux);
                }
            }
            drawCell(graphicsContext, current, cellWidth, cellHeight);
            visited.add(current);
        }
    }

    private static void drawCell(GraphicsContext graphicsContext, Cell cell, double cellWidth, double cellHeight) {
        int x = (int) (cell.getX() * cellWidth);
        int y = (int) (cell.getY() * cellHeight);
        if ((cell.getX() + cell.getY()) % 2 == 0) {
            graphicsContext.setFill(WHITE);
        } else {
            graphicsContext.setFill(BLACK);
        }
        graphicsContext.fillRect(x, y, cellWidth, cellHeight);
        for (Direction direction : Direction.getVerticals()) {
            Cell aux = cell.get(direction);
            if (aux == null) {
                drawBorder(graphicsContext, cell, cellWidth, cellHeight, Color.BLACK, direction);
            }
        }
        if (cell.getFigure() != null) {
            drawFigure(graphicsContext, cell.getFigure(), cellWidth, cellHeight);
        }
    }

    private static void drawFigure(GraphicsContext graphicsContext, Figure figure, double cellWidth, double cellHeight) {
        double x = figure.getPosition().getX() * cellWidth;
        double y = figure.getPosition().getY() * cellHeight;
        Image image = new Image(String.valueOf(Objects.requireNonNull(Rasterization.class.getResource(figure.getColor() + "/" + figure.getName() + ".png"))));
        graphicsContext.drawImage(image, x, y, cellWidth, cellHeight);
    }

    public static void drawPossibleMoves(GraphicsContext graphicsContext, ChessBoard chessBoard, Figure figure) {
        double canvasWidth = graphicsContext.getCanvas().getWidth();
        double canvasHeight = graphicsContext.getCanvas().getHeight();
        double cellWidth = canvasWidth / chessBoard.getSizeX();
        double cellHeight = canvasHeight / chessBoard.getSizeY();
        drawSelectedCell(graphicsContext, figure.getPosition(), cellWidth, cellHeight, Color.PURPLE);
        for (Cell cell : figure.getPossibleMoves()) {
            drawSelectedCell(graphicsContext, cell, cellWidth, cellHeight, Color.BLUE);
        }
        for (Cell cell : figure.getPossibleAttacks()) {
            drawSelectedCell(graphicsContext, cell, cellWidth, cellHeight, Color.RED);
        }
    }

    private static void drawSelectedCell(GraphicsContext graphicsContext, Cell cell, double cellWidth, double cellHeight, Color color) {
        double x = cell.getX() * cellWidth;
        double y = cell.getY() * cellHeight;
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x, y, cellWidth, WIDTH);
        graphicsContext.fillRect(x, y + cellHeight - WIDTH, cellWidth, WIDTH);
        graphicsContext.fillRect(x + cellWidth - WIDTH, y, WIDTH, cellHeight);
        graphicsContext.fillRect(x, y, WIDTH, cellHeight);
    }

    private static void drawBorder(GraphicsContext graphicsContext, Cell cell, double cellWidth, double cellHeight, Color color, Direction direction) {
        double x = cell.getX() * cellWidth;
        double y = cell.getY() * cellHeight;
        graphicsContext.setFill(color);
        if (direction == Direction.UP) {
            graphicsContext.fillRect(x, y, cellWidth, WIDTH);
        } else if (direction == Direction.DOWN) {
            graphicsContext.fillRect(x, y + cellHeight - WIDTH, cellWidth, WIDTH);
        } else if (direction == Direction.LEFT) {
            graphicsContext.fillRect(x, y, WIDTH, cellHeight);
        } else if (direction == Direction.RIGHT) {
            graphicsContext.fillRect(x + cellWidth - WIDTH, y, WIDTH, cellHeight);
        }
    }
}
