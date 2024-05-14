package sample;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Score {
     void saveScore() throws FileNotFoundException ;
     void showScore() throws FileNotFoundException ;
     void showHighScore(ActionEvent event) throws IOException;
}
