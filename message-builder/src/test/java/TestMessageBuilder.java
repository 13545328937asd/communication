import com.wzx.messagebuilder.annotation.ApplicationInfo;
import com.wzx.messagebuilder.annotation.ObjectInfo;
import com.wzx.messagebuilder.message.builder.interfaces.SmartMessageBuilder;
import com.wzx.messagebuilder.message.CommunicationMessage;
import org.springframework.web.bind.annotation.RequestParam;
@ObjectInfo(name="test",application = @ApplicationInfo(appName = "product"))
public interface TestMessageBuilder  extends SmartMessageBuilder {
    CommunicationMessage test(@RequestParam String str1, @RequestParam String str2);
}
