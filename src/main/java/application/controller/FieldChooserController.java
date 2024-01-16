package application.controller;

import com.damning.chess.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FieldChooserController {
    @FXML
    private Label field;
    @FXML
    private Button startBt;
    MainWindowController controller;
    Stage stage;

    final String CLASSIC = "src\\main\\resources\\java\\com\\damning\\chess\\chessboard\\classic.txt";
    final String RUSSIAN = "src\\main\\resources\\java\\com\\damning\\chess\\chessboard\\russian.txt";
    private String chosenField;
    @FXML
    void chooseClassic(ActionEvent event) {
        choose(CLASSIC);
    }

    @FXML
    void chooseRussian(ActionEvent event) {
        choose(RUSSIAN);
    }

    @FXML
    void openField(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\Users\\Danila\\VSU\\2year\\1term\\prog\\Chess\\src\\main\\resources\\java\\com\\damning\\chess\\chessboard"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        fileChooser.setTitle("Open Field");
        File file = fileChooser.showOpenDialog(stage);
        if(file == null)
            return;
        choose(file.getPath());

    }
    private void choose(String path){
        chosenField = path;
        field.setText(chosenField.split("\\\\")[chosenField.split("\\\\").length - 1]);
        startBt.setDisable(false);
    }
    public void setPath(MainWindowController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }
    @FXML
    void startGame(ActionEvent event) {
        controller.path = chosenField;
        stage.close();
        controller.startGame();
    }

}
