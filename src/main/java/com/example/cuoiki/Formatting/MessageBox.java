package com.example.cuoiki.Formatting;

import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.LinkedList;

public class MessageBox extends Pane
{
    //Declaration:
    private Rectangle LeftHolder;
    private Rectangle LeftHolderMask;
    private Rectangle RightHolder;
    private Rectangle RightHolderMask;
    private Rectangle MidHolder;
    private VBox MessageLineBox;

    private boolean isClient;
    private String InputText;
    private final Color Color1=Color.rgb(71, 43, 43);
    private final Color Color2=Color.rgb(252, 255, 249);
    private Font TextFont=CustomFont.createFont("Raleway - Medium", "ttf", 12);
    private final int MaxLineWidth=180;

    //Build:
    private void build()
    {
        //Initializing:
        LeftHolder=new Rectangle();
        LeftHolderMask=new Rectangle();
        RightHolder=new Rectangle();
        RightHolderMask=new Rectangle();
        MidHolder=new Rectangle();
        MessageLineBox=new VBox();

        //SettingUp:
        ObservableList MessageLineList=MessageLineBox.getChildren();

        /**
         * Chế độ không hàng đợi:
         *
         *  Nếu không là ' ':
         *  1. Thêm vào hàng.
         *  2. Nếu ký tự vượt ngưỡng hàng thì xóa khỏi hàng, đưa hàng vào cột, mở hàng mới. Ngược lại tăng biến đếm.
         *
         *  Nếu là ' ':
         *  1. Thêm vào hàng. Tăng biến đếm.
         *  2. Nếu ký tự vượt ngưỡng hàng thì xóa khỏi hàng. Đưa hàng vào cột, mở hàng mới.
         *  3. Kiểm tra nếu ký tự không ở cuối hàng, mở chế độ hàng đợi. Đặt biến đếm đầu hàng đợi.
         *
         *
         *
         *  Chế độ hàng đợi:
         *
         *   Nếu không là ' ':
         *   1. Thêm vào hàng, tăng biến đếm.
         *   2. Nếu ký tự vượt ngưỡng hàng thì xóa ngược hàng, trả lại hàng trước hàng đợi và thêm vào cột
         *      Mở hàng mới, thêm toàn bộ phần tử của hàng đợi vào hàng mới. Đóng chế độ hàng đợi.
         *      Ngược lại, thêm ký tự vào hàng đợi, tăng biến đếm.
         *
         *   Nếu là ' ':
         *   1. Thêm vào hàng. Xóa toàn bộ hàng đợi. Tăng biến đếm.
         *   2. Nếu ký tự vượt ngưỡng hàng thì xóa khỏi hàng. Đưa hàng vào cột, mở hàng mới.
         *   3. Kiểm tra nếu ký tự không ở cuối hàng, đặt biến đếm đầu hàng đợi. Ngược lại, đóng chế độ hàng đợi.
         */

        //Client:
        if(isClient==true)
        {
            //ProcessingText:
            int TextLength=InputText.length();
            int CharPointer=0;
            LinkedList<Text> CharQueue=new LinkedList<Text>();
            boolean isQueueMode=false;
            int List_StartingQueuePoint=0;

            while(true)
            {
                HBox Line=new HBox(-1.0);
                ObservableList Line_CharList=Line.getChildren();

                while(CharQueue.peekFirst()!=null) {Line_CharList.add(CharQueue.pollFirst());}
                while(CharPointer<TextLength)
                {
                    char PointedChar=InputText.charAt(CharPointer);

                    //NotQueueMode:
                    if(isQueueMode==false)
                    {
                        if(PointedChar!=' ')
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color2);
                            Line_CharList.add(DisplayedChar);
                            if(Line.getPrefWidth()<=180) {CharPointer+=1;}
                            else
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                        }
                        else
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color2);
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            if(Line.getPrefWidth()>180)
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                            Text DisplayedNextChar=new Text(""+InputText.charAt(CharPointer));
                            DisplayedNextChar.setFont(TextFont);
                            DisplayedNextChar.setFill(Color2);
                            Line_CharList.add(DisplayedNextChar);
                            if(Line.getPrefWidth()<=180)
                            {
                                Line_CharList.remove(DisplayedNextChar);
                                List_StartingQueuePoint=Line_CharList.size();
                                isQueueMode=true;
                            }
                            else
                            {
                                Line_CharList.remove(DisplayedNextChar);
                                break;
                            }
                        }
                    }

