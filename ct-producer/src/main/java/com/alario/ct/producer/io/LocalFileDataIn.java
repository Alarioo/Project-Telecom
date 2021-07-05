package com.alario.ct.producer.io;

import com.alario.ct.common.bean.DataIn;

/**
 * 本地文件的数据输入
 * @author alario
 */
public class LocalFileDataIn implements DataIn {

    public LocalFileDataIn(String path) {
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        setPath(path);
    }
}
