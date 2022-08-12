package com.example.cuoiki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application
{
    //Launcher:
    public static void main(String[] args) {launch();}

    //Build:
    @Override
    public void start(Stage stage)
    {
        Rectangle rec=new Rectangle(10, 10, 100, 100);
        rec.setStyle("-fx-background-radius: 0px 7px 7px 0px;");
        rec.setFill(Color.SADDLEBROWN);
        Pane pane=new Pane(rec);
        Scene Page=new Scene(pane);
        stage.setResizable(false);
        stage.setScene(Page);
        stage.show();
    }
}
