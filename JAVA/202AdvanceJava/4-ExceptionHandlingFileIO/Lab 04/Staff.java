package src.peopleprog;

import java.util.ArrayList;

/**
 * a staff has a job title (Head Librarian would be an example of a job title at a university library)
 * Created by Chris on 4/22/2015.
 */
public class Staff  extends Employee{
    private String titleStand;


    public Staff() {
        this.titleStand = "Magician";

    }

    public Staff(float inSalary, String inOffice, String titleStand) {
        super(inSalary, inOffice);
        this.titleStand = titleStand;
    }

    public Staff(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName,
                 String inEmailAdd, double inSalary, String inOffice, String titleStand) {
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd, inSalary, inOffice);
        this.titleStand = titleStand;
        super.setStaffCount();
        super.setObType("Staff");

    }
    //construct for cvs style
     public Staff(String inFirstName, String inLastName,Address inAddress,
                  String inEmailAdd,ArrayList<PhoneNumber>pNum,double inSalary,String inOffice,String titleStand) {
            super(inFirstName,inLastName,inAddress, inEmailAdd,pNum,inSalary,inOffice);
            this.titleStand = titleStand;
            super.setStaffCount();
            super.setObType("Staff");

        }
  //construct for cvs style
     public Staff(String[] intokens) {
            super(intokens);
            this.titleStand = intokens[12];
            super.setStaffCount();
            super.setObType("Staff");

        }

    public String getTitleStand() {
        return titleStand;
    }

    public void setTitleStand(String titleStand) {
        this.titleStand = titleStand;
    }

    @Override
    public String toString(){
        return super.toString() + "\nJob Title:\t\t\t" + getTitleStand();
    }
}
