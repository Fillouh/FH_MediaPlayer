package org.fillouh.fh_mediaplayer.observers;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

public class VolumeSlider implements Observer{
    private Slider slider;
    private MediaPlayer mediaPlayer;

    public VolumeSlider(Slider slider,MediaPlayer mediaPlayer){
        this.slider=slider;
        this.mediaPlayer=mediaPlayer;
        this.slider.setValue(this.mediaPlayer.getVolume()*100);
    }

    @Override
    public void update() {
        this.slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(slider.getValue()/100);
            }
        });
    }

    @Override
    public void update(double currentTime) {

    }
}
