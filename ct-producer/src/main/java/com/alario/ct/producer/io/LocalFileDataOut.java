package com.alario.ct.producer.io;

import com.alario.ct.common.bean.DataOut;

/**
 * 本地文件的数据输出
 * @author alario
 */
public class LocalFileDataOut implements DataOut {
    public LocalFileDataOut(String path) {
        setPath(path);
    }

    @Override
    public void setPath(String Path) {

    }
}
