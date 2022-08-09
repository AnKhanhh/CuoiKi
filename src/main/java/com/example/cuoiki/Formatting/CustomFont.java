package com.example.cuoiki.Formatting;

import javafx.scene.text.Font;

public class CustomFont
{
    public static Font createFont(String Style, String FileType, double Size)
    {
        Font font=new Font(Size);
        font=Font.loadFont("file:materials/font/" + Style + "."+FileType , Size);
        return font;
    }
}