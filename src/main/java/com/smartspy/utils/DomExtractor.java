package com.smartspy.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class DomExtractor {

    StringBuilder stringBuilder = new StringBuilder();
    Document document;
    List<String> listStrings = new ArrayList<String>();
    String innerxpath=null;
    String id = null;
    String name = null;
    String tagName = null;
    String text = null;
    String xpath=null;
    String findby=null;
    String cachelookup = "\t@CacheLookup";
    String webelement = null;


    String pageObjectmodel=null;
    String enumPropertiesmodel=null;
   // String pageName;

    String all;
    String all_links;
    String all_buttons;
    String all_radiobuttons;
    String all_texts;
    String all_lists;
    String all_images;
    String all_checkboxes;
    String all_edits;
    String all_comboboxes;
    String all_textarea;
    HashMap<Integer,String> hmLinks = new HashMap<Integer,String>();
    HashMap<Integer,String> hmEdits = new HashMap<Integer,String>();
    HashMap<Integer,String> hmButtons = new HashMap<Integer,String>();
    HashMap<Integer,String> hmRadioButtons = new HashMap<Integer,String>();
    HashMap<Integer,String> hmCheckBox = new HashMap<Integer,String>();
    HashMap<Integer,String> hmComboBox = new HashMap<Integer,String>();
    HashMap<Integer,String> hmTexts = new HashMap<Integer,String>();
    HashMap<Integer,String> hmImages = new HashMap<Integer,String>();
    //operations
    String allLinkOperations;
    String allInputOperations;
    String allButtonOperations;
    String allRadioButtonOperations;
    String allCheckBoxOperations;
    String allTextOperations;
    String allImageOperations;
    String allListOperations;
    String all_operations;



    public String smartExtractor(String htmlContent, ArrayList<String> objList){
        try
        {
            if(objList.size()!=0) {
                if(htmlContent.contains("</")) {
                    document = Jsoup.parse(htmlContent);
                }else{
                    document = Jsoup.connect(htmlContent).get();
                }
                Elements input_elements = document.getElementsByTag("input");
                for (int k = 0; k <= objList.size() - 1; k++) {
                    switch (objList.get(k)) {
                        case "Link":
                            getLinks();
                            break;
                        case "Button":
                            getButtons(input_elements);
                            break;
                        case "CheckBox":
                            getCheckbox(input_elements);
                            break;
                        case "EditBox":
                            getEdit(input_elements);
                            getTextArea();
                            break;
//                        case "Image":
//                            getImages(input_elements);
//                           // getImageOperations();
//                            break;
//                        case "List":
//                          //  getList(pomType);
//
//                            break;
                        case "RadioButton":
                            getRadioButton(input_elements);
                           // getRadioButtonOperations();
                            break;
                        case "ComboBox":
                            getCombobox();
                           // getListOperations();
                            break;
//                        case "Text (Headers)":
//                            getText();
//                         //   getTextOperations();
//                            break;
                    }
                }


                if(!StringUtils.isEmpty(all_links)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_links;
                    } else {
                        all = all_links;
                    }
                }
                if(!StringUtils.isEmpty(all_buttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_buttons;
                    } else {
                        all = all_buttons;
                    }
                }
                if(!StringUtils.isEmpty(all_checkboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_checkboxes;
                    } else {
                        all = all_checkboxes;
                    }
                }
                if(!StringUtils.isEmpty(all_edits)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_edits;
                    } else {
                        all = all_edits;
                    }
                }
                if(!StringUtils.isEmpty(all_textarea)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_textarea;
                    } else {
                        all = all_textarea;
                    }
                }
                if(!StringUtils.isEmpty(all_images)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_images+System.lineSeparator();
                    } else {
                        all = all_images+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_lists)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_lists;
                    } else {
                        all = all_lists;
                    }
                }
                if(!StringUtils.isEmpty(all_radiobuttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_radiobuttons;
                    } else {
                        all = all_radiobuttons;
                    }
                }
                if(!StringUtils.isEmpty(all_comboboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_comboboxes;
                    } else {
                        all = all_comboboxes;
                    }
                }
                if(!StringUtils.isEmpty(all_texts)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_texts;
                    } else {
                        all = all_texts;
                    }
                }

                //Operations
                if(!StringUtils.isEmpty(allLinkOperations)){
                    if(!StringUtils.isEmpty(all_operations)){
                        all_operations = all_operations+allLinkOperations+System.lineSeparator();
                    } else{
                        all_operations = allLinkOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allInputOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allInputOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allInputOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allButtonOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allButtonOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allButtonOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allRadioButtonOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allRadioButtonOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allRadioButtonOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allListOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allListOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allListOperations+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(allCheckBoxOperations)){
                    if(StringUtils.isEmpty(all_operations)){
                        all_operations = allCheckBoxOperations+System.lineSeparator();
                    } else{
                        all_operations = all_operations+allCheckBoxOperations+System.lineSeparator();
                    }
                }
//                if(!StringUtils.isEmpty(allTextOperations)){
//                    if(StringUtils.isEmpty(all_operations)){
//                        all_operations = allTextOperations+System.lineSeparator()+"\t";
//                    } else{
//                        all_operations = all_operations+allTextOperations+System.lineSeparator()+"\t";
//                    }
//                }
//                if(!StringUtils.isEmpty(allImageOperations)){
//                    if(StringUtils.isEmpty(all_operations)){
//                        all_operations = allImageOperations+System.lineSeparator()+"\t";
//                    } else{
//                        all_operations = all_operations+allImageOperations+System.lineSeparator()+"\t";
//                    }
//                }


                Constants.all_operations=all_operations;


//                if(StringUtils.isEmpty(pageName)){
//                    fileName = "DomExtractor_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
//                } else {
//                    fileName = pageName+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
//                }

//                if(!StringUtils.isEmpty(all)) {
////                    if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName)) {
////                        Generic.writeText(all, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName, false);
////                    }
//
//                } else{
//                    all= "null";
//                    JOptionPane.showMessageDialog(null, "Objects not found", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
//                }
//                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName);
//                pb.start();
            } else{
                JOptionPane.showMessageDialog(null, "Select atleast one Object control", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return all;
    }

    //###############################################################################################
    //###############################################################################################




    //###############################################################################################
    //###############################################################################################
    public void getLinkOperation(){
        Set set = hmLinks.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            value = "\tpublic void click"+mentry.getValue().toString()+"(){   lnk"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allLinkOperations)){
                allLinkOperations = value;
            } else{
                allLinkOperations = allLinkOperations+value;
            }
        }
    }
    public void getButtonOperation(){
        Set set = hmButtons.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   btn"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allButtonOperations)){
                allButtonOperations = value;
            } else{
                allButtonOperations = allButtonOperations+value;
            }
        }

    }

    public void getInputOperation(){
        Set set = hmEdits.entrySet();
        String valueEdit;
        Iterator iteratorEdit = set.iterator();
        String opName;
        while(iteratorEdit.hasNext()) {
            Map.Entry mentry = (Map.Entry)iteratorEdit.next();

            if(firstFive(mentry.getValue().toString()).equalsIgnoreCase("input")) {
                opName= mentry.getValue().toString().replaceAll("input","");
                valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                        "\t\t" + mentry.getValue().toString() + ".sendKeys(input_value); " + System.lineSeparator() +
                        "\t}" + System.lineSeparator();
            } else{
                opName= mentry.getValue().toString().replaceAll("input","");
                valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                        "\t\tinput" + mentry.getValue().toString() + ".sendKeys(input_value); " + System.lineSeparator() +
                        "\t}" + System.lineSeparator();
            }

            if(StringUtils.isEmpty(allInputOperations)){
                allInputOperations = valueEdit;
            } else{
                allInputOperations = allInputOperations+valueEdit;
            }
        }

    }
    public void getRadioButtonOperations(){
        Set set = hmRadioButtons.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allRadioButtonOperations)){
                allRadioButtonOperations = value;
            } else{
                allRadioButtonOperations = allRadioButtonOperations+value;
            }
        }
    }
    public void getListOperations(){
        Set set = hmComboBox.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void select"+mentry.getValue().toString()+"(String itemToSelect){   " +System.lineSeparator()+
                    "\t\tSelect list = new Select(list"+mentry.getValue()+");"+System.lineSeparator()+
                    "\t\tlist.selectByVisibleText(itemToSelect);"+System.lineSeparator()+
                    "\t}";

            if(StringUtils.isEmpty(allListOperations)){
                allListOperations = value;
            } else{
                allListOperations = allListOperations+value;
            }
        }
    }
    public void getCheckBoxOperations(){
        Set set = hmCheckBox.entrySet();
        String value;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();

            value = "\tpublic void click"+mentry.getValue().toString()+"(){   chkbox"+mentry.getValue()+".click();   }"+System.lineSeparator();
            if(StringUtils.isEmpty(allCheckBoxOperations)){
                allCheckBoxOperations = value;
            } else{
                allCheckBoxOperations = allCheckBoxOperations+value;
            }
        }
    }
