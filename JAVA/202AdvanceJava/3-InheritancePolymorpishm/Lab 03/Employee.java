package peopleprog;

import java.util.ArrayList;

/**
 * An employee has an office location (i.e. E&T-220), and a salary
 * Created by Chris on 4/22/2015.
 */
public class Employee extends Person{
    private float salary;
    private String office;
    public static int employees;
    public Employee(){
        this.salary = 29999;
        this.office = "E&T-220";
        employees = 0;
    }
    public Employee(float inSalary, String inOffice){
        this.salary = inSalary;
        this.office = inOffice;
    }
    public Employee(Address inAddress,ArrayList<PhoneNumber> pNum,
                    String inFirstName, String inLastName, String inEmailAdd,float inSalary, String inOffice){
        super(inAddress,pNum,inFirstName,inLastName,inEmailAdd);
        this.salary = inSalary;
        this.office = inOffice;
        employees+=1;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public static int getEmployees() {
        return employees;
    }

    @Override
    public String toString(){
        return super.toString() + "\nOffice Location:\t" + getOffice() +
                "\nSalary:\t\t\t    $" + getSalary();
    }
}//end class
