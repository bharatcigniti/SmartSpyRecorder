package com.smartspy.ui;

import org.openqa.selenium.InvalidElementStateException;
import sun.security.krb5.internal.ccache.Tag;

import java.awt.*;
        import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;
        import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.*;

public class SimpleBrowser extends JFrame implements ActionListener, HyperlinkListener {
    private JTextField addressBar;
    private JEditorPane pane;
    private int index;
    private Tag tag;


    SimpleBrowser() {
        super("Page Object Recorder Browser");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addressBar = new JTextField();
        addressBar.addActionListener(this);
        pane = new JEditorPane();
        pane.setEditable(false);
        pane.addHyperlinkListener(this);
        pane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneMousePressed(evt);
            }
        });
        add(addressBar, BorderLayout.NORTH);
        add(new JScrollPane(pane));
        setSize(new Dimension(400, 400));
    }

    public void actionPerformed(ActionEvent evt) {
        String url = addressBar.getText();
        try {
            pane.setPage(url);
            System.out.println(url);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void hyperlinkUpdate(HyperlinkEvent evt) {
        if (evt.getEventType() != HyperlinkEvent.EventType.ACTIVATED) {
            return;
        }
        JEditorPane srcPane = (JEditorPane)evt.getSource();
        if (evt instanceof HTMLFrameHyperlinkEvent) {
            HTMLDocument doc = (HTMLDocument)pane.getDocument();
            doc.processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent)evt);

        } else {
            String url = evt.getURL().toString();
            addressBar.setText(url);

            try {
                pane.setPage(url);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        SimpleBrowser browser = new SimpleBrowser();
        browser.setVisible(true);
    }

    private void paneMousePressed(java.awt.event.MouseEvent evt) {
        HTMLDocument doc = (HTMLDocument)pane.getDocument();
        System.out.println("doc::"+doc);
    }
}