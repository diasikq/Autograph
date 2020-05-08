package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField phone_num;

    @FXML
    private TextField num_persons;

    @FXML
    private TextField time;

    @FXML
    private TextField date;

    @FXML
    private Button SignUpBooking;

    @FXML
    void initialize() {

    }
}
