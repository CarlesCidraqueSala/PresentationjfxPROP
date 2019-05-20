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
    private Label lblStatusR;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtUsernameR;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPasswordR1;

    @FXML
    private TextField txtPasswordR2;

    public void Login() throws Exception{
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Succes");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP");
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
            primaryStage.setTitle("Ajedrez PROP (Sign Up)");
            primaryStage.show();
        }

    public void Signup2() throws Exception{
        if(!txtUsernameR.getText().equals("user") && (txtPasswordR1.getText().equals(txtPasswordR2.getText()) )) {
        lblStatusR.setText("Sign up Succes");
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Ajedrez PROP");
        primaryStage.show();
        }
        else if (txtUsernameR.getText().equals("user")) {//dir que el username user ja esta en us
            lblStatusR.setText("Aquest Username ja està en us");
        }
        else { //dir que la contrasenya ha de coincidir
            lblStatusR.setText("la contrasenya ha de coincidir");
        }
    }
}
