
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionString {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String cnsConnectionString(){
            String Sresult = null;
        try{

            String PassWord = "H@12345";
            String  UserName = "sa";
            String  Location = "192.168.200.127\\SQL_HKH_2014";
            String DataBaseName = "PollingReports";
             Sresult ="jdbc:sqlserver://" + Location + ";" +
                    "databaseName=" + DataBaseName + ";user=" + UserName + ";password=" + PassWord + "";
            return  Sresult;


        }
        catch (Exception e) {
            System.out.println(Sresult);
            System.out.println(e);
            return "";
        }
    }
    public ConnectionString() {
        ConnectSqlServer();
    }

   public Boolean ConnectSqlServer(){
       try {

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection =  DriverManager.getConnection(cnsConnectionString());
           connection.setAutoCommit(true);
           return true;
       }
       catch (Exception e) {

           System.out.println("No Connect -> "+e.getMessage());
           return false;

       }

   }
   public void DisconnectSqlServer(){

       try {
           connection.close();
           preparedStatement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   public ResultSet SelectToDB(String Query){
       try {
           System.out.println(Query);
           preparedStatement = connection.prepareStatement(Query);
           return preparedStatement.executeQuery();
       } catch (SQLException e) {
           System.out.println("Errors SelectToDB:"+Query);
           e.printStackTrace();
           return null;
       }
   }



   public String InsertToDB(String Query){
       String Result;
       try {
           System.out.println(Query);
           preparedStatement = connection.prepareStatement(Query);
           preparedStatement.execute();

           Result = "True";

       } catch (SQLException e) {
           System.out.println("Errors InsertToDB:"+Query);
           e.printStackTrace();
           Result = "False";
       }

       return  Result;


   }

    public String UpdateStatements(PreparedStatement preparedStatement,String Query) {

        try {

            PreparedStatement QPreapertStatement = connection.prepareStatement(Query);
            QPreapertStatement=preparedStatement;
            preparedStatement = connection.prepareStatement(Query);
            return String.valueOf(preparedStatement.executeUpdate());



        } catch (SQLException e) {
            System.out.println("Errors UpdateToDB:"+Query);
            e.printStackTrace();
            return "0";

        }
    }
   public String UpdateToDB(String Query){

       try {
           System.out.println(Query);

           preparedStatement = connection.prepareStatement(Query);
          return String.valueOf(preparedStatement.executeUpdate());



       } catch (SQLException e) {
           System.out.println("Errors UpdateToDB:"+Query);
           e.printStackTrace();
           return "0";

       }


   }

}
