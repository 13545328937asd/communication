import com.fasterxml.jackson.core.JsonProcessingException;
import com.wzx.messagebuilder.message.CommunicationMessage;
import com.wzx.messagebuilder.message.CommunicationMessageBuilder;
import com.wzx.messagebuilder.message.MessageType;
import com.wzx.messagebuilder.serialize.FastJsonUtil;
import com.wzx.messagebuilder.service.impl.TestCommunicationServiceImpl;
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

        /*ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.canSerialize(CommunicationMessage.class));
        String jsonStr=objectMapper.writeValueAsString(message);
        System.out.println(jsonStr);*/
        /*ResponseMessage responseMessage=new ResponseMessage("123",new String("123"));
        String json=FastJsonUtil.toJson(responseMessage);
        System.out.println(json);
        ResponseMessage message = FastJsonUtil.toObject(json, ResponseMessage.class);
        String response = (String) message.getResponse();*/
       /* ResponseMessage responseMessage=new ResponseMessage("123",new Person("WZX",23));
        String json=FastJsonUtil.toJson(responseMessage);
        String personjson=FastJsonUtil.toJson(new Person("WZX",23));

        System.out.println(json);
        System.out.println(personjson);

        ResponseMessage message = FastJsonUtil.toObject(json, ResponseMessage.class);
        JSONObject response = (JSONObject) message.getResponse();
        Person person = response.toJavaObject(Person.class);
        System.out.println(person);*/


    }
}
