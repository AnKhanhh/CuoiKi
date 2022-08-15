package com.example.cuoiki.Formatting;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
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

    //Build:
    private void build()
    {   
        //Initializing :
        LeftHolder=new Rectangle();
        LeftHolderMask=new Rectangle();
        RightHolder=new Rectangle();
        RightHolderMask=new Rectangle();
        MidHolder=new Rectangle();
        MessageLineBox=new VBox(2.0);

        //SettingUp:
        ObservableList MessageLineList=MessageLineBox.getChildren();
        double Box_Width=0, Box_Height=16;
        final double Line_Height=16.7209375;
        int TextLength=InputText.length();
        int CharPointer=0;
        LinkedList<Text> CharQueue=new LinkedList<Text>();
        double CharQueue_Width=0;
        boolean isQueueMode=false;

        //Client:
        if(isClient==true)
        {
            //ProcessingText:
            while(true)
            {
                HBox Line=new HBox(-1.0);
                Line.setAlignment(Pos.BASELINE_LEFT);
                double Line_Width=1;
                ObservableList Line_CharList=Line.getChildren();

                while(CharPointer<TextLength)
                {
                    char PointedChar=InputText.charAt(CharPointer);
                    Text DisplayedChar=new Text(""+PointedChar);
                    DisplayedChar.setFont(TextFont);
                    DisplayedChar.setFill(Color2);
                    Bounds DisplayedChar_Bounds=DisplayedChar.getBoundsInLocal();

                    if(isQueueMode==false)
                    {
                        if(Line_Width+DisplayedChar_Bounds.getWidth()<=184)
                        {
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            Line_Width+=DisplayedChar_Bounds.getWidth()-0.65;
                        }
                        else {break;}
                    }
                    if(Box_Width<Line_Width) {Box_Width=Line_Width;}
                }

                if(Line_CharList.size()!=0)
                {
                    MessageLineList.add(Line);
                    Box_Height+=Line_Height;
                }

                if(CharPointer>=TextLength) {break;}
            }

            //PlacingHolder:
            MessageLineBox.setLayoutX(220-Box_Width); MessageLineBox.setLayoutY(9);

            LeftHolder.setFill(Color1);
            LeftHolder.setWidth(32); LeftHolder.setHeight(Box_Height);
            LeftHolder.setArcWidth(32); LeftHolder.setArcHeight(32);
            LeftHolder.setLayoutX(204-Box_Width); LeftHolder.setLayoutY(0);
            LeftHolderMask.setFill(Color2);
            LeftHolderMask.setWidth(16); LeftHolderMask.setHeight(Box_Height);
            LeftHolderMask.setLayoutX(0); LeftHolderMask.setLayoutY(0);
            LeftHolder.setClip(LeftHolderMask);

            RightHolder.setFill(Color1);
            RightHolder.setWidth(16); RightHolder.setHeight(Box_Height);
            RightHolder.setArcWidth(8); RightHolder.setArcHeight(8);
            RightHolder.setLayoutX(216); RightHolder.setLayoutY(0);
            RightHolderMask.setFill(Color2);
            RightHolderMask.setWidth(12); RightHolderMask.setHeight(Box_Height);
            RightHolderMask.setLayoutX(4); RightHolderMask.setLayoutY(0);
            RightHolder.setClip(RightHolderMask);

            MidHolder.setFill(Color1);
            MidHolder.setWidth(Box_Width); MidHolder.setHeight(Box_Height);
            MidHolder.setLayoutX(220-Box_Width); MidHolder.setLayoutY(0);

            this.setPrefWidth(232); this.setPrefHeight(Box_Height);
        }

        //Server:
        else
        {
            //ProcessingText:
            while(true)
            {
                HBox Line=new HBox(-1.0);
                Line.setAlignment(Pos.BASELINE_LEFT);
                double Line_Width=1;
                ObservableList Line_CharList=Line.getChildren();

                while(CharPointer<TextLength)
                {
                    char PointedChar=InputText.charAt(CharPointer);
                    Text DisplayedChar=new Text(""+PointedChar);
                    DisplayedChar.setFont(TextFont);
                    DisplayedChar.setFill(Color1);
                    Bounds DisplayedChar_Bounds=DisplayedChar.getBoundsInLocal();

                    if(isQueueMode==false)
                    {
                        if(Line_Width+DisplayedChar_Bounds.getWidth()<=192)
                        {
                            Line_CharList.add(DisplayedChar);
                            CharPointer+=1;
                            Line_Width+=DisplayedChar_Bounds.getWidth()-0.65;
                        }
                        else {break;}
                    }
                    if(Box_Width<Line_Width) {Box_Width=Line_Width;}
                }

                if(Line_CharList.size()!=0)
                {
                    MessageLineList.add(Line);
                    Box_Height+=Line_Height;
                }

                if(CharPointer>=TextLength) {break;}
            }

            //PlacingHolder:
            MessageLineBox.setLayoutX(12); MessageLineBox.setLayoutY(9);

            LeftHolder.setFill(Color2);
            LeftHolder.setWidth(16); LeftHolder.setHeight(Box_Height);
            LeftHolder.setArcWidth(8); LeftHolder.setArcHeight(8);
            LeftHolder.setLayoutX(0); LeftHolder.setLayoutY(0);
            LeftHolderMask.setFill(Color1);
            LeftHolderMask.setWidth(12); LeftHolderMask.setHeight(Box_Height);
            LeftHolderMask.setLayoutX(0); LeftHolderMask.setLayoutY(0);
            LeftHolder.setClip(LeftHolderMask);

            RightHolder.setFill(Color2);
            RightHolder.setWidth(32); RightHolder.setHeight(Box_Height);
            RightHolder.setArcWidth(32); RightHolder.setArcHeight(32);
            RightHolder.setLayoutX(Box_Width-4); RightHolder.setLayoutY(0);
            RightHolderMask.setFill(Color1);
            RightHolderMask.setWidth(16); RightHolderMask.setHeight(Box_Height);
            RightHolderMask.setLayoutX(16); RightHolderMask.setLayoutY(0);
            RightHolder.setClip(RightHolderMask);

            MidHolder.setFill(Color2);
            MidHolder.setWidth(Box_Width); MidHolder.setHeight(Box_Height);
            MidHolder.setLayoutX(12); MidHolder.setLayoutY(0);

            this.setPrefWidth(232); this.setPrefHeight(Box_Height);
        }

        //AddingToPane:
        this.getChildren().addAll(LeftHolder, MidHolder, RightHolder, MessageLineBox);
        System.out.println(InputText);
    }

    //Constructor:
    public MessageBox(String text, boolean is_client)
    {
        this.InputText=text;
        this.isClient=is_client;
        build();
    }
}