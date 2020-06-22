import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class IvrCore  extends  HelloAgiScript{


    public void IVR_Core(AgiRequest request, AgiChannel channel , IvrConfigurations ivrConfigurations) throws AgiException {

        InitializeIVR initializeIVR = new InitializeIVR();

        System.out.println(ivrConfigurations.getPassword());
        System.out.println(ivrConfigurations.getDbURL());
        Utils utils= new Utils();

        String Choice="";
        answer();
        System.out.println("All Thread is Actie: "+Thread.activeCount());

        try {
            channel.setAutoHangup(20);
            Choice = utils.GetStringFormASK(ivrConfigurations.getVoiceUrl() + "enterPoll", 3).trim();
            String Query ="\tINSERT INTO MyLog ( CallerID, Discription,Choice,CreateDateTime,CallerName )\n" +
                    "VALUES\n" +
                    "\t( '"+request.getCallerIdNumber()+"', '"+request.getDnid()+"','"+Choice+"',now(),'"+Thread.currentThread().getId()+"')";
            DB db = new DB();
            db.InsertDataToDb(Query);
            System.out.println(Choice);


            utils.PlayFile("/etc/VOIP/Wave/" +"thanks");
        } catch (IOException e) {
            System.out.println("Not Polling Rate");
        }






    }
}
