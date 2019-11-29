package com.smartspy.utils;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */

public class ViewPageObjectsTable {

    private int sno;
    private String name;
    private String objType;
    private String description;
    private String identifier;


    public ViewPageObjectsTable(int sno, String name,String objType,String identifier, String description){
        this.sno = sno;
        this.name = name;
        this.description = description;
        this.objType =objType;
        this.identifier=identifier;
    }


    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }

    public int getSno()
    {
        return sno;
    }

    public String getobjType()
    {
        return objType;
    }
    public String getIdentifier(){ return identifier;}
}
