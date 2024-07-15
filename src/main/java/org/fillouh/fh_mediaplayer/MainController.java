package org.fillouh.fh_mediaplayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button exitButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button stopButton;

    private String filePath;


    private void openFile(){
        FileChooser fileChooser=new FileChooser();
        //nel campo extension possiamo metterci anche altre estensioni file
        FileChooser.ExtensionFilter filter=new FileChooser.ExtensionFilter("Select a File (*.mp4)","*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file=fileChooser.showOpenDialog(null);
        filePath=file.toURI().toString();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}