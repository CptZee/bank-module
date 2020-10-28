package groupnine.bank.auth;

import groupnine.bank.Main;
import groupnine.bank.siyam.balance;
import groupnine.bank.siyam.changePinType;
import groupnine.bank.util.*;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import static groupnine.bank.auth.Credentials.*;
import static groupnine.bank.auth.authPrompt.authPromptFrame;
import static groupnine.bank.siyam.menu.elemTitle;
import static groupnine.bank.siyam.menu.mainFrame;
import static groupnine.bank.util.util.*;
import static java.awt.Color.CYAN;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public class authGUI extends Main{
    public static byte attempts = 4;
    public static JFrame authMenu;

    public static void gui(int width, int height, String title, BufferedImage MenuIcon){
        authMenu = new JFrame(title);
        authMenu.setSize(new Dimension(width, height));
        authMenu.setResizable(false);
        authMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authMenu.setIconImage(MenuIcon);
        authMenu.setLocation(centerDim.width/2-authMenu.getSize().width/2, centerDim.height/2-authMenu.getSize().height/2);
    }

    /*
    User Inputs...
    Acts just like a scanner (Console Application)
     */
    public static JTextField usernameField = new JTextField();
    public static JPasswordField passwordField = new JPasswordField();
    private static final util.GhostText usernameFieldText = new util.GhostText(usernameField, "username");
    private static final util.GhostText passwordFieldText = new util.GhostText(passwordField, "pass");
    public static JButton loginButton = new JButton("Login");

    public static void loadElements() {
        JPanel authElem = new JPanel(null);
        authMenu.add(authElem);

        //Images
        JLabel mainBG = new JLabel(mainAuthBackGroundIMG);
        JLabel secondBG = new JLabel(secondAuthBackGroundIMG);
        JLabel logo = new JLabel(siyamLogo);

        mainBG.setBounds(0, 0, mainAuthBackGroundIMG.getIconWidth(), mainAuthBackGroundIMG.getIconHeight());
        secondBG.setBounds(35, 35, secondAuthBackGroundIMG.getIconWidth(), secondAuthBackGroundIMG.getIconHeight());
        logo.setBounds(220, 90, 200, 200);

        //Texts
        JLabel motoLabel = new JLabel("\"BANKING MADE EASY\"");
        JLabel title = new JLabel("Authenticate");
        JLabel usernameLabel = new JLabel("Username");
        JLabel pinLabel = new JLabel("Passcode");

        motoLabel.setFont(new Font("Open Sans", BOLD, 25));
        title.setFont(new Font("Helvetica", BOLD, 30));
        usernameLabel.setFont(new Font("Arial Black", PLAIN, 25));
        pinLabel.setFont(new Font("Arial Black" , PLAIN, 25));

        motoLabel.setForeground(CYAN);

        motoLabel.setBounds(170, 310, 500, 30);
        title.setBounds(230, 360, 225, 25);
        usernameLabel.setBounds(120, 420, 225, 25);
        pinLabel.setBounds(120, 480, 225, 25);

        //User Inputs
        usernameField.setBounds(270, 420, 225, 25);
        passwordField.setBounds(270, 480, 225, 25);
        loginButton.setBounds(270, 540, 225, 25);

        //Check if the authentication method is secured (6-digits) or not (4-digits)
        securityRate();

        loginButton.addActionListener(new loginFunction());

        //Add Texts
        authElem.add(title);
        authElem.add(usernameLabel);
        authElem.add(pinLabel);
        authElem.add(motoLabel);

        //Add User Inputs
        authElem.add(usernameField);
        authElem.add(passwordField);
        authElem.add(loginButton);

        //Add Images
        authElem.add(logo);
        authElem.add(secondBG);
        authElem.add(mainBG);

        authMenu.setVisible(true);
    }
    public static void securityRate(){
        PlainDocument passCode = (PlainDocument) passwordField.getDocument();
        if(authenticationIsSecured == true){
            passCode.setDocumentFilter(new passCode6Filter());
            changePinType.passCode.setDocumentFilter(new passCode6FilterBig());
        }else{
            passCode.setDocumentFilter(new passCode6Filter());
            changePinType.passCode.setDocumentFilter(new passCode6FilterBig());
        }
    }
}

