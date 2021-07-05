package com.alario.ct.common.bean;

/**
 * @author alario
 */
public class Data implements  Val{
    public String content;

    public void setString(String value){
        content=value;
    }
    @Override
    public Object getValue() {
        return null;
    }
}
