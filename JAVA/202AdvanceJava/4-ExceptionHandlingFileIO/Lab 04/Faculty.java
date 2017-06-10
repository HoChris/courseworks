package src.peopleprog;

import java.util.ArrayList;

/**
 * a faculty has office hours, and a rank (full time or part time are the only valid ranks)
 * Created by Chris on 4/22/2015.
 */
public class Faculty extends Employee {
    private String oHours;
    private String rank;


    public Faculty() {
        this.rank = "full time";
        this.oHours = "7am - 8pm";

    }

    public Faculty(String oHours, String rank) {
        this.oHours = oHours;
        this.rank = rank;
    }

    public Faculty(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName,
                   String inEmailAdd, double inSalary, String inOffice, String oHours, String rank){
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd, inSalary, inOffice);
        super.setObType("Faculty");
        this.oHours = oHours;
        if(rank.equalsIgnoreCase("full time")){
            this.rank = rank;
        }
        else {
            this.rank = "part time";
        }
        super.setFacCount();
    }
    //constructor for cvs style
    public Faculty(String[] intokens){
        super(intokens);
        super.setObType("Faculty");
        this.oHours = intokens[12];
        this.rank = intokens[13];
        if(rank.equalsIgnoreCase("full time")){
            this.rank = intokens[13];
        }
        else {
            this.rank = "part time";
        }
        super.setFacCount();
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


    @Override
    public String toString() {
        return super.toString() + "\nOffice Hours:\t\t" + getoHours() +
                "\nRank:\t\t\t    " + isRank();
    }
}
