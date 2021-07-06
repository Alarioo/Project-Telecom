package com.alario.ct.producer.io;

import com.alario.ct.common.bean.DataOut;
import com.alario.ct.producer.bean.Contact;

import java.io.*;

/**
 * 本地文件的数据输出
 * @author alario
 */
public class LocalFileDataOut implements DataOut {
    PrintWriter writer; //与BufferedWriter差别 https://blog.csdn.net/qq_38977097/article/details/80967896
    public LocalFileDataOut(String path) {
        setPath(path);
    }

    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(Object data) throws Exception {
        write(data.toString());
    }

    public void write (String data) throws Exception {
        writer.println(data);  // PrintWriter的print、println方法可以接受任意类型的参数，而BufferedWriter的write方法只能接受字符、字符数组和字符串
        writer.flush();
    }

    public void close() throws IOException {
        if (writer !=null){
            writer.close();
        }
    }
}
