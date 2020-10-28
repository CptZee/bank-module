package groupnine.bank.siyam;

import groupnine.bank.auth.authGUI;
import groupnine.bank.auth.ifAccIsLock;
import groupnine.bank.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import static groupnine.bank.Main.*;
import static groupnine.bank.auth.Credentials.credentials;
import static groupnine.bank.auth.Credentials.modifyCredentials;
import static groupnine.bank.auth.authGUI.securityRate;
import static groupnine.bank.auth.authPrompt.authPromptFrame;
import static groupnine.bank.util.util.*;
import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;

public class changePinType {
    public static JFrame changePinTypeFrame;
    public static JFrame changePin6Frame;
    public static JFrame changePin4Frame;
    public static JFrame confirmPasswordFrame;
    public static void changePinMenu(int width, int height, String title, BufferedImage MenuIcon){
        //Change Pin Type GUI
        changePinTypeFrame = new JFrame(title);
        changePinTypeFrame.setSize(new Dimension(width, height));
        changePinTypeFrame.setResizable(false);
        changePinTypeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePinTypeFrame.setIconImage(MenuIcon);
        changePinTypeFrame.setLocation(centerDim.width/2-changePinTypeFrame.getSize().width/2, centerDim.height/2-changePinTypeFrame.getSize().height/2);
        //Confirm Password GUI
        confirmPasswordFrame = new JFrame(title);
        confirmPasswordFrame.setSize(new Dimension(width, height));
        confirmPasswordFrame.setResizable(false);
        confirmPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmPasswordFrame.setIconImage(MenuIcon);
        confirmPasswordFrame.setLocation(centerDim.width/2-confirmPasswordFrame.getSize().width/2, centerDim.height/2-confirmPasswordFrame.getSize().height/2);
        //Change Pin 4 Digits GUI
        changePin4Frame = new JFrame(title);
        changePin4Frame.setSize(new Dimension(width, height));
        changePin4Frame.setResizable(false);
        changePin4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePin4Frame.setIconImage(MenuIcon);
        changePin4Frame.setLocation(centerDim.width/2-changePinTypeFrame.getSize().width/2, centerDim.height/2-changePinTypeFrame.getSize().height/2);
        //Change Pin 6 Digits GUI
        changePin6Frame = new JFrame(title);
        changePin6Frame.setSize(new Dimension(width, height));
        changePin6Frame.setResizable(false);
        changePin6Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePin6Frame.setIconImage(MenuIcon);
        changePin6Frame.setLocation(centerDim.width/2-changePin6Frame.getSize().width/2, centerDim.height/2-changePin6Frame.getSize().height/2);
    }
    public static JPanel changePinElem = new JPanel(null);
    public static JPanel changePin4Elem = new JPanel(null);
    public static JPanel changePin6Elem = new JPanel(null);
    public static JPanel confirmPasswordElem = new JPanel(null);

