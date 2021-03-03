package net.chriswareham.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * This class provides utility methods for menus.
 */
public final class MenuUtils {
    /**
     * Create a menu.
     *
     * @param label the label text for the menu
     * @param mnemonic the mnemonic for the menu accelerator
     * @param accessibleDescription the description of the menu for tool tips, etc.
     * @return a menu
     */
    public static JMenu createMenu(final String label, final String mnemonic, final String accessibleDescription) {
        JMenu menu = new JMenu(label);
        menu.setMnemonic(mnemonic.charAt(0));
        menu.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        return menu;
    }

    /**
     * Create a menu item.
     *
     * @param label the label text for the menu item
     * @param accessibleDescription the description of the menu item for tool tips, etc.
     * @param actionListener the listener for when the menu item is selected
     * @return a menu item
     */
    public static JMenuItem createMenuItem(final String label, final String accessibleDescription, final ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    /**
     * Create a menu item.
     *
     * @param label the label text for the menu item
     * @param mnemonic the mnemonic for the menu item accelerator
     * @param accessibleDescription the description of the menu item for tool tips, etc.
     * @param actionListener the listener for when the menu item is selected
     * @return a menu item
     */
    public static JMenuItem createMenuItem(final String label, final String mnemonic, final String accessibleDescription, final ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.setMnemonic(mnemonic.charAt(0));
        menuItem.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }

    /**
     * Create a menu item.
     *
     * @param label the label text for the menu item
     * @param mnemonic the mnemonic for the menu item accelerator
     * @param accessibleDescription the description of the menu item for tool tips, etc.
     * @param actionListener the listener for when the menu item is selected
     * @param enabled whether the menu item is enabled
     * @return a menu item
     */
    public static JMenuItem createMenuItem(final String label, final String mnemonic, final String accessibleDescription, final ActionListener actionListener, final boolean enabled) {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.setMnemonic(mnemonic.charAt(0));
        menuItem.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        menuItem.addActionListener(actionListener);
        menuItem.setEnabled(enabled);
        return menuItem;
    }

    /**
     * Utility class - no public constructor.
     */
    private MenuUtils() {
        // empty
    }
}
