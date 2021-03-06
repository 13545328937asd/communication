import com.wzx.message.CommunicationMessage;
import com.wzx.message.generator.MessageGeneratorProxy;
import com.wzx.message.generator.MessageGeneratorProxyFactory;
import org.junit.Test;

public class GeneratorTest {
    @Test
    public void test(){
        MessageGeneratorProxyFactory<TestMessageGenerator> proxyFactory = new MessageGeneratorProxyFactory(TestMessageGenerator.class);
        TestMessageGenerator proxy = proxyFactory.getProxy(new MessageGeneratorProxy(TestMessageGenerator.class));
        CommunicationMessage message = proxy.queryProduct("dhj", "打火机");
        System.out.println(message);
    }
}
