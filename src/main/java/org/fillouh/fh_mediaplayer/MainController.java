package org.fillouh.fh_mediaplayer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.fillouh.fh_mediaplayer.factories.Mp3MediaPlayerFactory;
import org.fillouh.fh_mediaplayer.factories.Mp4MediaPlayerFactory;
import org.fillouh.fh_mediaplayer.observers.ObservableMediaPlayer;
import org.fillouh.fh_mediaplayer.observers.SliderMedia;
import org.fillouh.fh_mediaplayer.observers.VolumeSlider;
import org.fillouh.fh_mediaplayer.strategies.MP3FileExtensionStrategy;
import org.fillouh.fh_mediaplayer.strategies.MP4FileExtensionStrategy;
import org.fillouh.fh_mediaplayer.strategies.MediaPlayerChooser;

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

    @FXML
    private MediaView mediaView;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider seekSlider;

    @FXML
    private Button fullscreenButton;

    private MediaPlayer mediaPlayer;
    private String filePath;
    private boolean screenplay;


    public void openFile(){
        FileChooser fileChooser=new FileChooser();
        //nel campo extension possiamo metterci anche altre estensioni file
        FileChooser.ExtensionFilter filter=new FileChooser.ExtensionFilter("Select a File (*.mp4, *mp3)","*.mp4","*.mp3");
        fileChooser.getExtensionFilters().add(filter);
        File file=fileChooser.showOpenDialog(null);
        filePath=file.toURI().toString();

        if(filePath!=null){
            MediaPlayerChooser chooser=new MediaPlayerChooser();
            chooser.addStrategy("mp4",new MP4FileExtensionStrategy(new Mp4MediaPlayerFactory()));
            chooser.addStrategy("mp3",new MP3FileExtensionStrategy(new Mp3MediaPlayerFactory()));

            mediaPlayer=chooser.getMediaPlayer(filePath);
            mediaView.setMediaPlayer(mediaPlayer);

            DoubleProperty witdth= mediaView.fitWidthProperty();
            DoubleProperty height=mediaView.fitHeightProperty();

            witdth.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));

            ObservableMediaPlayer observableMediaPlayer=new ObservableMediaPlayer(mediaPlayer);

            SliderMedia sliderMedia=new SliderMedia(seekSlider,mediaPlayer);
            VolumeSlider volumeS=new VolumeSlider(volumeSlider,mediaPlayer);
            observableMediaPlayer.addObserver(sliderMedia);
            observableMediaPlayer.addObserver(volumeS);

            mediaPlayer.play();

        }


    }

    @FXML
    private void pauseMedia(ActionEvent event){
        mediaPlayer.pause();
    }


    @FXML
    private void playMedia(ActionEvent event){
        mediaPlayer.setRate(1);
        mediaPlayer.play();
    }

    @FXML
    private void stopMedia(ActionEvent event){
        mediaPlayer.stop();
    }


    @FXML
    private void fastMedia(ActionEvent event){
        mediaPlayer.setRate(1.5);

    }
    @FXML
    private void fasterMedia(ActionEvent event){
        mediaPlayer.setRate(2);
    }
    @FXML
    private void slowMedia(ActionEvent event){
        mediaPlayer.setRate(.75);
    }
    @FXML
    private void slowerMedia(ActionEvent event){
        mediaPlayer.setRate(.5);
    }
    @FXML
    private void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void fullScreen(){
        Scene scene=fullscreenButton.getScene();
        Stage stage=(Stage) scene.getWindow();
        if(!screenplay){
            stage.setFullScreen(true);
            screenplay=true;
            fullscreenButton.setText("Zoom out");
        }
        else {
            stage.setFullScreen(false);
            screenplay=false;
            fullscreenButton.setText("Zoom in");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        screenplay=false;
    }
}