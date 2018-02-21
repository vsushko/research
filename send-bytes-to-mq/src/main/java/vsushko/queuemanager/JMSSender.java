package vsushko.queuemanager;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class JMSSender {

    private JmsTemplate jmsTemplate;

    public void sendMessage(final byte[] mess) {

        System.out.println("Sending message...");

        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                BytesMessage byteMess = session.createBytesMessage();
                byteMess.writeBytes(mess);
                return byteMess;
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Required
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}