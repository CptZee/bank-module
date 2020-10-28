package groupnine.bank.auth;

import java.util.TimerTask;

public class ifAccIsLock extends TimerTask {
    public void run(){
        TimerTask TimeLeft = new lockedAccountTimeInMin();
        TimerTask Unlock = new lockedAccountTimer();
        TimeLeft.run();
        Unlock.run();
    }
}