//    public void getTextOperations(){
//        Set set = hmTexts.entrySet();
//        String value;
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry)iterator.next();
//
//            value = "public void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
//            if(StringUtils.isEmpty(allTextOperations)){
//                allTextOperations = value;
//            } else{
//                allTextOperations = "\t"+allTextOperations+value;
//            }
//        }
//    }
//    public void getImageOperations(){
//        Set set = hmImages.entrySet();
//        String value;
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry)iterator.next();
//
//            value = "public void click"+mentry.getValue().toString()+"(){   radio"+mentry.getValue()+".click();   }"+System.lineSeparator();
//            if(StringUtils.isEmpty(allImageOperations)){
//                allImageOperations = value;
//            } else{
//                allImageOperations = "\t"+allImageOperations+value;
//            }
//        }
//    }


    public void getLinks(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        listStrings.clear();
        String lnkvarName=null;
        innerxpath=null;
        all_links=null;
        String linkInnerH=null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator=0;

        //     Link
        // Elements links = document.select("a[href]");
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            text=link.text();
            if (!StringUtils.isEmpty(text)) {
//                id = link.attr("id");
//                if (!StringUtils.isEmpty(id)) {
//                    objvalue=id;
//                 //   id = "\"" + id + "\"";
//                    findby = "id = " + id ;
//                } else {
                    linkInnerH = link.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = link.text();
                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(link) + "a/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(link) + "a[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(link) + "a/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(link) + "a[text()=" + text + "]";
                            }
                        }
                        objvalue=xpath;
                      //  xpath = "\"" + xpath + "\"";
                        findby = "xpath = " + xpath;

                    }
