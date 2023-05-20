package company;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager , Serializable {

    static GUI gui =new GUI();
    static ArrayList<Doctor>newDoctors=new ArrayList<Doctor>(10);//to add all doctor's data

    static ArrayList<Patient>patients=new ArrayList<>();

    static ArrayList<Consultation>consultations=new ArrayList<>();
    Scanner input = new Scanner(System.in);
    static int maxNoOFDoctors=10;
    public File Detail=new File("DocFile.txt");


    public static void menu() {
        System.out.println("---------------------------------");
        System.out.println("\t\tMenu");
        System.out.println("---------------------------------");
        System.out.println("Press 1 : Add a new Doctor");
        System.out.println("Press 2 : Delete a Doctor");
        System.out.println("press 3 : Print the list of the Doctors");
        System.out.println("Press 4 : Save in a file");
        System.out.println("Press 5 : Open Graphical User Interface");
        System.out.println("Press 9 : Exit");
        System.out.println("---------------------------------");
    }



    public void menuList(){
        menu();
        String choice;
        System.out.print("Your choice:");
        choice=input.next();

        while (true){
            if(choice.equals("1")){
                doctorInput();
                menuList();
            }else if (choice.equals("2")){
                deleteInput();
                menuList();
            }else if (choice.equals("3")){
                printList();
                menuList();
            }else if (choice.equals("4")){
                saveDetails();
                menuList();
            }else if(choice.equals("5")){
                gui.main_window();
                menuList();
            }else if (choice.equals("9")){
                System.out.println("end");
                System.exit(-1);

            }else {
                System.out.println("***Wrong Input***\nTry Again.");
                menuList();
            }
        }


    }

    private void doctorInput(){

        String firstName;
        System.out.print("Enter Doctor's first name : ");
        firstName=input.next();

        String lastName;
        System.out.print("Enter Doctor's surname : ");
        lastName= input.next();

        String birthDate;
        System.out.print("Enter doctor's date of birth : ");
        birthDate=input.next();

        String mobile;
        System.out.print("Enter doctor's Mobile number : ");
        mobile=input.next();

        String license;
        System.out.print("Enter doctor's license number : ");
        try{
            license=input.next();
        }catch(Exception e){
            System.out.println("Invalid input");
            System.out.print("Enter doctor's license number : ");
            license=input.next();
        }

        String specialization;
        System.out.print("Enter medical specialization of doctor : ");
        specialization=input.next();

        Doctor d1=new Doctor(firstName,lastName,birthDate,mobile,license,specialization);
        addDoctor(d1);




    }

    @Override
    public void addDoctor(Doctor doc) {
        while (true){

            if(newDoctors.size()==maxNoOFDoctors){
                System.out.println("you exceeded the maximum number of doctors");
            }
            else {
                newDoctors.add(doc);
            }
            break;


        }

    }

    private void deleteInput(){
        String dltLicense;
        System.out.print("Enter medical license number : ");
        dltLicense=input.next();

        while (true){
            String sameNum="none";
            for (Doctor doc: newDoctors) {
                if (doc.getLicenseNo().equals(dltLicense)) {
                    sameNum = dltLicense;
                    break;

                }
            }

            if(sameNum.equals("none")){
                System.out.println("There is no medical license number similar to this...");
                System.out.print("Reenter medical license number : ");
                dltLicense=input.next();
            }else {
                dltDoctor(sameNum);
                break;
            }



        }

    }



    @Override
    public void dltDoctor(String licenseNum) {
        for (int i=0;i<newDoctors.size();i++){
            if (newDoctors.get(i).getLicenseNo().equals(licenseNum)) {

                newDoctors.remove(i);
                System.out.println("Deleted");
                break;

            }
        }

    }

    @Override
    public void printList() {



        System.out.println("----------List of Doctors------------");
        Collections.sort(newDoctors,new Compare());
        int count=1;
       for (Doctor doc:newDoctors){
           System.out.println((count++)+") Name-\t"+doc.getName()+" "+doc.getSurname());
           System.out.println("\tLicense number-\t"+doc.getLicenseNo());
           System.out.println("\tSpecialization-\t"+doc.getSpecialization());
           System.out.println("\tDate Of Birth-\t"+doc.getDateOfBirth());
           System.out.println("\tMobile Number-\t"+doc.getMobileNo());
        }

    }


    @Override
    public void saveDetails() {

        try {
            FileWriter savedata = new FileWriter("SavedData.txt"); //Create a New Object Type File Writer
            for (int i = 0; i < newDoctors.size(); i++) {
                savedata.write((newDoctors.get(i)) + "\n");
                break;
            }
            savedata.close();
            System.out.println("The File was Successfully Written to..");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }







    public void readData()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(Detail))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String name = parts[0];
                String surname = parts[1];
                String dateOfBirth = parts[2];
                String mobileNo = parts[3];
                String LicenceNo = parts[4];
                String specialization = parts[5];

                Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNo,LicenceNo, specialization);
                newDoctors.add(doctor);
          }
        } catch (IOException|ArrayIndexOutOfBoundsException e) {
            // File not found or error reading file, ignore and start with empty list of doctors
        }
    }







}

