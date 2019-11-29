package com.smartspy.utils;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Design {

    public static void button_ui_style_blue(JButton btn, String btnName){
        btn.setBackground(new Color(0, 122, 181));
        btn.setText(btnName);
        btn.setFont(new Font("Tahoma", 1, 24));
        btn.setForeground(new Color(255, 255, 255));
        btn.setFocusPainted(false);
    }
    public static void button_ui_style_violet(JButton btn,String btnName){
        btn.setBackground(new Color(255, 255, 255));
        btn.setText(btnName);
        btn.setFont(new Font("Tahoma", 1, 18));
        btn.setForeground(new Color(102, 0, 102));
        btn.setFocusPainted(false);
    }
    public static void button_ui_style_violet_Font_32(JButton btn,String btnName){
        btn.setBackground(new Color(255, 255, 255));
        btn.setText(btnName);
        btn.setFont(new Font("Tahoma", 1, 32));
        btn.setForeground(new Color(102, 0, 102));
        btn.setFocusPainted(false);
    }

    public static void table_dimenetions(JTable jTable){
        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(500);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        //Projects.tblProjects.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
       // jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    public static void table_dimenetions_manualsteps(JTable jTable){
        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(500);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        //Projects.tblProjects.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        // jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    public static void table_dimenetions_newMethod(JTable jTable){
        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(2);
        columnModel.getColumn(1).setPreferredWidth(350);
        columnModel.getColumn(2).setPreferredWidth(600);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        //Projects.tblProjects.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        //jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    public static void table_dimenetions_twocolumn(JTable jTable){

        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(500);
      //  columnModel.getColumn(2).setPreferredWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//        jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }

    public static void table_dimenetions_ExecutionLab(JTable jTable){

        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(800);
        //  columnModel.getColumn(2).setPreferredWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//        jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }

    public static void table_ui_style_blue(JTable jTable){

        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new Font("Tahoma", 0, 16));
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.setRowHeight(35);
        jTable.setShowVerticalLines(true);
        jTable.getTableHeader().setFont(new Font("Tahoma", 0, 16));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(new Color(32,136,203));
        jTable.getTableHeader().setForeground(new Color(255,255,255));
    }

    public static void table_ui_style_Vilote(JTable jTable){
        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new Font("Tahoma", 0, 24));
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.setRowHeight(35);
        jTable.setShowVerticalLines(true);
        jTable.getTableHeader().setFont(new Font("Tahoma", 0, 32));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(new Color(163,73,164));
        jTable.getTableHeader().setForeground(new Color(255,255,255));
    }
    public static void table_ui_style_Vilote_SmartGen(JTable jTable){
        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new Font("Tahoma", 0, 24));
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.setRowHeight(35);
        jTable.setShowVerticalLines(true);
        jTable.getTableHeader().setFont(new Font("Tahoma", 0, 28));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(new Color(163,73,164));
        jTable.getTableHeader().setForeground(new Color(255,255,255));
    }


    public static void frame_boarder(JFrame frame){
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6,new Color(158, 71, 158) ));
    }

    public static void listControls(JButton btn){
        btn.setFocusPainted(false);
        btn.setBorder(null);
        btn.setBackground(new Color(255, 255, 255));
    }

    public static void table_dimenetions_testdatasetup(JTable jTable){
        TableColumnModel columnModel= jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(500);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        //Projects.tblProjects.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        //jTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    }
    public static void table_ui_style_Vilote_testdatasetup(JTable jTable){
        jTable.setAutoCreateRowSorter(true);
        jTable.setFont(new Font("Tahoma", 0, 20));
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.setRowHeight(35);
        jTable.setShowVerticalLines(true);
        jTable.getTableHeader().setFont(new Font("Tahoma", 0, 22));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(new Color(163,73,164));
        jTable.getTableHeader().setForeground(new Color(255,255,255));
    }
}
