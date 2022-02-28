module com.example.morpion {
    requires javafx.controls;
    requires javafx.fxml;


    opens GameMVC to javafx.fxml;
    exports GameMVC;
}