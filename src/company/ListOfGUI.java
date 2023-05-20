package company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


import static company.WestminsterSkinConsultationManager.newDoctors;

public class ListOfGUI {


    ListOfGUI(){
        JTable table=new JTable();
        DefaultTableModel tableModel=new DefaultTableModel();


        tableModel.setColumnIdentifiers(new Object[]{
                "Name","Medical License Number","Specialization","Date Of Birth","Mobile"
        });
        table.setModel(tableModel);
        table.setBounds(100,200,450,400);
        table.setAutoCreateColumnsFromModel(true);





        newDoctors.sort(new Compare());
        for(Doctor doc:newDoctors){
            tableModel.insertRow(0,new Object[]{
                    doc.getName()+" "+doc.getSurname(),doc.getLicenseNo(),doc.getSpecialization(),doc.getDateOfBirth(),doc.getMobileNo()
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

//references------>https://www.tutorialspoint.com/how-to-create-defaulttablemodel-which-is-an-implementation-of-tablemodel
