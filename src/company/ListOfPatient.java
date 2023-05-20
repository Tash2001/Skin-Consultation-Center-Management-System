package company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


import static company.WestminsterSkinConsultationManager.patients;

public class ListOfPatient {

    ListOfPatient(){
        JTable table=new JTable();
        DefaultTableModel tableModel=new DefaultTableModel();


        tableModel.setColumnIdentifiers(new Object[]{
                "Patient Id","Name","Date of birth","Mobile"
        });
        table.setModel(tableModel);
        table.setBounds(100,200,450,400);
        table.setAutoCreateColumnsFromModel(true);






        for(Patient patient:patients){
            tableModel.insertRow(0,new Object[]{
                    patient.getPatientID(),patient.getName()+" "+patient.getSurname(),patient.getDateOfBirth(),patient.getMobileNo()
            });
        }
        Dimension dimension=new Dimension(20,2);
        table.setIntercellSpacing(new Dimension(dimension));


        JFrame frame=new JFrame();
        table.getTableHeader().setBackground(Color.darkGray);
        table.getTableHeader().setForeground(Color.white);


        table.setAutoCreateRowSorter(true);
        frame.add(new JScrollPane(table));
        frame.setSize(1200,800);

        frame.setVisible(true);

    }
}
