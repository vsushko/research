package vsushko.queuemanager;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;

public class MessageListener implements javax.jms.MessageListener {
    public void onMessage(Message message) {
        if (message instanceof BytesMessage) {
            try {
                byte[] byteMess = new byte[(int) ((BytesMessage) message).getBodyLength()];
                ((BytesMessage) message).readBytes(byteMess);
                String mess = new String(byteMess);
                System.out.println("Received message: " + mess);

            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException(
                    "Message must be of type ByteMessage");
        }
    }
}