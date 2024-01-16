package application.controller;

import application.rasterization.Rasterization;
import com.damning.chess.chessboard.Cell;
import com.damning.chess.chessboard.ChessBoardUtils;
import com.damning.chess.game.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainWindowController {
    Game game;
    String path;
    boolean gameFinished = false;

    @FXML
    private Canvas field;

    @FXML
    void OpenFieldChooser() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("FieldChooser.fxml")));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Choose field");
            FieldChooserController controller = fxmlLoader.getController();
            stage.setScene(new Scene(root1));
            stage.show();
            controller.setPath(this, stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startGame() {
        game = new Game(ChessBoardUtils.readBoardFromFile(path));
        game.start();
        Rasterization.drawBoard(field.getGraphicsContext2D(), game.getBoard());
    }

    @FXML
    void onCanvasClicked(MouseEvent event) {
        if (game != null) {
            Cell selectedCell = game.getCell(getNormalizedX(event.getX()), getNormalizedY(event.getY()));
            if (selectedCell != null) {
                if (game.getSelectedFigure() == null) {
                    game.selectFigure(selectedCell.getFigure());
                } else if (game.getSelectedFigure().getPosition().equals(selectedCell)) {
                    game.deselectFigure();
                } else if (game.getSelectedFigure().canMoveTo(selectedCell)) {
                    game.move(game.getSelectedFigure(), selectedCell);
                    game.deselectFigure();
                }
                if (game.getSelectedFigure() != null)
                    Rasterization.drawPossibleMoves(field.getGraphicsContext2D(), game.getBoard(), game.getSelectedFigure());
                else {
                    gameFinished = game.checkWin();
                    Rasterization.drawBoard(field.getGraphicsContext2D(), game.getBoard());
                }
                if (gameFinished) {
                    showWinDialog();
                }
            }
        }
    }

    private void showWinDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Game finished");
        alert.setContentText("Player " + game.getPlayers().get(0).getColor() + " won!");
        alert.show();
    }

    private int getNormalizedX(double x) {
        return (int) (x / field.getWidth() * game.getBoard().getSizeX());
    }

    private int getNormalizedY(double y) {
        return (int) (y / field.getHeight() * game.getBoard().getSizeY());
    }

    @FXML
    void quit() {
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }


}
