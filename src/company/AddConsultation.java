package company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddConsultation extends JFrame implements ActionListener {
    JComboBox<String> cmbDoctor;
    JComboBox<String> cmbPName;
    JComboBox<String> cmbDatetime;
    JButton save;
    JButton btnUpload;
    JButton btnSearch;
    JButton reset;
    JButton cancel;
    JTextArea txtNote;

    JTextField txtDate;
    String selectDocId;
    static JTable table;
    JLabel lImagePath;
    private String imagePath;
    private String imageDestination;


    AddConsultation(){

        JFrame frame=new JFrame("Add a Consultation");

        Font font=new Font("Verdana",Font.PLAIN,15);

        JPanel panel =new JPanel();
        panel.setPreferredSize(new Dimension(600,600));
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);

        JPanel panel2=new JPanel();
        panel2.setPreferredSize(new Dimension(600,600));
        panel2.setBackground(Color.GRAY);
        panel2.setLayout(null);

        //heading
        JLabel heading=new JLabel("Search Doctor Availability");
        heading.setFont(new Font("Verdana",Font.BOLD,18));
        heading.setBounds(40,40,400,30);
        heading.setForeground(Color.black);

        //Select Doctor
        JLabel lDoctor=new JLabel("Doctors");
        lDoctor.setBounds(40,90,100,30);
        lDoctor.setFont(font);
        lDoctor.setForeground(Color.BLACK);

        cmbDoctor=new JComboBox<String>();
        cmbDoctor.setBounds(40,120,150,30);
        cmbDoctor.addActionListener(this);


        // add date

        JLabel lDate=new JLabel("Date(YYYY-MM-DD) :");
        lDate.setBounds(200,90,300,30);
        lDate.setFont(font);
        lDate.setForeground(Color.black);

        txtDate=new JTextField("");
        txtDate.setBounds(200,120,200,30);


        //search
        btnSearch= new JButton("Search");
        btnSearch.setBounds(490,150,100,30);
        btnSearch.addActionListener(this);



        //select patient
        JLabel lFName=new JLabel("Patient Id/ Name : ");
        lFName.setBounds(100,100,150,30);
        lFName.setFont(font);

        cmbPName=new JComboBox<String>();
        cmbPName.setBounds(300,100,200,30);

        JLabel datetime = new JLabel("Date/Time : ");
        datetime.setBounds(100, 160, 150, 30);
        datetime.setFont(font);

        cmbDatetime = new JComboBox<String>();
        cmbDatetime.setBounds(300, 160, 200, 30);

        JLabel lNote=new JLabel("Note");
        lNote.setBounds(100,250,200,30);
        lNote.setFont(font);

        txtNote =new JTextArea();
        txtNote.setBounds(100,300,350,100);
        txtNote.setLineWrap(true);

        //upload image

        JLabel image = new JLabel("Upload an Image");
        image.setBounds(100, 450, 200, 30);
        image.setFont(font);

        btnUpload = new JButton("Upload");
        btnUpload.setBounds(200, 500, 100, 30);
        btnUpload.addActionListener(this);

        JLabel imagepath = new JLabel("");
        imagepath.setBounds(480, 500, 50, 30);
        imagepath.setFont(font);

        //save

        save = new JButton("Save");
        save.setBounds(325, 500, 100, 30);
        save.addActionListener(this);

        //reset

        reset = new JButton("Reset");
        reset.setBounds(460, 500, 100, 30);
        reset.addActionListener(this);

        //cancel

        cancel = new JButton("Exit");
        cancel.setBounds(460, 550, 100, 30);
        cancel.addActionListener(this);






        panel.add(heading);
        panel.add(cmbDoctor);
        panel.add(lDoctor);
        panel.add(lDate);
        panel.add(txtDate);
        panel.add(btnSearch);
        panel.add(table);

        panel2.add(lFName);
        panel2.add(cmbPName);
        panel2.add(datetime);
        panel2.add(cmbDatetime);
        panel2.add(lNote);
        panel2.add(txtNote);
        panel2.add(save);
        panel2.add(reset);
        panel2.add(cancel);
        panel2.add(image);
        panel2.add(btnUpload);
        panel2.add(imagepath);

        data();


        frame.setTitle("Add Consultation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1200,675);
        frame.add(panel,BorderLayout.WEST);
        frame.add(panel2,BorderLayout.EAST);


        frame.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()==cmbDoctor)){
            String doctorName=cmbDoctor.getSelectedItem().toString();
            Availability(doctorName);
        }

        if (e.getSource()==save){
            SaveConsultation();
        }

        if (e.getSource()==btnSearch){
            Availability(cmbDoctor.getSelectedItem().toString());

            Search();
        }

//        if (e.getSource()==btnUpload){
//            UploadImage();
//        }

        if (e.getSource()==reset){
            cmbPName.setSelectedIndex(-1);
            cmbDatetime.setSelectedIndex(-1);
            cmbDoctor.setSelectedIndex(-1);
            txtDate.setText("");
            txtNote.setText("");
            Availability(cmbDoctor.getSelectedItem().toString());
        }
        if (e.getSource()==cancel){
            this.dispose();
        }

    }

    private void UploadImage() {
   /*     JFileChooser fileChooser=new JFileChooser();
        int result=fileChooser.showOpenDialog(null);

        if (result !=JFileChooser.APPROVE_OPTION){
            return;
        }

        imagePath=fileChooser.getSelectedFile().getAbsolutePath();
        imageDestination="./images/"+fileChooser.getSelectedFile().getName();
        lImagePath.setText(imagePath);*/
    }

    private  void data(){

        cmbDoctor.addItem("");
        for (Doctor doc: WestminsterSkinConsultationManager.newDoctors){
            String name=doc.getName()+" "+doc.getSurname();
            cmbDoctor.addItem(name);
        }

        cmbPName.addItem("");
        for (Patient patient:WestminsterSkinConsultationManager.patients){
            String name=patient.getName()+" "+patient.getSurname();
            cmbPName.addItem(name);
        }



    }

    void Availability(String docName) {

        selectDocId = "none";

        for (Doctor doctor : WestminsterSkinConsultationManager.newDoctors) {
            if ((doctor.getName() + "" + doctor.getSurname()).equals(docName)) {
                selectDocId = doctor.getLicenseNo();

            }


        }


    }

    void Search(){

        Consultation consult=new Consultation(selectDocId,txtDate.getText());

        if (consult.getLicenseNo().equals(selectDocId) & (consult.getDate().isEmpty())) {
            table=new JTable();
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                    "Medical license Number","Date","Availability"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);

            model.insertRow(0,new Object[]{

                    selectDocId,txtDate.getText(),"Is Available"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);



        }

        if (consult.getLicenseNo().equals(selectDocId)&consult.getDate().equals(txtDate.getText())) {


            table=new JTable();
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                    "Medical license Number","Date","Availability"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);

            model.insertRow(0,new Object[]{

                    selectDocId,txtDate.getText(),"Not Available"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);


        }
        if (consult.getLicenseNo().equals(selectDocId)&(!consult.getDate().equals(txtDate.getText()))){
            table=new JTable();
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                    "License number","Date","Availability"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);

            model.insertRow(0,new Object[]{

                    selectDocId,txtDate.getText(),txtDate.getText()+"is not Available"
            });
            table.setBounds(50,200,500,250);
            table.setModel(model);


        }

    }








    void  SaveConsultation(){
        String Date="";
        String time="";


    }



}