//                }
                text = Generic.removeSpecialChars(text);
                lnkvarName = "lnk_" + text;
                webelement = lnkvarName;


                iterator = iterator + 1;
//                System.out.println("Strin:"+stringBuilder.toString());
                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement = lnkvarName +"_duplicate"+m;
                            m=m+1;
                        } else {
                            webelement = lnkvarName ;
                        }
                        Constants.pageObjectsHashMap.put(webelement,findby);
                        pageObjectmodel = findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());

                        nullvars();
                    } else{
                        if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                            webelement = lnkvarName +"_dynamic;";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmLinks.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());

                            nullvars();
                        }

                    }
            }
        }

        all_links = stringBuilder.toString();

    }

    public void getButtons(Elements input_buttons){
        String[] textArr = null;
        String text_remove=null;
        String objvalue=null;
        int m = 1;
        String linkInnerH = null;
        String btnvarName = null;
        all_buttons=null;
        listStrings.clear();
        innerxpath = null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator = 0;
        Elements buttons = document.getElementsByTag("button");
        for (Element button : buttons) {
            text = button.text();
            text_remove=Generic.removeSpecialChars(text);
            if (!StringUtils.isEmpty(text) || !StringUtils.isEmpty(text_remove)) {
//                id = button.attr("id");
//                if (!StringUtils.isEmpty(id)) {
//                    objvalue=id;
////                    id = "\"" + id + "\"";
//                    findby = "id = " + id;
//                } else {
                    linkInnerH = button.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text.contains("'")) {
                        textArr = text.split("'");
                        if (innerxpath != null) {
                            xpath = getParentelements(button) + "button/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                        } else {
                            //xpath = "//a[text()=" + text + "]";
                            xpath = getParentelements(button) + "button[contains(text()," + textArr[0] + ")]";
                        }
                    } else {
                        text = "'" + text + "'";

                        if (innerxpath != null) {
                            xpath = getParentelements(button) + "button/" + innerxpath + "[contains(text()," + text + ")]";
                        } else {
                            //xpath = "//a[text()=" + text + "]";
                            xpath = getParentelements(button) + "button[contains(text()," + text +")]";
                        }
                    }
                    objvalue=xpath;
//                    xpath = "\"" + xpath + "\"";
                    findby = "xpath = " + xpath;
//                }

                text = Generic.removeSpecialChars(text);
                btnvarName = "btn_" + text;
                webelement = btnvarName;
                iterator = iterator + 1;

                if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement =btnvarName + "_duplicate" + m;
                        Constants.pageObjectsHashMap.put(webelement,findby);
                        m = m + 1;
                    } else {
                        webelement = btnvarName ;
                        Constants.pageObjectsHashMap.put(webelement,findby);
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmButtons.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else {
                    if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                        webelement = btnvarName + "_dynamic;";
                        Constants.pageObjectsHashMap.put(webelement,findby);
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmButtons.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }


            }

        }
        //Elements input_buttons = document.getElementsByTag("input");
        objvalue=null;
        for (Element input_button : input_buttons) {
            if (input_button.attr("type").equalsIgnoreCase("submit")) {
                text = input_button.text();
                text_remove=Generic.removeSpecialChars(text);
                if (!StringUtils.isEmpty(text) || !StringUtils.isEmpty(text_remove)) {
//                    id = input_button.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id ;
//                    } else {
                        linkInnerH = input_button.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(input_button) + "button/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(input_button) + "button[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(input_button) + "button/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(input_button) + "button[text()=" + text + "]";
                            }
                        }
                        objvalue=xpath;
//                        xpath = "\"" + xpath + "\"";
                        findby = "xpath = " + xpath;
//                    }

                    text = Generic.removeSpecialChars(text);
                    btnvarName = "btn_" + text;
                    webelement =  btnvarName;
                    iterator = iterator + 1;

                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement =  btnvarName + "_duplicate" + m ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            m = m + 1;
                        } else {
                            webelement =  btnvarName;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                        }
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmButtons.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    } else {
                        if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                            webelement = btnvarName + "_dynamic";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmButtons.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        }

                    }
                }
            }
        }
        objvalue=null;
        for (Element input_img : input_buttons) {
            if (input_img.attr("type").equalsIgnoreCase("image")) {
                text =  input_img.attr("alt");

                if (!StringUtils.isEmpty(text)) {
//                    id = input_img.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id;
//                    } else {
                        linkInnerH = input_img.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        text = "'" + text + "'";
                        if (innerxpath != null) {
                            xpath = getParentelements(input_img) + "input/" + innerxpath + "[@alt=" + text + "]";
                        } else {
                            xpath = getParentelements(input_img) + "input[@alt=" + text + "]";
                        }
                        objvalue = xpath;
//                        xpath = "\"" + xpath + "\"";
                        findby = "xpath = " + xpath;
//                    }
                    text = Generic.removeSpecialChars(text);
                    btnvarName = "btn_" + text;
                    webelement =  btnvarName;

                    iterator = iterator + 1;
                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement = btnvarName + "_duplicate" + m ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            m = m + 1;
                        } else {
                            webelement =  btnvarName ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                        }
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmButtons.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    } else {
                        if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                            webelement =  btnvarName + "_dynamic";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmButtons.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        }
                    }
                }
            }
        }
        all_buttons = stringBuilder.toString();
    }


    public void getCheckbox(Elements input_Checkboxes){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String linkInnerH=null;
        String chkvarName=null;
        listStrings.clear();
        innerxpath=null;
         all_checkboxes=null;
        stringBuilder.delete(0, stringBuilder.length());
        int iterator=0;
        for (Element input_checkbox : input_Checkboxes) {
            if (input_checkbox.attr("type").equalsIgnoreCase("checkbox")) {
                text = input_checkbox.attr("name");
                if (!StringUtils.isEmpty(text)) {
//                    id = input_checkbox.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id ;
//                    } else {
                        linkInnerH = input_checkbox.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        if (text != null) {
                            if (text.contains("'")) {
                                textArr = text.split("'");
                                if (innerxpath != null) {
                                    xpath = getParentelements(input_checkbox) + "input/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                                } else {
                                    //xpath = "//a[text()=" + text + "]";
                                    xpath = getParentelements(input_checkbox) + "input[text()=" + text + "]";
                                }
                            } else {
                                text = "'" + text + "'";

                                if (innerxpath != null) {
                                    xpath = getParentelements(input_checkbox) + "input/" + innerxpath + "[text()=" + text + "]";
                                } else {
                                    //xpath = "//a[text()=" + text + "]";
                                    xpath = getParentelements(input_checkbox) + "input[text()=" + text + "]";
                                }
                            }
                            objvalue=xpath;
//                            xpath = "\"" + xpath + "\"";
                            findby = "xpath = " + xpath;

//                        }
                    }
                    text = Generic.removeSpecialChars(text);
                    chkvarName = "chkbox_" + text;
                    webelement = chkvarName;


                    iterator = iterator + 1;

                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement =  chkvarName +"_duplicate"+m;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            m=m+1;
                        } else {
                            webelement =  chkvarName ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                        }
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmCheckBox.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());

                        nullvars();
                    } else{
                        if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                            webelement = chkvarName +"_dynamic";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmCheckBox.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());

                            nullvars();
                        }

                    }

                }

            }
        }
        all_checkboxes = stringBuilder.toString();

    }

    public void getEdit(Elements input_Edits){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String linkInnerH=null;
        String inputvarName=null;
        listStrings.clear();
        int iterator=0;
        innerxpath=null;
        all_edits=null;
        stringBuilder.delete(0, stringBuilder.length());

        for (Element input_edit : input_Edits) {
            if (input_edit.attr("type").equalsIgnoreCase("input")||input_edit.attr("type").equalsIgnoreCase("text")||input_edit.attr("type").equalsIgnoreCase("password")||input_edit.attr("type").equalsIgnoreCase("email")||input_edit.attr("type").equalsIgnoreCase("number")||input_edit.attr("type").equalsIgnoreCase("search")||input_edit.attr("type").equalsIgnoreCase("url")||input_edit.attr("type").equalsIgnoreCase("tel")) {
                text =  input_edit.attr("name");
                if (!StringUtils.isEmpty(text)) {

//                    id = input_edit.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id;
//                    } else {
                        linkInnerH = input_edit.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(input_edit) + "input/" + innerxpath + "[contains(@name,'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(input_edit) + "input[@name=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(input_edit) + "input/" + innerxpath + "[@name=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(input_edit) + "input[@name=" + text + "]";
                            }
                        }
                        objvalue=xpath;
//                        xpath = "\"" + xpath + "\"";
                        findby = "xpath = " + xpath;

//                    }
                    text = Generic.removeSpecialChars(text);
                    inputvarName = "input_" + text;
                    webelement = inputvarName;


                        iterator = iterator + 1;
                        if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                            if (stringBuilder.toString().contains(webelement)) {
                                webelement =  inputvarName + "_duplicate" + m ;
                                Constants.pageObjectsHashMap.put(webelement,findby);
                                m = m + 1;
                            } else {
                                webelement =  inputvarName ;
                                Constants.pageObjectsHashMap.put(webelement,findby);
                            }
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmEdits.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        } else {
                            if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                                webelement =  inputvarName + "_dynamic";
                                Constants.pageObjectsHashMap.put(webelement,findby);
                                pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                                hmEdits.put(iterator, text);
                                stringBuilder.append(pageObjectmodel);
                                stringBuilder.append(System.lineSeparator());
                                nullvars();
                            }

                        }
                    }
            }
        }
        all_edits = stringBuilder.toString();
    }



    public void getCombobox(){
        String[] textArr=null;
        int m=1;
        String linkInnerH=null;
        String cmboxvarName=null;
        listStrings.clear();
        innerxpath=null;
        all_comboboxes=null;
        int iterator=0;
        stringBuilder.delete(0, stringBuilder.length());
        Elements comboboxes = document.getElementsByTag("select");
        for (Element cmbox : comboboxes) {
            if (!StringUtils.isEmpty(cmbox.text())) {
//                id = cmbox.attr("id");
//                if (!StringUtils.isEmpty(id)) {
////                    id = "\"" + id + "\"";
//                    findby = "id = " + id;
//                } else {
//                    name = cmbox.attr("name");
//                    if (!StringUtils.isEmpty(name)) {
//                        findby = "name =" + name;
//                    } else {
                        linkInnerH = cmbox.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }
                        text = cmbox.attr("name");
                        if (text != null) {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(cmbox) + "select/" + innerxpath + "[@name=\"" + text + "\"]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(cmbox) + "select[@name=\"" + text + "\"]";
                            }
//                        xpath = "\"" + xpath + "\"";
                            findby = "xpath = " + xpath;

                        }
                        text = Generic.removeSpecialChars(text);
                        cmboxvarName = "list_" + text;
                        webelement = cmboxvarName;


                        iterator = iterator + 1;
                        if (findby != null && !stringBuilder.toString().contains(xpath)) {
                            if (stringBuilder.toString().contains(webelement)) {
                                webelement = cmboxvarName + "_duplicate" + m;
                                Constants.pageObjectsHashMap.put(webelement, findby);
                                m = m + 1;
                            } else {
                                webelement = cmboxvarName;
                                Constants.pageObjectsHashMap.put(webelement, findby);
                            }
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmComboBox.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        } else {
                            if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                                webelement = cmboxvarName + "_dynamic";
                                Constants.pageObjectsHashMap.put(webelement, findby);
                                pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                                hmComboBox.put(iterator, text);
                                stringBuilder.append(pageObjectmodel);
                                stringBuilder.append(System.lineSeparator());
                                nullvars();
                            }

                        }

//                    }
//                }
            }
        }
        all_comboboxes = stringBuilder.toString();
    }
    public void getTextArea(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String linkInnerH=null;
        String inputvarName=null;
        listStrings.clear();
        int iterator=0;
        innerxpath=null;
        //all_edits=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements textAreas = document.getElementsByTag("textarea");
        for (Element textarea : textAreas) {
            text = textarea.attr("name");


                if (!StringUtils.isEmpty(text) || text!=null) {

//                    id = textarea.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id;
//                    } else {
                        linkInnerH = textarea.html();
                        if (linkInnerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(linkInnerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textarea) + "textarea/" + innerxpath + "[contains(@name,'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textarea) + "textarea[@name=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textarea) + "textarea/" + innerxpath + "[@name=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textarea) + "textarea[@name=" + text + "]";
                            }
                        }
                        objvalue=xpath;
//                        xpath = "\"" + xpath + "\"";
                        findby = "xpath = " + xpath;

//                    }
                    text = Generic.removeSpecialChars(text);
                    inputvarName = "input_" + text;
                    webelement =  inputvarName;


                    iterator = iterator + 1;
                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement = inputvarName + "_duplicate" + m ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            m = m + 1;
                        } else {
                            webelement =  inputvarName ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                        }
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmEdits.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    } else {
                        if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                            webelement =  inputvarName + "_dynamic";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmEdits.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        }

                    }

            }
        }
        all_textarea = stringBuilder.toString();
    }
    public void getRadioButton(Elements input_radios){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String radiovarName=null;
        listStrings.clear();
        innerxpath=null;
         all_radiobuttons=null;
        stringBuilder.delete(0, stringBuilder.length());
        for (Element input_radio : input_radios) {
            if (input_radio.attr("type").equalsIgnoreCase("radio")) {
                text = input_radio.attr("value");
                if (!StringUtils.isEmpty(text)) {
//                    id = input_radio.attr("id");
//                    if (!StringUtils.isEmpty(id)) {
//                        objvalue=id;
////                        id = "\"" + id + "\"";
//                        findby = "id = " + id;
//                    } else {
                        innerH = input_radio.html();
                        if (innerH.contains("<")) {
                            Document innerdoc = Jsoup.parse(innerH);
                            Elements innerelements = innerdoc.getAllElements();
                            for (Element innerele : innerelements) {
                                listStrings.add(innerele.tag().getName());
                            }
                            innerxpath = listStrings.get(4);
                            for (int i = 5; i <= listStrings.size() - 1; i++) {
                                innerxpath = innerxpath + "/" + listStrings.get(i);
                            }
                            listStrings.clear();

                        }

                        if (text != null) {
                            if (text.contains("'")) {
                                textArr = text.split("'");
                                if (innerxpath != null) {
                                    xpath = getParentelements(input_radio) + "input/" + innerxpath + "[contains(@value,'" + textArr[0] + "')]";
                                } else {
                                    //xpath = "//a[text()=" + text + "]";
                                    xpath = getParentelements(input_radio) + "input[@value=" + text + "]";
                                }
                            } else {
                                text = "'" + text + "'";

                                if (innerxpath != null) {
                                    xpath = getParentelements(input_radio) + "input/" + innerxpath + "[@value=" + text + "]";
                                } else {
                                    //xpath = "//a[text()=" + text + "]";
                                    xpath = getParentelements(input_radio) + "input[@value=" + text + "]";
                                }
                            }
                            objvalue=xpath;
//                            xpath = "\"" + xpath + "\"";
                            findby = "xpath = " + xpath;
//                        }
                    }
                    text = Generic.removeSpecialChars(text);
                    radiovarName = "radio_" + text;
                    webelement =  radiovarName;


                    iterator = iterator + 1;
                    if (findby != null && !stringBuilder.toString().contains(objvalue)) {
                        if (stringBuilder.toString().contains(webelement)) {
                            webelement = radiovarName +"_duplicate"+m;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            m=m+1;
                        } else {
                            webelement =  radiovarName ;
                            Constants.pageObjectsHashMap.put(webelement,findby);
                        }
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmRadioButtons.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    } else{
                        if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                            webelement =  radiovarName +"_dynamic";
                            Constants.pageObjectsHashMap.put(webelement,findby);
                            pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                            hmRadioButtons.put(iterator, text);
                            stringBuilder.append(pageObjectmodel);
                            stringBuilder.append(System.lineSeparator());
                            nullvars();
                        }

                    }


                }
            }
        }
        all_radiobuttons = stringBuilder.toString();
    }

    public void getText(){
        all_texts = null;
        stringBuilder.delete(0, stringBuilder.length());
        geth1();
        geth2();
        geth3();
        geth4();
        geth5();
       // geth5(pomType);
        geth6();
        //getp();
        getsmall();
    }

    public void geth1(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_h1s = document.getElementsByTag("h1");
        for (Element h1 : text_h1s) {
            text = h1.text();
            if (!StringUtils.isEmpty(text)) {
                id = h1.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = h1.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(h1) + "h1/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(h1) + "h1[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(h1) + "h1/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(h1) + "h1[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                    text = Generic.removeSpecialChars(text);
                    h1varName = "txt" + text;
                    webelement = "public WebElement " + h1varName;
                    iterator = iterator + 1;
                System.out.println(findby+"::"+stringBuilder.toString());
                if (findby != null) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName + "_duplicate" + m + ";";
                        m = m + 1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else {
                    if (!stringBuilder.toString().contains(webelement + "_dynamic")) {
                        webelement = "public WebElement " + h1varName + "_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
       all_texts = stringBuilder.toString();
    }

    public void geth2(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("h2");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h2/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h2[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h2/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h2[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null ) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }
    public void geth3(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("h3");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h3/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h3[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h3/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h3[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }
    public void geth4(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("h4");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h4/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h4[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h4/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h4[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null ) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }
    public void geth5(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("h5");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h5/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h5[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h5/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h5[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null ) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }
    public void geth6(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("h6");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h6/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h6[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "h6/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "h6[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null ) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }
    public void getsmall(){
        String[] textArr=null;
        int m=1;
        String objvalue=null;
        String innerH=null;
        int iterator=0;
        String h1varName=null;
        listStrings.clear();
        innerxpath=null;
        Elements text_s = document.getElementsByTag("small");
        for (Element textHeader : text_s) {
            text = textHeader.text();
            if (!StringUtils.isEmpty(text)) {
                id = textHeader.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    objvalue=id;
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id = " + id + ")";
                } else {
                    innerH = textHeader.html();
                    if (innerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(innerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }

                    if (text != null) {
                        if (text.contains("'")) {
                            textArr = text.split("'");
                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "small/" + innerxpath + "[contains(text(),'" + textArr[0] + "')]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "small[text()=" + text + "]";
                            }
                        } else {
                            text = "'" + text + "'";

                            if (innerxpath != null) {
                                xpath = getParentelements(textHeader) + "small/" + innerxpath + "[text()=" + text + "]";
                            } else {
                                //xpath = "//a[text()=" + text + "]";
                                xpath = getParentelements(textHeader) + "small[text()=" + text + "]";
                            }
                        }
                        xpath = "\"" + xpath + "\"";
                        findby = "@FindBy(xpath = " + xpath + ")";

                    }
                }
                text = Generic.removeSpecialChars(text);
                h1varName = "txt" + text;
                webelement = "public WebElement " + h1varName;


                iterator = iterator + 1;
                if (findby != null ) {
                    if (stringBuilder.toString().contains(webelement)) {
                        webelement = "public WebElement " + h1varName +"_duplicate"+m+ ";";
                        m=m+1;
                    } else {
                        webelement = "public WebElement " + h1varName + ";";
                    }
                    pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                    hmLinks.put(iterator, text);
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                    nullvars();
                } else{
                    if (!stringBuilder.toString().contains(webelement+"_dynamic")) {
                        webelement = "public WebElement " + h1varName +"_dynamic;";
                        pageObjectmodel = cachelookup + System.lineSeparator() + "\t" + findby + System.lineSeparator() + "\t" + webelement + System.lineSeparator();
                        hmLinks.put(iterator, text);
                        stringBuilder.append(pageObjectmodel);
                        stringBuilder.append(System.lineSeparator());
                        nullvars();
                    }

                }

            }
        }
        all_texts = stringBuilder.toString();
    }



    public void nullvars(){
        findby = null;
        webelement = null;
        innerxpath = null;
        text=null;
        xpath=null;
        id=null;
        enumPropertiesmodel=null;
        pageObjectmodel=null;
    }


    public static String getParentelements(Element element){
        String returnVal=null;
        String id=null;
        String level1 = element.parentNode().nodeName();
        returnVal="//"+level1+"/";
        if(level1.equalsIgnoreCase("body")){
            return returnVal;
        } else {
            id = element.parentNode().attr("id");
            if(StringUtils.isEmpty(id)){
                String level2 = element.parentNode().parentNode().nodeName();
                returnVal = "//" + level2 + "/" + level1 + "/";
                if (level2.equalsIgnoreCase("body")) {
                    return returnVal;
                } else {
                    id=element.parentNode().parentNode().attr("id");
                    if(StringUtils.isEmpty(id)){
                        String level3 = element.parentNode().parentNode().parentNode().nodeName();
                        returnVal = "//" + level3 + "/" + level2 + "/" + level1 + "/";
                        if (level2.equalsIgnoreCase("body")) {
                            return returnVal;
                        } else {
                            id=element.parentNode().parentNode().parentNode().attr("id");
                            if(StringUtils.isEmpty(id)){
                                String level4 = element.parentNode().parentNode().parentNode().parentNode().nodeName();
                                returnVal = "//" + level4 + "/" + level3 + "/" + level2 + "/" + level1 + "/";
                                if (level4.equalsIgnoreCase("body")) {
                                    return returnVal;
                                } else {
                                    id=element.parentNode().parentNode().parentNode().parentNode().attr("id");
                                    if(StringUtils.isEmpty(id)){
                                        String level5 = element.parentNode().parentNode().parentNode().parentNode().parentNode().nodeName();
                                        returnVal = "//" + level5 + "/" + level4 + "/" + level3 + "/" + level2 + "/" + level1 + "/";
                                        if (level5.equalsIgnoreCase("body")) {
                                            return returnVal;
                                        } else {
                                            id=element.parentNode().parentNode().parentNode().parentNode().parentNode().attr("id");
                                            if(StringUtils.isEmpty(id)){
                                                id=element.parentNode().parentNode().parentNode().parentNode().parentNode().attr("class");

                                                if(StringUtils.isEmpty(id)){
                                                    return returnVal;
                                                } else {
                                                    returnVal="//"+level5+"[@class='"+id+"']"+"/" + level4 + "/" + level3 + "/" + level2 + "/" + level1 + "/";
                                                }
                                                return returnVal;
                                            } else {
                                                returnVal="//"+level5+"[@id='"+id+"']//"+level2+"//";
                                            }
                                        }

                                    } else{
                                        returnVal="//"+level4+"[@id='"+id+"']//"+level2+"//";
                                    }
                                }
                            } else {
                                returnVal="//"+level3+"[@id='"+id+"']//"+level2+"//";
                            }
                        }

                    } else{
                        returnVal="//"+level2+"[@id='"+id+"']//";
                    }
                }

            } else{
                returnVal="//"+level1+"[@id='"+id+"']/";
            }
        }
        return returnVal;
    }
    public String firstFive(String str) {
        return str.length() < 5 ? str : str.substring(0, 5);
    }
}
