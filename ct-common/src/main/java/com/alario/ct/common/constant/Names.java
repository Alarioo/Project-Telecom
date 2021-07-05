package com.alario.ct.common.constant;

import com.alario.ct.common.bean.Val;

/**
 * 名称常量枚举类
 * @author alario
 */
public enum Names implements Val {
    NAMESSPACE("ct");

    private String name;

    private Names (String name){
        this.name=name;
    }
    @Override
    public Object getValue() {
        return null;
    }
}
