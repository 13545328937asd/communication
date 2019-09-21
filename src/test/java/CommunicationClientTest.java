import com.wzx.messagebuilder.App;
import com.wzx.messagebuilder.gateway.MessageGateWay;
import com.wzx.messagebuilder.message.CommunicationMessage;
import com.wzx.messagebuilder.message.CommunicationMessageBuilder;
import com.wzx.messagebuilder.message.MessageType;
import com.wzx.messagebuilder.networking.NettyCommunicationClient;
import com.wzx.messagebuilder.networking.ObjectCommunicationClient;
import com.wzx.messagebuilder.service.impl.TestCommunicationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class) // 等价于使用 @RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class})
public class CommunicationClientTest {
    @Resource
    MessageGateWay messageGateWay;
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
                .buildMessageDetail("test",new Object[]{"wzx"}).buildToAppName("order").getCm();
        /*try {
            client.sendMessage(message);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/

        messageGateWay.sendMessage(message);

    }
}
