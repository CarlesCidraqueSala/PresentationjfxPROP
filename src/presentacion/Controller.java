package presentacion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller {
    @FXML
    private Label lblStatus;

    @FXML
    private Label lblProva;

    @FXML
    private Label lblRanking;

    @FXML
    private ChoiceBox<String> cbProblema;

    @FXML
    private ChoiceBox<String> cbProblemaPartida;

    @FXML
    private ChoiceBox<String> cbRival1;

    @FXML
    private ChoiceBox<String> cbRival2;

    @FXML
    private ListView<String> Clasificacion;

    private boolean global = false; //quam apretem RadioButton Global (RBglobal) aquest valor cambiarà

    private boolean cproblema = false; //quam apretem RadioButton Problema (RBproblema) aquest valor cambiarà

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

    //DEFINICION DE TODOS LOS STAGES
    private Stage LoginStage = new Stage();
    private Stage SignupStage = new Stage();
    private Stage Signup2Stage = new Stage();
    private Stage JugarStage = new Stage();
    private Stage GestionarProblemaStage = new Stage();
    private Stage EditarPerfilStage = new Stage();
    private Stage ConsultarRankingsStage = new Stage();
    private Stage JugarPartidaStage = new Stage();

    public void Login() throws Exception{
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) { //comprovacio user i pssw
            lblStatus.setText("Login Succes");
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            LoginStage.setScene(new Scene(root, 400, 400));
            LoginStage.setTitle("Ajedrez PROP");
            LoginStage.show();
        }
        else {
            lblStatus.setText("Login Failed");
        }
    }

    public void Signup() throws Exception{ //metode associat al "click" del boto Sign Up de la pantalla inicial
            Parent root = FXMLLoader.load(getClass().getResource("Registrar.fxml"));
            SignupStage.setScene(new Scene(root, 400, 400));
            SignupStage.setTitle("Ajedrez PROP (Sign Up)");
            SignupStage.show();
        }

    public void Signup2() throws Exception{ //metode associat al "click" del boto Sign Up en la pantalla de Sign Up
        if(!txtUsernameR.getText().equals("user") && (txtPasswordR1.getText().equals(txtPasswordR2.getText()) )) {
            if(txtNom.getText().isEmpty() || txtPasswordR1.getText().isEmpty() || txtUsernameR.getText().isEmpty()){
                lblStatusR.setText("Cal omplir tots els camps");
            }
            else {
                lblStatusR.setText("Sign up Succes");

                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Signup2Stage.setScene(new Scene(root, 400, 400));
                Signup2Stage.setTitle("Ajedrez PROP");
                Signup2Stage.show();
            }

        }
        else if (txtUsernameR.getText().equals("user")) {//dir que el username user ja esta en us
            lblStatusR.setText("Aquest Username ja està en us");
        }
        else { //dir que la contrasenya ha de coincidir
            lblStatusR.setText("la contrasenya ha de coincidir");
        }
    }

    public void inicializarChoiceBoxPartida() throws Exception {
        ObservableList<String> tipusjugadors = FXCollections.observableArrayList(
                "Humano", "Máquina 1", "Máquina 2");
        cbRival1.setItems(tipusjugadors);
        ObservableList<String> tipusjugadors2 = FXCollections.observableArrayList(
                "Humano", "Máquina 1", "Máquina 2");
        cbRival2.setItems(tipusjugadors2);
        ObservableList<String> problemasAjugar = FXCollections.observableArrayList(
                "P1", "P2", "P3", "P4", "P5"); //els agafarem de domini ( això només d'exemple
        cbProblemaPartida.setItems(problemasAjugar);
    }

    public void Jugar() throws Exception{ //ESCOLLIR CONTRINCANTS (totes les variables posibles)
        //ESCOLLIM CONTRINCANTS I PROBLEMA MITJANÇANT dos ChoiceBox
        Parent root = FXMLLoader.load(getClass().getResource("Jugar.fxml"));
        JugarStage.setScene(new Scene(root, 300, 300));
        JugarStage.setTitle("Ajedrez PROP (Jugar)");
        JugarStage.show();

        /*cbRival1.getItems().addAll("Humano","Máquina1","Máquina2");
        cbRival2.getItems().addAll("Humano","Máquina1","Máquina2");
        cbProblemaPartida.getItems().addAll("P1","P2","P3");*/
        /*ObservableList<String> tipusjugadors = FXCollections.observableArrayList(
                "Humano", "Máquina 1", "Máquina 2");
        cbRival1.setItems(tipusjugadors);
        ObservableList<String> tipusjugadors2 = FXCollections.observableArrayList(
                "Humano", "Máquina 1", "Máquina 2");
        cbRival2.setItems(tipusjugadors2);
        ObservableList<String> problemasAjugar = FXCollections.observableArrayList(
                "P1", "P2", "P3","P4","P5"); //els agafarem de domini ( això només d'exemple
        cbProblemaPartida.setItems(problemasAjugar);*/
            //UN COP ESCOLLITS ELS DOS RIVALS I UN PROBLEMA, CLICKEM BOTÓ "COMENÇAR PARTIDA" i
            // ens reconduirà cap a una nova pantalla on ja hi haurà el tablero i la librerias chess es
            //on entrarà en joc, per fer moviments, i mostrar-los,...
    }

    public void GestionarProblema() throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("GestionarProblema.fxml"));
            GestionarProblemaStage.setScene(new Scene(root, 400, 400));
            GestionarProblemaStage.setTitle("Ajedrez PROP (Gestió Problema)");
            GestionarProblemaStage.show();
    }

    public void EditarPerfil() throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("EditarPerfil.fxml"));
            EditarPerfilStage.setScene(new Scene(root, 400, 400));
            EditarPerfilStage.setTitle("Ajedrez PROP");
            EditarPerfilStage.show();
    }

    public void ConsultarRankings() throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("ConsultarRankings.fxml"));
            ConsultarRankingsStage.setScene(new Scene(root, 300, 450));
            ConsultarRankingsStage.setTitle("Ajedrez PROP");
            ConsultarRankingsStage.show();
        }

    public void ShowGlobalRanking() throws Exception{
        global = !global;
        //fariem remove del choiceBox per tal de que quan tenim Global marcat no es mostresin els problemes
        //Ho fariem amb un for dels problemes obtinguts desde domini
        cbProblema.getItems().removeAll("P1","P2","P3","P4","P5");
    }

    public void ShowProblemaRanking() throws Exception{
        cproblema = !cproblema;
        ObservableList<String> dataproblemes = FXCollections.observableArrayList( //en comptes de fer aquesta llista, es recollira
                //la llista de domini, i amb un for anirem omplint "dataproblemes",
                // que posteriorment farem cbProblema.getItems().add(dataproblemes[i]); amb un for que anirà recorrent dataproblemes
                "P1", "P2", "P3", "P4", "P5");
        //cbProblema.setItems(dataproblemes);
        /*cbProblema.getItems().add("P1");
        cbProblema.getItems().add("P2");
        cbProblema.getItems().add("P3");
        cbProblema.getItems().add("P4");
        cbProblema.getItems().add("P5");*/
        cbProblema.setItems(dataproblemes);
    }

    public void ShowRanking() throws Exception{
        if(global && cproblema) {
            //No es pot tindre els dos RadioButton marcats
            lblRanking.setText("Tria l'opció Global o Problema");
        }
        else if(!global && !cproblema) {
            //No es pot tindre els dos RadioButton no marcats i mostrar una clasifiacio
            lblRanking.setText("Tria l'opció Global o Problema");
        }
        else if(global){
            lblRanking.setText("Ranking Global");
            ObservableList<String> data = FXCollections.observableArrayList( //en comptes de fer aquesta llista, es recollira
                    //la llista de domini, i amb un for anirem omplint "data", que posteriorment farem Clasificacion.setItems(data)
                    "Java", "carles", "more", "Sergi", "edu",
                    "Java", "carles", "more", "Sergi", "edu",
                    "Java", "carles", "more", "Sergi", "edu"
            );
            Clasificacion.setItems(data);
        }
        else{
            lblRanking.setText("Ranking Problema");
            //Primer llegirem el problema escollit del ChoiceBox, i amb aquell problema demanem a domini
            //que ens doni la seva clasificacio

            ObservableList<String> data = FXCollections.observableArrayList( //en comptes de fer aquesta llista, es recollira
                    //la llista de domini, i amb un for anirem omplint "data", que posteriorment farem Clasificacion.setItems(data)
                    "JavaP", "carlesP", "moreP", "SergiP", "eduP",
                    "JavaP", "carlesP", "moreP", "SergiP", "eduP",
                    "JavaP", "carlesP", "moreP", "SergiP", "eduP"
            );
            Clasificacion.setItems(data);
        }
    }

    public void JugarPartida() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ConsultarRankings.fxml"));
        JugarPartidaStage.setScene(new Scene(root, 300, 450));
        JugarPartidaStage.setTitle("Ajedrez PROP");
        JugarPartidaStage.show();
    }

    public void DragProblema2() throws Exception{ //metode associat al "click" del boto Sign Up de la pantalla inicial
        ObservableList<String> problemasAjugar = FXCollections.observableArrayList(
                "P1", "P2", "P3","P4","P5"); //els agafarem de domini ( això només d'exemple
        cbProblemaPartida.setItems(problemasAjugar);
        lblProva.setText("Prova Succes");
    }
}
