package company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame {





    WestminsterSkinConsultationManager wscm=new WestminsterSkinConsultationManager();



    public void main_window(){



        JFrame frame=new JFrame();
        JLabel label=new JLabel();


        JPanel panelTop=new JPanel();
        panelTop.setPreferredSize(new Dimension(1200,150));
        panelTop.setBackground(Color.GRAY);
        panelTop.setLayout(null);

        JPanel panelCenter=new JPanel();
        panelCenter.setPreferredSize(new Dimension(1200,450));
        panelCenter.setBackground(Color.darkGray);
        panelCenter.setLayout(null);



        JLabel heading=new JLabel("Skin consultation menu");

        heading.setForeground(Color.black);
        heading.setFont(heading.getFont().deriveFont(30f));

        Font font =new Font(Font.DIALOG_INPUT,Font.BOLD,15);
        Border line=BorderFactory.createLineBorder(Color.white);
        heading.setBounds(450,25,750,75);


        JButton bAddConsultation=new JButton("Add Consultation");
        bAddConsultation.setBounds(490,60,220,60);

        bAddConsultation.setFont(font);
        bAddConsultation.setBorder(line);

        JButton bAddPatient=new JButton("Add Patient");
        bAddPatient.setBounds(190,60,220,60);
        bAddPatient.setFont(font);
        bAddPatient.setBorder(line);


        JButton bListOfDoctors=new JButton("List Of Doctors");
        bListOfDoctors.setBounds(490,160,220,60);
        bListOfDoctors.setFont(font);
        bListOfDoctors.setBorder(line);

        JButton bListOfPatient=new JButton("List of Patients");
        bListOfPatient.setBounds(190,160,220,60);
        bAddPatient.setFont(font);
        bAddPatient.setBorder(line);



        JButton bCancelConsultation=new JButton("Cancel Consultation");
        bCancelConsultation.setBounds(490,260,220,60);
        bCancelConsultation.setFont(font);
        bCancelConsultation.setBorder(line);

        JButton bExit=new JButton("Exit");
        bExit.setBounds(490,360,220,60);

        bExit.setFont(font);
        bExit.setBorder(line);


        panelTop.add(heading);
        panelCenter.add(bAddConsultation);
        panelCenter.add(bListOfDoctors);
        panelCenter.add(bCancelConsultation);
        panelCenter.add(bExit);
        panelCenter.add(bAddPatient);
        panelCenter.add(bListOfPatient);




        frame.setTitle("Skin Consultation Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1200,675);
        frame.add(panelTop,BorderLayout.NORTH);
        frame.add(panelCenter,BorderLayout.EAST);
        ImageIcon icon =new ImageIcon("logo.jpg");
        frame.setIconImage(icon.getImage());


        frame.setVisible(true);


//show table of doctors
        bListOfDoctors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListOfGUI();
                frame.setVisible(false);

            }

        });

        bAddPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatient();
                frame.setVisible(false);
            }
        });

        bListOfPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListOfPatient();
                frame.setVisible(false);

            }
        });


        bCancelConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bAddConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddConsultation();
                frame.setVisible(false);
            }
        });


    }

}
