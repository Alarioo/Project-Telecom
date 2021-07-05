package com.alario.ct.producer.bean;

import com.alario.ct.common.bean.DataIn;
import com.alario.ct.common.bean.DataOut;
import com.alario.ct.common.bean.Producer;

import java.io.IOException;
import java.util.List;

/**
 * 本地文件生产者
 * @author alario
 */
public class LocalFileProducer implements Producer {
    private DataIn in;
    private DataOut out;
    private volatile boolean flag;   //volatile是Java提供的一种轻量级的同步机制, volatile可以保证线程可见性且提供了一定的有序性，但是无法保证原子性 https://blog.csdn.net/u012723673/article/details/80682208

    public void setIn(DataIn in) {
        this.in=in;
    }

    public void setOut(DataOut out) {
        this.out=out;
    }

    public void produce() {
        flag=true;
        try {
            //读取通讯录
            while(flag) {
                //从通讯录找两个号码(主叫，被叫)
                List<Contact> contacts= in.read(Contact.class);
                for (Contact contact : contacts) {
                    System.out.println(contact);
                }
                flag=false;
                //随机生成通话时间

                //随机生成通话时长

                //生成通话记录

                //将通话记录写道数据文件中
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void close() throws IOException{
        if (in != null){
            in.close();
        }
        if (out != null){
            out.close();
        }
    }

}
