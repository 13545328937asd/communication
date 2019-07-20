import com.wzx.App;
import com.wzx.networking.NettyCommunnicationServer;
import com.wzx.networking.ObjectCommunicationServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)*/
public class CommunicationServerTest {
    @Test
    public void test() throws InterruptedException {
        ObjectCommunicationServer server=new NettyCommunnicationServer(0621);
        server.startServer();
    }
}
