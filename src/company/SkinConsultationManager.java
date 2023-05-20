package company;

public interface SkinConsultationManager {
    void addDoctor(Doctor doc);
    void dltDoctor(String licenseNum);
    void printList();
    void saveDetails();

    void readData();
}
