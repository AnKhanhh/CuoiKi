package com.example.cuoiki;
import java.io.*;
import java.net.Socket;
import java.sql.*;
import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.*;
// import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChatPage extends Pane
{
	//Chat:
	static Socket s,sChat;
	static DataOutputStream dout, doutChat;
	static DataInputStream din;

	static {
		try {
			s = new Socket("127.0.0.1", 4000);
			sChat = new Socket("127.0.0.1", 8000);
			dout =new DataOutputStream(s.getOutputStream());
			doutChat = new DataOutputStream(sChat.getOutputStream());
			din = new DataInputStream(sChat.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String msgout, msgin;

    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageTitle, Quote;
    private Pane TypingBox;
    private VBox MessageBoxes=new VBox(4);
    private Rectangle TypingBoxHolder;
    private Pane ChooseImageButton;
    private Circle ChooseImageButtonHolder;
    private ImageView ChooseImageButtonIcon;
    private Button ChooseImageButtonFrame;
    private TextField TypeField;
    private Pane SendButton;
    private ImageView SendButtonIcon;
    private Button SendButtonFrame;

    private ObservableList MessageList=MessageBoxes.getChildren();
    private UserInformation customer;
    private DrinkMap drink;
    private final Color TextColor=Color.rgb(71, 43, 43, 1.0);
    private final Color TextColor2=Color.rgb(252, 247, 247);
    private final Color TextColor3=Color.rgb(252, 255, 249);
    private Stage stage;
    private FileChooser filechooser;

    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        filechooser=new FileChooser();
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

        //SetCustomer:
        this.customer=customer;
        this.drink=drink;


    }

    //Build:
    private void build()
    {
        String url = "jdbc:mysql://localhost:3306/javadatabase";
        String user = "root";
        String password = "";
        String sqlChat = "Insert Into `tblchat`(`Tên đăng nhập`, `cusMessage`, `Sender`) VALUES (?,?,?)";
        String sql = "SELECT  `cusMessage`, `ID`, `Sender` FROM `tblchat` WHERE `Tên Đăng Nhập` = ?";
        String sqlID = "SELECT `Tên Đăng Nhập`, `ID`, `cusMessage`, `Sender` FROM `tblchat` WHERE `ID`=?";
        int ID=0;
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

        //MessageBoxes:
        MessageBoxes.setPrefWidth(232);
        MessageBoxes.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0,0.1), 6 , 0, 0, 4));
        MessageBoxes.setLayoutX(16); 
        MessageBoxes.setLayoutY(152);
        //TypingBox:
        TypingBoxHolder=new Rectangle(232, 32, TextColor2);
        TypingBoxHolder.setArcWidth(32); TypingBoxHolder.setArcHeight(32);
        TypingBoxHolder.setLayoutX(16); TypingBoxHolder.setLayoutY(8);

        ChooseImageButtonHolder=new Circle(12, TextColor);
        ChooseImageButtonHolder.setLayoutX(12); ChooseImageButtonHolder.setLayoutY(12);
        try {ChooseImageButtonIcon=new ImageView(new Image(new FileInputStream("materials/image/CameraIcon.png")));}
        catch(FileNotFoundException f) {}
        ChooseImageButtonIcon.setFitWidth(12); ChooseImageButtonIcon.setFitHeight(12);
        ChooseImageButtonIcon.setSmooth(true);
        ChooseImageButtonIcon.setCache(true);
        ChooseImageButtonIcon.setLayoutX(6); ChooseImageButtonIcon.setLayoutY(6);
        ChooseImageButtonFrame=new Button();
        ChooseImageButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 12px;");
        ChooseImageButtonFrame.setMinWidth(24); ChooseImageButtonFrame.setMinHeight(24); ChooseImageButtonFrame.setPrefWidth(24); ChooseImageButtonFrame.setPrefHeight(24);
        ChooseImageButtonFrame.setLayoutX(0); ChooseImageButtonFrame.setLayoutY(0);
        ChooseImageButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    try
                    {
                        String imagepath=filechooser.showOpenDialog(stage).getAbsolutePath();
                        if(imagepath!=null) {}
                    }
                    catch(Exception ex) {}
                }
            }
        );
        ChooseImageButton=new Pane(ChooseImageButtonHolder, ChooseImageButtonIcon, ChooseImageButtonFrame);
        ChooseImageButton.setPrefWidth(24); ChooseImageButton.setPrefHeight(24);
        ChooseImageButton.setLayoutX(20); ChooseImageButton.setLayoutY(12);

        TypeField=new TextField();
        TypeField.setPromptText("Type something here...");
        TypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        TypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 11));
        TypeField.setAlignment(Pos.CENTER_LEFT);
        TypeField.setPrefWidth(187.5); TypeField.setPrefHeight(24);
        TypeField.setLayoutX(40.5); TypeField.setLayoutY(12);
        TypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if(newPropertyValue) {TypeField.setPromptText("");}
                    else {TypeField.setPromptText("Type something here...");}
                }
            }
        );
        TypeField.setOnKeyPressed
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent k)
                {
                    if(k.getCode().equals(KeyCode.ENTER))
                    {
                        String InputText=TypeField.getText().trim();
                        if(InputText!=null)
                        {
                            MessageList.add(new MessageBox(InputText, true));
                            TypeField.clear(); 
                                              
                        try (Connection conn = DriverManager.getConnection(url, user, password)){
                            System.out.println("ket noi thanh cong");
                            System.out.println(conn.getCatalog());
                            PreparedStatement ps = conn.prepareStatement(sqlChat);
                            ps.setString(1, customer.userName);
                            ps.setString(2, InputText);
                            ps.setString(3, "Customer");
                            ps.execute();
                            conn.close();
                        }
                        catch(Exception E){
                    
                        }
                        }
                    }
                }
            }
        );

        try {SendButtonIcon=new ImageView(new Image(new FileInputStream("materials/image/SendIcon.png")));}
        catch(FileNotFoundException f) {}
        SendButtonIcon.setFitWidth(12); SendButtonIcon.setFitHeight(12);
        SendButtonIcon.setSmooth(true);
        SendButtonIcon.setCache(true);
        SendButtonIcon.setLayoutX(1); SendButtonIcon.setLayoutY(1);
        SendButtonFrame=new Button();
        SendButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        SendButtonFrame.setMinWidth(14); SendButtonFrame.setMinHeight(14); SendButtonFrame.setPrefWidth(14); SendButtonFrame.setPrefHeight(14);
        SendButtonFrame.setLayoutX(0); SendButtonFrame.setLayoutY(0);
        SendButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    String InputText=TypeField.getText().trim();
                    if(InputText!=null)
                    {   
                        MessageList.add(new MessageBox(InputText, true));
                        TypeField.clear();
                       
                        
                        try (Connection conn = DriverManager.getConnection(url, user, password)){
                            System.out.println("ket noi thanh cong");
                            System.out.println(conn.getCatalog());
                            PreparedStatement ps = conn.prepareStatement(sqlChat);
                            ps.setString(1, customer.userName);
                            ps.setString(2, InputText);
                            ps.setString(3, "Customer");
                            ps.execute();
                            conn.close();
							//chat
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
                        catch(Exception E){
                    
                        }
                    }
                }
            }
        );
        SendButton=new Pane(SendButtonIcon, SendButtonFrame);
        SendButton.setPrefWidth(14); SendButton.setPrefHeight(14);
        SendButton.setLayoutX(225); SendButton.setLayoutY(17);

        TypingBox=new Pane(TypingBoxHolder, ChooseImageButton, TypeField, SendButton);
        TypingBox.setPrefWidth(264); TypingBox.setPrefHeight(48);
        TypingBox.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.10), 8, 0, 0, 6));
        TypingBox.setLayoutX(0); TypingBox.setLayoutY(432);


        //MainPage:
        MainPage=new Pane(PageTitle, Quote, MessageBoxes);
        ScrollMainPage=new ScrollPane(MainPage);
        ScrollMainPage.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-unit-increment: 10; -fx-block-increment: 50;");
        ScrollMainPage.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ScrollMainPage.setPrefWidth(264); ScrollMainPage.setPrefHeight(432);
        ScrollMainPage.setLayoutX(0); ScrollMainPage.setLayoutY(0);

        //NavigationBar:
        NavigationBar NavBar=new NavigationBar(NavigationBar.PagePicker.CHAT, customer, drink);

        //Layout:
        this.getChildren().addAll(BlurredBackground, ScrollMainPage, TypingBox, NavBar);
        this.setLayoutX(0); this.setLayoutY(0);
        if (customer.isLoggedIn== true){
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("ket noi thanh cong");
            System.out.println(conn.getCatalog());
            int k =0;
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.userName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ID = rs.getInt(2);
            }
            System.out.println(ID);
            while(k<=10){
                PreparedStatement  ps1 = conn.prepareStatement(sqlID);
                ps1.setInt(1, ID);
                ResultSet rs1= ps1.executeQuery();
                while(rs1.next()){
                    System.out.println(rs1.getString(1));
                    if (rs1.getString(4).equals("Boss")){
                        MessageList.add(0,new MessageBox(rs1.getString(3), false));
                    } else {
                        MessageList.add(0,new MessageBox(rs1.getString(3), true));
                    }
                }
                k++; ID--;
            }

            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

		//Start client thread
		ClientThread clientThread = new ClientThread(sChat);
		clientThread.start();
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

class ClientThread extends Thread{
	static Socket sChat;
	static DataInputStream din;

	public ClientThread(Socket sChat){
		this.sChat=sChat;
	}

	public void run(){
		try {
			din = new DataInputStream(sChat.getInputStream());
			String msg;
			while (true){
				msg = din.readUTF();
				System.out.println("Server: "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}