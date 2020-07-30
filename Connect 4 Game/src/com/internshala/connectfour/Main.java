package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    // Field Variables
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Loaders
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(rootGridPane);
        Pane menuPane = (Pane)rootGridPane.getChildren().get(0);

        //MenuBar
        MenuBar menuBar = createMenu();
        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        //Grid Holes
        controller.createPlayground();

        // Primary Stage
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private MenuBar createMenu()
    {
        //MenuBar
        MenuBar menuBar = new MenuBar();

        //Seperator
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        //Menu
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");

        //MenuItem
        MenuItem newGame = new MenuItem("New Game");
        MenuItem resetGame = new MenuItem("Reset Game");
        MenuItem exitGame = new MenuItem("Exit");
        MenuItem aboutMe = new MenuItem("About Me");
        MenuItem aboutGame = new MenuItem("About Connect 4");

        //Linking MenuItem --> Menu
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
        helpMenu.getItems().addAll(aboutGame,aboutMe);

        //Linking Menu ---> MenuBar
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        //Methods
        newGame.setOnAction(actionEvent -> resetGame());
        resetGame.setOnAction(actionEvent -> resetGame());
        exitGame.setOnAction(actionEvent -> exitGame());
        aboutGame.setOnAction(actionEvent -> aboutGame());
        aboutMe.setOnAction(actionEvent -> aboutMe());

        return menuBar;
    }

    //Methods
    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the developer");
        alert.setHeaderText("SHAIK SOHAIL HASAN");;
        alert.setContentText("I am a BITSian. I have made this game.Hope anyone who plays it, Likes the game!");
        alert.show();
    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4");
        alert.setHeaderText("How to play?");;
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid."+"\n"+"The pieces fall straight down, occupying the next available space within the column."+"\n"+"The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs."+"\n"+"Connect Four is a solved game."+"\n"+"The first player can always win by playing the right moves.\n");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
