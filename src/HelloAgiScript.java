
import org.asteriskjava.fastagi.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//export JAVA_HOME=/usr/java/jre1.8.0_65
//export PATH=$JAVA_HOME/bin:$PATH
//GRANT ALL PRIVILEGES ON  asterisk.* TO 'root';
//sudo rpm -ivh java-1.8.0-openjdk-1.8.0.171-8.b10.el6_9.src.rpm
//java -classpath asterisk-java.jar:mysql-connector-java-5.1.9.jar:. org.asteriskjava.fastagi.DefaultAgiServer
public class HelloAgiScript extends BaseAgiScript
{
    public void service(AgiRequest request, AgiChannel channel)
    {
        IvrConfigurations ivrConfigurations = new IvrConfigurations();
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");
            String VoiceUrl = prop.getProperty("ivr.VoiceUrl");
            System.out.println(user+" "+url+" "+password+" "+VoiceUrl);
            ivrConfigurations.setDbURL(url);
            ivrConfigurations.setUsername(user);
            ivrConfigurations.setPassword(password);
            ivrConfigurations.setVoiceUrl(VoiceUrl);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        IvrCore ivrCore = new IvrCore();
        try {
            ivrCore.IVR_Core(request,channel,ivrConfigurations);
            channel.hangup();
        } catch (AgiException e) {
            System.out.println("not Hangup ->  ");
        }


    }
}