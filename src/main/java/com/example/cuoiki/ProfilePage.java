package com.example.cuoiki;
import Hashing.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkMap;
import com.example.cuoiki.Formatting.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class ProfilePage extends Pane
{
    //Declaration:
    private ScrollPane ScrollMainPage;
    private Pane MainPage;
    private ImageView BlurredBackground;
    private FormattedText PageTitle;
    private Pane ReceiptButton;
    private Rectangle ReceiptButtonHolder;
    private ImageView ReceiptButtonIcon;
    private Button ReceiptButtonFrame;
    private Pane InformationPane;
    private Rectangle InformationPaneHolder;
    private Pane UserAvatar;
    private ImageView UserAvatarImage;
    private Rectangle UserAvatarMask;
    private FormattedText UserEditedName;
    private FormattedText UserLevelText;
    private Pane UserLevelProgressBar;
    private Rectangle UserLevelProgressBarHolder;
    private Text UserLevelProgressText;
    private VBox InformationSettings;
    private Pane FullNameOption;
    private FormattedText FullNameTitle;
    private FormattedText DisplayedFullName;
    private Button FullNameOptionButton;
    private Pane PhoneNumberOption;
    private FormattedText PhoneNumberTitle;
    private FormattedText DisplayedPhoneNumber;
    private Button PhoneNumberOptionButton;
    private Pane EmailOption;
    private FormattedText EmailTitle;
    private FormattedText DisplayedEmail;
    private Button EmailOptionButton;
    private Pane ChangeProfilePictureOption;
    private FormattedText ChangeProfilePictureTitle;
    private Button ChangeProfilePictureButton;
    private Pane ChangePasswordOption;
    private FormattedText ChangePasswordTitle;
    private Button ChangePasswordButton;
    private Pane SignButton;
    private Rectangle SignButtonHolder;
    private FormattedText SignButtonTitle;
    private Button SignButtonFrame;
    private Pane SettingsTitle;
    private FormattedText SettingsTitleText;
    private Pane SettingsPane;
    private Rectangle SettingsPaneHolder;
    private VBox SettingsList;
    private Pane TurnNotificationsOption;
    private FormattedText TurnNotificationsTitle;
    private BinarySettingsButton TurnNotificationsButton;
    private Pane PreviewsOption;
    private FormattedText PreviewsTitle;
    private BinarySettingsButton PreviewsButton;
    private Pane VibrationsOption;
    private FormattedText VibrationsTitle;
    private BinarySettingsButton VibrationsButton;
    private Pane BlurBox;
    private Pane BlankSpace;

    private Pane ChangingPane;
    private Rectangle BlurredChangingPane;
    private Rectangle ChangingPaneHolder;
    private FormattedText ChangingPaneTitle;
    private Rectangle ChangingPaneUpperLine;
    private Rectangle ChangingPaneLowerLine;
    private HBox NavigateButtonsTitle;
    private FormattedText DoneButtonTitle, ChangingCancelButtonTitle;
    private HBox NavigateButtonsFrame;
    private Button DoneButtonFrame, ChangingCancelButtonFrame;
    private FormattedText OldFullNameTitle;
    private Rectangle OldFullNameTypeBox;
    private TextField OldFullNameTypeField;
    private Pane OldFullName;
    private FormattedText NewFullNameTitle;
    private Rectangle NewFullNameTypeBox;
    private TextField NewFullNameTypeField;
    private Pane NewFullName;
    private VBox FullNameTyping;
    private FormattedText OldPhoneNumberTitle;
    private Rectangle OldPhoneNumberTypeBox;
    private TextField OldPhoneNumberTypeField;
    private Pane OldPhoneNumber;
    private FormattedText NewPhoneNumberTitle;
    private Rectangle NewPhoneNumberTypeBox;
    private TextField NewPhoneNumberTypeField;
    private Pane NewPhoneNumber;
    private VBox PhoneNumberTyping;
    private FormattedText OldEmailTitle;
    private Rectangle OldEmailTypeBox;
    private TextField OldEmailTypeField;
    private Pane OldEmail;
    private FormattedText NewEmailTitle;
    private Rectangle NewEmailTypeBox;
    private TextField NewEmailTypeField;
    private Pane NewEmail;
    private VBox EmailTyping;
    private FormattedText OldPasswordTitle;
    private Rectangle OldPasswordTypeBox;
    private PasswordField OldPasswordTypeField;
    private Pane OldPassword;
    private FormattedText NewPasswordTitle;
    private Rectangle NewPasswordTypeBox;
    private PasswordField NewPasswordTypeField;
    private Pane NewPassword;
    private FormattedText ReNewPasswordTitle;
    private Rectangle ReNewPasswordTypeBox;
    private PasswordField ReNewPasswordTypeField;
    private Pane ReNewPassword;
    private VBox PasswordTyping;
    private FormattedText ResetImageTitle;
    private Button ResetImageButtonFrame;
    private Pane ResetImageOption;
    private FormattedText UploadImageTitle;
    private Button UploadImageButtonFrame;
    private Pane UploadImageOption;
    private VBox UserImageOptions;
    private Pane DisplayedUserAvatar;
    private ImageView DisplayedUserAvatarImage;
    private Rectangle DisplayedUserAvatarMask;
    
    private Pane SigningPane;
    private Rectangle BlurredSigningPane;
    private Rectangle SigningPaneHolder;
    private FormattedText SigningOutTitle;
    private FormattedText SigningInTitle;
    private FormattedText SigningUpTitle;
    private Rectangle SigningPaneUpperLine;
    private Rectangle SigningPaneLowerLine;
    private Pane SignOutButton;
    private FormattedText SignOutButtonTitle;
    private Button SignOutButtonFrame;
    private Pane SignInButton;
    private FormattedText SignInButtonTitle;
    private Button SignInButtonFrame;
    private Pane SignUpButton;
    private FormattedText SignUpButtonTitle;
    private Button SignUpButtonFrame;
    private Pane SigningCancelButton;
    private FormattedText SigningCancelButtonTitle;
    private Button SigningCancelButtonFrame;
    private FormattedText OrText;
    private Pane SignInUsername;
    private FormattedText SignInUsernameTitle;
    private Rectangle SignInUsernameTypeBox;
    private TextField SignInUsernameTypeField;
    private Pane SignInPassword;
    private FormattedText SignInPasswordTitle;
    private Rectangle SignInPasswordTypeBox;
    private TextField SignInPasswordTypeField;
    private VBox SigningInTyping;
    private Pane SignUpUsername;
    private FormattedText SignUpUsernameTitle;
    private Rectangle SignUpUsernameTypeBox;
    private TextField SignUpUsernameTypeField;
    private Pane SignUpPassword;
    private FormattedText SignUpPasswordTitle;
    private Rectangle SignUpPasswordTypeBox;
    private TextField SignUpPasswordTypeField;
    private Pane SignUpRePassword;
    private FormattedText SignUpRePasswordTitle;
    private Rectangle SignUpRePasswordTypeBox;
    private TextField SignUpRePasswordTypeField;
    private VBox SigningUpTyping;
    private FormattedText SignInAlert;
    private FormattedText SignUpAlert1;
    private FormattedText SignUpAlert2;

    public static UserInformation customer;
    private DrinkMap drink;
    private DecimalFormat DoubleFormatter=new DecimalFormat("0.00");
    private final Color Color1=Color.rgb(71, 43, 43);
    private final Color Color2=Color.rgb(252, 247, 247);
    private final Color Color3=Color.rgb(252, 255, 249);
    private Stage stage;
    private FileChooser filechooser;
    private boolean isAlertedSignIn=false, isAlertedSignUp=false;

    private class BinarySettingsButton extends Pane
    {
        private boolean State;
        int SettingNumber;

        private Rectangle ButtonHolder;
        private Circle StateCircle;
        private Button ButtonFrame;

        private final Color AltColor=Color.rgb(197, 197, 197);

        private void passStateParameter()
        {
            switch(SettingNumber)
            {
                case 1: {customer.TurnNotifications=State; break;}
                case 2: {customer.Previews=State; break;}
                case 3: {customer.Vibrations=State; break;}
            }
        }

        private void setState()
        {
            if(State==false)
            {
                ButtonHolder.setFill(AltColor);
                StateCircle.setLayoutX(8); StateCircle.setLayoutY(8);
            }
            else
            {
                ButtonHolder.setFill(Color1);
                StateCircle.setLayoutX(20); StateCircle.setLayoutY(8);
            }
        }

        private void build()
        {
            ButtonHolder=new Rectangle(28, 16);
            ButtonHolder.setArcWidth(16); ButtonHolder.setArcHeight(16);
            ButtonHolder.setLayoutX(0); ButtonHolder.setLayoutY(0);

            StateCircle=new Circle(6, Color2);

            ButtonFrame=new Button();
            ButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px;");
            ButtonFrame.setPrefWidth(28); ButtonFrame.setPrefHeight(16);
            ButtonFrame.setLayoutX(0); ButtonFrame.setLayoutY(0);
            ButtonFrame.setOnAction
            (
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent e)
                    {
                        State=!State;
                        setState();
                        passStateParameter();
                    }
                }
            );

            this.getChildren().addAll(ButtonHolder, StateCircle, ButtonFrame);
        }

        public BinarySettingsButton(boolean state, int settingnumber)
        {
            this.SettingNumber=settingnumber;
            State=state;
            build();
            setState();
        }
    }

    //FixString:
    private String fixedString(String input)
    {
        char inputCharArray[]=input.toCharArray();
        String temp=new String(inputCharArray);
        temp=temp.trim();
        return temp;
    }

    //ChangeFullName:
    private void changeFullName()
    {
        ChangingPaneHolder.setHeight(184);
        ChangingPaneHolder.setLayoutY(172);

        ChangingPaneTitle.setLayoutY(188);

        ChangingPaneUpperLine.setLayoutY(215.5);
        ChangingPaneLowerLine.setLayoutY(311.5);

        NavigateButtonsTitle.setLayoutY(326);
        NavigateButtonsFrame.setLayoutY(326);
        if (customer.FullName== null) customer.FullName=" ";
        OldFullNameTitle= new FormattedText("Current Full name :", -0.5, 0, false);
        OldFullNameTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        OldFullNameTitle.setFill(Color2);
        OldFullNameTitle.setLayoutX(8); OldFullNameTitle.setLayoutY(4);
        OldFullNameTypeBox=new Rectangle(136, 20, Color3);
        OldFullNameTypeBox.setArcWidth(16); OldFullNameTypeBox.setArcHeight(16);
        OldFullNameTypeBox.setLayoutX(0); OldFullNameTypeBox.setLayoutY(16);
        OldFullNameTypeField=new TextField();
        OldFullNameTypeField.setText(customer.FullName);
        OldFullNameTypeField.setEditable(false);
        OldFullNameTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; ");
        OldFullNameTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        OldFullNameTypeField.setAlignment(Pos.CENTER_LEFT);
        OldFullNameTypeField.setPrefWidth(136); OldFullNameTypeField.setPrefHeight(20);
        OldFullNameTypeField.setLayoutX(0); OldFullNameTypeField.setLayoutY(16);
        OldFullNameTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {OldFullNameTypeField.setPromptText("");}
                    else {OldFullNameTypeField.setPromptText("Type full name here...");}
                }
            }
        );
        OldFullNameTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=OldFullNameTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        OldFullNameTypeField.setText(BadInput.substring(0, 32));
                        OldFullNameTypeField.positionCaret(32);
                    }
                }
            }
        );
        OldFullName=new Pane(OldFullNameTitle, OldFullNameTypeBox, OldFullNameTypeField);
        OldFullName.setPrefWidth(136); OldFullName.setPrefHeight(40);
        if (customer.FullName==null) customer.FullName = "";
        NewFullNameTitle= new FormattedText("New full name :", -0.5, 0, false);
        NewFullNameTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        NewFullNameTitle.setFill(Color2);
        NewFullNameTitle.setLayoutX(8); NewFullNameTitle.setLayoutY(4);
        NewFullNameTypeBox=new Rectangle(136, 20, Color3);
        NewFullNameTypeBox.setArcWidth(16); NewFullNameTypeBox.setArcHeight(16);
        NewFullNameTypeBox.setLayoutX(0); NewFullNameTypeBox.setLayoutY(16);
        NewFullNameTypeField=new TextField();
        NewFullNameTypeField.setPromptText("Type full name here...");
        NewFullNameTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        NewFullNameTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        NewFullNameTypeField.setAlignment(Pos.CENTER_LEFT);
        NewFullNameTypeField.setPrefWidth(136); NewFullNameTypeField.setPrefHeight(20);
        NewFullNameTypeField.setLayoutX(0); NewFullNameTypeField.setLayoutY(16);
        NewFullNameTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {NewFullNameTypeField.setPromptText("");}
                    else {NewFullNameTypeField.setPromptText("Type new full name here...");}
                }
            }
        );
        NewFullNameTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=NewFullNameTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        NewFullNameTypeField.setText(BadInput.substring(0, 32));
                        NewFullNameTypeField.positionCaret(32);
                    }
                }
            }
        );
        NewFullName=new Pane(NewFullNameTitle, NewFullNameTypeBox, NewFullNameTypeField);
        NewFullName.setPrefWidth(136); NewFullName.setPrefHeight(40);

        DoneButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(OldFullNameTypeField.getText().compareTo(customer.FullName)==0)
                    {
                        customer.FullName=fixedString(NewFullNameTypeField.getText());
                        DisplayedFullName=null;
                        FullNameOption.getChildren().remove(2);
                        DisplayedFullName=new FormattedText(customer.FullName, -1.0, 0, false);
                        DisplayedFullName.setAlignment(Pos.BASELINE_RIGHT);
                        DisplayedFullName.setPrefWrapLength(120);
                        DisplayedFullName.setPrefWidth(120);
                        DisplayedFullName.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
                        DisplayedFullName.setFill(Color1);
                        DisplayedFullName.setLayoutX(57); DisplayedFullName.setLayoutY(7);
                        FullNameOption.getChildren().add(2, DisplayedFullName);
                        try {                   
                            String url = "jdbc:mysql://localhost:3306/javadatabase";
                            String user = "root";
                            String password = "";
                          
                            
                                try(Connection conn= DriverManager.getConnection(url, user, password)) {                                
                                System.out.println("ket noi thanh cong");
                                System.out.println(conn.getCatalog());
                                System.out.println(customer.Password);
                               
                                String SqlFullNameSet = "update `tblseller` Set `Họ và tên`=? where `Tên Đăng Nhập`=?";
                                PreparedStatement stmt = conn.prepareStatement(SqlFullNameSet);
                                stmt.setString(1, NewFullNameTypeField.getText());
                                stmt.setString(2, customer.userName);
                                stmt.execute();
                                stmt.close();
                                conn.close();
                                } catch (Exception a) {
                                    //TODO: handle exception
                                    a.printStackTrace();
                                }
                                deleteChangePasswordPane();
                           
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        
                        deleteChangeFullNamePane();
                    }
                }
            
                    }
                
        );

        ChangingCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteChangeFullNamePane();}
            }
        );

        FullNameTyping=new VBox(OldFullName, NewFullName);
        FullNameTyping.setLayoutX(64); FullNameTyping.setLayoutY(224);

        ChangingPane.getChildren().addAll(FullNameTyping);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(ChangingPane);
    }

    private void deleteChangeFullNamePane()
    {
        OldFullNameTitle=null;
        OldFullNameTypeBox=null;
        OldFullNameTypeField=null;
        OldFullName=null;
        NewFullNameTitle=null;
        NewFullNameTypeBox=null;
        NewFullNameTypeField=null;
        NewFullName=null;
        FullNameTyping=null;
        ChangingPane.getChildren().remove(7);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //ChangePhoneNumber:
    private void changePhoneNumber()
    {
        ChangingPaneHolder.setHeight(184);
        ChangingPaneHolder.setLayoutY(172);

        ChangingPaneTitle.setLayoutY(188);

        ChangingPaneUpperLine.setLayoutY(215.5);
        ChangingPaneLowerLine.setLayoutY(311.5);

        NavigateButtonsTitle.setLayoutY(326);
        NavigateButtonsFrame.setLayoutY(326);
        if (customer.PhoneNumber==null) customer.PhoneNumber= " ";
        OldPhoneNumberTitle= new FormattedText("Phone number :", -0.5, 0, false);
        OldPhoneNumberTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        OldPhoneNumberTitle.setFill(Color2);
        OldPhoneNumberTitle.setLayoutX(8); OldPhoneNumberTitle.setLayoutY(4);
        OldPhoneNumberTypeBox=new Rectangle(136, 20, Color3);
        OldPhoneNumberTypeBox.setArcWidth(16); OldPhoneNumberTypeBox.setArcHeight(16);
        OldPhoneNumberTypeBox.setLayoutX(0); OldPhoneNumberTypeBox.setLayoutY(16);
        OldPhoneNumberTypeField=new TextField();
        OldPhoneNumberTypeField.setText(customer.PhoneNumber);
        OldPhoneNumberTypeField.setEditable(false);
        OldPhoneNumberTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; ");
        OldPhoneNumberTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        OldPhoneNumberTypeField.setAlignment(Pos.CENTER_LEFT);
        OldPhoneNumberTypeField.setPrefWidth(136); OldPhoneNumberTypeField.setPrefHeight(20);
        OldPhoneNumberTypeField.setLayoutX(0); OldPhoneNumberTypeField.setLayoutY(16);
        OldPhoneNumberTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {OldPhoneNumberTypeField.setPromptText("");}
                    else {OldPhoneNumberTypeField.setPromptText("Type number here...");}
                }
            }
        );
        OldPhoneNumberTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=OldPhoneNumberTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        OldPhoneNumberTypeField.setText(BadInput.substring(0, 32));
                        OldPhoneNumberTypeField.positionCaret(32);
                    }
                }
            }
        );
        OldPhoneNumber=new Pane(OldPhoneNumberTitle, OldPhoneNumberTypeBox, OldPhoneNumberTypeField);
        OldPhoneNumber.setPrefWidth(136); OldPhoneNumber.setPrefHeight(40);

        NewPhoneNumberTitle= new FormattedText("New phone number :", -0.5, 0, false);
        NewPhoneNumberTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        NewPhoneNumberTitle.setFill(Color2);
        NewPhoneNumberTitle.setLayoutX(8); NewPhoneNumberTitle.setLayoutY(4);
        NewPhoneNumberTypeBox=new Rectangle(136, 20, Color3);
        NewPhoneNumberTypeBox.setArcWidth(16); NewPhoneNumberTypeBox.setArcHeight(16);
        NewPhoneNumberTypeBox.setLayoutX(0); NewPhoneNumberTypeBox.setLayoutY(16);
        NewPhoneNumberTypeField=new TextField();
        NewPhoneNumberTypeField.setPromptText("Type new number here...");
        NewPhoneNumberTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        NewPhoneNumberTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        NewPhoneNumberTypeField.setAlignment(Pos.CENTER_LEFT);
        NewPhoneNumberTypeField.setPrefWidth(136); NewPhoneNumberTypeField.setPrefHeight(20);
        NewPhoneNumberTypeField.setLayoutX(0); NewPhoneNumberTypeField.setLayoutY(16);
        NewPhoneNumberTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {NewPhoneNumberTypeField.setPromptText("");}
                    else {NewPhoneNumberTypeField.setPromptText("Type new number here...");}
                }
            }
        );
        NewPhoneNumberTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=NewPhoneNumberTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        NewPhoneNumberTypeField.setText(BadInput.substring(0, 32));
                        NewPhoneNumberTypeField.positionCaret(32);
                    }
                }
            }
        );
        NewPhoneNumber=new Pane(NewPhoneNumberTitle, NewPhoneNumberTypeBox, NewPhoneNumberTypeField);
        NewPhoneNumber.setPrefWidth(136); NewPhoneNumber.setPrefHeight(40);

        DoneButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    
                    
                        customer.PhoneNumber=fixedString(NewPhoneNumberTypeField.getText());
                        DisplayedPhoneNumber=null;
                        PhoneNumberOption.getChildren().remove(2);
                        DisplayedPhoneNumber=new FormattedText(customer.PhoneNumber, -1.0, 0, false);
                        DisplayedPhoneNumber.setAlignment(Pos.BASELINE_RIGHT);
                        DisplayedPhoneNumber.setPrefWrapLength(120);
                        DisplayedPhoneNumber.setPrefWidth(120);
                        DisplayedPhoneNumber.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
                        DisplayedPhoneNumber.setFill(Color1);
                        DisplayedPhoneNumber.setLayoutX(57); DisplayedPhoneNumber.setLayoutY(7);
                        PhoneNumberOption.getChildren().add(2, DisplayedPhoneNumber);
                        try {
                        
                            String url = "jdbc:mysql://localhost:3306/javadatabase";
                            String user = "root";
                            String password = "";
                                                      
                                try(Connection conn= DriverManager.getConnection(url, user, password)) {                                
                                System.out.println("ket noi thanh cong");
                                                           
                                String SqlPhoneSet = "update `tblseller` Set `SĐT`='?' where `Tên Đăng Nhập`=?";
                                PreparedStatement stmt = conn.prepareStatement(SqlPhoneSet);
                                stmt.setString(1, NewPhoneNumberTypeField.getText());
                                stmt.setString(2, customer.userName);
                                stmt.execute();
                                stmt.close();
                                conn.close();
                                } catch (Exception a) {
                                    //TODO: handle exception
                                    a.printStackTrace();
                                }
                                deleteChangePasswordPane();
                           
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        deleteChangePhoneNumberPane();
                    
                }
            }
        );

        ChangingCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteChangePhoneNumberPane();}
            }
        );

        PhoneNumberTyping=new VBox(OldPhoneNumber, NewPhoneNumber);
        PhoneNumberTyping.setLayoutX(64); PhoneNumberTyping.setLayoutY(224);

        ChangingPane.getChildren().addAll(PhoneNumberTyping);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(ChangingPane);
    }

    private void deleteChangePhoneNumberPane()
    {
        OldPhoneNumberTitle=null;
        OldPhoneNumberTypeBox=null;
        OldPhoneNumberTypeField=null;
        OldPhoneNumber=null;
        NewPhoneNumberTitle=null;
        NewPhoneNumberTypeBox=null;
        NewPhoneNumberTypeField=null;
        NewPhoneNumber=null;
        PhoneNumberTyping=null;
        ChangingPane.getChildren().remove(7)    ;
        BlurBox.setEffect(null);
        this.getChildren().remove(0);
    }

    //ChangeEmail:
    private void changeEmail()
    {
        ChangingPaneHolder.setHeight(184);
        ChangingPaneHolder.setLayoutY(172);

        ChangingPaneTitle.setLayoutY(188);

        ChangingPaneUpperLine.setLayoutY(215.5);
        ChangingPaneLowerLine.setLayoutY(311.5);

        NavigateButtonsTitle.setLayoutY(326);
        NavigateButtonsFrame.setLayoutY(326);
        
    if (customer.Email== null) customer.Email = " ";

        OldEmailTitle= new FormattedText("Current Email :", -0.5, 0, false);
        OldEmailTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        OldEmailTitle.setFill(Color2);
        OldEmailTitle.setLayoutX(8); OldEmailTitle.setLayoutY(4);
        OldEmailTypeBox=new Rectangle(136, 20, Color3);
        OldEmailTypeBox.setArcWidth(16); OldEmailTypeBox.setArcHeight(16);
        OldEmailTypeBox.setLayoutX(0); OldEmailTypeBox.setLayoutY(16);
        OldEmailTypeField=new TextField();
        OldEmailTypeField.setText(customer.Email);
        OldEmailTypeField.setEditable(false);
        OldEmailTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B;");
        OldEmailTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        OldEmailTypeField.setAlignment(Pos.CENTER_LEFT);
        OldEmailTypeField.setPrefWidth(136); OldEmailTypeField.setPrefHeight(20);
        OldEmailTypeField.setLayoutX(0); OldEmailTypeField.setLayoutY(16);
        OldEmailTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {OldEmailTypeField.setPromptText("");}
                    else {OldEmailTypeField.setPromptText("Type email here...");}
                }
            }
        );
        OldEmailTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=OldEmailTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        OldEmailTypeField.setText(BadInput.substring(0, 32));
                        OldEmailTypeField.positionCaret(32);
                    }
                }
            }
        );
        OldEmail=new Pane(OldEmailTitle, OldEmailTypeBox, OldEmailTypeField);
        OldEmail.setPrefWidth(136); OldEmail.setPrefHeight(40);

        NewEmailTitle= new FormattedText("New email :", -0.5, 0, false);
        NewEmailTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        NewEmailTitle.setFill(Color2);
        NewEmailTitle.setLayoutX(8); NewEmailTitle.setLayoutY(4);
        NewEmailTypeBox=new Rectangle(136, 20, Color3);
        NewEmailTypeBox.setArcWidth(16); NewEmailTypeBox.setArcHeight(16);
        NewEmailTypeBox.setLayoutX(0); NewEmailTypeBox.setLayoutY(16);
        NewEmailTypeField=new TextField();
        NewEmailTypeField.setPromptText("Type new email here...");
        NewEmailTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        NewEmailTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        NewEmailTypeField.setAlignment(Pos.CENTER_LEFT);
        NewEmailTypeField.setPrefWidth(136); NewEmailTypeField.setPrefHeight(20);
        NewEmailTypeField.setLayoutX(0); NewEmailTypeField.setLayoutY(16);
        NewEmailTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {NewEmailTypeField.setPromptText("");}
                    else {NewEmailTypeField.setPromptText("Type new email here...");}
                }
            }
        );
        NewEmailTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=NewEmailTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        NewEmailTypeField.setText(BadInput.substring(0, 32));
                        NewEmailTypeField.positionCaret(32);
                    }
                }
            }
        );
        NewEmail=new Pane(NewEmailTitle, NewEmailTypeBox, NewEmailTypeField);
        NewEmail.setPrefWidth(136); NewEmail.setPrefHeight(40);

        DoneButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {

                            customer.Email=fixedString(NewEmailTypeField.getText());
                            DisplayedEmail=null;
                            EmailOption.getChildren().remove(2);
                            DisplayedEmail=new FormattedText(customer.Email, -1.0, 0, false);
                            DisplayedEmail.setAlignment(Pos.BASELINE_RIGHT);
                            DisplayedEmail.setPrefWrapLength(120);
                            DisplayedEmail.setPrefWidth(120);
                            DisplayedEmail.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
                            DisplayedEmail.setFill(Color1);
                            DisplayedEmail.setLayoutX(57); DisplayedEmail.setLayoutY(7);
                            EmailOption.getChildren().add(2, DisplayedEmail);
                            try {
                            
                                String url = "jdbc:mysql://localhost:3306/javadatabase";
                                String user = "root";
                                String password = "";
                                if (customer.Email==null) customer.Email = "";
                              
                                    try(Connection conn= DriverManager.getConnection(url, user, password)) {                                
                                    System.out.println("ket noi thanh cong");
                                    System.out.println(conn.getCatalog());
                                    System.out.println(customer.Password);
                                   
                                    String SqlFullNameSet = "update `tblseller` Set `Email`=? where `Tên Đăng Nhập`=?";
                                    PreparedStatement stmt = conn.prepareStatement(SqlFullNameSet);
                                    stmt.setString(1, NewEmailTypeField.getText());
                                    stmt.setString(2, customer.userName);
                                    stmt.execute();
                                    conn.close();
                                    stmt.close();
                                    } catch (Exception a) {
                                        //TODO: handle exception
                                        a.printStackTrace();
                                    }
                                    deleteChangePasswordPane();
                               
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            deleteChangeEmailPane();
                        }
            }
        );

        ChangingCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteChangeEmailPane();}
            }
        );

        EmailTyping=new VBox(OldEmail, NewEmail);
        EmailTyping.setLayoutX(64); EmailTyping.setLayoutY(224);

        ChangingPane.getChildren().addAll(EmailTyping);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(ChangingPane);
    }

    private void deleteChangeEmailPane()
    {
        OldEmailTitle=null;
        OldEmailTypeBox=null;
        OldEmailTypeField=null;
        OldEmail=null;
        NewEmailTitle=null;
        NewEmailTypeBox=null;
        NewEmailTypeField=null;
        NewEmail=null;
        EmailTyping=null;
        ChangingPane.getChildren().remove(7);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //ChangeUserImage:
    private void changeUserImage()
    {
        ChangingPaneHolder.setHeight(236);
        ChangingPaneHolder.setLayoutY(146);

        ChangingPaneTitle.setLayoutY(162);

        ChangingPaneUpperLine.setLayoutY(189.5);
        ChangingPaneLowerLine.setLayoutY(341.5);

        NavigateButtonsTitle.setLayoutY(352);
        NavigateButtonsFrame.setLayoutY(352);

        DisplayedUserAvatarImage=new ImageView(customer.UserImage);
        DisplayedUserAvatarImage.setFitWidth(72); DisplayedUserAvatarImage.setFitHeight(72);
        DisplayedUserAvatarMask=new Rectangle(72, 72);
        DisplayedUserAvatarMask.setArcWidth(24); DisplayedUserAvatarMask.setArcHeight(24);
        DisplayedUserAvatarMask.setLayoutX(0); DisplayedUserAvatarMask.setLayoutY(0);
        DisplayedUserAvatarImage.setClip(DisplayedUserAvatarMask);
        DisplayedUserAvatar=new Pane(DisplayedUserAvatarImage);
        DisplayedUserAvatar.setPrefWidth(72); DisplayedUserAvatar.setPrefHeight(72);
        DisplayedUserAvatar.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.10), 8, 0, 0, 4));
        DisplayedUserAvatar.setLayoutX(96); DisplayedUserAvatar.setLayoutY(210);

        Polygon Pointer9=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer9.setFill(Color2);
        Pointer9.setLayoutX(0); Pointer9.setLayoutY(9);
        ResetImageTitle=new FormattedText("Reset image", -1.0, 0, false);
        ResetImageTitle.setPrefWrapLength(132);
        ResetImageTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 8.5));
        ResetImageTitle.setFill(Color2);
        ResetImageTitle.setLayoutX(7); ResetImageTitle.setLayoutY(7);
        ResetImageButtonFrame=new Button();
        ResetImageButtonFrame.setPrefWidth(50); ResetImageButtonFrame.setMinHeight(16); ResetImageButtonFrame.setPrefHeight(16);
        ResetImageButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        ResetImageButtonFrame.setLayoutX(6); ResetImageButtonFrame.setLayoutY(4);
        ResetImageButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    try {DisplayedUserAvatarImage.setImage(new Image(new FileInputStream("materials/image/BlankAvatar.png")));}
                    catch(FileNotFoundException f) {}
                }
            }
        );
        ResetImageOption=new Pane(Pointer9, ResetImageTitle, ResetImageButtonFrame);
        ResetImageOption.setPrefWidth(180); ResetImageOption.setPrefHeight(20);

        Polygon Pointer10=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer10.setFill(Color2);
        Pointer10.setLayoutX(0); Pointer10.setLayoutY(9);
        UploadImageTitle=new FormattedText("Upload from your device", -1.0, 0, false);
        UploadImageTitle.setPrefWrapLength(132);
        UploadImageTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 8.5));
        UploadImageTitle.setFill(Color2);
        UploadImageTitle.setLayoutX(7); UploadImageTitle.setLayoutY(7);
        UploadImageButtonFrame=new Button();
        UploadImageButtonFrame.setPrefWidth(100); UploadImageButtonFrame.setMinHeight(16);UploadImageButtonFrame.setPrefHeight(16);
        UploadImageButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        UploadImageButtonFrame.setLayoutX(6); UploadImageButtonFrame.setLayoutY(4);
        UploadImageButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    try
                    {
                        String imagepath=filechooser.showOpenDialog(stage).getAbsolutePath();
                        if(imagepath!=null) {DisplayedUserAvatarImage.setImage(new Image(imagepath));}
                    }
                    catch(Exception ex) {}
                }
            }
        );
        UploadImageOption=new Pane(Pointer10, UploadImageTitle, UploadImageButtonFrame);
        UploadImageOption.setPrefWidth(180); UploadImageOption.setPrefHeight(20);

        UserImageOptions=new VBox(ResetImageOption, UploadImageOption);
        UserImageOptions.setLayoutX(68); UserImageOptions.setLayoutY(292);

        DoneButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    customer.UserImage=DisplayedUserAvatarImage.getImage();
                    UserAvatarImage.setImage(customer.UserImage);
                    deleteChangeUserImagePane();
                }
            }
        );

        ChangingCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteChangeUserImagePane();}
            }
        );

        ChangingPane.getChildren().addAll(DisplayedUserAvatar, UserImageOptions);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(ChangingPane);
    }

    private void deleteChangeUserImagePane()
    {
        ResetImageTitle=null;
        ResetImageButtonFrame=null;
        ResetImageOption=null;
        UploadImageTitle=null;
        UploadImageButtonFrame=null;
        UploadImageOption=null;
        UserImageOptions=null;
        DisplayedUserAvatarImage=null;
        DisplayedUserAvatarMask=null;
        ChangingPane.getChildren().remove(7);
        ChangingPane.getChildren().remove(7);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //ChangePassword:
    private void changePassword()
    {
        ChangingPaneHolder.setHeight(224);
        ChangingPaneHolder.setLayoutY(152);

        ChangingPaneTitle.setLayoutY(168);

        ChangingPaneUpperLine.setLayoutY(195.5);
        ChangingPaneLowerLine.setLayoutY(331.5);

        NavigateButtonsTitle.setLayoutY(346);
        NavigateButtonsFrame.setLayoutY(346);

        OldPasswordTitle= new FormattedText("Password :", -0.5, 0, false);
        OldPasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        OldPasswordTitle.setFill(Color2);
        OldPasswordTitle.setLayoutX(8); OldPasswordTitle.setLayoutY(4);
        OldPasswordTypeBox=new Rectangle(136, 20, Color3);
        OldPasswordTypeBox.setArcWidth(16); OldPasswordTypeBox.setArcHeight(16);
        OldPasswordTypeBox.setLayoutX(0); OldPasswordTypeBox.setLayoutY(16);
        OldPasswordTypeField=new PasswordField();
        OldPasswordTypeField.setPromptText("Type password here...");
        OldPasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        OldPasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        OldPasswordTypeField.setSkin(new PasswordMaskSkin(OldPasswordTypeField, '\u0078'));
        OldPasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        OldPasswordTypeField.setPrefWidth(136); OldPasswordTypeField.setPrefHeight(20);
        OldPasswordTypeField.setLayoutX(0); OldPasswordTypeField.setLayoutY(16);
        OldPasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {OldPasswordTypeField.setPromptText("");}
                    else {OldPasswordTypeField.setPromptText("Type password here...");}
                }
            }
        );
        OldPasswordTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=OldPasswordTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        OldPasswordTypeField.setText(BadInput.substring(0, 32));
                        OldPasswordTypeField.positionCaret(32);
                    }
                }
            }
        );
        OldPassword=new Pane(OldPasswordTitle, OldPasswordTypeBox, OldPasswordTypeField);
        OldPassword.setPrefWidth(136); OldPassword.setPrefHeight(40);

        NewPasswordTitle=new FormattedText("New password :", -0.5, 0, false);
        NewPasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        NewPasswordTitle.setFill(Color2);
        NewPasswordTitle.setLayoutX(8); NewPasswordTitle.setLayoutY(4);
        NewPasswordTypeBox=new Rectangle(136, 20, Color3);
        NewPasswordTypeBox.setArcWidth(16); NewPasswordTypeBox.setArcHeight(16);
        NewPasswordTypeBox.setLayoutX(0); NewPasswordTypeBox.setLayoutY(16);
        NewPasswordTypeField=new PasswordField();
        NewPasswordTypeField.setPromptText("Type new password here...");
        NewPasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        NewPasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        NewPasswordTypeField.setSkin(new PasswordMaskSkin(NewPasswordTypeField, '\u0078'));
        NewPasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        NewPasswordTypeField.setPrefWidth(136); NewPasswordTypeField.setPrefHeight(20);
        NewPasswordTypeField.setLayoutX(0); NewPasswordTypeField.setLayoutY(16);
        NewPasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {NewPasswordTypeField.setPromptText("");}
                    else {NewPasswordTypeField.setPromptText("Type new password here...");}
                }
            }
        );
        NewPasswordTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=NewPasswordTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        NewPasswordTypeField.setText(BadInput.substring(0, 32));
                        NewPasswordTypeField.positionCaret(32);
                    }
                }
            }
        );
        NewPassword=new Pane(NewPasswordTitle, NewPasswordTypeBox, NewPasswordTypeField);
        NewPassword.setPrefWidth(136); NewPassword.setPrefHeight(40);

        ReNewPasswordTitle=new FormattedText("Re-type new password :", -0.5, 0, false);
        ReNewPasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        ReNewPasswordTitle.setFill(Color2);
        ReNewPasswordTitle.setLayoutX(8); ReNewPasswordTitle.setLayoutY(4);
        ReNewPasswordTypeBox=new Rectangle(136, 20, Color3);
        ReNewPasswordTypeBox.setArcWidth(16); ReNewPasswordTypeBox.setArcHeight(16);
        ReNewPasswordTypeBox.setLayoutX(0); ReNewPasswordTypeBox.setLayoutY(16);
        ReNewPasswordTypeField=new PasswordField();
        ReNewPasswordTypeField.setPromptText("Re-type new password here...");
        ReNewPasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        ReNewPasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        ReNewPasswordTypeField.setSkin(new PasswordMaskSkin(ReNewPasswordTypeField, '\u0078'));
        ReNewPasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        ReNewPasswordTypeField.setPrefWidth(136); ReNewPasswordTypeField.setPrefHeight(20);
        ReNewPasswordTypeField.setLayoutX(0); ReNewPasswordTypeField.setLayoutY(16);
        ReNewPasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {ReNewPasswordTypeField.setPromptText("");}
                    else {ReNewPasswordTypeField.setPromptText("Re-type new password here...");}
                }
            }
        );
        ReNewPasswordTypeField.setOnKeyTyped
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String BadInput=ReNewPasswordTypeField.getText();
                    if(BadInput.length()>32)
                    {
                        ReNewPasswordTypeField.setText(BadInput.substring(0, 32));
                        ReNewPasswordTypeField.positionCaret(32);
                    }
                }
            }
        );
        ReNewPassword=new Pane(ReNewPasswordTitle, ReNewPasswordTypeBox, ReNewPasswordTypeField);
        ReNewPassword.setPrefWidth(136); ReNewPassword.setPrefHeight(40);

        DoneButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    ValidatePassword check = new ValidatePassword();
                    Hashing hashingNewPass = new Hashing();
                    try {                 
                        String url = "jdbc:mysql://localhost:3306/javadatabase";
                        String user = "root";
                        String password = "";
                                try(Connection conn= DriverManager.getConnection(url, user, password)) {                                
                                    System.out.println("ket noi thanh cong");
                                    System.out.println(conn.getCatalog());
                                    System.out.println(customer.Password);
                                    if (check.ValidatePassword(OldPasswordTypeField.getText(), customer.Password)&& NewPasswordTypeField.getText().equals(ReNewPasswordTypeField.getText())){
                                        System.out.println("Success");
                                        customer.Password=hashingNewPass.Hashing(NewPasswordTypeField.getText());
                                        String Sql = "update `tblseller` Set `Password`=? where `Tên Đăng Nhập`=?";
                                        PreparedStatement ps = conn.prepareStatement(Sql);
                                        ps.setString(1, customer.Password);
                                        ps.setString(2, customer.userName);
                                        ps.execute();
                                        conn.close();
                                        ps.close();
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "Please try again", "Try again", JOptionPane.ERROR_MESSAGE);
                                        return;    
                                    }
                            }   catch (Exception a) {
                                    //TODO: handle exception
                                    a.printStackTrace();
                                }
                            
                           deleteChangePasswordPane();
                        
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        );

        ChangingCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteChangePasswordPane();}
            }
        );

        PasswordTyping=new VBox(OldPassword, NewPassword, ReNewPassword);
        PasswordTyping.setLayoutX(64); PasswordTyping.setLayoutY(204);

        ChangingPane.getChildren().addAll(PasswordTyping);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(ChangingPane);
    }

    private void deleteChangePasswordPane()
    {
        OldPasswordTitle=null;
        OldPasswordTypeBox=null;
        OldPasswordTypeField=null;
        OldPassword=null;
        NewPasswordTitle=null;
        NewPasswordTypeBox=null;
        NewPasswordTypeField=null;
        NewPassword=null;
        ReNewPasswordTitle=null;
        ReNewPasswordTypeBox=null;
        ReNewPasswordTypeField=null;
        ReNewPassword=null;
        PasswordTyping=null;
        ChangingPane.getChildren().remove(7);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //SignOut:
    private void signout()
    {
        SigningPaneHolder.setHeight(88);
        SigningPaneHolder.setLayoutY(220);

        SigningOutTitle.setLayoutY(236);

        SigningPaneUpperLine.setLayoutY(263.5);
        SigningPaneLowerLine.setVisible(false);

        SignOutButton.setLayoutX(75); SignOutButton.setLayoutY(278);
        SignOutButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    customer.FullName=null;
                    customer.EditedName="(none)";
                    customer.Email=null;
                    customer.Password= null;
                    customer.PhoneNumber=null;
                    customer.isLoggedIn=false;
                    customer.userName=null;
                   
                    repaintPage();
                    deleteSignOutPane();
                }
            }
        );

        SigningCancelButton.setLayoutX(149); SigningCancelButton.setLayoutY(278);
        SigningCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteSignOutPane();}
            }
        );

        SigningPane.getChildren().add(2, SigningOutTitle);
        SigningPane.getChildren().addAll(SignOutButton, SigningCancelButton);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(SigningPane);
    }

    private void deleteSignOutPane()
    {
        SigningPaneLowerLine.setVisible(true);
        SignOutButtonFrame.setOnAction(null);
        SigningCancelButtonFrame.setOnAction(null);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(2);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //SignIn:
    private void signin()
    {
        SigningPaneHolder.setHeight(224);
        SigningPaneHolder.setLayoutY(152);

        SigningInTitle.setLayoutY(168);

        SigningPaneUpperLine.setLayoutY(195.5);
        SigningPaneLowerLine.setLayoutY(291.5);

        OrText.setLayoutX(126); OrText.setLayoutY(324);

        SignInUsernameTitle= new FormattedText("Username :", -0.5, 0, false);
        SignInUsernameTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        SignInUsernameTitle.setFill(Color2);
        SignInUsernameTitle.setLayoutX(8); SignInUsernameTitle.setLayoutY(4);
        SignInUsernameTypeBox=new Rectangle(136, 20, Color3);
        SignInUsernameTypeBox.setArcWidth(16); SignInUsernameTypeBox.setArcHeight(16);
        SignInUsernameTypeBox.setLayoutX(0); SignInUsernameTypeBox.setLayoutY(16);
        SignInUsernameTypeField=new TextField();
        SignInUsernameTypeField.setPromptText("Type username here...");
        SignInUsernameTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        SignInUsernameTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        SignInUsernameTypeField.setAlignment(Pos.CENTER_LEFT);
        SignInUsernameTypeField.setPrefWidth(136); SignInUsernameTypeField.setPrefHeight(20);
        SignInUsernameTypeField.setLayoutX(0); SignInUsernameTypeField.setLayoutY(16);
        SignInUsernameTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {SignInUsernameTypeField.setPromptText("");}
                    else {SignInUsernameTypeField.setPromptText("Type username here...");}
                }
            }
        );
        SignInUsername=new Pane(SignInUsernameTitle, SignInUsernameTypeBox, SignInUsernameTypeField);
        SignInUsername.setPrefWidth(136); SignInUsername.setPrefHeight(40);

        SignInPasswordTitle=new FormattedText("Password :", -0.5, 0, false);
        SignInPasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        SignInPasswordTitle.setFill(Color2);
        SignInPasswordTitle.setLayoutX(8); SignInPasswordTitle.setLayoutY(4);
        SignInPasswordTypeBox=new Rectangle(136, 20, Color3);
        SignInPasswordTypeBox.setArcWidth(16); SignInPasswordTypeBox.setArcHeight(16);
        SignInPasswordTypeBox.setLayoutX(0); SignInPasswordTypeBox.setLayoutY(16);
        SignInPasswordTypeField=new PasswordField();
        SignInPasswordTypeField.setPromptText("Type password here...");
        SignInPasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        SignInPasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        SignInPasswordTypeField.setSkin(new PasswordMaskSkin(SignInPasswordTypeField, '\u0078'));
        SignInPasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        SignInPasswordTypeField.setPrefWidth(136); SignInPasswordTypeField.setPrefHeight(20);
        SignInPasswordTypeField.setLayoutX(0); SignInPasswordTypeField.setLayoutY(16);
        SignInPasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {SignInPasswordTypeField.setPromptText("");}
                    else {SignInPasswordTypeField.setPromptText("Type password here...");}
                }
            }
        );
        SignInPassword=new Pane(SignInPasswordTitle, SignInPasswordTypeBox, SignInPasswordTypeField);
        SignInPassword.setPrefWidth(136); SignInPassword.setPrefHeight(40);

        SigningInTyping=new VBox(SignInUsername, SignInPassword);
        SigningInTyping.setLayoutX(64); SigningInTyping.setLayoutY(204);

        SignInButton.setLayoutX(79); SignInButton.setLayoutY(306);
        SignInButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    /*
                    if(!condition)
                    {
                        isAlertedSignIn=true;
                        SigningPane.getChildren().add(SignInAlert);
                    }
                     */
                    String url = "jdbc:mysql://localhost:3306/javadatabase";
                    String user = "root";
                    String password = "";
                    UserInformation user2 = null;
                    ValidatePassword VP = new ValidatePassword();
                    // User user;
                    // String sqlInsert = "INSERT INTO `tblseller`(`Email`, `Password`, `Họ và tên`, `SĐT`,`Số tiền đã mua`) VALUES (?,?,?,?,?)";
                    String sql = "SELECT * FROM `tblseller` WHERE `Tên đăng nhập`=?";
            
                         try(Connection conn= DriverManager.getConnection(url, user, password)){
                            System.out.println("ket noi thanh cong");
                            System.out.println(conn.getCatalog());
                            
                            // select all student
                            PreparedStatement  stmt = conn.prepareStatement(sql);
                            stmt.setString(1, SignInUsernameTypeField.getText().toLowerCase());
                            Hashing passHashing = new Hashing();
                            System.out.println( passHashing.Hashing(String.valueOf(SignInPasswordTypeField.getText())));
                            ResultSet rs = stmt.executeQuery();
                            if (rs.next()) {
                                if (VP.ValidatePassword(String.valueOf(SignInPasswordTypeField.getText()), rs.getString(2))){
                                user2 = new UserInformation();
                                user2.Password = rs.getString(2);
                                customer.userName = rs.getString(1);
                                customer.FullName = rs.getString(3);
                                customer.Email = rs.getString(7);
                                customer.PhoneNumber = rs.getString(5);
                                customer.isLoggedIn = true;          
                                customer.Password = rs.getString(2);                     
                                }
                            }
                            if (user2 != null) {
                                JOptionPane.showMessageDialog(null, "Login succesfully!", "Logged In", JOptionPane.INFORMATION_MESSAGE);                                
                                repaintPage();
                                deleteSignInPane();
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Failed to login", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            // change
        
                            stmt.close();
                            conn.close();
                         } 
                         catch(Exception E)
                         {
                            System.out.println("ST wrong!!");
                            E.printStackTrace();
                         }
                   
                    repaintPage();
                    deleteSignInPane();
                }
            }
        );

        SignUpButton.setLayoutX(113); SignUpButton.setLayoutY(346);
        SignUpButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                       
                    deleteSignInPane();
                    signup();
                }
            }
        );

        SigningCancelButton.setLayoutX(149); SigningCancelButton.setLayoutY(306);
        SigningCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteSignInPane();}
            }
        );

        SigningPane.getChildren().add(2, SigningInTitle);
        SigningPane.getChildren().addAll(SigningInTyping, OrText, SignInButton, SignUpButton, SigningCancelButton);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(SigningPane);
    }

    public void deleteSignInPane()
    {
        SignInUsername=null;
        SignInUsernameTitle=null;
        SignInUsernameTypeBox=null;
        SignInUsernameTypeField=null;
        SignInPassword=null;
        SignInPasswordTitle=null;
        SignInPasswordTypeBox=null;
        SignInPasswordTypeField=null;
        SigningInTyping=null;
        SignInButtonFrame.setOnAction(null);
        SignUpButtonFrame.setOnAction(null);
        SigningCancelButtonFrame.setOnAction(null);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        // if(isAlertedSignIn==true)
        // {
        //     isAlertedSignIn=false;
        //     SigningPane.getChildren().remove(5);
        // }
        SigningPane.getChildren().remove(2);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //SignUp:
    private void signup()
    {
        SigningPaneHolder.setHeight(264);
        SigningPaneHolder.setLayoutY(132);

        SigningUpTitle.setLayoutY(148);

        SigningPaneUpperLine.setLayoutY(175.5);
        SigningPaneLowerLine.setLayoutY(311.5);

        OrText.setLayoutX(126); OrText.setLayoutY(344);

        SignUpUsernameTitle= new FormattedText("Username :", -0.5, 0, false);
        SignUpUsernameTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        SignUpUsernameTitle.setFill(Color2);
        SignUpUsernameTitle.setLayoutX(8); SignUpUsernameTitle.setLayoutY(4);
        SignUpUsernameTypeBox=new Rectangle(136, 20, Color3);
        SignUpUsernameTypeBox.setArcWidth(16); SignUpUsernameTypeBox.setArcHeight(16);
        SignUpUsernameTypeBox.setLayoutX(0); SignUpUsernameTypeBox.setLayoutY(16);
        SignUpUsernameTypeField=new TextField();
        SignUpUsernameTypeField.setPromptText("Type username here...");
        SignUpUsernameTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        SignUpUsernameTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        SignUpUsernameTypeField.setAlignment(Pos.CENTER_LEFT);
        SignUpUsernameTypeField.setPrefWidth(136); SignUpUsernameTypeField.setPrefHeight(20);
        SignUpUsernameTypeField.setLayoutX(0); SignUpUsernameTypeField.setLayoutY(16);
        SignUpUsernameTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {SignUpUsernameTypeField.setPromptText("");}
                    else {SignUpUsernameTypeField.setPromptText("Type username here...");}
                }
            }
        );
        SignUpUsername=new Pane(SignUpUsernameTitle, SignUpUsernameTypeBox, SignUpUsernameTypeField);
        SignUpUsername.setPrefWidth(136); SignUpUsername.setPrefHeight(40);

        SignUpPasswordTitle=new FormattedText("Password :", -0.5, 0, false);
        SignUpPasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        SignUpPasswordTitle.setFill(Color2);
        SignUpPasswordTitle.setLayoutX(8); SignUpPasswordTitle.setLayoutY(4);
        SignUpPasswordTypeBox=new Rectangle(136, 20, Color3);
        SignUpPasswordTypeBox.setArcWidth(16); SignUpPasswordTypeBox.setArcHeight(16);
        SignUpPasswordTypeBox.setLayoutX(0); SignUpPasswordTypeBox.setLayoutY(16);
        SignUpPasswordTypeField=new PasswordField();
        SignUpPasswordTypeField.setPromptText("Type password here...");
        SignUpPasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        SignUpPasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        SignUpPasswordTypeField.setSkin(new PasswordMaskSkin(SignUpPasswordTypeField, '\u0078'));
        SignUpPasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        SignUpPasswordTypeField.setPrefWidth(136); SignUpPasswordTypeField.setPrefHeight(20);
        SignUpPasswordTypeField.setLayoutX(0); SignUpPasswordTypeField.setLayoutY(16);
        SignUpPasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {SignUpPasswordTypeField.setPromptText("");}
                    else {SignUpPasswordTypeField.setPromptText("Type password here...");}
                }
            }
        );
        SignUpPassword=new Pane(SignUpPasswordTitle, SignUpPasswordTypeBox, SignUpPasswordTypeField);
        SignUpPassword.setPrefWidth(136); SignUpPassword.setPrefHeight(40);

        SignUpRePasswordTitle=new FormattedText("Re-type password :", -0.5, 0, false);
        SignUpRePasswordTitle.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8.5));
        SignUpRePasswordTitle.setFill(Color2);
        SignUpRePasswordTitle.setLayoutX(8); SignUpRePasswordTitle.setLayoutY(4);
        SignUpRePasswordTypeBox=new Rectangle(136, 20, Color3);
        SignUpRePasswordTypeBox.setArcWidth(16); SignUpRePasswordTypeBox.setArcHeight(16);
        SignUpRePasswordTypeBox.setLayoutX(0); SignUpRePasswordTypeBox.setLayoutY(16);
        SignUpRePasswordTypeField=new PasswordField();
        SignUpRePasswordTypeField.setPromptText("Re-type password here...");
        SignUpRePasswordTypeField.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 8px; -fx-text-fill: #472B2B; -fx-prompt-text-fill: #C5C5C5;");
        SignUpRePasswordTypeField.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 8));
        SignUpRePasswordTypeField.setSkin(new PasswordMaskSkin(SignUpRePasswordTypeField, '\u0078'));
        SignUpRePasswordTypeField.setAlignment(Pos.CENTER_LEFT);
        SignUpRePasswordTypeField.setPrefWidth(136); SignUpRePasswordTypeField.setPrefHeight(20);
        SignUpRePasswordTypeField.setLayoutX(0); SignUpRePasswordTypeField.setLayoutY(16);
        SignUpRePasswordTypeField.focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (newPropertyValue) {SignUpRePasswordTypeField.setPromptText("");}
                    else {SignUpRePasswordTypeField.setPromptText("Re-type password here...");}
                }
            }
        );
        SignUpRePassword=new Pane(SignUpRePasswordTitle, SignUpRePasswordTypeBox, SignUpRePasswordTypeField);
        SignUpRePassword.setPrefWidth(136); SignUpRePassword.setPrefHeight(40);

        SigningUpTyping=new VBox(SignUpUsername, SignUpPassword, SignUpRePassword);
        SigningUpTyping.setLayoutX(64); SigningUpTyping.setLayoutY(184);

        SignUpButton.setLayoutX(77); SignUpButton.setLayoutY(326);
        SignUpButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    /*
                    if(!condition)
                    {
                        isAlertedSignUp=true;
                        SigningPane.getChildren().addAll(SignUpAlert1, SignUpAlert2);
                    }
                     */
                    String url = "jdbc:mysql://localhost:3306/javadatabase";
                    String user = "root";
                    String password = "";
                    String sqlInsert = "INSERT INTO `tblseller`(`Tên đăng nhập`, `Password`) VALUES (?,?)";
                    String check = "SELECT * FROM `tblseller` where `Tên đăng Nhập`=?" ; 
                    // String selectAll = "SELECT * FROM `tblseller`";
                    boolean userNameCheck = false;
                    char [] passtoString = SignUpPasswordTypeField.getText().toCharArray();
                    char [] userNametoString = SignUpUsernameTypeField.getText().toCharArray();
                    int countNumbersPass = 0;
                    int countUpperCasePass =0;
                    int countNumbersUserName = 0;
                    String username = SignUpUsernameTypeField.getText();
                    String passwordtf = SignUpPasswordTypeField.getText();
                    // check the numbers of pass
                    for (int i = 0;i<passwordtf.length();i++){
                        if (Character.isDigit(passtoString[i])){
                           countNumbersPass++;
                        }
                        if (Character.isUpperCase(passtoString[i]))
                            countUpperCasePass++;
                    }
                    for (int i =0 ; i<username.length();i++){
                        if (Character.isDigit(userNametoString[i])){
                            countNumbersUserName++;
                        }
                    }
                    
                    try(Connection conn= DriverManager.getConnection(url, user, password)){
                    System.out.println("ket noi thanh cong");
                    System.out.println(conn.getCatalog());
                    PreparedStatement stmt = conn.prepareStatement(check);
                    stmt.setString(1, username);
                
                    ResultSet rs = stmt.executeQuery();
        
                    while (rs.next()) {
        
                         if (rs.getString(1).equals(username)){
                            userNameCheck = true;}
                                              
                    }
                    // change
                     if (passwordtf.isEmpty() || username.isEmpty() ){
                        JOptionPane.showMessageDialog(null, "Please enter all the fields", "Try again", JOptionPane.ERROR_MESSAGE);;
                        return;
                    }
                    if (username.length()<8 || countNumbersUserName<2){
                        JOptionPane.showMessageDialog(null,
                        "User name must has 8 character or above and at least 2 number ",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
                    }
                    if (userNameCheck){
                        JOptionPane.showMessageDialog(null,
                        "User name is used!",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
                    }
                    if (passwordtf.length()<8){
                        JOptionPane.showMessageDialog(null,
                        "Password must contain 8 character or above",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
                    }
        
                    if (!passwordtf.equals(SignUpRePasswordTypeField.getText())){
                        JOptionPane.showMessageDialog(null,
                        "Confirm Password does not match",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
                }
                if (countNumbersPass<2){
                    JOptionPane.showMessageDialog(null,
                    "Not enough numbers!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        
                }
                if (countUpperCasePass<1){
                    JOptionPane.showMessageDialog(null,
                    "Not enough Uppercase!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
                }
                Hashing passDB = new Hashing();
             System.out.println(passDB.Hashing(passwordtf));
                            // select all student
                            stmt = conn.prepareStatement(sqlInsert);
                            stmt.setString(1,username);
                            stmt.setString(2,passDB.Hashing(passwordtf));
                           
                            stmt.execute();
        
                           JOptionPane.showMessageDialog(null, "<HTML> Đăng Kí thành công <HTML>");
                            stmt.close();
                            conn.close();
                     
                         } 
                         catch(Exception E)
                         {
                             E.printStackTrace();
                         }
            
                    repaintPage();
                    deleteSignUpPane();
                }
            }
        );

        SignInButton.setLayoutX(113); SignInButton.setLayoutY(366);
        SignInButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    deleteSignUpPane();
                    signin();
                }
            }
        );

        SigningCancelButton.setLayoutX(149); SigningCancelButton.setLayoutY(326);
        SigningCancelButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {deleteSignInPane();}
            }
        );

        SigningPane.getChildren().add(2, SigningUpTitle);
        SigningPane.getChildren().addAll(SigningUpTyping, OrText, SignUpButton, SignInButton, SigningCancelButton);
        BlurBox.setEffect(new BoxBlur(20, 16, 4));
        this.getChildren().add(SigningPane);
    }

    public void deleteSignUpPane()
    {
        SignUpUsername=null;
        SignUpUsernameTitle=null;
        SignUpUsernameTypeBox=null;
        SignUpUsernameTypeField=null;
        SignUpPassword=null;
        SignUpPasswordTitle=null;
        SignUpPasswordTypeBox=null;
        SignUpPasswordTypeField=null;
        SignUpRePassword=null;
        SignUpRePasswordTitle=null;
        SignUpRePasswordTypeBox=null;
        SignUpRePasswordTypeField=null;
        SigningUpTyping=null;
        SignUpButtonFrame.setOnAction(null);
        SignInButtonFrame.setOnAction(null);
        SigningCancelButtonFrame.setOnAction(null);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        SigningPane.getChildren().remove(5);
        if(isAlertedSignUp==true)
        {
            isAlertedSignUp=false;
            SigningPane.getChildren().remove(5);
            SigningPane.getChildren().remove(5);
        }
        SigningPane.getChildren().remove(2);
        BlurBox.setEffect(null);
        this.getChildren().remove(1);
    }

    //RepaintPage:
    private void repaintPage()
    {
        UserAvatarImage.setImage(customer.UserImage);

        DisplayedFullName=null;
        FullNameOption.getChildren().remove(2);
        DisplayedFullName=new FormattedText(customer.FullName, -1.0, 0, false);
        DisplayedFullName.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedFullName.setPrefWrapLength(120);
        DisplayedFullName.setPrefWidth(120);
        DisplayedFullName.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedFullName.setFill(Color1);
        DisplayedFullName.setLayoutX(57); DisplayedFullName.setLayoutY(7);
        FullNameOption.getChildren().add(2, DisplayedFullName);

        DisplayedPhoneNumber=null;
        PhoneNumberOption.getChildren().remove(2);
        DisplayedPhoneNumber=new FormattedText(customer.PhoneNumber, -1.0, 0, false);
        DisplayedPhoneNumber.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedPhoneNumber.setPrefWrapLength(120);
        DisplayedPhoneNumber.setPrefWidth(120);
        DisplayedPhoneNumber.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedPhoneNumber.setFill(Color1);
        DisplayedPhoneNumber.setLayoutX(57); DisplayedPhoneNumber.setLayoutY(7);
        PhoneNumberOption.getChildren().add(2, DisplayedPhoneNumber);

        DisplayedEmail=null;
        EmailOption.getChildren().remove(2);
        DisplayedEmail=new FormattedText(customer.Email, -1.0, 0, false);
        DisplayedEmail.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedEmail.setPrefWrapLength(120);
        DisplayedEmail.setPrefWidth(120);
        DisplayedEmail.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedEmail.setFill(Color1);
        DisplayedEmail.setLayoutX(57); DisplayedEmail.setLayoutY(7);
        EmailOption.getChildren().add(2, DisplayedEmail);

        SignButtonTitle=null;
        SignButton.getChildren().remove(1);
        SignButtonTitle=new FormattedText(customer.isLoggedIn?"Sign out":"Sign in", -1.0, 0, false);
        SignButtonTitle.setAlignment(Pos.CENTER);
        SignButtonTitle.setPrefWrapLength(56);
        SignButtonTitle.setPrefWidth(56); SignButtonTitle.setPrefHeight(24);
        SignButtonTitle.setFont(CustomFont.createFont("Raleway - Semibold", "ttf", 12));
        SignButtonTitle.setFill(Color2);
        SignButtonTitle.setLayoutX(8); SignButtonTitle.setLayoutY(0);
        SignButton.getChildren().add(1, SignButtonTitle);

        TurnNotificationsButton=null;
        TurnNotificationsOption.getChildren().remove(2);
        TurnNotificationsButton=new BinarySettingsButton(customer.TurnNotifications, 1);
        TurnNotificationsButton.setLayoutX(152); TurnNotificationsButton.setLayoutY(4);
        TurnNotificationsOption.getChildren().add(TurnNotificationsButton);
        PreviewsButton=null;
        PreviewsOption.getChildren().remove(2);
        PreviewsButton=new BinarySettingsButton(customer.Previews, 2);
        PreviewsButton.setLayoutX(152); PreviewsButton.setLayoutY(4);
        PreviewsOption.getChildren().add(PreviewsButton);
        VibrationsButton=null;
        VibrationsOption.getChildren().remove(2);
        VibrationsButton=new BinarySettingsButton(customer.Vibrations, 3);
        VibrationsButton.setLayoutX(152); VibrationsButton.setLayoutY(4);
        VibrationsOption.getChildren().add(VibrationsButton);
    }

    //Setup:
    public void setup(UserInformation customer, DrinkMap drink)
    {
        //customer.isLoggedIn=true;
        Stop GradientStops[]={new Stop(0, Color.rgb(252, 247, 247, 0.6)), new Stop(1, Color.rgb(252, 252, 249, 0.7))};
        filechooser=new FileChooser();
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

        //SetCustomer:
        this.customer=customer;
        this.drink=drink;

        //ChangingPaneSetup:
        BlurredChangingPane=new Rectangle(264, 528, new LinearGradient(132, 0, 132, 528, true, CycleMethod.NO_CYCLE, GradientStops));
        BlurredChangingPane.setLayoutX(0); BlurredChangingPane.setLayoutY(0);

        ChangingPaneHolder=new Rectangle();
        ChangingPaneHolder.setWidth(168);
        ChangingPaneHolder.setFill(Color.rgb(71, 43, 43, 0.9));
        ChangingPaneHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 6));
        ChangingPaneHolder.setArcWidth(32); ChangingPaneHolder.setArcHeight(32);
        ChangingPaneHolder.setLayoutX(48);

        ChangingPaneTitle=new FormattedText("Change Data", -1.0, 0, false);
        ChangingPaneTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        ChangingPaneTitle.setFill(Color2);
        ChangingPaneTitle.setLayoutX(64);

        ChangingPaneUpperLine=new Rectangle(136, 1, Color2);
        ChangingPaneUpperLine.setLayoutX(64);
        ChangingPaneLowerLine=new Rectangle(136, 1, Color2);
        ChangingPaneLowerLine.setLayoutX(64);

        DoneButtonTitle=new FormattedText("Done", -1.0, 0, true);
        DoneButtonTitle.setPrefWidth(28);
        DoneButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        DoneButtonTitle.setFill(Color2);
        ChangingCancelButtonTitle=new FormattedText("Cancel", -1.0, 0, true);
        ChangingCancelButtonTitle.setPrefWidth(36);
        ChangingCancelButtonTitle.setFill(Color2);
        ChangingCancelButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        NavigateButtonsTitle=new HBox(39, DoneButtonTitle, ChangingCancelButtonTitle);
        NavigateButtonsTitle.setLayoutX(81);

        DoneButtonFrame=new Button();
        DoneButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        DoneButtonFrame.setMinWidth(28); DoneButtonFrame.setMinHeight(13); DoneButtonFrame.setPrefWidth(28); DoneButtonFrame.setPrefHeight(13);
        ChangingCancelButtonFrame=new Button();
        ChangingCancelButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        ChangingCancelButtonFrame.setMinHeight(36); ChangingCancelButtonFrame.setMinHeight(13); ChangingCancelButtonFrame.setPrefWidth(36); ChangingCancelButtonFrame.setPrefHeight(13);
        NavigateButtonsFrame=new HBox(39, DoneButtonFrame, ChangingCancelButtonFrame);
        NavigateButtonsFrame.setLayoutX(80);

        ChangingPane=new Pane(BlurredChangingPane, ChangingPaneHolder, ChangingPaneTitle, ChangingPaneUpperLine, ChangingPaneLowerLine, NavigateButtonsTitle, NavigateButtonsFrame);
        
        //SigningPaneSetup:
        BlurredSigningPane=new Rectangle(264, 528, new LinearGradient(132, 0, 132, 528, true, CycleMethod.NO_CYCLE, GradientStops));
        BlurredSigningPane.setLayoutX(0); BlurredSigningPane.setLayoutY(0);

        SigningPaneHolder=new Rectangle();
        SigningPaneHolder.setWidth(168);
        SigningPaneHolder.setFill(Color.rgb(71, 43, 43, 0.9));
        SigningPaneHolder.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.25), 10, 0, 0, 6));
        SigningPaneHolder.setArcWidth(32); SigningPaneHolder.setArcHeight(32);
        SigningPaneHolder.setLayoutX(48);

        SigningOutTitle=new FormattedText("Signing out", -1.0, 0, false);
        SigningOutTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        SigningOutTitle.setFill(Color2);
        SigningOutTitle.setLayoutX(64);

        SigningInTitle=new FormattedText("Signing in", -1.0, 0, false);
        SigningInTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        SigningInTitle.setFill(Color2);
        SigningInTitle.setLayoutX(64);

        SigningUpTitle=new FormattedText("Signing up", -1.0, 0, false);
        SigningUpTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        SigningUpTitle.setFill(Color2);
        SigningUpTitle.setLayoutX(64);

        SigningPaneUpperLine=new Rectangle(136, 1, Color2);
        SigningPaneUpperLine.setLayoutX(64);
        SigningPaneLowerLine=new Rectangle(136, 1, Color2);
        SigningPaneLowerLine.setLayoutX(64);

        SignOutButtonTitle=new FormattedText("Sign out", -1.0, 0, true);
        SignOutButtonTitle.setPrefWidth(42);
        SignOutButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        SignOutButtonTitle.setFill(Color2);
        SignOutButtonFrame=new Button();
        SignOutButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        SignOutButtonFrame.setMinHeight(13); SignOutButtonFrame.setPrefWidth(42); SignOutButtonFrame.setPrefHeight(13);
        SignOutButtonFrame.setLayoutX(0); SignOutButtonFrame.setLayoutY(0);
        SignOutButton=new Pane(SignOutButtonTitle, SignOutButtonFrame);
        SignOutButton.setPrefWidth(42); SignOutButton.setPrefHeight(13);

        SignInButtonTitle=new FormattedText("Sign in", -1.0, 0, true);
        SignInButtonTitle.setPrefWidth(34);
        SignInButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        SignInButtonTitle.setFill(Color2);
        SignInButtonFrame=new Button();
        SignInButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        SignInButtonFrame.setMinHeight(13); SignInButtonFrame.setPrefWidth(34); SignInButtonFrame.setPrefHeight(13);
        SignInButtonFrame.setLayoutX(0); SignInButtonFrame.setLayoutY(0);
        SignInButton=new Pane(SignInButtonTitle, SignInButtonFrame);
        SignInButton.setPrefWidth(42); SignInButton.setPrefHeight(13);

        SignUpButtonTitle=new FormattedText("Sign up", -1.0, 0, true);
        SignUpButtonTitle.setPrefWidth(38);
        SignUpButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        SignUpButtonTitle.setFill(Color2);
        SignUpButtonFrame=new Button();
        SignUpButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        SignUpButtonFrame.setMinHeight(13); SignUpButtonFrame.setPrefWidth(38); SignUpButtonFrame.setPrefHeight(13);
        SignUpButtonFrame.setLayoutX(0); SignUpButtonFrame.setLayoutY(0);
        SignUpButton=new Pane(SignUpButtonTitle, SignUpButtonFrame);
        SignUpButton.setPrefWidth(38); SignUpButton.setPrefHeight(13);

        OrText=new FormattedText("or", -0.5, 0, false);
        OrText.setPrefWidth(12);
        OrText.setFill(Color2);
        OrText.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 11));

        SigningCancelButtonTitle=new FormattedText("Cancel", -1.0, 0, true);
        SigningCancelButtonTitle.setPrefWidth(36);
        SigningCancelButtonTitle.setFill(Color2);
        SigningCancelButtonTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 11));
        SigningCancelButtonFrame=new Button();
        SigningCancelButtonFrame.setStyle(("-fx-border-color: transparent; -fx-background-color: transparent;"));
        SigningCancelButtonFrame.setMinHeight(36); SigningCancelButtonFrame.setMinHeight(13); SigningCancelButtonFrame.setPrefWidth(36); SigningCancelButtonFrame.setPrefHeight(13);
        SigningCancelButton=new Pane(SigningCancelButtonTitle, SigningCancelButtonFrame);
        SigningCancelButton.setPrefWidth(36); SigningCancelButton.setPrefHeight(13);

        SignInAlert=new FormattedText("* Incorrect username or password.", -1.0, 0, false);
        SignInAlert.setPrefWrapLength(145);
        SignInAlert.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 10));
        SignInAlert.setFill(Color1);
        SignInAlert.setLayoutX(55); SignInAlert.setLayoutY(380);

        SignUpAlert1=new FormattedText("* Password must have at least one UPPERCASE letter, 2 numbers and   eight characters in total.", -1.0, 0, false);
        SignUpAlert1.setPrefWrapLength(155);
        SignUpAlert1.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 10));
        SignUpAlert1.setFill(Color1);
        SignUpAlert1.setLayoutX(55); SignUpAlert1.setLayoutY(400);

        SignUpAlert2=new FormattedText("* Re-type password must match       password.", -1.0, 0, false);
        SignUpAlert2.setPrefWrapLength(155);
        SignUpAlert2.setFont(CustomFont.createFont("Raleway - MediumItalic", "ttf", 10));
        SignUpAlert2.setFill(Color1);
        SignUpAlert2.setLayoutX(55); SignUpAlert2.setLayoutY(437);

        SigningPane=new Pane(BlurredSigningPane, SigningPaneHolder, SigningPaneUpperLine, SigningPaneLowerLine);
    }

    //Build:
    private void build()
    {
        //SettingUp:
        setup(customer, drink);

        //Background:
        try {BlurredBackground=new ImageView(new Image(new FileInputStream("materials/image/BlurredBackground.png")));}
        catch(FileNotFoundException f) {}
        BlurredBackground.setFitWidth(264); BlurredBackground.setFitHeight(528);
        BlurredBackground.setSmooth(true);
        BlurredBackground.setCache(true);

        //PageTitle:
        PageTitle=new FormattedText("Your Profile", -1.0, 0, false);
        PageTitle.setFont(CustomFont.createFont("Raleway - ExtraBold", "ttf", 28));
        PageTitle.setPrefWrapLength(170);
        PageTitle.setFill(Color1);
        PageTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 4, 0, 0, 4));
        PageTitle.setLayoutX(23); PageTitle.setLayoutY(44);

        //ReceiptButton:
        ReceiptButtonHolder=new Rectangle(24, 24, Color1);
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
                public void handle(ActionEvent e) {getScene().setRoot(new OrderPage(customer, drink));}
            }
        );

        ReceiptButton=new Pane(ReceiptButtonHolder, ReceiptButtonIcon, ReceiptButtonFrame);
        ReceiptButton.setPrefWidth(24); ReceiptButton.setPrefHeight(24);
        ReceiptButton.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.2), 6, 0, 0, 2));
        ReceiptButton.setLayoutX(216); ReceiptButton.setLayoutY(48);

        //InformationPane:
        InformationPaneHolder=new Rectangle(216, 264, Color3);
        InformationPaneHolder.setArcWidth(32); InformationPaneHolder.setArcHeight(32);
        InformationPaneHolder.setLayoutX(0); InformationPaneHolder.setLayoutY(0);

        UserAvatarImage=new ImageView(customer.UserImage);
        UserAvatarImage.setFitWidth(72); UserAvatarImage.setFitHeight(72);
        UserAvatarMask=new Rectangle(72, 72);
        UserAvatarMask.setArcWidth(24); UserAvatarMask.setArcHeight(24);
        UserAvatarMask.setLayoutX(0); UserAvatarMask.setLayoutY(0);
        UserAvatarImage.setClip(UserAvatarMask);
        UserAvatarImage.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 4, 0, 0, 4));
        UserAvatar=new Pane(UserAvatarImage);
        UserAvatar.setPrefWidth(72); UserAvatar.setPrefHeight(72);
        UserAvatar.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        UserAvatar.setLayoutX(16); UserAvatar.setLayoutY(16);

        UserEditedName=new FormattedText(customer.EditedName, -1.0, 1, false);
        UserEditedName.setPrefWrapLength(100);
        UserEditedName.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 13));
        UserEditedName.setFill(Color1);
        UserEditedName.setLayoutX(98); UserEditedName.setLayoutY(24);

        UserLevelText=new FormattedText("- User level :  "+Integer.toString(customer.UserLevel)+" -", -1.0, 1, false);
        UserLevelText.setPrefWrapLength(100);
        UserLevelText.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 11));
        UserLevelText.setFill(Color1);
        UserLevelText.setLayoutX(98); UserLevelText.setLayoutY(45);

        UserLevelProgressBarHolder=new Rectangle(102, 14, Color1);
        UserLevelProgressBarHolder.setArcWidth(16); UserLevelProgressBarHolder.setArcHeight(16);
        UserLevelProgressBarHolder.setLayoutX(0); UserLevelProgressBarHolder.setLayoutY(0);
        UserLevelProgressText=new Text(DoubleFormatter.format(customer.UserLevelProgress*100)+"%");
        UserLevelProgressText.setTextAlignment(TextAlignment.CENTER);
        UserLevelProgressText.setWrappingWidth(40);
        UserLevelProgressText.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 9));
        UserLevelProgressText.setFill(Color2);
        UserLevelProgressText.setLayoutX(31); UserLevelProgressText.setLayoutY(10);
        UserLevelProgressBar=new Pane(UserLevelProgressBarHolder, UserLevelProgressText);
        UserLevelProgressBar.setPrefWidth(102); UserLevelProgressBar.setPrefHeight(14);
        UserLevelProgressBar.setLayoutX(96); UserLevelProgressBar.setLayoutY(64);

        Polygon Pointer1=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer1.setFill(Color1);
        Pointer1.setLayoutX(0); Pointer1.setLayoutY(10.5);
        FullNameTitle=new FormattedText("Full name:", -1.0, 0, false);
        FullNameTitle.setPrefWrapLength(80);
        FullNameTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        FullNameTitle.setFill(Color1);
        FullNameTitle.setLayoutX(7); FullNameTitle.setLayoutY(7);
        DisplayedFullName=new FormattedText(customer.FullName, -1.0, 0, false);
        DisplayedFullName.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedFullName.setPrefWrapLength(120);
        DisplayedFullName.setPrefWidth(120);
        DisplayedFullName.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedFullName.setFill(Color1);
        DisplayedFullName.setLayoutX(57); DisplayedFullName.setLayoutY(7);
        FullNameOptionButton=new Button();
        FullNameOptionButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        FullNameOptionButton.setPrefWidth(50); FullNameOptionButton.setPrefHeight(24);
        FullNameOptionButton.setLayoutX(4); FullNameOptionButton.setLayoutY(0);
        FullNameOptionButton.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {if(customer.isLoggedIn==true) {changeFullName();}}
            }
        );
        FullNameOption=new Pane(Pointer1, FullNameTitle, DisplayedFullName, FullNameOptionButton);
        FullNameOption.setPrefWidth(178); FullNameOption.setPrefHeight(24);

        Polygon Pointer2=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer2.setFill(Color1);
        Pointer2.setLayoutX(0); Pointer2.setLayoutY(10.5);
        PhoneNumberTitle=new FormattedText("Phone number:", -1.0, 0, false);
        PhoneNumberTitle.setPrefWrapLength(80);
        PhoneNumberTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        PhoneNumberTitle.setFill(Color1);
        PhoneNumberTitle.setLayoutX(7); PhoneNumberTitle.setLayoutY(7);
        DisplayedPhoneNumber=new FormattedText(customer.PhoneNumber, -1.0, 0, false);
        DisplayedPhoneNumber.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedPhoneNumber.setPrefWrapLength(120);
        DisplayedPhoneNumber.setPrefWidth(120);
        DisplayedPhoneNumber.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedPhoneNumber.setFill(Color1);
        DisplayedPhoneNumber.setLayoutX(57); DisplayedPhoneNumber.setLayoutY(7);
        PhoneNumberOptionButton=new Button();
        PhoneNumberOptionButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        PhoneNumberOptionButton.setPrefWidth(72); PhoneNumberOptionButton.setPrefHeight(24);
        PhoneNumberOptionButton.setLayoutX(4); PhoneNumberOptionButton.setLayoutY(0);
        PhoneNumberOptionButton.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {if(customer.isLoggedIn==true) {changePhoneNumber();}}
            }
        );
        PhoneNumberOption=new Pane(Pointer2, PhoneNumberTitle, DisplayedPhoneNumber, PhoneNumberOptionButton);
        PhoneNumberOption.setPrefWidth(178); PhoneNumberOption.setPrefHeight(24);
        
        Polygon Pointer3=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer3.setFill(Color1);
        Pointer3.setLayoutX(0); Pointer3.setLayoutY(10.5);
        EmailTitle=new FormattedText("Email:", -1.0, 0, false);
        EmailTitle.setPrefWrapLength(80);
        EmailTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        EmailTitle.setFill(Color1);
        EmailTitle.setLayoutX(7); EmailTitle.setLayoutY(7);
        DisplayedEmail=new FormattedText(customer.Email, -1.0, 0, false);
        DisplayedEmail.setAlignment(Pos.BASELINE_RIGHT);
        DisplayedEmail.setPrefWrapLength(120);
        DisplayedEmail.setPrefWidth(120);
        DisplayedEmail.setFont(CustomFont.createFont("Raleway - Medium", "ttf", 10));
        DisplayedEmail.setFill(Color1);
        DisplayedEmail.setLayoutX(57); DisplayedEmail.setLayoutY(7);
        EmailOptionButton=new Button();
        EmailOptionButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        EmailOptionButton.setPrefWidth(32); EmailOptionButton.setPrefHeight(24);
        EmailOptionButton.setLayoutX(4); EmailOptionButton.setLayoutY(0);
        EmailOptionButton.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {if(customer.isLoggedIn==true) {changeEmail();}}
            }
        );
        EmailOption=new Pane(Pointer3, EmailTitle, DisplayedEmail, EmailOptionButton);
        EmailOption.setPrefWidth(178); EmailOption.setPrefHeight(24);

        Polygon Pointer4=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer4.setFill(Color1);
        Pointer4.setLayoutX(0); Pointer4.setLayoutY(10.5);
        ChangeProfilePictureTitle=new FormattedText("Change your profile picture", -1.0, 0, true);
        ChangeProfilePictureTitle.setPrefWrapLength(132);
        ChangeProfilePictureTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 10));
        ChangeProfilePictureTitle.setFill(Color1);
        ChangeProfilePictureTitle.setLayoutX(7); ChangeProfilePictureTitle.setLayoutY(7);
        ChangeProfilePictureButton=new Button();
        ChangeProfilePictureButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        ChangeProfilePictureButton.setPrefWidth(124); ChangeProfilePictureButton.setPrefHeight(24);
        ChangeProfilePictureButton.setLayoutX(4); ChangeProfilePictureButton.setLayoutY(0);
        ChangeProfilePictureButton.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {if(customer.isLoggedIn==true) {changeUserImage();}}
            }
        );
        ChangeProfilePictureOption=new Pane(Pointer4, ChangeProfilePictureTitle, ChangeProfilePictureButton);
        ChangeProfilePictureOption.setPrefWidth(178); ChangeProfilePictureOption.setPrefHeight(24);
        
        Polygon Pointer5=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer5.setFill(Color1);
        Pointer5.setLayoutX(0); Pointer5.setLayoutY(10.5);
        ChangePasswordTitle=new FormattedText("Change your password", -1.0, 0, true);
        ChangePasswordTitle.setPrefWrapLength(132);
        ChangePasswordTitle.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 10));
        ChangePasswordTitle.setFill(Color1);
        ChangePasswordTitle.setLayoutX(7); ChangePasswordTitle.setLayoutY(7);
        ChangePasswordButton=new Button();
        ChangePasswordButton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent;");
        ChangePasswordButton.setPrefWidth(124); ChangePasswordButton.setPrefHeight(24);
        ChangePasswordButton.setLayoutX(4); ChangePasswordButton.setLayoutY(0);
        ChangePasswordButton.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e) {if(customer.isLoggedIn==true) {changePassword();}}
            }
        );
        ChangePasswordOption=new Pane(Pointer5, ChangePasswordTitle, ChangePasswordButton);
        ChangePasswordOption.setPrefWidth(178); ChangePasswordOption.setPrefHeight(24);

        InformationSettings=new VBox(FullNameOption, PhoneNumberOption, EmailOption, ChangeProfilePictureOption, ChangePasswordOption);
        InformationSettings.setPrefWidth(178); InformationSettings.setLayoutY(120);
        InformationSettings.setLayoutX(20); InformationSettings.setLayoutY(96);

        SignButtonHolder=new Rectangle(72, 24, Color1);
        SignButtonHolder.setArcWidth(24); SignButtonHolder.setArcHeight(24);
        SignButtonHolder.setLayoutX(0); SignButtonHolder.setLayoutY(0);
        SignButtonTitle=new FormattedText(customer.isLoggedIn?"Sign out":"Sign in", -1.0, 0, false);
        SignButtonTitle.setAlignment(Pos.CENTER);
        SignButtonTitle.setPrefWrapLength(56);
        SignButtonTitle.setPrefWidth(56); SignButtonTitle.setPrefHeight(24);
        SignButtonTitle.setFont(CustomFont.createFont("Raleway - Semibold", "ttf", 12));
        SignButtonTitle.setFill(Color2);
        SignButtonTitle.setLayoutX(8); SignButtonTitle.setLayoutY(0);
        SignButtonFrame=new Button();
        SignButtonFrame.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-background-radius: 20px;");
        SignButtonFrame.setPrefWidth(72); SignButtonFrame.setPrefHeight(24);
        SignButtonFrame.setLayoutX(0); SignButtonFrame.setLayoutY(0);
        SignButtonFrame.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if(customer.isLoggedIn==true) {signout();}
                    else {signin();}
                }
            }
        );
        SignButton=new Pane(SignButtonHolder, SignButtonTitle, SignButtonFrame);
        SignButton.setPrefWidth(72); SignButton.setPrefHeight(24);
        SignButton.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 4, 0, 0, 2));
        SignButton.setLayoutX(72); SignButton.setLayoutY(224);

        InformationPane=new Pane(InformationPaneHolder, UserAvatar, UserEditedName, UserLevelText, UserLevelProgressBar, InformationSettings, SignButton);
        InformationPane.setPrefWidth(216); InformationPane.setPrefHeight(264);
        InformationPane.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 10, 0, 0, 6));
        InformationPane.setLayoutX(24); InformationPane.setLayoutY(96);

        //SettingsPane:
        SettingsTitleText=new FormattedText("Settings", -1.0, 0, false);
        SettingsTitleText.setFont(CustomFont.createFont("Raleway - Bold", "ttf", 18));
        SettingsTitleText.setFill(Color1);
        SettingsTitleText.setLayoutX(12); SettingsTitleText.setLayoutY(1);
        Rectangle SettingsTitleLeftLine=new Rectangle(12, 1, Color1);
        SettingsTitleLeftLine.setLayoutX(0); SettingsTitleLeftLine.setLayoutY(12);
        Rectangle SettingsTitleRightLine=new Rectangle(147, 1, Color1);
        SettingsTitleRightLine.setLayoutX(85); SettingsTitleRightLine.setLayoutY(12);
        SettingsTitle=new Pane(SettingsTitleLeftLine, SettingsTitleText, SettingsTitleRightLine);
        SettingsTitle.setPrefWidth(264);
        SettingsTitle.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.15), 10, 0, 0, 4));
        SettingsTitle.setLayoutX(16); SettingsTitle.setLayoutY(382);

        SettingsPaneHolder=new Rectangle(216, 88, Color3);
        SettingsPaneHolder.setArcWidth(32); SettingsPaneHolder.setArcHeight(32);
        SettingsPaneHolder.setLayoutX(0); SettingsPaneHolder.setLayoutY(0);

        Polygon Pointer6=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer6.setFill(Color1);
        Pointer6.setLayoutX(0); Pointer6.setLayoutY(10.5);
        TurnNotificationsTitle=new FormattedText("Turn on/off notifications:", -1.0, 0, false);
        TurnNotificationsTitle.setPrefWrapLength(132);
        TurnNotificationsTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        TurnNotificationsTitle.setFill(Color1);
        TurnNotificationsTitle.setLayoutX(7); TurnNotificationsTitle.setLayoutY(7);
        TurnNotificationsButton=new BinarySettingsButton(customer.TurnNotifications, 1);
        TurnNotificationsButton.setLayoutX(152); TurnNotificationsButton.setLayoutY(4);
        TurnNotificationsOption=new Pane(Pointer6, TurnNotificationsTitle, TurnNotificationsButton);
        TurnNotificationsOption.setPrefWidth(180); TurnNotificationsOption.setPrefHeight(24);

        Polygon Pointer7=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer7.setFill(Color1);
        Pointer7.setLayoutX(0); Pointer7.setLayoutY(10.5);
        PreviewsTitle=new FormattedText("Previews:", -1.0, 0, false);
        PreviewsTitle.setPrefWrapLength(132);
        PreviewsTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        PreviewsTitle.setFill(Color1);
        PreviewsTitle.setLayoutX(7); PreviewsTitle.setLayoutY(7);
        PreviewsButton=new BinarySettingsButton(customer.Previews, 2);
        PreviewsButton.setLayoutX(152); PreviewsButton.setLayoutY(4);
        PreviewsOption=new Pane(Pointer7, PreviewsTitle, PreviewsButton);
        PreviewsOption.setPrefWidth(180); PreviewsOption.setPrefHeight(24);

        Polygon Pointer8=new Polygon(0.0, 0.0, 0.0, 6.0, 4.0, 3.0);
        Pointer8.setFill(Color1);
        Pointer8.setLayoutX(0); Pointer8.setLayoutY(10.5);
        VibrationsTitle=new FormattedText("Vibrations:", -1.0, 0, false);
        VibrationsTitle.setPrefWrapLength(132);
        VibrationsTitle.setFont(CustomFont.createFont("Raleway - SemiBold", "ttf", 10));
        VibrationsTitle.setFill(Color1);
        VibrationsTitle.setLayoutX(7); VibrationsTitle.setLayoutY(7);
        VibrationsButton=new BinarySettingsButton(customer.Vibrations, 3);
        VibrationsButton.setLayoutX(152); VibrationsButton.setLayoutY(4);
        VibrationsOption=new Pane(Pointer8, VibrationsTitle, VibrationsButton);
        VibrationsOption.setPrefWidth(180); VibrationsOption.setPrefHeight(24);

        SettingsList=new VBox(TurnNotificationsOption, PreviewsOption, VibrationsOption);
        SettingsList.setLayoutX(20); SettingsList.setLayoutY(8);

        SettingsPane=new Pane(SettingsPaneHolder, SettingsList);
        SettingsPane.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(0 ,0 , 0, 0.1), 10, 0, 0, 6));
        SettingsPane.setPrefWidth(216); SettingsPane.setPrefHeight(88);
        SettingsPane.setLayoutX(24); SettingsPane.setLayoutY(424);

        //BlankSpace:
        BlankSpace=new Pane();
        BlankSpace.setPrefWidth(264); BlankSpace.setPrefHeight(24);
        BlankSpace.setLayoutX(0); BlankSpace.setLayoutY(512);

        //MainPage:
        MainPage=new Pane(PageTitle, ReceiptButton, InformationPane, SettingsTitle, SettingsPane, BlankSpace);
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
    public ProfilePage(UserInformation customer, DrinkMap drink)
    {
        setup(customer, drink);
        build();
    }
}