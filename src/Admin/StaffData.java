package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StaffData {

    private final StringProperty ID;
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty NationalID;
    private final StringProperty Residence;
    private final StringProperty DateOfBirth;

    public StaffData(String id, String firstname, String lastname, String nationalid, String residence, String dateOfBirth){

        this.ID = new SimpleStringProperty(id);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.NationalID = new SimpleStringProperty(nationalid);
        this.Residence = new SimpleStringProperty(residence);
        this.DateOfBirth = new SimpleStringProperty(dateOfBirth);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
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

    public String getNationalID() {
        return NationalID.get();
    }

    public StringProperty nationalIDProperty() {
        return NationalID;
    }

    public void setNationalID(String nationalID) {
        this.NationalID.set(nationalID);
    }

    public String getResidence() {
        return Residence.get();
    }

    public StringProperty residenceProperty() {
        return Residence;
    }

    public void setResidence(String residence) {
        this.Residence.set(residence);
    }

    public String getDateOfBirth() {
        return DateOfBirth.get();
    }

    public StringProperty dateOfBirthProperty() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.DateOfBirth.set(dateOfBirth);
    }


}
