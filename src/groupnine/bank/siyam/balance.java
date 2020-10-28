package groupnine.bank.siyam;

import groupnine.bank.util.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import static groupnine.bank.Main.*;
import static groupnine.bank.auth.authGUI.usernameField;
import static groupnine.bank.siyam.deposit.depositFrame;
import static groupnine.bank.siyam.withdraw.withdrawFrame;
import static groupnine.bank.util.util.centerDim;
import static groupnine.bank.util.util.properNoun;
import static java.awt.Font.BOLD;

public class balance {
    public static JFrame balanceFrame;
    public static HashMap<String, Double> balances = new HashMap<String, Double>();
    public static Double currentBalance;

    public static void injectBalances(){
        balances.put("user", 50000.00);
        balances.put("Aaron James", 50000.00);
        balances.put("John Benigno", 50000.00);
        balances.put("Elizabeth", 50000.00);
        balances.put("John Empe", 50000.00);
        balances.put("Kurt Adrian", 50000.00);
        balances.put("Mhel Adrian", 50000.00);
    }

    public static void modifyBalance(String username, double amount){
        balances.replace(username, amount);
    }

    public static void balanceMenu(int width, int height, String title, BufferedImage MenuIcon){
        balanceFrame = new JFrame(title);
        balanceFrame.setSize(new Dimension(width, height));
        balanceFrame.setResizable(true);
        balanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        balanceFrame.setIconImage(MenuIcon);
        balanceFrame.setLocation(centerDim.width/2-balanceFrame.getSize().width/2, centerDim.height/2-balanceFrame.getSize().height/2);
    }
    public static JLabel elemTitle = new JLabel("");
    public static void elements(){
        JPanel balanceElem = new JPanel(null);
        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);

        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);
        //Text
        elemTitle.setText("<HTML><center>Current " + usernameField.getText() + properNoun() + " <BR>Balance: ₱ " + util.getBalance() + "</center><HTML>");
        elemTitle.setFont(new Font("Helvetica", BOLD, 25));

        elemTitle.setBounds(190, 180, 460, 200);

        //Buttons
        JButton withdrawButtonInBal = new JButton("Withdraw");
        JButton depositButtonInBal = new JButton("Deposit");
        JButton returnButtonInBal = new JButton("Return");

        withdrawButtonInBal.setFont(new Font("ARIAL BLACK", BOLD, 25));
        depositButtonInBal.setFont(new Font("ARIAL BLACK", BOLD, 25));
        returnButtonInBal.setFont(new Font("ARIAL BLACK", BOLD, 25));

        withdrawButtonInBal.setBounds(115, 340, 200, 80);
        depositButtonInBal.setBounds(335, 340, 200, 80);
        returnButtonInBal.setBounds(215, 430, 200, 80);

        withdrawButtonInBal.addActionListener(new withdrawInBalanceFunction());
        depositButtonInBal.addActionListener(new depositInBalanceFunction());
        returnButtonInBal.addActionListener(new returnInBalanceFunction());

        balanceElem.add(elemTitle);
        balanceElem.add(withdrawButtonInBal);
        balanceElem.add(depositButtonInBal);
        balanceElem.add(returnButtonInBal);
        balanceElem.add(logo);
        balanceElem.add(background);
        balanceFrame.add(balanceElem);
    }
}
class withdrawInBalanceFunction extends balance implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent withdrawButtonInBalanceClicked) {
        util.stopAllAudio();
        withdrawSFX.start();
        balanceFrame.dispose();
        withdrawFrame.setVisible(true);
    }
}

class depositInBalanceFunction extends balance implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent depositButtonInBalanceClicked) {
        util.stopAllAudio();
        depositSFX.start();
        balanceFrame.dispose();
        depositFrame.setVisible(true);
    }
}
class returnInBalanceFunction extends balance implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent returnButtonInBalanceClicked) {
        util.stopAllAudio();
        balance.balanceFrame.dispose();
        menu.mainFrame.setVisible(true);
    }
}