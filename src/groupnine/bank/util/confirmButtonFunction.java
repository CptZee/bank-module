package groupnine.bank.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static groupnine.bank.auth.authPrompt.authPromptFrame;

public class confirmButtonFunction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent onClick) {
        authPromptFrame.dispose();
    }
}
