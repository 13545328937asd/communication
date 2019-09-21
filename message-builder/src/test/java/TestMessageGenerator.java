import com.wzx.messagebuilder.annotation.ApplicationInfo;
import com.wzx.messagebuilder.annotation.MessageParam;
import com.wzx.messagebuilder.annotation.ObjectAction;
import com.wzx.messagebuilder.annotation.ObjectInfo;
import com.wzx.messagebuilder.message.CommunicationMessage;
import com.wzx.messagebuilder.message.generator.MessageGenerator;
@ApplicationInfo("PRODUCT")
@ObjectInfo(name="productController")
public interface TestMessageGenerator  extends MessageGenerator {
    @ObjectAction("queryProductByCodeAndName")
    public CommunicationMessage queryProduct(@MessageParam("codeForProduct") String code, @MessageParam("nameForProduct") String name);
}
