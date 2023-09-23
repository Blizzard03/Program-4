/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package calculator.Main_Class;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class Calculator extends Application {

    /**
     * Represents the stage which is the visible window.
     */
    private Stage stage;

    /**
     * This represents the current scene which is what sets the window
     * dimensions and the interface.
     */
    private Scene currentScene;
    //Theme 
    private Theme currentTheme = Theme.LIGHT;

    public enum Theme {
        LIGHT,
        DARK,
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/calculator/FXML_UI_Models/Calculator.fxml"));

            currentScene = new Scene(root);
            primaryStage.setTitle("Calculator");
            primaryStage.setResizable(false);
            primaryStage.setIconified(false);
            primaryStage.setScene(currentScene);
            primaryStage.show();
            //switchTheme(currentTheme);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

   /* public void switchTheme(Theme theme) {
        switch (theme) {
            case LIGHT:
                currentTheme = Theme.LIGHT;
                currentScene.getStylesheets().clear();
                currentScene.getStylesheets().add(getClass().getResource("/calculator/Style/Light/Light.css").toExternalForm());
                break;
            case DARK:
                currentTheme = Theme.DARK;
                currentScene.getStylesheets().clear();
                currentScene.getStylesheets().add(getClass().getResource("/calculator/Style/Dark/Dark.css").toExternalForm());
                break;
        }
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
