package LoginApp;

public enum Option {

    Admin, Doctor;

    Option(){
    }

    public String value(){

        return name();
    }

    public static Option fromValue(String value){

        return valueOf(value);
    }
}
