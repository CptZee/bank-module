package groupnine.bank.util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class passCode6Filter extends DocumentFilter {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
                             AttributeSet attr) throws BadLocationException {

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.insert(offset, string);

        if (test(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
            // warn the user and don't allow the insert
        }
    }

    private boolean test(String text) {
        if(text.trim().isEmpty()){
            return true;
        }else {
            try {
                Double.parseDouble(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);

        String string =fb.getDocument().getText(0, fb.getDocument().getLength())+text;

        if (test(sb.toString()) && string.length() <= 6) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            try {
                Clip ding = null;
                AudioInputStream sadStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("ding.wav"));
                ding = AudioSystem.getClip();
                ding.open(sadStream);
                ding.start();
            } catch(Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
            throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.delete(offset, offset + length);

        if (test(sb.toString())) {
            super.remove(fb, offset, length);
        } else {
            // warn the user and don't allow the insert
        }

    }
}
