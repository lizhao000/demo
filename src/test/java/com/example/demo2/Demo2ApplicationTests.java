package com.example.demo2;

import com.example.Rabbitmq.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void hello() throws Exception {
        for (int i=0;i<9;i++){
            msgProducer.send();
        }
    }
//    短信发送
//@Test
//public void testSendMessage() {
//    //SendMessageUtil.send("SMS账户","接口秘钥","目标号码","发送内容");
//    Integer resultCode = SendMessageUtil.send("lizhao", "d41d8cd98f00b204e980", "13997523871", "登录验证码:" + getRandomCode(6));
//    System.out.println(SendMessageUtil.getMessage(resultCode));
//}
}
