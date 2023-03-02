module com.example.videogamesdataview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.videogamesdataview to javafx.fxml;
    exports com.example.videogamesdataview;
}