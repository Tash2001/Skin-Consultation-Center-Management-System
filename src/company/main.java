package company;

import java.io.IOException;

public class main {
    public static void main(String[] args){
        WestminsterSkinConsultationManager wSkinCM=new WestminsterSkinConsultationManager();

        wSkinCM.readData();
        wSkinCM.menuList();
        new GUI();



    }

}
