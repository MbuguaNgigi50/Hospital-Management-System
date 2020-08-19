package Admin;


import Database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    @FXML
    private javafx.scene.control.TextField doctorID;
    @FXML
    private javafx.scene.control.TextField doctorFirstName;
    @FXML
    private javafx.scene.control.TextField doctorLastName;
    @FXML
    private javafx.scene.control.TextField doctorNID;
    @FXML
    private javafx.scene.control.TextField doctorResidence;
    @FXML
    private DatePicker doctorDOB;
    @FXML
    private TableView<DoctorsData> doctorRegistrationTable;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationIDColumn;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationFirstNameColumn;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationLastNameColumn;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationNIDColumn;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationResidenceColumn;
    @FXML
    private TableColumn<DoctorsData, String> doctorRegistrationDateOfBirthColumn;

    //Tags For Staff Registration Page
    @FXML
    private javafx.scene.control.TextField staffID;
    @FXML
    private javafx.scene.control.TextField staffFirstName;
    @FXML
    private javafx.scene.control.TextField staffLastName;
    @FXML
    private javafx.scene.control.TextField staffNID;
    @FXML
    private javafx.scene.control.TextField staffResidence;
    @FXML
    private DatePicker staffDOB;
    @FXML
    private TableView<StaffData> staffRegistrationTable;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationIDColumn;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationFirstNameColumn;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationLastNameColumn;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationNIDColumn;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationResidenceColumn;
    @FXML
    private TableColumn<StaffData, String> staffRegistrationDateOfBirthColumn;

    //Tags For The Username Registration Page
    @FXML
    private javafx.scene.control.TextField usernameUsername;
    @FXML
    private javafx.scene.control.TextField usernamePassword;
    @FXML
    private javafx.scene.control.TextField usernameDivision;
    @FXML
    private TableView<UsernameData> usernameRegistrationTable;
    @FXML
    private TableColumn<UsernameData, String> usernameRegistrationColumn;
    @FXML
    private TableColumn<UsernameData, String> passwordRegistrationColumn;
    @FXML
    private TableColumn<UsernameData, String> divisionRegistrationColumn;


    private DatabaseConnection dc;
    private ObservableList<DoctorsData> doctorsData;
    private ObservableList<StaffData> staffData;
    private ObservableList<UsernameData> usernameData;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new DatabaseConnection();
    }

    //THIS IS TO LOAD THE DOCTOR REGISTRATION FXML FILE
    public void loadDoctorRegistration(javafx.event.ActionEvent event) {
        try{
            Stage doctorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Admin/DoctorRegistration.fxml").openStream());

            AdminController adminController = (AdminController)loader.getController();

            Scene scene2 = new Scene(root);
            doctorStage.setScene(scene2);
            doctorStage.setTitle("Doctor Registration Dashboard");
            doctorStage.setResizable(false);
            doctorStage.show();
        }
        catch (IOException exes){
            exes.printStackTrace();
        }
    }

    //THIS IS TO LOAD THE USERNAME REGISTRATION FXML FILE
    public void loadUsernameRegistration(javafx.event.ActionEvent event) {
        try{
            Stage doctorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Admin/UsernameRegistration.fxml").openStream());

            AdminController adminController = (AdminController)loader.getController();

            Scene scene2 = new Scene(root);
            doctorStage.setScene(scene2);
            doctorStage.setTitle("Username Registration Dashboard");
            doctorStage.setResizable(false);
            doctorStage.show();
        }
        catch (IOException exes){
            exes.printStackTrace();
        }
    }

    //THIS IS TO LOAD THE STAFF REGISTRATION FXML FILE
    public void loadStaffRegistration(javafx.event.ActionEvent event) {
        try{
            Stage doctorStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Admin/StaffRegistration2.fxml").openStream());

            AdminController adminController = (AdminController)loader.getController();

            Scene scene2 = new Scene(root);
            doctorStage.setScene(scene2);
            doctorStage.setTitle("Staff Registration Dashboard");
            doctorStage.setResizable(false);
            doctorStage.show();
        }
        catch (IOException exes){
            exes.printStackTrace();
        }
    }

    public void addDoctorData(javafx.event.ActionEvent event) {
        String sqlInsertDoctor = "INSERT INTO Doctors(ID,FirstName,LastName,NationalID,Residence,DateOfBirth) VALUES (?,?,?,?,?,?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sqlInsertDoctor);

            statement.setString(1, this.doctorID.getText());
            statement.setString(2, this.doctorFirstName.getText());
            statement.setString(3, this.doctorLastName.getText());
            statement.setString(4, this.doctorNID.getText());
            statement.setString(5, this.doctorResidence.getText());
            statement.setString(6, this.doctorDOB.getEditor().getText());

            statement.execute();
            conn.close();

        } catch (SQLException E) {
            E.printStackTrace();
        }

    }

    public void clearDoctorData(javafx.event.ActionEvent event) {
        this.doctorID.setText("");
        this.doctorFirstName.setText("");
        this.doctorLastName.setText("");
        this.doctorNID.setText("");
        this.doctorResidence.setText("");
        this.doctorDOB.setValue(null);
    }

    public void loadDoctorsData(javafx.event.ActionEvent event) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.doctorsData = FXCollections.observableArrayList();

            String sql1 = "SELECT * FROM Doctors";
            ResultSet rs2 = conn.createStatement().executeQuery(sql1);
            while (rs2.next()) {
                this.doctorsData.add(new DoctorsData(rs2.getString(1),
                        rs2.getString(2),
                        rs2.getString(3),
                        rs2.getString(4),
                        rs2.getString(5),
                        rs2.getString(6)));
            }
        } catch (SQLException E) {
            System.err.println("Error" + E);
        }

        this.doctorRegistrationIDColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("ID"));
        this.doctorRegistrationFirstNameColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("FirstName"));
        this.doctorRegistrationLastNameColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("LastName"));
        this.doctorRegistrationNIDColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("NationalID"));
        this.doctorRegistrationResidenceColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("Residence"));
        this.doctorRegistrationDateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<DoctorsData, String>("DateOfBirth"));

        this.doctorRegistrationTable.setItems(null);
        this.doctorRegistrationTable.setItems(this.doctorsData);
    }

    public void addStaffData(javafx.event.ActionEvent event) {
        String sqlInsert = "INSERT INTO Staff(ID,FirstName,LastName,NationalID,Residence,DateOfBirth) VALUES (?,?,?,?,?,?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.staffID.getText());
            stmt.setString(2, this.staffFirstName.getText());
            stmt.setString(3, this.staffLastName.getText());
            stmt.setString(4, this.staffNID.getText());
            stmt.setString(5, this.staffResidence.getText());
            stmt.setString(6, this.staffDOB.getEditor().getText());

            stmt.execute();
            conn.close();

        } catch (SQLException E) {
            E.printStackTrace();
        }
    }

    public void clearStaffData(javafx.event.ActionEvent event) {
        this.staffID.setText("");
        this.staffFirstName.setText("");
        this.staffLastName.setText("");
        this.staffNID.setText("");
        this.staffResidence.setText("");
        this.staffDOB.setValue(null);
    }

    public void loadStaffData(javafx.event.ActionEvent event) {
        try {

            Connection conn = DatabaseConnection.getConnection();
            this.staffData = FXCollections.observableArrayList();

            String sql2 = "SELECT * FROM Staff";
            ResultSet rs = conn.createStatement().executeQuery(sql2);
            while (rs.next()) {
                this.staffData.add(new StaffData(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException E) {
            System.err.println("Error" + E);
        }

        this.staffRegistrationIDColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("ID"));
        this.staffRegistrationFirstNameColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("FirstName"));
        this.staffRegistrationLastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("LastName"));
        this.staffRegistrationNIDColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("NationalID"));
        this.staffRegistrationResidenceColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("Residence"));
        this.staffRegistrationDateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<StaffData, String>("DateOfBirth"));

        this.staffRegistrationTable.setItems(null);
        this.staffRegistrationTable.setItems(this.staffData);
    }

    public void addUsernameData(ActionEvent event) {
        String sqlInsertIntoUsername = "INSERT INTO Login(Username, Password, Division) VALUES (?,?,?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement1 = conn.prepareStatement(sqlInsertIntoUsername);

            statement1.setString(1,usernameUsername.getText());
            statement1.setString(2,usernamePassword.getText());
            statement1.setString(3,usernameDivision.getText());

            statement1.execute();
            conn.close();

        } catch (SQLException E) {
            E.printStackTrace();
        }
    }

    public void loadUsernameData(ActionEvent event) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.usernameData = FXCollections.observableArrayList();

            String sql3 = "SELECT * FROM Login";
            ResultSet rs3 = conn.createStatement().executeQuery(sql3);
            while (rs3.next()) {
                this.usernameData.add(new UsernameData(rs3.getString(1),
                        rs3.getString(2),
                        rs3.getString(3)));
            }
        } catch (SQLException E) {
            System.err.println("Error" + E);
        }
        this.usernameRegistrationColumn.setCellValueFactory(new PropertyValueFactory<UsernameData, String>("Username"));
        this.passwordRegistrationColumn.setCellValueFactory(new PropertyValueFactory<UsernameData, String>("Password"));
        this.divisionRegistrationColumn.setCellValueFactory(new PropertyValueFactory<UsernameData, String>("Division"));

        this.usernameRegistrationTable.setItems(null);
        this.usernameRegistrationTable.setItems(this.usernameData);
    }

    public void clearUsernameData(ActionEvent event) {
        this.usernameUsername.setText("");
        this.usernamePassword.setText("");
        this.usernameDivision.setText("");
    }
}

