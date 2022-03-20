package bank.testfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        MenuBarPane mbPane = new MenuBarPane();
        Scene mbScene = new Scene(mbPane, 1200, 800);
        Stage mbStage = new Stage();
        mbStage.setScene(mbScene);
        mbStage.show();
        mbStage.setX(500);
        mbStage.setY(40); 
    }

    public static void main(String[] args) {
        launch();
    }

}