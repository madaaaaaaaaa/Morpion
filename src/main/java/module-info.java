module com.example.morpion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens GameMVC to javafx.fxml;
    exports GameMVC;
}