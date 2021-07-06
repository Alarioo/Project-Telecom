package com.alario.ct.producer.bean;

import com.alario.ct.common.bean.DataIn;
import com.alario.ct.common.bean.DataOut;
import com.alario.ct.common.bean.Producer;
import com.alario.ct.common.util.DateUtil;
import com.alario.ct.common.util.NumberUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 本地文件生产者
 * @author alario
 */
public class LocalFileProducer implements Producer {
    private DataIn in;
    private DataOut out;
    private volatile boolean flag=true;   //volatile是Java提供的一种轻量级的同步机制, volatile可以保证线程可见性且提供了一定的有序性，但是无法保证原子性 https://blog.csdn.net/u012723673/article/details/80682208

    public void setIn(DataIn in) { this.in=in; }

    public void setOut(DataOut out) {
        this.out=out;
    }

    public void produce() {

        try {
            //读取通讯录
            List<Contact> contacts= in.read(Contact.class);
              while(flag) {
                //从通讯录找两个号码(主叫，被叫)
                //Math.random();  数据类型double Ramdon random = new Random(Int i) i 为种子 种子相同 随机数
                int call1index = new Random().nextInt(contacts.size());
                int call2index;
                while (true){
                    call2index = new Random().nextInt(contacts.size());
                    if(call1index != call2index){
                        break;
                    }
                }
                Contact call1=contacts.get(call1index);
                Contact call2=contacts.get(call2index);

              //随机生成通话时间
                String startDate = "20200101000000";
                String endDate = "20210101000000";

                long startTime = DateUtil.parse(startDate,"yyyyMMddHHmmss").getTime();
                long endTime = DateUtil.parse(endDate,"yyyyMMddHHmmss").getTime();
                long callTime= startTime - (long)((endTime - startTime) * Math.random());

                String callTimeString = DateUtil.format(new Date(callTime),"yyyyMMddHHmmss");

                //随机生成通话时长  返回固定格式 0120 24000 0013 0007
                String duration =NumberUtil.format(new Random().nextInt(3000),4);

                //生成通话记录
                CallLog log= new CallLog(call1.getTel(),call2.getTel(),callTimeString,duration);

                //将通话记录写道数据文件中
                out.write(log.toString());
                System.out.println(log.toString());
                Thread.sleep(500); //每秒生成两条
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
