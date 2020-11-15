import com.wzx.message.CommunicationMessage;
import com.wzx.objectinfo.annotation.AppInfo;
import com.wzx.objectinfo.annotation.ActParam;
import com.wzx.objectinfo.annotation.ObjAction;
import com.wzx.objectinfo.annotation.ObjInfo;
import com.wzx.message.generator.MessageGenerator;

@AppInfo("PRODUCT")
@ObjInfo(name="productController")
public interface TestMessageGenerator  extends MessageGenerator {
    @ObjAction("queryProductByCodeAndName")
    public CommunicationMessage queryProduct(@ActParam("codeForProduct") String code, @ActParam("nameForProduct") String name);
}
