package groupnine.bank.auth;


import java.util.TimerTask;

public class lockedAccountTimeInMin extends TimerTask {
    private static byte color = 0;
    public void run(){
        try {
            int timeLeft = 6;
            do{
                Thread.sleep(60000); //1 mins 60000
                loginFunction.waitingTime = loginFunction.waitingTime - 1;
                --timeLeft;
            }while(timeLeft > 0);
        } catch (InterruptedException e) {
            System.out.println("Account Timer failed!");
        }
    }
}