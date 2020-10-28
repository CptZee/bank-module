package groupnine.bank.siyam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static groupnine.bank.Main.*;
import static groupnine.bank.util.util.centerDim;
import static groupnine.bank.util.util.confirmButton;

public class withdrawPrompt {
    public static JFrame withdrawFramePrompt = new JFrame();

    public static void gui(int width, int height){
        withdrawFramePrompt.setSize(new Dimension(width, height));
        withdrawFramePrompt.setResizable(true);
        withdrawFramePrompt.setLocation(centerDim.width/2-withdrawFramePrompt.getSize().width/2, centerDim.height/2-withdrawFramePrompt.getSize().height/2);

    }
    public static JPanel withdrawPromptElem = new JPanel(null);
    public static JLabel withdrawPromptContentLabel;
    public static JLabel moneyLabel = new JLabel(moneyIMG);

    public static void elements(){
        JButton confirmButtonPrmpt = new JButton("Confirm");

        confirmButtonPrmpt.addActionListener(new confirmButtonFunctionWth());

        confirmButtonPrmpt.setBounds(155, 45, 100, 30);

        withdrawPromptContentLabel = new JLabel();

        moneyLabel.setBounds(50, 10, 40, 40);


        withdrawPromptElem.add(confirmButtonPrmpt);
        withdrawPromptElem.add(moneyLabel);
        withdrawPromptElem.add(withdrawPromptContentLabel);
        withdrawFramePrompt.add(withdrawPromptElem);

    }
}
class confirmButtonFunctionWth implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent onClick) {
        withdrawPrompt.withdrawFramePrompt.dispose();
    }
}