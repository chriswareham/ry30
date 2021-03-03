package net.chriswareham.gui;

import java.awt.Toolkit;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * This class provides a text field that only allows valid identifiers to be
 * entered.
 */
public class IdentifierTextField extends DefaultTextField {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default identifier pattern.
     */
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("\\w+");

    /**
     * Construct a new instance of the identifier field.
     */
    public IdentifierTextField() {
        this(DEFAULT_PATTERN, null, 0, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param width preferred width of the field in characters
     */
    public IdentifierTextField(final int width) {
        this(DEFAULT_PATTERN, null, width, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param width preferred width of the field in characters
     * @param maxLength maximum character length that can be entered
     */
    public IdentifierTextField(final int width, final int maxLength) {
        this(DEFAULT_PATTERN, null, width, maxLength);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param value initial value
     */
    public IdentifierTextField(final String value) {
        this(DEFAULT_PATTERN, value, 0, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param value initial value
     * @param width preferred width of the field in characters
     */
    public IdentifierTextField(final String value, final int width) {
        this(DEFAULT_PATTERN, value, width, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param value initial value
     * @param width preferred width of the field in characters
     * @param maxLength maximum character length that can be entered
     */
    public IdentifierTextField(final String value, final int width, final int maxLength) {
        this(DEFAULT_PATTERN, value, width, maxLength);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     */
    public IdentifierTextField(final Pattern pattern) {
        this(pattern, null, 0, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     * @param width preferred width of the field in characters
     */
    public IdentifierTextField(final Pattern pattern, final int width) {
        this(pattern, null, width, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     * @param width preferred width of the field in characters
     * @param maxLength maximum character length that can be entered
     */
    public IdentifierTextField(final Pattern pattern, final int width, final int maxLength) {
        this(pattern, null, width, maxLength);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     * @param value initial value
     */
    public IdentifierTextField(final Pattern pattern, final String value) {
        this(pattern, value, 0, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     * @param value initial value
     * @param width preferred width of the field in characters
     */
    public IdentifierTextField(final Pattern pattern, final String value, final int width) {
        this(pattern, value, width, 0);
    }

    /**
     * Construct an instance of the identifier field.
     *
     * @param pattern the identifier pattern
     * @param value initial value
     * @param width preferred width of the field in characters
     * @param maxLength maximum character length that can be entered
     */
    public IdentifierTextField(final Pattern pattern, final String value, final int width, final int maxLength) {
        super(new IdentifierDocument(pattern, maxLength), value, width);
    }

    /**
     * This class provides a document that enforces a maximum length and valid
     * identifier characters.
     */
    private static class IdentifierDocument extends PlainDocument {
        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * The identifier pattern.
         */
        private final Pattern pattern;

        /**
         * The maximum character length that can be entered.
         */
        private final int maxLength;

        /**
         * Construct an instance of the identifier document.
         *
         * @param pattern the identifier pattern
         * @param maxLength maximum character length that can be entered
         */
        IdentifierDocument(final Pattern pattern, final int maxLength) {
            this.pattern = pattern;
            this.maxLength = maxLength;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void insertString(final int offset, final String str, final AttributeSet attributeSet) throws BadLocationException {
            String text = str;

            if (getLength() > 0) {
                StringBuilder buf = new StringBuilder();
                if (offset > 0) {
                    buf.append(getText(0, offset));
                }
                buf.append(str);
                if (offset < getLength()) {
                    buf.append(getText(offset, getLength() - offset));
                }
                text = buf.toString();
            }

            if (maxLength > 0 && text.length() > maxLength) {
                Toolkit.getDefaultToolkit().beep();
            } else if (!pattern.matcher(text).matches()) {
                Toolkit.getDefaultToolkit().beep();
            } else {
                super.insertString(offset, str, attributeSet);
            }
        }
    }
}
