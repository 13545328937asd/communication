import com.wzx.message.CommunicationMessage;
import com.wzx.message.annotation.ApplicationInfo;
import com.wzx.message.annotation.MessageParam;
import com.wzx.message.annotation.ObjectAction;
import com.wzx.message.annotation.ObjectInfo;
import com.wzx.message.generator.MessageGenerator;

@ApplicationInfo("PRODUCT")
@ObjectInfo(name="productController")
public interface TestMessageGenerator  extends MessageGenerator {
    @ObjectAction("queryProductByCodeAndName")
    public CommunicationMessage queryProduct(@MessageParam("codeForProduct") String code, @MessageParam("nameForProduct") String name);
}
