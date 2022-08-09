package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkConst;
import com.example.cuoiki.Drink.DrinkDetails;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.FormattedText;
import com.example.cuoiki.Formatting.CustomFont;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class MenuPage extends Pane
{
    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageTitle, PageQuote;
    private Pane BubbleTea;
    private Pane BubbleTeaTitle;
    private FormattedText BubbleTeaTitleText;
    private Pane BubbleTeaMenu;
    private Rectangle BubbleTeaMenuHolder;
    private ImageView BubbleTeaMenuImage;
    private Pane FreshTea;
    private Pane FreshTeaTitle;
    private FormattedText FreshTeaTitleText;
    private Pane FreshTeaMenu;
    private Rectangle FreshTeaMenuHolder;
    private ImageView FreshTeaMenuImage;
    private Pane Coffee;
    private Pane CoffeeTitle;
    private FormattedText CoffeeTitleText;
    private Pane CoffeeMenu;
    private Rectangle CoffeeMenuHolder;
    private ImageView CoffeeMenuImage;
    private Pane Caramel;
    private Pane CaramelTitle;
    private FormattedText CaramelTitleText;
    private Pane CaramelMenu;
    private Rectangle CaramelMenuHolder;
    private ImageView CaramelMenuImage;
    private Pane Toppings;
    private Pane ToppingsTitle;
    private FormattedText ToppingsTitleText;
    private Pane ToppingsMenu;
    private Rectangle ToppingsMenuHolder;
    private ImageView ToppingsMenuImage;
    private VBox BubbleTeaSelectButtons;
    private Button BubbleTea_Lychee, BubbleTea_Squash, BubbleTea_Strawberry, BubbleTea_Taro, BubbleTea_Mint, BubbleTea_Matcha, BubbleTea_Chocolate, BubbleTea_Almond, BubbleTea_Kiwi, BubbleTea_Honey, BubbleTea_Peach;
    private VBox FreshTeaSelectButtons;
    private Button FreshTea_White, FreshTea_Green, FreshTea_LotusGreen, FreshTea_Oolong, FreshTea_Black, FreshTea_Jasmine, FreshTea_Matcha;
    private VBox CoffeeSelectButtons;
    private Button Coffee_PureBlack, Coffee_Phin, Coffee_Milk, Coffee_Espresso;
    private VBox CaramelSelectButtons;
    private Button Caramel_Apple, Caramel_Chocolate, Caramel_Milk, Caramel_Coffee, Caramel_Orange, Caramel_Bourbon, Caramel_Machiatto, Caramel_Seasalted;
    private VBox ToppingsSelectButtons;
    private Button Toppings_MilkPudding, Toppings_CoffeePudding, Toppings_MatchaPudding, Toppings_FlanPudding, Toppings_AloeVeraJelly, Toppings_AgarJelly, Toppings_Popball, Toppings_ChineseMilkFoam;
    private Pane DrinkAdding;
    private Rectangle BlurredPane;
    private Rectangle DrinkAddingHolder;
    private FormattedText DrinkAddingTitle;
    private HBox ButtonTitle;
    private FormattedText AddButtonTitle, CancelButtonTitle;
    private VBox DrinkPriceTag;
    private Pane MPriceTag, LPriceTag, PriceTag;
    private FormattedText MPriceTagTitle, LPriceTagTitle, PriceTagTitle;
    private HBox NavigateButtons;
    private Button AddDrinkButtonFrame, CancelDrinkButtonFrame;
    private VBox MPriceButtons;
    private Button MPriceIncreaseButtonFrame, MPriceDecreaseButtonFrame;
    private VBox LPriceButtons;
    private Button LPriceIncreaseButtonFrame, LPriceDecreaseButtonFrame;
    private Pane ButtonsLayout;
    private FormattedText PickedDrinkTitle;
    private Text MDrinkCountText, LDrinkCountText, PriceCountText;
    private Pane BlurBox;
    private Pane BlankSpace;

    private UserInformation customer;
    private DrinkMap drink;
    private DecimalFormat DoubleFormatter=new DecimalFormat("0.00");
    private final Color TextColor=Color.rgb(71, 43, 43, 1.0);
    private final Color TextColor2=Color.rgb(252, 247, 247);

    private class Menu extends Pane
    {
        private VBox DrinkMenu=new VBox(4);

        private final Color TextColor=Color.rgb(71, 43, 43, 1.0);

        public void insertDrink(String Name, String MPrice, String LPrice)
        {
            Polygon Triangle=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
            Triangle.setFill(TextColor);
            Triangle.setLayoutX(0); Triangle.setLayoutY(13.5);

            FormattedText DrinkName=new FormattedText(Name, -0.5, 0, false);
            DrinkName.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 9));
            DrinkName.setFill(TextColor);
            DrinkName.setLayoutX(8); DrinkName.setLayoutY(11);

            FormattedText DrinkMPrice=new FormattedText(MPrice, -1.0, 0, false);
            DrinkMPrice.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 9));
            DrinkMPrice.setFill(TextColor);
            DrinkMPrice.setLayoutX(119); DrinkMPrice.setLayoutY(11);

            FormattedText DrinkLPrice=new FormattedText(LPrice, -1.0, 0, false);
            DrinkLPrice.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 9));
            DrinkLPrice.setFill(TextColor);
            DrinkLPrice.setLayoutX(167); DrinkLPrice.setLayoutY(11);

            Pane DrinkInfo=new Pane(Triangle, DrinkName, DrinkMPrice, DrinkLPrice);
            DrinkInfo.setPrefWidth(196); DrinkInfo.setPrefHeight(15);

            DrinkMenu.getChildren().add(DrinkInfo);
        }

        public Menu()
        {
            FormattedText Name=new FormattedText("Drink Name", -1.0, 0, true);
            Name.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
            Name.setFill(TextColor);
            Name.setLayoutX(3); Name.setLayoutY(4);

            FormattedText MPrice=new FormattedText("M", -1.0, 0, true);
            MPrice.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
            MPrice.setFill(TextColor);
            MPrice.setLayoutX(126); MPrice.setLayoutY(4);

            FormattedText LPrice=new FormattedText("L", -1.0, 0, true);
            LPrice.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
            LPrice.setFill(TextColor);
            LPrice.setLayoutX(176); LPrice.setLayoutY(4);

            Pane Tag=new Pane(Name, MPrice, LPrice);
            DrinkMenu.setLayoutX(0); DrinkMenu.setLayoutY(15);
            this.getChildren().addAll(Tag, DrinkMenu);
            this.setLayoutX(12); this.setLayoutY(128);
        }
    }

    //AddDrink:
    private void addDrink(DrinkConst drinkconst)
    {
        DrinkDetails drinkdetail=drink.get(drinkconst);
        UserInformation.ReceiptDraft pricedraft=new UserInformation.ReceiptDraft(drinkdetail.getDrinkImage(), drinkdetail.getDrinkType(), drinkdetail.getDrinkName());

        PickedDrinkTitle=new FormattedText(drinkdetail.getDrinkType()+":  "+drinkdetail.getDrinkName(), -1.0, 0, false);
        PickedDrinkTitle.setPrefWidth(140);
        PickedDrinkTitle.setFill(TextColor2);
        PickedDrinkTitle.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 10));
        PickedDrinkTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10), 1, (drinkdetail.getDrinkType()+": ").length());
        PickedDrinkTitle.setLayoutX(66);PickedDrinkTitle.setLayoutY(231);
        DrinkAdding.getChildren().add(PickedDrinkTitle);

        MDrinkCountText=new Text("0");
        MDrinkCountText.setFill(TextColor2);
        MDrinkCountText.setFont(CustomFont.createFont("SFProText - Regular", "otf", 10));
        MDrinkCountText.setWrappingWidth(20);
        MDrinkCountText.setTextAlignment(TextAlignment.RIGHT);
        MDrinkCountText.setLayoutX(100); MDrinkCountText.setLayoutY(11);
        MPriceTag.getChildren().add(MDrinkCountText);

        LDrinkCountText=new Text("0");
        LDrinkCountText.setFill(TextColor2);
        LDrinkCountText.setFont(CustomFont.createFont("SFProText - Regular", "otf", 10));
        LDrinkCountText.setWrappingWidth(20);
        LDrinkCountText.setTextAlignment(TextAlignment.RIGHT);
        LDrinkCountText.setLayoutX(100); LDrinkCountText.setLayoutY(11);
        LPriceTag.getChildren().add(LDrinkCountText);

        PriceCountText=new Text("$0.00");
        PriceCountText.setFill(TextColor2);
        PriceCountText.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 11));
        PriceCountText.setWrappingWidth(60);
        PriceCountText.setTextAlignment(TextAlignment.RIGHT);
        PriceCountText.setLayoutX(56); PriceCountText.setLayoutY(9.5);
        PriceTag.getChildren().add(PriceCountText);

        AddDrinkButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    customer.addtoReceipt(drinkconst, pricedraft);
                    deleteAddDrinkPane();
                }
            }
        );

        CancelDrinkButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteAddDrinkPane();}
            }
        );

        MPriceIncreaseButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(drinkdetail.getMPrice()!=0)
                    {
                        if(pricedraft.MCount<99)
                        {
                            MDrinkCountText.setText(Integer.toString(++pricedraft.MCount));
                            pricedraft.Price=pricedraft.MCount*drinkdetail.getMPrice()+pricedraft.LCount*drinkdetail.getLPrice();
                            PriceCountText.setText("$"+DoubleFormatter.format(pricedraft.Price));
                        }
                    }
                }
            }
        );

        MPriceDecreaseButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(drinkdetail.getMPrice()!=0)
                    {
                        if(pricedraft.MCount>0)
                        {
                            MDrinkCountText.setText(Integer.toString(--pricedraft.MCount));
                            pricedraft.Price=pricedraft.MCount*drinkdetail.getMPrice()+pricedraft.LCount*drinkdetail.getLPrice();
                            PriceCountText.setText("$"+DoubleFormatter.format(pricedraft.Price));
                        }
                    }
                }
            }
        );

        LPriceIncreaseButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(drinkdetail.getLPrice()!=0)
                    {
                        if(pricedraft.LCount<99)
                        {
                            LDrinkCountText.setText(Integer.toString(++pricedraft.LCount));
                            pricedraft.Price=pricedraft.MCount*drinkdetail.getMPrice()+pricedraft.LCount*drinkdetail.getLPrice();
                            PriceCountText.setText("$"+DoubleFormatter.format(pricedraft.Price));
                        }
                    }
                }
            }
        );

        LPriceDecreaseButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(drinkdetail.getLPrice()!=0)
                    {
                        if(pricedraft.LCount>0)
                        {
                            LDrinkCountText.setText(Integer.toString(--pricedraft.LCount));
                            pricedraft.Price=pricedraft.MCount*drinkdetail.getMPrice()+pricedraft.LCount*drinkdetail.getLPrice();
                            PriceCountText.setText("$"+DoubleFormatter.format(pricedraft.Price));
                        }
                    }
                }
            }
        );

        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(DrinkAdding);
    }

    private void deleteAddDrinkPane()
    {
        AddDrinkButtonFrame.setOnAction(null);
        CancelDrinkButtonFrame.setOnAction(null);
        MPriceIncreaseButtonFrame.setOnAction(null);
        MPriceDecreaseButtonFrame.setOnAction(null);
        LPriceIncreaseButtonFrame.setOnAction(null);
        LPriceDecreaseButtonFrame.setOnAction(null);
        DrinkAdding.getChildren().remove(9);
        PickedDrinkTitle=null;
        MDrinkCountText=null;
        MPriceTag.getChildren().remove(4);
        LDrinkCountText=null;
        LPriceTag.getChildren().remove(4);
        PriceCountText=null;
        PriceTag.getChildren().remove(1);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        //SetCustomer:
        this.customer=customer;
        this.drink=drink;

        //SelectDrink:
        Stop GradientStops[]={new Stop(0, Color.rgb(252, 247, 247, 0.6)), new Stop(1, Color.rgb(252, 252, 249, 0.7))};
        BlurredPane=new Rectangle(264, 528, new LinearGradient(132, 0, 132, 528, true, CycleMethod.NO_CYCLE, GradientStops));
        BlurredPane.setLayoutX(0); BlurredPane.setLayoutY(0);

        DrinkAddingHolder=new Rectangle(168, 176, Color.rgb(71, 43, 43, 0.9));
        DrinkAddingHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.25), 10, 0, 0, 6));
        DrinkAddingHolder.setArcWidth(32); DrinkAddingHolder.setArcHeight(32);
        DrinkAddingHolder.setLayoutX(48); DrinkAddingHolder.setLayoutY(176);

        DrinkAddingTitle=new FormattedText("Add this drink", -1.0, 0, false);
        DrinkAddingTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        DrinkAddingTitle.setFill(TextColor2);
        DrinkAddingTitle.setLayoutX(64); DrinkAddingTitle.setLayoutY(192);

        Rectangle DrinkAddingUpperLine=new Rectangle(136, 1, TextColor2);
        DrinkAddingUpperLine.setLayoutX(64); DrinkAddingUpperLine.setLayoutY(219.5);
        Rectangle DrinkAddingLowerLine=new Rectangle(136, 1, TextColor2);
        DrinkAddingLowerLine.setLayoutX(64); DrinkAddingLowerLine.setLayoutY(311.5);

        Polygon MPricePointer=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        MPricePointer.setFill(TextColor2);
        MPricePointer.setLayoutX(0); MPricePointer.setLayoutY(6);
        MPriceTagTitle=new FormattedText("Size M :", -1.0, 0, false);
        MPriceTagTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        MPriceTagTitle.setFill(TextColor2);
        MPriceTagTitle.setLayoutX(8); MPriceTagTitle.setLayoutY(2.5);
        Polygon MNumberIncrease=new Polygon(2.5, 0.0, 0.0, 3.0, 5.0, 3.0);
        MNumberIncrease.setFill(TextColor2);
        MNumberIncrease.setLayoutX(123); MNumberIncrease.setLayoutY(3.5);
        Polygon MNumberDecrease=new Polygon(0.0, 0.0, 5.0, 0.0, 2.5, 3.0);
        MNumberDecrease.setFill(TextColor2);
        MNumberDecrease.setLayoutX(123); MNumberDecrease.setLayoutY(9.5);
        MPriceTag=new Pane(MPricePointer, MPriceTagTitle, MNumberIncrease, MNumberDecrease);
        MPriceTag.setPrefWidth(128); MPriceTag.setPrefHeight(16);

        Polygon LPricePointer=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        LPricePointer.setFill(TextColor2);
        LPricePointer.setLayoutX(0); LPricePointer.setLayoutY(6);
        LPriceTagTitle=new FormattedText("Size L :", -1.0, 0, false);
        LPriceTagTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        LPriceTagTitle.setFill(TextColor2);
        LPriceTagTitle.setLayoutX(8); LPriceTagTitle.setLayoutY(2.5);
        Polygon LNumberIncrease=new Polygon(2.5, 0.0, 0.0, 3.0, 5.0, 3.0);
        LNumberIncrease.setFill(TextColor2);
        LNumberIncrease.setLayoutX(123); LNumberIncrease.setLayoutY(3.5);
        Polygon LNumberDecrease=new Polygon(0.0, 0.0, 5.0, 0.0, 2.5, 3.0);
        LNumberDecrease.setFill(TextColor2);
        LNumberDecrease.setLayoutX(123); LNumberDecrease.setLayoutY(9.5);
        LPriceTag=new Pane(LPricePointer, LPriceTagTitle, LNumberIncrease, LNumberDecrease);
        LPriceTag.setPrefWidth(128); LPriceTag.setPrefHeight(16);

        PriceTagTitle=new FormattedText("Price :", -1.0, 0, false);
        PriceTagTitle.setPrefWidth(40);
        PriceTagTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        PriceTagTitle.setFill(TextColor2);
        PriceTag=new Pane(PriceTagTitle);
        PriceTag.setLayoutX(80); PriceTag.setLayoutY(290.5);

        DrinkPriceTag=new VBox(4, MPriceTag, LPriceTag);
        DrinkPriceTag.setLayoutX(72); DrinkPriceTag.setLayoutY(248);

        AddButtonTitle=new FormattedText("Add", -1.0, 0, true);
        AddButtonTitle.setPrefWidth(25);
        AddButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        AddButtonTitle.setFill(TextColor2);
        CancelButtonTitle=new FormattedText("Cancel", -1.0, 0, true);
        CancelButtonTitle.setPrefWidth(36);
        CancelButtonTitle.setFill(TextColor2);
        CancelButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        ButtonTitle=new HBox(44, AddButtonTitle, CancelButtonTitle);
        ButtonTitle.setLayoutX(80); ButtonTitle.setLayoutY(322);

        AddDrinkButtonFrame=new Button();
        AddDrinkButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        AddDrinkButtonFrame.setMinWidth(23); AddDrinkButtonFrame.setMinHeight(13); AddDrinkButtonFrame.setPrefWidth(23); AddDrinkButtonFrame.setPrefHeight(13);
        CancelDrinkButtonFrame=new Button();
        CancelDrinkButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        CancelDrinkButtonFrame.setMinHeight(36); CancelDrinkButtonFrame.setMinHeight(13); CancelDrinkButtonFrame.setPrefWidth(36); CancelDrinkButtonFrame.setPrefHeight(13);
        NavigateButtons=new HBox(47, AddDrinkButtonFrame, CancelDrinkButtonFrame);
        NavigateButtons.setLayoutX(79); NavigateButtons.setLayoutY(322);

        MPriceIncreaseButtonFrame=new Button();
        MPriceIncreaseButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        MPriceIncreaseButtonFrame.setMinWidth(7); MPriceIncreaseButtonFrame.setMinHeight(5); MPriceIncreaseButtonFrame.setPrefWidth(7); MPriceIncreaseButtonFrame.setPrefHeight(5);
        MPriceDecreaseButtonFrame=new Button();
        MPriceDecreaseButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        MPriceDecreaseButtonFrame.setMinWidth(7); MPriceDecreaseButtonFrame.setMinHeight(5); MPriceDecreaseButtonFrame.setPrefWidth(7); MPriceDecreaseButtonFrame.setPrefHeight(5);
        MPriceButtons=new VBox(2, MPriceIncreaseButtonFrame, MPriceDecreaseButtonFrame);
        MPriceButtons.setLayoutX(194); MPriceButtons.setLayoutY(249.5);

        LPriceIncreaseButtonFrame=new Button();
        LPriceIncreaseButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        LPriceIncreaseButtonFrame.setMinWidth(7); LPriceIncreaseButtonFrame.setMinHeight(5); LPriceIncreaseButtonFrame.setPrefWidth(7); LPriceIncreaseButtonFrame.setPrefHeight(5);
        LPriceDecreaseButtonFrame=new Button();
        LPriceDecreaseButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        LPriceDecreaseButtonFrame.setMinWidth(7); LPriceDecreaseButtonFrame.setMinHeight(5); LPriceDecreaseButtonFrame.setPrefWidth(7); LPriceDecreaseButtonFrame.setPrefHeight(5);
        LPriceButtons=new VBox(2, LPriceIncreaseButtonFrame, LPriceDecreaseButtonFrame);
        LPriceButtons.setLayoutX(194); LPriceButtons.setLayoutY(269.5);

        ButtonsLayout=new Pane(NavigateButtons, MPriceButtons, LPriceButtons);
        ButtonsLayout.setPrefWidth(264); ButtonsLayout.setPrefHeight(528);
        ButtonsLayout.setLayoutX(0); ButtonsLayout.setLayoutY(0);

        DrinkAdding=new Pane(BlurredPane, DrinkAddingHolder, DrinkAddingTitle, DrinkAddingUpperLine, DrinkAddingLowerLine, ButtonTitle, DrinkPriceTag, PriceTag, ButtonsLayout);
        DrinkAdding.setPrefWidth(264); DrinkAdding.setPrefHeight(528);
        DrinkAdding.setLayoutX(0); DrinkAdding.setLayoutY(0);
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
        PageTitle=new FormattedText("Menu", -1.0, 0, false);
        PageTitle.setFont(CustomFont.createFont("Raleway - ExtraBold", "ttf", 28));
        PageTitle.setPrefWrapLength(170);
        PageTitle.setFill(TextColor);
        PageTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 4, 0, 0, 4));
        PageTitle.setLayoutX(23); PageTitle.setLayoutY(44);

        //PageQuote:
        PageQuote=new FormattedText("The world of drinks is here. Go pick one!", -1.0, 1.0, false);
        PageQuote.setFont(CustomFont.createFont("Raleway - SemiBoldItalic", "ttf", 12));
        PageQuote.setPrefWrapLength(148);
        PageQuote.setFill(TextColor);
        PageQuote.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        PageQuote.setLayoutX(23); PageQuote.setLayoutY(84);

        //BubbleTea:
        BubbleTeaTitleText=new FormattedText("Bubble Tea", -1.0, 0, false);
        BubbleTeaTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        BubbleTeaTitleText.setFill(TextColor);
        BubbleTeaTitleText.setLayoutX(12); BubbleTeaTitleText.setLayoutY(1);
        Rectangle BubbleTeaLeftLine=new Rectangle(12, 1, TextColor);
        BubbleTeaLeftLine.setLayoutX(0); BubbleTeaLeftLine.setLayoutY(11);
        Rectangle BubbleTeaRightLine=new Rectangle(134, 1, TextColor);
        BubbleTeaRightLine.setLayoutX(98); BubbleTeaRightLine.setLayoutY(11);
        BubbleTeaTitle=new Pane(BubbleTeaLeftLine, BubbleTeaTitleText, BubbleTeaRightLine);
        BubbleTeaTitle.setPrefWidth(264);
        BubbleTeaTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        BubbleTeaTitle.setLayoutX(0); BubbleTeaTitle.setLayoutY(2);

        BubbleTeaMenuHolder=new Rectangle(216, 372, Color.rgb(252, 255, 249));
        BubbleTeaMenuHolder.setArcWidth(32); BubbleTeaMenuHolder.setArcHeight(32);
        BubbleTeaMenuHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        BubbleTeaMenuHolder.setLayoutX(0); BubbleTeaMenuHolder.setLayoutY(0);

        BubbleTeaMenuImage=new ImageView();
        try {BubbleTeaMenuImage.setImage(new Image(new FileInputStream("materials/image/BubbleTea.png")));}
        catch(FileNotFoundException f) {}
        BubbleTeaMenuImage.setFitWidth(216); BubbleTeaMenuImage.setFitHeight(120);
        BubbleTeaMenuImage.setSmooth(true);
        BubbleTeaMenuImage.setCache(true);
        BubbleTeaMenuImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 4, 0, 0, 4));
        BubbleTeaMenuImage.setLayoutX(0); BubbleTeaMenuImage.setLayoutY(0);

        Menu BubbleTeaPriceMenu=new Menu();
        BubbleTeaPriceMenu.insertDrink("Lychee","$2.30","$2.50");
        BubbleTeaPriceMenu.insertDrink("Squash","$1.80","$2.00");
        BubbleTeaPriceMenu.insertDrink("Strawberry","$2.70","$3.00");
        BubbleTeaPriceMenu.insertDrink("Taro","$2.20","$2.40");
        BubbleTeaPriceMenu.insertDrink("Mint","$2.10","$2.30");
        BubbleTeaPriceMenu.insertDrink("Matcha","$2.40","$2.70");
        BubbleTeaPriceMenu.insertDrink("Chocolate","$2.40","$2.70");
        BubbleTeaPriceMenu.insertDrink("Almond","$2.60","$2.90");
        BubbleTeaPriceMenu.insertDrink("Kiwi","$1.50","$1.70");
        BubbleTeaPriceMenu.insertDrink("Honey","$1.90","$2.10");
        BubbleTeaPriceMenu.insertDrink("Peach","$1.70","$2.00");
        
        BubbleTea_Lychee=new Button();
        BubbleTea_Lychee.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Lychee.setMinHeight(12); BubbleTea_Lychee.setPrefWidth(88); BubbleTea_Lychee.setPrefHeight(12);
        BubbleTea_Lychee.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Lychee);}
            }
        );
        BubbleTea_Squash=new Button();
        BubbleTea_Squash.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Squash.setMinHeight(12); BubbleTea_Squash.setPrefWidth(88); BubbleTea_Squash.setPrefHeight(12);
        BubbleTea_Squash.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Squash);}
            }
        );
        BubbleTea_Strawberry=new Button();
        BubbleTea_Strawberry.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Strawberry.setMinHeight(12); BubbleTea_Strawberry.setPrefWidth(88); BubbleTea_Strawberry.setPrefHeight(12);
        BubbleTea_Strawberry.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Strawberry);}
            }
        );
        BubbleTea_Taro=new Button();
        BubbleTea_Taro.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Taro.setMinHeight(12); BubbleTea_Taro.setPrefWidth(88); BubbleTea_Taro.setPrefHeight(12);
        BubbleTea_Taro.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Taro);}
            }
        );
        BubbleTea_Mint=new Button();
        BubbleTea_Mint.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Mint.setMinHeight(12); BubbleTea_Mint.setPrefWidth(88); BubbleTea_Mint.setPrefHeight(12);
        BubbleTea_Mint.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Mint);}
            }
        );
        BubbleTea_Matcha=new Button();
        BubbleTea_Matcha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Matcha.setMinHeight(12); BubbleTea_Matcha.setPrefWidth(88); BubbleTea_Matcha.setPrefHeight(12);
        BubbleTea_Matcha.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Matcha);}
            }
        );
        BubbleTea_Chocolate=new Button();
        BubbleTea_Chocolate.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Chocolate.setMinHeight(12); BubbleTea_Chocolate.setPrefWidth(88); BubbleTea_Chocolate.setPrefHeight(12);
        BubbleTea_Chocolate.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Chocolate);}
            }
        );
        BubbleTea_Almond=new Button();
        BubbleTea_Almond.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Almond.setMinHeight(12); BubbleTea_Almond.setPrefWidth(88); BubbleTea_Almond.setPrefHeight(12);
        BubbleTea_Almond.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Almond);}
            }
        );
        BubbleTea_Kiwi=new Button();
        BubbleTea_Kiwi.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Kiwi.setMinHeight(12); BubbleTea_Kiwi.setPrefWidth(88); BubbleTea_Kiwi.setPrefHeight(12);
        BubbleTea_Kiwi.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Kiwi);}
            }
        );
        BubbleTea_Honey=new Button();
        BubbleTea_Honey.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Honey.setMinHeight(12); BubbleTea_Honey.setPrefWidth(88); BubbleTea_Honey.setPrefHeight(12);
        BubbleTea_Honey.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Honey);}
            }
        );
        BubbleTea_Peach=new Button();
        BubbleTea_Peach.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        BubbleTea_Peach.setMinHeight(12); BubbleTea_Peach.setPrefWidth(88); BubbleTea_Peach.setPrefHeight(12);
        BubbleTea_Peach.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.BUBBLETEA_Peach);}
            }
        );
        BubbleTeaSelectButtons=new VBox(7, BubbleTea_Lychee, BubbleTea_Squash, BubbleTea_Strawberry, BubbleTea_Taro, BubbleTea_Mint, BubbleTea_Matcha, BubbleTea_Chocolate, BubbleTea_Almond, BubbleTea_Kiwi, BubbleTea_Honey, BubbleTea_Peach);
        BubbleTeaSelectButtons.setLayoutX(16); BubbleTeaSelectButtons.setLayoutY(152);

        BubbleTeaMenu=new Pane(BubbleTeaMenuHolder, BubbleTeaMenuImage, BubbleTeaPriceMenu, BubbleTeaSelectButtons);
        BubbleTeaMenu.setLayoutX(8); BubbleTeaMenu.setLayoutY(40);

        BubbleTea=new Pane(BubbleTeaTitle, BubbleTeaMenu);
        BubbleTea.setPrefWidth(232); BubbleTea.setPrefHeight(412);
        BubbleTea.setLayoutX(16); BubbleTea.setLayoutY(150);

        //FreshTea:
        FreshTeaTitleText=new FormattedText("Fresh Tea", -1.0, 0, false);
        FreshTeaTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        FreshTeaTitleText.setFill(TextColor);
        FreshTeaTitleText.setLayoutX(12); FreshTeaTitleText.setLayoutY(1);
        Rectangle FreshTeaLeftLine=new Rectangle(12, 1, TextColor);
        FreshTeaLeftLine.setLayoutX(0); FreshTeaLeftLine.setLayoutY(11);
        Rectangle FreshTeaRightLine=new Rectangle(147, 1, TextColor);
        FreshTeaRightLine.setLayoutX(85); FreshTeaRightLine.setLayoutY(11);
        FreshTeaTitle=new Pane(FreshTeaLeftLine, FreshTeaTitleText, FreshTeaRightLine);
        FreshTeaTitle.setPrefWidth(264);
        FreshTeaTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        FreshTeaTitle.setLayoutX(0); FreshTeaTitle.setLayoutY(2);

        FreshTeaMenuHolder=new Rectangle(216, 294, Color.rgb(252, 255, 249));
        FreshTeaMenuHolder.setArcWidth(32); FreshTeaMenuHolder.setArcHeight(32);
        FreshTeaMenuHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        FreshTeaMenuHolder.setLayoutX(0); FreshTeaMenuHolder.setLayoutY(0);

        FreshTeaMenuImage=new ImageView();
        try {FreshTeaMenuImage.setImage(new Image(new FileInputStream("materials/image/FreshTea.png")));}
        catch(FileNotFoundException f) {}
        FreshTeaMenuImage.setFitWidth(216); FreshTeaMenuImage.setFitHeight(120);
        FreshTeaMenuImage.setSmooth(true);
        FreshTeaMenuImage.setCache(true);
        FreshTeaMenuImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 4, 0, 0, 4));
        FreshTeaMenuImage.setLayoutX(0); FreshTeaMenuImage.setLayoutY(0);

        Menu FreshTeaPriceMenu=new Menu();
        FreshTeaPriceMenu.insertDrink("White","     x","$4.10");
        FreshTeaPriceMenu.insertDrink("Green","$2.80","$3.20");
        FreshTeaPriceMenu.insertDrink("Lotus Green","$6.30","$6.80");
        FreshTeaPriceMenu.insertDrink("Oolong","     x","$3.60");
        FreshTeaPriceMenu.insertDrink("Black","     x","$4.10");
        FreshTeaPriceMenu.insertDrink("Jasmine","$5.50","$5.80");
        FreshTeaPriceMenu.insertDrink("Matcha","$3.00","$3.30");

        FreshTea_White=new Button();
        FreshTea_White.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_White.setMinHeight(12); FreshTea_White.setPrefWidth(88); FreshTea_White.setPrefHeight(12);
        FreshTea_White.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_White);}
            }
        );
        FreshTea_Green=new Button();
        FreshTea_Green.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_Green.setMinHeight(12); FreshTea_Green.setPrefWidth(88); FreshTea_Green.setPrefHeight(12);
        FreshTea_Green.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_Green);}
            }
        );
        FreshTea_LotusGreen=new Button();
        FreshTea_LotusGreen.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_LotusGreen.setMinHeight(12); FreshTea_LotusGreen.setPrefWidth(88); FreshTea_LotusGreen.setPrefHeight(12);
        FreshTea_LotusGreen.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_LotusGreen);}
            }
        );
        FreshTea_Oolong=new Button();
        FreshTea_Oolong.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_Oolong.setMinHeight(12); FreshTea_Oolong.setPrefWidth(88); FreshTea_Oolong.setPrefHeight(12);
        FreshTea_Oolong.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_Oolong);}
            }
        );
        FreshTea_Black=new Button();
        FreshTea_Black.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_Black.setMinHeight(12); FreshTea_Black.setPrefWidth(88); FreshTea_Black.setPrefHeight(12);
        FreshTea_Black.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_Black);}
            }
        );
        FreshTea_Jasmine=new Button();
        FreshTea_Jasmine.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_Jasmine.setMinHeight(12); FreshTea_Jasmine.setPrefWidth(88); FreshTea_Jasmine.setPrefHeight(12);
        FreshTea_Jasmine.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_Jasmine);}
            }
        );
        FreshTea_Matcha=new Button();
        FreshTea_Matcha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FreshTea_Matcha.setMinHeight(12); FreshTea_Matcha.setPrefWidth(88); FreshTea_Matcha.setPrefHeight(12);
        FreshTea_Matcha.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.FRESHTEA_Matcha);}
            }
        );
        FreshTeaSelectButtons=new VBox(7, FreshTea_White, FreshTea_Green, FreshTea_LotusGreen, FreshTea_Oolong, FreshTea_Black, FreshTea_Jasmine, FreshTea_Matcha);
        FreshTeaSelectButtons.setLayoutX(16); FreshTeaSelectButtons.setLayoutY(152);

        FreshTeaMenu=new Pane(FreshTeaMenuHolder, FreshTeaMenuImage, FreshTeaPriceMenu, FreshTeaSelectButtons);
        FreshTeaMenu.setLayoutX(8); FreshTeaMenu.setLayoutY(40);

        FreshTea=new Pane(FreshTeaTitle, FreshTeaMenu);
        FreshTea.setPrefWidth(232); FreshTea.setPrefHeight(334);
        FreshTea.setLayoutX(16); FreshTea.setLayoutY(586);

        //Coffee:
        CoffeeTitleText=new FormattedText("Coffee", -1.0, 0, false);
        CoffeeTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        CoffeeTitleText.setFill(TextColor);
        CoffeeTitleText.setLayoutX(12); CoffeeTitleText.setLayoutY(1);
        Rectangle CoffeeLeftLine=new Rectangle(12, 1, TextColor);
        CoffeeLeftLine.setLayoutX(0); CoffeeLeftLine.setLayoutY(11);
        Rectangle CoffeeRightLine=new Rectangle(169, 1, TextColor);
        CoffeeRightLine.setLayoutX(63); CoffeeRightLine.setLayoutY(11);
        CoffeeTitle=new Pane(CoffeeLeftLine, CoffeeTitleText, CoffeeRightLine);
        CoffeeTitle.setPrefWidth(264);
        CoffeeTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        CoffeeTitle.setLayoutX(0); CoffeeTitle.setLayoutY(2);

        CoffeeMenuHolder=new Rectangle(216, 238, Color.rgb(252, 255, 249));
        CoffeeMenuHolder.setArcWidth(32); CoffeeMenuHolder.setArcHeight(32);
        CoffeeMenuHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        CoffeeMenuHolder.setLayoutX(0); CoffeeMenuHolder.setLayoutY(0);

        CoffeeMenuImage=new ImageView();
        try {CoffeeMenuImage.setImage(new Image(new FileInputStream("materials/image/Coffee.png")));}
        catch(FileNotFoundException f) {}
        CoffeeMenuImage.setFitWidth(216); CoffeeMenuImage.setFitHeight(120);
        CoffeeMenuImage.setSmooth(true);
        CoffeeMenuImage.setCache(true);
        CoffeeMenuImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 4, 0, 0, 4));
        CoffeeMenuImage.setLayoutX(0); CoffeeMenuImage.setLayoutY(0);

        Menu CoffeePriceMenu=new Menu();
        CoffeePriceMenu.insertDrink("Pure Black","$1.40","     x");
        CoffeePriceMenu.insertDrink("Phin","$1.90","     x");
        CoffeePriceMenu.insertDrink("Milk","$2.10","     x");
        CoffeePriceMenu.insertDrink("Espresso","     x","$2.00");

        Coffee_PureBlack=new Button();
        Coffee_PureBlack.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Coffee_PureBlack.setMinHeight(12); Coffee_PureBlack.setPrefWidth(88); Coffee_PureBlack.setPrefHeight(12);
        Coffee_PureBlack.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.COFFEE_PureBlack);}
            }
        );
        Coffee_Phin=new Button();
        Coffee_Phin.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Coffee_Phin.setMinHeight(12); Coffee_Phin.setPrefWidth(88); Coffee_Phin.setPrefHeight(12);
        Coffee_Phin.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.COFFEE_Phin);}
            }
        );
        Coffee_Milk=new Button();
        Coffee_Milk.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Coffee_Milk.setMinHeight(12); Coffee_Milk.setPrefWidth(88); Coffee_Milk.setPrefHeight(12);
        Coffee_Milk.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.COFFEE_Milk);}
            }
        );
        Coffee_Espresso=new Button();
        Coffee_Espresso.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Coffee_Espresso.setMinHeight(12); Coffee_Espresso.setPrefWidth(88); Coffee_Espresso.setPrefHeight(12);
        Coffee_Espresso.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.COFFEE_Espresso);}
            }
        );
        CoffeeSelectButtons=new VBox(7, Coffee_PureBlack, Coffee_Phin, Coffee_Milk, Coffee_Espresso);
        CoffeeSelectButtons.setLayoutX(16); CoffeeSelectButtons.setLayoutY(152);
        
        CoffeeMenu=new Pane(CoffeeMenuHolder, CoffeeMenuImage, CoffeePriceMenu, CoffeeSelectButtons);
        CoffeeMenu.setLayoutX(8); CoffeeMenu.setLayoutY(40);

        Coffee=new Pane(CoffeeTitle, CoffeeMenu);
        Coffee.setPrefWidth(232); Coffee.setPrefHeight(278);
        Coffee.setLayoutX(16); Coffee.setLayoutY(944);

        //Caramel:
        CaramelTitleText=new FormattedText("Caramel", -1.0, 0, false);
        CaramelTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        CaramelTitleText.setFill(TextColor);
        CaramelTitleText.setLayoutX(12); CaramelTitleText.setLayoutY(1);
        Rectangle CaramelLeftLine=new Rectangle(12, 1, TextColor);
        CaramelLeftLine.setLayoutX(0); CaramelLeftLine.setLayoutY(11);
        Rectangle CaramelRightLine=new Rectangle(156, 1, TextColor);
        CaramelRightLine.setLayoutX(76); CaramelRightLine.setLayoutY(11);
        CaramelTitle=new Pane(CaramelLeftLine, CaramelTitleText, CaramelRightLine);
        CaramelTitle.setPrefWidth(264);
        CaramelTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        CaramelTitle.setLayoutX(0); CaramelTitle.setLayoutY(2);

        CaramelMenuHolder=new Rectangle(216, 312, Color.rgb(252, 255, 249));
        CaramelMenuHolder.setArcWidth(32); CaramelMenuHolder.setArcHeight(32);
        CaramelMenuHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        CaramelMenuHolder.setLayoutX(0); CaramelMenuHolder.setLayoutY(0);

        CaramelMenuImage=new ImageView();
        try {CaramelMenuImage.setImage(new Image(new FileInputStream("materials/image/Caramel.png")));}
        catch(FileNotFoundException f) {}
        CaramelMenuImage.setFitWidth(216); CaramelMenuImage.setFitHeight(120);
        CaramelMenuImage.setSmooth(true);
        CaramelMenuImage.setCache(true);
        CaramelMenuImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 4, 0, 0, 4));
        CaramelMenuImage.setLayoutX(0); CaramelMenuImage.setLayoutY(0);

        Menu CaramelPriceMenu=new Menu();
        CaramelPriceMenu.insertDrink("Apple","$1.20","     x");
        CaramelPriceMenu.insertDrink("Chocolate", "$1.30","     x");
        CaramelPriceMenu.insertDrink("Milk","$1.50","     x");
        CaramelPriceMenu.insertDrink("Coffee","$1.30","     x");
        CaramelPriceMenu.insertDrink("Orange","$1.20","     x");
        CaramelPriceMenu.insertDrink("Bourbon","$1.70","     x");
        CaramelPriceMenu.insertDrink("Machiatto","$1.90","     x");
        CaramelPriceMenu.insertDrink("Sea-salted","$1.40","     x");

        Caramel_Apple=new Button();
        Caramel_Apple.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Apple.setMinHeight(12); Caramel_Apple.setPrefWidth(88); Caramel_Apple.setPrefHeight(12);
        Caramel_Apple.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Apple);}
            }
        );
        Caramel_Chocolate=new Button();
        Caramel_Chocolate.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Chocolate.setMinHeight(12); Caramel_Chocolate.setPrefWidth(88); Caramel_Chocolate.setPrefHeight(12);
        Caramel_Chocolate.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Chocolate);}
            }
        );
        Caramel_Milk=new Button();
        Caramel_Milk.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Milk.setMinHeight(12); Caramel_Milk.setPrefWidth(88); Caramel_Milk.setPrefHeight(12);
        Caramel_Milk.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Milk);}
            }
        );
        Caramel_Coffee=new Button();
        Caramel_Coffee.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Coffee.setMinHeight(12); Caramel_Coffee.setPrefWidth(88); Caramel_Coffee.setPrefHeight(12);
        Caramel_Coffee.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Coffee);}
            }
        );
        Caramel_Orange=new Button();
        Caramel_Orange.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Orange.setMinHeight(12); Caramel_Orange.setPrefWidth(88); Caramel_Orange.setPrefHeight(12);
        Caramel_Orange.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Orange);}
            }
        );
        Caramel_Bourbon=new Button();
        Caramel_Bourbon.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Bourbon.setMinHeight(12); Caramel_Bourbon.setPrefWidth(88); Caramel_Bourbon.setPrefHeight(12);
        Caramel_Bourbon.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Bourbon);}
            }
        );
        Caramel_Machiatto=new Button();
        Caramel_Machiatto.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Machiatto.setMinHeight(12); Caramel_Machiatto.setPrefWidth(88); Caramel_Machiatto.setPrefHeight(12);
        Caramel_Machiatto.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Macchiato);}
            }
        );
        Caramel_Seasalted=new Button();
        Caramel_Seasalted.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Caramel_Seasalted.setMinHeight(12); Caramel_Seasalted.setPrefWidth(88); Caramel_Seasalted.setPrefHeight(12);
        Caramel_Seasalted.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.CARAMEL_Seasalted);}
            }
        );
        CaramelSelectButtons=new VBox(7, Caramel_Apple, Caramel_Chocolate, Caramel_Milk, Caramel_Coffee, Caramel_Orange, Caramel_Bourbon, Caramel_Machiatto, Caramel_Seasalted);
        CaramelSelectButtons.setLayoutX(16); CaramelSelectButtons.setLayoutY(152);

        CaramelMenu=new Pane(CaramelMenuHolder, CaramelMenuImage, CaramelPriceMenu, CaramelSelectButtons);
        CaramelMenu.setLayoutX(8); CaramelMenu.setLayoutY(40);

        Caramel=new Pane(CaramelTitle, CaramelMenu);
        Caramel.setPrefWidth(232); Caramel.setPrefHeight(352);
        Caramel.setLayoutX(16); Caramel.setLayoutY(1246);

        //Toppings:
        ToppingsTitleText=new FormattedText("Toppings", -1.0, 0, false);
        ToppingsTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 16));
        ToppingsTitleText.setFill(TextColor);
        ToppingsTitleText.setLayoutX(12); ToppingsTitleText.setLayoutY(1);
        Rectangle ToppingsLeftLine=new Rectangle(12, 1, TextColor);
        ToppingsLeftLine.setLayoutX(0); ToppingsLeftLine.setLayoutY(11);
        Rectangle ToppingsRightLine=new Rectangle(149, 1, TextColor);
        ToppingsRightLine.setLayoutX(83); ToppingsRightLine.setLayoutY(11);
        ToppingsTitle=new Pane(ToppingsLeftLine, ToppingsTitleText, ToppingsRightLine);
        ToppingsTitle.setPrefWidth(264);
        ToppingsTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        ToppingsTitle.setLayoutX(0); ToppingsTitle.setLayoutY(2);

        ToppingsMenuHolder=new Rectangle(216, 312, Color.rgb(252, 255, 249));
        ToppingsMenuHolder.setArcWidth(32); ToppingsMenuHolder.setArcHeight(32);
        ToppingsMenuHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        ToppingsMenuHolder.setLayoutX(0); ToppingsMenuHolder.setLayoutY(0);

        ToppingsMenuImage=new ImageView();
        try {ToppingsMenuImage.setImage(new Image(new FileInputStream("materials/image/Toppings.png")));}
        catch(FileNotFoundException f) {}
        ToppingsMenuImage.setFitWidth(216); ToppingsMenuImage.setFitHeight(120);
        ToppingsMenuImage.setSmooth(true);
        ToppingsMenuImage.setCache(true);
        ToppingsMenuImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 4, 0, 0, 4));
        ToppingsMenuImage.setLayoutX(0); ToppingsMenuImage.setLayoutY(0);

        Menu ToppingsPriceMenu=new Menu();
        ToppingsPriceMenu.insertDrink("Milk Pudding", "$0.20", "     x");
        ToppingsPriceMenu.insertDrink("Coffee Pudding", "$0.20", "     x");
        ToppingsPriceMenu.insertDrink("Matcha Pudding", "$0.20", "     x");
        ToppingsPriceMenu.insertDrink("Flan Pudding", "$0.25", "     x");
        ToppingsPriceMenu.insertDrink("Aloe Vera Jelly", "$0.40", "     x");
        ToppingsPriceMenu.insertDrink("Agar Jelly", "$0.70", "     x");
        ToppingsPriceMenu.insertDrink("Popball", "$0.15", "     x");
        ToppingsPriceMenu.insertDrink("Chinese Milk Foam", "$0.85", "     x");

        Toppings_MilkPudding=new Button();
        Toppings_MilkPudding.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_MilkPudding.setMinHeight(12); Toppings_MilkPudding.setPrefWidth(88); Toppings_MilkPudding.setPrefHeight(12);
        Toppings_MilkPudding.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_MilkPudding);}
            }
        );
        Toppings_CoffeePudding=new Button();
        Toppings_CoffeePudding.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_CoffeePudding.setMinHeight(12); Toppings_CoffeePudding.setPrefWidth(88); Toppings_CoffeePudding.setPrefHeight(12);
        Toppings_CoffeePudding.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_CoffeePudding);}
            }
        );
        Toppings_MatchaPudding=new Button();
        Toppings_MatchaPudding.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_MatchaPudding.setMinHeight(12); Toppings_MatchaPudding.setPrefWidth(88); Toppings_MatchaPudding.setPrefHeight(12);
        Toppings_MatchaPudding.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_MatchaPudding);}
            }
        );
        Toppings_FlanPudding=new Button();
        Toppings_FlanPudding.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_FlanPudding.setMinHeight(12); Toppings_FlanPudding.setPrefWidth(88); Toppings_FlanPudding.setPrefHeight(12);
        Toppings_FlanPudding.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_FlanPudding);}
            }
        );
        Toppings_AloeVeraJelly=new Button();
        Toppings_AloeVeraJelly.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_AloeVeraJelly.setMinHeight(12); Toppings_AloeVeraJelly.setPrefWidth(88); Toppings_AloeVeraJelly.setPrefHeight(12);
        Toppings_AloeVeraJelly.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_AloeVeraJelly);}
            }
        );
        Toppings_AgarJelly=new Button();
        Toppings_AgarJelly.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_AgarJelly.setMinHeight(12); Toppings_AgarJelly.setPrefWidth(88); Toppings_AgarJelly.setPrefHeight(12);
        Toppings_AgarJelly.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_AgarJelly);}
            }
        );
        Toppings_Popball=new Button();
        Toppings_Popball.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_Popball.setMinHeight(12); Toppings_Popball.setPrefWidth(88); Toppings_Popball.setPrefHeight(12);
        Toppings_Popball.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_Popball);}
            }
        );
        Toppings_ChineseMilkFoam=new Button();
        Toppings_ChineseMilkFoam.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        Toppings_ChineseMilkFoam.setMinHeight(12); Toppings_ChineseMilkFoam.setPrefWidth(88); Toppings_ChineseMilkFoam.setPrefHeight(12);
        Toppings_ChineseMilkFoam.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {addDrink(DrinkConst.TOPPINGS_ChineseMilkFoam);}
            }
        );
        ToppingsSelectButtons=new VBox(7, Toppings_MilkPudding, Toppings_CoffeePudding, Toppings_MatchaPudding, Toppings_FlanPudding, Toppings_AloeVeraJelly, Toppings_AgarJelly, Toppings_Popball, Toppings_ChineseMilkFoam);
        ToppingsSelectButtons.setLayoutX(16); ToppingsSelectButtons.setLayoutY(152);

        ToppingsMenu=new Pane(ToppingsMenuHolder, ToppingsMenuImage, ToppingsPriceMenu, ToppingsSelectButtons);
        ToppingsMenu.setLayoutX(8); ToppingsMenu.setLayoutY(40);

        Toppings=new Pane(ToppingsTitle, ToppingsMenu);
        Toppings.setPrefWidth(232); Toppings.setPrefHeight(352);
        Toppings.setLayoutX(16); Toppings.setLayoutY(1622);

        //BlankSpace:
        BlankSpace=new Pane();
        BlankSpace.setPrefWidth(264); BlankSpace.setPrefHeight(24);
        BlankSpace.setLayoutX(0); BlankSpace.setLayoutY(1974);

        //MainPage:
        MainPage=new Pane(PageTitle, PageQuote, BubbleTea, FreshTea, Coffee, Caramel, Toppings, BlankSpace);
        ScrollMainPage=new ScrollPane(MainPage);
        ScrollMainPage.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-unit-increment: 10; -fx-block-increment: 50;");
        ScrollMainPage.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setPrefWidth(264); ScrollMainPage.setPrefHeight(480);
        ScrollMainPage.setLayoutX(0); ScrollMainPage.setLayoutY(0);

        //NavigationBar:
        NavigationBar NavBar=new NavigationBar(NavigationBar.PagePicker.MENU, customer, drink);

        //BlurBox:
        BlurBox=new Pane(BlurredBackground, ScrollMainPage, NavBar);
        BlurBox.setLayoutX(0); BlurBox.setLayoutY(0);

        //Layout:
        this.getChildren().addAll(BlurBox);
        this.setLayoutX(0); this.setLayoutY(0);
    }

    //Constructor:
    public MenuPage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}