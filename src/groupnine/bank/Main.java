package groupnine.bank;

import groupnine.bank.auth.*;
import groupnine.bank.siyam.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static groupnine.bank.auth.Credentials.injectCredentials;
import static groupnine.bank.auth.authGUI.usernameField;
import static groupnine.bank.siyam.balance.injectBalances;


public class Main {
    /*
    Conditions...
    Altered through out the program.
    This will allow us to break and initialize loops
     */

    public static boolean isAuthenticated = false;
    public static boolean authenticationIsSecured = false;
    public static boolean isAccountLocked = false;

    public static void main(String[] args){
        assets();
        injectCredentials();
        injectBalances();
        menu.mainMenu(666, 673, "Siyam Bank | Main Menu", allIco);
        menu.elements();
        withdrawPrompt.gui(380, 120);
        withdrawPrompt.elements();
        withdraw.withdrawMenu(666, 673, "Siyam Bank | Withdraw", allIco);
        withdraw.elements();
        deposit.depositMenu(666, 673, "Siyam Bank | Deposit", allIco);
        deposit.elements();
        changePinType.changePinMenu(666, 673, "Siyam Bank | Change Pin", allIco);
        changePinType.typeElements();
        authPrompt.gui(380, 120);
        authPrompt.elements();
        authGUI.gui(666, 873, "Siyam Bank | Login", allIco);
        authGUI.loadElements();
    }

    //Pre-load asset files.
    public static ImageIcon mainAuthBackGroundIMG;
    public static ImageIcon secondAuthBackGroundIMG;
    public static ImageIcon siyamLogo;
    public static ImageIcon errorIMG;
    public static ImageIcon backgroundIMG;
    public static ImageIcon alertIMG;
    public static ImageIcon moneyIMG;
    public static BufferedImage allIco = null;
    public static BufferedImage errorIco = null;
    public static BufferedImage alertIco = null;
    public static Clip morningSFX = null;
    public static Clip noonSFX = null;
    public static Clip afternoonSFX = null;
    public static Clip eveningSFX = null;
    public static Clip balanceSFX = null;
    public static Clip depositSFX = null;
    public static Clip pinNewSFX = null;
    public static Clip pinTypeSFX = null;
    public static Clip withdrawSFX = null;

    public static void assets(){
        try{
            //Audio
            AudioInputStream morningStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("morning.wav"));
            AudioInputStream noonStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("noon.wav"));
            AudioInputStream afternoonStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("afternoon.wav"));
            AudioInputStream eveningStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("evening.wav"));
            AudioInputStream balanceStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("balance.wav"));
            AudioInputStream depositStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("deposit.wav"));
            AudioInputStream pinNewStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("pinNew.wav"));
            AudioInputStream pintTypeStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("pinType.wav"));
            AudioInputStream withdrawStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("withdraw.wav"));

            morningSFX = AudioSystem.getClip();
            noonSFX = AudioSystem.getClip();
            afternoonSFX = AudioSystem.getClip();
            eveningSFX = AudioSystem.getClip();
            balanceSFX = AudioSystem.getClip();
            depositSFX = AudioSystem.getClip();
            pinNewSFX = AudioSystem.getClip();
            pinTypeSFX = AudioSystem.getClip();
            withdrawSFX = AudioSystem.getClip();

            morningSFX.open(morningStream);
            noonSFX.open(noonStream);
            afternoonSFX.open(afternoonStream);
            eveningSFX.open(eveningStream);
            balanceSFX.open(balanceStream);
            depositSFX.open(depositStream);
            pinNewSFX.open(pinNewStream);
            pinTypeSFX.open(pintTypeStream);
            withdrawSFX.open(withdrawStream);

            //Images
            allIco = ImageIO.read(ClassLoader.getSystemResource("logo-ico.png"));
            errorIco = ImageIO.read(ClassLoader.getSystemResource("error-ico.png"));
            alertIco = ImageIO.read(ClassLoader.getSystemResource("alert-ico.png"));
            siyamLogo = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
            mainAuthBackGroundIMG = new ImageIcon(ClassLoader.getSystemResource("authMainBg.png"));
            secondAuthBackGroundIMG = new ImageIcon(ClassLoader.getSystemResource("authSndBg.png"));
            errorIMG = new ImageIcon(ClassLoader.getSystemResource("error.png"));
            backgroundIMG = new ImageIcon(ClassLoader.getSystemResource("background.png"));
            alertIMG = new ImageIcon(ClassLoader.getSystemResource("alert.png"));
            moneyIMG = new ImageIcon(ClassLoader.getSystemResource("money.gif"));
        } catch (Exception fileNotFound) {
            System.out.println("Assets failed to load!");
        }
    }
}
