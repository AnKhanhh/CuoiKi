package com.example.cuoiki.Formatting;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TextFieldSkin;

public class PasswordMaskSkin extends TextFieldSkin
{
    private char MaskChar;

    public PasswordMaskSkin(TextField control, char MaskChar)
    {
        super(control);
        this.MaskChar=MaskChar;
    }

    @Override
    protected String maskText(String txt)
    {
        if(getSkinnable() instanceof PasswordField)
        {
            int n=txt.length();
            StringBuilder passwordBuilder=new StringBuilder(n);
            for(int i=0; i<n; i++) {passwordBuilder.append(MaskChar);}
            return passwordBuilder.toString();
        }
        else return txt;
    }
}
