package peopleprog;

import java.util.ArrayList;

/**
 * a faculty has office hours, and a rank (full time or part time are the only valid ranks)
 * Created by Chris on 4/22/2015.
 */
public class Faculty extends Employee {
    private String oHours;
    private String rank;
    public static int faculty;

    public Faculty() {
        this.rank = "full time";
        this.oHours = "7am - 8pm";
        faculty = 0;
    }

    public Faculty(String oHours, String rank) {
        this.oHours = oHours;
        this.rank = rank;
    }

    public Faculty(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName,
                   String inEmailAdd, float inSalary, String inOffice, String oHours, String rank){
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd, inSalary, inOffice);
        this.oHours = oHours;
        if(rank.equalsIgnoreCase("full time")){
            this.rank = rank;
        }
        else {
            this.rank = "part time";
        }
        faculty+=1;
    }

    public String getoHours() {
        return oHours;
    }

    public void setoHours(String oHours) {
        this.oHours = oHours;
    }

    public String isRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public static int getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return super.toString() + "\nOffice Hours:\t\t" + getoHours() +
                "\nRank:\t\t\t    " + isRank();
    }
}
