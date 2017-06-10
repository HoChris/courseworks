package src.peopleprog;

import java.util.ArrayList;

/**
 * An employee has an office location (i.e. E&T-220), and a salary
 * Created by Chris on 4/22/2015.
 */
public class Employee extends Person{
    private double salary;
    private String office;


    public Employee(){
        this.salary = 29999.00;
        this.office = "E&T-220";

    }
    public Employee(double inSalary, String inOffice){
        this.salary = inSalary;
        this.office = inOffice;
    }
    public Employee(Address inAddress,ArrayList<PhoneNumber> pNum,
                    String inFirstName, String inLastName,String inEmailAdd,double inSalary,String inOffice){
        super(inAddress,pNum,inFirstName,inLastName,inEmailAdd);
        this.salary = inSalary;
        super.setSalary(this.salary);
        super.setObType("Employee");
        //i got to move this over to person to call the functions in order to call them later in database
        this.office = inOffice;
        super.setEmpCount();

    }

    public Employee(String inFirstName,String inLastName,Address inAddress,
                    String inEmailAdd,ArrayList<PhoneNumber>pNum,double inSalary,String inOffice){
        super(inFirstName, inLastName, inAddress, inEmailAdd, pNum);
        this.salary = inSalary;
        super.setSalary(this.salary);
        super.setObType("Employee");
        //i got to move this over to person to call the functions in order to call them later in database
        this.office = inOffice;
        super.setEmpCount();

    }
    //construct for cvs style
    public Employee(String[] intokens){
        super(intokens);
        this.salary = Double.parseDouble(intokens[10]);
        super.setSalary(this.salary);
        super.setObType("Employee");
        //i got to move this over to person to call the functions in order to call them later in database
        this.office = intokens[11];
        super.setEmpCount();

    }

//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

//    public int getEmpCount() {
//        return empCount;
//    }
//    public void setEmpCount(){
//        this.empCount+=1;
//    }
    @Override
    public String toString(){
        return super.toString() + "\nOffice Location:\t" + getOffice() +
                "\nSalary:\t\t\t    $" + getSalary();
    }
}//end class
