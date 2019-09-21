import com.wzx.messagebuilder.networking.NettyCommunnicationServer;
import com.wzx.messagebuilder.networking.ObjectCommunicationServer;
import org.junit.Test;

/*@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)*/
public class CommunicationServerTest {
    @Test
    public void test() throws InterruptedException {
        ObjectCommunicationServer server=new NettyCommunnicationServer(0621);
        server.startServer();
    }
}
