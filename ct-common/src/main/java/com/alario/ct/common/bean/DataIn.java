package com.alario.ct.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @author alario
 */
public interface DataIn extends Closeable {
    public void setPath(String Path);
    public Object read() throws IOException;
    public <T extends Data > List<T> read(Class<T> t) throws IOException;
    // <T extends Data > 约束Data子类避免不能封装类型传入
}
