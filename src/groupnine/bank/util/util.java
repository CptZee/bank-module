package groupnine.bank.util;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static groupnine.bank.Main.*;
import static groupnine.bank.auth.authGUI.usernameField;
import static groupnine.bank.siyam.balance.currentBalance;

public class util {
    //Cause we are Grammar Nazis
    public static String properNoun(){
        if(usernameField.getText().endsWith("s")){
            return "'";
        }else{
            return "'s";
        }
    }

    public static Dimension centerDim = Toolkit.getDefaultToolkit().getScreenSize();

    public static void stopAllAudio(){
        balanceSFX.stop();
        depositSFX.stop();
        pinNewSFX.stop();
        pinTypeSFX.stop();
        withdrawSFX.stop();
        morningSFX.stop();
        noonSFX.stop();
        afternoonSFX.stop();
        eveningSFX.stop();

        balanceSFX.flush();
        depositSFX.flush();
        pinNewSFX.flush();
        pinTypeSFX.flush();
        withdrawSFX.flush();
        morningSFX.flush();
        noonSFX.flush();
        afternoonSFX.flush();
        eveningSFX.flush();

        balanceSFX.setFramePosition(0);
        depositSFX.setFramePosition(0);
        pinNewSFX.setFramePosition(0);
        pinTypeSFX.setFramePosition(0);
        withdrawSFX.setFramePosition(0);
        morningSFX.setFramePosition(0);
        noonSFX.setFramePosition(0);
        afternoonSFX.setFramePosition(0);
        eveningSFX.setFramePosition(0);
    }

    public static String getBalance(){
        try {
            return util.currencyFormat(currentBalance);
        }catch (NullPointerException userNotFound){
            //The user is still not authenticated... that's why this error happens, so it should be fine to ignore it.
        }
        return util.currencyFormat(0.0);
    }
    /*
    Adds Ghost Texts to TextFields
    GhostText name = new GhostText(textField, "Please enter some text here...");
     */

    public static class GhostText implements FocusListener, DocumentListener, PropertyChangeListener {
        private final JTextField textfield;
        private boolean isEmpty;
        private Color ghostColor;
        private Color foregroundColor;
        private final String ghostText;
        public GhostText(final JTextField textfield, String ghostText) {
            super();
            this.textfield = textfield;
            this.ghostText = ghostText;
            this.ghostColor = Color.LIGHT_GRAY;
            textfield.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textfield.hasFocus()) {
                focusLost(null);
            }
        }
        public void delete() {
            unregisterListeners();
            textfield.removeFocusListener(this);
        }
        private void registerListeners() {
            textfield.getDocument().addDocumentListener(this);
            textfield.addPropertyChangeListener("foreground", this);
        }
        private void unregisterListeners() {
            textfield.getDocument().removeDocumentListener(this);
            textfield.removePropertyChangeListener("foreground", this);
        }
        public Color getGhostColor() {
            return ghostColor;
        }
        public void setGhostColor(Color ghostColor) {
            this.ghostColor = ghostColor;
        }
        private void updateState() {
            isEmpty = textfield.getText().length() == 0;
            foregroundColor = textfield.getForeground();
        }
        @Override
        public void focusGained(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText("");
                    textfield.setForeground(foregroundColor);
                } finally {
                    registerListeners();
                }
            }

        }
        @Override
        public void focusLost(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText(ghostText);
                    textfield.setForeground(ghostColor);
                } finally {
                    registerListeners();
                }
            }
        }
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            updateState();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            updateState();
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateState();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            updateState();
        }
    }
    /*
    Currency Formatter
     */
    public static String currencyFormat(double number){
        return String.format("%,.2f", number);
    }

    //Prompt Elements
    public static JLabel promptContentLabel = new JLabel();
    public static JLabel errorLabel = new JLabel(errorIMG);
    public static JLabel alertLabel = new JLabel(alertIMG);

    public static JPanel authFailedElem = new JPanel(null);
    public static JButton confirmButton = new JButton();
}