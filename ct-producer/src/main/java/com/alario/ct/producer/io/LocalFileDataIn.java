package com.alario.ct.producer.io;

import com.alario.ct.common.bean.Data;
import com.alario.ct.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本地文件的数据输入
 * @author alario
 */
public class LocalFileDataIn implements DataIn {
    private BufferedReader reader = null;
    public LocalFileDataIn(String path) {
        setPath(path);
    }

    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object read() throws IOException {
        return null;
    }
    //读取数据返回封装集合
    public <T extends Data> List<T> read(Class<T> type) throws IOException {

        List<T> ts = new ArrayList<T>();

        try {
            //从数据文件读取所有数据
            String line;
            while((line=reader.readLine())!=null){
                // 转换为指定类型对象封装成结合返回
                T t = type.newInstance();
                t.setValue(line);
                ts.add(t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return ts;
    }

    public void close() throws IOException {
        if (reader !=null){
            reader.close();
        }
    }
}
