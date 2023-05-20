package company;



public class Consultation extends Doctor{

    private String date;
    private String startTime;
    private String endTime;
    private double cost;
    private String note;

    public Consultation(String name, String surname, String dateOfBirth, String mobileNo, String licenseNo,String specialization,String date,String startTime,String endTime,double cost,String note) {
        super(name, surname, dateOfBirth, mobileNo,licenseNo ,specialization);
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
        this.cost=cost;
        this.note=note;


    }

    public Consultation(String licenseNo, String date) {
        super(licenseNo);
        this.date=date;
    }


    public void setDate(String date){
        this.date=date;
    }
    public void setStartTime(String startTime){
        this.startTime=startTime;
    }
    public void setEndTime(String endTime){
        this.endTime=endTime;
    }
    public void setCost(double cost){
        this.cost=cost;
    }
    public void setNote(String note){
        this.note=note;
    }
    public String getDate(){
        return this.date;
    }
    public String getStartTime(){
        return this.startTime;
    }
    public String getEndTime(){
        return this.endTime;
    }
    public double getCost(){
        return this.cost;

    }
    public String getNote(){
        return this.note;
    }
}
