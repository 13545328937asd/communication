import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzx.message.CommunicationMessage;
import com.wzx.message.CommunicationMessageBuilder;
import com.wzx.message.MessageType;
import com.wzx.serialize.FastJsonUtil;
import com.wzx.service.impl.TestCommunicationServiceImpl;
import org.junit.Test;


public class SerializeTest {
    @Test
    public void testMessage() throws JsonProcessingException {
        CommunicationMessage message= CommunicationMessageBuilder.getInstance().buildObjInfo(this, TestCommunicationServiceImpl.class)
                .buildMessageType(MessageType.REQUEST)
                .buildMessageDetail("test",new Object[]{"wzx"}).getCm();
        message.getFutureAnswer().setResult("service");
        String toJson = FastJsonUtil.toJson(message);
        System.out.println(toJson);

        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.canSerialize(CommunicationMessage.class));
        String jsonStr=objectMapper.writeValueAsString(message);
        System.out.println(jsonStr);

    }
}
