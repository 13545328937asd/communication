import org.junit.Test;

public class ExceptionTest {
    @Test
    public void test() throws Exception {
        Exception e=new RuntimeException("asd",new RuntimeException("asd"));
        throw e;
    }
}
