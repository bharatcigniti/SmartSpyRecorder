package com.smartspy.ui;

import com.google.gson.JsonObject;
import com.smartspy.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;
import java.util.*;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class Main extends javax.swing.JFrame {

    public static ButtonGroup bgBrowsers = new ButtonGroup();
    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    public static String selected_table_row_objName = null;
    public static String selected_table_row_identifier = null;
    public static String selected_table_row_objPath = null;
//    static JSONObject jsonObj=null;
    JSONArray objects = new JSONArray();

    public Main() {
        initComponents();

        loadMain();
    }

    public void loadMain(){
        jPanel2.setVisible(false);
        btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chrome_26px.png")));
        rbChrome.setSelected(true);
        Constants.browser = "chrome";
        chkSelectAll.setSelected(false);
        inputPageName.setEnabled(false);
        btnFindElement.setEnabled(false);
        btnSave.setEnabled(false);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        txtUrl = new javax.swing.JLabel();
        inputUrl = new javax.swing.JTextField();
        btnSelectBrowser = new javax.swing.JButton();
        btnRecord = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        txtPageName = new javax.swing.JLabel();
        inputPageName = new javax.swing.JTextField();
        pnlPageObjects = new javax.swing.JPanel();
        chkLink = new javax.swing.JCheckBox();
        chkButton = new javax.swing.JCheckBox();
        chkInput = new javax.swing.JCheckBox();
        chkRadioButton = new javax.swing.JCheckBox();
        chkComboBox = new javax.swing.JCheckBox();
        chkCheckBox = new javax.swing.JCheckBox();
        chkSelectAll = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPageObjects = new javax.swing.JTable();
        inputSearch = new javax.swing.JTextField();
        btnFindElement = new javax.swing.JButton();
        btnCapture = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbChrome = new javax.swing.JRadioButton();
        rbFirefox = new javax.swing.JRadioButton();
        rbIE11 = new javax.swing.JRadioButton();
        rbEdge = new javax.swing.JRadioButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,new Color(0,122,181) ));

