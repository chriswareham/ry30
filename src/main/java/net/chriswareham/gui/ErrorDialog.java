package net.chriswareham.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 * This class provides an error dialog.
 */
public final class ErrorDialog extends JDialog {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Show an instance of the error dialog. Does not return to the caller until
     * the dialog is dismissed.
     *
     * @param title the title
     * @param exception the exception to extract the message and details from
     */
    public static void showDialog(final String title, final Exception exception) {
        ErrorDialog dialog = new ErrorDialog(title, exception);
        dialog.setVisible(true);
    }

    /**
     * Show an instance of the error dialog. Does not return to the caller until
     * the dialog is dismissed.
     *
     * @param parent the parent window
     * @param title the title
     * @param exception the exception to extract the message and details from
     */
    public static void showDialog(final Window parent, final String title, final Exception exception) {
        ErrorDialog dialog = new ErrorDialog(parent, title, exception);
        dialog.setVisible(true);
    }

    /**
     * Show an instance of the error dialog. Does not return to the caller until
     * the dialog is dismissed.
     *
     * @param parent the parent window
     * @param title the title
     * @param message the message
     * @param exception the exception to extract the message and details from
     */
    public static void showDialog(final Window parent, final String title, final String message, final Exception exception) {
        ErrorDialog dialog = new ErrorDialog(parent, title, message, exception);
        dialog.setVisible(true);
    }

    /**
     * Get the stack trace of an exception as a string.
     *
     * @param exception the exception
     * @return the stack trace as a string
     */
    private static String stackTraceToString(final Exception exception) {
        StringBuilder buf = new StringBuilder();

        for (Throwable cause = exception; cause != null; cause = cause.getCause()) {
            buf.append("Caused by: ");
            buf.append(cause.getMessage());
            buf.append('\n');
            for (StackTraceElement element : cause.getStackTrace()) {
                buf.append(element.toString());
                buf.append('\n');
            }
            buf.append('\n');
        }

        return buf.toString();
    }

    /**
     * The details button.
     */
    private JButton detailsButton;

    /**
     * The details scroll pane.
     */
    private JScrollPane detailsPane;

    /**
     * Whether the details are visible.
     */
    private boolean detailsVisible;

    /**
     * Whether the details have been visible.
     */
    private boolean detailsBeenVisible;

    /**
     * Construct an instance of the error dialog.
     *
     * @param title the title
     * @param exception the exception to extract the message and details from
     */
    private ErrorDialog(final String title, final Exception exception) {
        this(null, title, exception.getMessage(), stackTraceToString(exception));
    }

    /**
     * Construct an instance of the error dialog.
     *
     * @param parent the parent window
     * @param title the title
     * @param exception the exception to extract the message and details from
     */
    private ErrorDialog(final Window parent, final String title, final Exception exception) {
        this(parent, title, exception.getMessage(), stackTraceToString(exception));
    }

    /**
     * Construct an instance of the error dialog.
     *
     * @param parent the parent window
     * @param title the title
     * @param message the message
     * @param exception the exception to extract the message and details from
     */
    private ErrorDialog(final Window parent, final String title, final String message, final Exception exception) {
        this(parent, title, message, stackTraceToString(exception));
    }

    /**
     * Construct an instance of the error dialog.
     *
     * @param parent the parent window
     * @param title the title
     * @param message the message
     * @param details the details
     */
    private ErrorDialog(final Window parent, final String title, final String message, final String details) {
        super(parent, title, DEFAULT_MODALITY_TYPE);
        createInterface(parent, message, details);
    }

    /**
     * Create the interface.
     *
     * @param parent the parent window
     * @param message the message
     * @param details the details
     */
    private void createInterface(final Window parent, final String message, final String details) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent event) {
                close();
            }
        });

        JLabel messageLabel = new JLabel(message, UIManager.getIcon("OptionPane.errorIcon"), JLabel.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        getContentPane().add(messageLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(details, 8, 0);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        detailsPane = new JScrollPane(textArea);
        detailsPane.setBorder(BorderFactory.createLoweredBevelBorder());

        detailsButton = new JButton("Details >>");
        detailsButton.addActionListener(event -> toggleDetails());

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(event -> close());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(detailsButton);
        buttonPanel.add(closeButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();

        setLocationRelativeTo(parent);
    }

    /**
     * Toggle display of the details.
     */
    private void toggleDetails() {
        Dimension dialogSize = getSize();

        if (detailsVisible) {
            detailsButton.setText("Details >>");
            getContentPane().remove(detailsPane);
            Dimension detailsPaneSize = detailsPane.getSize();
            dialogSize.height -= detailsPaneSize.height;
        } else {
            detailsButton.setText("Details <<");
            getContentPane().add(detailsPane, BorderLayout.CENTER);
            Dimension detailsPaneSize;
            if (detailsBeenVisible) {
                detailsPaneSize = detailsPane.getSize();
            } else {
                detailsBeenVisible = true;
                detailsPaneSize = detailsPane.getPreferredSize();
            }
            dialogSize.height += detailsPaneSize.height;
        }

        detailsVisible = !detailsVisible;

        setSize(dialogSize);
        invalidate();
        validate();
    }

    /**
     * Close the dialog.
     */
    private void close() {
        setVisible(false);
        dispose();
    }
}
