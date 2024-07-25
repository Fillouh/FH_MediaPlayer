package org.fillouh.fh_mediaplayer.factories;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class MediaPlayerFactory {
    public abstract MediaPlayer createMediaPlayer(Media media);

}
