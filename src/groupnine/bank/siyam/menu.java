package groupnine.bank.siyam;

import groupnine.bank.Main;
import groupnine.bank.util.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import static groupnine.bank.Main.*;
import static groupnine.bank.auth.authGUI.authMenu;
import static groupnine.bank.siyam.balance.balanceFrame;
import static groupnine.bank.siyam.balance.currentBalance;
import static groupnine.bank.siyam.changePinType.changePinTypeFrame;
import static groupnine.bank.siyam.changePinType.confirmPasswordFrame;
import static groupnine.bank.siyam.deposit.depositFrame;
import static groupnine.bank.siyam.withdraw.withdrawFrame;
import static groupnine.bank.util.util.centerDim;
import static groupnine.bank.util.util.getBalance;
import static java.awt.Font.BOLD;

public class menu {
    public static JFrame mainFrame;

    public static void mainMenu(int width, int height, String title, BufferedImage MenuIcon){
        mainFrame = new JFrame(title);
        mainFrame.setSize(new Dimension(width, height));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(MenuIcon);
        mainFrame.setLocation(centerDim.width/2-mainFrame.getSize().width/2, centerDim.height/2-mainFrame.getSize().height/2);
    }

    public static JPanel mainElem = new JPanel(null);
    public static JLabel elemTitle = new JLabel();

    public static void elements(){
        //Images
        JLabel background = new JLabel(backgroundIMG);
        JLabel logo = new JLabel(siyamLogo);

        background.setBounds(0, 0, backgroundIMG.getIconWidth(), backgroundIMG.getIconHeight());
        logo.setBounds(220, 25, 200, 200);

        Timer coloredTitle = new Timer();
        TimerTask delay = new delayedTitle();

        coloredTitle.schedule(delay, 2000, 5000);
        elemTitle.setFont(new Font("Helvetica", BOLD, 25));
        elemTitle.setBounds(140, 160, 390, 200);

        //Buttons
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton balanceButton = new JButton("Balance");
        JButton changePinButton = new JButton("Change Pin");
        JButton logoutButton = new JButton("Logout");


        withdrawButton.setBounds(115, 320, 200, 80);
        depositButton.setBounds(335, 320, 200, 80);
        balanceButton.setBounds(115, 420, 200, 80);
        changePinButton.setBounds(335, 420, 200, 80);
        logoutButton.setBounds(215, 520, 200, 80);

        withdrawButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        depositButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        balanceButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        changePinButton.setFont(new Font("ARIAL BLACK", BOLD, 25));
        logoutButton.setFont(new Font("ARIAL BLACK", BOLD, 25));

        withdrawButton.addActionListener(new withdrawFunction());
        depositButton.addActionListener(new depositFunction());
        balanceButton.addActionListener(new balanceFunction());
        changePinButton.addActionListener(new changePinFunction());
        logoutButton.addActionListener(new logoutFunction());

        mainElem.add(withdrawButton);
        mainElem.add(depositButton);
        mainElem.add(balanceButton);
        mainElem.add(changePinButton);
        mainElem.add(logoutButton);
        mainElem.add(elemTitle);
        mainElem.add(logo);
        mainElem.add(background);
        mainFrame.add(mainElem);
    }
}

class delayedTitle extends TimerTask {
    private static byte color = 0;
    public void run(){
        do {
            ++color;
            if (color > 6) {
                color = 0;
            } else {
                switch (color) {
                    case 0:
                        menu.elemTitle.setForeground(Color.BLACK);
                        break;
                    case 1:
                        menu.elemTitle.setForeground(Color.RED);
                        break;
                    case 2:
                        menu.elemTitle.setForeground(Color.ORANGE);
                        break;
                    case 3:
                        menu.elemTitle.setForeground(Color.YELLOW);
                        break;
                    case 4:
                        menu.elemTitle.setForeground(Color.GREEN);
                        break;
                    case 5:
                        menu.elemTitle.setForeground(Color.BLUE);
                        break;
                    case 6:
                        menu.elemTitle.setForeground(Color.MAGENTA);
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Rainbow Title Failed to load!");
                }
            }
        }while(color <= 6);
    }
}

class withdrawFunction extends menu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent withdrawButtonClicked) {
        util.stopAllAudio();
        withdrawSFX.start();
        mainFrame.dispose();
        withdrawFrame.setVisible(true);
    }
}

class depositFunction extends menu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent depositButtonClicked) {
        util.stopAllAudio();
        depositSFX.start();
        mainFrame.dispose();
        depositFrame.setVisible(true);
    }
}

class balanceFunction extends menu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent balanceButtonClicked) {
        util.stopAllAudio();
        balanceSFX.start();
        mainFrame.dispose();
        balanceFrame.setVisible(true);
    }
}

class changePinFunction extends menu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent changePinButtonClicked) {
        util.stopAllAudio();
        mainFrame.dispose();
        confirmPasswordFrame.setVisible(true);
    }
}

class logoutFunction extends menu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent logoutButtonClicked) {
        util.stopAllAudio();
        isAuthenticated = false;
        mainFrame.dispose();
        authMenu.setVisible(true);
    }
}

