package groupnine.bank.siyam;

import groupnine.bank.util.doublesOnlyFilter;
import groupnine.bank.util.util;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static groupnine.bank.Main.*;
import static groupnine.bank.auth.authGUI.usernameField;
import static groupnine.bank.siyam.balance.*;
import static groupnine.bank.siyam.withdrawPrompt.*;
import static groupnine.bank.util.util.centerDim;
import static groupnine.bank.util.util.properNoun;
import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;

public class withdraw {
    public static JFrame withdrawFrame;

    public static void withdrawMenu(int width, int height, String title, BufferedImage MenuIcon){
        withdrawFrame = new JFrame(title);
        withdrawFrame.setSize(new Dimension(width, height));
        withdrawFrame.setResizable(false);
        withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        withdrawFrame.setIconImage(MenuIcon);
        withdrawFrame.setLocation(centerDim.width/2-withdrawFrame.getSize().width/2, centerDim.height/2-withdrawFrame.getSize().height/2);
    }
    public static JPanel withdrawElem = new JPanel(null);
    public static JTextField withdrawAmountField = new JTextField(10);
    public static JButton oneButton = new JButton("1");
    public static JButton twoButton = new JButton("2");
    public static JButton threeButton = new JButton("3");
    public static JButton fourButton = new JButton("4");
    public static JButton fiveButton = new JButton("5");
    public static JButton sixButton = new JButton("6");
    public static JButton sevenButton = new JButton("7");
    public static JButton eightButton = new JButton("8");
    public static JButton nineButton = new JButton("9");
    public static JButton zeroButton = new JButton("0");
    public static JButton deleteButton = new JButton("Clear");
    public static JButton dotButton = new JButton(".");
    public static JButton returnButton = new JButton("Menu");
    public static JButton withdrawButton = new JButton("Withdraw");

