import org.asteriskjava.fastagi.AgiException;

import java.io.IOException;

public class Utils extends HelloAgiScript{
    public  void    PlayFile(String S) throws AgiException {
        streamFile(S);
    }
    public  String  GetStringFormASK(String File,int timeOUT) throws AgiException, IOException {
        char digit= '@';
        String Result="";
        digit=streamFile(File, "0123456789*#");
        if (String.valueOf(digit).length()!=1){
            digit=streamFile(Integer.toString(timeOUT), "0123456789*#");
        }
        Result=Result+String.valueOf(digit);
        Result=Result.trim();
        return  Result;
    }
}
