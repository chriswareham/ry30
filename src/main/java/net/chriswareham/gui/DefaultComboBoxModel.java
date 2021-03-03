package net.chriswareham.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * This class provides a default combo box model.
 *
 * @param <T> type of the objects that make up the rows of the model
 */
public class DefaultComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The rows that make up the model.
     */
    private final List<T> rows = new ArrayList<>();

    /**
     * The selected row.
     */
    private T selectedRow;

    /**
     * Get the number of rows in the model.
     *
     * @return the number of rows
     */
    @Override
    public int getSize() {
        return rows.size();
    }

    /**
     * Get a row from the model.
     *
     * @param rowIndex the index of the row to get
     * @return the row
     */
    @Override
    public T getElementAt(final int rowIndex) {
        return rows.get(rowIndex);
    }

    /**
     * Get the selected row in the model.
     *
     * @return the selected row, or null if no row is selected
     */
    @Override
    public Object getSelectedItem() {
        return selectedRow;
    }

    /**
     * Set the selected row in the model.
     *
     * @param o the selected row
     */
    @Override
    public void setSelectedItem(final Object o) {
        if ((selectedRow != null && !selectedRow.equals(o)) || (selectedRow == null && o != null)) {
            selectedRow = getRow(rows.indexOf(o));
            fireContentsChanged(this, -1, -1);
        }
    }

    /**
     * Set the index of the selected row in the model.
     *
     * @param rowIndex the index of the row to select
     */
    public void setSelectedRowIndex(final int rowIndex) {
        setSelectedRow(getRow(rowIndex));
    }

    /**
     * Get the index of the selected row in the model.
     *
     * @return the index of the selected row, or -1 if no row is selected
     */
    public int getSelectedRowIndex() {
        return selectedRow != null ? rows.indexOf(selectedRow) : -1;
    }

    /**
     * Get whether there is a selected row in the model.
     *
     * @return whether there is a selected row in the model
     */
    public boolean isSelectedRow() {
        return selectedRow != null;
    }

    /**
     * Get the selected row in the model.
     *
     * @return the selected row, or null if no row is selected
     */
    public T getSelectedRow() {
        return selectedRow;
    }

    /**
     * Set the selected row in the model.
     *
     * @param row the selected row
     */
    public void setSelectedRow(final T row) {
        if ((selectedRow != null && !selectedRow.equals(row)) || (selectedRow == null && row != null)) {
            selectedRow = getRow(rows.indexOf(row));
            fireContentsChanged(this, -1, -1);
        }
    }

    /**
     * Get a row in the model at a specific index.
     *
     * @param rowIndex the index of the row to get
     * @return the row, or null if the row index is out of range
     */
    public T getRow(final int rowIndex) {
        return rowIndex > -1 && rowIndex < rows.size() ? rows.get(rowIndex) : null;
    }

    /**
     * Get the rows in the model.
     *
     * @return the rows in the model
     */
    public List<T> getRows() {
        return Collections.unmodifiableList(rows);
    }

    /**
     * Add a row to the model.
     *
     * @param row the row to add
     */
    public void addRow(final T row) {
        addRow(rows.size(), row);
    }

    /**
     * Add a row to the model at a specific index.
     *
     * @param rowIndex the index of the row to add
     * @param row the row to add
     */
    public void addRow(final int rowIndex, final T row) {
        rows.add(rowIndex, row);
        fireIntervalAdded(this, rowIndex, rowIndex);
        if (rowIndex == 0 && selectedRow == null) {
            setSelectedRow(row);
        }
    }

    /**
     * Add rows to the model.
     *
     * @param rowsToAdd the rows to add
     */
    public void addRows(final T[] rowsToAdd) {
        addRows(Arrays.asList(rowsToAdd));
    }

    /**
     * Add rows to the model.
     *
     * @param rowsToAdd the rows to add
     */
    public void addRows(final Collection<T> rowsToAdd) {
        if (!rowsToAdd.isEmpty()) {
            int size = rows.size();
            rows.addAll(rowsToAdd);
            fireIntervalAdded(this, size, size + rowsToAdd.size() - 1);
            if (size == 0 && selectedRow == null) {
                setSelectedRow(rowsToAdd.iterator().next());
            }
        }
    }

    /**
     * Remove a row in the model.
     *
     * @param row the row to remove
     */
    public void removeRow(final T row) {
        int rowIndex = rows.indexOf(row);
        if (rowIndex != -1) {
            removeRow(rowIndex);
        }
    }

    /**
     * Remove a row in the model at a specific index.
     *
     * @param rowIndex the index of the row to remove
     */
    public void removeRow(final int rowIndex) {
        if (rows.get(rowIndex) == selectedRow) {
            if (rowIndex == 0) {
                setSelectedRow(rows.size() == 1 ? null : getRow(rowIndex + 1));
            } else {
                setSelectedRow(getRow(rowIndex - 1));
            }
        }
        rows.remove(rowIndex);
        fireIntervalRemoved(this, rowIndex, rowIndex);
    }

    /**
     * Removes the rows in the model.
     */
    public void removeRows() {
        if (!rows.isEmpty()) {
            int size = rows.size();
            rows.clear();
            selectedRow = null;
            fireIntervalRemoved(this, 0, size - 1);
        }
    }
}
