package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.FormattedText;
import com.example.cuoiki.Formatting.CustomFont;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class ChatPage extends Pane
{
	//Chat:
	static Socket s,sChat;
	static DataOutputStream dout, doutChat;

	static {
		try {
			s = new Socket("127.0.0.1", 4000);
			sChat = new Socket("127.0.0.1", 8000);
			dout =new DataOutputStream(s.getOutputStream());
			doutChat = new DataOutputStream(sChat.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String msgout;

    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageTitle, Quote;
	private TextField TypeField;
	private Button TypeFieldButton;

    private UserInformation customer;
    private DrinkMap drink;
    private final Color TextColor=Color.rgb(71, 43, 43, 1.0);


    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        //SetCustomer:
        this.customer=customer;
        this.drink=drink;
    }

    //Build:
    private void build()
    {
        //Background:
        try {BlurredBackground=new ImageView(new Image(new FileInputStream("materials/image/BlurredBackground.png")));}
        catch(FileNotFoundException e) {}
        BlurredBackground.setFitWidth(264); BlurredBackground.setFitHeight(528);
        BlurredBackground.setSmooth(true);
        BlurredBackground.setCache(true);

        //PageTitle:
        PageTitle=new FormattedText("Chatting Up", -1.0, 0, false);
        PageTitle.setFont(CustomFont.createFont("Raleway - ExtraBold", "ttf", 28));
        PageTitle.setPrefWrapLength(170);
        PageTitle.setFill(TextColor);
        PageTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 4, 0, 0, 4));
        PageTitle.setLayoutX(23); PageTitle.setLayoutY(44);

        //Quote:
        Quote=new FormattedText("Tell your stories and problems     here with us!", -1.0, 1, false);
        Quote.setPrefWrapLength(88);
        Quote.setFont(CustomFont.createFont("Raleway - SemiBoldItalic", "ttf", 12));
        Quote.setFill(TextColor);
        Quote.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 4, 0, 0, 4));
        Quote.setLayoutX(23); Quote.setLayoutY(84);

		//TypeField:
		TypeField=new TextField();
		TypeField.setPrefWidth(232); TypeField.setPrefHeight(32);
		TypeField.setLayoutX(16); TypeField.setLayoutY(440);
		TypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 12));

		TypeFieldButton=new Button();
		TypeFieldButton.setPrefWidth(32); TypeFieldButton.setPrefHeight(32);
		TypeFieldButton.setLayoutX(216); TypeFieldButton.setLayoutY(440);
		TypeFieldButton.setOnAction
				(
						new EventHandler<ActionEvent>()
						{
							@Override
							public void handle(ActionEvent e)
							{
								try {
									msgout = TypeField.getText().trim();
									TypeField.setText(null);
									doutChat.writeUTF(msgout);
									dout.writeUTF("message");
									dout.flush();
									System.out.println("msg sent");
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
						}
				);


        //MainPage:
        MainPage=new Pane(PageTitle, Quote, TypeField, TypeFieldButton);
        ScrollMainPage=new ScrollPane(MainPage);
        ScrollMainPage.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-unit-increment: 10; -fx-block-increment: 50;");
        ScrollMainPage.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setPrefWidth(264); ScrollMainPage.setPrefHeight(480);
        ScrollMainPage.setLayoutX(0); ScrollMainPage.setLayoutY(0);

        //NavigationBar:
        NavigationBar NavBar=new NavigationBar(NavigationBar.PagePicker.CHAT, customer, drink);

        //Layout:
        this.getChildren().addAll(BlurredBackground, ScrollMainPage, NavBar);
        this.setLayoutX(0); this.setLayoutY(0);
	}

	//Chat send message
	static void send(String str){
		try {
			dout.writeUTF(str);
			dout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    //Constructor:
    public ChatPage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}