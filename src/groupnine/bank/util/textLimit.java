package groupnine.bank.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class textLimit extends PlainDocument {
    private int max = 10;
    public textLimit(int max) {
        this.max = max;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // check string being inserted does not exceed max length
        if (getLength()+str.length()>max) {
            // If it does, then truncate it
            str = str.substring(0, max - getLength());
        }
        super.insertString(offs, str, a);
    }
}