class loginFunction extends authGUI implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent loginButtonClicked) {
        authPromptFrame.remove(authFailedElem);
        if(isAccountLocked == false) {
            if (credentials.containsKey(usernameField.getText()) && Integer.parseInt(passwordField.getText()) == credentials.get(usernameField.getText())) { //A very line since I don't since I don't feel like making it shorter LMAO
                //Authenticated Code
                balance.currentBalance = balance.balances.get(usernameField.getText());

                balance.balanceMenu(666, 673, "Siyam Bank | " + usernameField.getText() + "'s Balance", allIco);
                balance.elements();

                //A little code to check for the time
                LocalDateTime currentTime = LocalDateTime.now();
                int currentTimeConverted = currentTime.getHour();
                if(currentTimeConverted >= 5){
                    if(currentTimeConverted >= 12){
                        if(currentTimeConverted >= 13){
                            if(currentTimeConverted >= 17){
                                elemTitle.setText("<HTML><center>Good Evening! " + usernameField.getText() + " <br>What do you want to do tonight?</center></HTML>");
                                stopAllAudio();
                                eveningSFX.start();
                            }else{
                                elemTitle.setText("<HTML><center>Good Afternoon! " + usernameField.getText() + " <br>What do you want to do today?</center></HTML>");
                                stopAllAudio();
                                afternoonSFX.start();
                            }
                        }else{
                            elemTitle.setText("<HTML><center>Good Noon! " + usernameField.getText() + " <br>What do you want to do today?</center></HTML>");
                            stopAllAudio();
                            noonSFX.start();
                        }
                    }else{
                        elemTitle.setText("<HTML><center>Good Morning! " + usernameField.getText() + " <br>What do you want to do today?</center></HTML>");
                        stopAllAudio();
                        morningSFX.start();
                    }
                }else{
                    elemTitle.setText("<HTML><center>Good Evening! " + usernameField.getText()+ " <br>What do you want to do tonight?</center></HTML>");
                    stopAllAudio();
                    eveningSFX.start();
                }
                isAuthenticated = true;
                mainFrame.setVisible(true);
                authMenu.setVisible(false);
                attempts = 4;
            } else {
                attempts = (byte) (attempts - 1);
                if (attempts >= 1) {
                    authPromptFrame.setIconImage(errorIco);
                    authPromptFrame.setTitle("Login Failed!");
                    promptContentLabel.setText("<html><center>Either your username or passcode is not correct!<br>Attempts left: " + (attempts - 1) + "</center></html>");
                    confirmButton.setText("Retry");
                    authFailedElem.remove(alertLabel);
                    authFailedElem.add(errorLabel);

                    //A neat code to aligned the text to the image (I got tired computing HAHAHA)
                    float contentYLoc = errorIMG.getIconHeight() * 0.5f;
                    int contentYLocInt = (int) contentYLoc - 5;
                    float contentXloc = errorIMG.getIconWidth() * 0.5f;
                    int contentXlocInt = errorIMG.getIconWidth() + (int) contentXloc;
                    promptContentLabel.setBounds(contentXlocInt, contentYLocInt, 320, 25);
                    confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
                    authPromptFrame.add(authFailedElem);
                    authPromptFrame.setVisible(true);

                    if(attempts == 1) {
                        isAccountLocked = true;
                        Timer acc = new Timer();
                        TimerTask check = new ifAccIsLock();
                        acc.schedule(check, 0, 5000000);
                    }

                }
            }
        }else{
            authPromptFrame.setIconImage(errorIco);
            authPromptFrame.setTitle("Login Locked!");
            promptContentLabel.setText("<html><center>You have been locked off the account!<br>Minutes left: " + (waitingTime - 1) + " " + minutesPlural() + "</center></html>");
            confirmButton.setText("Confirm");
            //A neat code to aligned the text to the image (I got tired computing HAHAHA)
            float contentYLoc = errorIMG.getIconHeight() * 0.5f;
            int contentYLocInt = (int) contentYLoc - 5;
            float contentXloc = errorIMG.getIconWidth() * 0.5f;
            int contentXlocInt = errorIMG.getIconWidth() + (int) contentXloc + 30;
            promptContentLabel.setBounds(contentXlocInt, contentYLocInt, 320, 25);
            confirmButton.setBounds(150, promptContentLabel.getHeight() + 20, 100, 25);
            authPromptFrame.add(authFailedElem);
            authPromptFrame.setVisible(true);
        }
    }

    public static int waitingTime = 6;
    //A little code that I improvised to properly address time.
    public static String minutesPlural(){
        if(waitingTime > 1){
            return "minutes";
        }else{
            return "minute";
        }
    }
}

