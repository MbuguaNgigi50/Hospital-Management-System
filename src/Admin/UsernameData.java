package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsernameData {

    private final StringProperty Username;
    private final StringProperty Password;
    private final StringProperty Division;

    public UsernameData(String username, String password, String division){

        this.Username = new SimpleStringProperty(username);
        this.Password = new SimpleStringProperty(password);
        this.Division = new SimpleStringProperty(division);
    }

    public String getUsername() {
        return Username.get();
    }

    public StringProperty usernameProperty() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username.set(username);
    }

    public String getPassword() {
        return Password.get();
    }

    public StringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }

    public String getDivision() {
        return Division.get();
    }

    public StringProperty divisionProperty() {
        return Division;
    }

    public void setDivision(String division) {
        this.Division.set(division);
    }

}
