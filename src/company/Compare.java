package company;

import java.util.Comparator;

public class Compare implements Comparator<Doctor> {




    @Override
    public int compare(Doctor o1, Doctor o2) {
        String name1=o1.getSurname().toUpperCase();
        String name2=o2.getSurname().toUpperCase();
        return name1.compareTo(name2);
    }
}

//references----->https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/