package com.example.cuoiki.Drink;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DrinkDetails
{
    //Declaration:
    private Image DrinkImage;
    private final String DrinkType, DrinkName;
    private final double MPrice, LPrice;

    public Image getDrinkImage() {return DrinkImage;}
    public String getDrinkType() {return DrinkType;}
    public String getDrinkName() {return DrinkName;}
    public double getMPrice() {return MPrice;}
    public double getLPrice() {return LPrice;}

    //Constructor:
    DrinkDetails(String imagepath, String drinktype, String drinkname, double mprice, double lprice)
    {
        try {DrinkImage=new Image(new FileInputStream(imagepath));}
        catch(FileNotFoundException f) {}
        DrinkType=drinktype;
        DrinkName=drinkname;
        MPrice=mprice;
        LPrice=lprice;
    }
}
