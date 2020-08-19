package Doctors;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorControllerSwitcher implements Initializable {

    public void initialize(URL url, ResourceBundle rb){
    }

    public void loadPatientRegistration(javafx.event.ActionEvent event) {
        try{
            Stage doctorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Doctors/PatientRegistration.fxml").openStream());

            DoctorController doctorController = (DoctorController)loader.getController();

            Scene scene2 = new Scene(root);
            doctorStage.setScene(scene2);
            doctorStage.setTitle("Patient Registration Dashboard");
            doctorStage.setResizable(false);
            doctorStage.show();
        }
        catch (IOException exes){
            exes.printStackTrace();
        }
    }
}
