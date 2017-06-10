package peopleprog;

import java.util.ArrayList;

/**
 * a staff has a job title (Head Librarian would be an example of a job title at a university library)
 * Created by Chris on 4/22/2015.
 */
public class Staff  extends Employee{
    private String titleStand;
    public static int staff;

    public Staff() {
        this.titleStand = "Magician";
        staff=0;
    }

    public Staff(float inSalary, String inOffice, String titleStand) {
        super(inSalary, inOffice);
        this.titleStand = titleStand;
    }

    public Staff(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName,
                 String inEmailAdd, float inSalary, String inOffice, String titleStand) {
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd, inSalary, inOffice);
        this.titleStand = titleStand;
        staff +=1;
    }

    public String getTitleStand() {
        return titleStand;
    }

    public void setTitleStand(String titleStand) {
        this.titleStand = titleStand;
    }

    public static int getStaff() {
        return staff;
    }

    public static void setStaff(int staff) {
        Staff.staff = staff;
    }

    @Override
    public String toString(){
        return super.toString() + "\nJob Title:\t\t\t" + getTitleStand();
    }
}
