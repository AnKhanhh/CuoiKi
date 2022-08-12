package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.CustomFont;
import com.example.cuoiki.Formatting.FormattedText;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;


public class StartPage extends Pane
{
    //Declaration & Pre-defining:
    private ImageView Background;
    private FormattedText PageTitle, Quote;
    private Pane StartButton;
    private HBox StartButtonText;
    private Text StartButtonTextLeft, StartButtonTextRight;
    private FormattedText StartButtonTextMain;
    private Rectangle StartButtonBox;
    private Button StartButtonFrame;
    private ImageView BackgroundMask;
    private Rectangle ButtonBlurMask;

    private UserInformation customer;
    private DrinkMap drink;
    private final Color Color1=Color.rgb(71, 43, 43, 1.0);

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
        //Background:
        try {Background=new ImageView(new Image(new FileInputStream("materials/image/Background.png")));}
        catch(FileNotFoundException f) {}
        Background.setFitWidth(264); Background.setFitHeight(528);
        Background.setSmooth(true);
        Background.setCache(true);

        //PageTitle:
        PageTitle=new FormattedText("A good         drink is likekindness", -1.0, -1.4, false);
        PageTitle.setFont(CustomFont.createFont("Raleway - ExtraBold", "ttf", 28));
        PageTitle.setFill(Color1);
        PageTitle.setPrefWrapLength(150);
        PageTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 4, 0, 0, 4));
        PageTitle.setLayoutX(23); PageTitle.setLayoutY(46);

        //Quote:
        Quote=new FormattedText("\"It awakens your spirit and improves your day.\"", -1.0, 1, false);
        Quote.setPrefWrapLength(145);
        Quote.setFont(CustomFont.createFont("Raleway - SemiBoldItalic", "ttf", 12));
        Quote.setFill(Color1);
        Quote.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 4, 0, 0, 4));
        Quote.setLayoutX(23); Quote.setLayoutY(157);

        //StartButton:
        try {BackgroundMask=new ImageView(new Image(new FileInputStream("materials/image/Background.png")));}
        catch(FileNotFoundException f) {}
        BackgroundMask.setFitWidth(264); BackgroundMask.setFitHeight(528);
        BackgroundMask.setSmooth(true);
        BackgroundMask.setCache(true);
        ButtonBlurMask=new Rectangle(32, 424, 200, 32);
        ButtonBlurMask.setArcWidth(32); ButtonBlurMask.setArcHeight(32);
        BackgroundMask.setClip(ButtonBlurMask);
        BackgroundMask.setEffect(new BoxBlur(8,16, 4));

        StartButtonBox=new Rectangle(32, 424, 200, 32);
        StartButtonBox.setArcWidth(32); StartButtonBox.setArcHeight(32);
        Stop GradientStops[]={new Stop(0, Color.rgb(249, 252, 247, 0.6)), new Stop(1, Color.rgb(252, 247, 247, 0.6))};
        StartButtonBox.setFill(new LinearGradient(132, 424, 132, 456, true, CycleMethod.NO_CYCLE, GradientStops));
        StartButtonBox.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 8, 0, 0, 6));

        StartButtonTextLeft=new Text("-");
        StartButtonTextLeft.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
        StartButtonTextLeft.setFill(Color1);
        StartButtonTextRight=new Text("-");
        StartButtonTextRight.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
        StartButtonTextRight.setFill(Color1);
        StartButtonTextMain=new FormattedText("Join us on an amazing journey!", -1.0, 0, true);
        StartButtonTextMain.setPrefWrapLength(165);
        StartButtonTextMain.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
        StartButtonTextMain.setFill(Color1);
        StartButtonText=new HBox(StartButtonTextLeft, StartButtonTextMain, StartButtonTextRight);
        StartButtonText.setLayoutX(45); StartButtonText.setLayoutY(433);

        StartButtonFrame=new Button();
        StartButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 18px;");
        StartButtonFrame.setLayoutX(32); StartButtonFrame.setLayoutY(424);
        StartButtonFrame.setPrefWidth(200); StartButtonFrame.setPrefHeight(32);
        StartButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {getScene().setRoot(new HomePage(customer, drink));}
            }
        );

        StartButton=new Pane(BackgroundMask, StartButtonBox, StartButtonText,StartButtonFrame);

        //Layout:
        this.getChildren().addAll(Background, PageTitle, Quote, StartButton);
        this.setLayoutX(0); this.setLayoutY(0);
    }

    //Constructor:
    public StartPage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}