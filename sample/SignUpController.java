package sample;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.sql.DriverManager.getConnection;

public class SignUpController extends Confix{

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField SignUpLogin;

        @FXML
        private PasswordField SignUpPass;

        @FXML
        private Button SignUpEnter;

        @FXML
        private TextField SignUpName;

        @FXML
        private TextField SignUpNumber;

        @FXML
        private TextField SignUpSurname;

        @FXML
        private TextField SignUpComLogin;

        @FXML
        private PasswordField SignUpComPass;

        @FXML
        private Button SignUpRegister;

        @FXML
        void initialize() {
            SignUpEnter.setOnAction(event -> {
                String logintext = SignUpLogin.getText().trim();
                String loginPassword = SignUpPass.getText().trim();

                if(!logintext.equals("") && loginPassword.equals(""))
                    loginUser(logintext, loginPassword);
                else
                    System.out.println("Login and password is empty");
            });


            SignUpRegister.setOnAction(event -> {

                signUpNewUser();

            });
        }


        private void signUpNewUser() {
            /* Connection dbConnection;
             Class.forName("com.mysql.jdbc.Driver");
             String connectionString = "jdbc:mysql://" + dbHost + ":"
                     + dbPort + "/" + dbName;
             Class.forName("com.mysql.jdbc.Driver");

             dbConnection = getConnection(connectionString
                     , dbUser, dbPass);
             */
            String name = SignUpName.getText();
            String surname = SignUpSurname.getText();
            String phonenumber = SignUpNumber.getText();
            String username = SignUpComLogin.getText();
            String paswword = SignUpComPass.getText();

            User user = new User(name,surname,phonenumber,username,paswword);
            //PackageData bd = new PackageData("Add",user);
            //Main.connect(bd);


            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.signUpUser(user);
        }
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql:// jdbc:mysql://localhost:3306/autograph?useUnicode=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager. getConnection("jdbc:mysql://localhost:3306/autograph?useUnicode=true&serverTimezone=UTC",
                "root","root");
        return dbConnection;
    }




        private void loginUser(String logintext, String loginPassword) {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            User user = new User();
           user.setUsername(logintext);
           user.setPaswword(loginPassword);
        ResultSet resultSet = databaseHandler.getUser(user);

        int phone =0;
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            phone++;
        }
        if (phone >= 1) {
            SignUpRegister.setOnAction(event -> {
                SignUpRegister.getScene().getWindow().hide();
                SignUpRegister.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });
        }
            else{
                Shake userLoginAnim = new Shake(SignUpComLogin);
            Shake userPassAnim = new Shake(SignUpComPass);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
            }
        }
}




