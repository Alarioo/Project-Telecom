package com.alario.ct.common.bean;

import java.io.Closeable;

/**
 * @author alario
 */
public interface Producer extends Closeable {
    public void setIn(DataIn in);    //数据来源
    public void setOut(DataOut out);     //数据输出
    public void produce();
}
