package peopleprog;

import java.util.ArrayList;

/**
 * a student has a class standing (freshman, sophomore, junior, senior, or graduate)
 * Created by Chris on 4/22/2015.
 */
public class Student extends Person {
    private String classS;
    public static int students;

    public Student() {
        this.classS = "freshman";
        students = 0;
    }

    public Student(String classS) {
        this.classS = classS;
    }

    public Student(Address inAddress,ArrayList<PhoneNumber> pNum, String inFirstName, String inLastName, String inEmailAdd, String classS) {
        super(inAddress,pNum, inFirstName, inLastName, inEmailAdd);
        this.classS = classS;
        students+=1;
    }

    public String getClassS() {
        return classS;
    }

    public void setClassS(String classS) {
        this.classS = classS;
    }

    public static int getStudents() {
        return students;
    }

    @Override
    public String toString(){
        return super.toString() + "\nClass Standing:\t\t" + getClassS();
    }


}
