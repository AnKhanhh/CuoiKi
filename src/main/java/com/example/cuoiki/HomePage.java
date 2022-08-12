package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.FormattedText;
import com.example.cuoiki.Formatting.CustomFont;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HomePage extends Pane
{
    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageTitle;
    private Pane News;
    private ImageView NewsImagePane=new ImageView();
    private HBox NewsImageCountBox;
    private Circle NewsImageCountCircle=new Circle();
    private HBox NewsButtonIcon;
    private ImageView NewsLeftButtonIcon, NewsRightButtonIcon;
    private HBox NewsButtons;
    private Button NewsLeftButtonFrame, NewsRightButtonFrame;
    private NavigationBar NavBar;
    private Pane BestSellersTitle;
    private FormattedText BestSellersTitleText;
    private VBox BestSellers;
    private BestSellerPane BestSeller1, BestSeller2, BestSeller3;

    private UserInformation customer;
    private DrinkMap drink;
    private final Color Color1=Color.rgb(71, 43, 43, 1.0);
    private int NewsImagePointer=1, NewsImageCount;
    private ArrayList<Image> NewsStorage=new ArrayList<Image>();

    private class BestSellerPane extends Pane
    {
        private Rectangle Holder;
        private ImageView BestSellerImage;
        private FormattedText BestSellerName, BestSellerQuote, BestSellerPrice;

        public BestSellerPane(Image image, String name, String quote, String price)
        {
            Holder=new Rectangle(216, 96, Color.rgb(252, 255,249));
            Holder.setArcWidth(36); Holder.setArcHeight(36);
            Holder.setLayoutX(0); Holder.setLayoutY(0);

            BestSellerImage=new ImageView(image);
            BestSellerImage.setFitWidth(76); BestSellerImage.setFitHeight(76);
            BestSellerImage.setLayoutX(10); BestSellerImage.setLayoutY(10);
            BestSellerImage.setSmooth(true);
            BestSellerImage.setCache(true);

            BestSellerName=new FormattedText(name, -1.0, 0, false);
            BestSellerName.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 11));
            BestSellerName.setFill(Color1);
            BestSellerName.setLayoutX(95); BestSellerName.setLayoutY(13);

            BestSellerQuote=new FormattedText(quote, -0.5, 1.0, false);
            BestSellerQuote.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 9));
            BestSellerQuote.setFill(Color.rgb(118, 114, 114));
            BestSellerQuote.setPrefWrapLength(111);
            BestSellerQuote.setLayoutX(95); BestSellerQuote.setLayoutY(31);

            BestSellerPrice=new FormattedText(price, -1.0, 0, false);
            BestSellerPrice.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 11));
            BestSellerPrice.setFill(Color1);
            BestSellerPrice.setLayoutX(95); BestSellerPrice.setLayoutY(71);

            this.getChildren().addAll(Holder, BestSellerImage, BestSellerName, BestSellerQuote, BestSellerPrice);
        }
    }

    private class BestSellerConcept
    {
        //Declaration:
        Image BestSellerImage;
        String BestSellerName;
        String BestSellerQuote;
        String BestSellerPrice;

        //SettingMethod:
        void setImage(Image image) {BestSellerImage=image;}
        void setName(String name) {BestSellerName=name;}
        void setQuote(String quote) {BestSellerQuote=quote;}
        void setPrice(String price) {BestSellerPrice=price;}
    }
    private ArrayList<BestSellerConcept> BestSellersStorage=new ArrayList<BestSellerConcept>();

    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        //SetCustomer:
        this.customer=customer;
        this.drink=drink;

        //News:
        NewsImageCountCircle.setRadius(4);
        NewsImageCountCircle.setFill(Color1);
        NewsImageCountCircle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 2, 0, 0, 2));
        try {NewsStorage.add(new Image(new FileInputStream("materials/image/New1.png")));}
        catch (FileNotFoundException f) {}
        try {NewsStorage.add(new Image(new FileInputStream("materials/image/New2.png")));}
        catch (FileNotFoundException f) {}
        NewsImageCount=NewsStorage.size();

        //BestSellers:
        try
        {
            BestSellerConcept bestseller=new BestSellerConcept();
            bestseller.setImage(new Image(new FileInputStream("materials/image/BestSeller1.png")));
            bestseller.setName("Chocolate Bubble Tea");
            bestseller.setQuote("Wanna give this piece of       sweetness a chance to rise  you up?");
            bestseller.setPrice("$3.00");
            BestSellersStorage.add(bestseller);
        }
        catch (FileNotFoundException f) {}
        try
        {
            BestSellerConcept bestseller=new BestSellerConcept();
            bestseller.setImage(new Image(new FileInputStream("materials/image/BestSeller2.png")));
            bestseller.setName("Green Fresh Tea");
            bestseller.setQuote("Open your mind, to what youreyes can’t see!");
            bestseller.setPrice("$1.20");
            BestSellersStorage.add(bestseller);
        }
        catch (FileNotFoundException f) {}
        try
        {
            BestSellerConcept bestseller=new BestSellerConcept();
            bestseller.setImage(new Image(new FileInputStream("materials/image/BestSeller3.png")));
            bestseller.setName("Macchiato Caramel");
            bestseller.setQuote("Glory, glory, Ma..... Macchiato Caramel!");
            bestseller.setPrice("$3.40");
            BestSellersStorage.add(bestseller);
        }
        catch (FileNotFoundException f) {}
    }

    private void pickNewsImage(int page)
    {
        int index=page-1;
        NewsImagePane.setImage(NewsStorage.get(index));
        NewsImagePane.setSmooth(true);
        NewsImagePane.setCache(true);
        NewsImagePane.setFitWidth(232); NewsImagePane.setFitHeight(160);
        NewsImagePane.setLayoutX(0); NewsImagePane.setLayoutY(0);
        NewsImageCountCircle.setLayoutX(111-5*NewsImageCount+10*page); NewsImageCountCircle.setLayoutY(152);
    }

    //Build:
    private void build()
    {
        //Background:
        try {BlurredBackground=new ImageView(new Image(new FileInputStream("materials/image/BlurredBackground.png")));}
        catch(FileNotFoundException f) {}
        BlurredBackground.setFitWidth(264); BlurredBackground.setFitHeight(528);
        BlurredBackground.setSmooth(true);
        BlurredBackground.setCache(true);

        //PageTitle:
        PageTitle=new FormattedText("Welcome", -1.0, 0, false);
        PageTitle.setFont(CustomFont.createFont("Raleway - ExtraBold", "ttf", 28));
        PageTitle.setPrefWrapLength(170);
        PageTitle.setFill(Color1);
        PageTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 4, 0, 0, 4));
        PageTitle.setLayoutX(23); PageTitle.setLayoutY(44);

        //News:
        Color Circle_White=Color.rgb(248, 255, 241);
        NewsImageCountBox=new HBox(4);
        for(int count=0; count<NewsImageCount; count++) {NewsImageCountBox.getChildren().add(new Circle(3, Circle_White));}
        NewsImageCountBox.setLayoutX(118-5*NewsImageCount); NewsImageCountBox.setLayoutY(149);
        NewsImageCountBox.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 4, 0, 0, 2));
        pickNewsImage(1);
        try {NewsLeftButtonIcon=new ImageView(new Image(new FileInputStream("materials/image/LeftButton.png")));}
        catch(FileNotFoundException f) {}
        NewsLeftButtonIcon.setFitWidth(16); NewsLeftButtonIcon.setFitHeight(48);
        NewsLeftButtonIcon.setSmooth(true);
        NewsLeftButtonIcon.setCache(true);
        try {NewsRightButtonIcon=new ImageView(new Image(new FileInputStream("materials/image/RightButton.png")));}
        catch(FileNotFoundException f) {}
        NewsRightButtonIcon.setFitWidth(16); NewsRightButtonIcon.setFitHeight(48);
        NewsRightButtonIcon.setSmooth(true);
        NewsRightButtonIcon.setCache(true);
        NewsButtonIcon=new HBox(200, NewsLeftButtonIcon, NewsRightButtonIcon);
        NewsButtonIcon.setLayoutX(0); NewsButtonIcon.setLayoutY(56);
        NewsLeftButtonFrame=new Button();
        NewsLeftButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 0px 7px 7px 0px;");
        NewsLeftButtonFrame.setPrefWidth(16); NewsLeftButtonFrame.setPrefHeight(48);
        NewsLeftButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(NewsImagePointer>1) {pickNewsImage(--NewsImagePointer);}
                    else
                    {
                        NewsImagePointer=NewsImageCount;
                        pickNewsImage(NewsImagePointer);
                    }
                }
            }
        );
        NewsRightButtonFrame=new Button();
        NewsRightButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 7px 0px 0px 7px;");
        NewsRightButtonFrame.setPrefWidth(16); NewsRightButtonFrame.setPrefHeight(48);
        NewsRightButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(NewsImagePointer<NewsImageCount) {pickNewsImage(++NewsImagePointer);}
                    else
                    {
                        NewsImagePointer=1;
                        pickNewsImage(NewsImagePointer);
                    }
                }
            }
        );
        NewsButtons=new HBox(200, NewsLeftButtonFrame, NewsRightButtonFrame);
        NewsButtons.setLayoutX(0); NewsButtons.setLayoutY(56);

        News=new Pane(NewsImagePane, NewsImageCountBox, NewsImageCountCircle, NewsButtonIcon, NewsButtons);
        News.setLayoutX(16); News.setLayoutY(88);
        News.setPrefWidth(232);
        News.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 15, 0, 0, 8));

        //BestSellersTitle:
        BestSellersTitleText=new FormattedText("This week's best-sellers", -1.0, 0, false);
        BestSellersTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        BestSellersTitleText.setFill(Color1);
        BestSellersTitleText.setLayoutX(12); BestSellersTitleText.setLayoutY(1);
        Rectangle LeftLine=new Rectangle(12, 1, Color1);
        LeftLine.setLayoutX(0); LeftLine.setLayoutY(11);
        Rectangle RightLine=new Rectangle(42, 1, Color1);
        RightLine.setLayoutX(190); RightLine.setLayoutY(11);
        BestSellersTitle=new Pane(LeftLine, BestSellersTitleText, RightLine);
        BestSellersTitle.setLayoutX(16); BestSellersTitle.setLayoutY(272);
        BestSellersTitle.setPrefWidth(264);

        //BestSellersPane:
        BestSellerConcept bestseller1=BestSellersStorage.get(0);
        BestSellerConcept bestseller2=BestSellersStorage.get(1);
        BestSellerConcept bestseller3=BestSellersStorage.get(2);
        BestSeller1=new BestSellerPane(bestseller1.BestSellerImage, bestseller1.BestSellerName, bestseller1.BestSellerQuote, bestseller1.BestSellerPrice);
        BestSeller2=new BestSellerPane(bestseller2.BestSellerImage, bestseller2.BestSellerName, bestseller2.BestSellerQuote, bestseller2.BestSellerPrice);
        BestSeller3=new BestSellerPane(bestseller3.BestSellerImage, bestseller3.BestSellerName, bestseller3.BestSellerQuote, bestseller3.BestSellerPrice);
        BestSellers=new VBox(24, BestSeller1, BestSeller2, BestSeller3);
        BestSellers.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.10), 10, 0, 0, 6));
        BestSellers.setPrefWidth(216); BestSellers.setPrefHeight(360);
        BestSellers.setLayoutX(24); BestSellers.setLayoutY(312);

        //MainPage:
        MainPage=new Pane(PageTitle, News, BestSellers,BestSellersTitle);
        ScrollMainPage=new ScrollPane(MainPage);
        ScrollMainPage.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-unit-increment: 10; -fx-block-increment: 50;");
        ScrollMainPage.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setPrefWidth(264); ScrollMainPage.setPrefHeight(480);
        ScrollMainPage.setLayoutX(0); ScrollMainPage.setLayoutY(0);

        //NavigationBar:
        NavigationBar NavBar=new NavigationBar(NavigationBar.PagePicker.HOME, customer, drink);

        //Layout:
        this.getChildren().addAll(BlurredBackground, ScrollMainPage, NavBar);
        this.setLayoutX(0); this.setLayoutY(0);
    }

    //Constructor:
    public HomePage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}