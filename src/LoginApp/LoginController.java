package LoginApp;

import Doctors.DoctorControllerSwitcher;
import Staff.StaffController;
import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label databaseStatus;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<Option> comboBox;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginStatus;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        if(this.loginModel.isDatabaseConnected()){
            this.databaseStatus.setText("Connected To The Database");
        }
        else{
            this.databaseStatus.setText("Not Connected To Database");
        }
        this.comboBox.setItems(FXCollections.observableArrayList(Option.values()));
    }

    @FXML
    public void Login (ActionEvent event){
        try{
            if (this.loginModel.isLogin(this.username.getText(),this.password.getText(),this.comboBox.getValue().toString()))
            {
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();

                switch ((this.comboBox.getValue()).toString()) {
                    case "Admin":
                        AdminLogin();
                        break;
                    case "Staff":
                        StaffLogin();
                        break;
                    case "Doctor":
                        DoctorsLogin();
                        break;
                }
            }
            else{
                this.loginStatus.setText("Wrong Credentials");
            }
        }
        catch(Exception localException){
        }
    }
    public void AdminLogin(){

        try{
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminRoot = (Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());

            AdminController adminController = (AdminController)adminLoader.getController();

            Scene scene = new Scene(adminRoot);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(false);
            adminStage.show();
        }
        catch (Exception exe){
            System.out.println("Error "+exe  );
        }
    }

    public void StaffLogin(){

        try{
            Stage staffStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Staff/Staff.fxml").openStream());

            StaffController staffController = (StaffController)loader.getController();

            Scene scene1 = new Scene(root);
            staffStage.setScene(scene1);
            staffStage.setTitle("Staff's Dashboard");
            staffStage.setResizable(false);
            staffStage.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public void DoctorsLogin(){

        try{
            Stage doctorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Doctors/Doctors.fxml").openStream());

            DoctorControllerSwitcher doctorControllerSwitcher = (DoctorControllerSwitcher) loader.getController();

            Scene scene2 = new Scene(root);
            doctorStage.setScene(scene2);
            doctorStage.setTitle("Doctor's Dashboard");
            doctorStage.setResizable(false);
            doctorStage.show();
        }
        catch (IOException exes){
            exes.printStackTrace();
        }

    }
}
