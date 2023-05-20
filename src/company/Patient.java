package company;


import java.util.Random;

public class Patient extends person{

    String patientID;

    public Patient(String name, String surname, String dateOfBirth, String mobileNo,String patientID) {
        super(name, surname, dateOfBirth, mobileNo);
        this.patientID=patientID;
    }

    public Patient() {
        super();
        Random rand = new Random();
        int randomNum = rand.nextInt((9999 - 1000)) + 10;

        this.patientID = "P" + randomNum;
    }




    public String getPatientID(){
        return patientID;
    }

    public void setPatientID(String patientID){
        this.patientID=patientID;

    }
}

