package org.fillouh.fh_mediaplayer.observers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ObservableMediaPlayer extends Subject{
    private MediaPlayer mediaPlayer;

    public ObservableMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                notifyObserver(t1.toSeconds());
                notifyObserver();
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
