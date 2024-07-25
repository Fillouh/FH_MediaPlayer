package org.fillouh.fh_mediaplayer.strategies;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.fillouh.fh_mediaplayer.factories.MediaPlayerFactory;
import org.fillouh.fh_mediaplayer.factories.Mp3MediaPlayerFactory;

public class MP3FileExtensionStrategy implements FileExtensionStrategy{
    private MediaPlayerFactory factory;

    public MP3FileExtensionStrategy(MediaPlayerFactory factory) {
        this.factory = factory;
    }

    @Override
    public MediaPlayer createMediaPlayer(Media media) {
        return factory.createMediaPlayer(media);
    }
}
