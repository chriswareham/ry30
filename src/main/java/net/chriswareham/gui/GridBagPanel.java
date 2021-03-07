package net.chriswareham.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * This class provides a panel with methods for laying out components in a grid.
 */
public class GridBagPanel extends JPanel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constraints for the grid layout.
     */
    private final GridBagConstraints constraints = new GridBagConstraints();

    /**
     * Construct an instance of the panel.
     */
    public GridBagPanel() {
        this(new Insets(4, 4, 4, 4));
    }

    /**
     * Construct an instance of the panel.
     *
     * @param insets specifies the external padding of the component
     */
    public GridBagPanel(final Insets insets) {
        super(new GridBagLayout());
        constraints.insets = insets;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.gridx = -1;
        constraints.gridy = 0;
    }

    /**
     * Add a component with a cell width and height of one, no horizontal and
     * vertical fill.
     *
     * @param component the component to add
     * @return the component that was added
     * @deprecated only present since this class extends the default panel
     */
    @Override
    @Deprecated
    public Component add(final Component component) {
        addCell(component);
        return component;
    }

    /**
     * Add a component with a cell width and height of one, no horizontal and
     * vertical fill.
     *
     * @param component the component to add
     * @param index the position at which to insert the component (ignored)
     * @return the component that was added
     * @deprecated only present since this class extends the default panel
     */
    @Override
    @Deprecated
    public Component add(final Component component, final int index) {
        addCell(component);
        return component;
    }

    /**
     * Add a component with a cell width and height of one, no horizontal and
     * vertical fill.
     *
     * @param component the component to add
     * @param obj an object expressing layout constraints for this component
     * @deprecated only present since this class extends the default panel
     */
    @Override
    @Deprecated
    public void add(final Component component, final Object obj) {
        if (obj instanceof Boolean) {
            addCell(component, (Boolean) obj);
        } else {
            addCell(component);
        }
    }

    /**
     * Add a component with a cell width and height of one, no horizontal and
     * vertical fill.
     *
     * @param component the component to add
     * @param obj an object expressing layout constraints for this component
     * @param index the position at which to insert the component (ignored)
     * @deprecated only present since this class extends the default panel
     */
    @Override
    @Deprecated
    public void add(final Component component, final Object obj, final int index) {
        if (obj instanceof Boolean) {
            addCell(component, (Boolean) obj);
        } else {
            addCell(component);
        }
    }

    /**
     * Add a border.
     *
     * @param border the border to add
     * @return the panel
     */
    public GridBagPanel addBorder(final Border border) {
        setBorder(border);
        return this;
    }

    /**
     * Add a right justified label with a cell width and height of one, no
     * horizontal or vertical fill.
     *
     * @param label the label
     * @return the panel
     */
    public GridBagPanel addCell(final String label) {
        return addCell(new JLabel(label, JLabel.RIGHT));
    }

    /**
     * Add a component with a cell width and height of one, no horizontal or
     * vertical fill.
     *
     * @param component the component to add
     * @return the panel
     */
    public GridBagPanel addCell(final Component component) {
        return addCell(component, 1, 1, false, false);
    }

    /**
     * Add a component with a cell width and height of one, no vertical fill.
     *
     * @param component the component to add
     * @param fillX whether the component should fill horizontally
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final boolean fillX) {
        return addCell(component, 1, 1, fillX, false);
    }

    /**
     * Add a component with a cell width and height of one.
     *
     * @param component the component to add
     * @param fillX whether the component should fill horizontally
     * @param fillY whether the component should fill vertically
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final boolean fillX, final boolean fillY) {
        return addCell(component, 1, 1, fillX, fillY);
    }

    /**
     * Add a component with a cell height of one, no horizontal or vertical
     * fill.
     *
     * @param component the component to add
     * @param width the cell width
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final int width) {
        return addCell(component, width, 1, false, false);
    }

    /**
     * Add a component with a cell height of one, no vertical fill.
     *
     * @param component the component to add
     * @param width the cell width
     * @param fillX whether the component should fill horizontally
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final int width, final boolean fillX) {
        return addCell(component, width, 1, fillX, false);
    }

    /**
     * Add a component with a cell height of one.
     *
     * @param component the component to add
     * @param width the cell width
     * @param fillX whether the component should fill horizontally
     * @param fillY whether the component should fill vertically
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final int width, final boolean fillX, final boolean fillY) {
        return addCell(component, width, 1, fillX, fillY);
    }

    /**
     * Add a component.
     *
     * @param component the component to add
     * @param width the cell width
     * @param height the cell height
     * @param fillX whether the component should fill horizontally
     * @param fillY whether the component should fill vertically
     * @return the panel
     */
    public GridBagPanel addCell(final Component component, final int width, final int height, final boolean fillX, final boolean fillY) {
        if (fillX && fillY) {
            constraints.fill = GridBagConstraints.BOTH;
        } else if (fillX) {
            constraints.fill = GridBagConstraints.HORIZONTAL;
        } else if (fillY) {
            constraints.fill = GridBagConstraints.VERTICAL;
        } else {
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }
        constraints.gridx += 1;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = fillX ? 1.0 : 0.0;
        constraints.weighty = fillY ? 1.0 : 0.0;

        super.add(component, constraints);

        return this;
    }

    /**
     * Add an empty cell with a cell width and height of one, no horizontal or
     * vertical fill.
     *
     * @return the panel
     */
    public GridBagPanel addCell() {
        return addCell(false);
    }

    /**
     * Add an empty cell with a cell width and height of one, no vertical fill.
     *
     * @param fillX whether the component should fill horizontally
     * @return the panel
     */
    public GridBagPanel addCell(final boolean fillX) {
        return addCell(new JLabel(""), 1, 1, fillX, false);
    }

    /**
     * Add a row consisting of a horizontally and vertically filled empty cell
     * with a cell width and height of one.
     *
     * @return the panel
     */
    public GridBagPanel addExpandingRow() {
        return addExpandingRow(1);
    }

    /**
     * Add a row consisting of a horizontally and vertically filled empty cell
     * with a cell height of one.
     *
     * @param width the cell width
     * @return the panel
     */
    public GridBagPanel addExpandingRow(final int width) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx += 1;
        constraints.gridwidth = width;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;

        super.add(new JLabel(""), constraints);

        return endRow();
    }

    /**
     * End a row of cells.
     *
     * @return the panel
     */
    public GridBagPanel endRow() {
        constraints.gridx = -1;
        constraints.gridy += 1;

        return this;
    }
}
