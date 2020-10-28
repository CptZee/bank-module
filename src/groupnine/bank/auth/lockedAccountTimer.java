package groupnine.bank.auth;

import groupnine.bank.Main;

import java.util.TimerTask;

import static groupnine.bank.auth.authPrompt.authPromptFrame;

public class lockedAccountTimer extends TimerTask {
    private static byte color = 0;
    public void run(){
        try {
            Thread.sleep(300000); //5 mins 300000
            Main.isAccountLocked = false;
            authPromptFrame.dispose();
        } catch (InterruptedException e) {
            System.out.println("Account Timer failed!");
        }
    }
}