package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.awt.event.*;

public interface SimpleCaptcha {


    void checkCaptcha();
    String generateCaptcha();


}