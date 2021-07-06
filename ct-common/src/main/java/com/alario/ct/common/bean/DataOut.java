package com.alario.ct.common.bean;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author alario
 */
public interface DataOut extends Closeable {
    public void setPath(String Path);
    public void write(Object data) throws Exception;
    public void write(String data) throws Exception;
}
