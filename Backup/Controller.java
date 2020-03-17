package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Button btnCancel;

    @FXML
    public void Cancel(ActionEvent event) {
    }

    @FXML
    public void login(ActionEvent event) {
        String username=txtUsername.getText().trim();
        String password=txtPassword.getText().trim();

        if ((username.equals("admin"))&&(password.equals("123"))){
            try {
                Parent rootNode = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene Dashboard = new Scene(rootNode);
                Stage DashboardScreen = new Stage();
                DashboardScreen.setTitle("Dashboard | Basic CRUD System");
                DashboardScreen.setScene(Dashboard);
                DashboardScreen.showAndWait();
            }
            catch (Exception ex){
                Alert message=new Alert(Alert.AlertType.ERROR,"Please check your file");
                message.showAndWait();
            }
        }else{
            Alert message=new Alert(Alert.AlertType.ERROR,"Incorrect Username or Password");
            message.showAndWait();
        }
    }

}
