package com.alario.ct.common.bean;

/**
 * @author alario
 */
public abstract class Data implements  Val{
    public String content;

    public void setValue(Object val){
        content=(String) val;
    }

    public Object getValue() {
        return null;
    }
}
