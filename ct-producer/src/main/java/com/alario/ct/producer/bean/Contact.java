package com.alario.ct.producer.bean;

import com.alario.ct.common.bean.Data;

/**
 * @author alario
 */
public class Contact extends Data {
    private String name;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setValue(Object val) {
        content=(String) val;
        String[] values = content.split("\t");
        setName(values[1]);
        setTel(values[0]);
    }

    @Override
    public String toString() {
        return "Contact{" + name + ","+ tel + '}'+"\n";
    }

}
