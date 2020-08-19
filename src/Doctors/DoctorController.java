package Doctors;

import Database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {

    //Tags for Patient Registration Page
    @FXML
    private javafx.scene.control.TextField patientNumberID;
    @FXML
    private javafx.scene.control.TextField patientFirstName;
    @FXML
    private javafx.scene.control.TextField patientLastName;
    @FXML
    private javafx.scene.control.TextField patientAge;
    @FXML
    private javafx.scene.control.TextField patientIllness;
    @FXML
    private TableView<PatientsData> patientRegistrationTable;
    @FXML
    private TableColumn<PatientsData, String> patientNumberRegistrationColumn;
    @FXML
    private TableColumn<PatientsData, String> patientFirstNameRegistrationColumn;
    @FXML
    private TableColumn<PatientsData, String> patientLastNameRegistrationColumn;
    @FXML
    private TableColumn<PatientsData, String> patientAgeColumn;
    @FXML
    private TableColumn<PatientsData, String> patientIllnessColumn;

    private DatabaseConnection db;
    private ObservableList<PatientsData> patientsData;

    private String sql = "SELECT * FROM Patients";


    public void initialize(URL url, ResourceBundle rb){
        this.db = new DatabaseConnection();
    }

    public void addPatientData(javafx.event.ActionEvent event) {
        String sqlInsert = "INSERT INTO Patients(PatientNumber,FirstName,LastName,Age,Illness) VALUES (?,?,?,?,?)";

        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.patientNumberID.getText());
            stmt.setString(2, this.patientFirstName.getText());
            stmt.setString(3, this.patientLastName.getText());
            stmt.setString(4, this.patientAge.getText());
            stmt.setString(5, this.patientIllness.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException E){
            E.printStackTrace();
        }
    }

    public void loadPatientData(javafx.event.ActionEvent event) {
        try{

            Connection conn = DatabaseConnection.getConnection();
            this.patientsData = FXCollections.observableArrayList();

            ResultSet rs3 = conn.createStatement().executeQuery(sql);
            while(rs3.next()){
                this.patientsData.add(new PatientsData(rs3.getString(1),
                        rs3.getString(2),
                        rs3.getString(3),
                        rs3.getString(4),
                        rs3.getString(5)));
            }

        }catch (SQLException E){
            System.err.println("Error"+ E);
        }

        this.patientNumberRegistrationColumn.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("patientNumber"));
        this.patientFirstNameRegistrationColumn.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("FirstName"));
        this.patientLastNameRegistrationColumn.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("LastName"));
        this.patientAgeColumn.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("Age"));
        this.patientIllnessColumn.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("Illness"));

        this.patientRegistrationTable.setItems(null);
        this.patientRegistrationTable.setItems(this.patientsData);
    }

    public void clearPatientData(javafx.event.ActionEvent event) {
        this.patientNumberID.setText("");
        this.patientFirstName.setText("");
        this.patientLastName.setText("");
        this.patientAge.setText("");
        this.patientIllness.setText("");
    }
}
