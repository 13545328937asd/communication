import com.wzx.networking.NettyCommunnicationServer;
import com.wzx.networking.ObjectCommunicationServer;
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
