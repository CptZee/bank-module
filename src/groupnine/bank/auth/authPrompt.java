package groupnine.bank.auth;

import groupnine.bank.util.confirmButtonFunction;

import javax.swing.*;
import java.awt.*;

import static groupnine.bank.Main.*;
import static groupnine.bank.util.util.*;

public class authPrompt{
    public static JFrame authPromptFrame = new JFrame();
    public static void gui(int width, int height){
        authPromptFrame.setSize(new Dimension(width, height));
        authPromptFrame.setResizable(false);
        authPromptFrame.setLocation(centerDim.width/2-authPromptFrame.getSize().width/2, centerDim.height/2-authPromptFrame.getSize().height/2);

    }

    public static void elements(){
        //Error Elements
        errorLabel.setBounds(10, 10, errorIMG.getIconWidth(), errorIMG.getIconHeight());


        confirmButton.addActionListener(new confirmButtonFunction());

        authFailedElem.add(confirmButton);
        authFailedElem.add(promptContentLabel);

    }
}
