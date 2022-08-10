package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkConst;
import com.example.cuoiki.Drink.DrinkDetails;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.FormattedText;
import com.example.cuoiki.Formatting.CustomFont;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.*;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderPage extends Pane
{
    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageQuote;
    private Pane ReceiptButton;
    private Rectangle ReceiptButtonHolder;
    private ImageView ReceiptButtonIcon;
    private Button ReceiptButtonFrame;
    private Pane ReceiptPane;
    private FormattedText ReceiptPaneSideTitle;
    private Rectangle ReceiptPaneHolder;
    private VBox OrderedDrinksBox;
    private Rectangle UpperLine;
    private Rectangle LowerLine;
    private Pane TotalPriceTag;
    private FormattedText TotalPriceTitle;
    private Text TotalPriceNumber;
    private Pane OrderButton;
    private FormattedText OrderButtonTitle;
    private Button OrderButtonFrame;
    private Pane CancelAllButton;
    private FormattedText CancelAllButtonTitle;
    private Button CancelAllButtonFrame;
    private Pane NavigateButtons;

    private Pane BlurBox;
    private Pane BlankSpace;

    private UserInformation customer;
    private DrinkMap drink;
    private DecimalFormat DoubleFormatter=new DecimalFormat("0.00");
    private final Color TextColor=Color.rgb(71, 43, 43, 1.0);
    private final Color TextColor2=Color.rgb(252, 247, 247);
    private final Color TextColor3=Color.rgb(252, 255, 249);
    private double TotalPrice;

	//Send order
	static Socket  sObj;
//	static DataOutputStream dout;
	static ObjectOutputStream oout;
	static {
		try {
			sObj=new Socket("127.0.0.1",8888);
			oout =new ObjectOutputStream(sObj.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public class OrderedDrinkConcept extends Pane
    {
        private DrinkConst drinkconst;
        private UserInformation.ReceiptDraft draft;
        private DrinkDetails drinkdetail;

        private Rectangle Holder;
        private ImageView DrinkImage;
        private Rectangle DrinkImageMask;
        private FormattedText DrinkName;
        private FormattedText MPriceTagTitle;
        private Text MDrinkCountText;
        private Pane MPriceTag;
        private Button MNumberIncreaseButton, MNumberDecreaseButton;
        private VBox MNumberButtons;
        private FormattedText LPriceTagTitle;
        private Text LDrinkCountText;
        private Pane LPriceTag;
        private Button LNumberIncreaseButton, LNumberDecreaseButton;
        private VBox LNumberButtons;
        private VBox PriceTag;
        private FormattedText PriceCountText;
        private Pane DeleteButton;
        private ImageView DeleteButtonImage;
        private Button DeleteButtonFrame;

        private void setup(DrinkConst drinkconst)
        {
            this.drinkconst=drinkconst;
            this.draft=customer.Receipt.get(drinkconst);
            this.drinkdetail=drink.get(drinkconst);
        }

        private void countPrice()
        {
            draft.Price=drinkdetail.getMPrice()*draft.MCount+drinkdetail.getMPrice()*draft.LCount;

            PriceCountText=null;
            this.getChildren().remove(4);
            PriceCountText=new FormattedText("$"+DoubleFormatter.format(draft.Price) , -1.0, 0, false);
            PriceCountText.setFill(TextColor2);
            PriceCountText.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
            PriceCountText.setPrefWrapLength(60);
            PriceCountText.setLayoutX(94); PriceCountText.setLayoutY(68);
            this.getChildren().add(4, PriceCountText);
        }

        private void build()
        {
            Holder=new Rectangle(216, 96, TextColor);
            Holder.setArcWidth(32); Holder.setArcHeight(32);
            Holder.setLayoutX(0); Holder.setLayoutY(0);

            DrinkImage=new ImageView(draft.DrinkImage);
            DrinkImage.setFitWidth(72); DrinkImage.setFitHeight(72);
            DrinkImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
            DrinkImage.setSmooth(true);
            DrinkImage.setCache(true);
            DrinkImage.setLayoutX(12); DrinkImage.setLayoutY(12);
            DrinkImageMask=new Rectangle(72, 72, TextColor2);
            DrinkImageMask.setArcWidth(24); DrinkImageMask.setArcHeight(24);
            DrinkImage.setClip(DrinkImageMask);


            DrinkName=new FormattedText((draft.DrinkType.equals("Toppings")?"":draft.DrinkType+" - ")+draft.DrinkName, -1.0, 0, false);
            DrinkName.setPrefWrapLength(120);
            DrinkName.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10.5));
            DrinkName.setFill(TextColor2);
            DrinkName.setLayoutX(94); DrinkName.setLayoutY(13);

            Polygon MPricePointer=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
            MPricePointer.setFill(TextColor2);
            MPricePointer.setLayoutX(0); MPricePointer.setLayoutY(3);
            MPriceTagTitle=new FormattedText("Size M :", -0.5, 0, true);
            MPriceTagTitle.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 9));
            MPriceTagTitle.setFill(TextColor2);
            MPriceTagTitle.setLayoutX(6); MPriceTagTitle.setLayoutY(1);
            Polygon MNumberIncrease=new Polygon(2.5, 0.0, 0.0, 3.0, 5.0, 3.0);
            MNumberIncrease.setFill(TextColor2);
            MNumberIncrease.setLayoutX(100); MNumberIncrease.setLayoutY(1.5);
            Polygon MNumberDecrease=new Polygon(0.0, 0.0, 5.0, 0.0, 2.5, 3.0);
            MNumberDecrease.setFill(TextColor2);
            MNumberDecrease.setLayoutX(100); MNumberDecrease.setLayoutY(7.5);
            MNumberIncreaseButton=new Button();
            MNumberIncreaseButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
            MNumberIncreaseButton.setMinWidth(7); MNumberIncreaseButton.setMinHeight(5); MNumberIncreaseButton.setPrefWidth(7); MNumberIncreaseButton.setPrefHeight(5);
            MNumberIncreaseButton.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        if(drinkdetail.getMPrice()!=0)
                        {
                            if(draft.MCount<99)
                            {
                                MDrinkCountText.setText(Integer.toString(++draft.MCount));
                                countPrice();
                                countTotalPrice();
                            }
                        }
                    }
                }
            );
            MNumberDecreaseButton=new Button();
            MNumberDecreaseButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
            MNumberDecreaseButton.setMinWidth(7); MNumberDecreaseButton.setMinHeight(5); MNumberDecreaseButton.setPrefWidth(7); MNumberDecreaseButton.setPrefHeight(5);
            MNumberDecreaseButton.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        if(drinkdetail.getMPrice()!=0)
                        {
                            if(draft.LCount==0)
                            {
                                if(draft.MCount>1)
                                {
                                    MDrinkCountText.setText(Integer.toString(--draft.MCount));
                                    countPrice();
                                    countTotalPrice();
                                }
                            }
                            else
                            {
                                if(draft.MCount>0)
                                {
                                    MDrinkCountText.setText(Integer.toString(--draft.MCount));
                                    countPrice();
                                    countTotalPrice();
                                }
                            }
                        }
                    }
                }
            );
            MNumberButtons=new VBox(1, MNumberIncreaseButton, MNumberDecreaseButton);
            MNumberButtons.setLayoutX(99); MNumberButtons.setLayoutY(0.5);
            MDrinkCountText=new Text(Integer.toString(draft.MCount));
            MDrinkCountText.setFill(TextColor2);
            MDrinkCountText.setFont(CustomFont.createFont("SFProText - Regular", "otf", 10));
            MDrinkCountText.setWrappingWidth(20);
            MDrinkCountText.setTextAlignment(TextAlignment.RIGHT);
            MDrinkCountText.setLayoutX(76); MDrinkCountText.setLayoutY(9);
            MPriceTag=new Pane(MPricePointer, MPriceTagTitle, MNumberIncrease, MNumberDecrease, MDrinkCountText, MNumberButtons);
            MPriceTag.setPrefWidth(104); MPriceTag.setPrefHeight(13);

            Polygon LPricePointer=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
            LPricePointer.setFill(TextColor2);
            LPricePointer.setLayoutX(0); LPricePointer.setLayoutY(3);
            LPriceTagTitle=new FormattedText("Size L :", -0.5, 0, true);
            LPriceTagTitle.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 9));
            LPriceTagTitle.setFill(TextColor2);
            LPriceTagTitle.setLayoutX(6); LPriceTagTitle.setLayoutY(1);
            Polygon LNumberIncrease=new Polygon(2.5, 0.0, 0.0, 3.0, 5.0, 3.0);
            LNumberIncrease.setFill(TextColor2);
            LNumberIncrease.setLayoutX(100); LNumberIncrease.setLayoutY(1.5);
            Polygon LNumberDecrease=new Polygon(0.0, 0.0, 5.0, 0.0, 2.5, 3.0);
            LNumberDecrease.setFill(TextColor2);
            LNumberDecrease.setLayoutX(100); LNumberDecrease.setLayoutY(7.5);
            LNumberIncreaseButton=new Button();
            LNumberIncreaseButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
            LNumberIncreaseButton.setMinWidth(7); LNumberIncreaseButton.setMinHeight(5); LNumberIncreaseButton.setPrefWidth(7); LNumberIncreaseButton.setPrefHeight(5);
            LNumberIncreaseButton.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        if(drinkdetail.getLPrice()!=0)
                        {
                            if(draft.LCount<99)
                            {
                                LDrinkCountText.setText(Integer.toString(++draft.LCount));
                                countPrice();
                                countTotalPrice();
                            }
                        }
                    }
                }
            );
            LNumberDecreaseButton=new Button();
            LNumberDecreaseButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
            LNumberDecreaseButton.setMinWidth(7); LNumberDecreaseButton.setMinHeight(5); LNumberDecreaseButton.setPrefWidth(7); LNumberDecreaseButton.setPrefHeight(5);
            LNumberDecreaseButton.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        if(drinkdetail.getLPrice()!=0)
                        {
                            if(draft.MCount==0)
                            {
                                if(draft.LCount>1)
                                {
                                    LDrinkCountText.setText(Integer.toString(--draft.LCount));
                                    countPrice();
                                    countTotalPrice();
                                }
                            }
                            else
                            {
                                if(draft.LCount>0)
                                {
                                    LDrinkCountText.setText(Integer.toString(--draft.LCount));
                                    countPrice();
                                    countTotalPrice();
                                }
                            }
                        }
                    }
                }
            );
            LNumberButtons=new VBox(1, LNumberIncreaseButton, LNumberDecreaseButton);
            LNumberButtons.setLayoutX(99); LNumberButtons.setLayoutY(0.5);
            LDrinkCountText=new Text(Integer.toString(draft.LCount));
            LDrinkCountText.setFill(TextColor2);
            LDrinkCountText.setFont(CustomFont.createFont("SFProText - Regular", "otf", 10));
            LDrinkCountText.setWrappingWidth(20);
            LDrinkCountText.setTextAlignment(TextAlignment.RIGHT);
            LDrinkCountText.setLayoutX(76); LDrinkCountText.setLayoutY(9);
            LPriceTag=new Pane(LPricePointer, LPriceTagTitle, LNumberIncrease, LNumberDecrease, LDrinkCountText, LNumberButtons);
            LPriceTag.setPrefWidth(104); LPriceTag.setPrefHeight(13);

            PriceTag=new VBox(4, MPriceTag, LPriceTag);
            PriceTag.setLayoutX(96); PriceTag.setLayoutY(32);

            PriceCountText=new FormattedText("$"+DoubleFormatter.format(draft.Price) , -1.0, 0, false);
            PriceCountText.setFill(TextColor2);
            PriceCountText.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
            PriceCountText.setPrefWrapLength(60);
            PriceCountText.setLayoutX(94); PriceCountText.setLayoutY(68);

            try {DeleteButtonImage=new ImageView(new Image(new FileInputStream("materials/image/DeleteIcon.png")));}
            catch(FileNotFoundException f) {}
            DeleteButtonImage.setFitWidth(12); DeleteButtonImage.setFitHeight(12);
            DeleteButtonImage.setSmooth(true);
            DeleteButtonImage.setCache(true);
            DeleteButtonFrame=new Button();
            DeleteButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
            DeleteButtonFrame.setMinWidth(12); DeleteButtonFrame.setPrefWidth(12); DeleteButtonFrame.setMinHeight(12); DeleteButtonFrame.setPrefHeight(12);
            DeleteButtonFrame.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        customer.Receipt.remove(drinkconst);
                        displayOrder();
                    }
                }
            );
            DeleteButton=new Pane(DeleteButtonImage, DeleteButtonFrame);
            DeleteButton.setPrefWidth(12); DeleteButton.setPrefHeight(12);
            DeleteButton.setLayoutX(190);DeleteButton.setLayoutY(70);

            this.getChildren().addAll(Holder, DrinkImage, DrinkName, PriceTag, PriceCountText, DeleteButton);
            this.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.10), 10, 0, 0, 6));
            this.setPrefWidth(216); this.setPrefHeight(96);
        }

        private OrderedDrinkConcept(DrinkConst drinkconst)
        {
            setup(drinkconst);
            build();
        }
    }

    //DisplayOrder:
    private void displayOrder()
    {
        int size=customer.Receipt.size();

        //NotHavingOrders:
        if(size==0)
        {
            ReceiptPaneHolder.setHeight(44);
            ReceiptPaneHolder.setArcWidth(24); ReceiptPaneHolder.setArcHeight(24);

            ReceiptPane.getChildren().clear();
            ReceiptPane.getChildren().addAll(ReceiptPaneHolder, ReceiptPaneSideTitle);
        }

        //HavingOrders:
        else
        {
            int s=112*size;

            ReceiptPaneHolder.setHeight(s+120);
            ReceiptPaneHolder.setArcWidth(36); ReceiptPaneHolder.setArcHeight(36);

            UpperLine.setLayoutY(s+7.5);
            LowerLine.setLayoutY(s+39.5);

            OrderedDrinksBox.getChildren().clear();
            ObservableList OrderedList=OrderedDrinksBox.getChildren();
            for(DrinkConst drinkconst:customer.Receipt.keySet()) {OrderedList.add(new OrderedDrinkConcept(drinkconst));}

            TotalPriceTag.setLayoutY(s+17);

            NavigateButtons.setLayoutY(s+54);

            ReceiptPane.getChildren().clear();
            ReceiptPane.getChildren().addAll(ReceiptPaneHolder, UpperLine, LowerLine, OrderedDrinksBox, TotalPriceTag, NavigateButtons);
            ReceiptPane.setPrefHeight(s+120);

            BlankSpace.setLayoutY(s+264);
        }
    }

    //CountTotalPrice:
    private void countTotalPrice()
    {
        TotalPrice=0;
        for(DrinkConst drinkconst:customer.Receipt.keySet()) {TotalPrice+=customer.Receipt.get(drinkconst).Price;}

        TotalPriceNumber=null;
        TotalPriceTag.getChildren().remove(1);
        TotalPriceNumber=new Text("$"+DoubleFormatter.format(TotalPrice));
        TotalPriceNumber.setFill(TextColor);
        TotalPriceNumber.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 13));
        TotalPriceNumber.setWrappingWidth(60);
        TotalPriceNumber.setTextAlignment(TextAlignment.RIGHT);
        TotalPriceNumber.setLayoutX(102); TotalPriceNumber.setLayoutY(10);
        TotalPriceTag.getChildren().add(1, TotalPriceNumber);
    }

    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        //SetCustomer:
        this.customer=customer;
        this.drink=drink;

        //HavingOrdersSettingUp:
        UpperLine=new Rectangle(184, 1, TextColor);
        UpperLine.setLayoutX(16);
        LowerLine=new Rectangle(184, 1, TextColor);
        LowerLine.setLayoutX(16);

        TotalPriceTitle=new FormattedText("Total Price :", -1.0, 0, false);
        TotalPriceTitle.setPrefWidth(68);
        TotalPriceTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 12));
        TotalPriceTitle.setFill(TextColor);

        TotalPriceNumber=new Text();

        TotalPriceTag=new Pane(TotalPriceTitle, TotalPriceNumber);
        countTotalPrice();
        TotalPriceTag.setPrefWidth(168); TotalPriceTag.setPrefHeight(16);
        TotalPriceTag.setLayoutX(24);

        OrderedDrinksBox=new VBox(16);

        OrderButtonTitle=new FormattedText("Order", -1.0, 0, true);
        OrderButtonTitle.setPrefWidth(38); OrderButtonTitle.setPrefHeight(14);
        OrderButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 14));
        OrderButtonTitle.setFill(TextColor);
        OrderButtonFrame=new Button();
        OrderButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        OrderButtonFrame.setMinHeight(14); OrderButtonFrame.setPrefWidth(38); OrderButtonFrame.setPrefHeight(14);
        OrderButtonFrame.setLayoutX(0); OrderButtonFrame.setLayoutY(0);
		OrderButtonFrame.setOnAction
			(
					new EventHandler<ActionEvent>()
					{
						@Override
						public void handle(ActionEvent e)
						{
							try {
								ArrayList<SerialReceipt> serialReceipts = new ArrayList<>();
								for(UserInformation.ReceiptDraft receiptDraft: customer.Receipt.values()){
									serialReceipts.add(new SerialReceipt(receiptDraft.DrinkName,receiptDraft.DrinkType,receiptDraft.Price, receiptDraft.MCount,receiptDraft.LCount));
								}
								ChatPage.send("order");
								oout.writeObject(serialReceipts);
							} catch (IOException ex) {
								ex.printStackTrace();
							}
//							for (UserInformation.ReceiptDraft receiptDraft:customer.Receipt.values()) {
//								System.out.println(receiptDraft.DrinkType+" - "+receiptDraft.DrinkName+" - "+receiptDraft.Price+" - "+receiptDraft.MCount+"/"+receiptDraft.LCount);
//							}
						}
					}
			);
        OrderButton=new Pane(OrderButtonTitle, OrderButtonFrame);
        OrderButton.setPrefWidth(38); OrderButton.setPrefHeight(14);
        OrderButton.setLayoutX(14); OrderButton.setLayoutY(0);

        CancelAllButtonTitle=new FormattedText("Cancel all", -1.0, 0, true);
        CancelAllButtonTitle.setPrefWidth(66); CancelAllButtonTitle.setPrefHeight(14);
        CancelAllButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 14));
        CancelAllButtonTitle.setFill(TextColor);
        CancelAllButtonFrame=new Button();
        CancelAllButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        CancelAllButtonFrame.setMinHeight(14); CancelAllButtonFrame.setPrefWidth(66); CancelAllButtonFrame.setPrefHeight(14);
        CancelAllButtonFrame.setLayoutX(0); CancelAllButtonFrame.setLayoutY(0);
        CancelAllButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    customer.Receipt.clear();
                    displayOrder();
                }
            }
        );
        CancelAllButton=new Pane(CancelAllButtonTitle, CancelAllButtonFrame);
        CancelAllButton.setPrefWidth(66); CancelAllButton.setPrefHeight(14);
        CancelAllButton.setLayoutX(0); CancelAllButton.setLayoutY(28);

        NavigateButtons=new Pane(OrderButton, CancelAllButton);
        NavigateButtons.setPrefWidth(66); NavigateButtons.setPrefHeight(44);
        NavigateButtons.setLayoutX(75);

        //NotHavingOrderSettingUp:
        ReceiptPaneSideTitle=new FormattedText("You have not picked any drink yet! Visit the Menu page to pick one.", -1.0, 0, false);
        ReceiptPaneSideTitle.setPrefWrapLength(190);
        ReceiptPaneSideTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        ReceiptPaneSideTitle.setFill(TextColor);
        ReceiptPaneSideTitle.setLayoutX(12); ReceiptPaneSideTitle.setLayoutY(10);
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

        //PageQuote:
        PageQuote=new FormattedText("Finish ordering   your drinks here and enjoy it!", -1.0, 1.0, false);
        PageQuote.setPrefWidth(88); PageQuote.setPrefHeight(42);
        PageQuote.setFont(CustomFont.createFont("Raleway - SemiBoldItalic", "ttf", 12));
        PageQuote.setPrefWrapLength(88);
        PageQuote.setFill(TextColor);
        PageQuote.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        PageQuote.setLayoutX(23); PageQuote.setLayoutY(42);

        //ReceiptButton:
        ReceiptButtonHolder=new Rectangle(24, 24, TextColor);
        ReceiptButtonHolder.setArcWidth(12); ReceiptButtonHolder.setArcHeight(12);
        ReceiptButtonHolder.setLayoutX(0); ReceiptButtonHolder.setLayoutY(0);

        try {ReceiptButtonIcon=new ImageView(new Image(new FileInputStream("materials/image/ReceiptButtonIcon.png")));}
        catch(FileNotFoundException f) {}
        ReceiptButtonIcon.setFitWidth(16); ReceiptButtonIcon.setFitHeight(16);
        ReceiptButtonIcon.setSmooth(true);
        ReceiptButtonIcon.setCache(true);
        ReceiptButtonIcon.setLayoutX(4); ReceiptButtonIcon.setLayoutY(4);

        ReceiptButtonFrame=new Button();
        ReceiptButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 6px;");
        ReceiptButtonFrame.setPrefWidth(24); ReceiptButtonFrame.setPrefHeight(24);
        ReceiptButtonFrame.setLayoutX(0); ReceiptButtonFrame.setLayoutY(0);
        ReceiptButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {getScene().setRoot(new ProfilePage(customer, drink));}
            }
        );

        ReceiptButton=new Pane(ReceiptButtonHolder, ReceiptButtonIcon, ReceiptButtonFrame);
        ReceiptButton.setPrefWidth(24); ReceiptButton.setPrefHeight(24);
        ReceiptButton.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 6, 0, 0, 2));
        ReceiptButton.setLayoutX(216); ReceiptButton.setLayoutY(48);

        //ReceiptPane:
        ReceiptPaneHolder=new Rectangle();
        ReceiptPaneHolder.setWidth(216);
        ReceiptPaneHolder.setFill(TextColor3);
        ReceiptPaneHolder.setLayoutX(0); ReceiptPaneHolder.setLayoutY(0);

        ReceiptPane=new Pane();
        ReceiptPane.setPrefWidth(216);
        ReceiptPane.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        ReceiptPane.setLayoutX(24); ReceiptPane.setLayoutY(120);

        //BlankSpace:
        BlankSpace=new Pane();
        BlankSpace.setPrefWidth(264); BlankSpace.setPrefHeight(24);
        BlankSpace.setLayoutX(0);

        //DisplayOrder:
        displayOrder();

        //MainPage:
        MainPage=new Pane(PageQuote, ReceiptButton, ReceiptPane, BlankSpace);
        ScrollMainPage=new ScrollPane(MainPage);
        ScrollMainPage.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-unit-increment: 10; -fx-block-increment: 50;");
        ScrollMainPage.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setPrefWidth(264); ScrollMainPage.setPrefHeight(480);
        ScrollMainPage.setLayoutX(0); ScrollMainPage.setLayoutY(0);

        //NavigationBar:
        NavigationBar NavBar=new NavigationBar(NavigationBar.PagePicker.PROFILE, customer, drink);

        //BlurBox:
        BlurBox=new Pane(BlurredBackground, ScrollMainPage, NavBar);
        BlurBox.setLayoutX(0); BlurBox.setLayoutY(0);

        //Layout:
        this.getChildren().addAll(BlurBox);
        this.setLayoutX(0); this.setLayoutY(0);
	}

    //Constructor:
    public OrderPage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}