package org.fillouh.fh_mediaplayer.observers;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SliderMedia implements Observer, Initializable {
    private Slider slider;
    private MediaPlayer mediaPlayer;

    public SliderMedia(Slider slider,MediaPlayer mediaPlayer) {
        this.slider = slider;
        this.mediaPlayer=mediaPlayer;
    }

    @Override
    public void update() {

    }

    @Override
    public void update(double currentTime) {
        this.slider.setValue(currentTime);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       this.slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                mediaPlayer.seek(Duration.seconds(slider.getValue()));
            }
        });
    }
}

