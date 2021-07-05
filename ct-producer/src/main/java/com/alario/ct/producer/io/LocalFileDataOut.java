package com.alario.ct.producer.io;

import com.alario.ct.common.bean.DataOut;

import java.io.IOException;

/**
 * 本地文件的数据输出
 * @author alario
 */
public class LocalFileDataOut implements DataOut {
    public LocalFileDataOut(String path) {
        setPath(path);
    }

    public void setPath(String Path) {

    }

    public void close() throws IOException {

    }
}
