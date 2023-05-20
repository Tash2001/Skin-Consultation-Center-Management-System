package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatient extends JFrame implements ActionListener {
    JTextField pName;
    JTextField pSurname;
    JTextField pDOB;
    JTextField pMobile;


    JButton cancel;

    JButton save;

    Patient patient=new Patient();

    public AddPatient(){

        JPanel panel=new JPanel();
        panel.setBounds(50,80,500,250);
        panel.setBackground(Color.white);
        Font font=new Font("Verdana",Font.PLAIN,12);

        JDialog dialog=new JDialog(this,"Add Patient",true);

        dialog.setBounds(650,300,600,475);
        dialog.setLayout(null);


        //insert heading
        JLabel heading=new JLabel("Add Patient");
        heading.setBounds(50,40,150,40);
        heading.setFont(new Font("Verdana",Font.BOLD,20));
        dialog.add(heading);



        //Patient ID
        JLabel LId = new JLabel(patient.getPatientID(), JLabel.CENTER);
        LId.setBounds(400, 25, 50, 30);
        LId.setBackground(Color.blue);
        LId.setForeground(Color.white);
        LId.setOpaque(true);
        dialog.add(LId);



        //Patient name

        JLabel fName=new JLabel("First Name  : ");
        fName.setBounds(100,100,170,30);
        fName.setFont(font);
        dialog.add(fName);

        pName=new JTextField("");
        pName.setBounds(220,100,250,30);
        dialog.add(pName);


        JLabel LName=new JLabel("Last Name  : ");
        LName.setBounds(100,150,170,30);
        LName.setFont(font);
        dialog.add(LName);

        pSurname=new JTextField("");
        pSurname.setBounds(220,150,250,30);
        dialog.add(pSurname);

        //DAte of birth

        JLabel dob = new JLabel("DOB (YYYY-MM-DD) :");
        dob.setBounds(100, 200, 170, 30);
        dob.setFont(font);
        dialog.add(dob);

        pDOB = new JTextField("");
        pDOB.setBounds(220, 200, 250, 30);
        dialog.add(pDOB);

        //Mobile No
        JLabel mobile = new JLabel("Mobile No : ");
        mobile.setBounds(100, 250, 170, 30);
        mobile.setFont(font);
        dialog.add(mobile);

        pMobile = new JTextField("");
        pMobile.setBounds(220, 250, 250, 30);
        dialog.add(pMobile);

        dialog.add(panel);

        //save

        save=new JButton("Save");
        save.setBounds(330,350,100,40);
        save.addActionListener(this);
        dialog.add(save);

        //cancel

        cancel=new JButton("Cancel");
        cancel.setBounds(440,350,100,40);
        cancel.addActionListener(this);
        dialog.add(cancel);

        dialog.setResizable(false);

        dialog.setVisible(true);






    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==save){

            patient.setName(pName.getText());
            patient.setSurname(pSurname.getText());
            patient.setDateOfBirth(pDOB.getText());
            patient.setMobileNo(pMobile.getText());

            Patient patient1=new Patient(pName.getText(),pSurname.getText(),pDOB.getText(),pMobile.getText(), patient.getPatientID());


            WestminsterSkinConsultationManager.patients.add(patient1);

        }

        if (e.getSource()==cancel){
            this.dispose();
        }

    }
}



//reference------>https://www.geeksforgeeks.org/java-swing-jdialog-examples/
