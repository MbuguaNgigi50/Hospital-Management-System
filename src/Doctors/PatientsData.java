package Doctors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientsData {

    private final StringProperty PatientNumber;
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty Age;
    private final StringProperty Illness;

    public PatientsData(String patientnumber, String firstname, String lastname, String age, String illness){

        this.PatientNumber = new SimpleStringProperty(patientnumber);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Age = new SimpleStringProperty(age);
        this.Illness = new SimpleStringProperty(illness);
    }

    public String getPatientNumber() {
        return PatientNumber.get();
    }

    public StringProperty patientNumberProperty() {
        return PatientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.PatientNumber.set(patientNumber);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getAge() {
        return Age.get();
    }

    public StringProperty ageProperty() {
        return Age;
    }

    public void setAge(String age) {
        this.Age.set(age);
    }

    public String getIllness() {
        return Illness.get();
    }

    public StringProperty illnessProperty() {
        return Illness;
    }

    public void setIllness(String illness) {
        this.Illness.set(illness);
    }

}
