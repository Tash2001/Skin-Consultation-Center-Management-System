package company;

public abstract class person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNo;

    // constructor
    public person(String name,String surname,String dateOfBirth,String mobileNo){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.mobileNo=mobileNo;
    }

    public person() {

    }
    //getter and setter for name

    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name=name;
    }
    //getter and setter for surname

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    //getter and setter for date of birth

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;

    }

    //getter and setter for mobile number
    public String getMobileNo(){
        return mobileNo;
    }

    public void setMobileNo(String mobileNo){
        this.mobileNo=mobileNo;
    }
}