                    //QueueMode:
                    else
                    {
                        if(PointedChar!=' ')
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color2);
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            if(Line.getPrefWidth()<=180)
                            {
                                CharQueue.add(DisplayedChar);
                                CharPointer+=1;
                            }
                            else
                            {
                                Line_CharList.remove(DisplayedChar);
                                while(Line_CharList.get(List_StartingQueuePoint)!=null) {Line_CharList.remove(List_StartingQueuePoint);}
                                isQueueMode=false;
                                break;
                            }
                        }
                        else
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color2);
                            Line_CharList.add(DisplayedChar);
                            CharQueue.clear();
                            CharPointer+=1;
                            if(Line.getPrefWidth()>180)
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                            Text DisplayedNextChar=new Text(""+InputText.charAt(CharPointer));
                            DisplayedNextChar.setFont(TextFont);
                            DisplayedNextChar.setFill(Color2);
                            Line_CharList.add(DisplayedNextChar);
                            if(Line.getPrefWidth()<=180) {List_StartingQueuePoint=Line_CharList.size();}
                            else
                            {
                                isQueueMode=false;
                                break;
                            }
                        }
                    }
                }

                MessageLineList.add(Line);
                if(CharPointer>=TextLength) {break;}
            }
            MessageLineBox.setLayoutX(16); MessageLineBox.setLayoutY(12);

            //PlacingHolder:
            double TextWidth=MessageLineBox.getPrefWidth();
            double TextHeight=MessageLineBox.getPrefHeight()+28;

            LeftHolder.setFill(Color1);
            LeftHolder.setWidth(32); LeftHolder.setHeight(TextHeight);
            LeftHolder.setArcWidth(16); LeftHolder.setArcHeight(16);
            LeftHolder.setLayoutX(0); LeftHolder.setLayoutY(0);
            LeftHolderMask.setFill(Color2);
            LeftHolderMask.setWidth(16); LeftHolderMask.setHeight(TextHeight);
            LeftHolderMask.setLayoutX(0); LeftHolderMask.setLayoutY(0);
            LeftHolder.setClip(LeftHolderMask);

            RightHolder.setFill(Color1);
            RightHolder.setWidth(16); RightHolder.setHeight(TextHeight);
            RightHolder.setArcWidth(4); RightHolder.setArcHeight(4);
            RightHolder.setLayoutX(TextWidth+12); RightHolder.setLayoutY(0);
            RightHolderMask.setFill(Color2);
            RightHolderMask.setWidth(12); RightHolderMask.setHeight(TextHeight);
            RightHolderMask.setLayoutX(4); RightHolderMask.setLayoutY(0);
            RightHolder.setClip(RightHolderMask);

            MidHolder.setFill(Color1);
            MidHolder.setWidth(TextWidth); MidHolder.setHeight(TextHeight);
            MidHolder.setLayoutX(16); MidHolder.setLayoutY(0);

            this.setPrefWidth(TextWidth+28); this.setPrefHeight(TextHeight);
        }

        //Server:
        else
        {
            //ProcessingText:
            int TextLength=InputText.length();
            int CharPointer=0;
            LinkedList<Text> CharQueue=new LinkedList<Text>();
            boolean isQueueMode=false;
            int List_StartingQueuePoint=0;

            while(true)
            {
                HBox Line=new HBox(-1.0);
                ObservableList Line_CharList=Line.getChildren();

                while(CharQueue.peekFirst()!=null) {Line_CharList.add(CharQueue.pollFirst());}
                while(CharPointer<TextLength)
                {
                    char PointedChar=InputText.charAt(CharPointer);

                    //NotQueueMode:
                    if(isQueueMode==false)
                    {
                        if(PointedChar!=' ')
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color1);
                            Line_CharList.add(DisplayedChar);
                            if(Line.getPrefWidth()<=180) {CharPointer+=1;}
                            else
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                        }
                        else
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color1);
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            if(Line.getPrefWidth()>180)
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                            Text DisplayedNextChar=new Text(""+InputText.charAt(CharPointer));
                            DisplayedNextChar.setFont(TextFont);
                            DisplayedNextChar.setFill(Color1);
                            Line_CharList.add(DisplayedNextChar);
                            if(Line.getPrefWidth()<=180)
                            {
                                Line_CharList.remove(DisplayedNextChar);
                                List_StartingQueuePoint=Line_CharList.size();
                                isQueueMode=true;
                            }
                            else
                            {
                                Line_CharList.remove(DisplayedNextChar);
                                break;
                            }
                        }
                    }

                    //QueueMode:
                    else
                    {
                        if(PointedChar!=' ')
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color1);
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            if(Line.getPrefWidth()<=180)
                            {
                                CharQueue.add(DisplayedChar);
                                CharPointer+=1;
                            }
                            else
                            {
                                Line_CharList.remove(DisplayedChar);
                                while(Line_CharList.get(List_StartingQueuePoint)!=null) {Line_CharList.remove(List_StartingQueuePoint);}
                                isQueueMode=false;
                                break;
                            }
                        }
                        else
                        {
                            Text DisplayedChar=new Text(""+PointedChar);
                            DisplayedChar.setFont(TextFont);
                            DisplayedChar.setFill(Color1);
                            Line_CharList.add(DisplayedChar);
                            CharQueue.clear();
                            CharPointer+=1;
                            if(Line.getPrefWidth()>180)
                            {
                                Line_CharList.remove(DisplayedChar);
                                break;
                            }
                            Text DisplayedNextChar=new Text(""+InputText.charAt(CharPointer));
                            DisplayedNextChar.setFont(TextFont);
                            DisplayedNextChar.setFill(Color1);
                            Line_CharList.add(DisplayedNextChar);
                            if(Line.getPrefWidth()<=180) {List_StartingQueuePoint=Line_CharList.size();}
                            else
                            {
                                isQueueMode=false;
                                break;
                            }
                        }
                    }
                }

                MessageLineList.add(Line);
                if(CharPointer>=TextLength) {break;}
            }
            MessageLineBox.setLayoutX(12); MessageLineBox.setLayoutY(12);

            //PlacingHolder:
            double TextWidth=MessageLineBox.getPrefWidth();
            double TextHeight=MessageLineBox.getPrefHeight()+28;

            LeftHolder.setFill(Color2);
            LeftHolder.setWidth(16); LeftHolder.setHeight(TextHeight);
            LeftHolder.setArcWidth(4); LeftHolder.setArcHeight(4);
            LeftHolder.setLayoutX(0); LeftHolder.setLayoutY(0);
            LeftHolderMask.setFill(Color1);
            LeftHolderMask.setWidth(12); LeftHolderMask.setHeight(TextHeight);
            LeftHolderMask.setLayoutX(0); LeftHolderMask.setLayoutY(0);
            LeftHolder.setClip(LeftHolderMask);

            RightHolder.setFill(Color2);
            RightHolder.setWidth(32); RightHolder.setHeight(TextHeight);
            RightHolder.setArcWidth(16); RightHolder.setArcHeight(16);
            RightHolder.setLayoutX(TextWidth-4); RightHolder.setLayoutY(0);
            RightHolderMask.setFill(Color1);
            RightHolderMask.setWidth(16); RightHolderMask.setHeight(TextHeight);
            RightHolderMask.setLayoutX(16); RightHolderMask.setLayoutY(0);
            RightHolder.setClip(RightHolderMask);

            MidHolder.setFill(Color2);
            MidHolder.setWidth(TextWidth); MidHolder.setHeight(TextHeight);
            MidHolder.setLayoutX(12); MidHolder.setLayoutY(0);

            this.setPrefWidth(TextWidth+28); this.setPrefHeight(TextHeight);
        }
        //AddingToPane:
        this.getChildren().addAll(LeftHolder, MidHolder, RightHolder, MessageLineBox);
    }

    //Constructor:
    public MessageBox(String text, boolean is_client)
    {
        this.InputText=text;
        this.isClient=is_client;
        build();
    }
}