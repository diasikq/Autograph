package sample;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AutSignButton;

    @FXML
    private Button NewsSignButton;

    @FXML
    private Button MenuSignButton;

    @FXML
    private Button BookingSignButton;

    @FXML
    private Button ABsignButton;



    @FXML
    void initialize() {
        AutSignButton.setOnAction(event -> { change(AutSignButton,"SignUp"); });

        ABsignButton.setOnAction(event -> { change(ABsignButton,"app");});

        NewsSignButton.setOnAction(event -> { change(NewsSignButton,"news");});

        BookingSignButton.setOnAction(event -> { change(BookingSignButton,"Booking");});

    }


    Socket socket = null;
    ObjectOutputStream output;{
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }


    public void change(Button button, String url) {
        button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/" + url + ".fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


}


