package vsushko.queuemanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MQJMSSender {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        JMSSender jmsSender = (JMSSender) context.getBean("jmsSender");
        jmsSender.sendMessage(new byte[]{'7', '5', 32, '6', '7', 'A', 'B', 'C', '!'});

        System.out.println("Message sent");
        MessageListener messageListener = null;
        messageListener = (MessageListener) context.getBean("messageListener");
//        messageListener.onMessage();
    }
}