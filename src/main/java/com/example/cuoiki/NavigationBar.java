package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NavigationBar extends Pane
{
    //Declaration:
    private HBox IconFrame;
    private ImageView HomeIcon, MenuIcon, ChatIcon, ProfileIcon;
    private HBox PickedIconFrame;
    private ImageView PickedHomeIcon, PickedMenuIcon, PickedChatIcon, PickedProfileIcon;
    private HBox ButtonFrame;
    private Button HomeButtonFrame, MenuButtonFrame, ChatButtonFrame, ProfileButtonFrame;
    private Pane PickerIcon;

    private UserInformation customer;
    private DrinkMap drink;
    private final Color Color1=Color.rgb(71, 43, 43, 1.0);
    public enum PagePicker{HOME, MENU, CHAT, PROFILE}

    //Setup:
    private void setup(UserInformation customer, DrinkMap drink)
    {
        //SetCustomer:
        this.customer=customer;
        this.drink=drink;
    }

    //Build:
    private void build()
    {
        //PickerIcon:
        Rectangle Rect1=new Rectangle(32, 28, Color1);
        Rect1.setArcWidth(20); Rect1.setArcHeight(20);
        Rect1.setLayoutX(0); Rect1.setLayoutY(0);
        Rectangle Rect2=new Rectangle(16, 2, Color1);
        Rect2.setArcWidth(2.5); Rect2.setArcHeight(2.5);
        Rect2.setLayoutX(8); Rect2.setLayoutY(31);
        PickerIcon=new Pane(Rect1, Rect2);
        PickerIcon.setPrefWidth(32); PickerIcon.setPrefHeight(33);

        //IconFrame:
        try {HomeIcon=new ImageView(new Image(new FileInputStream("materials/image/Home.png")));}
        catch(FileNotFoundException e) {}
        HomeIcon.setFitWidth(16); HomeIcon.setFitHeight(16);
        HomeIcon.setSmooth(true);
        HomeIcon.setCache(true);

        try {MenuIcon=new ImageView(new Image(new FileInputStream("materials/image/Menu.png")));}
        catch(FileNotFoundException e) {}
        MenuIcon.setFitWidth(16); MenuIcon.setFitHeight(16);
        MenuIcon.setSmooth(true);
        MenuIcon.setCache(true);

        try {ChatIcon=new ImageView(new Image(new FileInputStream("materials/image/Chat.png")));}
        catch(FileNotFoundException e) {}
        ChatIcon.setFitWidth(16); ChatIcon.setFitHeight(16);
        ChatIcon.setSmooth(true);
        ChatIcon.setCache(true);

        try {ProfileIcon=new ImageView(new Image(new FileInputStream("materials/image/Profile.png")));}
        catch(FileNotFoundException e) {}
        ProfileIcon.setFitWidth(16); ProfileIcon.setFitHeight(16);
        ProfileIcon.setSmooth(true);
        ProfileIcon.setCache(true);

        IconFrame=new HBox(40, HomeIcon, MenuIcon, ChatIcon, ProfileIcon);
        IconFrame.setLayoutX(40); IconFrame.setLayoutY(14);

        //PickedIconFrame:
        try {PickedHomeIcon=new ImageView(new Image(new FileInputStream("materials/image/PickedHome.png")));}
        catch(FileNotFoundException e) {}
        PickedHomeIcon.setFitWidth(16); PickedHomeIcon.setFitHeight(16);
        PickedHomeIcon.setSmooth(true);
        PickedHomeIcon.setCache(true);

        try {PickedMenuIcon=new ImageView(new Image(new FileInputStream("materials/image/PickedMenu.png")));}
        catch(FileNotFoundException e) {}
        PickedMenuIcon.setFitWidth(16); PickedMenuIcon.setFitHeight(16);
        PickedMenuIcon.setSmooth(true);
        PickedMenuIcon.setCache(true);

        try {PickedChatIcon=new ImageView(new Image(new FileInputStream("materials/image/PickedChat.png")));}
        catch(FileNotFoundException e) {}
        PickedChatIcon.setFitWidth(16); PickedChatIcon.setFitHeight(16);
        PickedChatIcon.setSmooth(true);
        PickedChatIcon.setCache(true);

        try {PickedProfileIcon=new ImageView(new Image(new FileInputStream("materials/image/PickedProfile.png")));}
        catch(FileNotFoundException e) {}
        PickedProfileIcon.setFitWidth(16); PickedProfileIcon.setFitHeight(16);
        PickedProfileIcon.setSmooth(true);
        PickedProfileIcon.setCache(true);

        PickedIconFrame=new HBox(40, PickedHomeIcon, PickedMenuIcon, PickedChatIcon, PickedProfileIcon);
        PickedIconFrame.setLayoutX(40); PickedIconFrame.setLayoutY(14);

        //ButtonFrame:
        HomeButtonFrame=new Button();
        HomeButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 10px;");
        HomeButtonFrame.setPrefWidth(32); HomeButtonFrame.setPrefHeight(32);
        HomeButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent arg0) {getScene().setRoot(new HomePage(customer, drink));}
            }
        );

        MenuButtonFrame=new Button();
        MenuButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 10px;");
        MenuButtonFrame.setPrefWidth(32); MenuButtonFrame.setPrefHeight(32);
        MenuButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent arg0) {getScene().setRoot(new MenuPage(customer, drink));}
            }
        );

        ChatButtonFrame=new Button();
        ChatButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 10px;");
        ChatButtonFrame.setPrefWidth(32); ChatButtonFrame.setPrefHeight(32);
        ChatButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent arg0) {getScene().setRoot(new ChatPage(customer, drink));}
            }
        );

        ProfileButtonFrame=new Button();
        ProfileButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 10px;");
        ProfileButtonFrame.setPrefWidth(32); ProfileButtonFrame.setPrefHeight(32);
        ProfileButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent arg0) {getScene().setRoot(new ProfilePage(customer, drink));}
            }
        );

        ButtonFrame=new HBox(24, HomeButtonFrame, MenuButtonFrame, ChatButtonFrame, ProfileButtonFrame);
        ButtonFrame.setLayoutX(32); ButtonFrame.setLayoutY(8);

        //Layout:
        this.getChildren().addAll(PickerIcon, IconFrame, PickedIconFrame, ButtonFrame);
        this.setLayoutX(0); this.setLayoutY(480);
        this.setPrefWidth(264); this.setPrefHeight(48);
    }

    //PagePicker:
    public void pickPage(PagePicker p)
    {
        //Home:
        if(p==PagePicker.HOME)
        {
            PickerIcon.setLayoutX(32); PickerIcon.setLayoutY(8);
            PickedMenuIcon.setVisible(false);
            PickedChatIcon.setVisible(false);
            PickedProfileIcon.setVisible(false);
        }

        //Menu:
        else if(p==PagePicker.MENU)
        {
            PickerIcon.setLayoutX(88); PickerIcon.setLayoutY(8);
            PickedHomeIcon.setVisible(false);
            PickedChatIcon.setVisible(false);
            PickedProfileIcon.setVisible(false);
        }

        //Home:
        else if(p==PagePicker.CHAT)
        {
            PickerIcon.setLayoutX(144); PickerIcon.setLayoutY(8);
            PickedHomeIcon.setVisible(false);
            PickedMenuIcon.setVisible(false);
            PickedProfileIcon.setVisible(false);
        }

        //Menu:
        else if(p==PagePicker.PROFILE)
        {
            PickerIcon.setLayoutX(200); PickerIcon.setLayoutY(8);
            PickedHomeIcon.setVisible(false);
            PickedMenuIcon.setVisible(false);
            PickedChatIcon.setVisible(false);
        }
    }

    //Constructor:
    public NavigationBar(PagePicker p, UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
        pickPage(p);
    }
}