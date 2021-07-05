package com.alario.ct.producer;

import com.alario.ct.producer.bean.LocalFileProducer;
import com.alario.ct.producer.io.LocalFileDataIn;
import com.alario.ct.producer.io.LocalFileDataOut;

/**
 * 启动对象
 * @author alario
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        //构建生产对象
        LocalFileProducer producer = new LocalFileProducer();
        producer.setIn(new LocalFileDataIn("F:\\BigData\\Projects\\Telecom\\log\\contact.log"));
        producer.setOut(new LocalFileDataOut("F:\\BigData\\Projects\\Telecom\\log\\call.log"));
        //生产数据
        producer.produce();
        //关闭生产对象
        producer.close();
    }
}
