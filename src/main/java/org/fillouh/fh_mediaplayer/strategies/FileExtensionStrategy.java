package org.fillouh.fh_mediaplayer.strategies;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public interface FileExtensionStrategy {
    public MediaPlayer createMediaPlayer(Media media);
}