//        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setBackground(new Color(0, 122, 181));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus_18px.png")));
        lblMinimize.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });

        lblMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rectangle_stroked_18px.png")));
        lblMaximize.setForeground(new java.awt.Color(255, 255, 255));
        lblMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMaximizeMousePressed(evt);
            }
        });

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/multiply_18px.png")));
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });
        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 16));
        inputSearch.setForeground(new java.awt.Color(127 , 127, 127));
        inputSearch.setText("  Search with Object Name");
        inputSearch.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputSearch.getText().trim().contains("Search with Object Name")){
                    inputSearch.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputSearch.getText())){
                    inputSearch.setText("  Search with Object Name");
                }
            }

        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        txtUrl.setFont(new java.awt.Font("Tahoma", 1, 14));
        txtUrl.setText("URL :");

        inputUrl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

        btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chrome_26px.png")));
        btnSelectBrowser.setFocusPainted(false);
        btnSelectBrowser.setBorder(null);
        btnSelectBrowser.setBackground(new Color(240, 240, 240));
        btnSelectBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectBrowserActionPerformed(evt);
            }
        });

        btnRecord.setText("Record");
        btnRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/video_camera_18px.png")));
        btnRecord.setFocusPainted(false);
        btnRecord.setBackground(new Color(240, 240, 240));
        btnRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stop_squared_18px.png")));
        btnStop.setFocusPainted(false);
        btnStop.setBackground(new Color(240, 240, 240));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtPageName.setFont(new java.awt.Font("Tahoma", 1, 14));
        txtPageName.setText("Page Name: ");

        inputPageName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

        pnlPageObjects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));

        chkLink.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkLink.setText("Link");

        chkButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkButton.setText("Button");

        chkInput.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkInput.setText("Input");

        chkRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkRadioButton.setText("RadioButton");

        chkComboBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkComboBox.setText("ComboBox");

        chkCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkCheckBox.setText("CheckBox");

        chkSelectAll.setFont(new java.awt.Font("Tahoma", 0, 14));
        chkSelectAll.setSelected(true);
        chkSelectAll.setText("Select All");
        chkSelectAll.addActionListener(actionListener);

        javax.swing.GroupLayout pnlPageObjectsLayout = new javax.swing.GroupLayout(pnlPageObjects);
        pnlPageObjects.setLayout(pnlPageObjectsLayout);
        pnlPageObjectsLayout.setHorizontalGroup(
                pnlPageObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(chkLink)
                                .addGap(31, 31, 31)
                                .addComponent(chkButton)
                                .addGap(26, 26, 26)
                                .addComponent(chkInput)
                                .addGap(18, 18, 18)
                                .addComponent(chkRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(chkComboBox)
                                .addGap(18, 18, 18)
                                .addComponent(chkCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                                .addComponent(chkSelectAll)
                                .addGap(22, 22, 22))
        );
        pnlPageObjectsLayout.setVerticalGroup(
                pnlPageObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(pnlPageObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlPageObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(chkRadioButton)
                                                .addComponent(chkComboBox)
                                                .addComponent(chkCheckBox)
                                                .addComponent(chkSelectAll))
                                        .addGroup(pnlPageObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(chkLink)
                                                .addComponent(chkButton)
                                                .addComponent(chkInput)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );


        jScrollPane1.setViewportView(tblPageObjects);
//        Design.table_dimenetions(tblPageObjects);
        Design.table_ui_style_blue(tblPageObjects);
        tblPageObjects.setModel(getObjectsModel());
//        Design.table_dimenetions_newMethod(tblPageObjects);
        tblPageObjects.getSelectionModel().addListSelectionListener(new SelectionListener());

        btnFindElement.setText("Find");
        btnFindElement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnFindElement.setFocusPainted(false);
        btnFindElement.setBackground(new Color(240, 240, 240));
        btnFindElement.setForeground(new Color(0, 122, 200));
        btnFindElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindElementActionPerformed(evt);
            }
        });

        btnCapture.setText("Capture");
        btnCapture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/screenshot_26px.png")));
        btnCapture.setFocusPainted(false);
        btnCapture.setBackground(new Color(240, 240, 240));
        btnCapture.setForeground(new Color(0, 122, 200));
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save_close_26px.png")));
        btnSave.setFocusPainted(false);
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setForeground(new Color(32, 164, 71));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_bin_26px.png")));
        btnDelete.setFocusPainted(false);
        btnDelete.setBackground(new Color(240, 240, 240));
        btnDelete.setForeground(new Color(230, 0, 0));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

      //  rbChrome.setText("Chrome");
        rbChrome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chrome_26px.png")));
        rbChrome.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbChrome.setSelected(true);
                btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chrome_26px.png")));
                jPanel2.setVisible(false);
                Constants.browser="chrome";
            }
        });

        //rbFirefox.setText("Firefox");
        rbFirefox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/firefox_26px.png")));
        rbFirefox.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbFirefox.setSelected(true);
                btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/firefox_26px.png")));
                jPanel2.setVisible(false);
                Constants.browser="firefox";
            }
        });

//        rbIE11.setText("IE11");
//        rbIE11.setToolTipText("");
        rbIE11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/internet_explorer_26px.png")));
        rbIE11.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbIE11.setSelected(true);
                btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/internet_explorer_26px.png")));
                jPanel2.setVisible(false);
                Constants.browser="ie11";
            }
        });