    public static void typeElements(){
        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);
        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);

        //Text
        JLabel elemTitle = new JLabel("<HTML><CENTER>What Type of Pin<BR> Do You Want to Use?</HTML>");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));

        elemTitle.setBounds(200, 180, 460, 200);

        //Buttons
        JButton fourButton = new JButton("4-Digits");
        JButton sixButton = new JButton("6-Digits");
        JButton returnButton = new JButton("Return");

        fourButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        sixButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        returnButton.setFont(new Font("ARIAL BLACK", BOLD, 25));

        fourButton.setBounds(115, 340, 200, 80);
        sixButton.setBounds(335, 340, 200, 80);
        returnButton.setBounds(215, 450, 200, 80);

        fourButton.addActionListener(new fourDigitButtonFunction());
        sixButton.addActionListener(new sixDigitButtonFunction());
        returnButton.addActionListener(new returnButtonFunction());

        changePinElem.add(fourButton);
        changePinElem.add(sixButton);
        changePinElem.add(returnButton);
        changePinElem.add(elemTitle);
        changePinElem.add(logo);
        changePinElem.add(background);
        changePinTypeFrame.add(changePinElem);
        confirmPassword();
        fourDigitButtonElements();
        sixDigitButtonElements();
    }

    public static JPasswordField passwordField = new JPasswordField(10);
    public static JButton onePasswordButton = new JButton("1");
    public static JButton twoPasswordButton = new JButton("2");
    public static JButton threePasswordButton = new JButton("3");
    public static JButton fourPasswordButton = new JButton("4");
    public static JButton fivePasswordButton = new JButton("5");
    public static JButton sixPasswordButton = new JButton("6");
    public static JButton sevenPasswordButton = new JButton("7");
    public static JButton eightPasswordButton = new JButton("8");
    public static JButton ninePasswordButton = new JButton("9");
    public static JButton zeroPasswordButton = new JButton("0");
    public static JButton deletePasswordButton = new JButton("Clear");
    public static JButton confirmPasswordButton = new JButton("Confirm");

    public static JTextField passwordFieldFour = new JTextField(10);
    public static JButton onePasswordButtonFour = new JButton("1");
    public static JButton twoPasswordButtonFour = new JButton("2");
    public static JButton threePasswordButtonFour = new JButton("3");
    public static JButton fourPasswordButtonFour = new JButton("4");
    public static JButton fivePasswordButtonFour = new JButton("5");
    public static JButton sixPasswordButtonFour = new JButton("6");
    public static JButton sevenPasswordButtonFour = new JButton("7");
    public static JButton eightPasswordButtonFour = new JButton("8");
    public static JButton ninePasswordButtonFour = new JButton("9");
    public static JButton zeroPasswordButtonFour = new JButton("0");
    public static JButton deletePasswordButtonFour = new JButton("Clear");
    public static JButton confirmPasswordButtonFour = new JButton("Confirm");

    public static JTextField passwordFieldSix = new JTextField(10);
    public static JButton onePasswordButtonSix = new JButton("1");
    public static JButton twoPasswordButtonSix = new JButton("2");
    public static JButton threePasswordButtonSix = new JButton("3");
    public static JButton fourPasswordButtonSix = new JButton("4");
    public static JButton fivePasswordButtonSix = new JButton("5");
    public static JButton sixPasswordButtonSix = new JButton("6");
    public static JButton sevenPasswordButtonSix = new JButton("7");
    public static JButton eightPasswordButtonSix = new JButton("8");
    public static JButton ninePasswordButtonSix = new JButton("9");
    public static JButton zeroPasswordButtonSix = new JButton("0");
    public static JButton deletePasswordButtonSix = new JButton("Clear");
    public static JButton confirmPasswordButtonSix = new JButton("Confirm");

    public static PlainDocument passCode = (PlainDocument) passwordField.getDocument();
    public static PlainDocument passCodeFour = (PlainDocument) passwordFieldFour.getDocument();
    public static PlainDocument passCodeSix = (PlainDocument) passwordFieldSix.getDocument();

    public static void confirmPassword(){
        //Buttons
        onePasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        twoPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        threePasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fourPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fivePasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sixPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sevenPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        eightPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        ninePasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        zeroPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        deletePasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        confirmPasswordButton.setFont(new Font("ARIAL BLACK", BOLD, 14));

        sevenPasswordButton.setBounds(160, 360, 100, 50);
        eightPasswordButton.setBounds(270, 360, 100, 50);
        ninePasswordButton.setBounds(380,360, 100, 50);
        fourPasswordButton.setBounds(160, 420, 100, 50);
        fivePasswordButton.setBounds(270, 420, 100, 50);
        sixPasswordButton.setBounds(380,420, 100, 50);
        onePasswordButton.setBounds(160, 480, 100, 50);
        twoPasswordButton.setBounds(270, 480, 100, 50);
        threePasswordButton.setBounds(380,480, 100, 50);
        deletePasswordButton.setBounds(160, 540, 100, 50);
        zeroPasswordButton.setBounds(270,540, 100, 50);
        confirmPasswordButton.setBounds(380,540, 100, 50);

        sevenPasswordButton.addActionListener(new confirmPassButtons());
        eightPasswordButton.addActionListener(new confirmPassButtons());
        ninePasswordButton.addActionListener(new confirmPassButtons());
        fourPasswordButton.addActionListener(new confirmPassButtons());
        fivePasswordButton.addActionListener(new confirmPassButtons());
        sixPasswordButton.addActionListener(new confirmPassButtons());
        onePasswordButton.addActionListener(new confirmPassButtons());
        twoPasswordButton.addActionListener(new confirmPassButtons());
        threePasswordButton.addActionListener(new confirmPassButtons());
        deletePasswordButton.addActionListener(new confirmPassButtons());
        zeroPasswordButton.addActionListener(new confirmPassButtons());
        confirmPasswordButton.addActionListener(new confirmPassButtons());

        //Screen
        passwordField.setBounds(135, 280, 370, 75);
        passwordField.setFont(new Font("ARIAL BLACK", BOLD, 50));
        passwordField.setEditable(false);
        passwordField.setBorder(new LineBorder(BLACK,1));

        //Texts
        JLabel elemTitle = new JLabel("Please Enter Your Current Passcode");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));

        elemTitle.setBounds(115, 150, 460, 200);

        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);
        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220,25, 200, 200);

        confirmPasswordElem.add(passwordField);
        confirmPasswordElem.add(elemTitle);
        confirmPasswordElem.add(onePasswordButton);
        confirmPasswordElem.add(twoPasswordButton);
        confirmPasswordElem.add(threePasswordButton);
        confirmPasswordElem.add(fourPasswordButton);
        confirmPasswordElem.add(fivePasswordButton);
        confirmPasswordElem.add(sixPasswordButton);
        confirmPasswordElem.add(sevenPasswordButton);
        confirmPasswordElem.add(eightPasswordButton);
        confirmPasswordElem.add(ninePasswordButton);
        confirmPasswordElem.add(zeroPasswordButton);
        confirmPasswordElem.add(deletePasswordButton);
        confirmPasswordElem.add(confirmPasswordButton);
        confirmPasswordElem.add(logo);
        confirmPasswordElem.add(background);
        confirmPasswordFrame.add(confirmPasswordElem);
    }

    public static void fourDigitButtonElements(){
        //Buttons
        onePasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        twoPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        threePasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fourPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fivePasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sixPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sevenPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        eightPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        ninePasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        zeroPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        deletePasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 18));
        confirmPasswordButtonFour.setFont(new Font("ARIAL BLACK", BOLD, 14));

        sevenPasswordButtonFour.setBounds(160, 360, 100, 50);
        eightPasswordButtonFour.setBounds(270, 360, 100, 50);
        ninePasswordButtonFour.setBounds(380,360, 100, 50);
        fourPasswordButtonFour.setBounds(160, 420, 100, 50);
        fivePasswordButtonFour.setBounds(270, 420, 100, 50);
        sixPasswordButtonFour.setBounds(380,420, 100, 50);
        onePasswordButtonFour.setBounds(160, 480, 100, 50);
        twoPasswordButtonFour.setBounds(270, 480, 100, 50);
        threePasswordButtonFour.setBounds(380,480, 100, 50);
        deletePasswordButtonFour.setBounds(160, 540, 100, 50);
        zeroPasswordButtonFour.setBounds(270,540, 100, 50);
        confirmPasswordButtonFour.setBounds(380,540, 100, 50);

        sevenPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        eightPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        ninePasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        fourPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        fivePasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        sixPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        onePasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        twoPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        threePasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        deletePasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        zeroPasswordButtonFour.addActionListener(new fourDigitCodeFunction());
        confirmPasswordButtonFour.addActionListener(new fourDigitCodeFunction());

        //Screen
        passwordFieldFour.setBounds(135, 280, 370, 75);
        passwordFieldFour.setFont(new Font("ARIAL BLACK", BOLD, 50));
        passwordFieldFour.setEditable(false);
        passwordFieldFour.setBorder(new LineBorder(BLACK,1));


        //Texts
        JLabel elemTitle = new JLabel("Please Enter Your New Passcode");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));

        elemTitle.setBounds(118, 150, 460, 200);
        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);
        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);


        changePin4Elem.add(passwordFieldFour);
        changePin4Elem.add(elemTitle);
        changePin4Elem.add(onePasswordButtonFour);
        changePin4Elem.add(twoPasswordButtonFour);
        changePin4Elem.add(threePasswordButtonFour);
        changePin4Elem.add(fourPasswordButtonFour);
        changePin4Elem.add(fivePasswordButtonFour);
        changePin4Elem.add(sixPasswordButtonFour);
        changePin4Elem.add(sevenPasswordButtonFour);
        changePin4Elem.add(eightPasswordButtonFour);
        changePin4Elem.add(ninePasswordButtonFour);
        changePin4Elem.add(zeroPasswordButtonFour);
        changePin4Elem.add(deletePasswordButtonFour);
        changePin4Elem.add(confirmPasswordButtonFour);
        changePin4Elem.add(logo);
        changePin4Elem.add(background);
        changePin4Frame.add(changePin4Elem);
    }
    public static void sixDigitButtonElements(){
        //Buttons
        onePasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        twoPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        threePasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fourPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fivePasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sixPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sevenPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        eightPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        ninePasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        zeroPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        deletePasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 18));
        confirmPasswordButtonSix.setFont(new Font("ARIAL BLACK", BOLD, 14));

        sevenPasswordButtonSix.setBounds(160, 360, 100, 50);
        eightPasswordButtonSix.setBounds(270, 360, 100, 50);
        ninePasswordButtonSix.setBounds(380,360, 100, 50);
        fourPasswordButtonSix.setBounds(160, 420, 100, 50);
        fivePasswordButtonSix.setBounds(270, 420, 100, 50);
        sixPasswordButtonSix.setBounds(380,420, 100, 50);
        onePasswordButtonSix.setBounds(160, 480, 100, 50);
        twoPasswordButtonSix.setBounds(270, 480, 100, 50);
        threePasswordButtonSix.setBounds(380,480, 100, 50);
        deletePasswordButtonSix.setBounds(160, 540, 100, 50);
        zeroPasswordButtonSix.setBounds(270,540, 100, 50);
        confirmPasswordButtonSix.setBounds(380,540, 100, 50);

        sevenPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        eightPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        ninePasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        fourPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        fivePasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        sixPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        onePasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        twoPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        threePasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        deletePasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        zeroPasswordButtonSix.addActionListener(new sixDigitCodeFunction());
        confirmPasswordButtonSix.addActionListener(new sixDigitCodeFunction());

        //Screen
        passwordFieldSix.setBounds(135, 280, 370, 75);
        passwordFieldSix.setFont(new Font("ARIAL BLACK", BOLD, 50));
        passwordFieldSix.setEditable(false);
        passwordFieldSix.setBorder(new LineBorder(BLACK,1));


        //Texts
        JLabel elemTitle = new JLabel("Please Enter Your New Passcode");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));

        elemTitle.setBounds(118, 150, 460, 200);

        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);
        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);

        changePin6Elem.add(passwordFieldSix);
        changePin6Elem.add(elemTitle);
        changePin6Elem.add(onePasswordButtonSix);
        changePin6Elem.add(twoPasswordButtonSix);
        changePin6Elem.add(threePasswordButtonSix);
        changePin6Elem.add(fourPasswordButtonSix);
        changePin6Elem.add(fivePasswordButtonSix);
        changePin6Elem.add(sixPasswordButtonSix);
        changePin6Elem.add(sevenPasswordButtonSix);
        changePin6Elem.add(eightPasswordButtonSix);
        changePin6Elem.add(ninePasswordButtonSix);
        changePin6Elem.add(zeroPasswordButtonSix);
        changePin6Elem.add(deletePasswordButtonSix);
        changePin6Elem.add(confirmPasswordButtonSix);
        changePin6Elem.add(logo);
        changePin6Elem.add(background);
        changePin6Frame.add(changePin6Elem);
    }
}
class fourDigitButtonFunction extends changePinType implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent withdrawButtonInBalanceClicked) {
        passCodeFour.setDocumentFilter(new passCode6FilterBig());
        authenticationIsSecured = false;
        util.stopAllAudio();
        pinNewSFX.start();
        changePinTypeFrame.dispose();
        changePin4Frame.setVisible(true);
    }
}