    public static void elements(){
        //Buttons
        oneButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        twoButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        threeButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fourButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fiveButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sixButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sevenButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        eightButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        nineButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        zeroButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        deleteButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        dotButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        returnButton.setFont(new Font("ARIAL BLACK", BOLD, 14));
        withdrawButton.setFont(new Font("ARIAL BLACK", BOLD, 14));

        sevenButton.setBounds(170, 360, 100, 50);
        eightButton.setBounds(280, 360, 100, 50);
        nineButton.setBounds(390,360, 100, 50);
        fourButton.setBounds(170, 420, 100, 50);
        fiveButton.setBounds(280, 420, 100, 50);
        sixButton.setBounds(390,420, 100, 50);
        oneButton.setBounds(170, 480, 100, 50);
        twoButton.setBounds(280, 480, 100, 50);
        threeButton.setBounds(390,480, 100, 50);
        deleteButton.setBounds(170, 540, 100, 50);
        zeroButton.setBounds(280, 540, 100, 50);
        dotButton.setBounds(390,540, 100, 50);
        returnButton.setBounds(10, 575, 100, 50);
        withdrawButton.setBounds(510, 575, 130, 50);

        sevenButton.addActionListener(new withdrawButtons());
        eightButton.addActionListener(new withdrawButtons());
        nineButton.addActionListener(new withdrawButtons());
        fourButton.addActionListener(new withdrawButtons());
        fiveButton.addActionListener(new withdrawButtons());
        sixButton.addActionListener(new withdrawButtons());
        oneButton.addActionListener(new withdrawButtons());
        twoButton.addActionListener(new withdrawButtons());
        threeButton.addActionListener(new withdrawButtons());
        deleteButton.addActionListener(new withdrawButtons());
        zeroButton.addActionListener(new withdrawButtons());
        dotButton.addActionListener(new withdrawButtons());
        returnButton.addActionListener(new withdrawButtons());
        withdrawButton.addActionListener(new withdrawButtons());

        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);

        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);

        //Text
        JLabel elemTitle = new JLabel("How Much Do You Wish To Withdraw?");
        JLabel pesoSign = new JLabel("₱");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));
        pesoSign.setFont(new Font("Helvetica", BOLD, 25));

        pesoSign.setBounds(130, 280, 390, 75);
        elemTitle.setBounds(100, 160, 460, 200);

        //Screen
        withdrawAmountField.setBounds(150, 280, 370, 75);
        withdrawAmountField.setFont(new Font("ARIAL BLACK", BOLD, 50));
        withdrawAmountField.setEditable(false);
        withdrawAmountField.setBorder(new LineBorder(BLACK,1));


        PlainDocument numbersOnly = (PlainDocument) withdrawAmountField.getDocument();
        numbersOnly.setDocumentFilter(new doublesOnlyFilter());

        withdrawElem.add(elemTitle);
        withdrawElem.add(pesoSign);
        withdrawElem.add(returnButton);
        withdrawElem.add(withdrawButton);
        withdrawElem.add(withdrawAmountField);
        withdrawElem.add(oneButton);
        withdrawElem.add(twoButton);
        withdrawElem.add(threeButton);
        withdrawElem.add(fourButton);
        withdrawElem.add(fiveButton);
        withdrawElem.add(sixButton);
        withdrawElem.add(sevenButton);
        withdrawElem.add(eightButton);
        withdrawElem.add(nineButton);
        withdrawElem.add(zeroButton);
        withdrawElem.add(dotButton);
        withdrawElem.add(deleteButton);
        withdrawElem.add(logo);
        withdrawElem.add(background);
        withdrawFrame.add(withdrawElem);
    }
}
class withdrawButtons extends withdraw implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent withdrawButtonsClicked) {
        if(oneButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "1");
        }else if(twoButton.getModel().isArmed()){
           withdrawAmountField.setText(withdrawAmountField.getText() + "2");
        }else if(threeButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "3");
        }else if(fourButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "4");
        }else if(fiveButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "5");
        }else if(sixButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "6");
        }else if(sevenButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "7");
        }else if(eightButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "8");
        }else if(nineButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "9");
        }else if(deleteButton.getModel().isArmed()){
            withdrawAmountField.setText("");
        }else if(zeroButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + "0");
        }else if(dotButton.getModel().isArmed()){
            withdrawAmountField.setText(withdrawAmountField.getText() + ".");
        }else if(returnButton.getModel().isArmed()){
            withdrawAmountField.setText("");
            menu.mainFrame.setVisible(true);
            withdraw.withdrawFrame.dispose();
        }else{
            util.stopAllAudio();
            double withdrawAmount = 0;
                try {
                    withdrawAmount = Double.parseDouble(withdrawAmountField.getText());
                } catch (NumberFormatException wrongNumber) {
                    //Failed - No Code since we have a solution for this later on.
                }
                if (withdrawAmount <= currentBalance && withdrawAmount >= 5000.00) {
                    //Success
                    double newBalance = currentBalance - withdrawAmount;
                    currentBalance = newBalance;
                    balance.modifyBalance(usernameField.getText(), newBalance);
                    elemTitle.setText("<HTML><center>Current " + usernameField.getText() + properNoun() + " <BR>Balance: ₱ " + util.getBalance() + "</center><HTML>"); //Update The Balance
                    withdrawPromptContentLabel.setBounds(110, 10, 250, 30);
                    withdrawPromptContentLabel.setText("<HTML><center> Transaction Success!<br>Successfully withdrawn ₱" + util.currencyFormat(withdrawAmount) + "!</center></HTML>");
                    withdrawFramePrompt.add(withdrawPromptElem);
                    withdrawFramePrompt.setTitle("Transaction Success!");
                    withdrawFramePrompt.setIconImage(allIco);
                } else if(withdrawAmount < 5000.00){
                    withdrawPromptContentLabel.setBounds(100, 10, 300, 30);
                    withdrawPromptContentLabel.setText("<HTML><center> Transaction Failed!<br>Amount must be more than ₱ 4,999.00</center></HTML>");
                    withdrawPromptElem.add(withdrawPromptContentLabel);
                    withdrawFramePrompt.setTitle("Transaction Failed!");
                    withdrawFramePrompt.setIconImage(errorIco);
                }else {
                    withdrawPromptContentLabel.setText("<HTML><center> Transaction Failed!<br>Not enough balance! </center></HTML>");
                    withdrawPromptContentLabel.setBounds(150, 10, 150, 30);
                    withdrawPromptElem.add(withdrawPromptContentLabel);
                    withdrawFramePrompt.setTitle("Transaction Failed!");
                    withdrawFramePrompt.setIconImage(errorIco);
                }
            withdrawFramePrompt.setVisible(true);
            withdrawAmountField.setText("");
        }

    }
}