package org.fillouh.fh_mediaplayer.factories;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Mp3MediaPlayerFactory extends MediaPlayerFactory{
    @Override
    public MediaPlayer createMediaPlayer(Media media) {
        return new MediaPlayer(media);
    }
}