class sixDigitButtonFunction extends changePinType implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent depositButtonInBalanceClicked) {
        passCodeSix.setDocumentFilter(new passCode6FilterBig());
        authenticationIsSecured = true;
        util.stopAllAudio();
        pinNewSFX.start();
        changePinTypeFrame.dispose();
        changePin6Frame.setVisible(true);
    }
}
class returnButtonFunction extends changePinType implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent returnButtonInBalanceClicked) {
        util.stopAllAudio();
        changePinTypeFrame.dispose();
        menu.mainFrame.setVisible(true);
    }
}

class confirmPassButtons extends changePinType implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent buttonClicked) {
        util.stopAllAudio();
        if(onePasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "1");
        }else if(twoPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "2");
        }else if(threePasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "3");
        }else if(fourPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "4");
        }else if(fivePasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "5");
        }else if(sixPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "6");
        }else if(sevenPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "7");
        }else if(eightPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "8");
        }else if(ninePasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "9");
        }else if(zeroPasswordButton.getModel().isArmed()){
            passwordField.setText(passwordField.getText() + "0");
        }else if(deletePasswordButton.getModel().isArmed()){
            passwordField.setText("");
        }else{
            int enteredPasscode = 0;
            try {
                enteredPasscode = Integer.parseInt(passwordField.getText());
            }catch(NumberFormatException empty){
                enteredPasscode = 0; //Returns invalid passcode
            }finally {
                if (credentials.containsKey(authGUI.usernameField.getText()) && enteredPasscode == credentials.get(authGUI.usernameField.getText())) {
                    util.stopAllAudio();
                    pinTypeSFX.start();
                    changePinTypeFrame.setVisible(true);
                    confirmPasswordFrame.dispose();
                    authGUI.attempts = 4;
                }else{
                    authGUI.attempts = (byte) (authGUI.attempts - 1);
                    if (authGUI.attempts >= 1) {
                        authPromptFrame.setIconImage(errorIco);
                        authPromptFrame.setTitle("Incorrect Passcode!");
                        promptContentLabel.setText("<html><center>Your passcode incorrect!<br>Attempts left: " + (authGUI.attempts - 1) + "</center></html>");
                        confirmButton.setText("Retry");
                        authFailedElem.remove(alertLabel);
                        authFailedElem.add(errorLabel);

                        //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                        float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                        int contentYLocInt = (int) contentYLoc - 5;
                        promptContentLabel.setBounds(125, contentYLocInt, 320, 25);
                        confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                        authPromptFrame.add(authFailedElem);
                        if(authGUI.attempts == 1) {
                            confirmPasswordFrame.dispose();
                            authGUI.authMenu.setVisible(true);
                            isAccountLocked = true;
                            java.util.Timer acc = new Timer();
                            TimerTask check = new ifAccIsLock();
                            acc.schedule(check, 0, 5000000);

                        }
                        authPromptFrame.setVisible(true);
                    }
                }
                passwordField.setText("");
            }
        }
    }
}

