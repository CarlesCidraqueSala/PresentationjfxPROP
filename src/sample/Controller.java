package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    public void Login() throws Exception{
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Succes");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP (Log In / Sign Up)");
            primaryStage.show();
        }
        else {
            lblStatus.setText("Login Failed");
        }
    }

    public void Signup() throws Exception{
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Registrar.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP (Log In / Sign Up)");
            primaryStage.show();
        }
}