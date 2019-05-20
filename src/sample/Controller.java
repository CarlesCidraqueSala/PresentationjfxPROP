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
    private TextField txtNom;

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
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) { //comprovacio user i pssw
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

    public void Signup() throws Exception{ //metode associat al "click" del boto Sign Up de la pantalla inicial
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Registrar.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP (Sign Up)");
            primaryStage.show();
        }

    public void Signup2() throws Exception{ //metode associat al "click" del boto Sign Up en la pantalla de Sign Up
        if(!txtUsernameR.getText().equals("user") && (txtPasswordR1.getText().equals(txtPasswordR2.getText()) )) {
            if(txtNom.getText().isEmpty() || txtPasswordR1.getText().isEmpty() || txtUsernameR.getText().isEmpty()){
                lblStatusR.setText("Cal omplir tots els camps");
            }
            else {
                lblStatusR.setText("Sign up Succes");
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                primaryStage.setScene(new Scene(root, 400, 400));
                primaryStage.setTitle("Ajedrez PROP");
                primaryStage.show();
            }

        }
        else if (txtUsernameR.getText().equals("user")) {//dir que el username user ja esta en us
            lblStatusR.setText("Aquest Username ja està en us");
        }
        else { //dir que la contrasenya ha de coincidir
            lblStatusR.setText("la contrasenya ha de coincidir");
        }
    }

    public void Jugar() throws Exception{
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Jugar.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP (Jugar)");
            primaryStage.show();
    }

    public void GestionarProblema() throws Exception{
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("GestionarProblema.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP (Gestió Problema)");
            primaryStage.show();
    }

    public void EditarPerfil() throws Exception{
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("EditarPerfil.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP");
            primaryStage.show();
    }

    public void ConsultarRankings() throws Exception{
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ConsultarRankings.fxml"));
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.setTitle("Ajedrez PROP");
            primaryStage.show();
        }
}
