module org.fillouh.fh_mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.fillouh.fh_mediaplayer to javafx.fxml;
    exports org.fillouh.fh_mediaplayer;
}