class fourDigitCodeFunction extends changePinType implements  ActionListener{
    @Override
    public void actionPerformed(ActionEvent buttonClicked) {
        util.stopAllAudio();
        if(onePasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "1");
        }else if(twoPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "2");
        }else if(threePasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "3");
        }else if(fourPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "4");
        }else if(fivePasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "5");
        }else if(sixPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "6");
        }else if(sevenPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "7");
        }else if(eightPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "8");
        }else if(ninePasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "9");
        }else if(zeroPasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText(passwordFieldFour.getText() + "0");
        }else if(deletePasswordButtonFour.getModel().isArmed()){
            passwordFieldFour.setText("");
        }else{
            int enteredPasscode = 0;
            try {
                enteredPasscode = Integer.parseInt(passwordFieldFour.getText());
            }catch(NumberFormatException empty){
                enteredPasscode = 0; //Returns invalid passcode
            }finally {
                if(enteredPasscode >= 1000) {
                    securityRate();
                    modifyCredentials(authGUI.usernameField.getText(), enteredPasscode);
                    passwordFieldFour.setText("");
                    authPromptFrame.setIconImage(allIco);
                    authPromptFrame.setTitle("Pin Changed Successfully!");
                    promptContentLabel.setText("<html><center>Your new passcode is:<br> '" + enteredPasscode + "' </center></html>");
                    confirmButton.setText("Confirm");

                    alertLabel.setBounds(50, 20, alertIMG.getIconWidth(), alertIMG.getIconHeight());

                    authFailedElem.add(alertLabel);
                    authFailedElem.remove(errorLabel);

                    //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                    float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                    int contentYLocInt = (int) contentYLoc - 5;
                    promptContentLabel.setBounds(130, contentYLocInt, 320, 25);
                    confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                    authPromptFrame.add(authFailedElem);
                    changePin4Frame.dispose();
                    authGUI.authMenu.setVisible(true);

                }else{
                    authPromptFrame.setIconImage(errorIco);
                    authPromptFrame.setTitle("Invalid Passcode");
                    promptContentLabel.setText("<html><center>Please enter a 4-digits passcode!</center></html>");
                    confirmButton.setText("Retry");
                    authFailedElem.remove(alertLabel);
                    authFailedElem.add(errorLabel);

                    //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                    float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                    int contentYLocInt = (int) contentYLoc - 5;
                    promptContentLabel.setBounds(100, contentYLocInt, 320, 25);
                    confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                    authPromptFrame.add(authFailedElem);
                }
                authPromptFrame.setVisible(true);
            }
        }
    }
}
class sixDigitCodeFunction extends changePinType implements  ActionListener{
    @Override
    public void actionPerformed(ActionEvent buttonClicked) {
        util.stopAllAudio();
        if(onePasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "1");
        }else if(twoPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "2");
        }else if(threePasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "3");
        }else if(fourPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "4");
        }else if(fivePasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "5");
        }else if(sixPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "6");
        }else if(sevenPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "7");
        }else if(eightPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "8");
        }else if(ninePasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "9");
        }else if(zeroPasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText(passwordFieldSix.getText() + "0");
        }else if(deletePasswordButtonSix.getModel().isArmed()){
            passwordFieldSix.setText("");
        }else{
            int enteredPasscode = 0;
            try {
                enteredPasscode = Integer.parseInt(passwordFieldSix.getText());
            }catch(NumberFormatException empty){
                enteredPasscode = 0; //Returns invalid passcode
            }finally {
                if(enteredPasscode >= 100000) {
                    securityRate();
                    modifyCredentials(authGUI.usernameField.getText(), enteredPasscode);
                    passwordFieldFour.setText("");
                    authPromptFrame.setIconImage(allIco);
                    authPromptFrame.setTitle("Pin Changed Successfully!");
                    promptContentLabel.setText("<html><center>Your new passcode is:<br> '" + enteredPasscode + "' </center></html>");
                    confirmButton.setText("Confirm");

                    alertLabel.setBounds(50, 20, alertIMG.getIconWidth(), alertIMG.getIconHeight());

                    authFailedElem.add(alertLabel);
                    authFailedElem.remove(errorLabel);

                    //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                    float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                    int contentYLocInt = (int) contentYLoc - 5;
                    promptContentLabel.setBounds(130, contentYLocInt, 320, 25);
                    confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                    authPromptFrame.add(authFailedElem);
                    changePin6Frame.dispose();
                    authGUI.authMenu.setVisible(true);

                }else{
                    authPromptFrame.setIconImage(errorIco);
                    authPromptFrame.setTitle("Invalid Passcode");
                    promptContentLabel.setText("<html><center>Please enter a 6-digits passcode!</center></html>");
                    confirmButton.setText("Retry");
                    authFailedElem.remove(alertLabel);
                    authFailedElem.add(errorLabel);

                    //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                    float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                    int contentYLocInt = (int) contentYLoc - 5;
                    promptContentLabel.setBounds(100, contentYLocInt, 320, 25);
                    confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                    authPromptFrame.add(authFailedElem);
                }
                authPromptFrame.setVisible(true);
            }
        }
    }
}