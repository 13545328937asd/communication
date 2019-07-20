import com.wzx.message.CommunicationMessage;
import com.wzx.message.CommunicationMessageBuilder;
import com.wzx.message.MessageType;
import com.wzx.networking.NettyCommunicationClient;
import com.wzx.networking.ObjectCommunicationClient;
import com.wzx.service.impl.TestCommunicationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TransferQueue;

public class CommunicationClientTest {
    private ObjectCommunicationClient client;
    @Before
    public  void init() throws InterruptedException {
        client=new NettyCommunicationClient("127.0.0.1",621);
        client.startClient();
    }
    @Test
    public void testCommunication(){
        CommunicationMessage message= CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageType(MessageType.REQUEST)
                .buildMessageDetail("test",new Object[]{"wzx"}).getCm();
        try {
            client.sendMessage(message);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
