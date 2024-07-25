package org.fillouh.fh_mediaplayer.strategies;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.HashMap;
import java.util.Map;

public class MediaPlayerChooser {
    private Map<String,FileExtensionStrategy> strategyMap=new HashMap<>();

    public void addStrategy(String extension, FileExtensionStrategy strategy){
        strategyMap.put(extension,strategy);
    }

    public MediaPlayer getMediaPlayer(String filePath) {
        String extension = getFileExtension(filePath);
        FileExtensionStrategy strategy = strategyMap.get(extension);
        if (strategy != null) {
            Media media = new Media(filePath);
            return strategy.createMediaPlayer(media);
        }
        else{
            throw new RuntimeException("Unsupported file extension, please choose another file");
        }
    }


    private String getFileExtension(String filePath) {
        String extension = "";
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }
}
