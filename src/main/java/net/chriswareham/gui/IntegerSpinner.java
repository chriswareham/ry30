package net.chriswareham.gui;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * This class provides a spinner that displays integers.
 */
public class IntegerSpinner extends JSpinner {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct an instance of the integer spinner.
     *
     * @param model the spinner number model
     */
    public IntegerSpinner(final SpinnerNumberModel model) {
        this(model, false);
    }

    /**
     * Construct an instance of the integer spinner.
     *
     * @param model the spinner number model
     * @param editable whether the value is directly editable
     */
    public IntegerSpinner(final SpinnerNumberModel model, final boolean editable) {
        super(model);
        createInterface(editable);
    }

    /**
     * Create the interface.
     *
     * @param editable whether the value is directly editable
     */
    private void createInterface(final boolean editable) {
        NumberEditor editor = new JSpinner.NumberEditor(this, "#");
        editor.getTextField().setEditable(editable);
        setEditor(editor);
    }
}
