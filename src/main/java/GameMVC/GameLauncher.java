package GameMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameLauncher extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(GameMVC.GameLauncher.class.getResource("/GameView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Morpion²");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}