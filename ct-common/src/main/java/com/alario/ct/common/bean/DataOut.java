package com.alario.ct.common.bean;

import java.io.Closeable;

/**
 * @author alario
 */
public interface DataOut extends Closeable {
    public void setPath(String Path);
}
