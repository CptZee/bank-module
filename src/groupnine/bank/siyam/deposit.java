package groupnine.bank.siyam;

import groupnine.bank.util.doublesOnlyFilter;
import groupnine.bank.util.util;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;
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

public class deposit {
    public static JFrame depositFrame;

    public static void depositMenu(int width, int height, String title, BufferedImage MenuIcon){
        depositFrame = new JFrame(title);
        depositFrame.setSize(new Dimension(width, height));
        depositFrame.setResizable(false);
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositFrame.setIconImage(MenuIcon);
        depositFrame.setLocation(centerDim.width/2-depositFrame.getSize().width/2, centerDim.height/2-depositFrame.getSize().height/2);
    }

    public static JPanel depositElem = new JPanel(null);
    public static JTextField depositAmountField = new JTextField(10);
    public static JButton oneDepositButton = new JButton("1");
    public static JButton twoDepositButton = new JButton("2");
    public static JButton threeDepositButton = new JButton("3");
    public static JButton fourDepositButton = new JButton("4");
    public static JButton fiveDepositButton = new JButton("5");
    public static JButton sixDepositButton = new JButton("6");
    public static JButton sevenDepositButton = new JButton("7");
    public static JButton eightDepositButton = new JButton("8");
    public static JButton nineDepositButton = new JButton("9");
    public static JButton zeroDepositButton = new JButton("0");
    public static JButton deleteDepositButton = new JButton("Clear");
    public static JButton dotDepositButton = new JButton(".");
    public static JButton returnDepositButton = new JButton("Menu");
    public static JButton withdrawDepositButton = new JButton("Deposit");

