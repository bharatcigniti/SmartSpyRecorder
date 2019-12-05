package com.smartspy.utils;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Constants {

    public static WebDriver driver=null;
    public static String browser=null;

    //Operations
    public static String all_operations=null;

    public static HashMap<String,String> pageObjectsHashMap=new HashMap<String,String>();
    public static HashMap<String,String> buttonsHashMap=new HashMap<String,String>();
    public static HashMap<String,String> inputHashMap=new HashMap<String,String>();
    public static HashMap<String,String> linkHashMap=new HashMap<String,String>();
    public static HashMap<String,String> checkboxHashMap=new HashMap<String,String>();
    public static HashMap<String,String> radioboxHashMap=new HashMap<String,String>();
    public static HashMap<String,String> listHashMap=new HashMap<String,String>();
    public static HashMap<String,String> textHashMap=new HashMap<String,String>();

    public static String TABLE_SELECTED=null;

}
