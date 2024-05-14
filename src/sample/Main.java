package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;




public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menuFX.fxml"));
            primaryStage.setTitle("CAPTCHA");
        Image icon = new Image(getClass().getResourceAsStream("img/titlepic.jpeg"));
        primaryStage.getIcons().add(icon);
        Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        String css = this.getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setResizable(false);
            primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}