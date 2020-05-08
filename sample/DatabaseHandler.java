package sample;
import java.sql.*;

public class DatabaseHandler extends Confix {
    Connection dbConnection;


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        /*
                String connectionString = "jdbc:mysql://"+ dbhost + ":"
                + dbport + "/" + dbname;
        Class.forName("com.mysql.jdbc.Driver");
         dbConnection = DriverManager.getConnection(connectionString
                , dbuser, dbpass);
        return dbConnection;

         */ Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/autograph?useUnicode=true&serverTimezone=UTC";
        dbConnection = DriverManager.getConnection(connectionString, "root",
                "root");
        return  dbConnection;
    }
   public void signUpUser(User user){
       try {
           String insert = "INSERT INTO users VALUES(?,?,?,?,?)";



           PreparedStatement prSt = getDbConnection().prepareStatement(insert);
           prSt.setString(1,user.getName());
           prSt.setString(2, user.getSurname());
           prSt.setString(3, user.getPhonenumber());
           prSt.setString(4, user.getUsername());
           prSt.setString(5, user.getPaswword());
           prSt.executeUpdate();
           prSt.close();
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
   public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM" + Cons.USER_TABLE + " WHERE " +
                Cons.USER_USERNAME + "=? AND" + Cons.USER_PASSWORD + "=?";

       try {
           PreparedStatement prSt = getDbConnection().prepareStatement(select);
           prSt.setString(1,user.getUsername());
           prSt.setString(2, user.getPaswword());
           resultSet= prSt.executeQuery();
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }
       return resultSet;
   }
}



