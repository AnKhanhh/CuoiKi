package com.example.cuoiki.Formatting;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FormattedText extends FlowPane
{
    public FormattedText(String InputText, double LetterSpacing, double LineSpacing, boolean isUnderline)
    {
        setText(InputText, isUnderline);
        setHgap(LetterSpacing);
        setVgap(LineSpacing);
    }

    public void setText(String InputText, boolean isUnderline)
    {
        getChildren().clear();
        if(isUnderline==false)
        {
            for(int count=0; count<InputText.length(); count++)
            {
                Text temp=new Text("" + InputText.charAt(count));
                this.getChildren().add(temp);
            }
        }
        else
        {
            for(int count=0; count<InputText.length(); count++)
            {
                Text temp=new Text("" + InputText.charAt(count));
                temp.setUnderline(true);
                this.getChildren().add(temp);
            }
        }
    }

    public void setFont(Font TextFont) {for(Node t:getChildren()) {((Text)t).setFont(TextFont);}}

    public void setFont(Font TextFont, int pos1, int pos2)
    {
        int count=1;
        for(Node t:getChildren())
        {
            if((count>=pos1)&&(count<=pos2)) {((Text)t).setFont(TextFont);}
            count+=1;
        }
    }

    public void setFill(Color TextColor) {for(Node t:getChildren()) {((Text)t).setFill(TextColor);}}
}