//        rbEdge.setText("Edge");
        rbEdge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/microsoft_edge_26px.png")));
        rbEdge.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                rbEdge.setSelected(true);
                btnSelectBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/microsoft_edge_26px.png")));
                jPanel2.setVisible(false);
                Constants.browser="edge";
            }
        });

        bgBrowsers.add(rbChrome);
        bgBrowsers.add(rbFirefox);
        bgBrowsers.add(rbEdge);
        bgBrowsers.add(rbIE11);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbIE11)
                                        .addComponent(rbChrome))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbFirefox)
                                        .addComponent(rbEdge))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbChrome)
                                        .addComponent(rbFirefox))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbIE11)
                                        .addComponent(rbEdge))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pnlPageObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtUrl)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(32, 32, 32)
                                                                                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtPageName)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(inputPageName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnSelectBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(btnFindElement, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(117, 117, 117)
                                                .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUrl, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(inputUrl, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSelectBrowser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(inputPageName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPageName)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addComponent(pnlPageObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnFindElement, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {
        this.setState(Frame.ICONIFIED);
    }

    private void lblMaximizeMousePressed(java.awt.event.MouseEvent evt) {
        if (this.getExtendedState() == MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL);
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
        }
    }

    ResourceBundle rbTestdata;
    String driverPath = null;
    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void btnSelectBrowserActionPerformed(java.awt.event.ActionEvent evt) {
       jPanel2.setVisible(true);
    }
    public String readTestdata(String key){
        return rbTestdata.getString(key);
    }
    private void btnRecordActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;
        String url = inputUrl.getText();
        String docPath = System.getProperty("user.home");
        if (url.toLowerCase().startsWith("http://") || url.toLowerCase().startsWith("https://")) {
            String driver = browserDriverName(Constants.browser);
            try {
                if (Generic.isFileExist(docPath+File.separator+"smartspy.properties")) {
                    driverPath = Generic.readConfigProp();
                    if (Generic.isFileExist(driverPath)) {
                        Properties props = new Properties();

                        System.out.println(docPath);
                        FileOutputStream fos = new FileOutputStream(docPath + File.separator + "smartspy.properties");
                        props.setProperty("drivers.path", driverPath);
                        props.store(fos, "Properties file generated from Java program");

                        fos.close();

                    } else {
                        flag = false;
                        JOptionPane.showMessageDialog(null, driver + "::Driver not found in folder path", "Warning.. ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, Constants.browser + "  :: Driver not set...please setup  the driver path...", "Warning.. ", JOptionPane.INFORMATION_MESSAGE);


                    driverPath = Generic.choosefolderPath();
                    System.out.println("driverpath::" + driverPath + File.separator + driver);
                    if (Generic.isFileExist(driverPath + File.separator + driver)) {
                        Properties props = new Properties();

                        System.out.println(docPath);
                        FileOutputStream fos = new FileOutputStream(docPath + File.separator + "smartspy.properties");
                        props.setProperty("drivers.path", driverPath);
                        props.store(fos, "Properties file generated from Smart Spy");

                        fos.close();

                    } else {
                        flag = false;
                        JOptionPane.showMessageDialog(null, driver + "::Driver not found in folder path", "Warning.. ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }


            Drivers.driver_init(Constants.browser,url);
            btnRecord.setEnabled(false);

        } else{
            JOptionPane.showMessageDialog(null, "Please enter correct url...", "Warning" , JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {
        btnRecord.setEnabled(true);
        btnDelete.setEnabled(true);
        inputPageName.setText("");
        Drivers.stop();
    }

    private void btnFindElementActionPerformed(java.awt.event.ActionEvent evt) {
        this.setState(Frame.ICONIFIED);
        WebElement element=null;
       JavascriptExecutor js=((JavascriptExecutor) Constants.driver);

        System.out.println(selected_table_row_objPath);
       if(selected_table_row_identifier.contains("id")){
           element=Constants.driver.findElement(By.id(selected_table_row_objPath.trim()));
       } else  if(selected_table_row_identifier.contains("name")){
            element=Constants.driver.findElement(By.name(selected_table_row_objPath.trim()));
        } else {
          element=Constants.driver.findElement(By.xpath(selected_table_row_objPath.trim()));
       }

       js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", element);

    }

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {

        inputPageName.setEnabled(true);
        inputPageName.setText(Constants.driver.getTitle());
        ArrayList<String> objList=new ArrayList<String>();

        if (chkLink.isSelected()) {
            objList.add("Link");
        }
        if (chkButton.isSelected()) {
            objList.add("Button");
        }
        if (chkCheckBox.isSelected()) {
            objList.add("CheckBox");
        }
        if (chkInput.isSelected()) {
            objList.add("EditBox");
        }

        if (chkRadioButton.isSelected()) {
            objList.add("RadioButton");
        }
        if (chkComboBox.isSelected()) {
            objList.add("ComboBox");
        }
        JavascriptExecutor js=((JavascriptExecutor) Constants.driver);
        String pageSource = js.executeScript("return document.documentElement.outerHTML").toString();
        Constants.pageObjectsHashMap.clear();
        DomExtractor domExtractor = new DomExtractor();
        System.out.println(objList);
        domExtractor.smartExtractor(pageSource, objList);
//        System.out.println(Constants.all_operations);

        Design.table_dimenetions(tblPageObjects);
        tblPageObjects.setModel(getObjectsModel());
        btnFindElement.setEnabled(true);
        btnSave.setEnabled(true);

    }
    public String getActions(String objType){
        String actions=null;
        if(objType.equalsIgnoreCase("Link")){
            actions = "click,getText,isDisplayed,isEnabled";
        } else if(objType.equalsIgnoreCase("Button")){
            actions = "click,doubleClick,isDisplayed,isEnabled";
        } else if(objType.equalsIgnoreCase("Radio Button")){
            actions = "click,getText,isDisplayed,isEnabled,isSelected";
        }else if(objType.equalsIgnoreCase("Input Box")){
            actions = "input,clear,getText,isDisplayed,isEnabled";
        } else if(objType.equalsIgnoreCase("Check Box")){
            actions = "click,getText,isDisplayed,isEnabled,isSelected";
        } else if(objType.equalsIgnoreCase("Combo Box")){
            actions = "select,getItem,isDisplayed,isEnabled,verifyItem";
        }
        return actions;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String fileFolderPath = Generic.choosefolderPath();
        String ObjectType=null;
        String identifier=null;
        List<ViewPageObjectsTable> viewObjects = new ArrayList<ViewPageObjectsTable>();
        String[] args=null;
//        jsonObj = new JSONObject();
        objects.clear();
//        jsonObj.clear();

        int rowCount = tblPageObjects.getModel().getRowCount();
        for(int k=0;k<rowCount;k++){

            objects.add(getObjectInfo((String) tblPageObjects.getModel().getValueAt(k, 1), (String) tblPageObjects.getModel().getValueAt(k, 4),(String) tblPageObjects.getModel().getValueAt(k, 2)));
        }

//        jsonObj.put(Generic.removeSpecialChars(inputPageName.getText()), objects );

        try (FileWriter file = new FileWriter(fileFolderPath+File.separator+Generic.removeSpecialChars(inputPageName.getText())+"_"+Generic.getDate()+"_"+Generic.getTime()+".json")) {
            file.write(objects.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        JOptionPane.showMessageDialog(null, "Successfully Saved , File Path::"+fileFolderPath+File.separator+Generic.removeSpecialChars(inputPageName.getText())+"_"+Generic.getDate()+"_"+Generic.getTime()+".json", "SmartSpy" , JOptionPane.INFORMATION_MESSAGE);
//        System.out.println(jsonObj);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(selected_table_row_objPath+":selected_table_row_objPath");
        Constants.pageObjectsHashMap.remove(selected_table_row_objName);
        Design.table_dimenetions(tblPageObjects);
        tblPageObjects.setModel(getObjectsModel());
    }
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();

            if(selected){
                chkLink.setSelected(true);
                chkButton.setSelected(true);
                chkCheckBox.setSelected(true);
                chkRadioButton.setSelected(true);
                chkComboBox.setSelected(true);
                chkInput.setSelected(true);

            } else {

                chkLink.setSelected(false);
                chkButton.setSelected(false);
                chkCheckBox.setSelected(false);
                chkRadioButton.setSelected(false);
                chkComboBox.setSelected(false);
                chkInput.setSelected(false);
            }
            // abstractButton.setText(newLabel);
        }
    };

    public ViewPageObjectsTableModel getObjectsModel() {
        int i=1;
        String ObjectType=null;
        String identifier=null;
        List<ViewPageObjectsTable> viewObjects = new ArrayList<ViewPageObjectsTable>();
        String[] args=null;


        for (Map.Entry<String, String> entry : Constants.pageObjectsHashMap.entrySet()) {
//            System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
//            if(entry.getValue().contains("id =")){
//                args=entry.getValue().split("id = ");
//                identifier="id";
//            } else if(entry.getValue().contains("name =")){
//                args=entry.getValue().split("name = ");
//                identifier="name";
//            }
//            else {
//                args=entry.getValue().split("xpath = ");
//                identifier="xpath";
//            }
            args=entry.getValue().split("xpath = ");
            identifier="xpath";
            if(entry.getKey().contains("lnk_")){
                ObjectType = "Link";
            } else if(entry.getKey().contains("btn_")){
                ObjectType = "Button";
            } else if(entry.getKey().contains("radio_")){
                ObjectType = "RadioButton";
            }else if(entry.getKey().contains("input_")){
                ObjectType = "TextBox";
            } else if(entry.getKey().contains("chkbox_")){
                ObjectType = "CheckBox";
            } else if(entry.getKey().contains("list_")){
                ObjectType = "List";
            }

//            System.out.println("value::"+entry.getValue());
//
//            System.out.println("args1::"+args[1]);

            ViewPageObjectsTable viewFileTable = new ViewPageObjectsTable(i, entry.getKey(), ObjectType,identifier,args[1].trim());


            viewObjects.add(viewFileTable);
            i = i + 1;
        }

        viewPageObjectsTableModel = new ViewPageObjectsTableModel(viewObjects);

        return viewPageObjectsTableModel;
    }
//    JSONObject getObjectInfo(String objName, String objPath,String objType, String actions){
    JSONObject getObjectInfo(String objName, String objPath,String objType){
        JSONObject obj = new JSONObject();
        obj.put("Name", objName);
        obj.put("Value", objPath);
        obj.put("ObjType",objType);
        //obj.put("Actions", actions);
        return obj ;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblPageObjects.getSelectedRow();
            if(row < 0)
                return;
            int col = tblPageObjects.getSelectedColumn();
            if(col < 0)
                return;

            if (tblPageObjects.getRowSorter()!=null) {
                row = tblPageObjects.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_table_row_objPath = (String) tblPageObjects.getModel().getValueAt(row, 4);
            selected_table_row_identifier = (String) tblPageObjects.getModel().getValueAt(row, 3);
            selected_table_row_objName = (String) tblPageObjects.getModel().getValueAt(row, 1);
          //  Constants.TABLE_SELECTED = selected_table_row;

            tblPageObjects.setSelectionBackground(Color.ORANGE);
            //  txtProjectName.setText(selected_TestScript.toUpperCase());

        }
    }

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    public void filter(String query){
        TableRowSorter<ViewPageObjectsTableModel> tr=new TableRowSorter<ViewPageObjectsTableModel>(viewPageObjectsTableModel);
        tblPageObjects.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    public String browserDriverName(String browser){
        String driverName=null;
        switch(browser.toLowerCase()){
            case "chrome":
                driverName="chromedriver.exe";
                break;
            case "firefox":
                driverName="geckodriver.exe";
                break;
            case "ie11":
                driverName="IEDriverServer.exe";
                break;
            case "edge":
                driverName="MicrosoftWebDriver.exe";
                break;
        }
        return driverName;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindElement;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JButton btnSelectBrowser;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox chkButton;
    private javax.swing.JCheckBox chkCheckBox;
    private javax.swing.JCheckBox chkInput;
    private javax.swing.JCheckBox chkLink;
    private javax.swing.JCheckBox chkComboBox;
    private javax.swing.JCheckBox chkRadioButton;
    private javax.swing.JCheckBox chkSelectAll;
    private javax.swing.JRadioButton rbIE11;
    private javax.swing.JTextField inputPageName;
    private javax.swing.JTextField inputUrl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel pnlPageObjects;
    private javax.swing.JRadioButton rbChrome;
    private javax.swing.JRadioButton rbEdge;
    private javax.swing.JRadioButton rbFirefox;
    private javax.swing.JTable tblPageObjects;
    private javax.swing.JLabel txtPageName;
    private javax.swing.JLabel txtUrl;
    // End of variables declaration
}

