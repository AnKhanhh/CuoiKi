package com.example.cuoiki.Drink;

import java.util.HashMap;

public class DrinkMap extends HashMap<DrinkConst, DrinkDetails>
{
    //Constructor:
    public DrinkMap()
    {
        //SettingUpMap:
        put(DrinkConst.BUBBLETEA_Lychee, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Lychee.jpg", "Bubble Tea", "Lychee", 2.30, 2.50));
        put(DrinkConst.BUBBLETEA_Squash, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Squash.jpg", "Bubble Tea", "Squash", 1.80, 2.00));
        put(DrinkConst.BUBBLETEA_Strawberry, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Strawberry.jpg", "Bubble Tea", "Strawberry", 2.70, 3.00));
        put(DrinkConst.BUBBLETEA_Taro, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Taro.jpg", "Bubble Tea", "Taro", 2.20, 2.40));
        put(DrinkConst.BUBBLETEA_Mint, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Mint.jpg", "Bubble Tea", "Mint", 2.10, 2.30));
        put(DrinkConst.BUBBLETEA_Matcha, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Matcha.jpg", "Bubble Tea", "Matcha", 2.40, 2.70));
        put(DrinkConst.BUBBLETEA_Chocolate, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Chocolate.jpg", "Bubble Tea", "Chocolate", 2.40, 2.70));
        put(DrinkConst.BUBBLETEA_Almond, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Almond.jpg", "Bubble Tea", "Almond", 2.60, 2.90));
        put(DrinkConst.BUBBLETEA_Kiwi, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Kiwi.jpg", "Bubble Tea", "Kiwi", 1.50, 1.70));
        put(DrinkConst.BUBBLETEA_Honey, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Honey.jpg", "Bubble Tea", "Honey", 1.90, 2.10));
        put(DrinkConst.BUBBLETEA_Peach, new DrinkDetails("materials/image/DrinkImage/BUBBLETEA_Peach.jpg", "Bubble Tea", "Peach", 1.70, 2.00));
        put(DrinkConst.FRESHTEA_White, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_White.jpg", "Fresh Tea", "White", 0, 4.10));
        put(DrinkConst.FRESHTEA_Green, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_Green.jpg", "Fresh Tea", "Green", 2.80, 3.20));
        put(DrinkConst.FRESHTEA_LotusGreen, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_LotusGreen.jpg", "Fresh Tea", "Lotus Green", 6.30, 6.80));
        put(DrinkConst.FRESHTEA_Oolong, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_Oolong.jpg", "Fresh Tea", "Oolong", 0, 3.60));
        put(DrinkConst.FRESHTEA_Black, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_Black.jpg", "Fresh Tea", "Black", 0, 4.10));
        put(DrinkConst.FRESHTEA_Jasmine, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_Jasmine.jpg", "Fresh Tea", "Jasmine", 5.50, 5.80));
        put(DrinkConst.FRESHTEA_Matcha, new DrinkDetails("materials/image/DrinkImage/FRESHTEA_Matcha.jpg", "Fresh Tea", "Black", 3.00, 3.30));
        put(DrinkConst.COFFEE_PureBlack, new DrinkDetails("materials/image/DrinkImage/COFFEE_PureBlack.jpg", "Coffee", "Pure Black", 1.40, 0));
        put(DrinkConst.COFFEE_Phin, new DrinkDetails("materials/image/DrinkImage/COFFEE_Phin.jpg", "Coffee", "Phin", 1.90, 0));
        put(DrinkConst.COFFEE_Milk, new DrinkDetails("materials/image/DrinkImage/COFFEE_Milk.jpg", "Coffee", "Milk", 2.10, 0));
        put(DrinkConst.COFFEE_Espresso, new DrinkDetails("materials/image/DrinkImage/COFFEE_Espresso.jpg", "Coffee", "Espresso", 0, 2.00));
        put(DrinkConst.CARAMEL_Apple, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Apple.jpg", "Caramel", "Apple", 1.20, 0));
        put(DrinkConst.CARAMEL_Chocolate, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Chocolate.jpg", "Caramel", "Chocolate", 1.30, 0));
        put(DrinkConst.CARAMEL_Milk, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Milk.jpg", "Caramel", "Milk", 1.50, 0));
        put(DrinkConst.CARAMEL_Coffee, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Coffee.jpg", "Caramel", "Coffee", 1.30, 0));
        put(DrinkConst.CARAMEL_Orange, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Orange.jpg", "Caramel", "Orange", 1.20, 0));
        put(DrinkConst.CARAMEL_Bourbon, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Bourbon.jpg", "Caramel", "Bourbon", 1.70, 0));
        put(DrinkConst.CARAMEL_Macchiato, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Macchiato.jpg", "Caramel", "Macchiato", 1.90, 0));
        put(DrinkConst.CARAMEL_Seasalted, new DrinkDetails("materials/image/DrinkImage/CARAMEL_Seasalted.jpg", "Caramel", "Sea-salted", 1.40, 0));
        put(DrinkConst.TOPPINGS_MilkPudding, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_MilkPudding.jpg", "Toppings", "Milk Pudding", 0.20, 0));
        put(DrinkConst.TOPPINGS_CoffeePudding, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_CoffeePudding.jpg", "Toppings", "Coffee Pudding", 0.20, 0));
        put(DrinkConst.TOPPINGS_MatchaPudding, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_MatchaPudding.jpg", "Toppings", "Matcha Pudding", 0.20, 0));
        put(DrinkConst.TOPPINGS_FlanPudding, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_FlanPudding.jpg", "Toppings", "Flan Pudding", 0.25, 0));
        put(DrinkConst.TOPPINGS_AloeVeraJelly, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_AloeVeraJelly.jpg", "Toppings", "Aloe Vera Jelly", 0.40, 0));
        put(DrinkConst.TOPPINGS_AgarJelly, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_AgarJelly.jpg", "Toppings", "Agar Jelly", 0.70, 0));
        put(DrinkConst.TOPPINGS_Popball, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_Popball.jpg", "Toppings", "Popball", 0.15, 0));
        put(DrinkConst.TOPPINGS_ChineseMilkFoam, new DrinkDetails("materials/image/DrinkImage/TOPPINGS_ChineseMilkFoam.jpg", "Toppings", "Chinese Milk Foam", 0.85, 0));
    }
}