    public static void elements(){
        //Buttons
        oneDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        twoDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        threeDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fourDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        fiveDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sixDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        sevenDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        eightDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        nineDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        zeroDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        deleteDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        dotDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 18));
        returnDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 14));
        withdrawDepositButton.setFont(new Font("ARIAL BLACK", BOLD, 14));

        sevenDepositButton.setBounds(170, 360, 100, 50);
        eightDepositButton.setBounds(280, 360, 100, 50);
        nineDepositButton.setBounds(390,360, 100, 50);
        fourDepositButton.setBounds(170, 420, 100, 50);
        fiveDepositButton.setBounds(280, 420, 100, 50);
        sixDepositButton.setBounds(390,420, 100, 50);
        oneDepositButton.setBounds(170, 480, 100, 50);
        twoDepositButton.setBounds(280, 480, 100, 50);
        threeDepositButton.setBounds(390,480, 100, 50);
        deleteDepositButton.setBounds(170, 540, 100, 50);
        zeroDepositButton.setBounds(280, 540, 100, 50);
        dotDepositButton.setBounds(390,540, 100, 50);
        returnDepositButton.setBounds(10, 575, 100, 50);
        withdrawDepositButton.setBounds(510, 575, 130, 50);

        sevenDepositButton.addActionListener(new depositButtons());
        eightDepositButton.addActionListener(new depositButtons());
        nineDepositButton.addActionListener(new depositButtons());
        fourDepositButton.addActionListener(new depositButtons());
        fiveDepositButton.addActionListener(new depositButtons());
        sixDepositButton.addActionListener(new depositButtons());
        oneDepositButton.addActionListener(new depositButtons());
        twoDepositButton.addActionListener(new depositButtons());
        threeDepositButton.addActionListener(new depositButtons());
        deleteDepositButton.addActionListener(new depositButtons());
        zeroDepositButton.addActionListener(new depositButtons());
        dotDepositButton.addActionListener(new depositButtons());
        returnDepositButton.addActionListener(new depositButtons());
        withdrawDepositButton.addActionListener(new depositButtons());

        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);

        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);

        //Text
        JLabel elemTitle = new JLabel("How Much Do You Wish To Deposit?");
        JLabel pesoSign = new JLabel("₱");

        elemTitle.setFont(new Font("Helvetica", BOLD, 25));
        pesoSign.setFont(new Font("Helvetica", BOLD, 25));

        pesoSign.setBounds(130, 280, 390, 75);
        elemTitle.setBounds(110, 160, 460, 200);

        //Screen
        depositAmountField.setBounds(150, 280, 370, 75);
        depositAmountField.setFont(new Font("ARIAL BLACK", BOLD, 50));
        depositAmountField.setEditable(false);
        depositAmountField.setBorder(new LineBorder(BLACK,1));

        PlainDocument numbersOnly = (PlainDocument) depositAmountField.getDocument();
        numbersOnly.setDocumentFilter(new doublesOnlyFilter());

        depositElem.add(elemTitle);
        depositElem.add(pesoSign);
        depositElem.add(returnDepositButton);
        depositElem.add(withdrawDepositButton);
        depositElem.add(depositAmountField);
        depositElem.add(oneDepositButton);
        depositElem.add(twoDepositButton);
        depositElem.add(threeDepositButton);
        depositElem.add(fourDepositButton);
        depositElem.add(fiveDepositButton);
        depositElem.add(sixDepositButton);
        depositElem.add(sevenDepositButton);
        depositElem.add(eightDepositButton);
        depositElem.add(nineDepositButton);
        depositElem.add(zeroDepositButton);
        depositElem.add(dotDepositButton);
        depositElem.add(deleteDepositButton);
        depositElem.add(logo);
        depositElem.add(background);
        depositFrame.add(depositElem);
    }
}
class depositButtons extends deposit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent withdrawButtonsClicked) {
        if(oneDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "1");
        }else if(twoDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "2");
        }else if(threeDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "3");
        }else if(fourDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "4");
        }else if(fiveDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "5");
        }else if(sixDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "6");
        }else if(sevenDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "7");
        }else if(eightDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "8");
        }else if(nineDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "9");
        }else if(deleteDepositButton.getModel().isArmed()){
            depositAmountField.setText("");
        }else if(zeroDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + "0");
        }else if(dotDepositButton.getModel().isArmed()){
            depositAmountField.setText(depositAmountField.getText() + ".");
        }else if(returnDepositButton.getModel().isArmed()){
            menu.mainFrame.setVisible(true);
            depositFrame.dispose();
            depositAmountField.setText("");
            util.stopAllAudio();
        }else{
            util.stopAllAudio();
            double depositAmount = 0;
            try {
                depositAmount = Double.parseDouble(depositAmountField.getText());
            } catch (NumberFormatException wrongNumber) {
                //Again... Empty :P
            }
            if(depositAmount >= 5000.00) {
                double newBalance = currentBalance + depositAmount;
                currentBalance = newBalance;
                balance.modifyBalance(usernameField.getText(), newBalance);
                elemTitle.setText("<HTML><center>Current " + usernameField.getText() + properNoun() + " <BR>Balance: ₱ " + util.getBalance() + "</center><HTML>"); //Update The Balance
                withdrawPromptContentLabel.setBounds(110, 10, 250, 30);
                withdrawPromptContentLabel.setText("<HTML><center> Transaction Success!<br>Successfully deposited ₱" + util.currencyFormat(depositAmount) + "!</center></HTML>");
                withdrawFramePrompt.setTitle("Transaction Success!");
                withdrawFramePrompt.setIconImage(allIco);
            }else{
                withdrawPromptContentLabel.setBounds(100, 10, 300, 30);
                withdrawPromptContentLabel.setText("<HTML><center> Transaction Failed!<br>Amount must be more than ₱ 4,999.00</center></HTML>");
                withdrawPromptElem.add(withdrawPromptContentLabel);
                withdrawFramePrompt.setTitle("Transaction Failed!");
                withdrawFramePrompt.setIconImage(errorIco);
            }
            withdrawFramePrompt.setVisible(true);
            depositAmountField.setText("");
        }
    }
}
