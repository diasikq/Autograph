package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void connect(PackageData bd) {
        try {
            Socket socket = new Socket("127.0.0.1", 3306);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

           if(bd.getOperationType().equals("Add")){
               outputStream.writeObject(bd);
           }

           else if(bd.getOperationType().equals("List")){
               outputStream.writeObject(bd);
               PackageData infoFromServer = (PackageData)inputStream.readObject();
               ArrayList<User> arrayListFromServer = infoFromServer.getUsers();
               String sss = "";


               for (int i = 0; i < arrayListFromServer.size(); i++) {
                   sss += arrayListFromServer.get(i) + "\n";

               }
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

