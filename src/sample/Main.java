package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static Stage stg;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stg=primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Visualizer v1.0");
        primaryStage.setScene(new Scene(root, 1366, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public void newScene(String title,String fxml) throws IOException{
        Stage a = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        a.setTitle(title);
        a.setScene(new Scene(root, 604, 483));
        a.setResizable(false);
        a.show();
        a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
    }


/*
    public void closeScene(String title,String fxml) throws IOException{
        Stage a = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        a.setTitle(title);
        a.setScene(new Scene(root, 604, 483));
        a.setResizable(false);
        a.show();
        a.getIcons().add(new Image(getClass().getResourceAsStream("/res/bird-icon.png")));
    }

 */

    public static void main(String[] args) {
        launch(args);
    }
}
