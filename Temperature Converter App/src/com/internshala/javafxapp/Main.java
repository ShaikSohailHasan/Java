package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.css.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("App Started");    // Starts an application

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    private MenuBar createMenu() {

        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu-Item Clicked");
            // More code....
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Exit");

        quitMenuItem.setOnAction(event -> {
            System.out.println("Exit Menu-Item Clicked");
            System.out.println("App Terminated");
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutApp() {

        System.out.println("About Menu-Item Clicked");
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About App");
        alertDialog.setHeaderText("Temperature Converter Tool");
        alertDialog.setContentText("Temperature Converter App is very simple and user-friendly tool to convert temperature from Fahrenheit to Celsius or from Celsius to Fahrenheit."+"\n"+"\n"+"Developed By:- SHAIK SOHAIL HASAN");

        ButtonType cnclBtn = new ButtonType("Cancel");

        alertDialog.getButtonTypes().setAll(cnclBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == cnclBtn) {
            System.out.println("Cancel Button Clicked");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
