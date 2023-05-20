package company;

public class Doctor extends person{
    private String licenseNo;
    private String specialization;

    //from person class
    public Doctor(String name, String surname, String dateOfBirth, String mobileNo) {
        super(name, surname, dateOfBirth, mobileNo);
    }

    //constructors for other methods
    public Doctor(String name, String surname, String dateOfBirth, String mobileNo,String licenseNo,String specialization) {
        super(name, surname, dateOfBirth, mobileNo);

        this.licenseNo=licenseNo;
        this.specialization=specialization;

    }

    public Doctor(String licenseNo) {
        this.licenseNo=licenseNo;
    }


    //getters and setters

    public String getLicenseNo(){
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo){
        this.licenseNo=licenseNo;
    }

    public String getSpecialization(){
        return specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }



}
