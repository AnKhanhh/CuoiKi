package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Launcher extends Application
{
    //Launcher:
    public static void main(String[] args) {launch();}

    //Build:
    @Override
    public void start(Stage stage)
    {
        UserInformation customer=new UserInformation();
        DrinkMap drink=new DrinkMap();
        Scene Page=new Scene(new StartPage(customer, drink));
        try {stage.getIcons().add(new Image(new FileInputStream("materials/image/AppIcon.png")));}
        catch(FileNotFoundException e) {}
        stage.setTitle("Drinks!");
        stage.setResizable(false);
        stage.setScene(Page);
        stage.show();
    }
}