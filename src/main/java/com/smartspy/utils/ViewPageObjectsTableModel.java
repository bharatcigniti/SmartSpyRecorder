package com.smartspy.utils;

import org.springframework.expression.spel.ast.Identifier;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPageObjectsTableModel  extends AbstractTableModel {
    private final List<ViewPageObjectsTable> viewPageObjectsTables;

    private final String[] columnNames = new String[] {
            "Sno", "Object Name", "Object Type", "Identifier", "Path"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class,String.class,String.class
    };

    public ViewPageObjectsTableModel(List<ViewPageObjectsTable> viewPageObjectsTables)
    {
        this.viewPageObjectsTables = viewPageObjectsTables;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {

        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return viewPageObjectsTables.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewPageObjectsTable row = viewPageObjectsTables.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
        else if(2 == columnIndex){
            return row.getobjType();
        }
       else if(3 == columnIndex){
            return row.getIdentifier();
        }
        else if(4 == columnIndex){
            return row.getDescription();
        }
        return null;
    }

    List<Color> rowColours = Arrays.asList(
            Color.RED,
            Color.GREEN,
            Color.CYAN
    );
    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }
}
