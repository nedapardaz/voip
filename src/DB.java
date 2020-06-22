import java.sql.*;

public class DB {
    public ResultSet Select(String Query, String DBMSType){
        if (DBMSType.equals("MySQL")){
        String dbURL = "jdbc:mysql://localhost:3306/asterisk";
        String username = "root";
        String password = "123456";
        String SResult ="-1";
        ResultSet resultSet=null;
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            PreparedStatement statement = conn.prepareStatement(Query);
            resultSet = statement.executeQuery();

            statement.close();
            conn.close();
            statement=null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;

        }
        else
        {
            ConnectionString connectionString = new ConnectionString();
            ResultSet resultSet = connectionString.SelectToDB(Query);
            return resultSet;
        }
    }
    public String InsertDataToDb(String Query){
        String dbURL = "jdbc:mysql://localhost:3306/asterisk";
        String username = "root";
        String password = "123456";
        String SResult ="-1";
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            PreparedStatement statement = conn.prepareStatement(Query);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                SResult="insert is OK";
                System.out.println("insert is OK");
            }
            statement.close();
            conn.close();
            statement=null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return SResult;
    }
}
